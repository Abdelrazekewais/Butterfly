package ProjectPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AdminCases extends BFPageBase {

	public AdminCases(WebDriver driver) {
		super(driver);
	}

	String VBTName;

	@FindBy(tagName = "table")
	WebElement table;

	@FindBy(xpath = "//a[@data-refid='recordId']")
	List<WebElement> Links;

	@FindBy(xpath = "//input[@name='CSP_VodafoneBusinessTeam__c-search-input']")
	WebElement BuscarVBT;

	@FindBy(xpath = "//*[@id=\"tab-2\"]//*[contains(@class, 'runtime_sales_activities-activity-panel-composer')]//button")
	WebElement NuevoEventoBTN;

	@FindBy(xpath = "//ul[@class='slds-tabs_default__nav']/li[@title='Actividad']")
	WebElement ProximasYVencidas;

	public void BuscarYAbrir_Record(String VBTID) throws InterruptedException {
		driver.get(
				"https://butterfly--qa1.sandbox.lightning.force.com/lightning/o/CSP_VodafoneBusinessTeam__c/list?filterName=00B7Y000004KhGCUA0");
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.tagName("tr"), 5));
		
		// tablerows =
		// wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.tagName("tr"),
		// 6));
		WaitElementtoBeVisible(BuscarVBT);
		BFPageBase.TakeScreenShot();
		SetTXTElement(BuscarVBT, VBTID);
		BuscarVBT.sendKeys(Keys.ENTER);
		wait.until(ExpectedConditions.numberOfElementsToBe(By.tagName("tr"), 2));

		for (WebElement Link : Links) {
			if (Link.getText().equals(VBTID)) {
				BFPageBase.TakeScreenShot();
				Link.click();

			}
		}
	}

	@FindBy(xpath = "//button[@name='Edit']")
	WebElement ModificarBTN;

	@FindBy(xpath = "//*[contains(@id, 'combobox-input-')]")
	// @FindBy(xpath="//button[@title='Modificar Account Manager']")
	WebElement ModificarAccountManager;

	@FindBy(xpath = "(//button[contains(@class, 'slds-button_icon') and contains(@title, 'Borrar selección')])[2]")
	WebElement BorrarACCManager;

	@FindBy(xpath = "/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div/div/div/records-lwc-record-layout/forcegenerated-detailpanel_csp_vodafonebusinessteam__c___0127y000001upqjqaq___full___edit___recordlayout2/records-record-layout-block/slot/records-record-layout-section[2]/div/div/div/slot/records-record-layout-row[1]/slot/records-record-layout-item[1]/div/span/slot/records-record-layout-lookup/lightning-lookup/lightning-lookup-desktop/lightning-grouped-combobox/div/div/lightning-base-combobox/div/div/div[1]/div[1]/div/input")
	WebElement Campo_Account_Manager;

	@FindBy(xpath = "//button[@name='SaveEdit']")
	WebElement GuardarBTN;

	public void Modificar_Miembros_De_Equipo() throws InterruptedException {
		//driver.navigate().refresh();
		//WaitElementtoBeClickable(ProximasYVencidas);
		WaitElementtoBeClickable(ModificarBTN);
		BFPageBase.TakeScreenShot();
		ClickBTN(ModificarBTN);
		// WaitElementtoBeVisible(ModificarAccountManager);
		// System.out.println(ModificarAccountManager.getText());
		WaitElementtoBeClickable(BorrarACCManager);
		BFPageBase.TakeScreenShot();
		//System.out.println(Campo_Account_Manager.getAttribute("data-value"));
		ClickBTN(BorrarACCManager);
		//Thread.sleep(5000);
		SetTXTElement(Campo_Account_Manager, "SalesAd");
		Thread.sleep(3000);
		//Campo_Account_Manager.sendKeys(Keys.RETURN);
		Press_Arrow_Dwon(Campo_Account_Manager);
		Press_Arrow_Dwon(Campo_Account_Manager);
		Press_Enter(Campo_Account_Manager);
		BFPageBase.TakeScreenShot();
		ClickBTN(GuardarBTN);
		WaitElementtoBeVisible(ConfirmationMessage);
		BFPageBase.TakeScreenShot();
		System.out.println(ConfirmationMessage.getText());
	}

	@FindBy(xpath = "//input[@class='keyboardMode--trigger' and @type='checkbox']")
	List<WebElement> Select_CheckBox1;

	// @FindBy(xpath="/html/body/div[4]/div[1]/section/div[1]/div/div[2]/div[1]/div/div/div/div/div/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[5]/td[2]/span/div/input")
	// WebElement Select_CheckBox2;

	public void Select_CheckBoxes() throws InterruptedException {
		driver.get(
				"https://butterfly--qa1.sandbox.lightning.force.com/lightning/o/CSP_VodafoneBusinessTeam__c/list?filterName=00B7Y000004KhGCUA0");
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(
				By.xpath("//input[@class='keyboardMode--trigger' and @type='checkbox']"), 5));

		WebElement checkBox1 = Select_CheckBox1.get(2);
		// Click the first element. Used action class because the element was intecepted
		// with other elements
		actions.moveToElement(checkBox1).click().build().perform();

		WebElement checkBox2 = Select_CheckBox1.get(3);
		actions.moveToElement(checkBox2).click().build().perform();
		BFPageBase.TakeScreenShot();
		//boolean isChecked = checkBox1.isSelected();
		//System.out.println("Checkbox is marked: " + isChecked);

	}

	@FindBy(xpath = "//a[@class='slds-grid slds-grid--vertical-align-center slds-grid--align-center sldsButtonHeightFix']")
	WebElement MenuDeBotones;

	@FindBy(xpath = "//a[@data-target-selection-name='sfdc:QuickAction.CSP_VodafoneBusinessTeam__c.CSP_MassChange']")
	WebElement Boton_De_Cambio_Masivo;

	@FindBy(xpath="//div[@class='slds-grid slds-col slds-is-editing slds-has-flexi-truncate mdp forcePageBlockItem forcePageBlockItemEdit']")
	List<WebElement> Fields;
	
	//@FindBy(xpath="/html/body/div[4]/div[2]/div[2]/div[2]/div/div[2]/div/div/div[2]/section/div/section/div/div/div/div/div/div[1]/div[1]/div/div")
	@FindBy(xpath = "//div[@data-target-selection-name='sfdc:RecordField.CSP_VodafoneBusinessTeam__c.CSP_AccountManager__c']")
	WebElement AccountManagerField;

	@FindAll({
	    @FindBy(xpath = "//div[@class='slds-grid slds-col slds-is-editing slds-has-flexi-truncate mdp forcePageBlockItem forcePageBlockItemEdit']"),
	    @FindBy(xpath = "//li[@class='pillContainerListItem']//a")
	    
	})
	WebElement UsuarioAgregado;
	
	@FindBy(xpath = "//a[@class='deleteAction']")
	List<WebElement> BorrarUsuario;

	@FindBy(xpath = "//button[@title='Aceptar']")
	WebElement Aceptar;
	
	@FindBy(xpath = "/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div[2]/section/div/section/div/div/div/div/div/div[1]/div[1]/div/div/div/div/div[1]/div[1]/div/input")
	WebElement RellenarACCManager;

	@FindBy(xpath = "//button[@class='slds-button slds-button_brand cuf-publisherShareButton undefined uiButton']")
	WebElement Guardar;

	@FindBy(xpath = "//a[@data-refid='recordId' and contains(@class, 'textUnderline outputLookupLink')]")	
	WebElement Seleccionar_UsuarioNuevo;
	
	
	public void CambioMasivo() throws InterruptedException
	{
		try {
			Select_CheckBoxes();
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("No se han seleccionado VBTs, fallo en seleccionar");
		}
		ClickBTN(MenuDeBotones);
		WaitElementtoBeClickable(Boton_De_Cambio_Masivo);
		BFPageBase.TakeScreenShot();
		ClickBTN(Boton_De_Cambio_Masivo);
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//div[@class='slds-grid slds-col slds-is-editing slds-has-flexi-truncate mdp forcePageBlockItem forcePageBlockItemEdit']"), 5));
		System.out.println(Fields.size());
		WebElement FieldManager = Fields.get(0);
		WaitElementtoBeVisible(FieldManager);
		System.out.println(FieldManager.getText());
		WaitElementtoBeVisible(UsuarioAgregado);
		BFPageBase.TakeScreenShot();
		//System.out.println(UsuarioAgregado.getText());
		if(UsuarioAgregado.getText().equals("Account Manager") || UsuarioAgregado.getText().isEmpty())
		{
			//Wait to appear the field ACC Manager to write the username wanted to be added.
			WaitElementtoBeVisible(RellenarACCManager);
			//Loop on the field wrting the user name and if it's not added retry to add it
			for(int x=0; x<=3; x++)
			{
				//every time clear the field and write the username
				RellenarACCManager.clear();
				//Write the userAdmin to add it
				SetTXTElement(RellenarACCManager, "SalesAdmin");
				RellenarACCManager.sendKeys(Keys.RETURN);
				
				 try {Seleccionar_UsuarioNuevo= wait.until(ExpectedConditions.elementToBeClickable(Seleccionar_UsuarioNuevo));
				 Seleccionar_UsuarioNuevo.click();
	                // If clicked successfully, break out of the loop
	                break;
	            } catch (Exception e) {
	                // If an exception is thrown (element not clickable), continue the loop
	                System.out.println("Element not clickable, retrying...");
	            }
			}}
			
			//Thread.sleep(3000);
			//Press_Arrow_Dwon(RellenarACCManager);
			//Press_Enter(RellenarACCManager);
			else if(UsuarioAgregado.getText().contains("Sales")) {
				if(UsuarioAgregado.getText().contains("SalesAd")) {
				//If there are users added, delete all users.
				for(WebElement Borrar: BorrarUsuario)
				{
					ClickBTN(Borrar);
					WaitElementtoBeVisible(RellenarACCManager);
					BFPageBase.TakeScreenShot();
					for(int x=0; x<=3; x++)
					{
						//every time clear the field and write the username
						RellenarACCManager.clear();
						//Write the userAdmin to add it
						SetTXTElement(RellenarACCManager, "SalesProfes");
						BFPageBase.TakeScreenShot();
						RellenarACCManager.sendKeys(Keys.RETURN);
						
						 try {Seleccionar_UsuarioNuevo= wait.until(ExpectedConditions.elementToBeClickable(Seleccionar_UsuarioNuevo));
						 Seleccionar_UsuarioNuevo.click();
			                // If clicked successfully, break out of the loop
			                break;
			            } catch (Exception e) {
			                // If an exception is thrown (element not clickable), continue the loop
			                System.out.println("Element not clickable, retrying...");
			            }
					}}}
				
				
				else if(!UsuarioAgregado.getText().contains("SalesAd")) {
					//If there are users added, delete all users.
					for(WebElement Borrar: BorrarUsuario)
					{
						ClickBTN(Borrar);
						WaitElementtoBeVisible(RellenarACCManager);
						for(int x=0; x<=3; x++)
						{
							//every time clear the field and write the username
							RellenarACCManager.clear();
							//Write the userAdmin to add it
							SetTXTElement(RellenarACCManager, "SalesAd");
							BFPageBase.TakeScreenShot();
							RellenarACCManager.sendKeys(Keys.RETURN);
							
							 try {Seleccionar_UsuarioNuevo= wait.until(ExpectedConditions.elementToBeClickable(Seleccionar_UsuarioNuevo));
							 Seleccionar_UsuarioNuevo.click();
				                // If clicked successfully, break out of the loop
				                break;
				            } catch (Exception e) {
				                // If an exception is thrown (element not clickable), continue the loop
				                System.out.println("Element not clickable, retrying...");
				            }
						}}}

			}
		BFPageBase.TakeScreenShot();
		ClickBTN(Guardar);
		WaitElementtoBeClickable(Aceptar);
		BFPageBase.TakeScreenShot();
		ClickBTN(Aceptar);		
		WaitElementtoBeVisible(ConfirmationMessage);
		BFPageBase.TakeScreenShot();
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.tagName("tr"), 5));
		BFPageBase.TakeScreenShot();

	}}
