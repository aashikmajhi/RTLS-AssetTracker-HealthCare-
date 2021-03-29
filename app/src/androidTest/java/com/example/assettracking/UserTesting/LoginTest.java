package com.example.assettracking.UserTesting;

import androidx.test.rule.ActivityTestRule;

import com.example.assettracking.R;
import com.example.assettracking.RegistrationSystem.SignIn.SignIn;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class LoginTest {
    @Rule
    public ActivityTestRule loginTest = new ActivityTestRule(SignIn.class);

    @Test
    public void LoginUser() {
        onView(withId(R.id.editTextEmail))
                .perform(typeText("aashikmajhi@gmail.com"))
                .perform(closeSoftKeyboard());
        onView(withId(R.id.editTextPassword))
                .perform(typeText("password123"))
                .perform(closeSoftKeyboard());
        onView(withId(R.id.cirLoginButton))
                .perform(click());
    }
}
