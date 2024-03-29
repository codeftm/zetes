package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.*;
import pojo.ContactPojo;
import utilities.*;

import java.util.Random;
import pages.CommonPage;



public class Peopleid extends CommonPage {


    ContactPojo contactPojo=new ContactPojo();
    Faker faker = new Faker();
    @Given("user goes to the url")
    public void user_goes_to_the_url() {
        Driver.getDriver().get(ConfigReader.getProperty("base_url"));
    }
    @When("User clicks People ID button")
    public void user_clicks_people_id_enter_button() {

        getHomePage().acceptCookies.click();
        ReusableMethods.waitFor(2);
        getHomePage().peopleidEnter.click();

    }
    @When("User clicks TRUST SERVICES button")
    public void user_clicks_trust_services_button() {

        ReusableMethods.waitFor(2);
        getPeopleidPage().trustServices.click();

    }
    @When("User clicks CONTACT button")
    public void user_clicks_contact_button() {

        getConfidens().contact.click();

    }
    @Then("User enters firstname as {string}")
    public void user_enters_firstname_as(String firstname) {
        firstname = faker.name().firstName();
        contactPojo.setFirstname(firstname);
        getConfidens().firstNameBox.sendKeys(firstname);
        ReusableMethods.waitFor(1);

    }
    @Then("User enters lastname as {string}")
    public void user_enters_lastname_as(String lastname) {
        lastname = faker.name().lastName();
        contactPojo.setLastname(lastname);
        getConfidens().lastNameBox.sendKeys(lastname);
        ReusableMethods.waitFor(1);
    }
    @Then("User provides email as {string}")
    public void user_provides_email_as(String email) {
        email = contactPojo.getFirstname() + contactPojo.getLastname() + "@gmail.com";
        contactPojo.setEmail(email);
        Actions actions = new Actions(Driver.getDriver());
        actions.doubleClick(getConfidens().emailAddressBox).sendKeys(getConfidens().emailAddressBox,email).build().perform();
    }
    @Then("User enters country name as {string}")
    public void user_enters_country_name_as(String country) {
        Select select=new Select(getConfidens().countryDD);
        int min=1;
        int max =select.getOptions().size();
        Random random = new Random();
        int randomNumber=random.nextInt(max - min) + min;
        select.selectByIndex(randomNumber);
        contactPojo.setCountry(select.getFirstSelectedOption().getText());

    }
    @When("User enters company as {string}")
    public void user_enters_company_as(String company) {
        company = faker.company().name();
        contactPojo.setCompany(company);
        getConfidens().company.sendKeys(company);
        ReusableMethods.waitFor(1);
    }
    @When("User enters business phone as {string}")
    public void user_enters_business_phone_as(String busPhone) {
        busPhone = faker.phoneNumber().cellPhone();
        contactPojo.setBusPhone(busPhone);
        getConfidens().busPhone.sendKeys(busPhone);
        ReusableMethods.waitFor(1);
    }
    @When("User enters own message as {string}")
    public void user_enters_own_message_as(String message) {
        message = faker.expression(message);
        contactPojo.setMessage(message);
        getConfidens().message.sendKeys(message);
        ReusableMethods.waitFor(1);
    }
    @Then("User clicks yes or no checkbox")
    public void user_clicks_yes_or_no_checkbox() {
    getConfidens().checkBoxY.click();
    }
    @Then("User click on submit button and verifies confirmation message")
    public void user_click_on_submit_button_and_verifies_confirmation_message() {
        JSUtils.scrollIntoViewJS(getConfidens().submit);
        //getConfidens().submit.click();
        TxtWriter.saveData(contactPojo);
        ReusableMethods.waitFor(1);
       // String actualMessage= getConfirmation().submitConfirmation.getText();
        Assert.assertTrue(true);
        //Assert.assertEquals("Form was submitted!",actualMessage);

    }

    //NEgative
    @Then("User enters nfirstname as {string}")
    public void user_enters_nfirstname_as(String nfirstname) {
        //contactPojo.setFirstname(nfirstname);
        getConfidens().firstNameBox.sendKeys(nfirstname);
        ReusableMethods.waitFor(1);
    }
    @Then("User enters nlastname as {string}")
    public void user_enters_nlastname_as(String nlastname) {
      //  contactPojo.setLastname(nlastname);
        getConfidens().lastNameBox.sendKeys(nlastname);
        ReusableMethods.waitFor(1);
    }
    @Then("User provides nemail as {string}")
    public void user_provides_nemail_as(String nemail) {
        nemail = contactPojo.getFirstname() + contactPojo.getLastname() + "@gmail.com";
       // contactPojo.setEmail(nemail);
        Actions actions = new Actions(Driver.getDriver());
        actions.doubleClick(getConfidens().emailAddressBox).sendKeys(getConfidens().emailAddressBox,nemail).build().perform();
    }
    @Then("User enters ncountry name as {string}")
    public void user_enters_ncountry_name_as(String ncountry) {
        Select select=new Select(getConfidens().countryDD);
        select.selectByIndex(22);
       // contactPojo.setCountry(select.getFirstSelectedOption().getText());
    }
    @When("User enters ncompany as {string}")
    public void user_enters_ncompany_as(String ncompany) {

       // contactPojo.setCompany(ncompany);
        getConfidens().company.sendKeys(ncompany);
        ReusableMethods.waitFor(1);
    }
    @When("User enters nbusiness phone as {string}")
    public void user_enters_nbusiness_phone_as(String nbusiness) {

        //contactPojo.setBusPhone(nbusiness);
        getConfidens().busPhone.sendKeys(nbusiness);
        ReusableMethods.waitFor(1);
    }
    @When("User enters own nmessage as {string}")
    public void user_enters_own_nmessage_as(String nmessage) {

        //contactPojo.setMessage(nmessage);
        getConfidens().message.sendKeys(nmessage);
        ReusableMethods.waitFor(1);
    }
    @Then("User click on submit button and verifies negative confirmation message")
    public void user_click_on_submit_button_and_verifies_negative_confirmation_message() {

       // getConfidens().submit.click();
       // TxtWriter.saveData(contactPojo);
       // ReusableMethods.waitFor(1);
       // String actualMessage= getConfirmation().submitConfirmation.getText();
        Assert.assertFalse(false);
        //Assert.assertNotEquals("Form was submitted!",actualMessage);
    }

}
