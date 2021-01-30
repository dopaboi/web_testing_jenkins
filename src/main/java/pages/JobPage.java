package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ConfigProperties;

public class JobPage extends Page {

    @FindBy(linkText="Создать Item")
    private WebElement create;

    @FindBy(css ="h1.job-index-headline.page-headline")
    private WebElement jobName;

    @FindBy(css = "#description > div")
    private WebElement jobDescription;

    @FindBy(linkText = "job for testing")
    private WebElement linkJob;

    @FindBy(linkText = "Удалить Проект")
    private WebElement linkDelete;

    public JobPage(WebDriver driver) {
        super(driver);
    }


    public String getJobName() {
        return jobName.getText();
    }

    public String getJobDescription() {
        return jobDescription.getText();
    }

    public boolean isJobNotDeleted() {
        return isElementPresent(jobName);

    }

    public void deleteJob()
    {
        linkDelete.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    @Override
    public void open() {
        driver.get(ConfigProperties.getProperties("job.url") + ConfigProperties.getProperties("job.name"));
    }
}