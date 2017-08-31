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
// File:        llist.cpp
//
// Description: A class file that contains function definitions for all the
//              class member functions, including the constructor and dest-
//              ructor. The constructor will initialize the class variables
//              while the destructor will deallocate the entire linked list.
//
***************************************************************************/

#include "llist.h"
#include "record.h"
#include "cstddef"
#include <iostream>
#include <string>
#include <iomanip>
#include <fstream>
using namespace std;

/***************************************************************************
//
// Function Name: llist() 
//
// Description:   A constructor that will initialize the class variables. 
//
// Parameters:    None 
//
// Return values: None 
//
***************************************************************************/

llist::llist()
{
    #ifdef DEBUGMODE
        cout << endl;
        cout << "**DEBUGMODE** CONTRUCTOR CALLED: llist() **DEBUGMODE**" << endl;
        cout << "**DEBUGMODE** NO PARAMETERS **DEBUGMODE**" << endl;
        cout << endl;
    #endif

    this->start = NULL; 
    this->filename = "database.txt";
    this->readfile();
}

/***************************************************************************
//
// Function Name: llist(string filename) 
//
// Description:   A constructor that will initialize the class variables.
//                Also takes in a paramter which will initialize the file
//                name member variable and assign it to whatever parameter
//                was passed.
//
// Parameters:    string filename: The name of the file to be read from .
//
// Return values: None 
//
***************************************************************************/

llist::llist(string filename)
{
    #ifdef DEBUGMODE
        cout << endl;
        cout << "**DEBUGMODE** CONTRUCTOR CALLED: llist() **DEBUGMODE**" << endl;
        cout << "**DEBUGMODE** STRING PARAMETER = " << filename << " **DEBUGMODE**" << endl;
        cout << endl;
    #endif

    this->start = NULL;
    this->filename = filename;
    this->readfile();
}

/***************************************************************************
//
// Function Name: ~llist()
//
// Description:   A Destructor that will deallocate the entire linked list
//                and also write the records in the linked list into the 
//                database.txt file.  
//
// Parameters:    None
//
// Return values: None 
//
***************************************************************************/

llist::~llist()
{
    #ifdef DEBUGMODE
        cout << endl;
        cout << "**DEBUGMODE** DESTRUCTOR CALLED: ~llist() **DEBUGMODE**" << endl;
        cout << "**DEBUGMODE** NO PARAMETERS **DEBUGMODE**" << endl;
        cout << endl;
    #endif

    struct record *curr = this->start;

    this->writefile();
    cout << "Records have been successfully written to the database.txt file!" << endl;
    cout << endl;

    while(curr != NULL)
    {
        delete(curr);
        curr = curr->next;
    }
}

/***********************************************************************************************
//
// Function Name:    addRecord
// 
// Description:      An addRecord method that reads in the parameters and adds the record to
//                   the linked list starting from the pointer start, if the year of birth is 
//                   less than or equal to the current year of birth, it will add it to the next
//                   pointer of the current year of birth (right), if it is greater than, it will
//                   add it to the front of the current record (left).
//
//Parameters:        accountno(int): The account number associated with the database.
//                   name (string): The name of the user.
//                   address (string): The address of the user.
//                   yearofbirth(int): The birth year of the user.
//
// Return Values:    0: void 
//
***********************************************************************************************/

int llist::addRecord(int accountnumber, string name, string address, int yearofbirth)
{
    #ifdef DEBUGMODE
        cout << endl;
        cout << "**DEBUGMODE** FUNCTION CALLED: addRecord **DEBUGMODE**" << endl;
        cout << "**DEBUGMODE** INT PARAMETER = " << accountnumber << " **DEBUGMODE**" << endl;
        cout << "**DEBUGMODE** STRING PARAMETER = " << name << " **DEBUGMODE**" << endl;
        cout << "**DEBUGMODE** STRING PARAMETER = " << address << " **DEBUGMODE**" << endl;
        cout << "**DEBUGMODE** INT PARAMETER = " << yearofbirth << " **DEBUGMODE**" << endl;
        cout << endl;
    #endif

    struct record *new_record,*curr, * prev; 

    new_record = new record;
    new_record->accountno = accountnumber;
    new_record->name = name;
    new_record->address = address;
    new_record->yearofbirth = yearofbirth;
    new_record->next = NULL;
    
    int inserted = 0;
    if(this->start == NULL)
    {
        this->start = new_record;
        curr = this->start;
        cout << "You record has been successfully added to the database!" << endl;
    }
    else
    {
        curr = this->start;
        prev = curr;
        while(inserted != 1)
        {
            if(yearofbirth <= curr->yearofbirth)
            {
                if(curr->next == NULL)
                {
                    curr->next = new_record;
                    inserted = 1;
                }
                else
                {
                    prev = curr;
                    curr = curr->next;
                }
            }
            else
            {
                if(curr == this->start)
                {
                    new_record->next = this->start;
                    this->start = new_record;
                }
                else
                {
                    new_record->next = curr;
                    prev->next = new_record;
                }
                inserted = 1;
            }
        } 
        cout << "You record has been successfully added to the database!" << endl;
    }
    return 0;
}

/***********************************************************************************************
//
// Function Name:    printRecord
// 
// Description:      A printRecord method that prints all records with the matching accountno.
// Parameters:       accountnumber(int): The account number associated with the account in the database.
//
// Return Values:    recordfound: returns the number of records found.
//
***********************************************************************************************/

int llist::printRecord(int accountnumber)
{
    #ifdef DEBUGMODE
        cout << endl;
        cout << "**DEBUGMODE** FUNCTION CALLED: printRecord **DEBUGMODE**" << endl;
        cout << "**DEBUGMODE** INT PARAMETER = " << accountnumber << " **DEBUGMODE**" << endl;
        cout << endl;
    #endif

    struct record *curr;
    int recordfound = 0;
    
    if(this->start == NULL)
    {
        cout << "There are no existing records in the database!";
    }
    else
    {
        curr = this->start;
        while(curr != NULL)
        {
            if(curr->accountno == accountnumber)
            {
                cout << "The item exists in the database!" << endl;
                cout << "The account number of the chosen record is: " << curr->accountno << endl;
                cout << "The name of the chosen record is " << curr->name << endl;
                cout << "The address of the chosen record is: " << curr->address << endl;
                cout << "The year of birth of the chosen record is: " << curr->yearofbirth << endl;
                cout << endl; 
                recordfound ++;
            }
            curr = curr->next;
        } 
        if(recordfound == 0)
        {
            cout << "The account number does not exist in the database!" << endl;
        }
        else
        {
            cout << "Number of records successfully printed: " << recordfound << endl;
        }
    }
    return recordfound; 
}


/***********************************************************************************************
//
// Function Name:    modifyRecord
// 
// Description:      A function which will modify all records with the matching account number to
//                   the new address the user inputs.
//
// Parameters:       accountno(int): The account number associated with the database.
//                   newaddress (string): The new address the user would like to change to. 
//
// Return Values:    0: void
//
***********************************************************************************************/

int llist::modifyRecord(int accountnumber, string newaddress)
{
    #ifdef DEBUGMODE
        cout << endl;
        cout << "**DEBUGMODE** FUNCTION CALLED: modifyRecord **DEBUGMODE**" << endl;
        cout << "**DEBUGMODE** INT PARAMETER = " << accountnumber << " **DEBUGMODE**" << endl;
        cout << "**DEBUGMODE** STRING PARAMETER = " << newaddress << " **DEBUGMODE**" << endl;
        cout << endl;
    #endif
    struct record *curr = this->start;
    int modified = 0;
    
    if(this->start == NULL)
    {
        cout << "There are no existing records in the database." << endl;
    }
    else
    {
        while(curr != NULL)
        {
            if(curr->accountno == accountnumber)
            {
                curr->address = newaddress;
                modified++;
            }
            curr = curr->next;
        }
        if(modified == 0)
        {
            cout << "The account number does not exist in the database!" << endl;
        }
        else
        {
            cout << "Number of records successfully modified: " << modified << endl;
        }
    }
    return 0;
}


/***********************************************************************************************
//
// Function Name:    printAll
// 
// Description:      An printAll method that prints all the records in the database.
//
// Parameters:       None
//
// Return Values:    None: void 
//
***********************************************************************************************/

void llist::printAll()
{
    #ifdef DEBUGMODE
        cout << endl;
        cout << "**DEBUGMODE** FUNCTION CALLED: printAll() **DEBUGMODE**" << endl;
        cout << "**DEBUGMODE** NO PARAMETERS **DEBUGMODE**" << endl;
        cout << endl;
    #endif

    struct record *curr;
    if(this->start == NULL)
    {
        cout << "There are no existing records in the database!" << endl;
    } 
    else
    {
        curr = this->start;
        while(1)
        {
            if(curr != NULL)
            {
                cout << "The account number of the current record is: " << curr->accountno << endl;
                cout << "The name of the current record is: " << curr->name << endl;
                cout << "The address of the current record is: " << curr->address << endl;
                cout << "The year of birth of the current record is: " << curr->yearofbirth << endl;
                cout << endl;
                curr = curr->next;
            }
            else
            {
                break;
            }
        }
        cout << "All the records have been successfully printed! Thank you!" << endl;
    }
}


/***********************************************************************************************
//
// Function Name:    deleteRecord
// 
// Description:      An deleteRecord method that deletes all records associated with the
//                   accountnumber.
//
// Parameters:       accountno(int): The account number associated with the database.
//
// Return Values:    0: 
//
***********************************************************************************************/

int llist::deleteRecord(int accountnumber)
{
    #ifdef DEBUGMODE
        cout << endl;
        cout << "**DEBUGMODE** FUNCTION CALLED: deleteRecord **DEBUGMODE**" << endl;
        cout << "**DEBUGMODE** INT PARAMETER = " << accountnumber << " **DEBUGMODE**" << endl;
        cout << endl;
    #endif

    struct record *curr, *temp, *prev;
    curr = this->start;
    
    if(this->start == NULL)
    {
        cout << "There is no existing records in the database!" << endl;
    }
    else
    {
        while(curr != NULL)
        {
            if(curr->accountno == accountnumber)
            {
                if(curr == this->start)
                {
                    temp = (this->start)->next;
                    free(this->start);
                    this->start = temp;
                }
                else
                {
                    prev->next = curr->next;
                    free(curr);
                    curr = prev;
                }
            }
            prev = curr;
            curr = curr->next;
        }
    }
    return 0;
}

/***********************************************************************************************
//
// Function Name:    reverse
// 
// Description:      An reverse method that reverses the linked list's pointers.
//
// Parameters:       None
//
// Return Values:    None: void 
//
***********************************************************************************************/

void llist::reverse()
{
    #ifdef DEBUGMODE
        cout << endl;
        cout << "**DEBUGMODE** FUNCTION CALLED: reverse() **DEBUGMODE**" << endl;
        cout << "**DEBUGMODE** NO PARAMETERS **DEBUGMODE**" << endl;
        cout << endl;
    #endif

    reverse(this->start);
}

/***********************************************************************************************
//
// Function Name:    reverse 
// 
// Description:      A reverse method that reversed the order of the linked list's pointers
//                   iteratively. Was not able to figure out the recursive way.
//
// Parameters:       start(struct record *): The address of the starting address. 
//
// Return Values:    start: A struct record * of start.
//
***********************************************************************************************/

struct record * llist::reverse(struct record * start)
{
    #ifdef DEBUGMODE
        cout << endl;
        cout << "**DEBUGMODE** FUNCTION CALLED: reverse **DEBUGMODE**" << endl;
        cout << "**DEBUGMODE** STRUCT RECORD PARAMETER = " << start << " **DEBUGMODE**" << endl;
        cout << endl;
    #endif

    struct record *next;
    struct record *prev = NULL;
    struct record *curr = this->start;
    
    if(this->start == NULL)
    {
        cout << "There is nothing in the database to reverse!" << endl;
    }
    else
    {
        while(curr != NULL)
        {
            next = curr->next;
            curr->next = prev;
            prev = curr; 
            curr = next;
        }
        this->start = prev;
    }
    return start;
}

/**************************************************************************************************
//
// Function Name:         readfile 
//
// Description:           A readfile function which reads in the the file name given and stores
//                        them into a linked list once the constructor is called.
// 
// Parameters:            None
//
// Return Values:         0: No use.
//
**************************************************************************************************/

int llist::readfile()
{
    #ifdef DEBUGMODE
        cout << endl;
        cout << "**DEBUGMODE** FUNCTION CALLED: readfile() **DEBUGMODE**" << endl;
        cout << "**DEBUGMODE** NO PARAMETERS **DEBUGMODE**" << endl;
        cout << endl;
    #endif

    string token;
    string name;
    string address;
    int yearofbirth;
    int accnum;
    int counter = 1;

    ifstream myfile; 
    myfile.open(this->filename.c_str());
    if(myfile.is_open())
    {
        cout << endl;
        cout << "Database successfully opened/read!" << endl;
    
        while(!myfile.eof())
        {
            myfile >> accnum;
            counter ++;
            getline(myfile, name);
            counter ++;
            getline(myfile, address, '!');
            counter ++;
            myfile >> yearofbirth; 
            counter ++;
        }

        counter = counter - 4;

        myfile.clear();
        myfile.seekg(0, ios::beg);

        for(int i = 1; i < counter; i++)
        {
            myfile >> accnum;
            i++;
            getline(myfile, name);
            i++;
            getline(myfile,address,'!');
            i++;
            myfile >> yearofbirth;
            this->addRecord(accnum, name, address, yearofbirth);
        }
    }
    else
    {
        cout << "The database file does not exist or is not in the current directory!" << endl;
    }
    myfile.close();

    return 0;
}

/**************************************************************************************************
//
// Function Name:         writefile 
//
// Description:           A writefile function which writes the records into database.txt
//                        when the destructor is called. 
// 
// Parameters:            None 
//
// Return Values:         0: No use. 
//
**************************************************************************************************/

int llist::writefile()
{
    #ifdef DEBUGMODE
        cout << endl;
        cout << "**DEBUGMODE** FUNCTION CALLED: writefile **DEBUGMODE**" << endl;
        cout << "**DEBUGMODE** NO PARAMETERS **DEBUGMODE**" << endl;
        cout << endl;
    #endif

    ofstream myfile;
    struct record *curr;
    curr = this->start;

    myfile.open(this->filename.c_str());
    
    if(myfile.is_open())
    {
        while(curr != NULL)
        {
            myfile << curr->accountno; 
            myfile << curr->name << endl;
            curr->address = curr->address + "!";
            myfile << curr->address << endl;
            myfile << curr->yearofbirth << endl;
            curr = curr->next;
        }
    }
    else
    {
        cout << "The database file does not exist or is not in the current directory!" << endl;
    }
    myfile.close();

    return 0;
}
