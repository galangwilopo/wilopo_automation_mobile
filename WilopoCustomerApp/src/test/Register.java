package test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Register extends base {
	
	//TC.2.001
	@Test
	public void RegisterUser() throws MalformedURLException {
		try {
			AndroidDriver<AndroidElement> driver = capabilities();
			//click menu Impor
			driver.findElementByAndroidUIAutomator("text(\"Importir\")").click();
			//click button daftar
			driver.findElementByAndroidUIAutomator("text(\"Daftar\")").click();
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			//isi form
			System.out.println("Sign Up Process");
//			driver.findElementByXPath("//android.widget.EditText[@text='123/WC/']").sendKeys("123/WC-tes");
//			driver.findElementByXPath("//android.widget.EditText[@text='Nama Lengkap']").sendKeys("Rambo");
//			driver.findElementByXPath("//android.widget.EditText[@text='Alamat Email']").sendKeys("rambo@mail.com");
//			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(text(\"Daftar\").instance(0));");
//			driver.findElementByXPath("(//android.widget.EditText)[@index=13]").sendKeys("085485411212");
//			driver.findElementByXPath("(//android.widget.EditText)[@index=16]").sendKeys("wilopocargo");
//			driver.findElementByXPath("(//android.widget.EditText)[@index=19]").sendKeys("wilopocargo");
			
			List<AndroidElement> indexField = driver.findElementsByAndroidUIAutomator("new UiSelector().className(\"android.widget.EditText\")");
			System.out.println("total list "+indexField+" field");
			
			indexField.get(0).sendKeys("123/WC-tes");
			indexField.get(1).sendKeys("Rambo");
			indexField.get(2).sendKeys("rambo@mail.com");
			
			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(text(\"Daftar\").instance(0));");
			List<AndroidElement> indexFieldAfterScroll = driver.findElementsByAndroidUIAutomator("new UiSelector().className(\"android.widget.EditText\")");
			System.out.println("total list "+indexFieldAfterScroll+" field after scroll");
			
			indexField.get(3).sendKeys("085485411212");
			indexField.get(4).sendKeys("wilopocargo");
			indexField.get(5).sendKeys("wilopocargo");
			
			driver.findElementsByAndroidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\")").get(0).click();
			
//			driver.findElementByXPath("//android.widget.EditText[@text='Daftar']").click();
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			System.out.println("Sign Up Submit");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage().toString());
		}
	}

}
