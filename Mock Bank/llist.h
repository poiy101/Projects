
/**************************************************************
//
// Name:        Sae Hyun Song
//
// Homework:    Project2 
// 
// Class:       ICS 212
//
// Instructor:  Ravi Narayan
// 
// Date:        November 29, 2016
//
// File:        llist.h 
// 
// Description: The class header file containing all the member
//              variables and functions that will be used in 
//              the llist.cpp file.
//
**************************************************************/

#ifndef LLIST_H
#define LLIST_H

#include <string>
using namespace std;

class llist
{
    private:
        struct record * start;
        string filename;
        int readfile();
        int writefile();
        struct record * reverse(record *);
        void cleanup();
    public:
        llist();
        llist(string);
        ~llist();
        int addRecord(int, string, string, int);
        int printRecord(int);
        int modifyRecord(int, string);
        int deleteRecord(int);
        void printAll();
        void reverse();
        friend ostream & operator << (ostream & os, llist & list);
};

#endif /* LLIST_H */
