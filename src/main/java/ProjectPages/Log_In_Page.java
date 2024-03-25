package ProjectPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Log_In_Page extends BFPageBase {

	public Log_In_Page(WebDriver driver) {
		super(driver);
	}

	
	@FindBy(id = "username")
	public WebElement UserName;
	@FindBy(id = "password")
	public WebElement Password;
	@FindBy(id = "Login")
	public WebElement LogInBTN;

	public void LogIn_SalesForce_FL(String User, String pass) throws InterruptedException {
		driver.navigate().to("https://butterfly--qa1.sandbox.my.salesforce.com/");
		SetTXTElement(UserName, User);
		SetTXTElement(Password, pass);
		ClickBTN(LogInBTN);
		Thread.sleep(3000);
	}
	
	@FindBy(id = "username")
	public WebElement UserNamePC;
	@FindBy(id = "password")
	public WebElement PasswordPC;
	@FindBy(id = "Login")
	public WebElement LogInBTNPC;
	
	@FindBy(xpath = "//div[contains(@class, 'navexConsoleTabContainer')]//div[@aria-label='Fichas de espacio de trabajo de Butterfly']//button[contains(@class,'slds-button_icon-x-small slds-button_icon-container') and contains(@title, 'Cerrar')]")
	List< WebElement> Boton_Cerrar_Ventanas;

	public void LogIn_SalesForce_PC(String User, String pass) {
		driver.navigate().to("https://butterfly--qa1.sandbox.my.site.com/partners/login");
		UserName = wait.until(ExpectedConditions.visibilityOf(UserName));
		SetTXTElement(UserName, User);
		Password = wait.until(ExpectedConditions.visibilityOf(Password));
		SetTXTElement(Password, pass);
		LogInBTN = wait.until(ExpectedConditions.visibilityOf(LogInBTN));
		ClickBTN(LogInBTN);
	}

	public void Log_In_SalesProfessional() throws InterruptedException {
		driver.navigate().to("https://butterfly--qa1.sandbox.my.salesforce.com/");
		SetTXTElement(UserName, "salesprofessional2@tsse.com.vf.qa1");
		SetTXTElement(Password, "contra@2023");
		BFPageBase.TakeScreenShot();
		ClickBTN(LogInBTN);
		Thread.sleep(8000);	
		for(WebElement Boton: Boton_Cerrar_Ventanas)
		{
			WaitElementtoBeClickable(Boton);
			ClickBTN(Boton);
		}
		

	}

	public void Log_In_SalesManager() throws InterruptedException
	{
		driver.navigate().to("https://butterfly--qa1.sandbox.my.salesforce.com/");
		WaitElementtoBeVisible(UserName);
		SetTXTElement(UserName, "salesmanager@tsse.com.vf.qa1");
		WaitElementtoBeVisible(Password);
		SetTXTElement(Password, "contra@2023");
		WaitElementtoBeClickable(LogInBTN);
		ClickBTN(LogInBTN);
		Thread.sleep(7000);
		try{for(WebElement Boton: Boton_Cerrar_Ventanas)
		{
			WaitElementtoBeClickable(Boton);
			ClickBTNJS(Boton);
		}}
		catch (Exception e) {
			driver.navigate().refresh();
			{for(WebElement Boton: Boton_Cerrar_Ventanas)
			{
				WaitElementtoBeClickable(Boton);
				ClickBTNJS(Boton);
			}
			}}
	}
	
	public void Log_In_CentralSales() throws InterruptedException
	{
		driver.navigate().to("https://butterfly--qa1.sandbox.my.salesforce.com/");
		WaitElementtoBeVisible(UserName);
		SetTXTElement(UserName, "centralsales@tsse.com.vf.qa1");
		WaitElementtoBeVisible(Password);
		SetTXTElement(Password, "calidad@2023");
		WaitElementtoBeClickable(LogInBTN);
		ClickBTN(LogInBTN);
		Thread.sleep(3000);
		for(WebElement Boton: Boton_Cerrar_Ventanas)
		{
			WaitElementtoBeClickable(Boton);
			ClickBTN(Boton);
		}
		Solicitudes_De_Aprobaciones_HomePage();
	}
	
	public void Log_In_Presales_Operations() throws InterruptedException
	{
		driver.navigate().to("https://butterfly--qa1.sandbox.my.salesforce.com/");
		WaitElementtoBeVisible(UserName);
		SetTXTElement(UserName, "vfpresalesoperations@tsse.com.vf.qa1");
		WaitElementtoBeVisible(Password);
		SetTXTElement(Password, "contra@2023");
		WaitElementtoBeClickable(LogInBTN);
		BFPageBase.TakeScreenShot();
		ClickBTN(LogInBTN);
		WaitForPageToBeLoaded();
		Thread.sleep(5000);
		for(WebElement Boton: Boton_Cerrar_Ventanas)
		{
			WaitElementtoBeClickable(Boton);
			ClickBTN(Boton);
			
		}
		wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//div[contains(@class, 'navexConsoleTabContainer')]//div[@aria-label='Fichas de espacio de trabajo de Butterfly']//button[contains(@class,'slds-button_icon-x-small slds-button_icon-container') and contains(@title, 'Cerrar')]"), 0));
		
	}
	
	
	public void Log_In_Soporte() throws InterruptedException
	{
		driver.navigate().to("https://butterfly--qa1.sandbox.my.salesforce.com/");
		WaitElementtoBeVisible(UserName);
		SetTXTElement(UserName, "soporte@tsse.com.vf.qa1");
		WaitElementtoBeVisible(Password);
		SetTXTElement(Password, "Suport@2023");
		WaitElementtoBeClickable(LogInBTN);
		BFPageBase.TakeScreenShot();
		ClickBTN(LogInBTN);
		Thread.sleep(2000);
	}
	
	public void Log_In_Admin() throws InterruptedException
	{
		driver.navigate().to("https://butterfly--qa1.sandbox.my.salesforce.com/");
		WaitElementtoBeVisible(UserName);
		SetTXTElement(UserName, "salesadmin@tsse.com.vf.qa1	");
		WaitElementtoBeVisible(Password);
		SetTXTElement(Password, "sales@2023");
		WaitElementtoBeClickable(LogInBTN);
		BFPageBase.TakeScreenShot();
		ClickBTN(LogInBTN);
		Thread.sleep(2000);
	}
	
	@FindBy(xpath="//a[text()='Cerrar sesión']")
	WebElement Cerrar_Sesion; 
	
	public void Cerrar_Sesion()
	{
		WaitElementtoBeClickable(Cerrar_Sesion);
		ClickBTNJS(Cerrar_Sesion);
		WaitElementtoBeVisible(UserName);
	}


	
	public void Log_In_Partner_Manager() throws InterruptedException
	{
		driver.navigate().to("https://butterfly--qa1.sandbox.my.site.com/partners/login");
		WaitElementtoBeVisible(UserName);
		SetTXTElement(UserName, "partnermanager1@tsse.com.vf.qa1");
		WaitElementtoBeVisible(Password);
		SetTXTElement(Password, "contra@2023");
		WaitElementtoBeClickable(LogInBTN);
		BFPageBase.TakeScreenShot();
		ClickBTN(LogInBTN);
		Thread.sleep(2000);
	}
}
