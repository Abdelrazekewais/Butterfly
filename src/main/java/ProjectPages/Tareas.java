package ProjectPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Tareas extends BFPageBase {

	public Tareas(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//a[@href='/partners/s/task/Task/Default']")
	WebElement TasksPage;
	
	@FindBy(xpath = "//button[@title='Seleccionar una vista de lista: Tareas']")
	WebElement ListViewBTN;
	
	@FindBy(partialLinkText = "Todas las tareas completadas recién")
	WebElement TodasLasTareasBTN;
	
	
	

	
	
	  
	   
	  
	  
	  
	 
	  
	     
	 
	 
	
	
	

}
