package com.example.interfacestaxi

import android.os.IBinder
import android.support.test.espresso.Espresso.closeSoftKeyboard
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.Root
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

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class LoginTest {


    /**
     *  ES necesario agregar el @JvmField para convertir esta propiedad
     *  en un campo JVM que JUnit pueda interpretar
     * */
    @Rule
    @JvmField
    val testRule: ActivityTestRule<LoginActivity> = ActivityTestRule(LoginActivity::class.java)


    @Test
    fun testCheckLoginSuccess() {

        onView(withId(R.id.etUsername)).perform(typeText("diego"))

        closeSoftKeyboard()

        onView(withId(R.id.etPassword)).perform(typeText("123456"))
                .perform()

        closeSoftKeyboard()

        onView(withId(R.id.btnIngresar)).perform(click())


        // Test para saber si el Toast Messasge es mostrado
        onView(withText(R.string.message_done)).inRoot(toastMatcher()).check(matches(isDisplayed()))

        //Test para saber si el Toast Message no es mostrado
        /*onView(withText(R.string.message_done)).inRoot(toastMatcher()).check(matches(not(isDisplayed())))*/

        // Test para saber si el Toast contiene especificamente algun Texto
        onView(withText(R.string.message_done)).inRoot(toastMatcher()).check(matches(withText("Ingreso exitoso")))
    }

    @Test
    fun testCheckLoginError() {
        onView(withId(R.id.etUsername)).perform(typeText("josue"))

        closeSoftKeyboard()

        onView(withId(R.id.etPassword)).perform(typeText("123"))

        closeSoftKeyboard()

        onView(withId(R.id.btnIngresar)).perform(click())

        onView(withText(R.string.message_incorrect_credentials)).inRoot(toastMatcher()).check(matches(isDisplayed()))

        onView(withText(R.string.message_incorrect_credentials)).inRoot(toastMatcher()).check(matches(withText("usuario y/o clave incorrectos")))
    }

    @Test
    fun testCheckFieldsisBlank() {
        onView(withId(R.id.btnIngresar)).perform(click())

        onView(withText(R.string.text_in_blank)).inRoot(toastMatcher()).check(matches(isDisplayed()))
        onView(withText(R.string.text_in_blank)).inRoot(toastMatcher()).check(matches(withText("Ingrese sus credenciales")))

    }


    @Suppress("DEPRECATION")
    private class toastMatcher : TypeSafeMatcher<Root>() {
        override fun describeTo(description: Description?) {
//                description?.appendText("is toast")
        }

        override fun matchesSafely(item: Root): Boolean {
            val type: Int = item.windowLayoutParams.get().type
            if (type == WindowManager.LayoutParams.TYPE_TOAST) {

                /* Permite tener el token que identifica a la ventana que se adjunta la vista */
                val windowToken: IBinder = item.decorView.windowToken

                /* Recupera un token único que identifica la ventana 'real' de la ventana a la que se adjunta la vista (similar a un windowtoken)
                * excepto que si la vista esta contenida en otra pantalla , nos retornara el token del contenedor mas no de la vista dentro de ella*/
                val appToken = item.decorView.applicationWindowToken

                //comparamos si los tokens de las ventanas en la que esta adjuntada la vista son iguales
                if (windowToken == appToken) {
                    /*
                    * Significa que la vista no esta contenida en otra
                    * */
                    return true
                }
            }
            return false
        }


    }


}
