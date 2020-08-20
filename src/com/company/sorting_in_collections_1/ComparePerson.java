package com.company.sorting_in_collections_1;

import java.util.Comparator;

public class ComparePerson implements Comparator<Person> {
    @Override
    public int compare(Person person1, Person person2) {
        return person1.getAge() - person2.getAge();
    }
}
