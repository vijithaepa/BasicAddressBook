This contains the set of instructions required to build and run the Address Book application.

Contents :
==========
.
├── ReadMe.txt
└── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── addressbook
    │   │           ├── entity
    │   │           │   ├── AddressBook.java
    │   │           │   └── Contact.java
    │   │           ├── service
    │   │           │   ├── DirectoryService.java
    │   │           │   └── impl
    │   │           │       └── DirectoryServiceImpl.java
    │   │           ├── ui
    │   │           │   ├── AddressBookUI.form
    │   │           │   └── AddressBookUI.java
    │   │           └── util
    │   │               ├── AddressBookBuilder.java
    │   │               ├── ContactBuilder.java
    │   │               ├── DirectoryLoader.java
    │   │               ├── EntityBuilder.java
    │   │               └── PropertyLoader.java
    │   └── resources
    │       └── Directory.properties
    └── test
        ├── java
        │   └── com
        │       └── addressbook
        │           ├── AbstractTest.java
        │           ├── entity
        │           │   └── AddressBookTest.java
        │           ├── service
        │           │   └── DirectoryServiceTest.java
        │           └── util
        │               ├── AddressBookBuilderTest.java
        │               ├── ContactBuilderTest.java
        │               ├── DirectoryLoaderTest.java
        │               └── PropertyLoaderTest.java
        └── resources
            └── Directory.properties


Building the Project.
====================

Pre-requisites
--------------
JDK 1.7
Maven 2 or higher
set java_home and m2_home.

Steps:
------
1 - Unzip the BasicAddressBook.zip
2 - Go to the project home directory /BasicAddressBook/, and run 
    - mvn clean package
    - This might take a few seconds to download all the dependencies to your local M2 repo.
3 - To run the tests,
    - mvn clean test

Running the application.
========================

Go to target folder (/BasicAddressBook/target) and enter the command
	java -jar addressBook.jar

- Follow the prompts made by the application.

***Additional Information on run the application




