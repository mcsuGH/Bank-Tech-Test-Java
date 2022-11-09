# Bank Tech Test
For a practice tech test, I have been tasked to create a Bank Account system that allows people to deposit money, withdraw money and print their bank statement.\
\
The program will be created with Java and will not need to have a Command Line Interface. 

## Instructions
Clone this repository using `git clone https://github.com/mcsuGH/Bank-Tech-Test-Java.git`
\
\
Ensure you have a JVM installed such as [Java 17 LTS](https://www.oracle.com/java/technologies/downloads/#jdk17-mac) and then run `gradle` to install any dependencies.
\
\
To use the program, open the project in an IDE such as VSCode or IntelliJ and open the file `app/src/main/java/bank/Bank.java` to then run the project.
\
\
Example of my code running:
![Screenshot](https://i.imgur.com/SG71owX.png)

## Specification
### Requirements
* You should be able to interact with your code via a REPL like IRB or Node.  (You don't need to implement a command line interface that takes input from STDIN.)
* Deposits, withdrawal.
* Account statement (date, amount, balance) printing.
* Data can be kept in memory (it doesn't need to be stored to a database or anything).

### Acceptance criteria
**Given** a client makes a deposit of 1000 on 10-01-2012  
**And** a deposit of 2000 on 13-01-2012  
**And** a withdrawal of 500 on 14-01-2012  
**When** she prints her bank statement  
**Then** she would see

```
date || credit || debit || balance
14/01/2012 || || 500.00 || 2500.00
13/01/2012 || 2000.00 || || 3000.00
10/01/2012 || 1000.00 || || 1000.00
```

**Given** a client makes a deposit of 1000 on 10-01-2012  
**And** a deposit of 2000 on 13-01-2012  
**And** a withdrawal of 500 on 14-01-2012  
**When** she prints her bank balance 
**Then** she would see

```
Current Balance: £2500.00
```

## User Stories from Specification
```
As a Client,
So that my money can be stored safely,
I would like to be able to deposit my money

As a Client,
So that I can use my money,
I would like to be able to withdraw my money

As a Client,
So that I can check the money in my account,
I would like to be able to print a bank statement 

As a Client,
So that I can see what happened to my money,
The statement should include the dates of when deposits and withdrawals were made aswell as the balance remaining

As a Client,
So that I can easily check the latest updates on my account,
The statement should show the most recent actions first

Possible Edge Cases:
As the Bank,
So that my customers do not overdraft,
I would like the customers to not be able to withdraw more money than they have

As the Bank,
So that my customers have valid balances,
I would like the customers to only be able to put in valid user inputs
```
