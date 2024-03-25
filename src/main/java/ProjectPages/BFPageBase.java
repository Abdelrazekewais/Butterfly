package ProjectPages;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BFPageBase {
	protected static JavascriptExecutor jsExecutor1;
	public static WebDriver driver;
	public static WebDriverWait wait, SpecialWait;
	// static int screenshotCounter = 1;
	public static Actions actions;
	static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	public static String formattedDate = dateFormat.format(new Date());

	public BFPageBase(WebDriver driver) {

		PageFactory.initElements(driver, this);
		BFPageBase.jsExecutor1 = (JavascriptExecutor) driver;
		BFPageBase.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(45));
		SpecialWait = new WebDriverWait(driver, Duration.ofSeconds(3));
		actions = new Actions(driver);
	}

	public String Verificar_Confirmation_Message() {
		WaitElementtoBeVisible(ConfirmationMessage2);
		String MessageContent = ConfirmationMessage2.getText();
		TakeScreenShot();
		ClickBTN(CloseMessage);
		wait.until(ExpectedConditions.invisibilityOf(CloseMessage));
		TakeScreenShot();
		return MessageContent;

	}

	public String Verificar_Error_Message() {
		 WaitElementtoBeVisible(ErrorMessage2);
		 String Message = ErrorMessage2.getText();
		 TakeScreenShot();
		 ClickBTN(CloseMessage);
		 wait.until(ExpectedConditions.invisibilityOf(CloseMessage));
		 TakeScreenShot();
		 return Message;
	}

	public static void WaitBotonesModificar(int num)
	{
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//button[contains(@title, 'Modificar')]"),
				num));
	}
	protected static void SetTXTElement(WebElement Element, String value) {
		Element.sendKeys(value);
	}

	protected static void ClickBTN(WebElement Element) {
		Element.click();
	}

	public static void WaitElementtoBeVisible(WebElement Element) {
		Element = wait.until(ExpectedConditions.visibilityOf(Element));
	}

	public static void WaitElementtoBeClickable(WebElement Element) {
		Element = wait.until(ExpectedConditions.elementToBeClickable(Element));
	}

	public static void ClickBTNJS(WebElement Element) {
		jsExecutor1.executeScript("arguments[0].click();", Element);
	}

	public boolean isLastElementVisible(WebDriver driver, WebElement scroller) {

		// Use Number instead of specific types for casting
		Number clientHeight = (Number) jsExecutor1.executeScript("return arguments[0].clientHeight;", scroller);
		Number scrollHeight = (Number) jsExecutor1.executeScript("return arguments[0].scrollHeight;", scroller);
		Number scrollTop = (Number) jsExecutor1.executeScript("return arguments[0].scrollTop;", scroller);

		// Convert to long before performing the comparison
		long clientHeightLong = clientHeight.longValue();
		long scrollHeightLong = scrollHeight.longValue();
		long scrollTopLong = scrollTop.longValue();

		return (clientHeightLong + scrollTopLong) >= scrollHeightLong;
	}

	public static void WaitForPageToBeLoaded() {
		wait.until((ExpectedCondition<Boolean>) webDriver -> ((JavascriptExecutor) webDriver)
				.executeScript("return document.readyState").equals("complete"));

	}

	public static void scrollDown(WebElement scroller, int scrollAmount) {
		String script = String.format("arguments[0].scrollTop += %d;", scrollAmount);
		jsExecutor1.executeScript(script, scroller);
	}

	public static void scrollDown(int amount) {
		jsExecutor1.executeScript("window.scrollBy(0, arguments[0]);", amount);
	}

	@FindBy(xpath = "//div[contains(@class, 'navigationMark navexAppNavMenu')]//div//button[contains(@title, 'Mostrar men')]")
	public static WebElement NavigationMenu;

	@FindBy(linkText = "Oportunidades")
	public static WebElement Oportunindades;

	@FindBy(linkText = "Cuentas")
	public static WebElement Cuentas;

	@FindBy(linkText = "Casos")
	public static WebElement Casos;
	@FindBy(linkText = "Campañas")
	public static WebElement Campañas;

	@FindBy(linkText = "Leads")
	public static WebElement Leads;

	@FindBy(linkText = "Solicitudes de aprobación pendientes")
	public static WebElement Solicitudes_De_Aprobaciones_Pendientes;
	
	@FindBy(xpath = "")
	WebElement SelectedItem;
	public static void Solicitudes_De_Aprobaciones_HomePage() throws InterruptedException {

		NavigationMenu = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class, 'navigationMark navexAppNavMenu')]//div//button[contains(@title, 'Mostrar men')]")));
		ClickBTN(NavigationMenu);
		Solicitudes_De_Aprobaciones_Pendientes = wait
				.until(ExpectedConditions.elementToBeClickable(Solicitudes_De_Aprobaciones_Pendientes));
		ClickBTN(Solicitudes_De_Aprobaciones_Pendientes);
		WaitForPageToBeLoaded();

	}

	public static void OPPHomePage() throws InterruptedException {

		NavigationMenu = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class, 'navigationMark navexAppNavMenu')]//div//button[contains(@title, 'Mostrar men')]")));
		ClickBTN(NavigationMenu);
		Oportunindades = wait.until(ExpectedConditions.elementToBeClickable(Oportunindades));
		ClickBTNJS(Oportunindades);
		wait.until(ExpectedConditions.textToBe(By.xpath("//div[contains(@class, 'slds-context-bar__item slds-context-bar__object-switcher')]//a//span[@class='slds-truncate']"), "Oportunidades"));

	}

	
	public static void CuentasHomePage() throws InterruptedException {

		try{NavigationMenu = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class, 'navigationMark navexAppNavMenu')]//div//button[contains(@title, 'Mostrar men')]")));
		ClickBTN(NavigationMenu);
		Cuentas = wait.until(ExpectedConditions.elementToBeClickable(Cuentas));
		ClickBTNJS(Cuentas);
		SpecialWait.until(ExpectedConditions.textToBe(
				By.xpath("//div[@class='selectedListItem slds-col--bump-left slds-p-left--x-small slds-context-bar__item "
						+ "slds-context-bar__object-switcher ']//a//span[@class='slds-truncate']"), "Cuentas"));
		}
		catch (Exception e) {
			ClickBTN(NavigationMenu);
			Cuentas = wait.until(ExpectedConditions.elementToBeClickable(Cuentas));
			ClickBTNJS(Cuentas);
		}
		
	}

	public static void CasosHomePage() throws InterruptedException {

		NavigationMenu = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class, 'navigationMark navexAppNavMenu')]//div//button[contains(@title, 'Mostrar men')]")));
		ClickBTN(NavigationMenu);
		Casos = wait.until(ExpectedConditions.elementToBeClickable(Casos));
		ClickBTN(Casos);
	}

	public static void CampañasHomePage() throws InterruptedException {

		NavigationMenu = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class, 'navigationMark navexAppNavMenu')]//div//button[contains(@title, 'Mostrar men')]")));
		ClickBTN(NavigationMenu);

		Campañas = wait.until(ExpectedConditions.elementToBeClickable(Campañas));
		ClickBTN(Campañas);
	}

	public static void LeadsHomePage() throws InterruptedException {

		NavigationMenu = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class, 'navigationMark navexAppNavMenu')]//div//button[contains(@title, 'Mostrar men')]")));
		ClickBTN(NavigationMenu);

		Leads = wait.until(ExpectedConditions.elementToBeClickable(Leads));
		ClickBTNJS(Leads);
	}

	@FindBy(xpath = "//a[contains(@href, 'Opportunity/') or contains(@href, 'Campaign/') or contains(@href, '/Account/') or contains(@href, '/lightning/r/Opportunity/') or contains(@href, 'Lead/')]")
	public static List<WebElement> OpenedTabs;

	@FindBy(xpath = "//button[@class='slds-button slds-button_icon slds-button_icon-x-small slds-button_icon-container' and contains(@title, 'Cerrar')]")
	static WebElement Boton_Cerrar_Ventana;

	public static void CloseAllOpenedTabs() throws InterruptedException

	{

		WaitForPageToBeLoaded();
		System.out.println("Number of tabs is: " + OpenedTabs.size());
		// if (OpenedTabs.size() > 0) {
		for (WebElement Tab : OpenedTabs) {
			WaitElementtoBeClickable(Tab);
			WaitElementtoBeClickable(Boton_Cerrar_Ventana);
			actions.moveToElement(Boton_Cerrar_Ventana).click().build().perform();
			WaitForPageToBeLoaded();
			// ClickBTNJS(Boton_Cerrar_Ventana);
			// Tab.click();
			// Thread.sleep(4000);
			// WebElement closeBTN = driver.findElement(By.xpath(
			// "/html/body/div[4]/div[1]/section/div[1]/div/div[1]/div[2]/div/div/ul[2]/li[2]/div[2]/button"));
			// closeBTN.click();
		}
	}
	// }

	public static void CreateEvidence(String TestCaseName) throws InvalidFormatException {
		InsertScreensToWord(TestCaseName);
		DeleteJpgFiles();
		System.out.println("Created Evidence");
	}

	// Create a Function to take screenshots
	/*
	 * public static void TakeScreenShot() { try { // Combine the path, base name,
	 * counter, and file extension String fullFileName = "Screen-" +
	 * screenshotCounter + ".jpg";
	 * 
	 * Rectangle screenRect = new
	 * Rectangle(Toolkit.getDefaultToolkit().getScreenSize()); Robot robot = new
	 * Robot(); BufferedImage screenFullImage =
	 * robot.createScreenCapture(screenRect); ImageIO.write(screenFullImage, "jpg",
	 * new File(fullFileName)); //System.out.println("Screenshot saved to " +
	 * fullFileName);
	 * 
	 * // Increment the counter for the next screenshot screenshotCounter++; } catch
	 * (AWTException | IOException ex) { System.err.println(ex); } }
	 */

	private static int screenshotCounter = 1;
	private static List<String> screenshotFileNames = new ArrayList<>();

	public static void TakeScreenShot() {
		try {
			String fullFileName = "Screen-" + screenshotCounter + ".jpg";
			screenshotFileNames.add(fullFileName); // Store the file name in the list

			Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
			Robot robot = new Robot();
			BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
			ImageIO.write(screenFullImage, "jpg", new File(fullFileName));

			screenshotCounter++;
		} catch (AWTException | IOException ex) {
			System.err.println(ex);
		}
	}
	/*
	 * Create a function to take the Screenshots and put them into /a word file
	 * created and named after the Test case name
	 */

	/*
	 * public static void InsertScreensToWord(String Name) throws
	 * InvalidFormatException { String folderPath =
	 * "C:\\My Files\\Test Automation\\BFAutomation"; String extension = "jpg";
	 * 
	 * File[] imageFiles = getFilesWithExtension(folderPath, extension);
	 * 
	 * // Step 1: Creating a blank document XWPFDocument document = new
	 * XWPFDocument();
	 * 
	 * // Step 2: Creating a Paragraph XWPFParagraph paragraph =
	 * document.createParagraph(); XWPFRun run = paragraph.createRun();
	 * 
	 * // Step 3: Creating a File output stream for the Word document try
	 * (FileOutputStream fout = new FileOutputStream(
	 * "C:\\My Files\\Test Automation\\BFAutomation\\" + Name + ".docx")) {
	 * 
	 * for (File image : imageFiles) { // Creating a FileInputStream for each image
	 * try (FileInputStream imageData = new FileInputStream(image)) {
	 * 
	 * // Adding the picture to the document run.addPicture(imageData,
	 * XWPFDocument.PICTURE_TYPE_JPEG, image.getName(), Units.toEMU(500),
	 * Units.toEMU(500));
	 * 
	 * // Move to the next line run.addBreak(); } }
	 * 
	 * // Write the document to the output stream document.write(fout);
	 * 
	 * } catch (IOException e) { e.printStackTrace(); } finally { // Close the
	 * connections try { document.close(); } catch (IOException e) {
	 * e.printStackTrace(); } } }
	 * 
	 * private static File[] getFilesWithExtension(String folderPath, String
	 * extension) { File folder = new File(folderPath); return
	 * folder.listFiles((dir, name) -> name.toLowerCase().endsWith("." +
	 * extension)); }
	 */

	// private static List<String> screenshotFileNames;

	public static void InsertScreensToWord(String name) throws InvalidFormatException {
		String folderPath = "C:\\My Files\\Test Automation\\BFAutomation";
		String extension = "jpg";

		@SuppressWarnings("unused")
		File[] imageFiles = getFilesWithExtension(folderPath, extension);

		XWPFDocument document = new XWPFDocument();
		XWPFParagraph paragraph = document.createParagraph();
		XWPFRun run = paragraph.createRun();

		try (FileOutputStream fout = new FileOutputStream(
				"C:\\My Files\\Test Automation\\BFAutomation\\" + name + ".docx")) {

			for (String fileName : screenshotFileNames) {
				File image = new File(fileName);

				try (FileInputStream imageData = new FileInputStream(image)) {
					run.addPicture(imageData, XWPFDocument.PICTURE_TYPE_JPEG, image.getName(), Units.toEMU(500),
							Units.toEMU(500));
					run.addBreak();
				}
			}

			document.write(fout);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				document.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static File[] getFilesWithExtension(String folderPath, String extension) {
		File folder = new File(folderPath);
		return folder.listFiles((dir, name) -> name.toLowerCase().endsWith("." + extension.toLowerCase()));
	}

	public static void DeleteJpgFiles() {
		File folder = new File("C:\\My Files\\Test Automation\\BFAutomation");

		// Check if the specified path is a directory
		if (folder.isDirectory()) {
			File[] files = folder.listFiles();

			// Iterate through all files in the directory
			if (files != null) {
				for (File file : files) {
					// Check if the file has a ".jpg" extension
					if (file.isFile() && file.getName().toLowerCase().endsWith(".jpg")) {
						// Attempt to delete the file
						if (file.delete()) {
							// System.out.println("Deleted file: " + file.getAbsolutePath());
						} else {
							System.err.println("Failed to delete file: " + file.getAbsolutePath());
						}
					}
				}
			} else {
				System.err.println("Failed to list files in the directory: " + folder.getAbsolutePath());
			}
		} else {
			System.err.println("Specified path is not a directory: " + folder.getAbsolutePath());
		}
	}

	public void Press_Enter(WebElement Element) {
		Element.sendKeys(Keys.ENTER);
	}

	public void Press_Arrow_Dwon(WebElement Element) {
		Element.sendKeys(Keys.ARROW_DOWN);
	}

	public void Press_Arrow_Up(WebElement Element) {
		Element.sendKeys(Keys.ARROW_UP);
	}

	@FindBy(css = "div.toastTitle.slds-text-heading--small")
	public static WebElement ErrorMessage;

	@FindBy(css = "span.toastMessage.forceActionsText")
	public static WebElement ErrorMessage2;

	@FindBy(xpath = "//button[contains(@class, 'slds-button slds-button_icon toastClose slds-notify__close')]")
	public static WebElement CloseMessage;

	@FindBy(xpath = "//div[@role='alertdialog']")
	public static WebElement ConfirmationMessage;

	@FindBy(xpath = "//div[@role='alertdialog']//div[contains(@class, 'notify__content')]")
	public static WebElement ConfirmationMessage2;

}
