package com.frank.projectlib;

import org.openqa.selenium.WebElement;

import com.frank.framework.AppiumLibAndroid;
import com.frank.framework.CommonLib;
import com.frank.store.DataStore;
import com.frank.store.TextStore;

public class AndroidDriverLibExtension extends AppiumLibAndroid {

	public AndroidDriverLibExtension() {
		super(driver);
	}

	public String newElements(String p_id) {

		CommonLib.sleep(DataStore.D_Wait_ShortTime);

		WebElement element = null;
		try {

			element = driver.findElement(parseObject(p_id));

			logger.info(TextStore.T_FindObject + p_id + TextStore.T_Pass);

		}

		catch (Exception e) {
			logger.severe(TextStore.T_Exception + "newWebElement(String p_id)" + TextStore.T_DetailInfo + e.toString());

		}
		return element.getText();
	}

	public boolean newElement(String p_id) {

		CommonLib.sleep(DataStore.D_Wait_ShortTime);

		try {

			driver.findElement(parseObject(p_id));

			logger.info(TextStore.T_FindObject + p_id + TextStore.T_Pass);
			return true;
		}

		catch (Exception e) {
			logger.severe(TextStore.T_Exception + "newWebElement(String p_id)" + TextStore.T_DetailInfo + e.toString());

		}
		return false;
	}
}
