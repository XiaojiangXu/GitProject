package com.frank.projectlib;

import org.openqa.selenium.WebElement;

import com.frank.framework.CommonLib;
import com.frank.framework.WebDriverLib;
import com.frank.store.DataStore;
import com.frank.store.TextStore;

public class WebDriverLibExtension extends WebDriverLib {

	public WebDriverLibExtension() {
		super(driver);
	}
	// 1.重写方法
	// 2.扩展方法

	public String newGetAttribute() {

		return "";
	}

	public void newAssertEquals(String p_message, String p_expected, String p_actual) {
		try {
			super.newAssertEquals(p_message, p_expected, p_actual);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String newWebElement(String p_id) {

		CommonLib.sleep(DataStore.D_Wait_ShortTime);

		WebElement element = null;
		try {

			element = driver.findElement(parseObject(p_id));

			logger.info(TextStore.T_ClickObject + p_id + TextStore.T_Pass);

		}

		catch (Exception e) {
			logger.severe(TextStore.T_Exception + "newWebElement(String p_id)" + TextStore.T_DetailInfo + e.toString());

		}
		return element.getText();
	}

}
