package pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.github.javafaker.Faker;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class Homepage {
	Faker faker = new Faker();
	public String namesss = faker.name().nameWithMiddle();

	@AndroidFindBy(accessibility = "Navigate up")
	AndroidElement btnNavigate;
	
	@AndroidFindBy(accessibility = "Filter")
	AndroidElement btnFilter;
	
	@AndroidFindBy(accessibility = "More options")
	AndroidElement btnMore;
	
	@AndroidFindBy (id = "com.example.android.architecture.blueprints.todomvp.mock:id/fab_add_task")
	AndroidElement btnAddTask;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@text='aldy list 1']")
	AndroidElement listTask;
	
	@AndroidFindBy (id = "com.example.android.architecture.blueprints.todomvp.mock:id/task_detail_title")
	AndroidElement TitleTask;
	
	@AndroidFindBy (id = "com.example.android.architecture.blueprints.todomvp.mock:id/task_detail_description")
	AndroidElement DetailTask;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@text='Refresh']")
	AndroidElement btnRefresh;
	
	@AndroidFindBy (id  = "com.example.android.architecture.blueprints.todomvp.mock:id/complete")
	AndroidElement boxChklist;
	
	public Homepage (AndroidDriver<AndroidElement> driver) {
PageFactory.initElements(new AppiumFieldDecorator(driver),this);
}

public AndroidElement clickBtnNavigate() {
	   btnNavigate.click();
	   Assert.assertTrue(true);
	   return btnNavigate;
}

public AndroidElement clickBtnFilter() {
	btnFilter.click();
	return btnFilter;
}
public AndroidElement clickBtnMore() {
	btnMore.click();
	return btnMore;
}
public AndroidElement clickBtnAddtask() {
	btnAddTask.click();
	return btnAddTask;
}
public AndroidElement lisktaskbaru() {
	listTask.click();
	return listTask;
}
public AndroidElement TitleTaskView() {
	return TitleTask;
}
public AndroidElement DetailTaskView() {
	return DetailTask;
}
public AndroidElement clickBtnRefresh() {
	btnRefresh.click();
	return btnRefresh;
}
public AndroidElement clickChklist() {
	boxChklist.click();
	return boxChklist;
}
}