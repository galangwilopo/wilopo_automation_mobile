package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class base {
	public static Properties prop;
	public static AndroidDriver<AndroidElement> capabilities() throws MalformedURLException {
		//android driver
		File appDir = new File("src");
		File app = new File(appDir, "app-release-unsigned-signed.apk");
		
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "GalangPixel2");
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		
		//for real device
//		cap.setCapability("app", "src/app-release-unsigned-signed.apk");
//		cap.setCapability("deviceName", "device");
//		cap.setCapability("platformName", "android");
//		cap.setCapability("appPackage", "com.wilopocargo.customerApp");
//		cap.setCapability("appActivity", "com.wilopocargo.customerApp.MainActivity");
		
		//uiautomator
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
//		driver.startActivity(new Activity("com.wilopocargo.customerApp","com.wilopocargo.customerApp.MainActivity"));
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;
	}
	
	public FileInputStream getFis() throws IOException {
		FileInputStream fis = null;
		try {
			prop = new Properties();
			fis = new FileInputStream("D:\\Work\\Wilopo\\Mobile Test\\Android\\WilopoCustomerApp\\src\\testConfig\\global.properties");
			System.out.println("global properties berhasil dibaca");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Tidak dapat membaca global properties");
			System.out.println(e.getMessage().toString());
		}
		
		return fis;
	}
	
	public String getUser1() throws IOException {
		String user1 = null;
		try {
			prop = new Properties();
			prop.load(getFis());
			user1 = prop.getProperty("user1");
			System.out.println("username "+user1);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Tidak dapat membaca nama user");
			System.out.println(e.getMessage().toString());
		}
		return user1;
	}
	
	public String getPass1() throws IOException {
		prop = new Properties();
		prop.load(getFis());
		String pass1 = prop.getProperty("pass1");
		return pass1;
	}
}
