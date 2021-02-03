import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BuildPage;
import pages.JobPage;
import pages.LoginPage;
import utils.ConfigProperties;


import static org.testng.Assert.*;

@Listeners({TestAllureListener.class})
public class BuildTest extends BasicTest {


    private JobPage jobPage = PageFactory.initElements(getWebDriver(), JobPage.class);
    private BuildPage buildPage = PageFactory.initElements(getWebDriver(), BuildPage.class);
    private LoginPage loginPage = PageFactory.initElements(getWebDriver(), LoginPage.class);


    @Test
    public void CreateBuild() throws Exception
    {
        jobPage.open(ConfigProperties.getProperties("job.url") + ConfigProperties.getProperties("job.newname"));
        if(loginPage.isLoggedIn())
        {
            loginPage.open();
            loginPage.login(admin);
        }
        buildPage = jobPage.createBuild();
        assertTrue(buildPage.isBuildCreated());
    }

    @Test(dependsOnMethods = {"CreateBuild"})
    public void EditBuildTest() throws Exception {
        buildPage.open();
        if(loginPage.isLoggedIn())
        {
            loginPage.open();
            loginPage.login(admin);
            buildPage.open();
        }
        buildPage.UpdateBuild();
        assertTrue(buildPage.isUpdateBuild());
    }

    @Test
    public void DeleteBuild() throws Exception
    {
        buildPage.open();
        if(loginPage.isLoggedIn())
        {
            loginPage.open();
            loginPage.login(admin);
            buildPage.open();
        }
        buildPage.DeleteBuild();
        assertTrue(buildPage.isBuildNotDeleted());
    }

}
