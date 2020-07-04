import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Writes output to terminal.
 *
 * Formats the hashtable into five columns to display.
 * It also display the statistics and case scenario name for all 11 cases.
 *
 * @author Alana Alfeche
 * @since 04 November 2019
 * @revised 04 December 2019
 */
public class MatrixWriter {

    public void printMatrix(java.io.PrintWriter OutputHandler, int[] hashTable) {
        for (int i=1; i<hashTable.length; i++){
            int matrixElementMaxLength = 5;
            String matrixElement = String.valueOf(hashTable[i]);

            StringBuilder tempString = new StringBuilder();

            if(matrixElement.length() < matrixElementMaxLength){
                int filler = matrixElementMaxLength - matrixElement.length();
                tempString.append(" ".repeat(Math.max(0, filler))); // Add empty spaces if element length is less than max
            }

            StringBuilder finalString = tempString.append(matrixElement); // Prepend filler

            OutputHandler.print(finalString + (i % 5 == 0 ? "\n" : "|")); // Create a 5-column matrix result
        }
        OutputHandler.println("\n");
    }
}
