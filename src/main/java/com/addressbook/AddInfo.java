package com.addressbook;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/*Create a dictionary and add multiple address book in it.
 * Inside those address book add contact details in it and also can delete the contact details
 * from that same address book.
 * After that we can edit the content of the same address book and also can display the content
 * of the dictionary as well as of the address books*/

public class AddInfo implements AddInfoIF {
    Scanner sc= new Scanner(System.in);
    Scanner scanner = new Scanner(System.in);

    HashMap<String,AddressBook> addressBookHashMap=new HashMap<String,AddressBook>();
    HashMap<String,AddInfo> addressBookDictionary=new HashMap<String,AddInfo>();
    public String addressBookName;
    boolean present=false;

    public ArrayList<AddressBook> getContact() {
        return new ArrayList<AddressBook>(addressBookHashMap.values());
    }
    public String getAddressBookName(){
        return addressBookName;
    }
    public void setAddressBookName(String addressBookName){
        this.addressBookName=addressBookName;
    }

    @Override
    public void operations(){
        //call every method related to address book to perform multiple operations in the address books.
        boolean changes = true;

        do{
            System.out.println("\nChoose the operation you want to perform");
            System.out.println("1.Add To Address Book\n2.Edit Existing Entry\n3.Delete Contact\n4.Display Contact\n5.Exit Address book System");
            switch (sc.nextInt()){

                case 1:
                    addContact();
                    break;
                case 2:
                    editPerson();
                    break;
                case 3:
                    deletePerson();
                    break;
                case 4:
                    display();
                    break;
                case 5:
                    changes = false;
                    System.out.println("We are exiting");
            }

        }while (changes);

    }

    @Override
    public void addContact(){
//        to add contact details in the address book.
        AddressBook addressBook=new AddressBook();
        System.out.println("Enter First Name: ");
        String firstname = sc.next();
        addressBookHashMap.entrySet().stream().forEach(entry ->{
            if(entry.getKey().equals(firstname.toLowerCase())){
                System.out.println("Already exist");
                present=true;
                return;
            }
        });
        if(present==false){
            System.out.println("Enter last Name: ");
            String lastname = sc.next();
            System.out.println("Enter Address: ");
            String adderss = sc.next();
            System.out.println("Enter City: ");
            String city = sc.next();
            System.out.print("Enter State: ");
            String state = sc.next();
            System.out.print("Enter Zip Code: ");
            int zip = sc.nextInt();
            System.out.print("Enter Phone Number: ");
            long phoneNumber = sc.nextLong();
            System.out.println("Enter Email: ");
            String email = sc.next();

            addressBook.setFirstName(firstname);
            addressBook.setLastName(lastname);
            addressBook.setAddress(adderss);
            addressBook.setCity(city);
            addressBook.setState(state);
            addressBook.setZip(zip);
            addressBook.setPhoneNumber(phoneNumber);
            addressBook.setEmail(email);
            addressBookHashMap.put(firstname.toLowerCase(),addressBook);
        }
    }
    @Override
    public void editPerson(){
//        edit contents in the address book.
        AddressBook addressBook=new AddressBook();
        System.out.println("Enter First name: ");
        String firstName=sc.next();
        if(addressBookHashMap.containsKey(firstName)) {
            addressBook = addressBookHashMap.get(firstName);
            System.out.println("Choose attribute you want to change:");
            System.out.println("1.First Name\n2.Last Name\n3.Address\n4.City\n5.State\n6.ZipCode\n7.Phone Number\n8.Email");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the correct first Name :");
                    firstName = sc.next();
                    addressBook.setFirstName(firstName);
                    break;
                case 2:
                    System.out.println("Enter the correct Last Name :");
                    String lastName = sc.next();
                    addressBook.setLastName(lastName);
                    break;
                case 3:
                    System.out.println("Enter the correct Address :");
                    String address = sc.next();
                    addressBook.setAddress(address);
                    break;
                case 4:
                    System.out.println("Enter the correct City :");
                    String city = sc.next();
                    addressBook.setCity(city);
                    break;
                case 5:
                    System.out.println("Enter the correct State :");
                    String state = sc.next();
                    addressBook.setState(state);
                    break;
                case 6:
                    System.out.println("Enter the correct Zip Code :");
                    int zip = sc.nextInt();
                    addressBook.setZip(zip);
                    break;
                case 7:
                    System.out.println("Enter the correct Phone Number :");
                    long phoneNumber = sc.nextLong();
                    addressBook.setPhoneNumber(phoneNumber);
                    break;
                case 8:
                    System.out.println("Enter the correct Email :");
                    String email = sc.next();
                    addressBook.setEmail(email);
                    break;
            }
        }
    }

    @Override
    public void deletePerson(){
//        delete content form the address book.
        System.out.println("Enter the first name of the person to be deleted");
        String firstName = sc.next();
        if(addressBookHashMap.containsKey(firstName)){
            addressBookHashMap.remove(firstName);
            System.out.println("Contact deleted");
        }
        else {
            System.out.println("Contact not found");
        }
    }

    @Override
    public void display(){
//        To display the content of address book.
        System.out.println("Contents of Address Book");
        for (String contact : addressBookHashMap.keySet()){
            AddressBook addressBook=addressBookHashMap.get(contact);
            System.out.println(addressBook);
        }

    }
    public void addAddressBook() {
//        To add multiple address book in the dictionary.
        System.out.println("Enter name of address book");
        String addressBookName = scanner.next();
        if (addressBookDictionary.containsKey(addressBookName)) {
            System.out.println("Address Book already exist");
            return;
        }
        AddInfo addInfo = new AddInfo();
        addInfo.setAddressBookName(addressBookName);
        addressBookDictionary.put(addressBookName,addInfo);

    }
    public void editAddressBook(){
//        To edit the content from address book.
        System.out.println("Enter name of address book you wanna edit");
        String addressBookName=scanner.next();
        if(addressBookDictionary.containsKey(addressBookName)){
            addressBookDictionary.get(addressBookName);
        }
        else{
            System.out.println("Book doesn't exist");
        }
    }
    public void displayContent(){
//        to display the content of the dictionary.
        System.out.println("Content of address book dictionary");
        for (String bookName : addressBookDictionary.keySet()){
            System.out.println(bookName);
        }
    }
    public void searchContent(){
//        to search the content of address book from dictionary.
        System.out.println("Enter name of address book you wanna search");
        String addressBookName=scanner.next();
        if(addressBookDictionary.containsKey(addressBookName)){
            System.out.println("Enter name of city");
            String city=sc.next();
            Stream<Map.Entry<String, AddressBook>> entryStream = addressBookHashMap.entrySet().stream()
                    .filter(entry -> entry.getKey().equals(city.toLowerCase()));
            System.out.println(addressBookHashMap);
            long count = addressBookHashMap.entrySet().stream()
                    .filter(entry -> entry.getKey().equals(city.toLowerCase()))
                    .count();
            System.out.println(count);

        }
        else{
            System.out.println("Book doesn't exist");
        }
    }
    public void searchContentByState(){
//        to search the content using city from address book.
        System.out.println("Enter name of address book you wanna search");
        String addressBookName=scanner.next();
        if(addressBookDictionary.containsKey(addressBookName)){
//            to check whether book exist or not
            System.out.println("Enter name of city");
            String state=sc.next();
            Stream<Map.Entry<String, AddressBook>> entryStream = addressBookHashMap.entrySet().stream().filter(entry -> entry.getKey().equals(state.toLowerCase()));
            System.out.println(addressBookHashMap);
        }
        else{
            System.out.println("Book doesn't exist");
        }
    }
    public void sortAddressBook(){
        List<AddressBook> sortedList = addressBookHashMap.values().stream()
                .sorted(Comparator.comparing(AddressBook::getFirstName))
                .collect(Collectors.toList());
        System.out.println("Sorted Address Book "+this.getAddressBookName());
        Iterator iterator=sortedList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    public void writeData() {
        File file = new File("C:\\Users\\Lenovo\\IdeaProjects\\AddressBookGradle\\src\\AddressBook.txt");
        BufferedWriter bufferedWriter=null;
        try {
            bufferedWriter=new BufferedWriter(new FileWriter(file));
            for(Map.Entry<String, AddressBook> entryStream:addressBookHashMap.entrySet()){
                bufferedWriter.write(entryStream.getKey()+ " : "+entryStream.getValue());
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void operationDictionary() {
//        call every method related to address book dictionary to perform multiple operations in the address books.
        boolean changes = true;
        do {
            System.out.println("\nChoose the operation you want to perform");
            System.out.println("1.Add Address Book\n2.Edit Entry of Existing address book\n3.Display Contact\n4.Search content in addressbook\n5.Sort address book by name\n6.Write data to file\n7.Exit Address book System");
            switch (scanner.nextInt()) {
                case 1:
                    addAddressBook();
                    addContact();
                    break;
                case 2:
                    editAddressBook();
                    editPerson();
                    break;
                case 3:
                    displayContent();
                    display();
                    break;
                case 4:
                    searchContent();
                    break;
                case 5:
                    sortAddressBook();
                    break;
                case 6:
                    writeData();
                    break;
                case 7:
                    changes = false;
                    System.out.println("We are exiting");
            }
        } while (changes);
    }
}
