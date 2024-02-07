package com.eva.vtiger.testscripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.eva.vtiger.pages.common.CommonReusableCodes;
import com.eva.vtiger.pages.marketing.accounts.MarketingAccountLandingPage;
import com.eva.vtiger.pages.marketing.accounts.MarketingAccountsNewCreateAccount;
import com.eva.vtiger.utils.WebUtil;

public class MarketingAccountTestScripts extends BaseTest{
	
	///  @BeforeClass  @AfterClass
	
	
	@Test(priority = 1,groups = {"Smoke"})
	public void verifyVT001CreateAccount() throws InterruptedException {
		webtl.printMessage("====verifyVT001CreateAccount starts from here====");

		cc.goToMarketingAccountsLink();
		cc.creatNewPluseButton();
		MarketingAccountsNewCreateAccount malp= new MarketingAccountsNewCreateAccount(webtl);
		String expAccountName =malp.fillUpBasicInformation();		
		cc.saveButton();
		cc.goToMarketing();
		cc.goToMarketingAccountsLink();
		MarketingAccountLandingPage acLandingPage= new MarketingAccountLandingPage(webtl);
		String actAccountName=acLandingPage.innerTextOfSearchedElement(expAccountName, "accountname");
		if (actAccountName.equalsIgnoreCase(expAccountName)) {
			webtl.printMessage("Passed !,new Account is created successfully");
		} else {
			webtl.printMessage("Failed !,new Account is not created successfully");
		}
	}



	@Test(priority=2, alwaysRun = true,groups = {"Smoke"})
//If set to true, this test method will always be run even if it depends on a method 
//that failed.This attribute will be ignored if this test doesn't depend on any method or group.
//	Default value is false.

	public void verifyVT002DeleteAccount() throws InterruptedException {
	
		webtl.printMessage("====  verifyVT002DeleteAccount starts from here====");
		
		cc.goToMarketingAccountsLink();
		cc.creatNewPluseButton();
		MarketingAccountsNewCreateAccount malp= new MarketingAccountsNewCreateAccount(webtl);
		String actAccountName =malp.fillUpBasicInformation();		
		cc.saveButton();
		MarketingAccountLandingPage acLandingPage= new MarketingAccountLandingPage(webtl);
		acLandingPage.deleteAndSearchAccountStatus(actAccountName, "accountname");
		
		webtl.printMessage("====  verifyVT002DeleteAccount ends from here====");
	}
////  sorting

	@Test(priority = 3,groups = {"Regression"})
	public void verifyVT003SearchAccount() throws InterruptedException {
		webtl.printMessage("====  verifyVT003SearchAccount Starts from here====");
	
		cc.goToMarketingAccountsLink();
		cc.creatNewPluseButton();
		MarketingAccountsNewCreateAccount malp= new MarketingAccountsNewCreateAccount(webtl);
		String expAccountName =malp.fillUpBasicInformation();		
		cc.saveButton();
		cc.goToMarketing();
		cc.goToMarketingAccountsLink();
		MarketingAccountLandingPage acLandingPage= new MarketingAccountLandingPage(webtl);
		String actAccountName=acLandingPage.innerTextOfSearchedElement(expAccountName, "accountname");
		if (actAccountName.equalsIgnoreCase(expAccountName)) {
			webtl.printMessage("Passed!,your expected name is searched successfully");
		} else {
			webtl.printMessage("failed!,your expected name is not searched successfully");
		}


		webtl.printMessage("====  verifyVT003SearchAccount ends from here====");
	}

	@Test(priority = 4,groups = {"Smoke"})
	public void verifyVT004DuplicateAccount() {
		webtl.printMessage("======= verifyVT004DuplicateAccount Starts from here ======");
//		webtl.launchBrowser();
//		webtl.goToHitUrl("http://localhost:8888");
//		CommonReusableCodes cc= new CommonReusableCodes(webtl);
//		cc.login();
		cc.goToMarketingAccountsLink();
		cc.creatNewPluseButton();
		MarketingAccountsNewCreateAccount malp= new MarketingAccountsNewCreateAccount(webtl);
		malp.fillUpBasicInformation();		
		cc.saveButton();
		MarketingAccountLandingPage acLandingPage= new MarketingAccountLandingPage(webtl);
		acLandingPage.DuplicateAndEditStatus();
	}

	@Test(priority = 5,groups = {"Regression"})
	public void verifyVT005AccountEditable()  {
		webtl.printMessage("===== verifyVT005AccountEditable starts from here ======");
//		webtl.launchBrowser();
//		webtl.goToHitUrl("http://localhost:8888");
//		CommonReusableCodes cc= new CommonReusableCodes(webtl);
//		cc.login();
		cc.goToMarketingAccountsLink();
		cc.creatNewPluseButton();
		MarketingAccountsNewCreateAccount malp= new MarketingAccountsNewCreateAccount(webtl);
		String acNameBeforeEdit=malp.fillUpBasicInformation();		
		cc.saveButton();
		MarketingAccountLandingPage acLandingPage= new MarketingAccountLandingPage(webtl);
		String acNameAfterEdit=acLandingPage.editAccountInformation();
		if (!acNameBeforeEdit.equalsIgnoreCase(acNameAfterEdit)) {  ///  !...not equalsIgnoreCase
			System.out.println("Passed !,your Account name is editable because your before edit A/C name ="+acNameBeforeEdit+" "
					+ "and after edit A/C name ="+acNameAfterEdit+" is different");

		} else {
			System.out.println("Failed !,your Account name is editable because your before edit A/C name ="+acNameBeforeEdit+" "
					+ "and after edit A/C name ="+acNameAfterEdit+" is same");
		}
//		cc.logOut();
//		webtl.myQuit();
		webtl.printMessage("===== verifyVT005AccountEditable ends from here ======");
	}
}