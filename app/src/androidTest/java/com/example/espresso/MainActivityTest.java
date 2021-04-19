package com.example.espresso;
import androidx.test.espresso.ViewAssertion;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.security.cert.PKIXCertPathChecker;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.*;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)

public class MainActivityTest {
     static final String USER_TO_BE_TYPED="User";
     static final String PASS_TO_BE_TYPED ="User";

   @Rule
   public ActivityScenarioRule<MainActivity> activityRule= new ActivityScenarioRule<>(MainActivity.class);
    @Test




    public void view_elements_are_displayed() {
      onView(withId(R.id.activity_title)).check(matches(isDisplayed()));
      onView(withId(R.id.button)).check(matches(isDisplayed()));
    }

    @Test
    public void view_elements_text_are_correct() {
        onView(withId(R.id.activity_title)).check(matches(withText(R.string.main_activity_title)));
        onView(withId(R.id.button)).check(matches(withText(R.string.next)));

    } @Test
    public void  login_form_behaviour() {
        onView(withId(R.id.username)).perform(click()).perform(typeText(USER_TO_BE_TYPED)).perform(closeSoftKeyboard());
        onView(withId(R.id.password)).perform(click()).perform(typeText(PASS_TO_BE_TYPED)).perform(closeSoftKeyboard());
        onView(withId(R.id.button)).check(matches(withText(R.string.next)));
        onView(withId(R.id.button)).perform(click()).check(matches(withText("Logged")));

    }

    @Test
    public void check_the_button_is_clickeable_and_when_pressed_the_text_change_to_back() {
        onView(withId(R.id.button)).check(matches(isClickable()));
        onView(withId(R.id.button)).perform(click()).check(matches(withText(R.string.back)));

    }

    @Test
    public void check_if_Activity_changed_on_click_the_next_button() {
        onView(withId(R.id.button)).perform(click());
                onView(withId(R.id.secondActivity)).check(matches(isDisplayed()));
    }
    @Test
    public void check_if_Activity_changed_on_click_the_next_button_andCheckThatReturnsToMain() {
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.secondActivity)).check(matches(isDisplayed()));
        onView(isRoot()).perform(pressBack());
        onView(withId(R.id.mainActivity)).check(matches(isDisplayed()));

    }

    @Test
    public void Large_test_function() {
        onView(withId(R.id.username)).perform(click()).perform(typeText(USER_TO_BE_TYPED)).perform(closeSoftKeyboard());
        onView(withId(R.id.password)).perform(click()).perform(typeText(PASS_TO_BE_TYPED)).perform(closeSoftKeyboard());
         onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.secondActivity)).check(matches(isDisplayed()));
           onView(withId(R.id.activity_title)).check(matches(withText("Welcome back " + USER_TO_BE_TYPED)));
        onView(isRoot()).perform(pressBack());
        onView(withId(R.id.mainActivity)).check(matches(isDisplayed()));
        onView(withId(R.id.username)).check(matches(withText("")));
        onView(withId(R.id.password)).check(matches(withText("")));

    }
}
