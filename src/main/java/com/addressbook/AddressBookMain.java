package com.addressbook;

public class AddressBookMain {
    public static void main(String[] args) {

        System.out.println("Welcome to Address Book");
        AddInfo addressBookDictionary=new AddInfo();
        addressBookDictionary.operationDictionary();
        FileCreation fileCreation = new FileCreation();
        fileCreation.createFile();

    }

}
