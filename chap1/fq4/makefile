#
# makefile 
#
# input file for 'make' build tool ( /usr/bin/make )
# to build solution for CS 3490 FQ fun
#
# @author Dr. Fenwick
# @version Spring 2017
#

JUNIT_JAR = /usr/share/java/junit-4.10.jar
HAMCREST_JAR = /usr/share/java/hamcrest/core-1.1.jar
JBF_PUB = /u/csd/jbf/pub/3490

default: 
	@echo "usage: make target"
	@echo "available targets: compile, test, clean, check restore"

compile: Array2dTest.java Array2d.java PartialArray2d.class
	javac -cp .:$(JUNIT_JAR) Array2dTest.java
	javac Array2d.java

clean:
	rm -f Array2d.class
	rm -f Array2dTest.class

test: Array2d.class Array2dTest.class PartialArray2d.class
	java -cp .:$(JUNIT_JAR):$(HAMCREST_JAR) org.junit.runner.JUnitCore Array2dTest

check: Array2d.java
	checkstyle Array2d.java

restore: $(JBF_PUB)/chap1/fq4/PartialArray2d.class $(JBF_PUB)/chap1/fq4/Array2dTest.java
	cp $(JBF_PUB)/chap1/fq4/PartialArray2d.class .
	cp $(JBF_PUB)/chap1/fq4/Array2dTest.java .
