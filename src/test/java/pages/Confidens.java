package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Confidens {

    public Confidens(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//a[.='Contact'])[1]")
    public WebElement contact;
    @FindBy(name = "firstName")
    public WebElement firstNameBox;

    @FindBy(name = "lastName")
    public WebElement lastNameBox;
    @FindBy(name = "emailAddress")
    public WebElement emailAddressBox;

    @FindBy(xpath = "//select[@name='country']")
    public WebElement countryDD;

    @FindBy(xpath = "//input[@name='company']")
    public WebElement company;

    @FindBy(name="busPhone")
    public WebElement busPhone;

    @FindBy(xpath = "//textarea[@name='paragraphText']")
    public WebElement message;
    @FindBy(xpath = "(//input[@name='checkboxes'])[1]")
    public WebElement checkBoxY;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement submit;


}
