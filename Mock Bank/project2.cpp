/***************************************************************************
//
// Name:          Sae Hyun Song
// 
// Homework:      Project 2 
// 
// Class:         ICS212
//
// Instructor:    Ravi Narayan
//
// Date:          November 29, 2016
// 
// File:          project2
//
// Description:   This file contains the driver function for the database,
//                as well as using compiler directive/preprocessing to make
//                it run in debugmode or not.
//
****************************************************************************/
#include <iostream>
#include <iomanip>
#include <string>
#include "record.h"
#include "llist.h"
using namespace std;

int getyearofbirth();
int getaccountnum();

/****************************************************************************
//
// Function Name:    main
//
// Description:      A driver which prints the menu of selections and shows
//                   whether it is in debugmode or not depending on the 
//                   preprocessor directives. It will run until exit program
//                   key has been pressed.
//
// Parameters:       argc(int): The size of command line argument in array
//                   argv(char* []): The array of command line arguments.
// 
// Return Values:    0: To exit the int main function.
//
****************************************************************************/

int main(int argc, char * argv[])
{
    int input = 0;
    int accountnumber = 0;
    int yearofbirth = 0;
    string name = "";
    string address = "";

    char welcome[] = "Welcome! What would you like to do today?";
    char opt1[] = "1 => Add a new record in the database.";
    char opt2[] = "2 => Modify a record in the database.";
    char opt3[] = "3 => Print information about a record."; 
    char opt4[] = "4 => Print all information in the database.";
    char opt5[] = "5 => Delete an existing record in the database.";
    char opt6[] = "6 => Reverse the order of the database! (Recursively)"; 
    char opt7[] = "7 => Quit the program.";

    llist * linkedlist = new llist();

    if(argc == 1)
    {
        if(string(argv[0]) == "./project2" || string(argv[0]) == "./project2debug")    
        {
            while(input != 7)
            {
                input = 0;
                cout << endl;
                cout << "***********************************************************************" << endl;
                #ifdef DEBUGMODE
                    cout << "~~~~~~~~~~~~~~~~~~~~~~~~~DEBUG MODE ACTIVATED~~~~~~~~~~~~~~~~~~~~~~~~~~" << endl;
                #endif
                cout << endl;
                cout << welcome << endl;
                cout << endl;
                cout << opt1 << endl;
                cout << opt2 << endl;
                cout << opt3 << endl;
                cout << opt4 << endl;
                cout << opt5 << endl;
                cout << opt6 << endl;
                cout << opt7 << endl;
                cout << "\n";
                cout << "Please enter the corresponding number to the option given (1~7): " << endl;
                cin >> input;
                cout << endl;
                cout << "***********************************************************************"; 
                while(1)
                {
                    if(input > 0 && input <= 7)
                    {
                        break;
                    }
                    else
                    {
                        cin.clear();
                        cin.ignore(INT_MAX, '\n');
                        cout << "\n";
                        cout << welcome << endl;
                        cout << opt1 << endl;
                        cout << opt2 << endl;
                        cout << opt3 << endl;
                        cout << opt4 << endl;
                        cout << opt5 << endl;
                        cout << opt6 << endl;
                        cout << opt7 << endl;
                        cout << "\n";
                        cout << "Please re-enter the corresponding number to the option given (1~7): " << endl;
                        cin >> input;
                        cout << endl;
                    }
                }
                switch(input)
                {
                    case 1:
                        cout << endl;
                        cout << "You have chosen to add a new record!" << endl;
                        cout << endl;
                        
                        cout << "Please enter your account number: " << endl;
                        accountnumber = getaccountnum();
                        cin.clear();
                        cin.ignore(INT_MAX, '\n');
                        cout << endl;
  
                        cout << "Please enter your name: " << endl;
                        getline(cin, name);
                        cout << endl;
 
                        cout << "Please enter your address, type '!' when you are finished entering your address: " << endl;
                        getline(cin, address, '!');
                        cout << endl;
                        
                        cout << "Finally please enter your year of birth to complete adding a record: " << endl;
                        yearofbirth = getyearofbirth();
                        cin.clear();
                        cin.ignore(INT_MAX, '\n');
                        cout << endl;
   
                        linkedlist->addRecord(accountnumber, name, address, yearofbirth);
                       
                        break;
                    case 2:
                        cout << endl;
                        cout << "You have chosen to modify a record in the database!" << endl;
                        cout << endl;
                        
                        cout << "Please enter your account number: " << endl;
                        accountnumber = getaccountnum();
                        cin.clear();
                        cin.ignore(INT_MAX, '\n');
                        cout << endl;
 
                        cout << "Please enter your new address, type '!' when you are finished entering your address: " << endl;
                        getline(cin, address, '!');
                        cout << endl;

                        linkedlist->modifyRecord(accountnumber, address);
                        break;
                    case 3:
                        cout << endl;
                        cout << "You have chosen to print information about a record!" << endl;
                        cout << endl;
                        
                        cout << "Please enter your account number: " << endl;
                        accountnumber = getaccountnum();
                        cin.clear();
                        cin.ignore(INT_MAX, '\n');
                        cout << endl;
             
                        linkedlist->printRecord(accountnumber);
                        
                        break;
                    case 4:
                        cout << endl;
                        cout << "You have chosen to print all the information in the database!" << endl;
                        cout << endl;

                        cout << *linkedlist;
                        break;
                    case 5:
                        cout << endl;
                        cout << "You have chosen to delete an existing record in the database!" << endl;
                        cout << endl;

                        cout << "Please enter your account number: " << endl;
                        accountnumber = getaccountnum();
                        cin.clear();
                        cin.ignore(INT_MAX, '\n');

                        linkedlist->deleteRecord(accountnumber);

                        break;
                    case 6:
                        cout << endl;
                        cout << "You have chosen to reverse the database recursively!" << endl;
                        cout << endl;
      
                        linkedlist->reverse();

                        break;
                    case 7:
                        cout << endl;
                        cout << "You have chosen to quit the program!" << endl;
                        cout << endl;

                        break;
                    default:
                        break;
                } 
            }
        }
        else
        {
            cout << "The executable name must be project2 or project2debug." << endl;
        }
    }
    delete(linkedlist);
    return 0;
}
  

/****************************************************************************
//
// Function Name:    operator overloader <<  
//
// Description:      A function that overloads the << operator so that it
//                   prints all the records in the linked list without
//                   having to call linkedlist->printAll(); 
//
// Parameters:       os(ostream &): The operator. 
//                   list(lllist &): The linked list. 
// 
// Return Values:    os: The operator. 
//
****************************************************************************/

ostream & operator << (ostream& os, llist& list)
{
    #ifdef DEBUGMODE
        cout << "**DEBUGMODE** OPERATOR OVERLOAD FUNCTION CALLED **DEBUGMODE**" << endl;
        cout << "**DEBUGMODE** OSTREAM PARAMETER = " << "cout" << " **DEBUGMODE**" << endl;
        cout << "**DEBUGMODE** LLIST PARAMETER = " << "list" << " **DEBUGMODE**" << endl;
    #endif

    struct record *curr = list.start;

    if(list.start == NULL)
    {
        os << "There are no existing records in the database!" << endl;
    }
    else
    {
        while(1)
        {
            if(curr != NULL)
            {
                os << endl;
                os << "The account number of the current record is: " << curr->accountno << endl;
                os << "The name of the current record is: " << curr->name << endl;
                os << "The address of the current record is: " << curr->address << endl;
                os << "The year of birth of the current record is: " << curr->yearofbirth << endl;
                os << endl;
                curr = curr->next;
            }
            else
            {
                break;
            }
            os << "All of the records have been successfully printed! Thank you!" << endl;
        }
    }
    return os;
}
