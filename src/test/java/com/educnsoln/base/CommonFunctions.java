package com.educnsoln.base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import com.educnsoln.utilities.PropertyReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonFunctions {
	public static WebDriver driver;
	public static String homepath = System.getProperty("user.dir");
	static String folderpath;

	static long wait_time = Long.parseLong(PropertyReader.getProperty(Constants.WAIT));
	public static SoftAssert softassert = new SoftAssert();

	public static WebDriver browserLaunch(String browsername) {
		switch (browsername) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		default:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait_time));
		return driver;

	}

	public static String getScreenshot(WebDriver driver, String screenshotname) {
		TakesScreenshot ts = (TakesScreenshot) driver; // downcasting
		File src = ts.getScreenshotAs(OutputType.FILE); // to get the screenshot
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH_mm");
		String formattedDate = dateFormat.format(date);
		System.out.println(formattedDate);
		folderpath = homepath + "\\src\\test\\resources\\Screenshot\\" + formattedDate;
		File target = new File(folderpath + "\\" + screenshotname + ".png");
		String destination = folderpath + "\\" + screenshotname + ".png";
		try {
			FileUtils.copyFile(src, target);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return destination;

	}

	public static void getScreenshot(WebElement element, String screenshotname) throws IOException {
		File headerScrn = element.getScreenshotAs(OutputType.FILE);
		File target = new File(folderpath + "\\" + screenshotname + ".png");
		FileUtils.copyFile(headerScrn, target);

	}

	public static String getStringData(Object obj) {
		return obj.toString();

	}

	public static void sleep(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void visibilityOfElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(wait_time));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void visibilityOfListElement(List<WebElement> element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(wait_time));
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
	}

	public static void cickElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(wait_time));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

}