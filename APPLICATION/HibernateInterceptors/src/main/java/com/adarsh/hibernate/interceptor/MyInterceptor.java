package com.adarsh.hibernate.interceptor;

/**
 * Created with IntelliJ IDEA.
 * User: Adarsh
 * Date: 6/25/12
 * Time: 2:02 PM
 * To change this template use File | Settings | File Templates.
 */

import java.io.Serializable;
import java.util.Iterator;

import com.adarsh.hibernate.entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

@Slf4j
public class MyInterceptor extends EmptyInterceptor {

    private int updates;
    private int creates;
    private int loads;

    public void onDelete(Object entity,
                         Serializable id,
                         Object[] state,
                         String[] propertyNames,
                         Type[] types) {
        // do nothing
    }

    // This method is called when Employee object gets updated.
    public boolean onFlushDirty(Object entity,
                                Serializable id,
                                Object[] currentState,
                                Object[] previousState,
                                String[] propertyNames,
                                Type[] types) {
        if (entity instanceof Employee) {
            log.info("Update Operation");
            return true;
        }
        return false;
    }

    public boolean onLoad(Object entity,
                          Serializable id,
                          Object[] state,
                          String[] propertyNames,
                          Type[] types) {
        // do nothing
        return true;
    }

    // This method is called when Employee object gets created.
    public boolean onSave(Object entity,
                          Serializable id,
                          Object[] state,
                          String[] propertyNames,
                          Type[] types) {
        if (entity instanceof Employee) {
            log.info("Create Operation");
            return true;
        }
        return false;
    }

    //called before commit into database
    public void preFlush(Iterator iterator) {
        log.info("preFlush");
    }

    //called after committed into database
    public void postFlush(Iterator iterator) {
        log.info("postFlush");
    }
}