package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public abstract class CommonPage {
    public CommonPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    private Confidens confidens;
    private Confirmation confirmation;
    private HomePage homePage;
    private  PeopleidPage peopleidPage;

    public Confidens getConfidens() {
        if(confidens==null)
        {confidens=new Confidens();}
        return confidens;
    }

    public Confirmation getConfirmation() {
        if(confirmation==null)
        {confirmation=new Confirmation();}
        return confirmation;
    }

    public HomePage getHomePage() {
        if(homePage==null)
        {homePage=new HomePage();}
        return homePage;
    }

    public PeopleidPage getPeopleidPage() {
        if(peopleidPage==null)
        {peopleidPage=new PeopleidPage();}
        return peopleidPage;
    }
}
