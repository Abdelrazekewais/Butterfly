package Tests;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import ProjectPages.AdminCases;
import ProjectPages.BFPageBase;
import ProjectPages.Log_In_Page;

public class AdminTest extends BFTestBase{
	
	Log_In_Page LogInObj;
	BFPageBase PagebaseObj;
	AdminCases AdminCasesOBJ; 
	
	@Test
	public void TC31_Modification_and_search_Administrator() throws InterruptedException, InvalidFormatException
	{
		LogInObj = new Log_In_Page(driver);
		PagebaseObj = new BFPageBase(driver);
		AdminCasesOBJ = new AdminCases(driver);
		
		LogInObj.Log_In_Admin();
		AdminCasesOBJ.BuscarYAbrir_Record("VBT-000010");
		AdminCasesOBJ.Modificar_Miembros_De_Equipo();
		AdminCasesOBJ.CambioMasivo();
		BFPageBase.CreateEvidence("TC31_Modification_and_search_Administrator");
		
	}

}
