package com.amigoscode.examples;


import com.amigoscode.beans.Car;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingData {

    @Test
    public void simpleGrouping () throws Exception {
        List <Car> carList = MockData.getCars ();
        Map <String, List <Car>> groupByMake = carList
                .stream ()
                .collect (Collectors.groupingBy (Car::getMake));

        groupByMake.forEach ((s, cars) -> {
            System.out.println ("Make " + s);
            cars.forEach (System.out::println);
            System.out.println ("--------------------------------------");
        });
    }

    @Test
    void carGroupByColor () throws IOException {
        List <Car> carList = MockData.getCars ();
        Map <String, List <Car>> groupByCarColor = carList.stream ().collect (Collectors.groupingBy (Car::getColor));
        groupByCarColor.forEach ((color, carListByColor) -> {
            System.out.println ("Color " + color);
            carListByColor.forEach (System.out::println);
            System.out.println ("___________________________________________");
        });
    }

    @Test
    void carGroupModel () throws IOException {
        List <Car> carList = MockData.getCars ();
        Map <String, List <Car>> groupByCarModel = carList.stream ()
                                .collect (Collectors.groupingBy (Car::getModel));
        groupByCarModel.forEach ((carModel, carListByModel) -> {
            System.out.println ("Car Model" + carModel);
            carListByModel.forEach (System.out::println);
            System.out.println ("_____________________________________________");
        });
    }

    @Test
    public void groupingAndCounting () throws Exception {
        List <String> names = List.of (
                "John",
                "John",
                "Mariam",
                "Alex",
                "Mohammado",
                "Mohammado",
                "Vincent",
                "Alex",
                "Alex"
        );
        Map <String, Long> map = names.stream ().collect (Collectors.groupingBy (s -> s, Collectors.counting ()));
        System.out.println (map);
    }
}