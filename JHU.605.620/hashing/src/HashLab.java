import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Hash Table Assignment.
 *
 * This application accepts an input file and execute 11 cases against the input data.
 * The goal is to compare 4 different hashing method, 3 of which apply the Modular method and a Multiplicative method.
 * It also investigate the success rate of collision scheme in handling collision.
 * The runtime, statistics, and hash table for each dataset is displayed in the terminal.
 *
 * @author Alana Alfeche
 * @created 04 November 2019
 */
public class HashLab {

    public static void main(String[] args) throws IOException {
        String inputFilePath = null, outputFilePath = null;
        final List<String> inputData;
        final int tableSize = 120;

        // parse read/write location
        if (args.length < 2){
            System.out.println("Please see README for instruction on how to run this application.");
        } else {
            inputFilePath = args[0];
            outputFilePath = args[1];
        }

        // handle read/parse of input file
        InputHandler inputHandler = new InputHandler(inputFilePath);
        inputData = inputHandler.read();

        // initiate file writing
        assert outputFilePath != null;
        PrintWriter OutputHandler = new PrintWriter(outputFilePath);

        // initiate hashing algorithm
        HashHandler hashHandler = new HashHandler(inputData, tableSize);

        // initiate matrix writing
        MatrixWriter matrixWriter = new MatrixWriter();

        System.out.print("Calculating...\n");

        OutputHandler.println("Case 1 Matrix");
        var case1 = TimedResult.time(() -> hashHandler.createHashTable("division", 120, 1, "linear"));
        var stats1 = hashHandler.getStatistics();
        matrixWriter.printMatrix(OutputHandler, case1.result);
        OutputHandler.println("Number of Collisions: " + stats1.get(0) +
                              "\nNumber of Unadded Entries: " + stats1.get(1) +
                              "\nLoad Factor: " + stats1.get(2));
        OutputHandler.println("Runtime: " + case1.time);

        OutputHandler.println("Case 2 Matrix");
        var case2 = TimedResult.time(() -> hashHandler.createHashTable("division", 120, 1, "quadratic"));
        var stats2 = hashHandler.getStatistics();
        matrixWriter.printMatrix(OutputHandler, case2.result);
        OutputHandler.println("Number of Collisions: " + stats2.get(0) +
                              "\nNumber of Unadded Entries: " + stats2.get(1) +
                              "\nLoad Factor: " + stats2.get(2));
        OutputHandler.println("Runtime: " + case2.time);

        OutputHandler.println("Case 3 Matrix");
        var case3 = TimedResult.time(() -> hashHandler.createHashTable("division", 120, 1, "chaining"));
        var stats3 = hashHandler.getStatistics();
        matrixWriter.printMatrix(OutputHandler, case3.result);
        OutputHandler.println("Number of Collisions: " + stats3.get(0) +
                              "\nNumber of Unadded Entries: " + stats3.get(1) +
                              "\nLoad Factor: " + stats3.get(2));
        OutputHandler.println("Runtime: " + case3.time);

        OutputHandler.println("Case 4 Matrix");
        var case4 = TimedResult.time(() -> hashHandler.createHashTable("division", 113, 1, "linear"));
        var stats4 = hashHandler.getStatistics();
        matrixWriter.printMatrix(OutputHandler, case4.result);
        OutputHandler.println("Number of Collisions: " + stats4.get(0) +
                              "\nNumber of Unadded Entries: " + stats4.get(1) +
                              "\nLoad Factor: " + stats4.get(2));
        OutputHandler.print("Runtime: " + case4.time);

        OutputHandler.println("Case 5 Matrix");
        var case5 = TimedResult.time(() -> hashHandler.createHashTable("division", 113, 1, "quadratic"));
        var stats5 = hashHandler.getStatistics();
        matrixWriter.printMatrix(OutputHandler, case5.result);
        OutputHandler.println("Number of Collisions: " + stats5.get(0) +
                              "\nNumber of Unadded Entries: " + stats5.get(1) +
                              "\nLoad Factor: " + stats5.get(2));
        OutputHandler.println("Runtime: " + case5.time);

        OutputHandler.println("Case 6 Matrix");
        var case6 = TimedResult.time(() -> hashHandler.createHashTable("division", 113, 1, "chaining"));
        var stats6 = hashHandler.getStatistics();
        matrixWriter.printMatrix(OutputHandler, case6.result);
        OutputHandler.println("Number of Collisions: " + stats6.get(0) +
                              "\nNumber of Unadded Entries: " + stats6.get(1) +
                              "\nLoad Factor: " + stats6.get(2));
        OutputHandler.print("Runtime: " + case6.time);

        OutputHandler.println("Case 7 Matrix");
        var case7 = TimedResult.time(() -> hashHandler.createHashTable("division", 41, 3, "linear"));
        var stats7 = hashHandler.getStatistics();
        matrixWriter.printMatrix(OutputHandler, case7.result);
        OutputHandler.println("Number of Collisions: " + stats7.get(0) +
                              "\nNumber of Unadded Entries: " + stats7.get(1) +
                              "\nLoad Factor: " + stats7.get(2));
        OutputHandler.print("Runtime: " + case7.time);

        OutputHandler.println("Case 8 Matrix");
        var case8 = TimedResult.time(() -> hashHandler.createHashTable("division", 41, 3, "quadratic"));
        var stats8 = hashHandler.getStatistics();
        matrixWriter.printMatrix(OutputHandler, case8.result);
        OutputHandler.println("Number of Collisions: " + stats8.get(0) +
                              "\nNumber of Unadded Entries: " + stats8.get(1) +
                              "\nLoad Factor: " + stats8.get(2));
        OutputHandler.print("Runtime: " + case8.time);

        OutputHandler.println("Case 9 Matrix");
        var case9 = TimedResult.time(() -> hashHandler.createHashTable("multiplication", 120, 1, "linear"));
        var stats9 = hashHandler.getStatistics();
        matrixWriter.printMatrix(OutputHandler, case9.result);
        OutputHandler.println("Number of Collisions: " + stats9.get(0) +
                              "\nNumber of Unadded Entries: " + stats9.get(1) +
                              "\nLoad Factor: " + stats9.get(2));
        OutputHandler.print("Runtime: " + case9.time);

        OutputHandler.println("Case 10 Matrix");
        var case10 = TimedResult.time(() -> hashHandler.createHashTable("multiplication", 120, 1, "quadratic"));
        var stats10 = hashHandler.getStatistics();
        matrixWriter.printMatrix(OutputHandler, case10.result);
        OutputHandler.println("Number of Collisions: " + stats10.get(0) +
                              "\nNumber of Unadded Entries: " + stats10.get(1) +
                              "\nLoad Factor: " + stats10.get(2));

        OutputHandler.print("Runtime: " + case10.time);

        OutputHandler.println("Case 11 Matrix");
        var case11 = TimedResult.time(() -> hashHandler.createHashTable("multiplication", 120, 1, "chaining"));
        var stats11 = hashHandler.getStatistics();
        matrixWriter.printMatrix(OutputHandler, case11.result);
        OutputHandler.println("Number of Collisions: " + stats11.get(0) +
                              "\nNumber of Unadded Entries: " + stats11.get(1) +
                              "\nLoad Factor: " + stats11.get(2));

        OutputHandler.print("Runtime: " + case11.time);

        System.out.print("Done. Please see results in " + outputFilePath);
        OutputHandler.close();
    }
}

