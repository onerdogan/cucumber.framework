package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.EditorPages;
import utilities.ConfigReader;
import utilities.Driver;

public class EditorStepDefinitions {
EditorPages editorPages=new EditorPages();
Actions actions=new Actions(Driver.getDriver());

    @Given("kullanici {string} adresine gider")
    public void kullanici_adresine_gider(String string) {
        Driver.getDriver().get(ConfigReader.getProperty("editorUrl"));
    }
    @Then("new butonuna basar")
    public void new_butonuna_basar() {
    editorPages.newButton.click();
    }
    @Then("editor firstname kutusuna {string} bilgileri girer")
    public void editor_firstname_kutusuna_bilgileri_girer(String firstname) {
    editorPages.firstnameInbox.sendKeys(firstname);
    }
    @Then("editor lastname kutusuna {string} bilgileri girer")
    public void editor_lastname_kutusuna_bilgileri_girer(String lastname) {
    editorPages.lastnameInbox.sendKeys(lastname);
    }
    @Then("editor position kutusuna {string} bilgileri girer")
    public void editor_position_kutusuna_qa_bilgileri_girer(String position) {
    editorPages.positionInbox.sendKeys(position);
    }
    @Then("editor office kutusuna {string} bilgileri girer")
    public void editor_office_kutusuna_adana_bilgileri_girer(String office) {
    editorPages.officeInbox.sendKeys(office);
    }
    @Then("editor extension kutusuna {string} bilgileri girer")
    public void editor_extension_kutusuna_bilgileri_girer(String extention) {
    editorPages.extentionInbox.sendKeys(extention);
    }
    @Then("editor startDate kutusuna {string} bilgileri girer")
    public void editor_start_date_kutusuna_bilgileri_girer(String startDate) {
    editorPages.startdateInbox.sendKeys(startDate);
    }
    @Then("editor salary kutusuna {string} bilgileri girer")
    public void editor_salary_kutusuna_bilgileri_girer(String salary) {
    editorPages.salaryInbox.sendKeys(salary);
    }
    @Then("Create tusuna basar")
    public void create_tusuna_basar() {
    editorPages.createButton.click();
    }

    @And("editor ilgili kutulara {string} {string} {string} {string} {string} {string}{string} bilgileri girer")
    public void editorIlgiliKutularaBilgileriGirer(String firstname, String lastname, String position, String office, String extension, String startDate, String salary) {
        actions.
                sendKeys(firstname).
                sendKeys(Keys.TAB).
                sendKeys(lastname).
                sendKeys(Keys.TAB).
                sendKeys(position).
                sendKeys(Keys.TAB).
                sendKeys(office).
                sendKeys(Keys.TAB).
                sendKeys(extension).
                sendKeys(Keys.TAB).
                sendKeys(startDate).
                sendKeys(Keys.TAB).
                sendKeys(salary).
                click(editorPages.createButton).
                perform();


    }

    @Then("{string} ve {string} girerek kaydin tamamlandigini test eder")
    public void veGirerekKaydinTamamlandiginiTestEder(String firstname, String lastname) throws InterruptedException {
        Thread.sleep(3000);
        editorPages.searchInbox.click();
        editorPages.searchInbox.sendKeys(firstname+" "+lastname);
        Assert.assertTrue(editorPages.isimGostermeAlani.getText().contains(firstname));

    }
}
