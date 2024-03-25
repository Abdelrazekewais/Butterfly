package Tests;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.Test;

import ProjectPages.BFPageBase;
import ProjectPages.Leads;
import ProjectPages.LeadsPC;
import ProjectPages.Log_In_Page;

public class LeadsTests extends BFTestBase{
	
	Log_In_Page LogInObj;
	BFPageBase PagebaseObj;
	Leads LeadOBJ; 
	LeadsPC LeadsPCOBJ;
	
	String Lead_Name="Lead Automation" + BFPageBase.formattedDate;
	@Test
	public void Create_Leads() throws InterruptedException, InvalidFormatException
	{
		LogInObj = new Log_In_Page(driver);
		LeadOBJ = new Leads(driver);
		PagebaseObj = new BFPageBase(driver);
		LogInObj.LogIn_SalesForce_FL("salesmanager@tsse.com.vf.qa1", "contra@2023");
		//LogInObj.LogIn_SalesForce_FL("salesprofessional2@tsse.com.vf.qa1", "calidad@2023");
		LeadOBJ.Crear_Nueva_Lead("SALAMANCA", "CALVARRASA DE ARRIBA");
		Assert.assertTrue(driver.getTitle().contains("Lead Automation"));
		BFPageBase.CreateEvidence("Create_Leads");
	}
		
	@Test
	//Este caso tiene un defecto porque se cambia a Cualificado en vez de Trabajando 27-12-2023
	public void TC149_Automatic_status_change_user_not_MKT_Vf_sales_rofesional() throws InterruptedException, InvalidFormatException 
	{
		LogInObj = new Log_In_Page(driver);
		LeadOBJ = new Leads(driver);
		PagebaseObj = new BFPageBase(driver);
		
		LogInObj.LogIn_SalesForce_FL("salesprofessional2@tsse.com.vf.qa1", "calidad@2023");
		LeadOBJ.Verify_Lead_Not_MKT(Lead_Name);
		Assert.assertTrue(LeadOBJ.VerifyEstado.getAttribute("data-value").equals("Trabajando"));
		BFPageBase.CreateEvidence("TC149_Automatic_status_change_user_not_MKT_Vf_sales_rofesional");
		
	}
		
	@Test
	//Pasar un caso creado por usuario MKT.
	public void TC150_Automatic_status_change_user_MKT_VF_Sales_Manager() throws InterruptedException, InvalidFormatException
	{
		LogInObj = new Log_In_Page(driver);
		LeadOBJ = new Leads(driver);
		PagebaseObj = new BFPageBase(driver);
		
		LogInObj.LogIn_SalesForce_FL("salesmanager@tsse.com.vf.qa1", "contra@2023");
		LeadOBJ.Verify_Lead_User_MKT("C86452349");
		Assert.assertTrue(LeadOBJ.VerifyEstado.getAttribute("data-value").equals("Nuevo"));
		BFPageBase.CreateEvidence("TC150_Automatic_status_change_user_MKT_VF_Sales_Manager");
	}
		
	//Pass an Id for a Lead in status "New"
	@Test
	public void TC151_Automatic_status_change_with_only_the_owner_filed_updated_Vf_partner_sales_professional() throws InterruptedException, InvalidFormatException
	{
		LogInObj = new Log_In_Page(driver);
		LeadOBJ = new Leads(driver);
		LeadsPCOBJ = new LeadsPC(driver);
		PagebaseObj = new BFPageBase(driver);
		
		LogInObj.LogIn_SalesForce_PC("partnermanager1@tsse.com.vf.qa1", "contra@2023");
		LeadsPCOBJ.OpenLeadsHomePagePC();
		LeadsPCOBJ.Search_Leads("00Q7Y00000D8piTUAR");
		
	
		LeadsPCOBJ.Verify_Lead_Con_Cambio_Propietario();
		Assert.assertTrue(LeadsPCOBJ.VerifyEstadoPC.getText().equals("Nuevo"));
		BFPageBase.CreateEvidence("TC151 - Automatic status change with only the owner filed updated (Vf partner sales professional)");
	}
	//Deleted case. will be added in later regressions. 21-12-2024
	@Test
	public void TC28_Import_file_Support() throws InterruptedException
	{
		LogInObj = new Log_In_Page(driver);
		LeadOBJ = new Leads(driver);
		LeadsPCOBJ = new LeadsPC(driver);
		PagebaseObj = new BFPageBase(driver);
		
		LogInObj.Log_In_Soporte();
		BFPageBase.LeadsHomePage();
		LeadOBJ.Crear_Lead_Con_Bulk();	
	}
	
}
