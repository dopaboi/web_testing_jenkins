import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;


import pages.HomePage;
import pages.JobPage;
import pages.ViewJobPage;
import utils.ConfigProperties;


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

    @Test
    public void AddDeskTest() throws Exception
    {
        viewJobPage.open();
        viewJobPage.AddDesk();
        assertTrue(viewJobPage.isAddedDesk());
    }

    @Test
    public void DeleteView() throws Exception
    {
        viewJobPage.open();
        viewJobPage.DeleteView();
        assertFalse(viewJobPage.isViewNotDeleted());
    }

    @Test
    public void AddJobToView() throws Exception
    {
        viewJobPage.open();
        viewJobPage = homePage.createJobToView();
        assertEquals(jobPage.getJobName(), ConfigProperties.getProperties("job.finalname"));
    }
}
