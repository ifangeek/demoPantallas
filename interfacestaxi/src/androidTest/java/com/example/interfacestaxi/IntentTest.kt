package com.example.interfacestaxi

import android.app.Activity
import android.app.Instrumentation
import android.content.Intent
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.intent.Intents
import android.support.test.espresso.intent.Intents.intended
import android.support.test.espresso.intent.Intents.intending
import android.support.test.espresso.intent.matcher.IntentMatchers
import android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent
import android.support.test.espresso.intent.matcher.IntentMatchers.toPackage
import android.support.test.espresso.intent.rule.IntentsTestRule
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.runner.AndroidJUnit4
import android.support.v7.widget.RecyclerView
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class IntentTest {

    companion object {
        const val ITEM_FOR_MATCH = 3

    }


    @Rule
    @JvmField
    val intentsTestRule: IntentsTestRule<LoginActivity> = IntentsTestRule(LoginActivity::class.java)

    @Test
    fun activityLaunch() {
        val message = "Good Morning Luis alonso"

        //Login prueba de ingreso correcto
        onView(withId(R.id.etUsername)).perform(typeText("diego"), ViewActions.closeSoftKeyboard())
        onView(withId(R.id.etPassword)).perform(typeText("123456"), ViewActions.closeSoftKeyboard())
        onView(withId(R.id.btnIngresar)).perform(click())
        //Ingreso segunda actividad
        onView(withId(R.id.btnTestAFR)).perform(click())
        //verifica que se envie la intencion al activity siguiente
        intended(hasComponent(SecondActivity::class.java.name))

        onView(withId(R.id.edtMessage)).perform(typeText(message), ViewActions.closeSoftKeyboard())
        val resultData = Intent()
        resultData.putExtra("message", message)
        var result: Instrumentation.ActivityResult = Instrumentation.ActivityResult(Activity.RESULT_OK, resultData)
        //actividad que va gestionar el envio del resultado

        onView(withId(R.id.btnSendMessage)).perform(click())
        intending(toPackage(SecondActivity::class.java.name)).respondWith(result)
//        intended(toPackage("com.example.interfacestaxi.SecondActivity"))
//        intended(toPackage("com.example.interfacestaxi.SecondActivity.kt"))
        onView(withId(R.id.tvWelcome)).check(matches(withText(message)))

    }

    @Test
    fun testRegisterSucessfulAndTestRecyclerView() {
        onView(withId(R.id.tvRegister)).perform(click())
        onView(withId(R.id.etName)).perform(typeText("Diego"), closeSoftKeyboard())
        onView(withId(R.id.etLastName)).perform(typeText("Pacheco"), closeSoftKeyboard())
        onView(withId(R.id.etPassword)).perform(typeText("tismart"), closeSoftKeyboard())
        onView(withId(R.id.etPhone)).perform(typeText("948429548"), closeSoftKeyboard())
        onView(withId(R.id.etEmail)).perform(typeText("diego.pacheco@tismart.com"), closeSoftKeyboard())
        onView(withId(R.id.btnRegister)).perform(click())
        onView(withId(R.id.btnTestRV)).perform(click())
        onView(withId(R.id.rvJob))
                .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(ITEM_FOR_MATCH, click()))

        val itemElementText = intentsTestRule.activity.applicationContext.resources.getString(R.string.company_microfost)

        onView(withText(itemElementText)).check(matches(isDisplayed()))

    }

}