# Bank-Management-System
The Bank Management System is a Java-based application that provides a comprehensive solution for managing banking operations. It is designed to simplify and automate various banking processes, such as customer account management, transaction processing, and reporting. This README file provides an overview of the project, its features, and instructions for setting up and running the application.

# Features
# Login:
Users can log in to the system using their credentials. The login page verifies the username and password against the stored user data in the database.

# Signup:
New users can create an account by providing their personal information, such as name, address, contact details, and choosing a username and password.

# Additional Details:
After signing up, users are prompted to provide additional details, such as their occupation, income, and identification documents. This information is stored securely and can be used for future reference or verification.

# Account Details:
Users can view their account details, including their account number, account type, and current balance. This page provides an overview of the user's financial status.

#Change PIN:
Users can change their PIN (Personal Identification Number) for added security. This page prompts users to enter their current PIN and then allows them to set a new PIN.

# Balance Enquiry:
Users can check the current balance of their account by selecting the balance enquiry option. The system retrieves the account balance from the database and displays it on the screen.

# Amount Withdrawal:
Users can initiate a withdrawal by specifying the amount they want to withdraw from their account. The system validates the withdrawal amount and deducts it from the account balance.

# Amount Deposit:
Users can deposit funds into their account by specifying the amount to be deposited. The system validates the deposit amount and adds it to the account balance.

# Database Connection:
The Connect class handles the database connection and interaction. It establishes a connection with the database and provides methods for executing SQL queries and updating the data.

# Getting Started
To set up and run the Bank Management System, follow these steps:

# 1.Prerequisites: 
Ensure that you have Java Development Kit (JDK) installed on your system. The application is developed using Java, so JDK is required for compilation and execution and MySql connector JAR wwhich is already presnent in the repository.

# 2.Download: 
Download the project files from the GitHub repository [https://github.com/Kabirsharma2607/Bank-Management-System].

# 3.Compilation: 
Open a terminal or command prompt and navigate to the project directory. Compile the Java source files using the following command:

javac Main.java

# 4.Execution: 
Once the compilation is successful, run the application using the following command:

java Main

# 5.Interacting with the Application: 
The Bank Management System provides a GUI for interacting with the application. Follow the on-screen prompts to navigate through the available options and perform various banking operations.

# Project Structure
The project directory structure is organized as follows:

# Main.java: 
The main entry point of the application. It contains the main method and initializes the GUI.

# Login.java:
Handles the login functionality. It verifies the user's credentials and grants access to the system.

# Signup1.java:
Manages the signup process. It collects user information and creates a new account in the database.

# Signup2.java:
Prompts the user to provide additional details after signup. It securely stores the information for future reference.

# Signup3.java: 
Displays the account details, including the account number, type, and current balance.

# ChangePIN.java:
Allows the user to change their PIN for added security. It verifies the current PIN and updates it with a new one.

# BalanceEnquiry.java:
Retrieves the account balance from the database and displays it to the user.

# AmountWithdrawal.java:
Handles the process of withdrawing funds from the user's account. It validates the withdrawal amount and updates the account balance accordingly.

## AmountDeposit.java:
Manages the process of depositing funds into the user's account. It validates the deposit amount and updates the account balance.

# Connect.java:
Establishes a connection with the database and provides methods for executing SQL queries and updating the data.

## Contributing
Contributions to the Bank Management System project are welcome! If you encounter any issues or have suggestions for improvements, please submit them via E-Mail.[kabirsharma2607@gmail.com] You can also fork the repository, make your changes, and submit a pull request for review.

## License
Feel free to use, modify, and distribute the application as per the terms of the license.

## Acknowledgments
I would like to express gratitude to Mr. Arvind Kumar under whose guidance I was able to complete the project. Thank YOU!
