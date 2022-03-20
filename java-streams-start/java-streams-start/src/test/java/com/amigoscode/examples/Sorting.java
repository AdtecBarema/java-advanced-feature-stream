package com.amigoscode.examples;

import com.amigoscode.beans.Car;
import com.amigoscode.beans.Person;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sorting {

    @Test
    public void sortingSteamOfElements () throws IOException {
        List <Person> people = MockData.getPeople ();
        List <String> sortedByFirstName = people.stream ()
                .map (Person::getFirstName)
                .sorted ().
                        collect (Collectors.toList ());
        System.out.println (sortedByFirstName);
        sortedByFirstName.forEach (System.out::println);
    }

    @Test
    public void sortingSteamOfElementsReverse () throws IOException {
        List <Person> people = MockData.getPeople ();
        Comparator <String> stringComparator = Comparator.reverseOrder ();
        List <String> sortedByFirstName = people.stream ()
                .map (Person::getFirstName)
                .sorted (stringComparator).
                        collect (Collectors.toList ());
        System.out.println (sortedByFirstName);
    }

    @Test
    public void sortingSteamOfObjets () throws IOException {
        List <Person> people = MockData.getPeople ();
        List <Person> sortedByFirstName = people.stream ().sorted (Comparator.comparing (Person::getFirstName)).collect (Collectors.toList ());
        sortedByFirstName.forEach (System.out::println);
        List <Person> sortedByFirstNameReverseOrder = people.stream ().sorted (Comparator.comparing (Person::getFirstName).reversed ()).collect (Collectors.toList ());
        sortedByFirstNameReverseOrder.forEach (System.out::println);
    }

    @Test
    public void topTenMostExpensiveBlueCars () throws IOException {
        List <Car> cars = MockData.getCars ();

        List <Car> topTenMostExpensiveBlueCars = cars.stream ()
                .filter (car -> car.getColor ().equalsIgnoreCase ("Blue"))
                .sorted (Comparator.comparing (Car::getPrice)).limit (10).collect (Collectors.toList ());
topTenMostExpensiveBlueCars.forEach (System.out::println);

    }
}
