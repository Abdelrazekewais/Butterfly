package Tests;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.Test;

import ProjectPages.BFPageBase;
import ProjectPages.Casos;
import ProjectPages.Log_In_Page;
import ProjectPages.OpportunitiesPage;

public class CasosTests extends BFTestBase{
	
	Log_In_Page LogInObj;
	BFPageBase PagebaseObj;
	Casos CasosOBJ;
	OpportunitiesPage OPPObj;
	
	
	@Test
	public void TC58_Create_a_Cases_linked_to_opportunities_without_Complexity() throws InterruptedException, InvalidFormatException
	{
		LogInObj = new Log_In_Page(driver); 
		CasosOBJ = new Casos(driver); 
		PagebaseObj = new BFPageBase(driver);
		OPPObj = new OpportunitiesPage(driver);
		
		LogInObj.Log_In_SalesProfessional();
		//Pass an OPP without complexity filled.
		OPPObj.SearchAndOpenOPP("OPP-0011162989");
		CasosOBJ.Creat_CasoPreventa_Con_Tripleta();
		Assert.assertTrue(PagebaseObj.Verificar_Error_Message().equalsIgnoreCase("Acción no permitida. "
				+ "No es posible crear el caso sin haber informado el campo Complejidad."));
		BFPageBase.CreateEvidence("TC58 - Create a Cases linked to opportunities without Complexity");	
	}
	
	
	@Test
	public void TC152_Cancelled_Pre_Sales_Support_Case_cannot_be_assigned_to_presales_user_Sales_Professional() throws InterruptedException, InvalidFormatException
	{
		LogInObj = new Log_In_Page(driver); 
		CasosOBJ = new Casos(driver); 
		PagebaseObj = new BFPageBase(driver);
		
		LogInObj.Log_In_SalesProfessional();
		CasosOBJ.Asignar_Caso_cancelado("01149676");
		BFPageBase.CreateEvidence("TC152 - Cancelled Pre-Sales Support Case cannot be assigned to presales user (Sales Professional)");
		
	}

	

	
}
