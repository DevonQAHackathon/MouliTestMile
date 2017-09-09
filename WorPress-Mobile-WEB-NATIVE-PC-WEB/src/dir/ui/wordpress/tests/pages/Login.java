package dir.ui.wordpress.tests.pages;

import arjunasdk.uiauto.interfaces.UiDriver;
import dir.ui.wordpress.tests.enums.E_Login;
import unitee.steps.Steps;

public class Login extends Wordpress {

	public Login(UiDriver driver, String url) throws Exception{
		this(driver);
		goTo(url);
	}
	
	public Login(UiDriver driver) throws Exception{
		super(driver);
		populate("/wordpress/Login.ini");
	}
	
	public void enterEmail(String emailAdd) throws Exception {
		element(E_Login.TXT_FIELD_USER_NAME.toString()).enterText(emailAdd);
		Steps.pass("Entered UserName" + emailAdd);
	}

	public void enterPassword(String password) throws Exception {
		element(E_Login.TXT_FIELD_PASSWORD.toString()).enterText(password);
		Steps.pass("Entered Password" + password);
	}
	
	public void clickOnLogin() throws Exception {
		element(E_Login.SUBMIT_LOGIN.toString()).click();
		Steps.pass("Clicked on Login" );
	}

	public DashBoard login(String emailAdd, String password) throws Exception {
		enterEmail(emailAdd);
		enterPassword(password);
		clickOnLogin();
		return new DashBoard(this.getUiDriver());
	}
}
