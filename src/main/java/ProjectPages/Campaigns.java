package ProjectPages;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Campaigns extends BFPageBase {
	WebDriverWait wait;

	public Campaigns(WebDriver driver) {
		super(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	public static String DeletConfirmation;
	public static String CreateConfirmation;
	public static String Name = "Campaña Automation" + formattedDate;
	public static String descripcion = "Test";

	@FindBy(xpath = "//a[@title='Nuevo' and @role='button']")
	WebElement NuevoBTN;

	@FindBy(xpath = "/html/body/div[4]/div[1]/section/div[1]/div/div[2]/div[2]/section/div/div/section/div/div[2]/div/div/div/div[1]/div/div/div/div/div/div/fieldset/div/label[2]/span[2]")
	WebElement SellingCampaign;

	@FindBy(css = "button.slds-button.slds-button--neutral.slds-button.slds-button_brand.uiButton")
	WebElement Siguiente;

	@FindBy(css = "input.input")
	WebElement Nombre_De_Campana;

	@FindBy(css = "textarea.textarea")
	WebElement Descripcion_De_Campana;

	@FindBy(xpath = "/html/body/div[4]/div[1]/section/div[1]/div/div[2]/div[2]/section/div/div/section/div/div[2]/div/div/div/div[1]/div/article/div[3]/div/div[1]/div/div/div[3]/div[1]/div/div/div/div/a")
	WebElement FechaInicio;

	@FindBy(css = "span.slds-day.weekday.DESKTOP.uiDayInMonthCell--default")
	WebElement SelectDate;

	@FindBy(css = "a.select")
	WebElement SelectClassification;

	@FindBy(linkText = "Desarrollo")
	WebElement SelectClassificationValue;

	@FindBy(xpath = "/html/body/div[4]/div[1]/section/div[1]/div/div[2]/div[2]/section/div/div/section/div/div[2]/div/div/div/div[1]/div/article/div[3]/div/div[1]/div/div/div[3]/div[2]/div/div/div/div/a")
	WebElement FechaFin;
	@FindBy(css = "span.slds-day.weekday.DESKTOP.uiDayInMonthCell--default")
	WebElement SelectFechaFin;

	@FindBy(xpath = "/html/body/div[4]/div[1]/section/div[1]/div/div[2]/div[2]/section/div/div/section/div/div[2]/div/div/div/div[1]/div/article/div[3]/div/div[1]/div/div/div[4]/div[2]/div/div/div/div/div[1]/div/div/a")
	WebElement ReportLevel;
	@FindBy(linkText = "Lead")
	WebElement SelectReportLevel;

	@FindBy(css = "button.slds-button.slds-button--neutral.uiButton--brand.uiButton.forceActionButton")
	WebElement GuardarBTN;

	@FindBy(css = ("div.forceVirtualActionMarker.forceVirtualAction"))
	WebElement SelectorForDelete;

	@FindBy(linkText = ("Eliminar"))
	WebElement DeletBTN;

	@FindBy(css = ("button.slds-button.slds-button--neutral.uiButton--default.uiButton--brand.uiButton.forceActionButton"))
	WebElement ConfirmDeletBTN;

	@FindBy(xpath = ("/html/body/div[4]/div[1]/section/div[1]/div/div[2]/div[1]/div/div/div/div/div/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]"))
	WebElement scroller;

	@FindBy(xpath = "//*[@id=\"brandBand_2\"]/div/div/div[1]/div/div[1]/div[1]/header/div[2]/div/div[1]/div[2]/h1/div[2]/div/lightning-formatted-text")
	public static WebElement Nombre_De_CampanaVerify;

	@FindBy(xpath = "//a[@title='Borrador']")
	public static WebElement Estado;

	@FindBy(tagName = "table")
	private WebElement table;

	@FindBys({ @FindBy(xpath = ".//tr") })
	public List<WebElement> rows;

	public int numberOfRows1 = 0, numberOfRows2;

	public void CountCampaigns() throws InterruptedException {
		CampañasHomePage();
		while (!isLastElementVisible(driver, scroller)) {
			scrollDown(scroller, 2000);
		}
		numberOfRows1 = rows.size();

	}

	@FindBy(xpath = "//button[@type='button' and contains(@title,'Ver Jerarqu')]")
	public static WebElement VerJerarquia;

	@FindBy(xpath = "//a[@data-refid='recordId' and @rel='noreferrer']")
	public static WebElement VerifyCampName;
	public static String Verification;
	public void Create_New_campaign() throws InterruptedException, InvalidFormatException, IOException {
		CampañasHomePage();
		// numberOfRows1 = rows.size() - 1;
		BFPageBase.TakeScreenShot();
		NuevoBTN = wait.until(ExpectedConditions.elementToBeClickable(NuevoBTN));
		NuevoBTN.click();

		SellingCampaign = wait.until(ExpectedConditions.elementToBeClickable(SellingCampaign));
		ClickBTN(SellingCampaign);

		Siguiente = wait.until(ExpectedConditions.elementToBeClickable(Siguiente));
		BFPageBase.TakeScreenShot();
		ClickBTN(Siguiente);

		Thread.sleep(6000);
		BFPageBase.TakeScreenShot();
		Nombre_De_Campana = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input.input")));
		Nombre_De_Campana.clear();
		Nombre_De_Campana.sendKeys(Name);

		Descripcion_De_Campana = wait.until(ExpectedConditions.elementToBeClickable(Descripcion_De_Campana));

		SetTXTElement(Descripcion_De_Campana, descripcion);
		ClickBTN(FechaInicio);
		ClickBTN(SelectDate);

		SelectClassification = wait.until(ExpectedConditions.elementToBeClickable(SelectClassification));
		ClickBTN(SelectClassification);

		SelectClassificationValue = wait.until(ExpectedConditions.elementToBeClickable(SelectClassificationValue));
		ClickBTN(SelectClassificationValue);
		ClickBTN(FechaFin);

		ClickBTN(SelectFechaFin);

		ReportLevel = wait.until(ExpectedConditions.elementToBeClickable(ReportLevel));
		ClickBTN(ReportLevel);
		SelectReportLevel = wait.until(ExpectedConditions.elementToBeClickable(SelectReportLevel));
		ClickBTN(SelectReportLevel);
		BFPageBase.TakeScreenShot();
		GuardarBTN = wait.until(ExpectedConditions.elementToBeClickable(GuardarBTN));
		ClickBTN(GuardarBTN);
		Thread.sleep(3000);
		BFPageBase.TakeScreenShot();
		Thread.sleep(8000);
		BFPageBase.TakeScreenShot();
		//Thread.sleep(4000);
		//ClickBTN(VerJerarquia);
		Verification=driver.getTitle();
	}

	public String MakeSureCampCreated() throws InterruptedException {
		CampañasHomePage();
		while (!isLastElementVisible(driver, scroller)) {
			scrollDown(scroller, 2000);
		}
		numberOfRows2 = rows.size() - 1;
		System.out.println("First count of row is:" + numberOfRows1);
		if (numberOfRows2 > numberOfRows1) {
			CreateConfirmation = "Created";
			System.out.println(CreateConfirmation);
			System.out.println("Second count is: " + numberOfRows2);

		} else {
			CreateConfirmation = "Not Created";
			System.out.println(CreateConfirmation);
		}
		return CreateConfirmation;
	}

	String CampNameToBeDeleted = "Campaña Automation"; // + formattedDate;
	@FindBy(partialLinkText = ("CampNameToBeDeleted"))
	WebElement CampToBeDeleted;

	@FindBy(css  = ("a.slds-grid.slds-grid--vertical-align-center.slds-grid--align-center.sldsButtonHeightFix"))
	WebElement SelectActions;

	@FindBy(xpath = ("//a[@data-target-selection-name='sfdc:StandardButton.Campaign.Delete' and @title='Eliminar']"))
	WebElement EliminarBTN;

	@FindBy(xpath = ("//button[@type='button' and @title='Eliminar']"))
	WebElement EliminarConfirm;

	@FindBy(partialLinkText = ("Deshacer"))
	WebElement ConfirmationMessage;
	public static String ConfMessage;

	public String Delet_Campaign() throws InterruptedException {
		CampañasHomePage();
		BFPageBase.TakeScreenShot();
		CampToBeDeleted = wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(CampNameToBeDeleted)));
		ClickBTN(CampToBeDeleted);
		BFPageBase.TakeScreenShot();
		// SelectActions =wait.until(ExpectedConditions.elementToBeClickable(SelectActions));
		//Thread.sleep(6000);
		 //JavascriptExecutor jse = (JavascriptExecutor) driver;
		 //jse.executeScript("arguments[0].click();", SelectActions);
		// ClickBTN(SelectActions);
		Thread.sleep(7000);
		ClickBTNJS(SelectActions);
		BFPageBase.TakeScreenShot();
		ClickBTN(EliminarBTN);
		Thread.sleep(1000);
		BFPageBase.TakeScreenShot();
		ClickBTN(EliminarConfirm);
		Thread.sleep(1000);
		BFPageBase.TakeScreenShot();
		ConfirmationMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Deshacer")));
		BFPageBase.TakeScreenShot();
		ConfMessage = ConfirmationMessage.getText();
		return ConfMessage;
	}

	public String MakeSureCampDeleted() throws InterruptedException {
		CampañasHomePage();
		System.out.println("First Count before deleting is: " + numberOfRows1);
		while (!isLastElementVisible(driver, scroller)) {
			scrollDown(scroller, 2000);
		}
		numberOfRows2 = rows.size() - 1;
		System.out.println("Second count of rows after deleting is:" + numberOfRows2);
		if (numberOfRows2 < numberOfRows1) {
			DeletConfirmation = "Deleted";
			System.out.println(DeletConfirmation);

		} else {
			DeletConfirmation = "Not Deleted";
			System.out.println(DeletConfirmation);
		}
		return DeletConfirmation;
	}

}
