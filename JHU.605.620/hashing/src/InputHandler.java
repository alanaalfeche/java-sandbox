import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Read and parse an input file.
 *
 * Returns a list of string that matches a numerical format of [0-9]
 * It also handles the following error scenarios:
 *  - empty file
 *  - input data size is greater than constant table size
 *  - corrupt file
 *
 * @author Alana Alfeche
 * @since 04 November 2019
 */
public class InputHandler {

    private String location;
    private List<String> inputData = new ArrayList<>();

    public InputHandler(String location){
        this.location = location;
    }

    List<String> read() {
        BufferedReader objReader = null;

        try {
            String line;
            objReader = new BufferedReader(new FileReader(this.location));

            while ((line = objReader.readLine()) != null) {
                if (line.matches("[0-9]+") && line.length() > 2) {
                    inputData.add(line);
                }
            }

            if (inputData.isEmpty()){
                System.err.println("No data found in the file.");
                System.exit(0);
            }

            if (inputData.size() > 120){
                System.err.println("Input file exceeds the max table size.");
                System.exit(0);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert objReader != null;
                objReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return inputData;
    }

}