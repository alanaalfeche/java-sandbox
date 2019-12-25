import java.util.Arrays;

/**
 * Insertion Sort Algorithm is an in-place sort.
 * 
 * Best: O(n)
 * Average, Worst: O(n^2)
 */
class InsertionSort{

    private static int[] sort(int[] input){
        for(int i = 1; i < input.length; i++){
            int key = input[i];
            int j = i-1;

            while (j >= 0 && input[j] > key){
                input[j+1] = input[j];
                j = j - 1; 
            }

            input[j + 1] = key;
        }

        return input;
    }

    public static void main(String[] args){
        int[] numberArray = {12, 25, 11, 22, 64};
        sort(numberArray);
        System.out.println(Arrays.toString(numberArray));
    }

}