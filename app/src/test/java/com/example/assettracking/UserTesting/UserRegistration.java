package com.example.assettracking.UserTesting;

import com.example.assettracking.Database.User;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserRegistration {
    @Test
    public void Register(){
        User user = new User("Aashik Majhi","aashikmajhi@gmail.com","9803922659","Passmein123");
        boolean result = user.UserRegister();
        assertEquals(true,result);
    }

    @Test
    public void RegisterduplicateUser(){
        User user = new User("Aashik Majhi","aashikmajhi@gmail.com","9803922659","Passmein123");
        boolean result = user.UserRegister();
        assertEquals(false,result);
    }

    @Test
    public void RegisterwithblankData(){
        User user = new User("","aashikmajhi@gmail.com","","Passmein123");
        boolean result = user.UserRegister();
        assertEquals(false,result);
    }
}
