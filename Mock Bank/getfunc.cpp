/***************************************************************************
//
// Name:        Sae Hyun Song
//
// Homework:    Project 2 
//
// Class:       ICS 212
//
// Instructor:  Ravi Narayan
//
// Date:        November 29 , 2016
//
// File:        getfunc.cpp
//
// Description: A get function file which uses functions to get the year of
//              birth and the accountnumber. 
//
***************************************************************************/

#include <iostream>
#include <iomanip>
#include <string>
#include "record.h"
#include "llist.h" 
using namespace std;

int getyearofbirth();
int getaccountnum();

/***************************************************************************
//
// Function Name: getyearofbirth 
//
// Description:   A function that gets the year of birth from the user.
//
// Parameters:    None 
//
// Return values: input: the correct input from the user(positive int) 
//
***************************************************************************/
int getyearofbirth(){
    #ifdef DEBUGMODE
        cout << endl;
        cout << "**DEBUGMODE** FUNCTION CALLED: getyearofbirth() **DEBUGMODE**" << endl;
        cout << "**DEBUGMODE** NO PARAMETERS **DEBUGMODE**" << endl;
        cout << endl;
    #endif

    int input = 0;

    while(1)
    {
        cin >> input;
        if(input > 0)
        {
            break;
        }
        else
        {
            cout << "That is an invalid year of birth, please re-enter as a positive number: " << endl;
            cin.clear();
            cin.ignore(INT_MAX, '\n');
        }
    } 
    return input;
}
/***************************************************************************
//
// Function Name: getaccountnum
//
// Description:   A function which gets the account number from the user. 
//
// Parameters:    None 
// 
// Return values: input: the input from the user that is correct(pos int) 
//
***************************************************************************/
int getaccountnum(){
    #ifdef DEBUGMODE
        cout << endl;
        cout << "**DEBUGMODE** FUNCTION CALLED: getaccountnum() **DEBUGMODE**" << endl;
        cout << "**DEBUGMODE** NO PARAMETERS **DEBUGMODE**" << endl;
        cout << endl;
    #endif

    int input = 0;

    while(1)
    {
        cin >> input;
        if(input > 0)
        {
            break;
        }
        else
        {
            cout << "That is an invalid account number, please re-enter as a positive number: " << endl;
            cin.clear();
            cin.ignore(INT_MAX, '\n');
        }
    } 
    return input;
}
