package com.example.assettracking.UserTesting;

import com.example.assettracking.Database.User;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Login {
    @Test
    public void loginTest(){
        User user = new User("aashikmajhi@gmail.com","Passmein123");
        boolean result = user.Userlogin();
        assertEquals(true,result);
    }

    @Test
    public void invalidUser(){
        User user = new User("aashik@gmail.com","Passmein123");
        boolean result = user.Userlogin();
        assertEquals(false,result);
    }

    @Test
    public void emptyData(){
        User user = new User("","");
        boolean result = user.Userlogin();
        assertEquals(false,result);
    }
}
