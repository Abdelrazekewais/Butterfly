package Tests;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.Test;

import ProjectPages.BFPageBase;
import ProjectPages.Cuentas;
import ProjectPages.Log_In_Page;

public class CuentasTests extends BFTestBase{
	BFPageBase BFPageBaseOBJ; 
	Cuentas CuentasOBJ; 
	Log_In_Page LogInOBJ;
	
	
	
	@Test
	public void TC33_Change_the_owner_of_an_existing_account_Reassign_Account_Potential_bag_Not_Debt_Not_Active_services_Not_Active_BA() throws InterruptedException, InvalidFormatException
	{
		CuentasOBJ = new Cuentas(driver);
		LogInOBJ = new Log_In_Page(driver);
		
		LogInOBJ.Log_In_SalesProfessional();
		CuentasOBJ.Reasignar_Cuenta_NOT_Active("61924885F");
		BFPageBase.CreateEvidence("TC33_Change_the_owner_of_an_existing_account_Reassign_Account_Potential_bag_Not_Debt_Not_Active_services_Not_Active_BA");
	}

	
	@Test
	public void TC36_Access_Account_Same_dealer_PC() throws InterruptedException, InvalidFormatException
	{
		CuentasOBJ = new Cuentas(driver);
		LogInOBJ = new Log_In_Page(driver);
		
		
		LogInOBJ.Log_In_Partner_Manager();
		CuentasOBJ.Tener_Acceso("N4957839F");
		BFPageBase.CreateEvidence("TC36_Access_Account_Same_dealer_PC");
	}
	
	
	@Test
	public void TC164_New_field_is_included_in_the_next_Business_Account_list_views_Todos_los_clientes_empresas_Sales_manager() throws InterruptedException, InvalidFormatException
	{
		CuentasOBJ = new Cuentas(driver);
		LogInOBJ = new Log_In_Page(driver);
		BFPageBaseOBJ = new BFPageBase(driver);
		
		LogInOBJ.Log_In_SalesManager();
		BFPageBase.CuentasHomePage();
		CuentasOBJ.Seleccionar_Vista("Empresa");
		Assert.assertTrue(CuentasOBJ.Verifcar_Vista_De_Cuentas().equalsIgnoreCase("Todos los clientes empresa"));
		BFPageBase.CreateEvidence("TC164 - New field is included in the next Business Account list views (Todos los clientes empresas) Sales manager");
		
	}
	
	
	@Test
	public void TC165_Account_Name_field_of_Business_Accounts_Editable_VF_Support() throws InterruptedException, InvalidFormatException
	{
		CuentasOBJ = new Cuentas(driver);
		LogInOBJ = new Log_In_Page(driver);
		BFPageBaseOBJ = new BFPageBase(driver);
		
		LogInOBJ.Log_In_Soporte();
		BFPageBase.CuentasHomePage();
		CuentasOBJ.Buscar_Cuentas("R0318681D");
		CuentasOBJ.Modificar_Nombre_DeCuenta();
		Assert.assertTrue(CuentasOBJ.Verificar_Nombre_De_Cuenta().contains("Cuenta" +BFPageBase.formattedDate));
		BFPageBase.CreateEvidence("TC165 - Account Name field of Business Accounts Editable (VF Support)");
	
	}
	
	@Test
	public void TC166_Account_Name_field_of_Business_Accounts_Editable_VF_Partner_Sales_manager() throws InterruptedException, InvalidFormatException
	{
		CuentasOBJ = new Cuentas(driver);
		LogInOBJ = new Log_In_Page(driver);
		BFPageBaseOBJ = new BFPageBase(driver);
		
		LogInOBJ.Log_In_Partner_Manager();
		driver.get("https://butterfly--qa1.sandbox.my.site.com/partners/s/account/Account/Default");
		CuentasOBJ.Buscar_Cuentas("79782862W");
		CuentasOBJ.Modificar_Nombre_DeCuenta_Partner();
		Assert.assertTrue(CuentasOBJ.Verificar_Nombre_De_Cuenta_Partner().contains("Cuenta" +BFPageBase.formattedDate));
		BFPageBase.CreateEvidence("TC165 - Account Name field of Business Accounts Editable (VF Partner Sales Manager)");
	
	}
	
	
	
}
