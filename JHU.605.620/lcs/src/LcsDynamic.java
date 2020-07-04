public class LcsDynamic {

    /**
     * Returns the longest subsequence of two sequence using the dynamic method
     *
     * @param s1 String of sequence
     * @param s2 String of sequence
     * @return String of longest subsequence
     */
    public String compute(String s1, String s2){
        int s1Size = s1.length();
        int s2Size = s2.length();

        // initializing matrix
        int[][] matrixScore = new int[s1Size + 1][s2Size + 1];

        // creating scoring matrix
        for(int i = 0; i < s1.length(); i++){
            for(int j = 0; j < s2.length(); j++){
                if(s1.charAt(i) == s2.charAt(j)){
                    matrixScore[i+1][j+1] = matrixScore[i][j] + 1;
                } else {
                    matrixScore[i+1][j+1] = Math.max(matrixScore[i+1][j], matrixScore[i][j+1]);
                }
            }
        }

        // reading substring from matrix
        StringBuffer stringBuffer = new StringBuffer();
        for(int x = s1Size, y = s2Size; x != 0 && y !=0;){
            if(matrixScore[x][y] == matrixScore[x-1][y]){
                x--;
            } else if(matrixScore[x][y] == matrixScore[x][y-1]){
                y--;
            } else {
                assert s1.charAt(x-1) == s2.charAt(y-1);
                stringBuffer.append(s1.charAt(x-1));
                x--;
                y--;
            }
        }

        // OPTION: print matrix
        Boolean writeMatrix = Boolean.parseBoolean(System.getProperty("writeMatrix", "false"));
        if (writeMatrix){
            MatrixWriter matrixWriter = new MatrixWriter();
            matrixWriter.printMatrix(s1, s2, matrixScore);
        }

        return stringBuffer.reverse().toString();
    }
}
