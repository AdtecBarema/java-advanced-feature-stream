package com.amigoscode.examples;

import com.amigoscode.beans.Car;
import com.amigoscode.beans.Person;
import com.amigoscode.beans.PersonDTO;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TransformationsMapAndReduce {

    @Test
    void yourFirstTransformationWithMap () throws IOException {
        List <Person> people = MockData.getPeople ();

        Function <Person, PersonDTO> personPersonDTOFunction = person -> {
            return new PersonDTO (
                    person.getId (),
                    person.getFirstName (),
                    person.getAge ()
            );
        };

        List <PersonDTO> personDTOList = people.stream ()
                .filter (person -> person.getAge () > 94)
                .filter (person -> person.getGender ().equals ("Male"))
                .map (PersonDTO::map).collect (Collectors.toList ());
        personDTOList.forEach (System.out::println);
        // assertThat(people.size ()).isEqualTo (personDTOList.size ());
    }

    @Test
    void mapToDoubleAndFindAverageCarPrice () throws IOException {
        List <Car> cars = MockData.getCars ();
        double average = cars.stream ().mapToDouble (Car::getPrice).average ().orElse (0);
        System.out.println (average);
    }

    @Test
    public void reduce () {

        int[] integers = {1, 2, 3, 4, 99, 100, 121, 1302, 199};
        int sum = Arrays.stream (integers).reduce (0, Integer::sum);
        int subtraction = Arrays.stream (integers).reduce (0, (a, b) -> a - b);
        System.out.println (sum);
        System.out.println (subtraction);
    }
}