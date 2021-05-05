package lesson3;

import java.util.*;

public class Lesson3 {
    public static void main(String[] args) {

        List<String> gorodaSibiri = new ArrayList<>(Arrays.asList("Барнаул","Новосибирск","Томск",
                "Красноярск","Екатеринбург","Барнаул","Кемерово",
                "Новокузнецк","Новосибирск", "Барнаул", "Иркутск"));
        Set<String> unique = new HashSet<>(gorodaSibiri);
        System.out.println(unique);
        for (String key : unique) {
            System.out.println(key + ": " + Collections.frequency(gorodaSibiri, key));
        }

        System.out.println("__________________________");

        Phonebook phonebook = new Phonebook();

        phonebook.add(1111111, "Ukolov");
        phonebook.add(2222222, "Sokolov");
        phonebook.add(3333333, "Petrov");
        phonebook.add(4444444, "Sokolov");
        phonebook.add(5555555, "Sidorov");
        phonebook.add(6666666, "Ukolov");

        phonebook.get("Ukolov");
        phonebook.get("Sokolov");
        phonebook.get("Petrov");
        phonebook.get("Sidorov");
        phonebook.get("Dyrov");
    }
}