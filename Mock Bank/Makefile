CC=g++

CFLAGS=-c -Wall

project2: project2.o getfunc.o llist.o
	$(CC) -o project2 project2.o getfunc.o llist.o

proj2debug: Dproject2.o Dgetfunc.o Dllist.o
	$(CC) -DDEBUGMODE -o project2debug project2.o getfunc.o llist.o

Dllist.o: llist.cpp
	$(CC) -DDEBUGMODE $(CFLAGS) llist.cpp

llist.o: llist.cpp
	$(CC) $(CFLAGS) llist.cpp

Dgetfunc.o: getfunc.cpp
	$(CC) -DDEBUGMODE $(CFLAGS) getfunc.cpp

getfunc.o: getfunc.cpp
	$(CC) $(CFLAGS) getfunc.cpp

Dproject2.o: project2.cpp
	$(CC) -DDEBUGMODE $(CFLAGS) project2.cpp

project2.o: project2.cpp
	$(CC) $(CFLAGS) project2.cpp

clear:
	rm -rf *o project2 
Dclear:
	rm -rf *o project2debug 
