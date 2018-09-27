package com.frank.framework;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

import com.frank.reportlib.html.HtmlFile;
import com.frank.reportlib.html.HtmlFileGlobal;
import com.frank.store.DataStore;
import com.frank.store.TextStore;

public class WebDriverLib {

	public WebDriverLib(WebDriver driver) {
		
	}

	protected static Logger logger = Logger.getLogger(DataStore.D_DebugLogger);
	protected static WebDriver driver = null;

	private FileHandler fileHandler = null;

	private String browser = DataStore.D_Browser;
	private String baseUrl = DataStore.D_URL;

	//static ReportEntry re = new ReportEntry();

	public void newSetup(String p_Name)

	{
		try {
			fileHandler = new FileHandler(DataStore.D_LogPath + File.separator + "Debug.log", true);
			fileHandler.setFormatter(new SimpleFormatter());
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			logger.severe(e.toString());
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.addHandler(fileHandler);

		if (browser.equalsIgnoreCase("chrome")) {
			// System.setProperty("webdriver.chrome.driver","D:\\MyWorkplace\\webdriverServer\\chromedriver.exe");

			driver = new ChromeDriver();
			logger.info("启动chrome浏览器。");

		} else if (browser.equalsIgnoreCase("ie")) {

			driver = new InternetExplorerDriver();
			logger.info("启动ie浏览器。");

		} else if (browser.equalsIgnoreCase("safari")) {
			// System.setProperty("webdriver.safari.noinstall","C:\\Program
			// Files\\Safari\\Safari.exe");
			Platform current = Platform.getCurrent();
			if (Platform.WINDOWS.is(current))
				driver = new SafariDriver();
			logger.info("启动safari浏览器。");

		} else {
			//ProfilesIni pi = new ProfilesIni();
			//FirefoxProfile profile = pi.getProfile("default");
			//driver = new FirefoxDriver(profile);
			driver = new FirefoxDriver();
			logger.info("启动firefox浏览器。");

		}

		if (driver != null) {
			HtmlFileGlobal.createLog(DataStore.D_LogPath +File.separator + p_Name + ".html");
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver.get(baseUrl);
			logger.info("获取环境信息：" + baseUrl);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			logger.info("浏览器窗口最大化。");
			logger.info(TextStore.T_Init + TextStore.T_Pass);
		}

	}

	public void newTeardown() {

		driver.quit();
		logger.info("webdriverLib 销毁");
		logger.info(TextStore.T_Logout + TextStore.T_Pass);
		HtmlFileGlobal.closeLog();

	}

	public static By parseObject(String p_object) {
		String newObjecyt = null;

		if (p_object.startsWith(".//") || p_object.startsWith("//")) {
			return By.xpath(p_object);
		} else if (p_object.startsWith("link=") || p_object.startsWith("Link=")) {
			newObjecyt = p_object.substring(p_object.indexOf("=") + 1);
			return By.linkText(newObjecyt);
		} else if (p_object.startsWith("xpath=")) {
			newObjecyt = p_object.substring(p_object.indexOf("=") + 1);
			return By.xpath(newObjecyt);
		} else if (p_object.startsWith("id=")) {
			newObjecyt = p_object.substring(p_object.indexOf("=") + 1);
			return By.id(newObjecyt);
		} else if (p_object.startsWith("css=")) {
			newObjecyt = p_object.substring(p_object.indexOf("=") + 1);
			return By.cssSelector(newObjecyt);
		} else if (p_object.startsWith("class=")) {
			newObjecyt = p_object.substring(p_object.indexOf("=") + 1);
			return By.className(newObjecyt);
		} else if (p_object.startsWith("tagName=")) {
			newObjecyt = p_object.substring(p_object.indexOf("=") + 1);
			return By.tagName(newObjecyt);
		} else if (p_object.startsWith("name=")) {
			newObjecyt = p_object.substring(p_object.indexOf("=") + 1);
			return By.name(newObjecyt);
		} else
			return null;

	}

	public void newClick(String p_id) {

		CommonLib.sleep(DataStore.D_Wait_ShortTime);

		try {

			driver.findElement(parseObject(p_id)).click();
			logger.info(TextStore.T_ClickObject + p_id + TextStore.T_Pass);

		}

		catch (Exception e) {
			logger.severe(TextStore.T_Exception + "newClick(String p_id)" + TextStore.T_DetailInfo + e.toString());

		}

	}

	public void newType(String p_id, String p_text) {
		CommonLib.sleep(DataStore.D_Wait_ShortTime);

		try {
			driver.findElement(parseObject(p_id)).clear(); // 输入文字前，清除文本框中的文字
			driver.findElement(parseObject(p_id)).sendKeys(p_text);
			logger.info(TextStore.T_Input + p_text + TextStore.T_To + p_id + TextStore.T_Pass);

		} catch (Exception e) {
			logger.severe(TextStore.T_Exception + "newType" + TextStore.T_DetailInfo + e.toString());
		}
	}

	public void newSelect(String p_id, String p_text) {
		CommonLib.sleep(DataStore.D_Wait_ShortTime);

		try {
			Select select = new Select(driver.findElement(parseObject(p_id)));
			select.selectByVisibleText(p_text);

			logger.info(TextStore.T_SelectListValue + p_id + "内容是" + p_id + TextStore.T_Pass);

		} catch (Exception e) {
			logger.severe(TextStore.T_Exception + "newSelect" + TextStore.T_DetailInfo + e.toString());
		}
	}

	public void newVerifyEquals(String p_message, Object p_expected, Object p_actual) throws Exception {

		if (p_expected.equals(p_actual)) {
			HtmlFileGlobal.write(p_message, p_expected.toString(), p_actual.toString());// 写入html
																			// report
																			// or
																			// debug
																			// report
			logger.info("");

		} else {
			screenShot();
			HtmlFileGlobal.write(p_message, p_expected.toString(), p_actual.toString());// 写入html
																			// report
																			// or
																			// debug
																			// report
			logger.severe("");

		}
	}

	public void newAssertEquals(String p_message, Object p_expected, Object p_actual) throws Exception {

		if (p_expected.equals(p_actual)) {
			HtmlFileGlobal.write(p_message, p_expected.toString(), p_actual.toString());// 写入html
																			// report
																			// or
																			// debug
																			// report
			logger.info("");

		} else {
			screenShot();
			HtmlFileGlobal.write(p_message, p_expected.toString(), p_actual.toString());// 写入html
																			// report
																			// or
																			// debug
																			// report
			HtmlFileGlobal.closeLog();
			driver.quit();
			logger.severe("");

		}
	}

	public void swithchToWindow(String p_windowName) {
		CommonLib.sleep(DataStore.D_Wait_ShortTime);
		for (String s : driver.getWindowHandles()) {
			driver.switchTo().window(s);
			if (driver.getTitle().equals(p_windowName)) {
				{
					logger.info("切换到窗口：" + p_windowName + TextStore.T_Pass);
					break;
				}

			}
		}
	}

	public void newRunScript(String p_script) {

		CommonLib.sleep(DataStore.D_Wait_ShortTime);

		try {
			((JavascriptExecutor) driver).executeScript(p_script);
			logger.info("执行jS代码：" + p_script + TextStore.T_Pass);

		} catch (Exception e) {
			logger.severe(
					TextStore.T_Exception + "newRunScript(String p_script)" + TextStore.T_DetailInfo + e.toString());

		}
	}

	public boolean newIsElementPresent(String p_id) {
		try {
			driver.findElement(parseObject(p_id));
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	/*
	 * public String newWebElement(String p_id) {
	 * 
	 * CommonLib.sleep(DataStore.D_Wait_ShortTime);
	 * 
	 * WebElement element = null; try {
	 * 
	 * element = driver.findElement(parseObject(p_id));
	 * 
	 * logger.info(TextStore.T_ClickObject + p_id + TextStore.T_Pass);
	 * 
	 * }
	 * 
	 * catch (Exception e) { logger.severe(TextStore.T_Exception +
	 * "newWebElement(String p_id)" + TextStore.T_DetailInfo + e.toString());
	 * 
	 * } return element.getText(); }
	 */

	/*public static String screenShot() {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String file = DataStore.D_ScreenShotPath + File.separator + "shot-" + CommonLib.getCurrentDate() + ".png";
		try {
			FileUtils.copyFile(src, new File(file));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return file;
	}*/
	
	public void screenShot() {

		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenshot = DataStore.D_ScreenShotPath + File.separator + "shot-" + CommonLib.getCurrentDate() + ".png";
		try {
			FileUtils.copyFile(srcFile, new File(screenshot));
			HtmlFile.setScreenshot(screenshot); //日志接口
			logger.info("截屏成功！截屏信息是 —— "+screenshot);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
