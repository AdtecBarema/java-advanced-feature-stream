package com.amigoscode.examples;


import com.amigoscode.beans.Person;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class IntStreams {

    @Test
    public void range() throws Exception {

        System.out.println ("With int stream exclusive");
        IntStream.range (0,10).forEach (System.out::println);
        System.out.println ("With int stream inclusive");
        IntStream.rangeClosed (0,10).forEach (System.out::println);
    }

    // Loop through people using IntStream
    @Test
    public void rangeIteratingLists () throws Exception {
        List <Person> people = MockData.getPeople ();
        IntStream.range(0, people.size ())
                .forEach (inex -> {
                    System.out.println (people.get (inex));
                });
        //Note here we can't make rangeClosed as it will throw java.lang.IndexOutOfBoundsException: Index 1000 out of bounds for length 1000
    }

    @Test
    public void intStreamIterate()  {
        //Note iterate is exclusive
        IntStream.iterate (0,value -> value+1).limit (20).forEach (System.out::println);
    }

    @Test
    public void DoubelStreamMethod()  {
        //Note iterate is exclusive

        DoubleStream.iterate (0,value -> value+10.25).limit (10).forEach (System.out::println);

    }

    @Test
    public void LongStreamIterate()  {

        LongStream.iterate (10, value -> value+100).limit (10).forEach (System.out::println);

    }
}