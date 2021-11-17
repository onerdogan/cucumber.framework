package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class amazonStepDefinitions {
    AmazonPage amazonPage = new AmazonPage();

    @When("kullanici amazon sayfasina gider")
    public void kullanici_amazon_sayfasina_gider() {

        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));


    }

    @When("nutella icin arama yapar")
    public void nutella_icin_arama_yapar() {
    amazonPage.aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

    }

    @Then("sonucun nutella icerdigini test eder")
    public void sonucun_nutella_icerdigini_test_eder() {
        Assert.assertTrue(amazonPage.sonucYazisi.getText().contains("Nutella"));


    }

    @When("java icin arama yapar")
    public void java_icin_arama_yapar() {

        amazonPage.aramaKutusu.sendKeys("java"+ Keys.ENTER);
    }
    @Then("sonucun java icerdigini test eder")
    public void sonucun_java_icerdigini_test_eder() {
        Assert.assertTrue(amazonPage.sonucYazisi.getText().contains("java"));
    }


    @When("ipad icin arama yapar")
    public void ipad_icin_arama_yapar() {

        amazonPage.aramaKutusu.sendKeys("ipad"+ Keys.ENTER);
    }
    @Then("sonucun ipad icerdigini test eder")
    public void sonucun_ipad_icerdigini_test_eder() {
        Assert.assertTrue(amazonPage.sonucYazisi.getText().contains("ipad"));
    }
    @Given("{string} icin arama yapar")
    public void icin_arama_yapar(String aranankelime) {
        amazonPage.aramaKutusu.sendKeys(aranankelime+ Keys.ENTER);
    }
    @Then("sonucun {string} icerdigini test eder")
    public void sonucun_icerdigini_test_eder(String aranankelime) {
        Assert.assertTrue(amazonPage.sonucYazisi.getText().contains(aranankelime));

    }


    @And("sayfayi kapatir")
    public void sayfayiKapatir() {
        Driver.closeDriver();
    }

    @Given("kullanici {string} sayfasina gider")
    public void kullaniciSayfasinaGider(String istenenURL) {
        Driver.getDriver().get(ConfigReader.getProperty(istenenURL));
    }


    @Then("basligin {string} icerdigini test eder eder")
    public void basliginIcerdiginiTestEderEder(String aranankelime) {
        Assert.assertTrue(Driver.getDriver().getTitle().contains(aranankelime));
    }
}