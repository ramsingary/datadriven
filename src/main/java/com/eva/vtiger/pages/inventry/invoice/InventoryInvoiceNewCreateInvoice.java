package com.eva.vtiger.pages.inventry.invoice;

import java.util.Map;

import com.eva.vtiger.pages.inventry.invoiceOr.InventoryInvoiceNewCreateInvoiceOr;
import com.eva.vtiger.utils.WebUtil;

public  class InventoryInvoiceNewCreateInvoice  extends InventoryInvoiceNewCreateInvoiceOr{

	//TB--TextBox
	//BT--Button
	//RB--Radio Button
	//LK--Link
	private WebUtil wt;
	
	public InventoryInvoiceNewCreateInvoice(WebUtil wu) {
		super(wu);
		this.wt=wu;
	}
	
	public  String fillUpInvoiceInformation(Map<String, String> testcaseDataMap,String expSubjectName) {
		wt.sendKeys(getExpSubjectNameTB(),expSubjectName);
		wt.sendKeys(getCustomerNumberTB(), ""+expSubjectName+".er@gmail.com");
		InventoryInvoiceNewCreateInvoiceCommonAdd commonAdd= new InventoryInvoiceNewCreateInvoiceCommonAdd(wt); 
		wt.click(getSelectContactBT());
		//String firstnamevalue=getTestCaseData.get("firstname");
		commonAdd.addElementName(testcaseDataMap.get("firstname"), "firstname");
		wt.sendKeys(getPurchaseOrderTB(), "Contact list");
		wt.click(getAccountNameTB());
		wt.myThread(2000);
		commonAdd.addElementName(testcaseDataMap.get("accountname"),"accountname");
		wt.myClear(getBillingAddressTB());
		wt.sendKeys(getBillingAddressTB(),testcaseDataMap.get("adress"));
		wt.myClear(getBillPoBoxTB());
		wt.sendKeys(getBillPoBoxTB(),"bhadohi");
		wt.myClear(getBillCityTB());
		wt.sendKeys(getBillCityTB(), "kaushambi");
		wt.myClear(getBillStateTB());
		wt.sendKeys(getBillStateTB(),"utter pradesh");
		wt.myClear(getBillCodeTB());
		wt.sendKeys(getBillCodeTB(), "9856");
		wt.myClear(getBillCountryTB());
		wt.sendKeys(getBillCountryTB(), "indian");
		wt.click(getCopyBillingAddressRB());
		wt.click(getProductLNK());
		return expSubjectName;
	}


}
