package ProjectPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeadsPC extends BFPageBase {

	public LeadsPC(WebDriver driver) {
		super(driver);
	}

	String Name = "";
	// String xpathExpression = "//a[@data-refid='recordId' and @title='" + Name +
	// "']";

	@FindBy(xpath = "//a[text() = 'Todos mis leads']")
	WebElement LeadHomePage_PC;

	@FindBy(xpath = "//input[@name='Lead-search-input']")
	WebElement LeadSearch_PC;

	// @FindBy(xpath = "//a[@data-refid='recordId' and text()='" + Name + "']")
	// WebElement Lead_Link_PC;

	@FindBy(xpath = "//button[@title='Cambiar propietario']")
	WebElement Cambiar_Propietario;

	@FindBy(xpath = "//input[@title='Buscar Usuarios']")
	WebElement Buscar_Propietarios;

	@FindBy(xpath = "//button[@class='slds-button slds-button--neutral uiButton--default uiButton--brand uiButton forceActionButton']")
	WebElement ConfirmCambiarPropietario;

	@FindBy(xpath = "//div[contains(@id, 'toastDescription')]")
	WebElement ConfirmationMessage;

	@FindBy(xpath = "//li[@role='presentation' and @class='lookup__item  default uiAutocompleteOption forceSearchInputLookupDesktopOption' and @data-aura-class='uiAutocompleteOption forceSearchInputLookupDesktopOption']")
	WebElement FirstElement;

	@FindBy(xpath = "//a[@title='Modificar']")
	WebElement Modificar_Lead_BTN;

	@FindBy(xpath = "//a[contains(@data-interactive-lib-uid, '10')]")
	public WebElement VerifyEstadoPC;

	@FindBy(xpath = "//button[@title='Nueva Tarea']")
	WebElement NuevaTareaBTN;
	
	@FindBy(xpath = "//button[@class='slds-button slds-button--brand slds-path__mark-complete stepAction current uiButton']")
	WebElement MarcarcomoCompletadoBTN;
	
	public void OpenLeadsHomePagePC() throws InterruptedException {
		WaitElementtoBeClickable(LeadHomePage_PC);
		ClickBTN(LeadHomePage_PC);
	}

	@FindBy(xpath = "//a[text()='Ver todo']")
	WebElement VerTodasLasTareas;

	public void Search_Leads(String ID) throws InterruptedException {

		driver.get("https://butterfly--qa1.sandbox.my.site.com/partners/s/lead/" + ID);
		//WaitElementtoBeVisible(LeadSearch_PC);
		//SetTXTElement(LeadSearch_PC, Name);
		//LeadSearch_PC.sendKeys(Keys.ENTER);
	        }

		// Lead_Link_PC=driver.findElement(By.xpath("//a[@data-refid='recordId' and
		// @title='" + Name + "']"));
		// Lead_Link_PC=wait.until(ExpectedConditions.visibilityOf(Lead_Link_PC));

		// jsExecutor1.executeScript("arguments[0].click();", Lead_Link_PC);
	

	public void Verify_Lead_Con_Cambio_Propietario() throws InterruptedException {
		// always found the error: javascript error: Cannot read properties of undefined
		// (reading 'defaultView')
		// Will redirect to the LeadPage by driver.navigate()
		// WaitElementtoBeClickable(LeadHomePage_PC);
		// Thread.sleep(6000);
		// actions.moveToElement(LeadHomePage_PC).click().build().perform();
		// Thread.sleep(6000);

		WaitElementtoBeVisible(VerTodasLasTareas);
		WaitElementtoBeVisible(NuevaTareaBTN);
		WaitElementtoBeVisible(MarcarcomoCompletadoBTN);
		
		BFPageBase.TakeScreenShot();
		ClickBTN(Cambiar_Propietario);
		WaitElementtoBeVisible(Buscar_Propietarios);
		BFPageBase.TakeScreenShot();
		SetTXTElement(Buscar_Propietarios, "Partner Comercial 1 TSSE");
		// Thread.sleep(4000);
		WaitElementtoBeVisible(FirstElement);
		BFPageBase.TakeScreenShot();
		jsExecutor1.executeScript("arguments[0].click();", FirstElement);
		ClickBTN(ConfirmCambiarPropietario);
		// Thread.sleep(4000);
		WaitElementtoBeVisible(ConfirmationMessage);
		BFPageBase.TakeScreenShot();
		//System.out.println(ConfirmationMessage.getText());
		WaitElementtoBeClickable(VerTodasLasTareas);
		BFPageBase.TakeScreenShot();
		// Thread.sleep(6000);

		WaitElementtoBeClickable(Modificar_Lead_BTN);
		Modificar_Lead_BTN.click();
		WaitElementtoBeClickable(VerifyEstadoPC);

		if (!VerifyEstadoPC.getText().equals("Nuevo")) {
			System.out.println("Failed: Estado cambiado y no deberia: " + ConfirmationMessage.getText());
		}

	}

}
