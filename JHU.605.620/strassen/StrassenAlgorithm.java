import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class StrassenAlgorithm {
    public static void main(String[] args) {
        try(Stream<String> lines = Files.lines(Paths.get(args[0]))) {
            AtomicInteger matrixSize = new AtomicInteger(0);
            List<List<Integer>> matrixContent  = new ArrayList<>();
            List<List<Integer>> matrixA = new ArrayList<>();
            List<List<Integer>> matrixB = new ArrayList<>();

            lines.forEach(line -> {
                if(!line.trim().isEmpty()) {
                    // array size is not set
                    if (matrixSize.get() == 0) {
                        matrixSize.set(Integer.parseInt(line));
                    } else {
                        // line contains matrix contents
                        var tokens = line.split("\\s+");
                        var numbers = new ArrayList<Integer>();
                        for (var token : tokens) {
                            var i = Integer.parseInt(token);
                            numbers.add(i);
                        }
                        matrixContent.add(numbers);
                        // System.out.println(matrixContent);
                    }
                } else {
                    matrixA.addAll(matrixContent.subList(0, matrixSize.get()));
                    matrixB.addAll(matrixContent.subList(matrixSize.get(), matrixContent.size()));

                    List<List<Integer>> matrixResult = multiply(matrixA, matrixB);
                    System.out.println(matrixResult);
                    
                    matrixContent.clear();
                    matrixSize.set(0);
                }
            });
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static List<List<Integer>> multiply(List<List<Integer>> matrixA, List<List<Integer>> matrixB) {
        int M1 = (matrixA.get(0).get(0) + matrixA.get(1).get(1)) * (matrixB.get(0).get(0) + matrixB.get(1).get(1));
        int M2 = (matrixA.get(1).get(0) + matrixA.get(1).get(1)) * (matrixB.get(0).get(0));
        int M3 = (matrixA.get(0).get(0)) * (matrixB.get(0).get(1) - matrixB.get(1).get(1));
        int M4 = (matrixA.get(1).get(1)) * (matrixB.get(1).get(0) - matrixB.get(0).get(0));
        int M5 = (matrixA.get(0).get(0) + matrixA.get(0).get(1)) * (matrixB.get(1).get(1));
        int M6 = (matrixA.get(1).get(0) + matrixA.get(0).get(0)) * (matrixB.get(0).get(0) + matrixB.get(0).get(1));
        int M7 = (matrixA.get(0).get(1) + matrixA.get(1).get(1)) * (matrixB.get(1).get(0) + matrixB.get(1).get(1));

        int C11 = M1 + M4 - M5 + M7;
        int C12 = M3 + M5;
        int C21 = M2 + M4;
        int C22 = M1 - M2 + M3 + M6;

        return List.of(List.of(C11, C12), List.of(C21, C22));
    }
}
