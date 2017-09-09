package dir.ui.wordpress.tests.pages;

import java.util.Map;

import arjunasdk.config.RunConfig;
import arjunasdk.uiauto.interfaces.UiDriver;
import arjunasdk.uiauto.pageobject.BasePage;

public class Wordpress extends BasePage{
	protected String fromtemplate;
	protected String toTemplate;
	
	public Wordpress(UiDriver driver) throws Exception {
		super(driver);
	}

	@Override
	public void processElementProperties(String name, Map<String,String> properties){
		processMap(properties);
		processTemplate(properties);
		RunConfig.logger().debug(name+" , "+ properties);
	}
	
	
	public void processMap(Map<String,String> properties){
		String context = "PC_WEB";
		try {
			context = RunConfig.userOptions().value("context").asString();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		if(context.equals("ANDROIDNATIVE")){
			process(context.toUpperCase(), properties);
		}
		else if(context.equals("ANDROIDWEB")){
			process(context.toUpperCase(),properties);
		}
		else{
			
		}
		
	}
	
	public boolean isMobileNative() throws Exception{
		String context = RunConfig.userOptions().value("context").asString();
		return context.equals("ANDROIDNATIVE");
	}
	
	public void processTemplate(Map<String,String> properties){
		if(fromtemplate!=null && toTemplate!=null){
			for(String childkey: properties.keySet()){
				String value = properties.get(childkey);
				if(value.contains(fromtemplate))
					value = value.replace(fromtemplate, toTemplate);
					properties.put(childkey, value);
				}
			}
		}
		
	
	public void process(String context, Map<String,String> properties){
		boolean found = false;
		String foundKey = null;
		for(String key: properties.keySet()){
			if(key.startsWith(context)){
				found = true;
				foundKey = key;
				String value = properties.get(key);
				properties.remove(key);
				properties.put(key.split("_", 1)[1], value);
			}
			if(found){
				for(String childkey: properties.keySet()){
					if(!(childkey.equals(foundKey))){
						properties.remove(childkey);
					}
				}
			}
		}
	}

}
