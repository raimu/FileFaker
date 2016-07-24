package com.github.raimu.filefaker;

import com.github.javafaker.Faker;

public class Main
{
    public static void main( String[] args )
    {
        System.out.println("Here are some random names:");

        Faker faker = new Faker();
        for (int i=0; i<10; i++) {
            System.out.println(faker.name().fullName());
        }
    }
}
