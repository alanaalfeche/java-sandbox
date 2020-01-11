import java.util.Arrays;

/**
 * MergeSort Algorithm is a stable algorithm, but it is out of place. 
 * This means that it requires another copy of the data.  
 * MergeSort splits a dataset into multiple subserts until length is 1. 
 * The work is merging the single subset together in the correct order.
 * 
 * Best, Average, Worst: O(n lgn) because we reduced comparison by 1/2.
 * 
 * Resources : https://www.youtube.com/watch?v=qdv3i6X0PiQ
 */
class MergeSort{

    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];

        int leftPointer, rightPointer, resultPointer;
        leftPointer = rightPointer = resultPointer = 0;

        while (leftPointer < left.length || rightPointer < right.length) {
            if (leftPointer < left.length && rightPointer < right.length) {
                if (left[leftPointer] < right[rightPointer]) {
                    result[resultPointer++] = left[leftPointer++];
                } else {
                    result[resultPointer++] = right[rightPointer++];
                }
            } else if (leftPointer < left.length) {
                result[resultPointer++] = left[leftPointer++];
            } else if (rightPointer < right.length) {
                result[resultPointer++] = right[rightPointer++];
            }
        }

        return result;
    }

    private static int[] sort(int[] input){
        if (input.length <= 1) {
            return input;
        }

        int midpoint = input.length / 2;
        int[] left = new int[midpoint];
        int[] right;

        // for subset that doesn't have an odd number of elements
        if (input.length % 2 == 0) {
            right = new int[midpoint];
        } else {
            right = new int[midpoint + 1];
        }

        for (int i = 0; i < midpoint; i++){
            left[i] = input[i];
        }

        for (int j = 0; j < right.length; j++){
            right[j] = input[midpoint + j];
        }

        left = sort(left);
        right = sort(right);

        return merge(left, right);
    }

    public static void main(String[] args){
        int[] numberArray = {11, 25, 12, 22, 64};
        int[] sortedArray = sort(numberArray);

        System.out.println(Arrays.toString(sortedArray));
    }

}