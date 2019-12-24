import java.util.Arrays;

/**
 * Selection Sort Algorithm is an in-place comparison sort.
 * Iterates through an array to look for the most minimum value. 
 * Swaps the minimum value to the first element index, and so on.
 * Repeat until everything is in order. 
 * 
 * Best, Average, Worst: O(n^2)
 * 
 * Resource: https://www.mkyong.com/java/java-selection-sort-example/
 */
class SelectionSort{

    private static int[] sort(int[] input){
        for (int i = 0; i < input.length-1; i++){
            int minIndex = i; // 2

            for (int j = i + 1; j < input.length-1; j++){
                if (input[j] < input[minIndex]) {
                    minIndex = j;
                }

            }

            // swapping logic
            int temp = input[minIndex];
            input[minIndex] = input[i];
            input[i] = temp;
        }

        return input;
    }

    public static void main(String[] arguments){
        int[] numberArray = {11, 25, 12, 22, 64};
        sort(numberArray);
        System.out.println(Arrays.toString(numberArray));
    }

}