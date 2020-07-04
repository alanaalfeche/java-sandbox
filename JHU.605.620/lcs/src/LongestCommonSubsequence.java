import java.io.*;
import java.util.List;

public class LongestCommonSubsequence {

    public static void main(String[] args) throws IOException {
        String inputFilePath = null, outputFilePath = null;

        if (args.length < 2) {
            System.out.println("Please see README for instruction on how to run this application.");
        } else {
            inputFilePath = args[0];
            outputFilePath = args[1];
        }

        InputHandler inputHandler = new InputHandler(inputFilePath);
        List<String> inputData = inputHandler.read();

        // OPTIONS: apply recursion / dynamic logic
        boolean dynamic = Boolean.parseBoolean(System.getProperty("dynamic", "true"));
        boolean recursion = Boolean.parseBoolean(System.getProperty("recursion", "false"));

        LcsDynamic lcsDynamic = new LcsDynamic();
        LcsRecursive lcsRecursive = new LcsRecursive();

        assert outputFilePath != null;
        PrintWriter OutputHandler = new PrintWriter(new FileWriter(outputFilePath));

        OutputHandler.println("Determining Longest Common Subsequences...\n");

        for (int i = 0; i <= inputData.size(); i++){
            for (int j = i+1; j <= inputData.size() - 1; j++) {
                int finalI = i, finalJ = j; // variables in lambda should be final or effectively final

                OutputHandler.println("Sequence Pair: " + inputData.get(finalI) + "," + inputData.get(finalJ));

                if (dynamic){
                    var LCSDynamicResult = TimedResult.time(() -> lcsDynamic.compute(inputData.get(finalI), inputData.get(finalJ)));
                    OutputHandler.println("Longest Common Subsequence: " + LCSDynamicResult.result);
                    OutputHandler.println("Dynamic Programming Completed in " + LCSDynamicResult.time);
                }

                if (recursion){
                    var LCSRecursiveResult = TimedResult.time(() -> lcsRecursive.compute(inputData.get(finalI), inputData.get(finalJ)));
                    OutputHandler.println("Longest Common Subsequence: " + LCSRecursiveResult.result);
                    OutputHandler.println("Recursion Completed in " + LCSRecursiveResult.time);
                }

            }
        }

        System.out.println("Done. Please view result in " + outputFilePath);
        OutputHandler.close();
    }

}
