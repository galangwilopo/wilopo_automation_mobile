package test;

import java.net.MalformedURLException;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class LandingPage extends base {
	//TC.1.001
	@Test(priority = 1)
	public void LandingPageBeforeLogin() throws MalformedURLException {
		try {
			AndroidDriver<AndroidElement> driver = capabilities();
//			String lastSection = driver.findElementByXPath("(//android.widget.TextView)[9]").getText();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(text(\"Promo\").instance(0));");
			System.out.println("scroll down view success");
			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(text(\"Terpopuler\").instance(0));");
			System.out.println("scroll up view success");
//			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).setAsHorizontalList().scrollIntoView(text(\"Matrass Mainan Anak...\").instance(0));");
//			System.out.println("horizontal view success");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage().toString());
		}
	}
	//TC.1.002
	@Test
	public void LandingPageToScreenFromBanner() throws MalformedURLException {
		try {
			AndroidDriver<AndroidElement> driver = capabilities();
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			
			//horizontal scroll view
			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).setAsHorizontalList().scrollIntoView(class(\"android.view.ViewGroup\").instance(0));");
			System.out.println("horizontal view success");
//			driver.findElementByXPath("(//android.view.ViewGroup)[2]").click();
//			driver.findElementByXPath("(//android.view.ViewGroup)[0]").click();
//			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//			String textFromBanner = driver.findElementByXPath("(//android.widget.TextView)[1]").getText();
//			Assert.assertEquals(textFromBanner, "Banner 1");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage().toString());
		}
	}
	//TC.1.004
	@Test
	public void LandingPageToRegisterScreen() throws MalformedURLException {
		try {
			AndroidDriver<AndroidElement> driver = capabilities();
			//click menu Impor
			driver.findElementByAndroidUIAutomator("text(\"Importir\")").click();
			//click button daftar
			driver.findElementByAndroidUIAutomator("text(\"Daftar\")").click();
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			//cek menu form
			String menuTitle = driver.findElementByXPath("(//android.widget.TextView)[1]").getText();
			System.out.println(menuTitle);
			Assert.assertEquals(menuTitle, "Register");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage().toString());
		}
	}
	//TC.1.005
	@Test
	public void LandingPageToDetailArticle() throws MalformedURLException {
		try {
			AndroidDriver<AndroidElement> driver = capabilities();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(text(\"Newsfeed\").instance(0));");
			System.out.println("scroll down view success");
			
			driver.findElementByXPath("(//android.view.ViewGroup)[@index=0]").click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			String menuTitle = driver.findElementByXPath("(//android.widget.TextView)").getText();
			Assert.assertEquals(menuTitle, "Wilopo Artikel");
			System.out.println(menuTitle);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage().toString());
		}
	}
	//TC.1.007
	@Test
	public void LandingPageToListArticle() throws MalformedURLException {
		try {
			AndroidDriver<AndroidElement> driver = capabilities();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(text(\"Newsfeed\").instance(0));");
			System.out.println("scroll down view success");
			driver.findElementByAndroidUIAutomator("text(\"Lihat semua artikel\")").click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			String menuTitle = driver.findElementByXPath("(//android.widget.TextView)").getText();
			Assert.assertEquals(menuTitle, "Semua Article");
			System.out.println("berhasil masuk ke "+menuTitle);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage().toString());
		}
	}
	//TC.1.008
	@Test
	public void LandingPageCheckNavbarButton() throws MalformedURLException {
		try {
			AndroidDriver<AndroidElement> driver = capabilities();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage().toString());
		}
	}
}
