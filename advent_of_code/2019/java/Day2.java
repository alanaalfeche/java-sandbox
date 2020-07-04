import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Part A
 * Intcode program -- list of integers separated by a comma: (1, 0, 0, 3, 99):
 * first integer is the opcode -- can be 1, 2, or 99 Opcode 99 means to halt the
 * program Opcode 1 means to add numbers from two positions and stores result in
 * the third position. The three integers after opcode or the "params" will tell
 * you these positions e.g. add numbers from position 0 and 0 and store in
 * position 3 Opcode 2 works the same as opcode 1, but instead it multiples the
 * two inputs. After opcode is complete, march forward to position 4
 * 
 * Part B 
 * Determine which combination of noun and value to add up to 19690720
 */
public class Day2 {

    // Part A -- ARRAY 
    private static void decipher(String[] opcode) {
        int rowSize = opcode.length / 4;
        int columnSize = 4;
        int[][] opcode2D = new int[rowSize][columnSize];
        
        int counter = 0;
        for (int row = 0; row < rowSize; row++) {
            for (int column = 0; column < columnSize; column++) {

                int opcodeInt = Integer.parseInt(opcode[counter]);
                
                opcode2D[row][column] = opcodeInt;

                counter += 1; // iterate through the opcode[] array to get opcode2D[][] array value
            }
        }

        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < columnSize; j++) {
                if (j == 0) {
                    int x1 = opcode2D[i][j+1];
                    int x2 = opcode2D[i][j+2];
                    int x3 = opcode2D[i][j+3];

                    if (opcode2D[i][j] == 1) {
                        int sum = Integer.parseInt(opcode[x1]) + Integer.parseInt(opcode[x2]);
                        opcode[x3] = String.valueOf(sum); 
                    } else if (opcode2D[i][j] == 2) {
                        int product = Integer.parseInt(opcode[x1]) * Integer.parseInt(opcode[x2]);
                        opcode[x3] = String.valueOf(product);
                    } else if (opcode2D[i][j] == 99) break;
                }
            }
        }

        // System.out.println(Arrays.asList(opcode));
        // 3516593
    }

    // Part B -- LIST
    private static void bruteMatch(Integer[] opcodeInt) {
        int output = 0;
        int noun = 0;
        int verb = 0;

        while (output != 19690720) {
            int range = 99;
            int x = (int) (Math.random() * range);
            int y = (int) (Math.random() * range);

            List<Integer> input = Arrays.asList(1,12,2,3,1,1,2,3,1,3,4,3,1,5,0,3,2,9,1,19,1,19,5,23,1,23,6,27,2,9,27,31,1,5,31,35,1,35,10,39,1,39,10,43,2,43,9,47,1,6,47,51,2,51,6,55,1,5,55,59,2,59,10,63,1,9,63,67,1,9,67,71,2,71,6,75,1,5,75,79,1,5,79,83,1,9,83,87,2,87,10,91,2,10,91,95,1,95,9,99,2,99,9,103,2,10,103,107,2,9,107,111,1,111,5,115,1,115,2,119,1,119,6,0,99,2,0,14,0);
            // List<Integer> input = Arrays.asList(opcodeInt);
            input.set(1, x);
            input.set(2, y);

            for (int i = 0; i < input.size(); i += 4) {
                if (input.get(i) == 1) {
                    input.set(input.get(i+3), input.get(input.get(i+1)) + input.get(input.get(i+2)));
                } else if (input.get(i) == 2) {
                    input.set(input.get(i+3), input.get(input.get(i+1))*input.get(input.get(i+2)));
                } else if (input.get(i) == 99) {
                    break;
                }
            }

            output = input.get(0);
            noun = input.get(1);
            verb = input.get(2);
        }

        System.out.println(100 * noun + verb);
        // 7749
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = null;
        String line;
        String input = "";

        try {
            reader = new BufferedReader(new FileReader("input/day-02"));
            while ((line = reader.readLine()) != null) {
                input += line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }

        String[] opcodeString = input.split(",");
        Integer[] opcodeInt = new Integer[opcodeString.length];
        for (int i = 0; i < opcodeString.length; i++ ) {
            opcodeInt[i] = Integer.parseInt(opcodeString[i]);
        }

        decipher(opcodeString);
        bruteMatch(opcodeInt);
    }

}