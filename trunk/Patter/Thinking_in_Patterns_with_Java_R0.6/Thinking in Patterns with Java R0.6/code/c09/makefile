# From Thinking in Patterns (with Java) by Bruce Eckel
# At http://www.BruceEckel.com
# (c)2001 Bruce Eckel 
# Copyright notice in Copyright.txt
# Automatically-generated MAKEFILE 
# For examples in directory .\c09
# using the JDK 1.3 compiler
# Invoke with: make

HOME := ../

ifndef MAKECMDGOALS
MAKECMDGOALS := javac
endif

# Command.com is too weak to build this under Windows NT/2000:
ifeq ($(OS),Windows_NT)
COMSPEC=$(SYSTEMROOT)\system32\cmd.exe
endif

ifneq ($(MAKECMDGOALS),clean)
include $(HOME)/$(MAKECMDGOALS).mac
endif

.SUFFIXES : .class .java
.java.class :
	$(JVC) $(JVCFLAGS) $<

javac: \
	GreenHouseController.class \
	PythonInterpreterSetting.class \
	PythonInterpreterGetting.class \
	MultipleJythons.class \
	TestPythonToJavaClass.class \
	if \
	list \
	myFunction \
	differentReturns \
	sum \
	strings \
	stringFormatting \
	SimpleClass \
	Simple2 \
	GreenHouseLanguage \
	JavaClassInPython \
	PythonSwing \
	PythonDialogs \
	python\java\test\PythonToJavaClass.class

jikes: \
	GreenHouseController.class \
	PythonInterpreterSetting.class \
	PythonInterpreterGetting.class \
	MultipleJythons.class \
	TestPythonToJavaClass.class \
	if \
	list \
	myFunction \
	differentReturns \
	sum \
	strings \
	stringFormatting \
	SimpleClass \
	Simple2 \
	GreenHouseLanguage \
	JavaClassInPython \
	PythonSwing \
	PythonDialogs \
	python\java\test\PythonToJavaClass.class

clean:
ifeq ($(notdir $(SHELL)),COMMAND.COM)
	del *.class
else
	rm -f *.class
endif


GreenHouseController.class: GreenHouseController.java 
	$(JVC) $(JVCFLAGS) $<
	java com.bruceeckel.test.RunUnitTests GreenHouseController
PythonInterpreterSetting.class: PythonInterpreterSetting.java 
	$(JVC) $(JVCFLAGS) $<
	java com.bruceeckel.test.RunUnitTests PythonInterpreterSetting
PythonInterpreterGetting.class: PythonInterpreterGetting.java 
	$(JVC) $(JVCFLAGS) $<
	java com.bruceeckel.test.RunUnitTests PythonInterpreterGetting
MultipleJythons.class: MultipleJythons.java 
	$(JVC) $(JVCFLAGS) $<
	java com.bruceeckel.test.RunUnitTests MultipleJythons
TestPythonToJavaClass.class: TestPythonToJavaClass.java python\java\test\PythonToJavaClass.class 
	$(JVC) $(JVCFLAGS) $<
	java com.bruceeckel.test.RunUnitTests TestPythonToJavaClass
if: if.py 
	python $<

list: list.py 
	python $<

myFunction: myFunction.py 
	python $<

differentReturns: differentReturns.py 
	python $<

sum: sum.py 
	python $<

strings: strings.py 
	python $<

stringFormatting: stringFormatting.py 
	python $<

SimpleClass: SimpleClass.py 
	python $<

Simple2: Simple2.py 
	python $<

GreenHouseLanguage: GreenHouseLanguage.py 
	python $<

JavaClassInPython: JavaClassInPython.py 
	jython.bat JavaClassInPython.py


PythonSwing: PythonSwing.py 
	@echo skipping PythonSwing.py


PythonDialogs: PythonDialogs.py 
	@echo skipping PythonDialogs.py


python\java\test\PythonToJavaClass.class: PythonToJavaClass.py 
	jythonc.bat --package python.java.test \
	PythonToJavaClass.py


