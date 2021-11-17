package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.GMIBankPage;
import utilities.ConfigReader;
import utilities.Driver;

public class GMIBankStepDefinitions {
    GMIBankPage gmiBankPage = new GMIBankPage();

    @When("kullanici gmibank sayfasina gider")
    public void kullanici_gmibank_sayfasina_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("GMIBankUrl"));

    }
    @Then("sayfaya giris yapar")
    public void sayfaya_giris_yapar() {
        gmiBankPage.GMIBankLogin();

    }
    @Then("sayfaya giris yapyigini dogrular")
    public void sayfaya_giris_yapyigini_dogrular() {
        gmiBankPage.girisOnayWebElementi.isDisplayed();

    }
    @When("gmibank signout butonuna tiklar")
    public void gmibank_signout_butonuna_tiklar() {
        gmiBankPage.girisOnayWebElementi.click();
        gmiBankPage.signOutWebElementi.click();

    }
    @When("gmibank sayfasindan cikis yaptigini dogrular")
    public void gmibank_sayfasindan_cikis_yaptigini_dogrular() {
        gmiBankPage.signOutOnayWebElementi.isDisplayed();

    }


}
