package ProjectPages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OPPsPartnerCommunity extends BFPageBase{
	public OPPsPartnerCommunity(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath="//input[@name='Opportunity-search-input']")
	WebElement BuscarOPP;
	
	@FindBy(xpath="//a[@data-refid='recordId']")
	WebElement NombreDeOPP;
	
	@FindBy(xpath="//*[@id=\"CustomerPortalTemplate\"]/div[2]/div/div[2]/div/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[1]/td[4]/span/span")
	WebElement EtapaDeOPP;
	
	@FindBy(xpath="//li[contains(@data-target-selection-name, 'sfdc:QuickAction.Opportunity.CSP_AddProduct')]")
	WebElement GestionarProductosBTN;
	
	@FindBy(xpath="/html/body/div[7]/div/div[2]/div/div[2]/div/div/div/div[2]/section/article/c-c-s-p_opp-products-container-cmp/div/c-c-s-p_add-products-cmp/lightning-card/article/div[2]/slot/div[2]/lightning-datatable/div[2]/div/div/table/tbody/tr[2]/td[1]")
	WebElement SeleccionProdGener;
	
	@FindBy(css="div.modal-body.scrollable.slds-modal__content.slds-p-around--medium")
	WebElement ScrollParaProds;
	
	@FindBy(xpath="//button[@title='Siguiente']")
	WebElement SiguienteBTN;
	
	@FindBy(xpath="//input[@class='slds-input' and @name='quantity' and @inputmode='decimal' ]")
	WebElement Cantidad;
	
	@FindBy(xpath="//button[@name='actionType' and @aria-haspopup='listbox' and @role='combobox']")
	WebElement TipoDeAccionBTN;
	
	@FindBy(xpath="//input[@name='oneTimeRevenue']")
	WebElement IngresosUnicos;
	
	@FindBy(xpath="//input[@name='productTermsMonths']")
	WebElement Plazos;
	
	@FindBy(xpath="//button[@title='Guardar']")
	WebElement GuardarBTN;
	
	@FindBy(xpath="//a[@data-tab-name='2']")
	WebElement GestionDeOPPTab;
	
	@FindBy(partialLinkText = "Producto genérico")
	WebElement VerifyProdGenerico;
	
	@FindBy(xpath = "//li[@role='presentation' and @data-name='Qualify']")
	//a[@data-tab-name='Qualify']
	WebElement EtapaQualify;
	
	@FindBy(css="button.slds-button.slds-button--brand.slds-path__mark-complete.stepAction.active.uiButton")
	WebElement MarcarComoEtapaActualBTN;
	
	@FindBy(css="div.toastTitle.slds-text-heading--small")
	WebElement ErrorMessage;
	
	
	
	public void AnadirProducGenerico() throws InterruptedException
	{
		GestionarProductosBTN=wait.until(ExpectedConditions.visibilityOf(GestionarProductosBTN));
		ClickBTN(GestionarProductosBTN);
		SeleccionProdGener=wait.until(ExpectedConditions.visibilityOf(SeleccionProdGener));
		ClickBTN(SeleccionProdGener);
		scrollDown(ScrollParaProds, 2000);
		ClickBTN(SiguienteBTN);
		Cantidad=wait.until(ExpectedConditions.visibilityOf(Cantidad));
		SetTXTElement(Cantidad, "1");
		ClickBTN(TipoDeAccionBTN);
		TipoDeAccionBTN.sendKeys(Keys.ARROW_DOWN);
		TipoDeAccionBTN.sendKeys(Keys.ENTER);
		SetTXTElement(IngresosUnicos, "23000000");
		IngresosUnicos.clear();
		Thread.sleep(3000);
		SetTXTElement(IngresosUnicos, "23000000");
		Thread.sleep(3000);
		SetTXTElement(Plazos, "12");
		Actions actions = new Actions(driver); actions.moveToElement(GuardarBTN).click().build().perform();

		//ClickBTN(GuardarBTN);
		Thread.sleep(6000);
	}
	
	
	public void SearchAndOpenOPPPartner(String OPPID) throws InterruptedException
	{
		
		BuscarOPP=wait.until(ExpectedConditions.visibilityOf(BuscarOPP));
		SetTXTElement(BuscarOPP, OPPID);
		EtapaDeOPP=wait.until(ExpectedConditions.visibilityOf(EtapaDeOPP));
		if(EtapaDeOPP.getText().contains("Identifica"))
		{
			NombreDeOPP=wait.until(ExpectedConditions.elementToBeClickable(NombreDeOPP));
			ClickBTN(NombreDeOPP);
		}
		else
		{
			return;
		}
		
		//EtapaDeOPP=wait.until(ExpectedConditions.visibilityOf(EtapaDeOPP));
	}
	
	@FindBy(xpath="//*[@id=\"CustomerPortalTemplate\"]/div[1]/div[2]/div/div/div[2]/div/div/div/community_navigation-global-navigation-list/div/nav/ul/li[6]")
	WebElement PartnerOPPBTN;
	
	
	public void OPPHomePartner()
	{
		PartnerOPPBTN=wait.until(ExpectedConditions.elementToBeClickable(PartnerOPPBTN));
		ClickBTN(PartnerOPPBTN);
	}
	
	public void CambiarEtapaPartner(String OPPID) throws InterruptedException
	{
		
		OPPHomePartner();
		SearchAndOpenOPPPartner(OPPID);
		BFPageBase.TakeScreenShot();
		//AnadirProducGenerico();
		//Thread.sleep(4000);
		//BFPageBase.TakeScreenShot();
		//driver.navigate().back();
		GestionDeOPPTab=wait.until(ExpectedConditions.visibilityOf(GestionDeOPPTab));
		ClickBTN(GestionDeOPPTab);
		BFPageBase.TakeScreenShot();
		VerifyProdGenerico=wait.until(ExpectedConditions.visibilityOf(VerifyProdGenerico));
		ClickBTN(VerifyProdGenerico);
		Thread.sleep(3000);
		BFPageBase.TakeScreenShot();
		driver.navigate().back();
		Thread.sleep(3000);
		EtapaQualify=wait.until(ExpectedConditions.elementToBeClickable(EtapaQualify));
		Actions actions = new Actions(driver); actions.moveToElement(EtapaQualify).click().build().perform();
		BFPageBase.TakeScreenShot();
		actions = new Actions(driver); actions.moveToElement(MarcarComoEtapaActualBTN).click().build().perform();
		BFPageBase.TakeScreenShot();
		ErrorMessage=wait.until(ExpectedConditions.visibilityOf(ErrorMessage));
		System.out.println(ErrorMessage.getText());
		Thread.sleep(1500);
		BFPageBase.TakeScreenShot();
	}

	
	@FindBy(xpath="//a[@title='Modificar' and @role='button']")
	WebElement ModificarProductoBTN;
	
	@FindBy(css="div.slds-form-element.slds-form-element_readonly.slds-grow.slds-hint-parent.override--slds-form-element")
	public WebElement SeccionDeTaxonomia;
	
	public void CambiarTaxonomiaPC(String OPPID) throws InterruptedException
	{
		OPPHomePartner();
		Thread.sleep(3000);
		BFPageBase.TakeScreenShot();
		SearchAndOpenOPPPartner(OPPID);
		Thread.sleep(3000);
		BFPageBase.TakeScreenShot();
		GestionDeOPPTab=wait.until(ExpectedConditions.visibilityOf(GestionDeOPPTab));
		ClickBTN(GestionDeOPPTab);
		Thread.sleep(2000);
		BFPageBase.TakeScreenShot();
		VerifyProdGenerico=wait.until(ExpectedConditions.visibilityOf(VerifyProdGenerico));
		ClickBTN(VerifyProdGenerico);
		Thread.sleep(2000);
		BFPageBase.TakeScreenShot();
		ModificarProductoBTN=wait.until(ExpectedConditions.visibilityOf(ModificarProductoBTN));
		
		ClickBTN(ModificarProductoBTN);
		Thread.sleep(4000);
		SeccionDeTaxonomia=wait.until(ExpectedConditions.visibilityOf(SeccionDeTaxonomia));
		BFPageBase.TakeScreenShot();
		if (!SeccionDeTaxonomia.isEnabled()) {
			System.out.println("Taxonomia no se puede modificar.");
        } else {
            // Check if the field is read-only
        	return;
        	
        }
		
	}

}
