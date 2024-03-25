package ProjectPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Casos extends BFPageBase {

	Log_In_Page LogINOBJ;
	public Casos(WebDriver driver) {
		super(driver);
	}

	private String ID_Caso_Preventa = null;
	private String ID_Caso_MesaOferta=null;

	@FindBy(xpath = "//input[@name='Case-search-input']")
	WebElement Buscar_Casos;

	@FindBy(xpath = "//a[@data-refid='recordId']")
	WebElement Case_Name;

	@FindBy(xpath = "//button[@title='Cambiar propietario']")
	WebElement BTN_Cambiar_Propietario;

	@FindBy(xpath = "//input[@title='Buscar Usuarios']")
	WebElement Buscar_Usuarios;

	@FindBy(xpath = "//a[text()='VF Presales Operations']")
	WebElement seleccionar_Usuario;

	@FindBy(xpath = "//button[@class='slds-button slds-button_brand']")
	WebElement Cambiar_Prop_BTN;

	@FindBy(xpath = "//div[@class='slds-theme_error slds-notify--toast']")
	WebElement Error_Message;

	public void Asignar_Caso_cancelado(String CaseID) throws InterruptedException {
		CasosHomePage();
		WaitElementtoBeVisible(Buscar_Casos);
		BFPageBase.TakeScreenShot();
		SetTXTElement(Buscar_Casos, CaseID);
		Buscar_Casos.sendKeys(Keys.ENTER);
		WaitElementtoBeClickable(Case_Name);
		Thread.sleep(2000);
		BFPageBase.TakeScreenShot();
		ClickBTNJS(Case_Name);
		// actions.moveToElement(Case_Name).click().build().perform();
		WaitElementtoBeClickable(BTN_Cambiar_Propietario);
		Thread.sleep(2000);
		BFPageBase.TakeScreenShot();
		ClickBTN(BTN_Cambiar_Propietario);
		WaitElementtoBeVisible(Buscar_Usuarios);
		Thread.sleep(2000);
		BFPageBase.TakeScreenShot();
		SetTXTElement(Buscar_Usuarios, "Presales");
		Buscar_Usuarios.sendKeys(Keys.ARROW_DOWN);
		Buscar_Usuarios.sendKeys(Keys.ENTER);
		WaitElementtoBeClickable(seleccionar_Usuario);
		ClickBTN(seleccionar_Usuario);
		WaitElementtoBeClickable(Cambiar_Prop_BTN);
		Thread.sleep(2000);
		BFPageBase.TakeScreenShot();
		ClickBTN(Cambiar_Prop_BTN);
		WaitElementtoBeVisible(Error_Message);
		Thread.sleep(1000);
		BFPageBase.TakeScreenShot();
		System.out.println(Error_Message.getText());
	}

	@FindBy(xpath = "//button[@title='Nueva tarea']")
	WebElement NuevaTareaBTN;

	@FindBy(xpath = "//li[@data-label='Casos']")
	WebElement Ventana_De_Casos;

	@FindBy(xpath = "//input[@placeholder='Buscar...']")
	WebElement Buscar_Tripleta_De_Casos;

	@FindBy(xpath = "//div[@class='slds-show slds-dropdown slds-dropdown_length-with-icon-7 slds-dropdown_fluid' and @data-key='dropdownresult']")
	WebElement Soporte_Preventa;

	@FindBy(xpath = "//button[@name='selectReason']")
	WebElement Seleccionar_Razon;

	@FindBy(xpath = "//button[@name='selectType']")
	WebElement Seleccionar_Tipo;

	@FindBy(xpath = "//button[@name='selectSubType']")
	WebElement Seleccionar_SubTipo;

	@FindBy(xpath = "/html/body/div[4]/div[1]/section/div[1]/div/div[2]/div[2]/section/div/div/section/div/div[2]/div/div/div/div/one-record-home-flexipage2/forcegenerated-adg-rollup_component___force-generated__flexipage_-record-page___-c-s-p_-opportunity-record-page___-opportunity___-v-i-e-w/forcegenerated-flexipage_csp_opportunityrecordpage_opportunity__view_js/record_flexipage-desktop-record-page-decorator/div[1]/records-record-layout-event-broker/slot/slot/flexipage-record-home-template-desktop2/div/div[2]/div[1]/slot/flexipage-component2/slot/flexipage-tabset2/div/lightning-tabset/div/slot/slot/flexipage-tab2[3]/slot/flexipage-component2[1]/slot/c-c-s-p_-case-management-classification/lightning-card/article/div[2]/slot/div/div[5]/lightning-textarea/div/textarea")
	WebElement Asunto_Del_Caso;

	@FindBy(xpath = "//button[text()='Guardar']")
	WebElement Guardar_Caso;

	@FindBy(xpath = "//button[@aria-label='Nombre del Caso, --Ninguno--']")
	WebElement Seleccionar_Nombre_Caso;

	@FindBy(xpath = "//input[@name='CSP_NumberOfSites__c']")
	WebElement Nimero_De_Sedes;

	@FindBy(xpath = "//div[@class='actionBody']")
	// @FindBy(xpath="//div[@class='isModal inlinePanel oneRecordActionWrapper']")
	WebElement Scroller;

	@FindBy(xpath = "//li[@role='presentation']/div[@data-value='Cloud Applications']")
	WebElement AplicacionesEnLaNube;

	@FindBy(xpath = "//button[contains(@title, ' a Elegido')]")
	WebElement MoverSeleccionA_Elegido;

	@FindBy(xpath = "/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div[2]/div/div/records-lwc-record-layout/forcegenerated-detailpanel_case___0127y000001uqaiqai___full___edit___recordlayout2/records-record-layout-block/slot/records-record-layout-section[2]/div/div/div/slot/records-record-layout-row[7]/slot/records-record-layout-item[1]/div/span/slot/records-record-layout-text-area/lightning-textarea/div[1]/textarea")
	WebElement DescripcionDeProyecto;

	@FindBy(xpath = "//input[@name='CSP_ExpectedDeliveryDate__c']")
	WebElement Fecha_Entrega_Prevista;

	@FindBy(xpath = "//button[@name='SaveEdit']")
	WebElement Guardar_Cambios_Caso;

	@FindBy(xpath = "//a[@title='Ahora mismo']")
	WebElement CambiosPorUsuariosBTN;

	@FindBy(xpath = "//a[@data-tab-name='In Progress']")
	WebElement EnCursoBTN;

	@FindBy(xpath = "//records-highlights-details-item[@style='max-width: 155px;']//lightning-formatted-text")
	WebElement Numero_Del_caso_Preventa;

	public void Creat_CasoPreventa_Con_Tripleta()
	{
		WaitElementtoBeClickable(NuevaTareaBTN);
		BFPageBase.TakeScreenShot();
		WaitElementtoBeClickable(Ventana_De_Casos);
		ClickBTNJS(Ventana_De_Casos);
		WaitElementtoBeVisible(Buscar_Tripleta_De_Casos);
		BFPageBase.TakeScreenShot();
		SetTXTElement(Buscar_Tripleta_De_Casos, "Preve");
		WaitElementtoBeClickable(Soporte_Preventa);
		ClickBTN(Soporte_Preventa);
		for(int i =0; i<3; i++)
		{
			if(Suptipo.getAttribute("data-value").equals("Soporte Preventa")) {
					Asunto_Del_Caso.clear();
					break;
							
				}
			
			else
				{
					driver.navigate().refresh();
					WaitElementtoBeClickable(NuevaTareaBTN);
					BFPageBase.TakeScreenShot();
					WaitElementtoBeClickable(Ventana_De_Casos);
					ClickBTNJS(Ventana_De_Casos);
					WaitElementtoBeVisible(Buscar_Tripleta_De_Casos);
					BFPageBase.TakeScreenShot();
					SetTXTElement(Buscar_Tripleta_De_Casos, "Preve");
					WaitElementtoBeClickable(Soporte_Preventa);
					ClickBTN(Soporte_Preventa);
				
				}	
		}
		SetTXTElement(Asunto_Del_Caso, "Caso Para Automatizacion");
		BFPageBase.TakeScreenShot();
		ClickBTN(Guardar_Caso);
	}
	public String Crear_CasoSoportePreventa_Dentro_De_OPP() throws InterruptedException {
		Creat_CasoPreventa_Con_Tripleta();
		WaitElementtoBeClickable(Seleccionar_Nombre_Caso);
		BFPageBase.TakeScreenShot();
		ClickBTN(Seleccionar_Nombre_Caso);
		Press_Arrow_Dwon(Seleccionar_Nombre_Caso);
		Press_Enter(Seleccionar_Nombre_Caso);
		SetTXTElement(Nimero_De_Sedes, "5");
		BFPageBase.TakeScreenShot();
		scrollDown(Scroller, 300);
		BFPageBase.TakeScreenShot();
		ClickBTNJS(AplicacionesEnLaNube);
		ClickBTN(MoverSeleccionA_Elegido);
		BFPageBase.TakeScreenShot();
		scrollDown(Scroller, 300);
		BFPageBase.TakeScreenShot();
		SetTXTElement(DescripcionDeProyecto, "Caso Automatizacion" + formattedDate);
		SetTXTElement(Fecha_Entrega_Prevista, "31/5/2026");
		BFPageBase.TakeScreenShot();
		scrollDown(Scroller, 300);
		BFPageBase.TakeScreenShot();
		ClickBTN(Guardar_Cambios_Caso);
		WaitElementtoBeClickable(CambiosPorUsuariosBTN);
		WaitElementtoBeVisible(ConfirmationMessage);
		BFPageBase.TakeScreenShot();
		ID_Caso_Preventa = Numero_Del_caso_Preventa.getText();
		System.out.println(ID_Caso_Preventa);
		return ID_Caso_Preventa;

	}

	@FindBy(xpath = "//button[@name='Edit' or text()='Modificar']")
	WebElement Modificar;

	@FindBy(xpath = "//button[contains(@aria-label, 'Estado,')]")
	WebElement CambiarEstadoDeCaso;

	@FindBy(xpath = "//button[@data-value='En Curso']")
	WebElement OpcionEnCurso;

	@FindBy(xpath = "//button[@data-value='Completado']")
	WebElement OpcionCompletado;

	@FindBy(xpath = "//button[@name='SaveEdit' or @class='slds-button slds-button_brand' or text()='Guardar']")
	WebElement GuardarBTN;

	@FindBy(xpath = "//h2[@title='Se produjo un problema.']")
	// @FindBy(xpath="//button[contains(@class, '__mark-complete stepAction ') ]")
	WebElement PrimerErrorDeROLyVERSION;

	@FindBy(xpath = "//button[@title='Cerrar cuadro de diálogo de error']")
	WebElement CerrarCuadroDeError;

	@FindBy(css = "div.actionBody")
	WebElement ScrollerCaso;

	@FindBy(xpath = "//button[@aria-label='Rol, --Ninguno--']")
	WebElement Boton_De_Rol;

	@FindBy(xpath = "//button[@aria-label='Version, --Ninguno--']")
	WebElement Boton_De_Version;

	@FindBy(xpath = "//*[@data-value='TPSA']")
	WebElement TPSA;

	@FindBy(xpath = "//button[@data-value='Completado' or @aria-label='Estado, Completado']")
	WebElement EstadoCompletado;

	@FindBy(xpath = "//input[@name='CSP_VEAmount__c']")
	WebElement Importe_VE;

	@FindBy(xpath = "//div[@class='slds-show slds-dropdown slds-dropdown_length-with-icon-7 slds-dropdown_fluid' and @data-key='dropdownresult']")
	WebElement Mesa_De_Oferta;

	@FindBy(xpath = "//div[@data-target-selection-name='sfdc:RecordField.Case.ParentId']//input")
	WebElement Campo_Buscar_Caso_Preventa_Padre;

	@FindBy(xpath = "//ul[@role='group']//li[@role='presentation']")
	List<WebElement> Listado_De_Casos_Padres;

	@FindBy(xpath = "//li[@class='slds-listbox__item']//lightning-base-combobox-formatted-text")
	WebElement Caso_Preventa_Para_Seleccionar_Como_Padre;

	public static String CaseLink = null;

	public void CerrarCaso() throws InterruptedException {
		driver.navigate().refresh();
		WaitElementtoBeClickable(Modificar);
		BFPageBase.TakeScreenShot();
		ClickBTN(Modificar);
		WaitElementtoBeClickable(CambiarEstadoDeCaso);
		BFPageBase.TakeScreenShot();
		ClickBTN(CambiarEstadoDeCaso);
		// Press_Arrow_Dwon(OpcionAbierto);
		Press_Arrow_Dwon(CambiarEstadoDeCaso);
		Press_Enter(CambiarEstadoDeCaso);

		WaitElementtoBeClickable(GuardarBTN);
		BFPageBase.TakeScreenShot();
		// ClickBTN(OpcionEnCurso);
		ClickBTN(GuardarBTN);
		WaitElementtoBeVisible(PrimerErrorDeROLyVERSION);
		BFPageBase.TakeScreenShot();
		ClickBTN(CerrarCuadroDeError);
		scrollDown(ScrollerCaso, 500);
		WaitElementtoBeClickable(Boton_De_Rol);
		BFPageBase.TakeScreenShot();
		ClickBTN(Boton_De_Rol);
		ClickBTN(TPSA);
		ClickBTN(Boton_De_Version);
		Press_Arrow_Dwon(Boton_De_Version);
		Press_Enter(Boton_De_Version);
		BFPageBase.TakeScreenShot();
		ClickBTN(GuardarBTN);

		WaitElementtoBeVisible(ConfirmationMessage);
		BFPageBase.TakeScreenShot();

		WaitElementtoBeClickable(Modificar);
		BFPageBase.TakeScreenShot();
		ClickBTN(Modificar);

		WaitElementtoBeClickable(CambiarEstadoDeCaso);
		BFPageBase.TakeScreenShot();
		ClickBTN(CambiarEstadoDeCaso);
		// WaitElementtoBeClickable(EstadoCompletado);
		// ClickBTN(EstadoCompletado);
		CambiarEstadoDeCaso.sendKeys(Keys.CONTROL + "C");
		Press_Enter(CambiarEstadoDeCaso);
		BFPageBase.TakeScreenShot();
		ClickBTN(GuardarBTN);

		WaitElementtoBeVisible(PrimerErrorDeROLyVERSION);
		BFPageBase.TakeScreenShot();
		ClickBTN(CerrarCuadroDeError);

		scrollDown(ScrollerCaso, 150);
		WaitElementtoBeVisible(Importe_VE);
		SetTXTElement(Importe_VE, "2");
		BFPageBase.TakeScreenShot();
		ClickBTN(GuardarBTN);
		WaitElementtoBeVisible(PrimerErrorDeROLyVERSION);
		BFPageBase.TakeScreenShot();
		ClickBTN(CerrarCuadroDeError);
		driver.findElement(By.xpath("//button[@name='CancelEdit']")).click();
		WaitElementtoBeClickable(Modificar);
		BFPageBase.TakeScreenShot();
		CaseLink = driver.getCurrentUrl();
	}

	public void Abrir_Caso_Con_URL() {
		WaitForPageToBeLoaded();
		driver.get(CaseLink);
		WaitElementtoBeClickable(Modificar);
		BFPageBase.TakeScreenShot();
		ClickBTN(Modificar);

		WaitElementtoBeClickable(CambiarEstadoDeCaso);
		BFPageBase.TakeScreenShot();
		ClickBTN(CambiarEstadoDeCaso);

		CambiarEstadoDeCaso.sendKeys(Keys.CONTROL + "C");
		Press_Enter(CambiarEstadoDeCaso);
		BFPageBase.TakeScreenShot();

		WaitElementtoBeVisible(Importe_VE);
		SetTXTElement(Importe_VE, "2");
		BFPageBase.TakeScreenShot();
		ClickBTN(GuardarBTN);

		WaitElementtoBeVisible(ConfirmationMessage);
		BFPageBase.TakeScreenShot();
		driver.navigate().refresh();
		WaitElementtoBeClickable(Modificar);
		BFPageBase.TakeScreenShot();

	}

	public String Confirmar_Estado_Del_Caso() {
		driver.get(CaseLink);
		WaitElementtoBeClickable(Modificar);
		ClickBTN(Modificar);

		WaitElementtoBeClickable(CambiarEstadoDeCaso);
		return (CambiarEstadoDeCaso.getText());
	}

	@FindBy(xpath="//button[@name='selectSubType']")
	WebElement Suptipo; 
	
	public void Crear_Caso_Mesa_De_Oferta() throws InterruptedException {

		try {
			Crear_CasoSoportePreventa_Dentro_De_OPP();
		} catch (InterruptedException e) {
			System.out.println("No ha sido creado el caso preventa correctamente.");
			e.printStackTrace();
		}
		ClickBTN(CloseMessage);
		driver.navigate().back();
		driver.navigate().refresh();
		WaitElementtoBeClickable(Ventana_De_Casos);
		ClickBTNJS(Ventana_De_Casos);
		WaitElementtoBeVisible(Buscar_Tripleta_De_Casos);
		BFPageBase.TakeScreenShot();
		SetTXTElement(Buscar_Tripleta_De_Casos, "oferta");
		WaitElementtoBeClickable(Mesa_De_Oferta);
		BFPageBase.TakeScreenShot();
		ClickBTN(Mesa_De_Oferta);
		for(int i =0; i<3; i++)
		{
			if(Suptipo.getAttribute("data-value").equals("Mesa de Oferta")) {
				Asunto_Del_Caso.clear();
				SetTXTElement(Asunto_Del_Caso, "Caso Para Automatizacion");	
				break;
				}
			
			else
				{
				driver.navigate().refresh();
				WaitElementtoBeClickable(Ventana_De_Casos);
				ClickBTNJS(Ventana_De_Casos);

				WaitElementtoBeVisible(Buscar_Tripleta_De_Casos);
				
				SetTXTElement(Buscar_Tripleta_De_Casos, "oferta");
				WaitElementtoBeClickable(Mesa_De_Oferta);
				ClickBTN(Mesa_De_Oferta);				
				}
		}
		BFPageBase.TakeScreenShot();
		ClickBTN(Guardar_Caso);
		
		WaitElementtoBeVisible(Campo_Buscar_Caso_Preventa_Padre);
		BFPageBase.TakeScreenShot();
		driver.navigate().refresh();
		WaitElementtoBeClickable(Modificar);
		ClickBTN(Modificar);
		WaitElementtoBeVisible(Campo_Buscar_Caso_Preventa_Padre);
		actions.moveToElement(Campo_Buscar_Caso_Preventa_Padre).click().build().perform();
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(
				By.xpath("//div[@part='dropdown overlay']//ul[@role='group']//li[@class='slds-listbox__item']"), 1));
		BFPageBase.TakeScreenShot();
		SetTXTElement(Campo_Buscar_Caso_Preventa_Padre, ID_Caso_Preventa);
		wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//li[@role='presentation']//lightning-base-combobox-item"), 1));
		Press_Arrow_Dwon(Campo_Buscar_Caso_Preventa_Padre);
		Press_Arrow_Dwon(Campo_Buscar_Caso_Preventa_Padre);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@role='presentation']//lightning-base-combobox-item")));
		
		Press_Enter(Campo_Buscar_Caso_Preventa_Padre);
		BFPageBase.TakeScreenShot();
		
		jsExecutor1.executeScript("arguments[0].scrollIntoView(true);", GuardarBTN);    
		GuardarBTN.click();
		WaitElementtoBeVisible(Numero_Del_caso_Preventa);
		ID_Caso_MesaOferta = Numero_Del_caso_Preventa.getText();
		
		Verificar_Confirmation_Message();
	}

	

	@FindBy(xpath = "//li[@class='slds-listbox__item']")
	WebElement Numero_De_CasoPadre_Sugerido;

	@FindBy(xpath="//button[@class='slds-button slds-button_neutral search-button slds-truncate' and @aria-label='Buscar']")
	WebElement Campo_De_Busqueda;
	
	@FindBy(xpath="//div//input[@placeholder='Buscar Casos y más...' and @part='input']")
	WebElement Campo_De_Busqueda_Principal;
	
	@FindBy(xpath="//h2[contains(@class, 'recordTitle slds-page-header__title slds-card__header-link')]//a[@data-refid='recordId']")
	WebElement Numero_De_Caso_Buscado; 
	
	@FindBy(xpath="//button[contains(@aria-label, 'Estado,')]")
	WebElement Boton_Estado_Del_Caso; 
	
	@FindBy(xpath="//div[contains(@class, 'slds-dropdown_fluid slds-dropdown_left')]//lightning-base-combobox-item[@data-value='Approved']")
	WebElement Valor_Estado_Aprovado; 
	
	@FindBy(xpath="//lightning-formatted-rich-text//span[@part='formatted-rich-text']//mark")
	WebElement Enlace_Del_Caso;
	
	public void Aprobar_MesaOferta_Con_Preventa(String ID) throws InterruptedException {
		LogINOBJ=new Log_In_Page(driver);
		
		try{
			CasosHomePage();
			wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//td[@role='gridcell']"), 40));
			WaitElementtoBeVisible(Campo_De_Busqueda);
		ClickBTN(Campo_De_Busqueda);
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//search_dialog-instant-result-item//div[contains(@class, 'instant-result-item-query-suggestion') or contains(@class, 'instant-result-item-record-suggestion')]"), 4));
		WaitElementtoBeVisible(Campo_De_Busqueda_Principal);
		SetTXTElement(Campo_De_Busqueda_Principal, ID_Caso_MesaOferta);
		Campo_De_Busqueda_Principal.clear();
		SetTXTElement(Campo_De_Busqueda_Principal, ID_Caso_MesaOferta);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='slds-truncate instant-result-item__content']//span//lightning-formatted-rich-text//span[@part='formatted-rich-text']//mark")));
		ClickBTN(Enlace_Del_Caso);
		}
		
		catch (Exception e) {
			driver.navigate().refresh();
			WaitElementtoBeVisible(Campo_De_Busqueda);
			ClickBTN(Campo_De_Busqueda);		
			WaitElementtoBeVisible(Campo_De_Busqueda_Principal);
			SetTXTElement(Campo_De_Busqueda_Principal, ID_Caso_MesaOferta);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='slds-truncate instant-result-item__content']")));
			ClickBTN(Enlace_Del_Caso);
		}
		
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//button[contains(@title, 'Modificar')]"), 4));
		try{
			WaitElementtoBeClickable(Modificar);
		}
		catch (Exception e) {
			driver.navigate().refresh();
			WaitElementtoBeClickable(Modificar);
		}
		ClickBTNJS(Modificar);
		WaitElementtoBeClickable(Boton_Estado_Del_Caso); 
		ClickBTN(Boton_Estado_Del_Caso);
		WaitElementtoBeClickable(Valor_Estado_Aprovado);
		ClickBTNJS(Valor_Estado_Aprovado);
		WaitElementtoBeClickable(GuardarBTN);
		ClickBTN(GuardarBTN);
		Verificar_Confirmation_Message();
	}
}
