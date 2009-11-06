# Master makefile for Thinking in Patterns by Bruce Eckel
# at http://www.BruceEckel.com
# (c)2001 Bruce Eckel 
# Copyright notice in Copyright.txt
# Compiles all the code in the book
# Using the JDK 1.3 compiler

help: 
	@echo To compile all programs from 
	@echo Thinking in Patterns (with Java), type
	@echo one of the following commands,
	@echo according to your platform:
	@echo make javac
	@echo make jikes
	@echo make clean
	@echo Make sure that this directory and '.' are
	@echo in your CLASSPATH before compiling

$(MAKECMDGOALS): 
	$(MAKE) $(MAKECMDGOALS) -C com/bruceeckel/util
	$(MAKE) $(MAKECMDGOALS) -C com/bruceeckel/test
	$(MAKE) $(MAKECMDGOALS) -C com/bruceeckel/python
	$(MAKE) $(MAKECMDGOALS) -C c01
	$(MAKE) $(MAKECMDGOALS) -C c02
	$(MAKE) $(MAKECMDGOALS) -C c02/test
	$(MAKE) $(MAKECMDGOALS) -C c02/testable
	$(MAKE) $(MAKECMDGOALS) -C c03
	$(MAKE) $(MAKECMDGOALS) -C c04
	$(MAKE) $(MAKECMDGOALS) -C c04/statemachine
	$(MAKE) $(MAKECMDGOALS) -C c04/mouse
	$(MAKE) $(MAKECMDGOALS) -C c04/mousetrap1
	$(MAKE) $(MAKECMDGOALS) -C c04/mousetrap2
	$(MAKE) $(MAKECMDGOALS) -C c04/statemachine2
	$(MAKE) $(MAKECMDGOALS) -C c04/vendingmachine
	$(MAKE) $(MAKECMDGOALS) -C cX/decorator/nodecorators
	$(MAKE) $(MAKECMDGOALS) -C cX/decorator/alldecorators
	$(MAKE) $(MAKECMDGOALS) -C cX/decorator/compromise
	$(MAKE) $(MAKECMDGOALS) -C c05
	$(MAKE) $(MAKECMDGOALS) -C c05/shapefact1
	$(MAKE) $(MAKECMDGOALS) -C c05/shapefact2
	$(MAKE) $(MAKECMDGOALS) -C c06
	$(MAKE) $(MAKECMDGOALS) -C c06/strategy
	$(MAKE) $(MAKECMDGOALS) -C c07
	$(MAKE) $(MAKECMDGOALS) -C c09/javaclass
	$(MAKE) $(MAKECMDGOALS) -C c09
	$(MAKE) $(MAKECMDGOALS) -C c10
	$(MAKE) $(MAKECMDGOALS) -C c11
	$(MAKE) $(MAKECMDGOALS) -C c12/trash
	$(MAKE) $(MAKECMDGOALS) -C c12/recyclea
	$(MAKE) $(MAKECMDGOALS) -C c12/recycleap
	$(MAKE) $(MAKECMDGOALS) -C c12/recycleb
	$(MAKE) $(MAKECMDGOALS) -C c12/doubledispatch
	$(MAKE) $(MAKECMDGOALS) -C c12/trashvisitor
	$(MAKE) $(MAKECMDGOALS) -C c12/dynatrash
	$(MAKE) $(MAKECMDGOALS) -C c13
