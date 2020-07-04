<h1> Hashing Assignment </h1>

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
To run this application,  use the following command:
```java HashLab /full/path/to/input/file /full/path/to/output/file```

This zip folder has three different sections:
1. resources/input folder contains five input files
    - input.txt is the default test file,
            no expected error
    - medium_input.txt will populate 80% of the table size,
            no expected error
    - large_input.txt exceeds the table size,
            returns a too large error
    - corrupt_input.txt contains data with non-numerical values,
            will not error out as regex match fails and will simply skip these bad data
    - empty_input.txt is an empty file,
            returns an empty dataset error
2. resources/output folder contains one output files
    - output.txt which is manually created by copy/paste result from terminal
3. src folder contains the source code
    - HashLab is the main driver
    - InputHandler reads and parses the data
    - HashHandler creates the HashTable
    - TimedResult times each hash table creation
    - MatrixWriter contains the logic for printing the matrix prettily
3. analysis has my write-up for the application of hashing in bioinformatics,
        the challenges I experienced throughout this project,
        and lessons learned.

All java files has already been compiled using javac. To run this application, simply use the following command:
```java HashLab /full/path/to/input/file```

#### Sample Terminal Output:
```
Calculating...
Done. Please see results in /Users/aa/Desktop/algorithms/programming/hashing/resources/output/output.txt
```

#### Sample File Output:
```
Case 1 Matrix
   -1|   -1|90123|14763|   -1
   -1|   -1|   -1|   -1|   -1
59531|38531|47893|   -1|33975
   -1|   -1|   -1|22699|   -1
12501|42501|12503|   -1|22705
   -1|   -1|   -1|99989|   -1
57391|   -1|   -1| 1234|   -1
13956|35197|   -1|22599|99999
80800|   -1|84763|   -1|18765
56565|   -1|78888|   -1|   -1
39531| 9531|   -1|   -1|   -1
   -1|   -1| 2698| 2699|62699
78901|19501|   -1|   -1|54545
92345|   -1|   -1|   -1|   -1
90911|78911|31753|   -1|   -1
   -1|71717|   -1|22999|62000
54321|   -1|64763|   -1|   -1
   -1|49287|   -1|   -1|67890
49531|88531|   -1|   -1|   -1
   -1|   -1|   -1|42699|   -1
62501|92501|   -1|   -1|   -1
   -1|26987|   -1|   -1|   -1
81111|   -1|47993|   -1|55555
67676|   -1|  358|37319|

Number of Collisions: 18
Number of Unadded Entries: 0
Load Factor: 100
Runtime: 43 ms
```
