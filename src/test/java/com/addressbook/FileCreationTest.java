package com.addressbook;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

public class FileCreationTest {
    @Test
    public void givenPathWhenCheckConfirmIfFileExist(){
        File file=new File("C:\\Users\\Lenovo\\IdeaProjects\\AddressBookGradle\\src\\AddressBook.txt");
        boolean fileExist=file.exists();
        Assertions.assertTrue(fileExist);
    }
}
