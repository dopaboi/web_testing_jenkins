import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BuildPage;
import pages.HomePage;
import pages.JobPage;
import pages.LoginPage;
import utils.ConfigProperties;


import static org.testng.Assert.*;

@Listeners({TestAllureListener.class})
public class BuildTest extends BasicTest {


    private JobPage jobPage = PageFactory.initElements(getWebDriver(), JobPage.class);
    private BuildPage buildPage = PageFactory.initElements(getWebDriver(), BuildPage.class);
    private LoginPage loginPage = PageFactory.initElements(getWebDriver(), LoginPage.class);
    private HomePage homePage = PageFactory.initElements(getWebDriver(), HomePage.class);


    @BeforeMethod
    public void loginIs()
    {
        homePage.open();
        if(loginPage.isLoggedIn())
        {
            loginPage.open();
            loginPage.login(admin);
        }
        if(jobPage.JobIsCreate()) { }
        else
        {
            homePage.open();
            homePage.createJob();
        }
    }

    @Test
    public void CreateBuild()
    {
        jobPage.open(ConfigProperties.getProperties("job.url") + ConfigProperties.getProperties("job.name"));
        buildPage = jobPage.createBuild();
        assertTrue(buildPage.isBuildCreated());
        buildPage.open();
        buildPage.DeleteBuild();
    }

    @Test
    public void EditBuildTest() {
       jobPage.open(ConfigProperties.getProperties("job.url") + ConfigProperties.getProperties("job.name"));
        buildPage = jobPage.createBuild();
        buildPage.open();
        buildPage.UpdateBuild();
        assertTrue(buildPage.isUpdateBuild());
        buildPage.open();
        buildPage.DeleteBuild();
    }

    @Test
    public void DeleteBuild()
    {
       jobPage.open(ConfigProperties.getProperties("job.url") + ConfigProperties.getProperties("job.name"));
        buildPage = jobPage.createBuild();
        buildPage.open();
        buildPage.DeleteBuild();
        assertFalse(buildPage.isBuildDeleted());
    }

}
