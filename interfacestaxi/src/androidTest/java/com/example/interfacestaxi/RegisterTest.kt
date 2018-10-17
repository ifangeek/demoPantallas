package com.example.interfacestaxi

import android.os.IBinder
import android.support.test.espresso.Espresso.closeSoftKeyboard
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.Root
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.view.WindowManager
import org.hamcrest.Description
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class RegisterTest {

    /*
    * Hamcrest = es una libreria de objetos que permiten hacer coincidir objetos  ( matcher objects )
    * permitiendo que coincida reglas en otros frameworks como espresso
    * Usado tipicamente en escenarios de frameworks para test y validaciones de UI
    * */

    @Rule
    @JvmField
    val testRule: ActivityTestRule<registerActivity> = ActivityTestRule(registerActivity::class.java)



    @Test
    fun testRegisterSuccess(){
        /*
        *
        *    withId(R.id.etName) isViewMatcher = permite ubicar una vista dentro de la jerarquia de vista actual
        *    click() is a ViewAction = Realizar acciones en una vista como el onClick()
        *    matches(isDisplayed()) is a ViewAssertion = permite utilizar validar la coincidencia del estado de una vista
        *    seleccionada en este caso en el Toast para verificar que se muestre y que coincida con el texto indicado
        * */


        /*
        * En ocasiones podria generar la busqueda del id de una vista una excepcion 'AmbiguousViewMatcherException'
        * esto se debe a que el id se esta compartiendo entre varias vistas
        * El mensaje de excepcion proporciona las vistas que podrian estar compartiendo el mismo id que genera la excepcion
        * */

        //Escribir en la caja de texto
        onView(withId(R.id.etName)).perform(typeText("Diego"),ViewActions.closeSoftKeyboard())

        onView(withId(R.id.etLastName)).perform(typeText("Pacheco"),ViewActions.closeSoftKeyboard())

        onView(withId(R.id.etPassword)).perform(typeText("123456"),ViewActions.closeSoftKeyboard())

        onView(withId(R.id.etPhone)).perform(typeText("948429548"),ViewActions.closeSoftKeyboard())

        onView(withId(R.id.etEmail)).perform(typeText("diego.pacheco@tismart.com"),ViewActions.closeSoftKeyboard())

        //realizar la accion de Click
        onView(withId(R.id.btnRegister)).perform(click())

        //validar Toast
        onView(withText(R.string.register_done)).inRoot(toastMatcher()).check(matches(isDisplayed()))
        onView(withText(R.string.register_done)).inRoot(toastMatcher()).check(matches(withText("Registro exitoso")))
    }

    @Test
    fun testRegisterError(){

        onView(withId(R.id.etName)).perform(typeText("Josue"))
        closeSoftKeyboard()

        onView(withId(R.id.etLastName)).perform(typeText("Rosas"))
        closeSoftKeyboard()

        onView(withId(R.id.btnRegister)).perform(click())

        onView(withText(R.string.register_incorrect)).inRoot(toastMatcher()).check(matches(isDisplayed()))
        onView(withText(R.string.register_incorrect)).inRoot(toastMatcher()).check(matches(withText("No dejar campos vacios para el registro")))
    }


    //Permite realizar pruebas sobre el Toast

    @Suppress("DEPRECATION")
    private class toastMatcher : TypeSafeMatcher<Root>() {
        override fun describeTo(description: Description?) {
//            description?.appendText("is toast")
        }

        override fun matchesSafely(item: Root): Boolean {
            val type: Int = item.windowLayoutParams.get().type
            //validamos si es TOAST el tipo
            if (type == WindowManager.LayoutParams.TYPE_TOAST) {
                val windowToken: IBinder = item.decorView.windowToken
                val appToken = item.decorView.applicationWindowToken
                if (windowToken == appToken) {
                    /*
                    * Significa que la pantalla no esta contenida por otra pantalla
                    * */
                    return true
                }
            }
            return false
        }


    }

}