# From Thinking in Patterns (with Java) by Bruce Eckel
# At http://www.BruceEckel.com
# (c)2001 Bruce Eckel 
# Copyright notice in Copyright.txt
# Automatically-generated MAKEFILE 
# For examples in directory .\c12\trashvisitor
# using the JDK 1.3 compiler
# Invoke with: make

HOME := ../../

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
	Visitable.class \
	Visitor.class \
	VAluminum.class \
	VisitableDecorator.class \
	FillableVisitor.class \
	TrashVisitor.class

jikes: \
	Visitable.class \
	Visitor.class \
	VAluminum.class \
	VisitableDecorator.class \
	FillableVisitor.class \
	TrashVisitor.class

clean:
ifeq ($(notdir $(SHELL)),COMMAND.COM)
	del *.class
else
	rm -f *.class
endif


Visitable.class: Visitable.java 

Visitor.class: Visitor.java 

VAluminum.class: VAluminum.java 

VisitableDecorator.class: VisitableDecorator.java 

FillableVisitor.class: FillableVisitor.java 

TrashVisitor.class: TrashVisitor.java 
	$(JVC) $(JVCFLAGS) $<
	java com.bruceeckel.test.RunUnitTests TrashVisitor
