import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Day3 {

    private static void direct(String wire) {
        int rowSize = 2;
        int columnSize = 3;
        int[][] matrix = new int[rowSize][columnSize];
    
        print(matrix);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = null;
        String line;
        String input = "";
        
        try {
            reader = new BufferedReader(new FileReader("input/day-03"));
            while ((line = reader.readLine()) != null) {
                input += line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }

        direct(input);

    }  

    // best 2D printer in the world
    private static void print(int[][] matrix) {
        for (int[] x : matrix) {
            for (int y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }

}