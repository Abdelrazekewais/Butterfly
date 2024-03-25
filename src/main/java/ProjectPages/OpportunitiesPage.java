package ProjectPages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class OpportunitiesPage extends BFPageBase {
	WebDriverWait wait;
	Log_In_Page LogINOBJ;
	Casos CasosOBJ;
	private String Approval;
	
	public OpportunitiesPage(WebDriver driver) {
		super(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(45));
	}

	// Element to create New Opportunity.
	@FindBy(xpath = "//input[@placeholder='Buscar en esta lista...']")
	WebElement BuscarCuenta;

	@FindBy(xpath = "//a[contains(@href, '/lightning/r/')]")
	WebElement Cuenta;

	@FindBy(xpath = "//button[@name='Account.CSP_NewOpportunity']")
	WebElement NuevaOPPBTN;

	@FindBy(xpath = "//*[@name='radioGroup']")
	WebElement OPPDeVenta;

	@FindBy(xpath = "//button[@type='submit'and text()='Enviar']")
	WebElement EnviarBTN;

	@FindBy(xpath = "//input[@class='slds-input' and @name='Name']")
	WebElement Nombre_De_OPP;

	@FindBy(xpath = "//input[@class='slds-input' and @name='CloseDate']")
	WebElement Fecha_Fin_De_OPP;

	@FindBy(xpath = "//button[ @name='Type']")
	WebElement Tipo_De_OPP;

	@FindBy(xpath = "//button[@title='Modificar Etapa']")
	WebElement Button_Modificar_Etapa;

	@FindBy(xpath = "//button[contains(@id, 'combobox-button') and contains(@aria-label, 'Etapa') ]")
	WebElement Button_Menu_Etapa;

	@FindBy(xpath = "//input[@name='Opportunity-search-input']")
	WebElement BuscarOPP;

	@FindBy(xpath = "//div[4]//section//div[2]//div//div//table//tbody/tr[1]//a")
	WebElement NombreDeOPP;

	@FindBy(xpath = "/html/body/div[4]/div[1]/section/div[1]/div/div[2]/div[2]/section[3]/div/div/section/div/div[2]/div/div/div/div/one-record-home-flexipage2/forcegenerated-adg-rollup_component___force-generated__flexipage_-record-page___-c-s-p_-opportunity-record-page___-opportunity___-v-i-e-w/forcegenerated-flexipage_csp_opportunityrecordpage_opportunity__view_js/record_flexipage-desktop-record-page-decorator/div[1]/records-record-layout-event-broker/slot/slot/flexipage-record-home-template-desktop2/div/div[1]/slot/flexipage-component2[1]/slot/records-lwc-highlights-panel/records-lwc-record-layout/forcegenerated-highlightspanel_opportunity___0127y000001uq9gqaa___compact___view___recordlayout2/records-highlights2/div[1]/div[2]/slot/records-highlights-details-item[4]")
	// @FindBy(xpath="//*[@id=\"brandBand_2\"]/div/div/div/one-record-home-flexipage2/forcegenerated-adg-rollup_component___force-generated__flexipage_-record-page___-c-s-p_-opportunity-record-page___-opportunity___-v-i-e-w/forcegenerated-flexipage_csp_opportunityrecordpage_opportunity__view_js/record_flexipage-desktop-record-page-decorator/div[1]/records-record-layout-event-broker/slot/slot/flexipage-record-home-template-desktop2/div/div[1]/slot/flexipage-component2[1]/slot/records-lwc-highlights-panel/records-lwc-record-layout/forcegenerated-highlightspanel_opportunity___0127y000001uq9gqaa___compact___view___recordlayout2/records-highlights2/div[1]/div[2]/slot/records-highlights-details-item[4]/div/p[2]/slot/lightning-formatted-text")
	WebElement EtapaDeOPP;

	@FindBy(xpath = "//button[@name='Opportunity.CSP_AddProducts']")
	// @FindBy(xpath =
	// "//li[@data-target-selection-name='sfdc:QuickAction.Opportunity.CSP_AddProducts']//lightning-button//button[@name='Opportunity.CSP_AddProducts']")
	WebElement GestionarProductosBTN;

	@FindBy(xpath = "//tbody/tr[@data-row-number='6']//td//lightning-primitive-cell-checkbox/span/input[@type='checkbox']")
	WebElement SeleccionProdGener;

	@FindBy(css = "div.quick-actions-panel")
	WebElement ScrollParaProds;

	@FindBy(xpath = "//button[@title='Siguiente']")
	WebElement SiguienteBTN;

	@FindBy(xpath = "//input[@class='slds-input' and @name='quantity' and @inputmode='decimal' ]")
	WebElement Cantidad;

	@FindBy(xpath = "//button[@name='actionType' and @aria-haspopup='listbox' and @role='combobox']")
	WebElement TipoDeAccionBTN;

	@FindBy(xpath = "//input[@name='oneTimeRevenue']")
	WebElement IngresosUnicos;

	@FindBy(xpath = "//input[@name='productTermsMonths']")
	WebElement Plazos;

	@FindBy(xpath = "//button[@title='Guardar']")
	WebElement GuardarBTN;

	@FindBy(xpath = "//a[@data-label='Gestión de Oportunidad']")
	WebElement GestionDeOPPTab;

	@FindBy(partialLinkText = "Producto genérico")
	WebElement VerifyProdGenerico;
	
	@FindBy(partialLinkText = "IPVPN")
	WebElement VerifyProdIPVPN;

	@FindBy(xpath = "//li[@role='presentation' and @data-name='Qualify']")
	// a[@data-tab-name='Qualify']
	WebElement EtapaQualify;

	@FindBy(css = "button.slds-button.slds-button--brand.slds-path__mark-complete.stepAction.active.uiButton")
	WebElement MarcarComoEtapaActualBTN;

	// @FindBy(css="div.toastTitle.slds-text-heading--small")
	// WebElement ErrorMessage;

	@FindBy(tagName = "table")
	WebElement TableOPP;

	@FindBy(xpath = "//table/tbody/tr")
	List<WebElement> TableRows;

	@FindBy(tagName = "td")
	WebElement TableCells;
	
	@FindBy(xpath = "//tbody/tr[@data-row-number='1']//td//lightning-primitive-cell-checkbox/span/input[@type='checkbox']")
	WebElement Seleccionar_Producto_IPVPN;
	
	@FindBy(xpath = "//a[@title='Eliminar' and @role='button']")
	WebElement EliminarBTN;

	@FindBy(xpath = "//button[@title='Eliminar' and @type='button']")
	WebElement EliminarConfirmBTN;
	
	@FindBy(xpath = "//a[@title='Modificar' and @role='button']")
	WebElement ModificarProductoBTN;

	@FindBy(xpath = "/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div[1]/div/article/div[3]/div/div[1]/div/div/div[4]/div[2]/div")
	public WebElement SeccionDeTaxonomia;
	
	@FindBy(xpath = "//div[@data-target-selection-name='sfdc:RecordField.OpportunityLineItem.CSP_Operator__c']//a")
	WebElement SelectPortabilityBTN;

	@FindBy(xpath = "//div[@data-target-selection-name='sfdc:RecordField.OpportunityLineItem.CSP_Partner__c']//a")
	WebElement Select_Partner_BTN;
	
	@FindBy(partialLinkText = "ORANGE")
	public static WebElement OrangeValue;

	@FindBy(partialLinkText = "Ninguno")
	public static WebElement Ninguno;
	
	@FindBy(partialLinkText = "MAS MOVIL")
	public static WebElement MasMovilValue;

	@FindBy(xpath = "//div[@role='alertdialog']")
	public static WebElement ConfirmationMessage;

	@FindBy(partialLinkText = "Ver todos")
	WebElement Ver_Todos_Productos;
	
	@FindBy(xpath="//li[@role='presentation']//a")
	List<WebElement> PartnerValues; 
	
	@FindBy(xpath = "//button[contains(@title, 'Complejidad')]")
	WebElement ModificarComplejidad;

	@FindBy(xpath = "//button[@aria-label='Complejidad, --Ninguno--']")
	WebElement Menu_De_Complejidad;

	@FindBy(xpath = "//lightning-base-combobox-item[@data-value='Complex 2']")
	WebElement Opcion_Complejo2;

	@FindBy(xpath = "//button[@name='SaveEdit']")
	WebElement Guardar_Modificaciones_OPP;
	
	@FindBy(xpath = "//records-highlights-details-item[4]/div/p[2]//lightning-formatted-text")
	WebElement Verificar_Etapa;

	@FindBy(xpath = "//records-highlights-details-item[6]/div/p[2]//lightning-formatted-text")
	WebElement Verificar_SNAV_Esperado;

	@FindBy(xpath = "//div[@data-target-selection-name='sfdc:RecordField.Opportunity.Name']//slot[@name='outputField']//lightning-formatted-text")
	public static WebElement NombreDe_Oportunity;

	@FindBy(xpath = "//div[@data-target-selection-name='sfdc:RecordField.Opportunity.GSP_Complexity__c']//slot[@name='outputField']//lightning-formatted-text")
	public static WebElement Tipo_DeOPP;

	@FindBy(xpath = "//div[@data-target-selection-name='sfdc:RecordField.Opportunity.CSP_OpportunityReferenceID__c']//slot[@name='outputField']//lightning-formatted-text")
	public static WebElement ID_De_OPP;
	
	@FindBy(xpath = "//a[@data-tab-name='Identify']")
	WebElement Boton_Etapa_Identificacion;

	@FindBy(xpath = "//a[@data-tab-name='Qualify']")
	WebElement Boton_Etapa_Cualificacion;

	@FindBy(xpath = "//a[@data-tab-name='Propose']")
	WebElement Boton_Etapa_Propuesta;

	@FindBy(xpath = "//a[@data-tab-name='Negotiate']")
	WebElement Boton_Etapa_Negociando;

	@FindBy(xpath = "//a[@data-tab-name='Closed']")
	WebElement Boton_Etapa_Cerrada;

	@FindBy(xpath = "//input[@name='CSP_EDRA1__c']")
	WebElement CheckBox_Edra1;

	@FindBy(xpath = "//input[@name='CSP_EDRA2__c']")
	WebElement CheckBox_Edra2;

	@FindBy(xpath = "//input[@name='CSP_EDRA3__c']")
	WebElement CheckBox_Edra3;

	@FindBy(xpath = "//input[@name='CSP_EDRA4__c']")
	WebElement CheckBox_Edra4;

	@FindBy(xpath = "//button[text()='Enviar para aprobación']")
	WebElement Boton_Enviar_A_Aprobacion;

	@FindBy(xpath = "//textarea[@class='inputTextArea cuf-messageTextArea textarea']")
	WebElement Comentario_De_aprobacion;

	@FindBy(xpath = "//button[@class='slds-button slds-button--neutral modal-button-left actionButton uiButton--default uiButton--brand uiButton']")
	WebElement Boton_Enviar_Comentario_Aprobacion;

	@FindBy(xpath = "//a[contains(@title, 'Oportunidad/')]")
	WebElement Oprotunidad_Relacionada_con_aprobacion;

	@FindBy(xpath = "//a[contains(@title, 'ProcessInstanceWorkitem/')]")
	WebElement ID_De_aprobacion;

	@FindBy(xpath = "//a[@role='menuitem']//span[text()='Aprobar']")
	WebElement Boton_Aprobar_Edra;

	@FindBy(xpath = "//textarea[@class='slds-textarea']")
	WebElement ComentarioAprobarCasoPorCentralSales;

	@FindBy(xpath = "//button[@title='Save']")
	WebElement Boton_Confirmar_Aprobar_Edra;

	@FindBy(xpath = "//lightning-formatted-url[@data-navigation='enable']//a")
	List<WebElement> AprobacionLinks;

	@FindBy(xpath = "//button[@class='slds-button slds-button_icon-border slds-button_icon-x-small']")
	List<WebElement> Mostrar_Acciones_De_Aprobacion;

	@FindBy(xpath = "//button[contains(@aria-label, 'Etapa')]")
	WebElement Boton_Menu_De_Etapas;

	@FindBy(xpath = "//button[contains(@aria-label, 'Motivo Resultado')]")
	WebElement Boton_Motivo_Resultados;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement Boton_Listo;

	@FindBy(xpath = "//lightning-base-combobox-item[@data-value='Closed Won']")
	WebElement Seleccion_Cerrada_Ganada;
	@FindBy(xpath = "//lightning-base-combobox-item[@data-value='Closed Lost']")
	WebElement Seleccion_Cerrada_Perdida;
	@FindBy(xpath = "//lightning-base-combobox-item[@data-value='Close No Deal']")
	WebElement Seleccion_Cerrada_NoTratada;

	@FindBy(xpath = "//lightning-base-combobox-item[@data-value='Price']")
	WebElement Seleccion_Motivo_Precio;

	@FindBy(xpath = "//lightning-base-combobox-item[@data-value='Not interested']")
	WebElement Seleccion_Motivo_NoInteresado;

	@FindBy(xpath = "//button[@name='Opportunity.CSP_CloneWithProducts']")
	WebElement Boton_Clonar_Con_Prouctos;

	@FindBy(xpath = "//div[@data-target-selection-name='sfdc:RecordField.Opportunity.CSP_OpportunityReferenceID__c']//lightning-formatted-text")
	WebElement Campo_ID_OPP;

	@FindBy(xpath="//lightning-base-combobox-item//span[@class='slds-media__body']")
	List<WebElement> Motivo_Resultados; 
	
	// This will be the ID to be passed for functions to search and deal with
	// Opportunities.

	// This will be the name to pass to any function creating a new Opportunity.

	public String Name;
	public String New_Generated_OPP_ID = null;

	public String Crear_Nueva_Oportunidad(String ACCID) throws InterruptedException {
		CuentasHomePage();
		BFPageBase.TakeScreenShot();

		WaitElementtoBeVisible(BuscarCuenta);
		BuscarCuenta.sendKeys(ACCID);
		BuscarCuenta.sendKeys(Keys.ENTER);
		wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//tbody//tr"), 1));
		BFPageBase.TakeScreenShot();
		ClickBTNJS(Cuenta);

		try{WaitElementtoBeVisible(NuevaOPPBTN);}
		catch (Exception e) {
			driver.navigate().refresh();
			WaitElementtoBeVisible(NuevaOPPBTN);
		}
		ClickBTN(NuevaOPPBTN);
		BFPageBase.TakeScreenShot();

		WaitElementtoBeVisible(OPPDeVenta);
		actions.moveToElement(OPPDeVenta).click().build().perform();
		BFPageBase.TakeScreenShot();

		ClickBTN(EnviarBTN);
		WaitElementtoBeVisible(Nombre_De_OPP);
		WaitForPageToBeLoaded();
		BFPageBase.TakeScreenShot();
		Nombre_De_OPP.sendKeys("Oportunidad Automation " + formattedDate);

		WaitElementtoBeVisible(Fecha_Fin_De_OPP);
		Fecha_Fin_De_OPP.sendKeys("31 dic 2025");

		WaitElementtoBeVisible(Tipo_De_OPP);
		Tipo_De_OPP.click();
		Tipo_De_OPP.sendKeys(Keys.ARROW_DOWN);
		Tipo_De_OPP.sendKeys(Keys.ENTER);
		BFPageBase.TakeScreenShot();
		ClickBTN(EnviarBTN);
		WaitElementtoBeVisible(Button_Modificar_Etapa);
		driver.navigate().refresh();
		WaitElementtoBeVisible(Button_Modificar_Etapa);
		WaitElementtoBeVisible(ID_De_OPP);
		New_Generated_OPP_ID = ID_De_OPP.getText();
		BFPageBase.TakeScreenShot();
		Name = driver.getTitle();
		return New_Generated_OPP_ID;

	}

	// funcion para buscar la oportunidad y pulsarla para abrirla si es con el mismo nombre

	public void SearchAndOpenOPP(String ID_OPP) throws InterruptedException {

		BuscarOPP = wait.until(ExpectedConditions.visibilityOf(BuscarOPP));
		BuscarOPP.clear();
		SetTXTElement(BuscarOPP, ID_OPP);
		Press_Enter(BuscarOPP);
		//Thread.sleep(5000);
		wait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.xpath("//tbody//tr"), 3));

		NombreDeOPP = wait.until(ExpectedConditions.elementToBeClickable(NombreDeOPP));
		ClickBTNJS(NombreDeOPP);
		// OpenOPPEnTable(OPPID);
		// EtapaDeOPP=wait.until(ExpectedConditions.visibilityOf(EtapaDeOPP));
	}

	public void AnadirProducGenerico() throws InterruptedException {
		GestionarProductosBTN = wait.until(ExpectedConditions.visibilityOf(GestionarProductosBTN));
		ClickBTNJS(GestionarProductosBTN);
		SeleccionProdGener = wait.until(ExpectedConditions.visibilityOf(SeleccionProdGener));
		ClickBTNJS(SeleccionProdGener);
		scrollDown(ScrollParaProds, 2000);
		ClickBTN(SiguienteBTN);
		Cantidad = wait.until(ExpectedConditions.visibilityOf(Cantidad));
		SetTXTElement(Cantidad, "1");
		ClickBTN(TipoDeAccionBTN);
		TipoDeAccionBTN.sendKeys(Keys.ARROW_DOWN);
		TipoDeAccionBTN.sendKeys(Keys.ENTER);
		SetTXTElement(IngresosUnicos, "23000000");
		SetTXTElement(Plazos, "12");
		ClickBTN(GuardarBTN);
		WaitElementtoBeVisible(ConfirmationMessage);
	}

	public void Anadir_Producto_IPVPN() throws InterruptedException {

		GestionarProductosBTN = wait.until(ExpectedConditions.visibilityOf(GestionarProductosBTN));
		actions.moveToElement(GestionarProductosBTN).click().build().perform();
		Seleccionar_Producto_IPVPN = wait.until(ExpectedConditions.visibilityOf(Seleccionar_Producto_IPVPN));
		WaitElementtoBeVisible(ScrollParaProds);
		ClickBTNJS(Seleccionar_Producto_IPVPN);
		scrollDown(ScrollParaProds, 2000);
		Thread.sleep(4000);
		ClickBTN(SiguienteBTN);
		Cantidad = wait.until(ExpectedConditions.visibilityOf(Cantidad));
		SetTXTElement(Cantidad, "1");
		ClickBTN(TipoDeAccionBTN);
		TipoDeAccionBTN.sendKeys(Keys.ARROW_DOWN);
		TipoDeAccionBTN.sendKeys(Keys.ENTER);
		SetTXTElement(IngresosUnicos, "23000000");
		SetTXTElement(Plazos, "12");
		ClickBTN(GuardarBTN);
		WaitElementtoBeVisible(ConfirmationMessage);
	}
	
	public void EliminarProduc(String ID_OPP) throws InterruptedException {
		SearchAndOpenOPP(ID_OPP);
		ClickBTN(GestionDeOPPTab);
		VerifyProdGenerico = wait.until(ExpectedConditions.visibilityOf(VerifyProdGenerico));
		ClickBTN(VerifyProdGenerico);
		ClickBTN(EliminarBTN);
		EliminarConfirmBTN = wait.until(ExpectedConditions.visibilityOf(EliminarConfirmBTN));
		ClickBTN(EliminarConfirmBTN);
	}

	public void cambiarEtapaOPP(String ID_OPP) throws InterruptedException {
		OPPHomePage();
		SearchAndOpenOPP(ID_OPP);
		BFPageBase.TakeScreenShot();
		if (Verificar_Etapa.getText().contains("Identificac")) {
			AnadirProducGenerico();
			driver.navigate().back();
			BFPageBase.TakeScreenShot();
			ClickBTN(GestionDeOPPTab);
			BFPageBase.TakeScreenShot();
			VerifyProdGenerico = wait.until(ExpectedConditions.visibilityOf(VerifyProdGenerico));
			ClickBTN(VerifyProdGenerico);
			Thread.sleep(3000);
			BFPageBase.TakeScreenShot();
			driver.navigate().back();
			Thread.sleep(3000);
			EtapaQualify = wait.until(ExpectedConditions.elementToBeClickable(EtapaQualify));
			Actions actions = new Actions(driver);
			actions.moveToElement(EtapaQualify).click().build().perform();
			BFPageBase.TakeScreenShot();
			actions = new Actions(driver);
			actions.moveToElement(MarcarComoEtapaActualBTN).click().build().perform();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			BFPageBase.TakeScreenShot();
			ErrorMessage = wait.until(ExpectedConditions.visibilityOf(ErrorMessage));
			System.out.println(ErrorMessage.getText());
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
			BFPageBase.TakeScreenShot();
		} else {
			System.out.println("Etapa no es Identificacion");
			return;
		}

	}
	

	public void CambiarTaxonomia(String ID_OPP) throws InterruptedException {
		OPPHomePage();
		Thread.sleep(3000);
		BFPageBase.TakeScreenShot();
		SearchAndOpenOPP(ID_OPP);
		Thread.sleep(2000);
		BFPageBase.TakeScreenShot();
		ClickBTN(GestionDeOPPTab);
		Thread.sleep(2000);
		BFPageBase.TakeScreenShot();
		VerifyProdGenerico = wait.until(ExpectedConditions.visibilityOf(VerifyProdGenerico));
		Thread.sleep(2000);
		BFPageBase.TakeScreenShot();
		ClickBTN(VerifyProdGenerico);
		ModificarProductoBTN = wait.until(ExpectedConditions.visibilityOf(ModificarProductoBTN));
		BFPageBase.TakeScreenShot();
		ClickBTN(ModificarProductoBTN);
		SeccionDeTaxonomia = wait.until(ExpectedConditions.visibilityOf(SeccionDeTaxonomia));
		BFPageBase.TakeScreenShot();
		if (!SeccionDeTaxonomia.isEnabled()) {
			System.out.println("Taxonomia no se puede modificar.");
		} else {
			// Check if the field is read-only
			return;

		}

	}
	
	
	public void Modificar_ProductoGenerico() throws InterruptedException {

		try{GestionDeOPPTab=wait.until(ExpectedConditions.visibilityOf(GestionDeOPPTab));}
		catch (Exception e) {
			driver.navigate().refresh();
			GestionDeOPPTab=wait.until(ExpectedConditions.visibilityOf(GestionDeOPPTab));
		}
		ClickBTN(GestionDeOPPTab);
		BFPageBase.TakeScreenShot();
		
		WaitElementtoBeVisible(Ver_Todos_Productos);
		WaitElementtoBeClickable(Ver_Todos_Productos);
		ClickBTN(Ver_Todos_Productos);
		
		VerifyProdGenerico = wait.until(ExpectedConditions.visibilityOf(VerifyProdGenerico));
		BFPageBase.TakeScreenShot();
		ClickBTN(VerifyProdGenerico);
		WaitBotonesModificar(4);
		ModificarProductoBTN = wait.until(ExpectedConditions.visibilityOf(ModificarProductoBTN));
		BFPageBase.TakeScreenShot();

		ClickBTN(ModificarProductoBTN);
		BFPageBase.TakeScreenShot();

	}

	public void PortabilityVlaueSelection(WebElement Element) throws InterruptedException {
		Modificar_ProductoGenerico();
		SelectPortabilityBTN = wait.until(ExpectedConditions.visibilityOf(SelectPortabilityBTN));
		ClickBTN(SelectPortabilityBTN);
		BFPageBase.TakeScreenShot();

		Element = wait.until(ExpectedConditions.visibilityOf(Element));
		ClickBTN(Element);
		BFPageBase.TakeScreenShot();

		ClickBTN(GuardarBTN);
		
	}

	
	public String Modificar_Producto_Partner_Campo() throws InterruptedException {
		WaitElementtoBeVisible(Select_Partner_BTN);
		WaitElementtoBeVisible(SelectPortabilityBTN);
		WaitElementtoBeClickable(Select_Partner_BTN);
		ClickBTN(Select_Partner_BTN);
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//li[@role='presentation']//a"), 4));
		BFPageBase.TakeScreenShot();
		WebElement Value1= PartnerValues.get(1);
		ClickBTNJS(Value1);
		String result = null;
		if(Select_Partner_BTN.getText().equals("1MILLIONBOT"))
		{
			
			result= "Values are ordered alphabetically because first value is: 1MILLIONBOT";
			System.out.println(result);
		}
		else
		{
			result= "Value are not ordered alphabetically because first value is Not: 1MILLIONBOT";
			System.out.println(result);
			
		}

		return result;
	}
		

	public void RellenarComplejidad() throws InterruptedException {
		driver.navigate().refresh();
		scrollDown(100);
		BFPageBase.TakeScreenShot();
		WaitElementtoBeClickable(ModificarComplejidad);
		ClickBTNJS(ModificarComplejidad);
		scrollDown(150);
		Thread.sleep(3000);
		WaitElementtoBeClickable(Menu_De_Complejidad);
		ClickBTNJS(Menu_De_Complejidad);
		WaitElementtoBeClickable(Opcion_Complejo2);
		ClickBTNJS(Opcion_Complejo2);
		ClickBTN(Guardar_Modificaciones_OPP);
		wait.until(ExpectedConditions.invisibilityOf(Guardar_Modificaciones_OPP));
		WaitElementtoBeClickable(ModificarComplejidad);
		BFPageBase.TakeScreenShot();

	}

	
		
	public String VerificarEtapa() {
		WaitElementtoBeVisible(Verificar_Etapa);
		return Verificar_Etapa.getText();
	}

	public String VerificarSNAV() {
		WaitElementtoBeVisible(Verificar_SNAV_Esperado);
		return Verificar_SNAV_Esperado.getText();
	}

		
	public void Verificar_Motivo_Resultados_Cierre_OPP()
	{
		
		try{WaitElementtoBeVisible(NombreDe_Oportunity);
		WaitElementtoBeClickable(Boton_Etapa_Cerrada);
		ClickBTNJS(Boton_Etapa_Cerrada);}
		catch (Exception e) {
			driver.navigate().refresh();
			WaitElementtoBeVisible(NombreDe_Oportunity);
			WaitElementtoBeClickable(Boton_Etapa_Cerrada);
			ClickBTNJS(Boton_Etapa_Cerrada);
		}
		BFPageBase.TakeScreenShot();
		ClickBTNJS(MarcarComoEtapaActualBTN);
		BFPageBase.TakeScreenShot();
		WaitElementtoBeClickable(Boton_Menu_De_Etapas);
		BFPageBase.TakeScreenShot();
		ClickBTN(Boton_Menu_De_Etapas);
		BFPageBase.TakeScreenShot();

		WaitElementtoBeClickable(Seleccion_Cerrada_Ganada);	        
	}
	
	public String Check_Each_Result_Cerrada_Ganada()
	{
		Verificar_Motivo_Resultados_Cierre_OPP();
		ClickBTN(Seleccion_Cerrada_Ganada);
		BFPageBase.TakeScreenShot();
		WaitElementtoBeClickable(Boton_Motivo_Resultados);

		ClickBTN(Boton_Motivo_Resultados);
		BFPageBase.TakeScreenShot();
		wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//lightning-base-combobox-item//span[@class='slds-media__body']"), 4));
		
		String Verification_Result = "null";
		for(WebElement Un_Resultado: Motivo_Resultados)
		 { 
			 int counter = 0;
			
			if(Un_Resultado.getText().equals("Precio") || Un_Resultado.getText().equals("Prestaciones de la solución") 
					|| Un_Resultado.getText().equals("Fidelidad a Vodafone") ||Un_Resultado.getText().equals("Ninguno"))
			{
				
				 System.out.println("Element number:" +(counter+1) + " is OK" );
				 Verification_Result = "Ok";
				 counter++;
			}
			
			else
			{
				break;
			}
			 
		 }
		 return Verification_Result;
	}

	
	public String Check_Each_Result_Cerrada_Perdida()
	{
		Verificar_Motivo_Resultados_Cierre_OPP();
		ClickBTN(Seleccion_Cerrada_Perdida);
		BFPageBase.TakeScreenShot();
		WaitElementtoBeClickable(Boton_Motivo_Resultados);

		ClickBTN(Boton_Motivo_Resultados);
		BFPageBase.TakeScreenShot();
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//lightning-base-combobox-item//span[@class='slds-media__body']"), 4));
		
		String Verification_Result = "null";
		for(WebElement Un_Resultado: Motivo_Resultados)
		 { 
			 int counter = 0;
			
			if(Un_Resultado.getText().equals("Precio") || Un_Resultado.getText().equals("Prestaciones de la solución") 
					|| Un_Resultado.getText().equals("Permanencia / penalización") ||Un_Resultado.getText().equals("Ninguno") 
					||Un_Resultado.getText().equals("Problemas de cobertura") ||Un_Resultado.getText().equals("Datos de contacto erróneos") ||Un_Resultado.getText().equals("Descontento con Vodafone"))
			{
				 System.out.println("Element number:" +(counter+1) + " is OK" );
				 Verification_Result = "Ok";
				 counter++;
			}
			
			else
			{
				Verification_Result = "There are different elements";
				System.out.println("There are different elements");
			}
			 
		 }
		 return Verification_Result;
	}
	
	
	public void Check_Each_Result_Cerrada_No_Tratada() throws InterruptedException
	{
		Verificar_Motivo_Resultados_Cierre_OPP();
		ClickBTN(Seleccion_Cerrada_NoTratada);
		BFPageBase.TakeScreenShot();
		WaitElementtoBeClickable(Boton_Motivo_Resultados);

		ClickBTN(Boton_Motivo_Resultados);
		BFPageBase.TakeScreenShot();
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//lightning-base-combobox-item//span[@class='slds-media__body']"), 4));
		for(int i =0; i<5; i++)
		{
			int counter = 0;
		WebElement FirstElement = Motivo_Resultados.get(8);
		FirstElement.click();
		Thread.sleep(6000);
		System.out.println(Boton_Motivo_Resultados.getAttribute("data-value"));
		}
	
	
	}
	
		 
	
	
	
	
	public void Clonar_Con_Productos(String OPPID) throws InterruptedException {
		WaitElementtoBeClickable(Boton_Clonar_Con_Prouctos);
		ClickBTNJS(Boton_Clonar_Con_Prouctos);
		// Should be used this thread because the same elements are shown even when
		// creating the new one. so can not wait explicitly
		try {
			// Wait until the condition is false
			SpecialWait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(Campo_ID_OPP, OPPID)));
			System.out.println("New text value: " + Campo_ID_OPP.getText());

		} catch (Exception e) {
			driver.navigate().refresh();
			WaitElementtoBeVisible(Campo_ID_OPP);
			if (!Campo_ID_OPP.getText().equals(OPPID))
				System.out.println("New OPP ID is : " + Campo_ID_OPP.getText());
		}

	}
		

	public void EnviarAprobacion_Edra() {
		driver.navigate().refresh();
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//button[contains(@title, 'Modificar')]"),
				5));
		WaitElementtoBeClickable(Boton_Enviar_A_Aprobacion);
		ClickBTNJS(Boton_Enviar_A_Aprobacion);
		WaitElementtoBeVisible(Comentario_De_aprobacion);
		SetTXTElement(Comentario_De_aprobacion, "Enviamos EDRA Para aprobacion. Selenium Webdriver(Abdelrazek)");
		WaitElementtoBeClickable(Boton_Enviar_Comentario_Aprobacion);
		BFPageBase.TakeScreenShot();
		ClickBTN(Boton_Enviar_Comentario_Aprobacion);
		Verificar_Confirmation_Message();
	}

	Wait<WebDriver> wait1 = new FluentWait<>(driver)
	        .withTimeout(Duration.ofSeconds(6))  // Maximum wait time
	        .pollingEvery(Duration.ofMillis(300)) // Polling interval
	        .ignoring(NoSuchElementException.class); // Ignore NoSuchElementException
	
	public void Aprobar_Edra() throws InterruptedException {
		try {
			Solicitudes_De_Aprobaciones_HomePage();
		} catch (InterruptedException e) {
			System.out.println("Can't open the approval request Homepage");
			e.printStackTrace();
		}
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(
				By.xpath("//button[@class='slds-button slds-button_icon-border slds-button_icon-x-small']"), 0));
		BFPageBase.TakeScreenShot();

		int number = Mostrar_Acciones_De_Aprobacion.size();
		while (number > 0) {
		    try {
		        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(
		            By.xpath("//button[@class='slds-button slds-button_icon-border slds-button_icon-x-small']"), 0));

		        if (number == 1) {
		            Mostrar_Acciones_De_Aprobacion.get(0).click();
		            WaitElementtoBeClickable(Boton_Aprobar_Edra);
		            ClickBTN(Boton_Aprobar_Edra);
		            WaitElementtoBeVisible(ComentarioAprobarCasoPorCentralSales);
		            SetTXTElement(ComentarioAprobarCasoPorCentralSales, "Aprobado EDRA automaticamente por Selenium Webdriver");
		            ClickBTN(Boton_Confirmar_Aprobar_Edra);
		            driver.navigate().refresh();
		            break; // Exit the loop after performing actions on the single element
		        } else {
		            Mostrar_Acciones_De_Aprobacion.get(0).click();
		            WaitElementtoBeClickable(Boton_Aprobar_Edra);
		            ClickBTN(Boton_Aprobar_Edra);
		            WaitElementtoBeVisible(ComentarioAprobarCasoPorCentralSales);
		            SetTXTElement(ComentarioAprobarCasoPorCentralSales, "Aprobado EDRA automaticamente por Selenium Webdriver");
		            ClickBTN(Boton_Confirmar_Aprobar_Edra);
		            driver.navigate().refresh();
		            
		        }
		    } catch (Exception e) {
		        // Handle the exception if needed
		        number = 0;
		    }
		}
		BFPageBase.TakeScreenShot();
	}

	public void Aprobar_Edra1(String OPPID, String User) throws InterruptedException {
		LogINOBJ = new Log_In_Page(driver);

		scrollDown(750);
		WaitElementtoBeVisible(CheckBox_Edra1);
		if (!CheckBox_Edra1.isSelected()) {
			EnviarAprobacion_Edra();
			LogINOBJ.Cerrar_Sesion();
			LogINOBJ.Log_In_CentralSales();
			try {
				Aprobar_Edra();
			} catch (InterruptedException e) {
				// TO DO Auto-generated catch block
				e.printStackTrace();
			}
			LogINOBJ.Cerrar_Sesion();
			if (User.equalsIgnoreCase("Support"))
				LogINOBJ.Log_In_Soporte();
			else if (User.equalsIgnoreCase("Sales Professional"))
				LogINOBJ.Log_In_SalesProfessional();
			else if (User.equalsIgnoreCase("Sales manager"))
				LogINOBJ.Log_In_SalesManager();

			OPPHomePage();
			SearchAndOpenOPP(OPPID);
			wait.until(ExpectedConditions
					.numberOfElementsToBeMoreThan(By.xpath("//button[contains(@title, 'Modificar')]"), 5));
			scrollDown(600);
			WaitElementtoBeVisible(CheckBox_Edra4);
			if (CheckBox_Edra1.isSelected())
				System.out.println("He Aprobado EDRA1");
			BFPageBase.TakeScreenShot();
			driver.navigate().refresh();
		} else {
			System.out.println("Edra1 esta aprobada ya");
		}

	}

	public void Aprobar_EDRA2(String OPPID, String User) throws InterruptedException {
		CasosOBJ = new Casos(driver);
		LogINOBJ = new Log_In_Page(driver);
		OPPHomePage();
		SearchAndOpenOPP(OPPID);
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//button[contains(@title, 'Modificar')]"),
				5));
		scrollDown(650);
		WaitElementtoBeVisible(CheckBox_Edra2);
		BFPageBase.TakeScreenShot();
		if (CheckBox_Edra1.isSelected() && !CheckBox_Edra2.isSelected()) {
			try {
				CasosOBJ.Crear_Caso_Mesa_De_Oferta();
			} catch (InterruptedException e) {
				System.out.println("Algun error en creacion de mesa de oferta");
				e.printStackTrace();
			}
			LogINOBJ.Cerrar_Sesion();
			LogINOBJ.Log_In_Presales_Operations();

			CasosOBJ.Aprobar_MesaOferta_Con_Preventa(OPPID);
			LogINOBJ.Cerrar_Sesion();

			if (User.equalsIgnoreCase("Support"))
				LogINOBJ.Log_In_Soporte();
			else if (User.equalsIgnoreCase("Sales Professional"))
				LogINOBJ.Log_In_SalesProfessional();
			else if (User.equalsIgnoreCase("Sales manager"))
				LogINOBJ.Log_In_SalesManager();

			OPPHomePage();
			SearchAndOpenOPP(OPPID);
			wait.until(ExpectedConditions
					.numberOfElementsToBeMoreThan(By.xpath("//button[contains(@title, 'Modificar')]"), 5));
			scrollDown(700);
			WaitElementtoBeVisible(CheckBox_Edra4);
			BFPageBase.TakeScreenShot();
			if (CheckBox_Edra2.isSelected()) {
				System.out.println("He Aprobado EDRA2");
			}
		} else if (!CheckBox_Edra1.isSelected()) {
			Aprobar_Edra1(OPPID, User);
			Aprobar_EDRA2(OPPID, User);
			System.out.println("He Aprobado EDRA 1 y 2");
		}
	}

	public void Aprobar_EDRA3(String OPPID, String User) throws InterruptedException {
		CasosOBJ = new Casos(driver);
		OPPHomePage();
		SearchAndOpenOPP(OPPID);
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//button[contains(@title, 'Modificar')]"),
				5));
		scrollDown(650);
		WaitElementtoBeVisible(CheckBox_Edra4);
		BFPageBase.TakeScreenShot();
		if (CheckBox_Edra1.isSelected() && CheckBox_Edra2.isSelected() && !CheckBox_Edra3.isSelected()) {
			EnviarAprobacion_Edra();
			LogINOBJ.Cerrar_Sesion();
			LogINOBJ.Log_In_CentralSales();
			try {
				Aprobar_Edra();
			} catch (InterruptedException e) {
				driver.navigate().refresh();
				Aprobar_Edra();
				e.printStackTrace();
			}
			LogINOBJ.Cerrar_Sesion();
			if (User.equalsIgnoreCase("Support"))
				LogINOBJ.Log_In_Soporte();
			else if (User.equalsIgnoreCase("Sales Professional"))
				LogINOBJ.Log_In_SalesProfessional();
			else if (User.equalsIgnoreCase("Sales manager"))
				LogINOBJ.Log_In_SalesManager();

			OPPHomePage();
			SearchAndOpenOPP(OPPID);
			wait.until(ExpectedConditions
					.numberOfElementsToBeMoreThan(By.xpath("//button[contains(@title, 'Modificar')]"), 5));

			scrollDown(650);
			WaitElementtoBeVisible(CheckBox_Edra4);
			BFPageBase.TakeScreenShot();
			if (CheckBox_Edra3.isSelected()) {
				System.out.println("He Aprobado ya EDRA3");
				BFPageBase.TakeScreenShot();
			}
		}

		else if (CheckBox_Edra1.isSelected() && !CheckBox_Edra2.isSelected()) {
			Aprobar_EDRA2(OPPID, User);
			Aprobar_EDRA3(OPPID, User);

		} else if (!CheckBox_Edra1.isSelected()) {
			Aprobar_Edra1(OPPID, User);
			Aprobar_EDRA2(OPPID, User);
			Aprobar_EDRA3(OPPID, User);
		}
	}

	public void Aprobar_EDRA4(String OPPID, String User) throws InterruptedException {
		CasosOBJ = new Casos(driver);
		OPPHomePage();
		SearchAndOpenOPP(OPPID);
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//button[contains(@title, 'Modificar')]"),
				5));
		scrollDown(650);
		WaitElementtoBeVisible(CheckBox_Edra4);
		BFPageBase.TakeScreenShot();
		if (CheckBox_Edra1.isSelected() && CheckBox_Edra2.isSelected() && CheckBox_Edra3.isSelected()
				&& !CheckBox_Edra4.isSelected()) {
			EnviarAprobacion_Edra();
			LogINOBJ.Cerrar_Sesion();
			LogINOBJ.Log_In_CentralSales();
			try {
				Aprobar_Edra();
			} catch (InterruptedException e) {
				// TO DO Auto-generated catch block
				e.printStackTrace();
			}
			LogINOBJ.Cerrar_Sesion();
			if (User.equalsIgnoreCase("Support"))
				LogINOBJ.Log_In_Soporte();
			else if (User.equalsIgnoreCase("Sales Professional"))
				LogINOBJ.Log_In_SalesProfessional();
			else if (User.equalsIgnoreCase("Sales manager"))
				LogINOBJ.Log_In_SalesManager();
			OPPHomePage();
			SearchAndOpenOPP(OPPID);
			wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//button[contains(@title, 'Modificar')]"),
					5));
			scrollDown(650);
			WaitElementtoBeVisible(CheckBox_Edra4);
			if (CheckBox_Edra4.isSelected()) {
				System.out.println("Edra4 approved ya");
				BFPageBase.TakeScreenShot();
			}
		}

		else if (CheckBox_Edra1.isSelected() && CheckBox_Edra2.isSelected() && !CheckBox_Edra3.isSelected()) {
			Aprobar_EDRA3(OPPID, User);
			Aprobar_EDRA4(OPPID, User);
		}

		else if (CheckBox_Edra1.isSelected() && !CheckBox_Edra2.isSelected()) {
			Aprobar_EDRA2(OPPID, User);
			Aprobar_EDRA3(OPPID, User);
			Aprobar_EDRA4(OPPID, User);
		}

		else if (!CheckBox_Edra1.isSelected()) {
			Aprobar_Edra1(OPPID, User);
			Aprobar_EDRA2(OPPID, User);
			Aprobar_EDRA3(OPPID, User);
			Aprobar_EDRA4(OPPID, User);
		}
	}

	

	public String VerificarEDRAS() throws InterruptedException {
		WaitElementtoBeVisible(CheckBox_Edra4);
		if (CheckBox_Edra1.isSelected() && CheckBox_Edra2.isSelected() && CheckBox_Edra3.isSelected()
				&& CheckBox_Edra4.isSelected()) {
			Approval = "4 EDRAS are approved";
			BFPageBase.TakeScreenShot();
			System.out.println(Approval);
		} else if (CheckBox_Edra1.isSelected() && CheckBox_Edra2.isSelected() && CheckBox_Edra3.isSelected()) {
			Approval = "3 EDRAS are approved";
			BFPageBase.TakeScreenShot();
			System.out.println(Approval);
		} else if (CheckBox_Edra1.isSelected() && CheckBox_Edra2.isSelected()) {
			Approval = "2 EDRA are approved";
			BFPageBase.TakeScreenShot();
		} else if (CheckBox_Edra1.isSelected()) {
			Approval = "EDRA1 is approved";
			BFPageBase.TakeScreenShot();
			System.out.println(Approval);
		} else {
			Approval = "EDRAS are not approved";
			BFPageBase.TakeScreenShot();
			System.out.println(Approval);
		}
		scrollDown(650);
		WaitElementtoBeVisible(CheckBox_Edra4);
		BFPageBase.TakeScreenShot();
		Boton_Etapa_Identificacion.sendKeys(Keys.PAGE_UP);
		return Approval;
	}

	// Locate th opportunity stages:
	// Create function to pass the opportunity to cualify:
	
	
	public void Pass_To_Identify() {
		driver.navigate().refresh();
		WaitElementtoBeVisible(NombreDe_Oportunity);
		WaitElementtoBeClickable(Boton_Etapa_Cualificacion);
		ClickBTNJS(Boton_Etapa_Identificacion);
		ClickBTNJS(MarcarComoEtapaActualBTN);
		BFPageBase.TakeScreenShot();
	}

	public void Pass_To_Cualify() {
		driver.navigate().refresh();
		WaitElementtoBeVisible(NombreDe_Oportunity);
		WaitElementtoBeClickable(Boton_Etapa_Cualificacion);
		ClickBTNJS(Boton_Etapa_Cualificacion);
		ClickBTNJS(MarcarComoEtapaActualBTN);
		BFPageBase.TakeScreenShot();
	}

	public void Pass_To_Propuesta() throws InterruptedException {
		driver.navigate().refresh();
		WaitElementtoBeVisible(NombreDe_Oportunity);
		WaitElementtoBeClickable(Boton_Etapa_Propuesta);
		ClickBTNJS(Boton_Etapa_Propuesta);
		BFPageBase.TakeScreenShot();
		ClickBTNJS(MarcarComoEtapaActualBTN);
		BFPageBase.TakeScreenShot();

	}

	public void Pass_To_Negociando() throws InterruptedException {
		driver.navigate().refresh();
		WaitElementtoBeVisible(NombreDe_Oportunity);
		WaitElementtoBeClickable(Boton_Etapa_Negociando);
		// actions.moveToElement(Boton_Etapa_Negociando).click().build().perform();
		ClickBTNJS(Boton_Etapa_Negociando);
		BFPageBase.TakeScreenShot();
		// actions.moveToElement(MarcarComoEtapaActualBTN).click().build().perform();
		ClickBTNJS(MarcarComoEtapaActualBTN);
		BFPageBase.TakeScreenShot();

	}

	public void Pass_To_Cerrada_Ganada() {
		driver.navigate().refresh();
		WaitElementtoBeVisible(NombreDe_Oportunity);
		WaitElementtoBeClickable(Boton_Etapa_Cerrada);
		ClickBTNJS(Boton_Etapa_Cerrada);
		BFPageBase.TakeScreenShot();
		ClickBTNJS(MarcarComoEtapaActualBTN);
		BFPageBase.TakeScreenShot();
		WaitElementtoBeClickable(Boton_Menu_De_Etapas);
		BFPageBase.TakeScreenShot();
		ClickBTN(Boton_Menu_De_Etapas);
		BFPageBase.TakeScreenShot();

		WaitElementtoBeClickable(Seleccion_Cerrada_Ganada);

		ClickBTN(Seleccion_Cerrada_Ganada);
		BFPageBase.TakeScreenShot();
		WaitElementtoBeClickable(Boton_Motivo_Resultados);

		ClickBTN(Boton_Motivo_Resultados);
		BFPageBase.TakeScreenShot();

		ClickBTN(Seleccion_Motivo_Precio);
		BFPageBase.TakeScreenShot();

		ClickBTN(Boton_Listo);
		BFPageBase.TakeScreenShot();

	}

	public void Pass_To_Cerrada_Perdida() {
		driver.navigate().refresh();
		WaitElementtoBeVisible(NombreDe_Oportunity);
		WaitElementtoBeClickable(Boton_Etapa_Cerrada);
		ClickBTNJS(Boton_Etapa_Cerrada);
		BFPageBase.TakeScreenShot();
		ClickBTNJS(MarcarComoEtapaActualBTN);
		BFPageBase.TakeScreenShot();
		WaitElementtoBeClickable(Boton_Menu_De_Etapas);
		ClickBTN(Boton_Menu_De_Etapas);
		BFPageBase.TakeScreenShot();
		WaitElementtoBeClickable(Seleccion_Cerrada_Perdida);
		ClickBTN(Seleccion_Cerrada_Perdida);
		BFPageBase.TakeScreenShot();

		WaitElementtoBeClickable(Boton_Motivo_Resultados);
		ClickBTN(Boton_Motivo_Resultados);
		BFPageBase.TakeScreenShot();

		ClickBTN(Seleccion_Motivo_Precio);
		BFPageBase.TakeScreenShot();

		ClickBTN(Boton_Listo);
		BFPageBase.TakeScreenShot();
	}

	public void Pass_To_Cerrada_NoTratada() {
		driver.navigate().refresh();
		WaitElementtoBeVisible(NombreDe_Oportunity);
		WaitElementtoBeClickable(Boton_Etapa_Cerrada);
		ClickBTNJS(Boton_Etapa_Cerrada);
		BFPageBase.TakeScreenShot();
		ClickBTNJS(MarcarComoEtapaActualBTN);
		BFPageBase.TakeScreenShot();
		WaitElementtoBeClickable(Boton_Menu_De_Etapas);
		BFPageBase.TakeScreenShot();
		ClickBTN(Boton_Menu_De_Etapas);
		BFPageBase.TakeScreenShot();
		WaitElementtoBeClickable(Seleccion_Cerrada_NoTratada);
		ClickBTN(Seleccion_Cerrada_NoTratada);
		BFPageBase.TakeScreenShot();
		WaitElementtoBeClickable(Boton_Motivo_Resultados);
		ClickBTN(Boton_Motivo_Resultados);
		BFPageBase.TakeScreenShot();
		ClickBTN(Seleccion_Motivo_NoInteresado);
		BFPageBase.TakeScreenShot();
		ClickBTN(Boton_Listo);
		BFPageBase.TakeScreenShot();
	}
}
