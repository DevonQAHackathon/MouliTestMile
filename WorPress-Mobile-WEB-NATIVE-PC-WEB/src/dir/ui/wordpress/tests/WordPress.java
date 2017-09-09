package dir.ui.wordpress.tests;

import arjunasdk.config.RunConfig;
import arjunasdk.ddauto.interfaces.DataRecord;
import arjunasdk.uiauto.factories.UiDriverFactory;
import arjunasdk.uiauto.interfaces.UiDriver;
import dir.ui.wordpress.tests.pages.DashBoard;
import dir.ui.wordpress.tests.pages.Login;
import dir.ui.wordpress.tests.pages.PostEditor;
import unitee.annotations.BeforeTest;
import unitee.annotations.DriveWithData;
import unitee.annotations.DriveWithDataFile;
import unitee.annotations.TestClass;
import unitee.annotations.TestMethod;
import unitee.interfaces.TestVariables;

@TestClass
public class WordPress {
	private UiDriver driver;
	private String url = "https://wordpress.com/log-in";
	private DashBoard dashBoard;
	private PostEditor postEditor;
	private String userName;
	private String password;
	private String title;
	private String content;
	private String appPath;

	@BeforeTest
	public void login(TestVariables tvar) throws Exception {
		DataRecord record = tvar.record();
		appPath = RunConfig.value("directory.project.root").asString().replace("mproject", "WordPress_org.wordpress.android.apk");
		userName = record.string("USERNAME");
		password = record.string("PASSWORD");
		title = record.string("BLOG_TITLE");
		content = record.string("BLOG_CONTENT");
		driver = UiDriverFactory.getMobileNativeUiDriver(appPath);
		Login login = new Login(driver, url);
		dashBoard = login.login(userName, password);
	}

	@DriveWithDataFile("posts.ini")
	public void publishPost(TestVariables tvar) throws Exception {
		postEditor = dashBoard.clickOnCreatePost();
		postEditor.enterTitle(title);
		postEditor.selectHTMLLink();
		postEditor.enterPost(content);
		postEditor.clickonPublish();
		postEditor.clickonConfirmPublish();
	}

}
