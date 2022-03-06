package ru.egorov.mavenHomework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        LOGGER.debug("Application started...");

        ContactsBook contactsBook = new ContactsBook();
        contactsBook.addContact(new Contact("John", "111"));
        contactsBook.addContact(new Contact("Liz", "34555"));
        contactsBook.addContact(new Contact("Bartholomew", "67235343"));
        contactsBook.addContact(new Contact("Lina", "123"));
        contactsBook.addContact(new Contact("Liz", "453"));
        contactsBook.addContact(new Contact("Jacob", "41111"));
        contactsBook.addContact(new Contact("Anna", "80111"));
        contactsBook.addContact(new Contact("Anna", "53915391"));

        LOGGER.debug(" Predicate \n-----------");
        contactsBook.searchBy(c -> c.getName().contains("Liz"));
        contactsBook.searchBy(c -> c.getPhone().contains("111"));

        LOGGER.debug(" String with or without *\n--------------------------");
        contactsBook.searchBy("J*");
        contactsBook.searchBy("Liz");
        contactsBook.searchBy("*na_2");
        contactsBook.searchBy("*na");
        contactsBook.searchBy("Bar*ew");

        LOGGER.debug("Application finished.");
    }
}
