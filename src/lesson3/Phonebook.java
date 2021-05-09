package lesson3;

import java.util.*;

public class Phonebook {

    private Map<Integer, String> book;
    Phonebook() {
        book = new HashMap<>();
    }
    public void add(int number, String surname) {
        book.put(number, surname);
    }
    public void get(String surname){
        if(book.containsValue(surname)) {
            Set<Map.Entry<Integer, String>> set = book.entrySet();
            for (Map.Entry<Integer, String> temp : set) {
                if(temp.getValue().equals(surname)) {
                    System.out.println(temp.getValue() + " : " + temp.getKey());
                }
            }
        } else {
            System.out.println("Фамилия не внесена в телефонную книгу");
        }
    }

}
