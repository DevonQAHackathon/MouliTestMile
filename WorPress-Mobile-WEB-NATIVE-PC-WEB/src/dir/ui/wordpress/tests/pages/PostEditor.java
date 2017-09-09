package dir.ui.wordpress.tests.pages;

import arjunasdk.uiauto.interfaces.UiDriver;
import dir.ui.wordpress.tests.enums.E_PostEditor;
import unitee.steps.Steps;

public class PostEditor extends Wordpress{
	
	public PostEditor(UiDriver driver) throws Exception{
		super(driver);
		populate("/wordpress/PostEditor.ini");
	}
	
	public void enterTitle(String title) throws Exception{
		element(E_PostEditor.TXT_AREA_TITLE.toString()).enterText(title);
		Steps.pass("Entered Post Title "+ title);
	}
	
	public void enterPost(String msg) throws Exception{
		element(E_PostEditor.TXT_AREA_TITLE.toString()).enterText(msg);
		Steps.pass("Entered Post Content"+ msg);
	}
	
	public void clickonPublish() throws Exception{
		element(E_PostEditor.BTN_PUBLISH.toString()).click();
		Steps.pass("Clicked on publish button");
	}
	
	public void clickonConfirmPublish() throws Exception{
		if(!isMobileNative())
		element(E_PostEditor.BTN_CONFIRM_PUBLISH.toString()).click();
		Steps.pass("Clicked on Confirm button of publish");
	}
	
	public void selectHTMLLink() throws Exception{
		if(!isMobileNative())
		element(E_PostEditor.LNK_CHOOSE_HTML.toString()).click();
		Steps.pass("Selected Html Link");
	}
	
	public void post(String title, String msg) throws Exception{
		enterTitle(title);
		enterPost(msg);
		selectHTMLLink();
		clickonPublish();
		clickonConfirmPublish();
	}

}
