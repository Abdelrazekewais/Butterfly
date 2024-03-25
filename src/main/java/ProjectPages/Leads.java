package ProjectPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Leads extends BFPageBase {

	public static String Nombre_Completo;

	public Leads(WebDriver driver) {
		super(driver);
	}

	@FindBy(partialLinkText = "Nuevo")
	WebElement Nuevo;

	@FindBy(xpath = "//input[@name='FirstName']")
	WebElement LeadFName;

	@FindBy(xpath = "//input[@name='LastName']")
	WebElement LeadLastName;

	@FindBy(xpath = "//input[@name='Company']")
	WebElement Compania;

	@FindBy(xpath = "//button[@name='CSP_DocumentType__c']")
	WebElement Tipo_De_Documento;

	@FindBy(xpath = "//input[@name='CSP_DocumentNumber__c']")
	WebElement Numero_De_Documento;

	@FindBy(xpath = "//button[@name='CSP_Country__c']")
	WebElement Pais;

	@FindBy(xpath = "//button[@name='CSP_Province__c']")
	WebElement Provincia;

	@FindBy(xpath = "//input[@placeholder='Buscar Ciudades...']")
	WebElement Ciudad;

	@FindBy(xpath = "(//li[@class='slds-listbox__item'])[1]")
	WebElement NuevoLead_Ciudad_FirstOpt;

	@FindBy(xpath = "//input[@name='CSP_PostalCode__c']")
	WebElement CodigoPostal;

	@FindBy(xpath = "//input[@name='CSP_StreetAddress__c']")
	WebElement Calle;

	@FindBy(xpath = "//input[@name='Phone']")
	WebElement Telefono;

	@FindBy(xpath = "//input[@name='CSP_StreetType__c']")
	WebElement Tipo_Del_Calle;

	@FindBy(xpath = "//input[@name='CSP_StreetNumber__c']")
	WebElement Numero_Del_Calle;

	@FindBy(xpath = "//button[text()='Enviar']")
	WebElement EnviarBTN;

	public void Crear_Nueva_Lead(String Provence, String ciudad) throws InterruptedException {
		LeadsHomePage();
		WaitElementtoBeClickable(Nuevo);
		BFPageBase.TakeScreenShot();
		ClickBTN(Nuevo);

		Thread.sleep(3000);
		BFPageBase.TakeScreenShot();
		WaitElementtoBeVisible(LeadFName);
		SetTXTElement(LeadFName, "Lead Automation");
		SetTXTElement(LeadLastName, formattedDate);
		SetTXTElement(Compania, "Test");
		SetTXTElement(Telefono, "688110022");

		ClickBTN(Tipo_De_Documento);
		Tipo_De_Documento.sendKeys(Keys.ARROW_DOWN);
		Tipo_De_Documento.sendKeys(Keys.ENTER);
		SetTXTElement(Numero_De_Documento, "R6011498J");

		ClickBTN(Pais);
		Pais.sendKeys(Keys.ARROW_DOWN);
		Pais.sendKeys(Keys.ENTER);

		Provincia.click();
		driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='" + Provence + "']")).click();
		BFPageBase.TakeScreenShot();

		jsExecutor1.executeScript("window.scrollBy(0,500)");
		SetTXTElement(Ciudad, "CALVARRASA DE ARRIBA");
		WaitElementtoBeVisible(NuevoLead_Ciudad_FirstOpt);
		NuevoLead_Ciudad_FirstOpt.click();
		driver.findElement(By.xpath("//input[@data-value='" + ciudad + "']")).click();

		SetTXTElement(CodigoPostal, "37349");
		SetTXTElement(Calle, "VIA REAL");

		SetTXTElement(Tipo_Del_Calle, "CL");
		SetTXTElement(Numero_Del_Calle, "82");
		BFPageBase.TakeScreenShot();
		ClickBTN(EnviarBTN);
		Thread.sleep(8000);
		BFPageBase.TakeScreenShot();

	}

	@FindBy(xpath = "//button[@class='test-id__inline-edit-trigger slds-shrink-none inline-edit-trigger slds-button slds-button_icon-bare' and @title='Modificar Email']")
	WebElement Boton_Modificar_Email;

	@FindBy(xpath = "//button[@name='Edit' and @type='button']")
	WebElement ModificarBTN;

	@FindBy(xpath = "/html/body/div[4]/div[1]/section/div[1]/div/div[2]/div[2]/section/div/div/section/div/div[2]/div/div/div/div/one-record-home-flexipage2/forcegenerated-adg-rollup_component___force-generated__flexipage_-record-page___-c-s-p_-lead-record-page___-lead___-v-i-e-w/forcegenerated-flexipage_csp_leadrecordpage_lead__view_js/record_flexipage-desktop-record-page-decorator/div[1]/records-record-layout-event-broker/slot/slot/flexipage-record-home-with-subheader-template-desktop2/div/div[3]/div[1]/slot/flexipage-component2[2]/slot/flexipage-tabset2/div/lightning-tabset/div/slot/slot/flexipage-tab2[1]/slot/flexipage-component2[1]/slot/flexipage-field-section2/div/div/div/laf-progressive-container/slot/div/slot/flexipage-column2[1]/div/slot/flexipage-field[3]/slot/record_flexipage-record-field/div/div/div[2]/span/slot[1]/lightning-formatted-name")
	WebElement VerifyLeadName;

	@FindBy(xpath = "//input[@name='Lead-search-input' and @type='search']")
	WebElement Buscar_Leads;

	@FindBy(xpath = "//a[contains(@href, '/lightning/r/') and @data-refid='recordId'  and @data-special-link='true']")
	WebElement Lead_LinkBTN;

	@FindBy(xpath = "//input[@class='slds-input' and @inputmode='email']")
	WebElement Cambiar_Correo;

	@FindBy(xpath = "//button[@name='SaveEdit']")
	WebElement GuardarBTN;

	@FindBy(xpath = "//button[contains(@aria-label, 'Estado') and contains(@class, 'slds-combobox__input slds-input')]")
	public WebElement VerifyEstado;

	// @FindBy(xpath="//button[@name='CancelEdit']")
	// WebElement CancelarBTN;

	@FindBy(xpath = "//button[@name='Edit' and text()='Modificar']")
	WebElement Modificar_Lead_BTN;

	public void Verify_Lead_Not_MKT(String Name) throws InterruptedException {
		LeadsHomePage();
		WaitElementtoBeClickable(Nuevo);
		BFPageBase.TakeScreenShot();
		SetTXTElement(Buscar_Leads, Name);
		WaitElementtoBeVisible(Lead_LinkBTN);
		BFPageBase.TakeScreenShot();
		ClickBTN(Lead_LinkBTN);
		WaitElementtoBeVisible(Boton_Modificar_Email);
		BFPageBase.TakeScreenShot();
		Thread.sleep(6000);
		ClickBTN(Modificar_Lead_BTN);
		Thread.sleep(4000);
		if (VerifyEstado.getAttribute("data-value").equals("Nuevo")) {
			BFPageBase.TakeScreenShot();
			SetTXTElement(Cambiar_Correo, "TestingTSSE@Test.com");
			BFPageBase.TakeScreenShot();
			ClickBTN(GuardarBTN);
			Thread.sleep(5000);
			WaitElementtoBeVisible(Modificar_Lead_BTN);
			BFPageBase.TakeScreenShot();
			ClickBTN(Modificar_Lead_BTN);
			if (VerifyEstado.getAttribute("data-value").equals("Trabajando")) {
				BFPageBase.TakeScreenShot();
				System.out.println("Cambiado el estado a Trabajando correctamente!");
			}
		} else {
			System.out.println("No Se puede modificar esta Lead porque su estado no es: Nuevo");
			return;
			// ClickBTN(CancelarBTN);

		}

	}

	@FindBy(xpath = "//input[contains(@name, 'MKT')]")
	WebElement Craeted_MKT_Checkbox;

	@FindBy(css = "div.actionBody")
	WebElement Scroller;

	public void Make_Lead_User_MKT(String LeadReference) throws InterruptedException {
		LeadsHomePage();
		WaitElementtoBeClickable(Nuevo);
		BFPageBase.TakeScreenShot();
		SetTXTElement(Buscar_Leads, LeadReference);
		Buscar_Leads.sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		BFPageBase.TakeScreenShot();
		ClickBTN(Lead_LinkBTN);
		// WaitElementtoBeVisible(Modificar_Lead_BTN);
		BFPageBase.TakeScreenShot();
		WaitElementtoBeClickable(Modificar_Lead_BTN);
		Thread.sleep(6000);
		ClickBTN(Modificar_Lead_BTN);
		Thread.sleep(4000);
		jsExecutor1.executeScript("arguments[0].scrollTop += 400;", Scroller);
		Thread.sleep(4000);
		driver.findElement(By.xpath("")).click();
		System.out.println(Craeted_MKT_Checkbox.getTagName());
		// ClickBTN(Craeted_MKT_Checkbox);
		// actions.moveToElement(Craeted_MKT_Checkbox).click().build().perform();
		Thread.sleep(4000);
		// ClickBTN(Craeted_MKT_Checkbox);
		ClickBTN(GuardarBTN);
		Thread.sleep(4000);

	}

	public void Verify_Lead_User_MKT(String LeadReference) throws InterruptedException {
		LeadsHomePage();
		WaitElementtoBeClickable(Nuevo);
		BFPageBase.TakeScreenShot();
		SetTXTElement(Buscar_Leads, LeadReference);
		Thread.sleep(4000);
		BFPageBase.TakeScreenShot();
		WaitElementtoBeVisible(Lead_LinkBTN);
		ClickBTN(Lead_LinkBTN);
		WaitElementtoBeClickable(Modificar_Lead_BTN);
		Modificar_Lead_BTN.click();
		//actions.moveToElement(Modificar_Lead_BTN).click().build().perform();
		WaitElementtoBeVisible(VerifyEstado);
		
		
		if (VerifyEstado.getAttribute("data-value").equals("Nuevo")) {
			BFPageBase.TakeScreenShot();
			Cambiar_Correo.clear();
			SetTXTElement(Cambiar_Correo, "TestingTSSE@Test.com");
			BFPageBase.TakeScreenShot();
			ClickBTN(GuardarBTN);
			Thread.sleep(2000);
			
			BFPageBase.TakeScreenShot();
			ClickBTN(Modificar_Lead_BTN);
			WaitElementtoBeVisible(VerifyEstado);
			if (VerifyEstado.getAttribute("data-value").equals("Nuevo")) {
				System.out.println("Estado no se ha cambiado a ningun otro estado, esta en Nuevo");
				System.out.println("Passed");
			} else {
				System.out.println("Failed, estado no debe cambiarse, Estado se ha cambiado a: "
						+ VerifyEstado.getAttribute("data-value"));
			}

		} else {
			System.out.println("No Se puede modificar esta Lead porque su estado no es: Nuevo");
			return;
		}

}
	
	@FindBy(xpath="//a[@title='Importar']")
	WebElement ImportarBTN; 
	
	@FindBy(xpath="//*[text()='Leads']")
	WebElement LeadsBTN;
	
	@FindBy(xpath="//a[text()='Agregar nuevos registros']")
	WebElement AgregarNuevosLeadsBTN;
	
	@FindBy(xpath="/html/body/div[4]/div[1]/div[2]/div[3]/div/div[3]/a/div")
	WebElement CSVBTN;
	
	@FindBy(xpath="//input[@name='file' and @type='file']")
	WebElement SeleccionarFileBTN;
	
	
	public void Crear_Lead_Con_Bulk() throws InterruptedException
	{
		WaitElementtoBeClickable(ImportarBTN);
		ClickBTN(ImportarBTN);
		Thread.sleep(10000);
		driver.navigate().refresh();
		//WaitElementtoBeClickable(LeadsBTN);
		ClickBTNJS(LeadsBTN);
		WaitElementtoBeClickable(AgregarNuevosLeadsBTN);
		ClickBTN(AgregarNuevosLeadsBTN);
		WaitElementtoBeClickable(CSVBTN);
		ClickBTN(CSVBTN);
		WaitElementtoBeClickable(SeleccionarFileBTN);
		ClickBTN(SeleccionarFileBTN);
		
	}
	
	
}


 
	
	



