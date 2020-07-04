import java.io.*;
import java.util.*;

/**
 * This application accepts an input file. Matrix is constructed, and calculated
 * using ordinary and strassen matrix multiplication method.
 *
 * The calculated result for ordinary and strassen matrix multiplication is
 * generated to the command line.
 *
 * @author Alana Alfeche
 * @since 04 December 2019
 */
public class Strassen {

    public static void main(String[] args) {

        if (args.length < 1){
            System.out.println("Please see README for instruction on how to run this application.");
            System.exit(-1);
        }

        String line;
        int x = 0, y = 0;
        int matrixSize = 0;
        int initialMatrixSize = 32; //initial matrix size to allocate space
        int[][] matrix = new int [initialMatrixSize][initialMatrixSize];
        boolean flag = false; //  to handle output flow

        try {
            BufferedReader objReader = new BufferedReader(new FileReader(args[0]));

            while((line = objReader.readLine()) != null) {

                // empty line
                if (line.length() == 0){
                    if (flag){
                        System.out.println("\nMatrix Size: " + matrixSize);
                        System.out.println("Input matrix");
                        print_array(matrix, x, matrixSize);

                        int[][] A = new int [matrixSize][matrixSize];
                        int[][] B = new int [matrixSize][matrixSize];

                        //split input data
                        splitMatrix(matrix, A, B, x, matrixSize);

                        //ordinary multiplication
                        ordinaryMultiplication(A,B);

                        //strassen multiplication
                        int[][] strassenOutput = strassenMultiplication(A,B);

                        //strassen output
                        System.out.println("\nStrassen Multiplication Result: ");
                        for (int[] ints : strassenOutput) {
                            for (int j = 0; j < strassenOutput.length; j++) {
                                System.out.print(ints[j] + "\t");
                            }
                            System.out.println();
                        }

                    }
                    flag = false;
                }

                if (line.length() == 1){
                    matrixSize = Integer.parseInt(line);
                    flag = true;
                    x = 0;
                    y = 0;
                    continue;
                }

                if (flag){
                    StringTokenizer tokenizer = new StringTokenizer(line," ");
                    while (tokenizer.hasMoreTokens()){
                        matrix[x][y] = Integer.parseInt(tokenizer.nextToken());
                        y++;
                    }
                    y = 0;
                    x++;
                }

            }
        } catch (FileNotFoundException ex) {
            System.out.println("File error");
        } catch (IOException ex) {
            System.out.println("Read error");
        }
    }

    // Source: CLRS Appendix D.1 - Matrices and Matrix Operations
    private static void ordinaryMultiplication(int[][] A, int[][] B){
        int size = A.length;
        int[][] ordinaryOutputMatrix = new int [size][size];

        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                ordinaryOutputMatrix[i][j] = 0;
                for (int k = 0; k < size; k++){
                    ordinaryOutputMatrix[i][j] = ordinaryOutputMatrix[i][j] + A[i][k] * B[k][j];
                }
            }
        }

        System.out.println("\nOrdinary Result:");
        print_array(ordinaryOutputMatrix, size, size);
    }

    // Source: CLRS Chapter 4.2 - Strassen's Algorithm for Matrix Multiplication
    private static int[][] strassenMultiplication(int[][] A, int[][] B){
        int size = A.length;
        int[][] strassenMatrix = new int[size][size];

        //base case
        if (size == 1){
            strassenMatrix[0][0] = A[0][0] * B[0][0];
        }

        //recursive case
        else{
            //initializing submatrices
            int[][] A11 = new int[size/2][size/2];
            int[][] A12 = new int[size/2][size/2];
            int[][] A21 = new int[size/2][size/2];
            int[][] A22 = new int[size/2][size/2];
            int[][] B12 = new int[size/2][size/2];
            int[][] B21 = new int[size/2][size/2];
            int[][] B11 = new int[size/2][size/2];
            int[][] B22 = new int[size/2][size/2];

            //partitioning original matrix to submatrices
            partition(A,A11,0,size/2,0, size/2);
            partition(A,A12,0,size/2,size/2, size);
            partition(A,A21,size/2,size,0, size/2);
            partition(A,A22,size/2,size,size/2, size);
            partition(B,B11,0,size/2,0, size/2);
            partition(B,B12,0,size/2,size/2, size);
            partition(B,B21,size/2,size,0, size/2);
            partition(B,B22,size/2,size,size/2, size);

            //initializing helper matrices
            int[][] S1 = subtract(B12,B22);
            int[][] S2 = add(A11,A12);
            int[][] S3 = add(A21,A22);
            int[][] S4 = subtract(B21,B11);
            int[][] S5 = add(A11,A22);
            int[][] S6 = add(B11,B22);
            int[][] S7 = subtract(A12,A22);
            int[][] S8 = add(B21,B22);
            int[][] S9 = subtract(A11,A21);
            int[][] S10 = add(B11,B12);

            //initializing second set of matrices for strassen calculation with recursion
            int[][] P1 = strassenMultiplication(A11,S1);
            int[][] P2 = strassenMultiplication(S2,B22);
            int[][] P3 = strassenMultiplication(S3, B11);
            int[][] P4 = strassenMultiplication(A22,S4);
            int[][] P5 = strassenMultiplication(S5,S6);
            int[][] P6 = strassenMultiplication(S7,S8);
            int[][] P7 = strassenMultiplication(S9,S10);

            //initializing combination
            int[][] C11 = add(subtract(add(P5,P4),P2),P6);
            int[][] C12 = add(P1,P2);
            int[][] C21 = add(P3,P4);
            int[][] C22 = subtract(subtract(add(P5,P1),P3),P7);

            //combining matrices
            combine(strassenMatrix,C11,0,size/2,0, size/2);
            combine(strassenMatrix,C12,0,size/2,size/2, size);
            combine(strassenMatrix,C21,size/2,size,0, size/2);
            combine(strassenMatrix,C22,size/2,size,size/2, size);

        }

        return strassenMatrix;
    }

    // Partition original matrix into 4 matrices
    private static void partition(int[][] matrix, int[][] subMatrix,
                                  int x1, int x2,
                                  int y1, int y2){

        for (int i = 0, x = x1; i < x2 - x1; i++, x++){
            for (int j = 0, y = y1; j < y2- y1; j++, y++){
                subMatrix[i][j] = matrix[x][y];
            }
        }
    }

    // Add two matrices
    private static int[][] add(int[][] A, int[][] B){
        int size = A.length;
        int[][] sumMatrix = new int[size][size];
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                sumMatrix[i][j] = A[i][j] + B[i][j];
            }
        }
        return sumMatrix;
    }

    // Subtracts two matrices
    private static int[][] subtract(int[][] A, int[][] B){
        int size = A.length;
        int[][] differenceMatrix = new int[size][size];
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                differenceMatrix[i][j] = A[i][j] - B[i][j];
            }
        }
        return differenceMatrix;
    }

    // Merge submatrices to matrix
    private static void combine(int[][] matrix, int[][] subMatrix,
                                int x1, int x2,
                                int y1, int y2){
        for (int i = 0, x = x1; x < x2; x++, i++){
            for (int j = 0, y = y1; y < y2; y++, j++){
                matrix[x][y] = subMatrix[i][j];
            }
        }
    }

    // manual array copy
    private static void splitMatrix(int[][] matrix, int[][] A, int[][] B, int x, int y){
        for (int i = 0; i < x/2; i++){
            if (y >= 0) System.arraycopy(matrix[i], 0, A[i], 0, y);
        }

        for (int i = x/2; i < x; i++){
            if (y >= 0) System.arraycopy(matrix[i], 0, B[i - x / 2], 0, y);
        }
    }

    // print array
    private static void print_array(int[][] matrix, int x, int y){
        for (int i = 0; i < x; i++){
            for (int j = 0; j < y; j++){
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

}