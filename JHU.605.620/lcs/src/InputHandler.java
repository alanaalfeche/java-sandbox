import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Read and parse input file.
 *
 * It also handles the following error scenarios:
 *  - empty file
 *  - corrupt file
 *
 * @author Alana Alfeche
 * @since 04 November 2019
 * @revised 3 December 2019, line 37-44
 */
public class InputHandler {

    private String location;
    private List<String> inputData = new ArrayList<>();

    public InputHandler(String location){
        this.location = location;
    }

    public List<String> read() {
        BufferedReader objReader = null;

        try {
            String line;
            objReader = new BufferedReader(new FileReader(this.location));

            while ((line = objReader.readLine()) != null) {

                // To handle regular data
                if (line.matches("[A-Z]+")) {
                    inputData.add(line);
                } else { // To handle S1 = TEXTSAMPLEDATA
                    String segment = line.substring(line.lastIndexOf("=") + 1);
                    String segmentWithoutWhitespace = segment.replaceAll("\\s","");
                    inputData.add(segmentWithoutWhitespace);
                }
            }

            // To handle error when no data matches the input validation
            if (inputData.isEmpty()){
                System.err.println("No data found in the file.");
                System.exit(0);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (objReader != null);
                objReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return inputData;
    }

}