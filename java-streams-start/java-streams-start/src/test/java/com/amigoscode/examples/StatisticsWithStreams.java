package com.amigoscode.examples;


import com.amigoscode.beans.Car;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.DoubleSummaryStatistics;
import java.util.List;

public class StatisticsWithStreams {

    @Test
    public void count () throws Exception {
        List <Car> cars = MockData.getCars ();

        long fordCount = cars.stream ()
                .filter (car -> car.getMake ().equalsIgnoreCase ("Ford"))
                .count ();
        System.out.println (fordCount);
    }

    @Test
    public void min () throws Exception {
        List <Car> cars = MockData.getCars ();
        double cheapCar = cars
                .stream ()
                .mapToDouble (car -> car.getPrice ())
                .min ()
                .orElse (0);
        System.out.println (cheapCar);


    }

    @Test
    public void max () throws Exception {
        List <Car> cars = MockData.getCars ();
        double mostExpensiveCar = cars.stream ().mapToDouble (Car::getPrice)
                .max ()
                .orElse (0);
        System.out.println (mostExpensiveCar);
    }


    @Test
    public void average () throws Exception {
        List <Car> cars = MockData.getCars ();

        double averagePriceOfCars = cars.stream ()
                .mapToDouble (Car::getPrice)
                .average ()
                .orElse (0);
        System.out.println (averagePriceOfCars);
    }

    @Test
    public void sum () throws Exception {
        List <Car> cars = MockData.getCars ();

        double sumOfPricesOfCars = cars.stream ()
                .mapToDouble (Car::getPrice)
                .sum ();
        System.out.println (BigDecimal.valueOf (sumOfPricesOfCars));
    }

    @Test
    public void statistics () throws Exception {

        List <Car> cars = MockData.getCars ();
        //Summary Statistics is a bit expensive but it contains
        DoubleSummaryStatistics summaryStatistics = cars.stream ()
                .mapToDouble (Car::getPrice)
                .summaryStatistics ();
        System.out.println (cars.stream ().mapToDouble (Car::getPrice).summaryStatistics ().getAverage ());

        System.out.println (summaryStatistics.getCount ());
        System.out.println (summaryStatistics.getMax ());
        System.out.println (summaryStatistics.getMin ());
        System.out.println (summaryStatistics.getAverage ());
        System.out.println (BigDecimal.valueOf (summaryStatistics.getSum ()));
    }
}