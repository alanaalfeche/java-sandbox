public class MatrixWriter {

    /**
     * Prints [m][n] scoring matrix from dynamic logic
     *
     * @param s1 String of sequence
     * @param s2 String of sequence
     * @param matrixScore Scoring matrix of the paired sequence
     */
    public void printMatrix(String s1, String s2, int[][] matrixScore) {
        int s1Size = s1.length();
        int s2Size = s2.length();

        // printing score matrix
        System.out.print("Scoring Matrix:\n     ");

        // printing row header
        for(int i = 0; i < s1Size; i++) {
            System.out.print(String.format("%4c ", s1.charAt(i)));
        }
        System.out.println();

        // printing column header
        for(int j = 1; j <= s2Size; j++) {
            System.out.print(String.format("%4c ", s2.charAt(j - 1)));

            // printing key-value pair
            for(int i = 1; i <= s1Size; i++) {
                System.out.print(String.format("%4d ", matrixScore[i][j]));
            }
            System.out.println();
        }

    }
}
