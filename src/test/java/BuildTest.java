import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.BuildPage;
import pages.HomePage;
import pages.JobPage;
import pages.LoginPage;
import utils.ConfigProperties;

import static org.testng.Assert.*;

public class BuildTest extends BasicTest {

    private JobPage jobPage = PageFactory.initElements(getWebDriver(), JobPage.class);
    private BuildPage buildPage = PageFactory.initElements(getWebDriver(), BuildPage.class);

    @Test
    public void CreateBuild() throws Exception
    {
        jobPage.open(ConfigProperties.getProperties("job.url") + ConfigProperties.getProperties("job.newname"));
        buildPage = jobPage.createBuild();
        assertTrue(buildPage.isBuildCreated());
    }

    @Test(dependsOnMethods = {"CreateBuild"})
    public void EditBuildTest() throws Exception {
        buildPage.open();
        buildPage.UpdateBuild();
        assertTrue(buildPage.isUpdateBuild());
    }

    @Test(dependsOnMethods = {"EditBuildTest"})
    public void DeleteBuild() throws Exception
    {
        buildPage.open();
        buildPage.DeleteBuild();
    }

}
