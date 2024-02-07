
package com.eva.vtiger.testscripts;

import org.testng.annotations.Test;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.eva.vtiger.pages.common.CommonReusableCodes;
import com.eva.vtiger.pages.inventry.invoice.InventoryInvoiceNewCreateInvoice;
import com.eva.vtiger.utils.DataUtil;
import com.eva.vtiger.utils.DataUtil1;
import com.eva.vtiger.utils.WebUtil;

public class InventryInvoiceTestScripts extends BaseTest{
	
	
	
	///  requirement   Testing Logic  TestCase TestScript
	///  TDD -  Test Driven Development
	 
	WebUtil wt=WebUtil.getObject();

	@Test(dataProvider = "getData")
	public void verifyVT006AccountAndContactAddOnInvoiceForm(Object data) {
		Map<String, String> testcaseDataMap=(Map<String, String>)data;
		System.out.println(testcaseDataMap);
		
		wt.printMessage("====  verifyVT0012AccountAndContactAddOnInvoiceForm starts from here====");
//		wt.launchBrowser();
//		wt.goToHitUrl("http://localhost:8888");
//		CommonReusableCodes cc=new CommonReusableCodes(wt);
//		cc.login();
		cc.goToInventoryInvoiceLink();
		cc.creatNewPluseButton();
		InventoryInvoiceNewCreateInvoice creatInvoice= new InventoryInvoiceNewCreateInvoice(wt);
		creatInvoice.fillUpInvoiceInformation(testcaseDataMap,"Test Account Name And Contact Name Addition");
		wt.printMessage("====  verifyVT0012AccountAndContactAddOnInvoiceForm ends from here====");

	}
	
   ///  cadric beust 
	
	    /////   TestNG  JUnit
	
	   ////  Cucumber   -   BDD 
	
	
	
	
	
	
	
}
