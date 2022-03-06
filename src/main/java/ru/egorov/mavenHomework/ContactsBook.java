package ru.egorov.mavenHomework;

import java.util.*;
import java.util.function.Predicate;

public class ContactsBook {
    private Map<String, Contact> contacts = new HashMap<>();

    public void searchBy(Predicate<Contact> predicate) {
        List<Contact> contactList = new ArrayList<>(contacts.values());
        List<Contact> criteriaList = new ArrayList<>();

        for (Contact contact : contactList) {
            if (predicate.test(contact)) {
                criteriaList.add(contact);
            }
        }
        Collections.sort(criteriaList);
        System.out.println(criteriaList);
    }

    public void searchBy(String string) {
        List<String> list = Arrays.asList(string.split(""));

        if (!list.contains("*")) {
            searchBy(c -> c.getName().contains(string));
        } else {
            int i = list.indexOf("*");
            String sBeg = String.join("", list.subList(0, i));
            String sEnd = String.join("", list.subList(i + 1, list.size()));
            searchBy(c -> c.getName().startsWith(sBeg) && c.getName().endsWith(sEnd));
        }
    }

    public void addContact(Contact contact) {
        contacts.put(contact.getPhone(), contact);
    }

    public Contact getContact(Integer key) {
        return contacts.get(key);
    }

    public void deleteContact(Integer key) {
        contacts.remove(key);
    }

    public void showAllContactsSortedByList() {
        List<Contact> contactList = new ArrayList<>(this.contacts.values());
        Collections.sort(contactList);
        contactList.forEach(n -> System.out.println(n));
    }

    public void showAllContactsSortedByTreeSet() {
        SortedSet<Contact> sortedSet = new TreeSet<>(contacts.values());
        System.out.println(sortedSet.toString());
    }
    public void showAllContactsSortedByStream() {
        contacts.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
    }
}
