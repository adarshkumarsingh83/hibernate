package com.adarsh;


import lombok.extern.slf4j.Slf4j;
import static com.adarsh.service.PersonService.*;

@Slf4j
public class ApplicationMain {

    public static void main(String[] args) {
        try {
            insertPerson();
            displayPersonByQueryList();
            displayPersonByQueryIterate();
        } catch (Exception exceptionObject) {
            log.error(exceptionObject.getMessage());
        }
    }
}
