package test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class LoginAndResetPassword extends base {

	@Test(priority = 2)
	//For TC.03.001
	public void LandingPageToLoginPage() throws MalformedURLException {
		try {
			AndroidDriver<AndroidElement> driver = capabilities();
			//click menu Impor
			driver.findElementByAndroidUIAutomator("text(\"Importir\")").click();
			//enter to login form
			driver.findElementByAndroidUIAutomator("text(\"Login Akun\")").click();
			//click button sign in
			driver.findElementByAndroidUIAutomator("text(\"Sign In\")").click();
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			//cek apakah sudah di halaman login
			String textLoginPage = driver.findElementByXPath("(//android.widget.TextView)[1]").getText();
			System.out.println(textLoginPage);
			Assert.assertEquals(textLoginPage, "Masuk Akun");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage().toString());
		}
		
	}
	
	@Test(priority = 4)
	//For TC.3.002
	public void LoginCustomerApp() throws MalformedURLException {
		try {
			AndroidDriver<AndroidElement> driver = capabilities();
			//click menu Impor
			driver.findElementByAndroidUIAutomator("text(\"Importir\")").click();
			//enter to login form
			driver.findElementByAndroidUIAutomator("text(\"Login Akun\")").click();
			//click button sign in
			driver.findElementByAndroidUIAutomator("text(\"Sign In\")").click();
			//input text ID Marking and password
			driver.findElementByXPath("//android.widget.EditText[@text='123/WC/']").sendKeys("123/WC-tes");
//			driver.findElementByXPath("//android.widget.EditText[@text='123/WC/']").sendKeys(getUser1());
			driver.findElementByXPath("//android.widget.EditText[@text='********']").sendKeys("wilopocargo");
//			driver.findElementByXPath("//android.widget.EditText[@text='********']").sendKeys(getPass1());
			
			//klik button sign in
			driver.findElementByAndroidUIAutomator("text(\"Sign In\")").click();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage().toString());
		}
	}
	
	@Test(priority = 3)
	//For TC.3.003
	public void LoginFailedCustomerApp() throws MalformedURLException {
		try {
			AndroidDriver<AndroidElement> driver = capabilities();
			//click menu Impor
			driver.findElementByAndroidUIAutomator("text(\"Importir\")").click();
			//enter to login form
			driver.findElementByAndroidUIAutomator("text(\"Login Akun\")").click();
			//click button sign in
			driver.findElementByAndroidUIAutomator("text(\"Sign In\")").click();
			//input text ID Marking and password
			driver.findElementByXPath("//android.widget.EditText[@text='123/WC/']").sendKeys("123/WC-tes");
//			driver.findElementByXPath("//android.widget.EditText[@text='123/WC/']").sendKeys(getUser1());
			driver.findElementByXPath("//android.widget.EditText[@text='********']").sendKeys("5555555");
//			driver.findElementByXPath("//android.widget.EditText[@text='********']").sendKeys(getPass1());
			
			//klik button sign in
			driver.findElementByAndroidUIAutomator("text(\"Sign In\")").click();
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			
			//Muncul alert message
			String getAlertMsg = driver.findElementByXPath("(//android.widget.TextView)[3]").getText();
			System.out.println(getAlertMsg);
			Assert.assertEquals(getAlertMsg, "ID Marking atau Password salah");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage().toString());
		}
	}

}
