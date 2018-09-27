package com.frank.framework;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import com.frank.reportlib.html.HtmlFile;
import com.frank.reportlib.html.HtmlFileGlobal;
import com.frank.store.DataStore;
import com.frank.store.TextStore;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AppiumLibAndroid {

	public AppiumLibAndroid(AndroidDriver<MobileElement> driver) {

	}

	protected static Logger logger = Logger.getLogger(DataStore.D_DebugLogger);
	protected static AndroidDriver<MobileElement> driver = null;

	private FileHandler fileHandler = null;

	private String deviceName = DataStore.D_deviceName;
	private String platformName = DataStore.D_platformName;
	private String appPackage = DataStore.D_appPackage;
	private String appActivity = DataStore.D_appActivity;

	//static ReportEntry re = new ReportEntry();

	public void newSetup(String p_Name) {

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
		// 启动appium
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", deviceName);
		// capabilities.setCapability("automationName", "Appium");
		capabilities.setCapability("platformName", platformName);
		// capabilities.setCapability("platformVersion", "5.1");
		capabilities.setCapability("noReset", "true"); // 不需要再次安装apk

		// 配置测试apk
		capabilities.setCapability("appPackage", appPackage);
		capabilities.setCapability("appActivity", appActivity);
		capabilities.setCapability("sessionOverride", true); // 每次启动时覆盖session，否则第二次后运行会报错不能新建session
		capabilities.setCapability("unicodeKeyboard", true); // 设置键盘
		capabilities.setCapability("resetKeyboard", true); // 设置默认键盘为appium的键盘

		try {
			HtmlFileGlobal.createLog(DataStore.D_LogPath +File.separator + p_Name + ".html");
			driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			CommonLib.sleep(DataStore.D_Wait_ShortTime);
			logger.info(TextStore.T_Init + TextStore.T_Pass);

		} catch (Exception e) {
			driver.quit();
			logger.severe("launch Android driver fail！" + e.toString());
		}
		try {
			startRecord(p_Name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void startRecord(String p_Name) throws Exception {
		Runtime rt = Runtime.getRuntime();
		rt.exec("cmd.exe /C adb shell screenrecord /sdcard/" + "runCase_" + p_Name + ".mp4");
	}

	public void newTeardown() {
		driver.quit();
		logger.info("AndroidDriverLib 销毁");
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

			driver.findElement(parseObject(p_id)).isDisplayed();
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

	
/*	public static String screenshot() {
		File screen = driver.getScreenshotAs(OutputType.FILE);
		String screenFile = DataStore.D_ScreenShotPath + File.separator + "shot-" + CommonLib.getCurrentDate() + ".png";
		try {
			FileUtils.copyFile(screen, new File(screenFile));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return screenFile;
	}*/
	
	public void screenShot() {
		File srcFile = driver.getScreenshotAs(OutputType.FILE);
		String screenshot = DataStore.D_ScreenShotPath + File.separator + "shot-" + CommonLib.getCurrentDate() + ".png";
		try {
			FileUtils.copyFile(srcFile, new File(screenshot));
			HtmlFile.setScreenshot(screenshot); //日志接口
			logger.info("截屏成功！截屏信息是 —— "+screenshot);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void newfindElementByAndroidUIAutomator(String p_id) {

		CommonLib.sleep(DataStore.D_Wait_ShortTime);

		try {

			driver.findElementByAndroidUIAutomator(scrollToByText(p_id)).click();
			logger.info(TextStore.T_ClickObject + p_id + TextStore.T_Pass);

		}

		catch (Exception e) {
			logger.severe(TextStore.T_Exception + "newfindElementByAndroidUIAutomator(String p_id)" + TextStore.T_DetailInfo + e.toString());

		}

	}

	public static String scrollToByText(String text) {
		String uiScrollables = myUiScrollable("new UiSelector().descriptionContains(\"" + text + "\")")
				+ myUiScrollable("new UiSelector().textContains(\"" + text + "\")");
		return uiScrollables;

	}

	private static String myUiScrollable(String uiSelector) {
		return "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(" + uiSelector
				+ ".instance(0));";
	}
}
