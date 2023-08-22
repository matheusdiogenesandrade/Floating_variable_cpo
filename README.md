For compiling the code:
```sh
javac -cp /opt/ibm/ILOG/CPLEX_Studio2211/cpoptimizer/lib/ILOG.CP.jar Main.java
```

For running it:
```sh
java -cp /opt/ibm/ILOG/CPLEX_Studio2211/cpoptimizer/lib/ILOG.CP.jar:/opt/ibm/ILOG/CPLEX_Studio2211/opl/lib/oplall.jar:. -Djava.library.path=/opt/ibm/ILOG/CPLEX_Studio2211/cpoptimizer/bin/x86-64_linux/:/opt/ibm/ILOG/CPLEX_Studio2211/cplex/bin/x86-64_linux/:/opt/ibm/ILOG/CPLEX_Studio2211/opl/bin/x86-64_linux/ Main
```

Some cases you will need to set the environment variable below for running the program:
```sh
DYLD_LIBRARY_PATH=/opt/ibm/ILOG/CPLEX_Studio2211/cpoptimizer/bin/x86-64_linux/:/opt/ibm/ILOG/CPLEX_Studio2211/cplex/bin/x86-64_linux/:/opt/ibm/ILOG/CPLEX_Studio2211/opl/bin/x86-64_linux/
```
