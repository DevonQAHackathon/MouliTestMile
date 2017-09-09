package dir.ui.wordpress.tests.pages;

import arjunasdk.uiauto.interfaces.UiDriver;
import dir.ui.wordpress.tests.enums.E_DashBoard;

public class DashBoard extends Wordpress{
	
	public DashBoard(UiDriver driver) throws Exception{
		super(driver);
		populate("/wordpress/DashBoard.ini");
	}
	
	public PostEditor clickOnCreatePost() throws Exception{
		element(E_DashBoard.LNK_CREATE_POST.toString()).click();
		return new PostEditor(this.getUiDriver());
	}
	
}
