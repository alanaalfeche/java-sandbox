import java.util.Arrays;

/**
 * QuickSort Algorithm falls in the divide and conquer category. 
 * Divide full set into two multiple subsets and use recursion to sort each subset.
 * 
 * Best, Average: O(n lgn) because comparison is done on a subset 
 * Worst: O(n^2)
 * 
 * Resources : https://www.youtube.com/watch?v=ZHVk2blR45Q
 *           : https://www.interviewbit.com/tutorial/quicksort-algorithm/
 */
class QuickSort{

    private static int partition(int[] input, int low, int high){
        int pivot =  input[high];
        int minIndex = low - 1;

        for (int j = low; j < high; j++){
            if (input[j] <= pivot) {
                minIndex++;

                // needs more clarification in this block..
                int temp = input[minIndex];
                input[minIndex] = input[j];
                input[j] = temp;
            }
        }

        // swapping pivot and highest number 
        int temp = input[minIndex + 1];
        input[minIndex + 1] = input[high];
        input[high] = temp;

        // returning partition index
        return minIndex + 1;
    }


    private static int[] sort(int[] input, int low, int high){
        if(low < high){
            int partitionIndex = partition(input, low, high);

            sort(input, low, partitionIndex - 1);
            sort(input, partitionIndex + 1, high);
        }

        return input;
    }

    public static void main(String[] args){
        int[] numberArray = {11, 25, 12, 22, 64};
        int arrayLength = numberArray.length;

        sort(numberArray, 0, arrayLength - 1);
        System.out.println(Arrays.toString(numberArray));
    }
}