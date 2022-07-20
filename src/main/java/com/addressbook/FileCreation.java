package com.addressbook;

import java.io.File;
import java.io.IOException;

public class FileCreation {
    public void createFile() {
//        path has been given for file creation.
        File file=new File("C:\\Users\\Lenovo\\IdeaProjects\\AddressBookGradle\\src\\AddressBook.txt");
        try{
            if(file.createNewFile()){
                System.out.println("File created: "+file.getName());
            }else {
                System.out.println("File exist: "+file.getName());
            }
        }catch (IOException e){
            System.out.println("Error is: "+ e);
        }

    }
}
