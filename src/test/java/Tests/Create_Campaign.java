package Tests;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.Test;

import ProjectPages.BFPageBase;
import ProjectPages.Campaigns;
import ProjectPages.Log_In_Page;

public class Create_Campaign extends BFTestBase {
	Campaigns campanasObject;
	Log_In_Page LogInObj;
	BFPageBase PagebaseObj;

	@Test(priority = 1)
	public void TC140_Create_Campaign_VF_Sales_Operations()
			throws InterruptedException, InvalidFormatException, IOException {
		LogInObj = new Log_In_Page(driver);
		campanasObject = new Campaigns(driver);

		LogInObj.LogIn_SalesForce_FL("salesoperations@tsse.com.vf.qa1", "sales@2023");
		
		campanasObject.Create_New_campaign();
		Assert.assertTrue(Campaigns.Verification.contains("Campaña Automation" +Campaigns.formattedDate));
		System.out.println(Campaigns.Verification);
		BFPageBase.CreateEvidence("TC140_Create_Campaign_VF_Sales_Operations");
		
	}

	@Test(priority = 2)
	public void TC141_Create_Campaign_VF_Support() throws InterruptedException, InvalidFormatException, IOException {
		LogInObj = new Log_In_Page(driver);
		campanasObject = new Campaigns(driver);

		LogInObj.LogIn_SalesForce_FL("soporte@tsse.com.vf.qa1", "Suport@2023");
		
		campanasObject.Create_New_campaign();
		Assert.assertTrue(Campaigns.Verification.contains("Campaña Automation" +Campaigns.formattedDate));
		System.out.println(Campaigns.Verification);
		BFPageBase.CreateEvidence("TC141_Create_Campaign_VF_Support");
	}

	@Test(priority = 3)
	
	public void TC142_Delete_Campaign_Draft_status_VF_Support()
			throws InvalidFormatException, IOException, InterruptedException {
		LogInObj = new Log_In_Page(driver);
		campanasObject = new Campaigns(driver);
		
		LogInObj.LogIn_SalesForce_FL("salesoperations@tsse.com.vf.qa1", "sales@2023");
		
		campanasObject.Delet_Campaign();
	
		// campanasObject.MakeSureCampDeleted();
		// Assert.assertEquals("Deleted", Campaigns.DeletConfirmation);
		Assert.assertTrue(Campaigns.ConfMessage.contains("Deshacer"));
		BFPageBase.CreateEvidence("TC142_Delete_Campaign_Draft_status_VF_Support");
		
	}	
	}


