package com.example.interfacestaxi

import android.app.Instrumentation
import android.content.Context
import android.content.Intent
import android.support.test.InstrumentationRegistry.getInstrumentation
import android.support.test.runner.AndroidJUnit4
import android.support.test.uiautomator.UiDevice
import android.content.pm.PackageManager
import android.content.pm.ResolveInfo
import android.support.test.InstrumentationRegistry.getContext
import android.support.test.uiautomator.By
import android.support.test.uiautomator.UiObject2
import android.support.test.uiautomator.Until
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.CoreMatchers.notNullValue
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TestUIAutomator {
    companion object {
        const val BASIC_SIMPLE_PACKAGE = "com.example.interfacestaxi.LoginTest"
        const val LAUNCH_TIMEOUT : Long = 5000
        const val TEXT_TO_BE_TYPE = "UiAutomator"
    }

    lateinit var mDevice : UiDevice

    @Before
    fun startMainActivity(){
        mDevice = UiDevice.getInstance(getInstrumentation())

        //Comenzar desde la pantalla de Home
        mDevice.pressHome()

        val launcherPackage = getLauncherPackageName()
        assertThat(launcherPackage,notNullValue())
        mDevice.wait(Until.hasObject(By.pkg(launcherPackage).depth(0)), LAUNCH_TIMEOUT)

        val context : Context = getContext().applicationContext

        val intent = context.packageManager
                .getLaunchIntentForPackage(BASIC_SIMPLE_PACKAGE)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        context.startActivity(intent)
        mDevice.wait(Until.hasObject(By.pkg(BASIC_SIMPLE_PACKAGE).depth(0)), LAUNCH_TIMEOUT)
    }

    @Test
    fun testChangeText_sameActivity(){
        mDevice.findObject(By.res(BASIC_SIMPLE_PACKAGE,"etUsername"))
                .text = TEXT_TO_BE_TYPE
        mDevice.findObject(By.res(BASIC_SIMPLE_PACKAGE,"btnIngresar")).click()

        //verificando que el test se muestre en la UI
        var changeText : UiObject2 = mDevice.wait(Until.findObject(By.res(BASIC_SIMPLE_PACKAGE,"etUsername")),500)
        assertThat(changeText.text, equalTo(TEXT_TO_BE_TYPE))

    }



    fun getLauncherPackageName(): String{

        // CREAR EL INTENT LAUNCHER
        val intent = Intent(Intent.ACTION_VIEW)
        intent.addCategory(Intent.CATEGORY_HOME)

        // use PackageManager para obtener el nombre del paquete
        val pm : PackageManager = getContext().applicationContext.packageManager!!
        val resolveInfo : ResolveInfo = pm.resolveActivity(intent,PackageManager.MATCH_DEFAULT_ONLY)
        return resolveInfo.activityInfo.packageName
    }
}