package com.eva.vtiger.testscripts;

import org.testng.annotations.Test;

import com.eva.vtiger.pages.common.CommonReusableCodes;
import com.eva.vtiger.pages.marketing.leads.MarketingLaedsNewCreateLead;
import com.eva.vtiger.pages.marketing.leads.MarketingLeadsInformationPage;
import com.eva.vtiger.pages.marketing.leads.MarketingLeadsLandingPage;
import com.eva.vtiger.utils.WebUtil;

public class MarketingLeadsTestScripts extends BaseTest{
	WebUtil webtl=WebUtil.getObject();

	
	@Test(priority = 6,groups = {"Smoke"})
	public void verifyVT007SearchLeads() {
webtl.printMessage("====  verifyVT008SearchLeads starts from here====");
//webtl.launchBrowser();
//webtl.goToHitUrl("http://localhost:8888");
//		CommonReusableCodes cc= new CommonReusableCodes(webtl);
//		cc.login();
		cc.goToMarketingLeadsLink();
		cc.creatNewPluseButton();
		MarketingLaedsNewCreateLead creatLead=new MarketingLaedsNewCreateLead(webtl);
		String expFirstName =creatLead.newCreatMarketingLeads();
		cc.saveButton();
		cc.goToMarketingLeadsLink();
		MarketingLeadsLandingPage malp=new MarketingLeadsLandingPage(webtl);
		String searchedName=malp.innerTextOfSearchedElement(expFirstName, "firstname");
		if (searchedName.contains(expFirstName)) {
			webtl.printMessage("passed! your data "+searchedName+" is matched that you are searching");
		} else {
			webtl.printMessage("failed! your data "+searchedName+" is not  matched that you are searching");
		}
//		cc.logOut();
//		webtl.myQuit();
		webtl.printMessage("====  verifyVT008SearchLeads starts from here====");
	}
	@Test(priority = 7,groups = {"Smoke"})
	public void verifyVT008CreateLeads() {
		webtl.printMessage("====  verifyVT00CreateLeads ends from here====");
//		webtl.launchBrowser();
//		webtl.goToHitUrl("http://localhost:8888");
//		CommonReusableCodes cc= new CommonReusableCodes(webtl);
//		cc.login();
		cc.goToMarketingLeadsLink();
		cc.creatNewPluseButton();
		MarketingLaedsNewCreateLead creatLead=new MarketingLaedsNewCreateLead(webtl);
		String expFirstName =creatLead.newCreatMarketingLeads();
		cc.saveButton();
		cc.goToMarketingLeadsLink();
		MarketingLeadsLandingPage mlLandingPage=new MarketingLeadsLandingPage(webtl);
		String searchData=mlLandingPage.innerTextOfSearchedElement(expFirstName, "firstname");
		if (searchData.contains(expFirstName)) {
			webtl.printMessage("your search data "+searchData+" is matched that you are searching");
			webtl.printMessage("Passed !, "+searchData+" name is created successfully");
		} else {
			webtl.printMessage("your search data data "+searchData+" is not  matched that you are searching");
			webtl.printMessage("Failed !, "+searchData+" name is not created successfully");
		}
//		cc.logOut();
//		webtl.myQuit();
		webtl.printMessage("====  verifyVT009CreateLeads ends from here====");
	}
	@Test(priority = 8,groups = {"Smoke"})
	public void verifyVT009DeleteLead() {
		webtl.printMessage("====  verifyVT0010DeleteLead starts from here====");
//		webtl.launchBrowser();
//		webtl.goToHitUrl("http://localhost:8888");
//		CommonReusableCodes cc= new CommonReusableCodes(webtl);
//		cc.login();
		cc.goToMarketingLeadsLink();
		cc.creatNewPluseButton();
		MarketingLaedsNewCreateLead creatLead=new MarketingLaedsNewCreateLead(webtl);
		creatLead.newCreatMarketingLeads();
		cc.saveButton();
		webtl.myThread(3000);
		MarketingLeadsInformationPage mlInfoPage=new MarketingLeadsInformationPage(webtl);
		String leadResult=mlInfoPage.innerTextsearchForLeadNumber();
		String expResult="No Lead Found !";
 if (expResult.equalsIgnoreCase(leadResult)) {
		System.out.println("Passed!,your created lead has been deleted successfully");
} else {
	System.out.println("failed!,your created lead hasn't been deleted successfully");

}
//		cc.logOut();
//		webtl.myQuit();
		webtl.printMessage("====  verifyVT0010DeleteLead ends from here====");
	}
	@Test(priority = 9,groups = {"Regression"})
	public void verifyVT010LeadsTableLinks() {
		webtl.printMessage("===== verifyVT011LeadsTableLinks starts from here ======");
//		webtl.launchBrowser();
//		webtl.goToHitUrl("http://localhost:8888");
//		CommonReusableCodes cc= new CommonReusableCodes(webtl);
//		cc.login();
		cc.goToMarketingLeadsLink();
		cc.creatNewPluseButton();
		MarketingLaedsNewCreateLead creatLead=new MarketingLaedsNewCreateLead(webtl);
		String expLeadsName=creatLead.newCreatMarketingLeads();
		cc.saveButton();
		webtl.myThread(3000);
		cc.goToMarketingLeadsLink();
//		MarketingLeadsLandingPage mlLandingPage=new MarketingLeadsLandingPage(webtl);
//		String firstNameBeforeClickText=mlLandingPage.innerTextOfSearchedElement(expLeadsName, "firstname");
//		MarketingLeadsInformationPage mlip=new MarketingLeadsInformationPage(webtl);
//		String firstNameAfterClickText=mlip.firstName();
//		 
//		if (firstNameBeforeClickText.equalsIgnoreCase(firstNameAfterClickText)) {
//			webtl.printMessage("Passed !,first name is same After clicking the first name link in marketing leads");
//		} else {
//			webtl.printMessage("Passed !,first name is not same After clicking the first name link in marketing leads");
//		}
//		cc.logOut();
//		webtl.myQuit();
		webtl.printMessage("====  verifyVT011LeadsTableLinks ends from here====");
	
}
}
