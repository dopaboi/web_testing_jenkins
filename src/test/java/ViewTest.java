import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;


import pages.HomePage;
import pages.JobPage;
import pages.ViewJobPage;
import utils.ConfigProperties;


import java.io.ByteArrayInputStream;

import static org.testng.Assert.*;

public class ViewTest extends BasicTest {

    private HomePage homePage = PageFactory.initElements(getWebDriver(), HomePage.class);
    private ViewJobPage viewJobPage = PageFactory.initElements(getWebDriver(), ViewJobPage.class);
    private JobPage jobPage = PageFactory.initElements(getWebDriver(), JobPage.class);

    @Test
    public void CreateNewView() throws Exception
    {
        homePage.open();
        viewJobPage = homePage.createNewView();
    }

    @Test(dependsOnMethods = {"CreateNewView"})
    public void AddDeskTest() throws Exception
    {
        viewJobPage.open();
        viewJobPage.AddDesk();
        assertTrue(viewJobPage.isAddedDesk());
        Allure.addAttachment("Failed to create view", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }


    @Test(dependsOnMethods = {"AddDeskTest"})
    public void AddJobToView() throws Exception
    {
        viewJobPage.open();
        viewJobPage = homePage.createJobToView();
        assertEquals(jobPage.getJobName(), ConfigProperties.getProperties("job.finalname"));
        Allure.addAttachment("Failed to add job to view", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }
    @Test(dependsOnMethods = {"AddJobToView"})
    public void DeleteView() throws Exception
    {
        viewJobPage.open();
        viewJobPage.DeleteView();
        assertFalse(viewJobPage.isViewNotDeleted());
        Allure.addAttachment("Failed to delete view", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));

    }
}
