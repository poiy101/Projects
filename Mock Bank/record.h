/**************************************************************
//
// Name:        Sae Hyun Song
//
// Homework:    project2 
// 
// Class:       ICS 212
//
// Instructor:  Ravi Narayan
// 
// Date:        November 29 , 2016
//
// File:        record.h 
// 
// Description: A struct file which contains the record object-
//              like properties with struct.
//
**************************************************************/

#ifndef RECORD_H
#define RECORD_H

#include <string>
using namespace std;

struct record
{
    int accountno;
    string name;
    string address;
    int yearofbirth;
    struct record* next;
};
 
#endif /* RECORD_H */
