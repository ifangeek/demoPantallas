package com.example.interfacestaxi

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.v7.widget.RecyclerView
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TestList {

    companion object {
        const val ITEM_FOR_MATCH = 4
    }

    @Rule
    @JvmField
    val testRule: ActivityTestRule<JobsActivity> = ActivityTestRule(JobsActivity::class.java)


    @Test
    fun testShowListSucceful() {

        //verifica que se encuentre el texto '3y' dentro del listado que tiene como identificador el nombre del trabajo 'IBM'
        // ya que es un identificador unico dentro de las vistas de cada listado

        //allof = permite encontrar conjunciones de coincidencias multiples , no se llama a las coincidencias posteriorres si devuelve una anterior.
        //hasSibling = usado mayormente cuando un view que se quiere testear tiene un unico id dentro de un listado y contiene texto igual
        // con el hassibling hacemos que se limite la busqueda dandole algun identificaddor que este acompañado del texto que queremos testear este caso un
        //identificado para encontrar '3y' que es un texto que se repite
        onView(allOf(withText("3y"), hasSibling(withText("IBM")))).perform(click())

        //verificar si el texto es correcto dentro del adapter
//        onView(withId(R.id.rvJob)).check(matches(withText(containsString("KOTLIN Developer"))))


    }

    @Test
    fun scrolltoItemBelow_checkItsText() {
        //Scroleamos hasta la posicion que necesitamos hacerle match
        onView(ViewMatchers.withId(R.id.rvJob))
                .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(ITEM_FOR_MATCH, click()))

        var itemElementText = testRule.activity.applicationContext.resources.getString(R.string.company_microfost)

        onView(withText(itemElementText)).check(matches(isDisplayed()))
    }


}