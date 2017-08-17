package br.hue.com.palindromo;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.rule.ActivityTestRule;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;


import org.junit.Test;
import org.junit.Rule;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    public static final String TEXT_PALINDROME_RIGHT = "sos";
    public static final String TEXT_PALINDROME_WRONG = "fulano";
    public static final String TITLE_PALINDROME = "É um palíndromo? (versão beta, somente palavras)";

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);


    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("br.hue.com.palindromo", appContext.getPackageName());
    }

    @Test
    public void verifyTitleApp() throws Exception {
        onView(withId(R.id.tv_titulo)).check(matches(withText(TITLE_PALINDROME)));
    }

    @Test
    public void searchRightTerm() throws Exception {
        onView(withId(R.id.et_palindromo)).perform(clearText(), typeText(TEXT_PALINDROME_RIGHT), closeSoftKeyboard());
        onView(withId(R.id.bt_verificar)).perform(click());
        onView(withId(R.id.tv_resposta)).check(matches(withText(TEXT_PALINDROME_RIGHT + " é um palíndromo ")));
    }

    @Test
    public void searchWrongTerm() throws Exception {
        onView(withId(R.id.et_palindromo)).perform(clearText(), typeText(TEXT_PALINDROME_WRONG), closeSoftKeyboard());
        onView(withId(R.id.bt_verificar)).perform(click());
        onView(withId(R.id.tv_resposta)).check(matches(withText(TEXT_PALINDROME_WRONG + " não é um palíndromo")));
    }
}
