package ProjectPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Cuentas extends BFPageBase{
	public Cuentas(WebDriver driver) {
		super(driver);
	}
	
	private String AcoountName= null;
	
	@FindBy(xpath="//a[@title='Solicitar cuenta']")
	WebElement SolicitarCuenta; 
	
	//@FindBy(className  ="slds-input")
	@FindBy(xpath="//div[contains(@class, 'slds-input-has-icon_left-right')]//input[@placeholder='Busque por CIF o Nombre']")
	WebElement BuscarCuentasParaReasignar; 
	
	//@FindBy(xpath="//button[text()='Buscar']")
	@FindBy(xpath="//button[text()='Buscar']")
	WebElement Boton_Buscar;
	
	@FindBy(xpath="//button[@title='reAssign']")
	WebElement Boton_Reasignar_Cuenta;
	
	@FindBy(xpath="//button[@title='reAssign']")
	WebElement Boton_AccesoA_Cuenta;
	
	@FindBy(xpath="//input[@type='radio' and contains(@name, 'lgt-datatable-')]")
	WebElement Seleccionar_Resultado;
	
	@FindBy(xpath="//input[@value='potentialBag']")
	WebElement Boton_Saco_Potenciales;
	
	@FindBy(xpath="//input[@value='specificUser']")
	WebElement Boton_Usuario_Especifico;
	
	@FindBy(xpath="//button[@title='next']")
	WebElement Boton_Siguiente;
	
	@FindBy(xpath="//input[@part='input']")
	List<WebElement> camposDeBusqueda;
	
	@FindBy(xpath="//button[contains(@aria-describedby, 'salesforce-lightning-tooltip-bubble_')]")
	WebElement Bubble; 
	
	@FindBy(xpath = "//input[@name='Account-search-input']")
	WebElement Campo_Buscar_Cuentas; 
	
	@FindBy(xpath = "//th//a[@data-refid='recordId']")
	WebElement Cuenta_Como_Resultado_De_Busqueda;
	
	@FindBy(xpath = "//button[@title='Modificar Nombre de la Cuenta']")
	WebElement Modificar_Nombre_DeCuenta;
	
	@FindBy(xpath = "//input[@name='Name']")
	WebElement input_Nombre_DeCuenta;
	
	@FindBy(xpath = "//div[@data-target-selection-name='sfdc:RecordField.Account.Name']//input")
	WebElement input_Nombre_DeCuenta_Partner;
	
	@FindBy(xpath = "//button[@name='SaveEdit']")
	WebElement Guardar_Cambios;
	
	@FindBy(xpath = "//button[@title='Guardar']")
	WebElement Guardar_Cambios_Partner;
	
	@FindBy(xpath = "//div[@data-target-selection-name='sfdc:RecordField.Account.Name']//lightning-formatted-text")
	WebElement Verificar_Nombre_Cuenta;
	
	@FindBy(xpath = "//div[@data-target-selection-name='sfdc:RecordField.Account.Name']//div[@class='slds-form-element__control slds-grid itemBody']//span//span")
	WebElement Verificar_Nombre_Cuenta_Partner;
	
	@FindBy(xpath = "//button[@title='Seleccionar una vista de lista: Cuentas']")
	WebElement Boton_Seleccionar_La_Vista;
	
	@FindBy(xpath = "//input[@placeholder='Buscar listas...']")
	WebElement Campo_Buscar_Listas;
	
	
	@FindBy(xpath="//div[@class='list uiAbstractList forceVirtualAutocompleteMenuList']//li//a[@role='option']")
	WebElement Resultado_Campo_Buscar_Vistas;	
	
	public void Reasignar_Cuenta_NOT_Active(String CIF)
	{
		try {
			CuentasHomePage();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		WaitElementtoBeClickable(SolicitarCuenta);
		BFPageBase.TakeScreenShot();
		ClickBTN(SolicitarCuenta);
		WaitElementtoBeVisible(BuscarCuentasParaReasignar);
		BFPageBase.TakeScreenShot();
		SetTXTElement(BuscarCuentasParaReasignar, CIF);
		BFPageBase.TakeScreenShot();
		ClickBTN(Boton_Buscar);
		WaitElementtoBeClickable(Seleccionar_Resultado);
		BFPageBase.TakeScreenShot();
		ClickBTNJS(Seleccionar_Resultado);
		BFPageBase.TakeScreenShot();
		ClickBTN(Boton_Reasignar_Cuenta);
		WaitElementtoBeClickable(Boton_Saco_Potenciales);
		BFPageBase.TakeScreenShot();
		ClickBTNJS(Boton_Saco_Potenciales);
		BFPageBase.TakeScreenShot();
		ClickBTN(Boton_Siguiente);
		WaitElementtoBeVisible(ConfirmationMessage);
		BFPageBase.TakeScreenShot();
	}

	
	public void Tener_Acceso(String CIF) throws InterruptedException
	{
		driver.get("https://butterfly--qa1.sandbox.my.site.com/partners/s/account/Account/Default");
		WaitElementtoBeClickable(SolicitarCuenta);
		BFPageBase.TakeScreenShot();
		ClickBTN(SolicitarCuenta); 
		//WaitElementtoBeClickable(Boton_Buscar);
		//WaitElementtoBeVisible(BuscarCuentasParaReasignar);
		Thread.sleep(9000);
		//System.out.println(camposDeBusqueda.size());
		//camposDeBusqueda.get(0).sendKeys(CIF);
		//Thread.sleep(6000);
		//BFPageBase.TakeScreenShot();
		Bubble.click();
		Bubble.sendKeys(Keys.TAB);
		SetTXTElement(Bubble,CIF );
		//BFPageBase.TakeScreenShot();
		WaitElementtoBeClickable(Boton_Buscar);
		ClickBTN(Boton_Buscar);
		WaitElementtoBeClickable(Seleccionar_Resultado);
		BFPageBase.TakeScreenShot();
		ClickBTNJS(Seleccionar_Resultado);
		BFPageBase.TakeScreenShot();
		WaitElementtoBeClickable(Boton_AccesoA_Cuenta);
		ClickBTN(Boton_AccesoA_Cuenta);
		BFPageBase.TakeScreenShot();
		WaitElementtoBeVisible(ConfirmationMessage);
		BFPageBase.TakeScreenShot();
	}
	
	
	public void Buscar_Cuentas(String AccountID) throws InterruptedException
	{
		
		WaitElementtoBeVisible(Campo_Buscar_Cuentas);
		Campo_Buscar_Cuentas.clear();
		BFPageBase.TakeScreenShot();
		SetTXTElement(Campo_Buscar_Cuentas, AccountID);
		Press_Enter(Campo_Buscar_Cuentas);
		BFPageBase.TakeScreenShot();
		wait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.xpath("//tbody//tr"), 3));
		BFPageBase.TakeScreenShot();
		ClickBTNJS(Cuenta_Como_Resultado_De_Busqueda);
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//button[contains(@title, 'Modificar')]"),
				4));
		BFPageBase.TakeScreenShot();
		
	}
	public void Modificar_Nombre_DeCuenta()
	{
		try{WaitElementtoBeClickable(Modificar_Nombre_DeCuenta);
		BFPageBase.TakeScreenShot();
		ClickBTN(Modificar_Nombre_DeCuenta);
		WaitElementtoBeVisible(input_Nombre_DeCuenta);
		BFPageBase.TakeScreenShot();
		SetTXTElement(input_Nombre_DeCuenta, "Cuenta" + formattedDate);
		BFPageBase.TakeScreenShot();
		ClickBTN(Guardar_Cambios);
		WaitElementtoBeVisible(Verificar_Nombre_Cuenta);
		BFPageBase.TakeScreenShot();}
		catch (Exception e) {
			driver.navigate().refresh();
			WaitElementtoBeClickable(Modificar_Nombre_DeCuenta);
			BFPageBase.TakeScreenShot();
			ClickBTN(Modificar_Nombre_DeCuenta);
			WaitElementtoBeVisible(input_Nombre_DeCuenta);
			BFPageBase.TakeScreenShot();
			SetTXTElement(input_Nombre_DeCuenta, "Cuenta" + formattedDate);
			BFPageBase.TakeScreenShot();
			ClickBTN(Guardar_Cambios);
			WaitElementtoBeVisible(Verificar_Nombre_Cuenta);
			BFPageBase.TakeScreenShot();
		}
	}
	
	public void Modificar_Nombre_DeCuenta_Partner()
	{
		try{WaitElementtoBeClickable(Modificar_Nombre_DeCuenta);
		BFPageBase.TakeScreenShot();
		ClickBTN(Modificar_Nombre_DeCuenta);
		WaitElementtoBeVisible(input_Nombre_DeCuenta_Partner);
		BFPageBase.TakeScreenShot();
		SetTXTElement(input_Nombre_DeCuenta_Partner, "Cuenta" + formattedDate);
		BFPageBase.TakeScreenShot();
		ClickBTN(Guardar_Cambios_Partner);
		WaitElementtoBeVisible(Verificar_Nombre_Cuenta_Partner);
		BFPageBase.TakeScreenShot();}
		catch (Exception e) {
			driver.navigate().refresh();
			WaitElementtoBeClickable(Modificar_Nombre_DeCuenta);
			BFPageBase.TakeScreenShot();
			ClickBTN(Modificar_Nombre_DeCuenta);
			WaitElementtoBeVisible(input_Nombre_DeCuenta_Partner);
			BFPageBase.TakeScreenShot();
			SetTXTElement(input_Nombre_DeCuenta_Partner, "Cuenta" + formattedDate);
			BFPageBase.TakeScreenShot();
			ClickBTN(Guardar_Cambios_Partner);
			WaitElementtoBeVisible(Verificar_Nombre_Cuenta_Partner);
			BFPageBase.TakeScreenShot();
		}
	}


	public String Verificar_Nombre_De_Cuenta()
	{
		WaitElementtoBeVisible(Verificar_Nombre_Cuenta);
		AcoountName = Verificar_Nombre_Cuenta.getText();
		return AcoountName;
	}
	
	public String Verificar_Nombre_De_Cuenta_Partner()
	{
		WaitElementtoBeVisible(Verificar_Nombre_Cuenta_Partner);
		AcoountName = Verificar_Nombre_Cuenta_Partner.getText();
		return AcoountName;
	}


	public void Seleccionar_Vista(String Nombre_De_Vista_Requerida)
	{
		WaitElementtoBeClickable(Boton_Seleccionar_La_Vista);
		BFPageBase.TakeScreenShot();
		ClickBTNJS(Boton_Seleccionar_La_Vista);
		BFPageBase.TakeScreenShot();
		WaitElementtoBeVisible(Campo_Buscar_Listas);
		Campo_Buscar_Listas.clear();
		BFPageBase.TakeScreenShot();
		SetTXTElement(Campo_Buscar_Listas, Nombre_De_Vista_Requerida);
		wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//div[@class='list uiAbstractList forceVirtualAutocompleteMenuList']//li//a[@role='option']"), 1));
		BFPageBase.TakeScreenShot();
		ClickBTN(Resultado_Campo_Buscar_Vistas);
		BFPageBase.TakeScreenShot();
	}
	
	@FindBy(xpath = "//div[@class='slds-page-header__name-title']//h1//span[2]")
	WebElement Nombre_De_La_Vista; 
	
	public String Verifcar_Vista_De_Cuentas()
	{
		WaitElementtoBeVisible(Nombre_De_La_Vista);
		BFPageBase.TakeScreenShot();
		return Nombre_De_La_Vista.getText();

	}


}
