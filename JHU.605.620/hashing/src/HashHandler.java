import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Creates the Hash Table.
 *
 * Accepts an input data and its designated table size for the hash table.
 * Based on the specified hash function, a hash key is generated.
 * If a hash key is already populated in the hash table, the collision schema is called to generate a new key.
 * Stats are collected per iteration and displayed in the terminal.
 * Lastly, reset function is called to empty the cache for each variables.
 *
 * @author Alana Alfeche
 * @since 04 November 2019
 */
public class HashHandler {
    // hash table
    private List<String> inputData;
    private int tableSize;
    private int[] hashTable;
    private int[] finalHashTable;

    // statistics
    private int numberOfCollision;
    private int numberOfUnaddedEntries;

    // for chaining collision method
    private ArrayList<Integer> freeSpaceStack;

    /*
    Constructor
    Prepares the hash table with a default value of -1
    Prepares the free space stack for chaining collision with a default value of 1 - table size
     */
    public HashHandler(List<String> inputData, int tableSize){
        this.tableSize = tableSize;
        this.inputData = inputData;

        // initializing hash table
        this.hashTable = new int[tableSize];
        Arrays.fill(hashTable, -1);

        // for chaining collision method
        this.freeSpaceStack = new ArrayList<>();
        for (int i=0; i<tableSize; i++){
            freeSpaceStack.add(i);
        }
    }

    /**
     * Add following valuable statistic values to a list:
     * number of collision
     * number of not added entries
     * load factor
     *
     * @return a list containing statistics
     */
    List<Integer> getStatistics(){

        List<Integer> statistics = new ArrayList<>();

        statistics.add(numberOfCollision);
        statistics.add(numberOfUnaddedEntries);
        statistics.add((inputData.size()-numberOfUnaddedEntries) * 100 / inputData.size());

        return statistics;
    }

    /**
     * Creates a hash table
     *
     * @param hashFunctionMethod accepts division or multiplication method
     * @param modulo required divisor to generate key
     * @param bucketSize accepts one or multi-bucket, default is one
     * @param collisionScheme handles collision when the generated index already has a value in the hash table
     * @return hash table
     */
    int[] createHashTable(String hashFunctionMethod,
                          int modulo,
                          int bucketSize,
                          String collisionScheme) {

        // call reset function to remove cached data
        reset();

        // determine which hash method to use in creating the hash map
        if (hashFunctionMethod.equals("division")) {
            finalHashTable = getModularHash(inputData, modulo, bucketSize, collisionScheme);
        } else if (hashFunctionMethod.equals("multiplication")){
            finalHashTable = getMultiplicativeHash(inputData, modulo, bucketSize, collisionScheme);
        }

        return finalHashTable;
    }

    // CLRS 11.3.1 Division Method
    private int[] getModularHash(List<String> inputData, int modulo, int bucketSize, String collisionScheme) {
        for (String inputDatum : inputData) {
            int value = Integer.parseInt(inputDatum);

            // h(k) = k mod m
            int key = value % modulo;

            if (hashTable[key] != -1) {
                ++numberOfCollision; // if key enters this if statement, then there was a collision

                int newKey = handleCollision(key, value, modulo, collisionScheme);

                // we know that key has slotted entry
                // thus if the new calculated key is equal to the old key
                // then the the slot already contains an item so it cannot accept a new entry
                if (key == newKey) {
                    ++numberOfUnaddedEntries;
                }

                key = newKey;
            }

            hashTable[key] = value;
        }

        return hashTable;
    }

    // CLRS 11.3.2 Multiplication Method
    private int[] getMultiplicativeHash(List<String> inputData, int modulo, int bucketSize, String collisionScheme) {
        for (String inputDatum : inputData) {
            int value = Integer.parseInt(inputDatum);
            double a = 0.6180339887; // Recommended double value by Knuth -- golden ratio
            int m = 2; // let m be a power of 2, m = 2^p

            // h(k) = m(kA mod 1)
            int key = (int) Math.floor(m * ((value * a) % 1));

            if (hashTable[key] != -1) {
                ++numberOfCollision; // if key enters this if statement, then there was a collision

                int newKey = handleCollision(key, value, modulo, collisionScheme);

                // we know that key has slotted entry
                // thus if the new calculated key is equal to the old key
                // then the the slot already contains an item so it cannot accept a new entry
                if (key == newKey) {
                    ++numberOfUnaddedEntries;
                }

                key = newKey;
            }

            hashTable[key] = value;
        }

        return hashTable;
    }

    // CLRS 11.4 Collision Handling
    private int handleCollision(int key, int value, int modulo, String collisionScheme) {

        switch(collisionScheme) {
            case "linear":
                return ++key;   // return the next space

            case "quadratic":
                double c1 = 0.5;
                double c2 = 0.5;
                return (int) (value + (c1 * key) + (c2 * Math.pow(key, 2))) % modulo; // uses equation

            case "chaining":
                // returns the highest key in the stack
                int newKey = freeSpaceStack.get(freeSpaceStack.size()-1);

                // decrement free stack by 1 to remove redundancy
                while(hashTable[newKey] > 0) {
                    freeSpaceStack.remove(newKey);
                    newKey = freeSpaceStack.get(freeSpaceStack.size() - 1);
                }

                return newKey;
        }

        return key;
    }

    // Need to reset objects because data is getting cached
    private void reset(){
        // clear hash table
        Arrays.fill(hashTable, -1);

        // clear free space stack
        freeSpaceStack.clear();
        for (int i = 0; i < tableSize;i++){
            freeSpaceStack.add(i);
        }

        // clear statistics
        numberOfCollision = 0;
        numberOfUnaddedEntries = 0;
    }

}
