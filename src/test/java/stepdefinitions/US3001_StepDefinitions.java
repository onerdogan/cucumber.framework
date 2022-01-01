package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.US3001_Page;

public class US3001_StepDefinitions {

    US3001_Page us3001_page=new US3001_Page();


    @Then("gmibank giris butonuna tiklar")
    public void gmibank_giris_butonuna_tiklar() {
       us3001_page.ilkGirisButonu.click();
    }
    @Then("gmibank register butonuna tiklar")
    public void gmibank_register_butonuna_tiklar() {
        us3001_page.registerButonu.click();
    }
    @Then("gmibank password kutusuna tiklar")
    public void gmibank_password_kutusuna_tiklar() {
      us3001_page.passwordKutusu.click();
    }

    @Given("{string} girer")
    public void girer(String password) throws InterruptedException {
        us3001_page.passwordKutusu.sendKeys(password);
        Thread.sleep(2000);
    }
       @Then("gmibank Password strenght red gorunur")
    public void gmibankPasswordStrenghtRedGorunur() {
           Assert.assertTrue(us3001_page.red.isDisplayed());

    }


    @Then("gmibank Password strenght orange gorunur")
    public void gmibankPasswordStrenghtOrangeGorunur() {
        Assert.assertTrue(us3001_page.orange.isDisplayed());
    }

    @Then("gmibank Password strenght yellow gorunur")
    public void gmibankPasswordStrenghtYellowGorunur() {
        Assert.assertTrue(us3001_page.yellow.isDisplayed());
    }

    @Then("gmibank Password strenght lightgreen gorunur")
    public void gmibankPasswordStrenghtLightgreenGorunur() {
        Assert.assertTrue(us3001_page.lightgreen.isDisplayed());
    }

    @Then("gmibank Password strenght green gorunur")
    public void gmibankPasswordStrenghtGreenGorunur() {
        Assert.assertTrue(us3001_page.green.isDisplayed());
    }
}
