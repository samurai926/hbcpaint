# hbcpaint
This program reads in a file with customer paint and finish 
preferences and outputs the combination that satisfies 
all customers (if a solution exists)

### Prerequisites

To build and run the executable jar file you'll need:

```
Maven
JRE 1.7+
```

### Binary distribution

For convenience I uploaded hbcpaint.jar to my Drive:

```
https://drive.google.com/open?id=1RXc5NnQCVnJhGVhMzkJ5z76MQcqMGy8s
```

Steps to compile and run the program :
1. Download the git project
2. Run maven install
3. The resulting executable jar file is /target/hbcpaint.jar
4. To run the jar file cd to jar directory and issue:  java -jar ./hbcpaint.jar {path}
5. There is an optional command line arg for debug stmts:  java -jar ./hbcpaint.jar debug {path}
6. The output is written to stdout

Sample output (with debug turned on):
```
2018/04/15 23:00:24 [INFO] input string: 5
1 M 3 G 5 G
2 G 3 M 4 G
5 M

2018/04/15 23:00:24 [INFO] input (5 colors): 
2018/04/15 23:00:24 [INFO] 1 M 3 G 5 G
2018/04/15 23:00:24 [INFO] 2 G 3 M 4 G
2018/04/15 23:00:24 [INFO] 5 M
2018/04/15 23:00:24 [INFO] printing all customer objects...
2018/04/15 23:00:24 [INFO] cust 1: { [color: 3, finish: G],[color: 5, finish: G],[color: 1, finish: M] }
2018/04/15 23:00:24 [INFO] cust 2: { [color: 2, finish: G],[color: 4, finish: G],[color: 3, finish: M] }
2018/04/15 23:00:24 [INFO] cust 3: { [color: 5, finish: M] }
2018/04/15 23:00:24 [INFO] Building solution set...
2018/04/15 23:00:24 [INFO] solving...
2018/04/15 23:00:24 [INFO] printing contents of solution matrix...
2018/04/15 23:00:24 [INFO] GGGGG
2018/04/15 23:00:24 [INFO] GGGGM
G G G G M

...
```

## Automated Tests

There is a JUnit test suite included in the project that exercises one of the
supporting functions of the entry point.  

### Running the tests

The test suite gets automatically executed during the Maven install process 
but you can run the suite manually by running the following class from your 
favorite IDE:

```
/sitesearcher/src/test/java//sitesearcher/AppTest.java
```

## This project was built with

* [Eclipse](https://www.eclipse.org/) - The IDE
* [Maven](https://maven.apache.org/) - Dependency Management

