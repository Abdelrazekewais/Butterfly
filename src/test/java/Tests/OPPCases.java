package Tests;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.Test;

import ProjectPages.BFPageBase;
import ProjectPages.Casos;
import ProjectPages.Log_In_Page;
import ProjectPages.OPPsPartnerCommunity;
import ProjectPages.OpportunitiesPage;

public class OPPCases extends BFTestBase {
	Log_In_Page LogInObj;
	BFPageBase PagebaseObj;
	OpportunitiesPage OPPObj;
	OPPsPartnerCommunity OPPObjPC;
	Casos CasosOBJ;
	
	String OPPName = "OPP-0011162958";

	//Esta prueba necesita una cuenta para crear la OPP
	@Test
	public void Crear_OPP() throws InterruptedException, InvalidFormatException {
		LogInObj = new Log_In_Page(driver);
		OPPObj = new OpportunitiesPage(driver);
		PagebaseObj = new BFPageBase(driver);
		CasosOBJ=new Casos(driver);
		LogInObj.Log_In_SalesProfessional();
		//LogInObj.Log_In_Presales_Operations();
		//LogInObj.Log_In_Soporte();
		//LogInObj.Log_In_CentralSales();
		//OPPObj.Aprobar_Edra();
		OPPObj.Crear_Nueva_Oportunidad("A74615832");
		Assert.assertTrue(OPPObj.Name.contains("Oportunidad Automation"));
		OPPObj.RellenarComplejidad();
		OPPObj.Anadir_Producto_IPVPN();
		//BFPageBase.OPPHomePage();
		//OPPObj.SearchAndOpenOPP("OPP-0011162964");
		//OPPObj.VerificarEDRAS();
		//OPPObj.Aprobar_EDRA2("OPP-0011162981", "Sales Professional");
		OPPObj.Aprobar_EDRA4(OPPObj.New_Generated_OPP_ID, "Sales Professional");
		//CasosOBJ.Aprobar_MesaOferta_Con_Preventa("OPP-0011162964");
		//CasosOBJ.Aprobar_MesaOferta_Con_Preventa("01152423");
		//BFPageBase.CreateEvidence("Crear_OPP");
	}

	@Test
	public void TC143_Update_Opportunity_Stage_with_Producto_Generico_to_Cualificacion_Sales_Professional()
			throws InterruptedException, InvalidFormatException {
		LogInObj = new Log_In_Page(driver);
		OPPObj = new OpportunitiesPage(driver);

		LogInObj.LogIn_SalesForce_FL("salesprofessional2@tsse.com.vf.qa1", "calidad@2023");
		OPPObj.cambiarEtapaOPP("OPP-0011162906");
		BFPageBase.CreateEvidence(
				"TC143_Update_Opportunity_Stage_with_Producto_Generico_to_Cualificacion_Sales_Professional");
	}

	@Test
	public void TC06_TSO_TPSA_Support_Case_VF_Sales_Professional() throws InterruptedException, InvalidFormatException
	{
		LogInObj = new Log_In_Page(driver);
		OPPObj = new OpportunitiesPage(driver);
		PagebaseObj= new BFPageBase(driver);
		CasosOBJ = new Casos(driver);
		
		LogInObj.Log_In_SalesProfessional();
		BFPageBase.OPPHomePage();
		OPPObj.SearchAndOpenOPP("OPP-0011162742");
		CasosOBJ.Crear_CasoSoportePreventa_Dentro_De_OPP();
		CasosOBJ.CerrarCaso();
		LogInObj.Cerrar_Sesion();
		LogInObj.Log_In_Presales_Operations();
		CasosOBJ.Abrir_Caso_Con_URL();
		Assert.assertTrue(CasosOBJ.Confirmar_Estado_Del_Caso().equals("Completado"));
		BFPageBase.CreateEvidence("TC06_TSO_TPSA_Support_Case_VF_Sales_Professional");
	
	}
	
	@Test
	public void TC144_Update_Opportunity_Stage_with_Producto_Generico_to_Cualificacion_Partner_Sales_Professional()
			throws InterruptedException, InvalidFormatException {
		LogInObj = new Log_In_Page(driver);
		OPPObjPC = new OPPsPartnerCommunity(driver);

		LogInObj.LogIn_SalesForce_PC("partnercomercial1@tsse.com.vf.qa1", "contra@2023");
		OPPObjPC.CambiarEtapaPartner(OPPName);
		BFPageBase.CreateEvidence(
				"TC144_Update_Opportunity_Stage_with_Producto_Generico_to_Cualificacion_Partner_Sales_Professional");
	}

	@Test
	public void TC145_Verify_value_Orange_in_portability_operators_field_of_opportunity_products_VF_Sales_Professional()
			throws InterruptedException, InvalidFormatException {
		LogInObj = new Log_In_Page(driver);
		OPPObj = new OpportunitiesPage(driver);
		PagebaseObj= new BFPageBase(driver);
		
		LogInObj.Log_In_SalesProfessional();
		//Pass an OPP with producto generico sin Portabilidad rellenada
		BFPageBase.OPPHomePage();
		OPPObj.SearchAndOpenOPP("OPP-0011162989");
		OPPObj.PortabilityVlaueSelection(OpportunitiesPage.OrangeValue);
		Assert.assertTrue(PagebaseObj.Verificar_Confirmation_Message().contains("Producto de oportunidad"));
		BFPageBase.CreateEvidence(
				"TC145_Verify_value_Orange_in_portability_operators_field_of_opportunity_products_VF_Sales_Professional");
	}
	
	@Test
	public void TC146_Verify_value_Mas_Movil_in_portability_operators_field_of_opportunity_products_VF_Sales_Professional()
			throws InterruptedException, InvalidFormatException {
		LogInObj = new Log_In_Page(driver);
		OPPObj = new OpportunitiesPage(driver);
		PagebaseObj= new BFPageBase(driver);
		
		LogInObj.Log_In_SalesProfessional();
		OPPObj.SearchAndOpenOPP("OPP-0011162989");
		OPPObj.PortabilityVlaueSelection(OpportunitiesPage.MasMovilValue);
		Assert.assertTrue(PagebaseObj.Verificar_Confirmation_Message().contains("Producto de oportunidad"));
		BFPageBase.CreateEvidence(
				"TC146_Verify_value_Mas_Movil_in_portability_operators_field_of_opportunity_products_VF_Sales_Professional");
	}
	
	@Test
	public void TC147_Product_Taxonomy_field_Not_allowed_to_be_Modified_VF_Sales_Professional()
			throws InterruptedException, InvalidFormatException {
		LogInObj = new Log_In_Page(driver);
		OPPObj = new OpportunitiesPage(driver);

		LogInObj.LogIn_SalesForce_FL("salesprofessional2@tsse.com.vf.qa1", "calidad@2023");
		OPPObj.CambiarTaxonomia(OPPName);
		Assert.assertTrue(OPPObj.SeccionDeTaxonomia.isEnabled(), "Taxonomia no se puede modificar.");
		System.out.println("Assertions passed: The field is either disabled or read-only.");
		BFPageBase.CreateEvidence("TC147_Product_Taxonomy_field_Not_allowed_to_be_Modified_VF_Sales_Professional");

	}

	@Test
	public void TC148_Product_Taxonomy_field_not_allowed_to_be_Modified_VF_Partner_Sales_Professional()
			throws InterruptedException, InvalidFormatException {
		LogInObj = new Log_In_Page(driver);
		OPPObjPC = new OPPsPartnerCommunity(driver);

		LogInObj.LogIn_SalesForce_PC("partnercomercial1@tsse.com.vf.qa1", "contra@2023");
		OPPObjPC.CambiarTaxonomiaPC(OPPName);
		Assert.assertTrue(OPPObjPC.SeccionDeTaxonomia.isEnabled(), "Taxonomia no se puede modificar.");
		System.out.println("Assertions passed: The field is either disabled or read-only.");
		BFPageBase.CreateEvidence(
				"TC148_Product_Taxonomy_field_Not_allowed_to_be_Modified_VF_Partner_Sales_Professional");

	}

	//Esta prueb necesita 3 OPPs: 2 con 4 EDRAS aprobadas. 1 con 2 EDRAS aprobadas y todas en Identificacion.
	@Test
	public void TC84_Transitions_of_status_in_opportunity_Identificacion_FL() throws InterruptedException, InvalidFormatException
	{
		LogInObj = new Log_In_Page(driver);
		OPPObj = new OpportunitiesPage(driver);
		PagebaseObj= new BFPageBase(driver);
		CasosOBJ = new Casos(driver);
		
		//Acceder con sales professional y abrir una OPP con complejidad rellenada y EDRAS4 aprobadas.
		LogInObj.Log_In_SalesProfessional();
		//Pass the OPP Id which is approved the 4 levels of EDRAS and the stage is identify
		
		  OPPObj.SearchAndOpenOPP("OPP-0011162886");
		  
		  Assert.assertTrue(OPPObj.VerificarEtapa().contains("Identificaci"));
		  Assert.assertTrue(OPPObj.VerificarEDRAS().equals("4 EDRAS are approved"));
		  
		  OPPObj.Pass_To_Propuesta();
		  Assert.assertTrue(PagebaseObj.Verificar_Error_Message().
		  contains("puedes cambiar a las etapas Cualificando o Cerrada No Tratada"));
		  
		  OPPObj.Pass_To_Negociando();
		  Assert.assertTrue(PagebaseObj.Verificar_Error_Message().
		  contains("puedes cambiar a las etapas Cualificando o Cerrada No Tratada"));
		  
		  OPPObj.Pass_To_Cerrada_Ganada();
		  Assert.assertTrue(PagebaseObj.Verificar_Error_Message().
		  contains("puedes cambiar a las etapas Cualificando o Cerrada No Tratada"));
		  
		  OPPObj.Pass_To_Cerrada_Perdida();
		  Assert.assertTrue(PagebaseObj.Verificar_Confirmation_Message().contains(
		  "correctamente"));
		  
		  
		  //Pass an oportunity like the last one approved 4 EDRAs. complexity filled and in Identification stage.
		  OPPObj.SearchAndOpenOPP("OPP-0011162894");
		  Assert.assertTrue(OPPObj.VerificarEtapa().contains("Identificaci"));
		  Assert.assertTrue(OPPObj.VerificarEDRAS().equals("4 EDRAS are approved"));
		  
		  driver.navigate().refresh(); OPPObj.Pass_To_Cerrada_NoTratada();
		  Assert.assertTrue(PagebaseObj.Verificar_Confirmation_Message().contains(
		  "correctamente"));
		  
		  //pass an opportunity with EDRA1 y 2 not approved and in status Identification. 
		  OPPObj.SearchAndOpenOPP("OPP-0011162893");
		  Assert.assertTrue(OPPObj.VerificarEtapa().contains("Identificaci"));
		  Assert.assertTrue(OPPObj.VerificarEDRAS().equals("4 EDRAS are approved"));
		  
		  OPPObj.Pass_To_Cualify();
		  Assert.assertTrue(PagebaseObj.Verificar_Error_Message().
		  contains("Tiene que pasar las aprobaciones EDRA 1 y EDRA 2"));
		 	
		//pass an opportunity approved EDRA1 y 2 and in status identification. 
		OPPObj.SearchAndOpenOPP("OPP-0011162922");
		Assert.assertTrue(OPPObj.VerificarEtapa().contains("Identificaci"));
		Assert.assertTrue(OPPObj.VerificarEDRAS().equals("2 EDRA are approved"));
		
		OPPObj.Pass_To_Cualify();
		Assert.assertTrue(PagebaseObj.Verificar_Confirmation_Message().contains("correctamente"));
		BFPageBase.CreateEvidence("TC84_Transitions_of_status_in_opportunity_Identificacion_FL");
	}

	@Test
	public void TC169_Transitions_of_status_in_opportunity_Qualification_status_Full_License() throws InterruptedException, InvalidFormatException
	{
		LogInObj = new Log_In_Page(driver);
		OPPObj = new OpportunitiesPage(driver);
		PagebaseObj = new BFPageBase(driver);
		CasosOBJ = new Casos(driver);

		// Acceder con sales professional y abrir una OPP con complejidad rellenada y EDRAS4 aprobadas.
		LogInObj.Log_In_SalesProfessional();
		// Pass the OPP Id which is NOT approved the 1 and 2 levels of EDRAS and the stage is identify
		OPPObj.SearchAndOpenOPP("OPP-0011162984");

		Assert.assertTrue(OPPObj.VerificarEtapa().contains("Identificaci"));
		Assert.assertTrue(OPPObj.VerificarEDRAS().equals("EDRAS are not approved"));
		
		OPPObj.Pass_To_Cualify();
		Assert.assertTrue(PagebaseObj.Verificar_Error_Message().contains("Acción no permitida. Tiene que pasar las aprobaciones EDRA 1 y EDRA 2."));
		
		OPPObj.Aprobar_EDRA2("OPP-0011162984", "Sales Professional");
		OPPObj.Pass_To_Cualify();
		Assert.assertTrue(PagebaseObj.Verificar_Confirmation_Message().contains("correctamente"));
		
		//pass from Cualify to Negotiate and will appear an error.
		OPPObj.Pass_To_Negociando();
		Assert.assertTrue(PagebaseObj.Verificar_Error_Message().contains("Acción no permitida. Tiene que pasar la aprobación EDRA 3"));
		//approve EDRA3 to be able to pass from Cualify to negitiate
		OPPObj.Aprobar_EDRA3("OPP-0011162984", "Sales Professional");
		
		//pass from Cualify to Negotiate and will be passed.
		OPPObj.Pass_To_Negociando();
		Assert.assertTrue(PagebaseObj.Verificar_Confirmation_Message().contains("correctamente"));
		
		//return it to cualify as preparation again and will be in cualify successfully
		OPPObj.Pass_To_Cualify();
		Assert.assertTrue(OPPObj.VerificarEtapa().contains("Cualificación"));

		//pass from cualify to Close win and will appear an error to approve EDRA4
		OPPObj.Pass_To_Cerrada_Ganada();
		Assert.assertTrue(PagebaseObj.Verificar_Error_Message().contains("Acción no permitida. Tiene que pasar la aprobación EDRA 4"));

		//pass from cualify to Close lost and will appear an error that is not possible
		OPPObj.Pass_To_Cerrada_Perdida();
		Assert.assertTrue(PagebaseObj.Verificar_Error_Message().contains("Acción no permitida. No puedes cambiar a la etapa Cerrada Perdida"));

		//pass from cualify to Close not deal and will pass successfully.
		OPPObj.Pass_To_Cerrada_NoTratada();
		Assert.assertTrue(PagebaseObj.Verificar_Confirmation_Message().contains("correctamente"));

		//Pass OPP with EDRAS 2 approved and status to be Cualify
		OPPObj.SearchAndOpenOPP("OPP-0011162984");
	
		//pass it to propose and will pass.
		OPPObj.Pass_To_Propuesta();
		Assert.assertTrue(PagebaseObj.Verificar_Confirmation_Message().contains("correctamente"));
		BFPageBase.CreateEvidence("TC169- Transitions of status in opportunity (Qualification status) Full License.");
		
	}

	@Test
	public void TC170_Transitions_of_status_in_opportunity_Proposa_status_Full_License() throws InterruptedException, InvalidFormatException
	{
		LogInObj = new Log_In_Page(driver);
		OPPObj = new OpportunitiesPage(driver);
		PagebaseObj = new BFPageBase(driver);
		CasosOBJ = new Casos(driver);

		// Acceder con sales professional y abrir una OPP con complejidad rellenada y EDRAS4 aprobadas.
		LogInObj.Log_In_SalesProfessional();
		
		// Pass the OPP Id which is approved the 2 levels of EDRAS and the stage is Propose
		OPPObj.SearchAndOpenOPP("OPP-0011162984");
		Assert.assertTrue(OPPObj.VerificarEtapa().contains("Propuesta"));
		
		OPPObj.Pass_To_Negociando();
		Assert.assertTrue(PagebaseObj.Verificar_Error_Message().contains("Acción no permitida. Tiene que pasar la aprobación EDRA 3"));

		//Pass OPP with EDRAS3 approved and in status propose
		OPPObj.SearchAndOpenOPP("OPP-0011162984");
		Assert.assertTrue(OPPObj.VerificarEtapa().contains("Propuesta"));
		OPPObj.Pass_To_Negociando();
		Assert.assertTrue(PagebaseObj.Verificar_Confirmation_Message().contains("correctamente"));

		//return it to propuesta as preparation
		OPPObj.Pass_To_Propuesta();
		Assert.assertTrue(PagebaseObj.Verificar_Confirmation_Message().contains("correctamente"));
		
		OPPObj.Pass_To_Cualify();
		Assert.assertTrue(PagebaseObj.Verificar_Confirmation_Message().contains("correctamente"));
		
		OPPObj.Pass_To_Propuesta();
		Assert.assertTrue(PagebaseObj.Verificar_Confirmation_Message().contains("correctamente"));
		
		OPPObj.Pass_To_Identify();
		Assert.assertTrue(PagebaseObj.Verificar_Confirmation_Message().contains("correctamente"));
		
		OPPObj.Pass_To_Cualify();
		OPPObj.Pass_To_Propuesta();
		
		OPPObj.Pass_To_Cerrada_Ganada();
		Assert.assertTrue(PagebaseObj.Verificar_Error_Message().contains(
				"Acción no permitida. Tiene que pasar la aprobación EDRA 4"));

		//pass OPP in status Cualification and approved 4 levels of EDRAS.
		OPPObj.SearchAndOpenOPP("OPP-0011162984");
		Assert.assertTrue(OPPObj.VerificarEtapa().contains("Cualificaci"));
		Assert.assertTrue(OPPObj.VerificarEDRAS().contains("4 EDRAS are approved"));
		OPPObj.Pass_To_Cerrada_Ganada();
		Assert.assertTrue(PagebaseObj.Verificar_Confirmation_Message().contains("correctamente"));

		//Pass a new OPP en ststus Propose and approved EDRAS4
		OPPObj.SearchAndOpenOPP("OPP-0011162984");
		Assert.assertTrue(OPPObj.VerificarEtapa().contains("Propuesta"));
		OPPObj.Pass_To_Cerrada_NoTratada();
		Assert.assertTrue(PagebaseObj.Verificar_Error_Message().contains(
				"Acción no permitida. Sólo puedes cambiar a las etapas Negociando, Cerrada Ganada o Cerrada Pérdida"));

		OPPObj.Pass_To_Cerrada_Perdida();
		Assert.assertTrue(PagebaseObj.Verificar_Confirmation_Message().contains("correctamente"));
		BFPageBase.CreateEvidence("TC170 - Transitions of status in opportunity (Proposal status) Full License.");
	
	}
	@Test
	public void TC171_Transitions_of_status_in_opportunity_Negotiating_status_Full_License() throws InterruptedException, InvalidFormatException
	{
		LogInObj = new Log_In_Page(driver);
		OPPObj = new OpportunitiesPage(driver);
		PagebaseObj = new BFPageBase(driver);
		CasosOBJ = new Casos(driver);

		// Acceder con sales professional y abrir una OPP con complejidad rellenada y EDRAS4 aprobadas.
		LogInObj.Log_In_SalesProfessional();
		// Pass the OPP Id which is approved the 4 levels of EDRAS and the stage is Negotiate

		OPPObj.SearchAndOpenOPP("OPP-0011162984");

		Assert.assertTrue(OPPObj.VerificarEtapa().contains("Negociando"));
		
		OPPObj.Pass_To_Identify();
		Assert.assertTrue(PagebaseObj.Verificar_Confirmation_Message().contains("correctamente"));
		
		// Pass the OPP Id which is approved the 4 levels of EDRAS and the stage is Negotiate
		OPPObj.SearchAndOpenOPP("OPP-0011162984");
		OPPObj.Pass_To_Cualify();
		Assert.assertTrue(PagebaseObj.Verificar_Confirmation_Message().contains("correctamente"));
		
		
		// Pass the OPP Id which is approved the 4 levels of EDRAS and the stage is Negotiate
		 
		OPPObj.SearchAndOpenOPP("OPP-0011162984");
		OPPObj.Pass_To_Propuesta();
		Assert.assertTrue(PagebaseObj.Verificar_Confirmation_Message().contains("correctamente"));
		
		
		// Pass the OPP Id which is approved the 4 levels of EDRAS and the stage is Negotiate
		 
		OPPObj.SearchAndOpenOPP("OPP-0011162984");
		OPPObj.Pass_To_Cerrada_NoTratada();
		Assert.assertTrue(PagebaseObj.Verificar_Error_Message().contains("Acción no permitida. No puedes cambiar a la etapa Cerrada No Tratada"));
		
		
		// Pass the OPP Id which is approved the 3 levels of EDRAS and the stage is Negotiate
		OPPObj.SearchAndOpenOPP("OPP-0011162984");
		OPPObj.Pass_To_Cerrada_Ganada();
		Assert.assertTrue(PagebaseObj.Verificar_Error_Message().contains("Acción no permitida. Tiene que pasar la aprobación EDRA 4"));

		// Pass the OPP Id which is approved the 4 levels of EDRAS and the stage is Negotiate
		OPPObj.SearchAndOpenOPP("OPP-0011162984");
		OPPObj.VerificarEDRAS();
		OPPObj.Pass_To_Cerrada_Ganada();
		Assert.assertTrue(PagebaseObj.Verificar_Confirmation_Message().contains("correctamente"));
		
		
		// Pass the OPP Id which is approved the 4 levels of EDRAS and the stage is Negotiate
		OPPObj.SearchAndOpenOPP("OPP-0011162984");
		OPPObj.Pass_To_Cerrada_Perdida();
		Assert.assertTrue(PagebaseObj.Verificar_Confirmation_Message().contains("correctamente"));
		BFPageBase.CreateEvidence("TC171- Transitions of status in opportunity (Negotiating status) Full License.");
	}


	//Need OPP en ststus C.Perdida, OPP in status C.No Tratada and another one instatus C. Ganada
	public void TC172_Transitions_of_status_in_opportunity_Closed_status_Full_License() throws InterruptedException, InvalidFormatException
	{
		LogInObj = new Log_In_Page(driver);
		OPPObj = new OpportunitiesPage(driver);
		PagebaseObj = new BFPageBase(driver);
		CasosOBJ = new Casos(driver);

		// Acceder con sales professional y abrir una OPP con complejidad rellenada y
		// EDRAS4 aprobadas.
		LogInObj.Log_In_SalesProfessional();
		// Pass the OPP Id which is approved the 4 levels of EDRAS and the stage is Cerrada Perdida
		OPPObj.SearchAndOpenOPP("OPP-0011162984");
		Assert.assertTrue(OPPObj.VerificarEtapa().contains("Cerrada Perdida"));

		OPPObj.Pass_To_Negociando();
		Assert.assertTrue(PagebaseObj.Verificar_Error_Message().contains(
				"Acción no permitida. No se puede modificar una oportunidad bloqueada Acción no permitida. Estado final"));

		
		OPPObj.Pass_To_Propuesta();
		Assert.assertTrue(PagebaseObj.Verificar_Error_Message().contains(
				"Acción no permitida. No se puede modificar una oportunidad bloqueada Acción no permitida. Estado final"));
			
		
		// Pass the OPP Id which is approved the 4 levels of EDRAS and the stage is Cerrada Ganada
		OPPObj.SearchAndOpenOPP("OPP-0011162984");
		
		OPPObj.Pass_To_Negociando();
		Assert.assertTrue(PagebaseObj.Verificar_Error_Message().contains(
				"Acción no permitida. No se puede modificar una oportunidad bloqueada Acción no permitida. Estado final"));

		
		OPPObj.Pass_To_Propuesta();
		Assert.assertTrue(PagebaseObj.Verificar_Error_Message().contains(
				"Acción no permitida. No se puede modificar una oportunidad bloqueada Acción no permitida. Estado final"));
				
		
		// Pass the OPP Id which is approved the 4 levels of EDRAS and the stage is Cerrada No tratada
		OPPObj.SearchAndOpenOPP("OPP-0011162984");
		
		OPPObj.Pass_To_Negociando();
		Assert.assertTrue(PagebaseObj.Verificar_Error_Message().contains(
				"Acción no permitida. No se puede modificar una oportunidad bloqueada Acción no permitida. Estado final"));

		
		OPPObj.Pass_To_Propuesta();
		Assert.assertTrue(PagebaseObj.Verificar_Error_Message().contains(
				"Acción no permitida. No se puede modificar una oportunidad bloqueada Acción no permitida. Estado final"));			
		BFPageBase.CreateEvidence("TC172- Transitions of status in opportunity (Closed status) Full License.");	
	}


	@Test
	public void TC162_1MILLIONBOT_value_updated_in_Partner_Field_of_opportunity_products_alphabetically_ordered_Sales_Professional() throws InterruptedException, InvalidFormatException
	{
		LogInObj = new Log_In_Page(driver);
		OPPObj = new OpportunitiesPage(driver);
		PagebaseObj= new BFPageBase(driver);
		
		LogInObj.Log_In_SalesProfessional();
		BFPageBase.OPPHomePage();
		//Pass an OPP with producto generico and Partner field not filled
		OPPObj.SearchAndOpenOPP("OPP-0011162988");
		OPPObj.Modificar_ProductoGenerico();
		Assert.assertTrue(OPPObj.Modificar_Producto_Partner_Campo().equals("Values are ordered alphabetically because first value is: 1MILLIONBOT"));	
		BFPageBase.CreateEvidence("TC162 - (1MILLIONBOT) value updated in Partner Field of opportunity products (alphabetically ordered) (Sales Professional)");
	}
	
	@Test
	public void TC56_Display_opportunity_outcome_reason_field_VF_Sales_Professional() throws InterruptedException
	{
		LogInObj = new Log_In_Page(driver);
		OPPObj = new OpportunitiesPage(driver);
		PagebaseObj= new BFPageBase(driver);
		
		LogInObj.Log_In_SalesProfessional();
		BFPageBase.OPPHomePage();
		//Pass an OPP with producto generico and Partner field not filled
		OPPObj.SearchAndOpenOPP("OPP-0011162988");
		OPPObj.Check_Each_Result_Cerrada_No_Tratada();
		//Assert.assertTrue(OPPObj.Check_Each_Result_Cerrada_No_Tratada().equals("Ok"));	

		
	}
}
