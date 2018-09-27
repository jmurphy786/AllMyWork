import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MainPage {

	@FindBy (xpath = "//*[@id=\"li_myaccount\"]/a")
	private WebElement myAccount;
	
	@FindBy (xpath = "//*[@id=\"li_myaccount\"]/ul/li[2]/a")
	private WebElement mySignUp;
	
	public void searchDetails(WebDriver driver){
		Actions action = new Actions(driver);
		action.moveToElement(myAccount).click().moveToElement(mySignUp).click().perform();
		
	}
	
}
