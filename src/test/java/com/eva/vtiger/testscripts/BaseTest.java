package com.eva.vtiger.testscripts;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.eva.vtiger.pages.common.CommonReusableCodes;
import com.eva.vtiger.utils.DataUtil1;
import com.eva.vtiger.utils.WebUtil;

import lombok.Getter;

@Getter
public class BaseTest {
    
	protected WebUtil webtl=  WebUtil.getObject();
	protected CommonReusableCodes cc;
	
//	@BeforeGroups(groups="Smoke")
//	public void x() {
//		System.out.println("extent report  intialization");
//	}
	@Parameters({"username", "password"})
	@BeforeMethod(groups = "Smoke")
    public void beforeTestCase(String uname, String pwd) {
		cc=new CommonReusableCodes(webtl);
		cc.login(uname, pwd);
    }
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("extent report object intialization");

	}
	
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("extent report finalization");

	}
	
	@BeforeTest
	public void beforeTestTag() {
		System.out.println("connect to data base");

	}
	@AfterTest
	public void afterTestTag() {
		System.out.println("disconnect to data base");

	}	
	@Parameters({"browser"})
	@BeforeClass(groups = "Smoke")
	public void beforeClass() {
		webtl.launchBrowser();
		webtl.goToHitUrl("http://localhost:8888");
	}
	
	@AfterClass(groups = "Smoke")
	public void afterClass() {
		webtl.myQuit();
		
	}
	
	
	@AfterMethod(groups = "Smoke")
	public void afterTestcase() {
		cc.logOut();	
	}
	@DataProvider
	public Object[][] getData(Method method) {
		DataUtil1 data=new DataUtil1();
		List<Map<String, String>> testcaseDataMapList=data.getAllTestCaseData(method.getName());
		int matchingTcIDCount =testcaseDataMapList.size();
		Object[][] dim2Arr=new Object[matchingTcIDCount][1];
		for(int i=0;i<=matchingTcIDCount-1;i++) {
			dim2Arr[i][0]=testcaseDataMapList.get(i);		
	}
		return dim2Arr;
	}

	
	
}
