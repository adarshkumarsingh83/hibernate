package com.adarsh;


import com.adarsh.service.PersonService;

public class ApplicationMain {

    public static void main(String[] args) {
        try {
            PersonService.insertPerson();
            PersonService.displayPerson(new Integer[]{100, 101, 102, 103, 104});

        } catch (Exception exceptionObject) {
            System.out.println(exceptionObject.getMessage());
        }
    }


}
