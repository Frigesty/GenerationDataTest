package ru.frigesty.utils;

import com.github.javafaker.Faker;

import java.util.concurrent.ThreadLocalRandom;

import static ru.frigesty.tests.TestData.*;

public class RandomUtils {


    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomItemFromArray(String[] values) {
        int index = getRandomInt(0, values.length - 1);

        return values[index];
    }

    public static String getRandomCity(String state) {

        Faker faker = new Faker();

        String city;
        switch (state) {
            case "NCR" -> {
                city = faker.options().option(stateNCR);
                return city;
            }
            case "Uttar Pradesh" -> {
                city = faker.options().option(stateUttarPradesh);
                return city;
            }
            case "Haryana" -> {
                city = faker.options().option(stateHaryana);
                return city;
            }
            case "Rajasthan" -> {
                city = faker.options().option(stateRajasthan);
                return city;
            }
        }
        return null;
    }
}