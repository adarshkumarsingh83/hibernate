package com.adarsh;


import static com.adarsh.service.PersonService.displayPerson;
import static com.adarsh.service.PersonService.insertPerson;

public class ApplicationMain {

    public static void main(String[] args) {
        try {
            insertPerson();
            displayPerson(new Integer[]{100, 101, 102, 103, 104});

        } catch (Exception exceptionObject) {
            System.out.println(exceptionObject.getMessage());
        }
    }
}
