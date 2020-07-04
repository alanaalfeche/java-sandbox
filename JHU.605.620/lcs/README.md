<h1> Longest Common Subsequence Lab </h1>

#### Java Version: 
```
openjdk version "13" 2019-09-17
OpenJDK Runtime Environment (build 13+33)
OpenJDK 64-Bit Server VM (build 13+33, mixed mode, sharing)
```
#### IDE: 
```
IntelliJ IDEA 2019.2.4 (Community Edition)
 Build #IC-192.7142.36, built on October 28, 2019
 Runtime version: 11.0.4+10-b304.77 x86_64
 VM: OpenJDK 64-Bit Server VM by JetBrains s.r.o
 macOS 10.14.6
 GC: ParNew, ConcurrentMarkSweep
 Memory: 2014M
 Cores: 4
 Registry: ide.mac.allowDarkWindowDecorations=true
 Non-Bundled Plugins: org.intellij.scala
```
#### Instruction:
By default, the dynamic logic is **always** used against the input data. To run, use the following command:

```java LongestCommonSubsequence /full/path/to/input/file  /full/path/to/output/file```

To use the recursion logic against the input data, set the java command-line option to true like so: 
    
```java -Drecursion=true LongestCommonSubsequence /full/path/to/input/file  /full/path/to/output/file```

Or, if only interested in running the recursion logic, set the java command-line option **-Ddynamic** to false like so: 

```java -Drecursion=true -Ddynamic=false LongestCommonSubsequence /full/path/to/input/file  /full/path/to/output/file```

A matrix printer is also available in this application. To print the scoring matrix, set the command-line option **-DwriteMatrix** to true like so: 

```java -DwriteMatrix=true LongestCommonSubsequence /full/path/to/input/file  /full/path/to/output/file```

#### Sample Terminal Output:

```
Scoring Matrix:
        A    L    A    N    A    $ 
   F    0    0    0    0    0    0 
   1    0    0    0    0    0    0 
   N    0    0    0    1    1    1 
   A    1    1    1    1    2    2 
   L    1    2    2    2    2    2 
   $    1    2    2    2    2    3 
Done. Please view result in output/text_and_num_output.txt
```

#### Sample File Output:
```$xslt
Determining Longest Common Subsequences...

Sequence Pair: ALANA$,F1NAL$
Longest Common Subsequence: AL$
Dynamic Programming Completed in 1091 ms 

Longest Common Subsequence: AL$
Recursion Completed in 1245 ms 

```