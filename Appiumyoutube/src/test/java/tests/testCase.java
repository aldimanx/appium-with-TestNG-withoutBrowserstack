package tests;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.appium.java_client.android.AndroidElement;
import pages.Homepage;
import pages.ToDoForm;

public class testCase extends appiumtesst {

	Faker faker = new Faker();
	String desc = faker.lorem().paragraph();
	@Test(priority=1)
	public void createNewToDo()throws IOException, InterruptedException{
		Homepage objHome = new Homepage(driver);
		ToDoForm objTdf = new ToDoForm(driver);

		objHome.clickBtnAddtask();
		objTdf.TypefrmTitle().sendKeys("aldy list 1");
		objTdf.TypefrmDesc().sendKeys(desc);
		objTdf.clickBtnSubmit();
		

		objHome.clickBtnAddtask();
		objTdf.TypefrmTitle().sendKeys("aldy list 2");
		objTdf.TypefrmDesc().sendKeys(desc);
		objTdf.clickBtnSubmit();
}

	@Test(priority=2)
	public void editToDo()throws IOException, InterruptedException{
		Homepage objHome = new Homepage(driver);
		ToDoForm objTdf = new ToDoForm(driver);
		objHome.lisktaskbaru();
	String taskName = objHome.TitleTaskView().getText();
	String taskDetail = objHome.DetailTaskView().getText();		
		Assert.assertEquals(taskName, "aldy list 1");
		Assert.assertEquals(taskDetail, desc);
		
		objTdf.clickBtnEdit();
		objTdf.TypefrmTitle().clear();
		objTdf.TypefrmTitle().sendKeys("aldy list edited");
		objTdf.TypefrmDesc().clear();
		objTdf.TypefrmDesc().sendKeys("details edited");
		objTdf.clickBtnSubmit();
		objHome.clickBtnMore();
		objHome.clickBtnRefresh();
		driver.findElementByXPath("//android.widget.TextView[@text='aldy list edited']").click();
		String taskName1 = objHome.TitleTaskView().getText();
		String taskDetail1 = objHome.DetailTaskView().getText();		
		Assert.assertEquals(taskName1, "aldy list edited");
		Assert.assertEquals(taskDetail1, "details edited");
}
	@Test(priority=3)
	public void deleteToDo()throws IOException, InterruptedException{
		
		ToDoForm objTdf = new ToDoForm(driver);	
		
		driver.findElementByXPath("//android.widget.TextView[@text='aldy list edited']").click();
		objTdf.clickBtnDelete();
		driver.findElementByXPath("//android.widget.TextView[@text='aldy list 2']").click();
		objTdf.clickBtnDelete();

}
	@Test(priority=4)
	public void ChecklistToDo()throws IOException, InterruptedException {
		Homepage objHome = new Homepage(driver);
		ToDoForm objTdf = new ToDoForm(driver);	
		objHome.clickBtnAddtask();
		objTdf.TypefrmTitle().sendKeys("aldy list new");
		objTdf.TypefrmDesc().sendKeys(desc);
		objTdf.clickBtnSubmit();
		
	//	AndroidElement cb = driver.findElementByClassName("android.widget.CheckBox");
		
		objHome.clickChklist();
		objHome.clickBtnMore();
		objHome.clickBtnRefresh();
		//Assert.assertEquals(cb.isSelected(), true );
		//Assert.assertEquals(true, cb.is());
	
	}
}
