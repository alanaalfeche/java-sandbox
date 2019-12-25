import java.util.Arrays;

class Marathon{

    // Selection Sort
    private static int[] sort(int[] input){
        for(int i = 0; i < input.length-1; i++){
            int minIndex = i;

            for(int j = i + 1; j < input.length; j++){
                if (input[j] < input[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = input[minIndex];
            input[minIndex] = input[i];
            input[i] = temp;
        }

        return input;
    }

    public static void main(String[] args){
        String[] names = {
            "Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex",
            "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda",
            "Aaron", "Kate"
        };

        int[] times = {
            341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299,
            343, 317, 265
        };
        
        int[] timesCopy = Arrays.copyOf(times, times.length);

        sort(timesCopy);
    
        int fastestTime = timesCopy[timesCopy.length - 1];
        int secondFastedTime = timesCopy[timesCopy.length - 2];
        
        int fastestTimeIndex, secondFastestTimeIndex;
        fastestTimeIndex = secondFastestTimeIndex = 0;

        for (int i = 0; i < times.length - 1; i++) {
            if (times[i] == fastestTime) {
                fastestTimeIndex = i;
            } 
            
            if (times[i] == secondFastedTime) {
                secondFastestTimeIndex = i;
            }
        }

        System.out.println("First Place: " + names[fastestTimeIndex] + " at " + fastestTime + " minutes");
        System.out.println("Second Place: " + names[secondFastestTimeIndex] + " at " + secondFastedTime + " minutes");
 
    }
    
}