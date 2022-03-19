package com.amigoscode.examples;

import com.amigoscode.beans.Car;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Filtering {

    @Test
    public void filter () throws Exception {

        System.out.println ("carLessThan20K_inlineFunctionalInterface" + "\n");
        List <Car> cars = MockData.getCars ();
        List <Car> carLessThan20K_inlineFunctionalInterface = cars.stream ()
                .filter (c -> c.getPrice () <= 20000)
                .filter (c -> c.getColor ().equals ("Yellow"))
                .filter (c -> c.getMake ().equals ("Ford"))
                .filter (car -> car.getYear ().equals (2004))
                .collect (Collectors.toList ());
        carLessThan20K_inlineFunctionalInterface.forEach (System.out::println);

        //So as to extract a line of code to variable, CTL+ALT+V
        System.out.println ("carLessThan20K_extractedFunctionalInterface" + "\n");
        Predicate <Car> carPredicate = c -> c.getPrice () <= 20000;
        Predicate <Car> carColorPredicate = c -> c.getColor ().equals ("Yellow");
        Predicate <Car> carMadePredicate = c -> c.getMake ().equals ("Ford");
        Predicate <Car> carMadeYearPredicate = car -> car.getYear ().equals (2004);
        Collector <Car, ?, List <Car>> carListCollector = Collectors.toList ();

        List <Car> inexpensiveCarsLess20K = cars.stream ()
                .filter (carPredicate)
                .filter (carColorPredicate)
                .filter (carMadePredicate)
                .filter (carMadeYearPredicate)
                .collect (carListCollector);
        inexpensiveCarsLess20K.forEach (System.out::println);
    }


    @Test
    public void filter2 () throws Exception {
        System.out.println ("using filter");
        Stream.of (2, 4, 6, 8, 9, 10, 12).dropWhile (n -> n % 2 == 0)
                .forEach (n -> System.out.print (n + " "));
        System.out.println ();
    }

    @Test
    public void takeWhile () throws Exception {
        System.out.println ("using take while");
        Stream.of (2, 4, 6, 8, 9, 10, 12)
                .takeWhile (n -> n % 2 == 0)
                .forEach (n -> System.out.print (n + " "));
        System.out.println ();

    }

    @Test
    public void dropWhile () throws Exception {
        System.out.println ("using dropWhile");
        Stream.of (2, 4, 6, 8, 9, 10, 12).dropWhile (n -> n % 2 == 0)
                .forEach (n -> System.out.print (n + " "));
        System.out.println ();

    }

    @Test
    public void filterTakeWhileDropWhile () throws Exception {
        System.out.println ("using filter");
        Stream.of (2, 4, 6, 8, 9, 10, 12).filter (n -> n % 2 == 0)
                .forEach (n -> System.out.print (n + " "));
        System.out.println ();

        System.out.println ("\nusing takeWhile");
        Stream.of (2, 4, 6, 8, 9, 10, 12)
                .takeWhile (n -> n % 2 == 0)
                .forEach (n -> System.out.print (n + " "));

        System.out.println ();
        System.out.println ("\nusing dropWhile");
        Stream.of (2, 4, 6, 8, 9, 10, 12).dropWhile (n -> n % 2 == 0)
                .forEach (n -> System.out.print (n + " "));
    }

    //Unless there is specific reason to use findAny, favour findFirst than findAny
    @Test
    public void findFirst () throws Exception {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int result = Arrays.stream (numbers).filter (num -> num == 9)
                .findFirst ()
                .orElse (-1);
        System.out.println (result);


    }

    @Test
    public void findAny () throws Exception {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 10};
        int result = Arrays.stream (numbers).filter (num -> num == 9)
                .findAny ()
                .orElse (-1);
        System.out.println (result);

    }

    @Test
    public void allMatch () throws Exception {
        int[] even = {2, 4, 6, 8, 10};

        boolean allMatch = Arrays.stream (even).allMatch (n -> n % 2 == 0);
        System.out.println (allMatch);

        boolean nonMatch = Arrays.stream (even).noneMatch (n -> n % 2 != 0);
        System.out.println (nonMatch);
    }

    @Test
    public void anyMatch () throws Exception {
        int[] evenAndOneOdd = {2, 4, 6, 8, 10, 11};

        boolean oddMatch = Arrays.stream (evenAndOneOdd).anyMatch (n -> n % 2 == 1);
        System.out.println (oddMatch);

        boolean evenMatch = Arrays.stream (evenAndOneOdd).anyMatch (n -> n % 2 == 0);
        System.out.println (evenMatch);

    }

    @Test
    public void allMatchAnyMatchNoneMatch () throws Exception {

        int[] even = {2, 4, 6, 8, 10};
        System.out.println ("All match");
        boolean allMatch = Arrays.stream (even).allMatch (n -> n % 2 == 0);
        System.out.println (allMatch);

        System.out.println ("\nNone Match");
        boolean nonMatch = Arrays.stream (even).noneMatch (n -> n % 2 != 0);
        System.out.println (nonMatch);

        System.out.println ("\nAny Match");
        int[] evenAndOneOdd = {2, 4, 6, 8, 10, 11};

        boolean oddMatch = Arrays.stream (evenAndOneOdd).anyMatch (n -> n % 2 == 1);
        System.out.println (oddMatch);

        boolean evenMatch = Arrays.stream (evenAndOneOdd).anyMatch (n -> n % 2 == 0);
        System.out.println (evenMatch);

    }
}



