package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class EditorPages {
    public EditorPages(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

@FindBy(xpath = "//*[text()='New']")
    public WebElement newButton;

    @FindBy(xpath = "//input[@id='DTE_Field_first_name']")
    public WebElement firstnameInbox;

    @FindBy(xpath = "//input[@id='DTE_Field_last_name']")
    public WebElement lastnameInbox;

    @FindBy(xpath = "//input[@id='DTE_Field_position']")
    public WebElement positionInbox;

    @FindBy(xpath = "//input[@id='DTE_Field_office']")
    public WebElement officeInbox;

    @FindBy(xpath = "//input[@id='DTE_Field_extn']")
    public WebElement extentionInbox;

    @FindBy(xpath = "//input[@id='DTE_Field_start_date']")
    public WebElement startdateInbox;

    @FindBy(xpath = "//input[@id='DTE_Field_salary']")
    public WebElement salaryInbox;

    @FindBy(xpath = "//button[@class='btn']")
    public WebElement createButton;

    @FindBy(xpath = "//input[@type='search']")
    public WebElement searchInbox;

    @FindBy(xpath = "//td[@class='sorting_1']")
    public WebElement isimGostermeAlani;



}
