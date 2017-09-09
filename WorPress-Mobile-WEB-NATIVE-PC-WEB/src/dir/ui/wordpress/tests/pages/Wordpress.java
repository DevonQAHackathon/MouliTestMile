package dir.ui.wordpress.tests.pages;

import java.util.Map;

import arjunasdk.config.RunConfig;
import arjunasdk.uiauto.interfaces.UiDriver;
import arjunasdk.uiauto.pageobject.BasePage;

public class Wordpress extends BasePage{
	protected String template;
	
	public Wordpress(UiDriver driver) throws Exception {
		super(driver);
	}

	@Override
	public void processElementProperties(String name, Map<String,String> properties){
		try {
			RunConfig.userOptions().value("context").asString().equalsIgnoreCase(name.split(",")[0]);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		RunConfig.logger().debug(name+" , "+ properties);
	}

}
