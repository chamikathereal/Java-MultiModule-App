package lk.jiat.ee.ejb.impl;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ejb.*;
import lk.jiat.ee.ejb.remote.AppSettings;
import lk.jiat.ee.ejb.remote.UserDetails;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.Serializable;

@Stateful
public class UserDetailsBean implements UserDetails, Serializable {

    @EJB
    private transient  AppSettings appSettings;

    private int counter;

    @PostConstruct
    public void init() {
        System.out.println("UserDetailsBean Init: " + this);
    }

    @PreDestroy
    public void destroy() {
        System.out.println("UserDetailsBean Destroy");
    }

    @Override
    @Lock(LockType.WRITE)
    public String getName() {
        counter++;
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        return appSettings.getAppName() + " " + counter;
    }

    @PrePassivate
    public void prePassivate() {
        System.out.println("UserDetailsBean passivate....");
    }

    @PostActivate
    public void postActivate() {
        System.out.println("UserDetailsBean activate....");
    }

    @Remove
    public void remove() {
        System.out.println("UserDetailsBean has been removed");
    }

    @Override
    public String getEmail() {
        return "chamika@gmail.com";
    }

    @Override
    public String getContact() {
        return "0772101809";
    }

}
