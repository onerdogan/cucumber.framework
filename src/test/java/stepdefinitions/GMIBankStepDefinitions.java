package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.GMIBankPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

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

    @Then("gmibank signin butonuna tiklar")
    public void gmibank_signin_butonuna_tiklar() {
        gmiBankPage.ilkGirisButonu.click();
        gmiBankPage.signInButonu.click();
    }

    @Then("gmibank username kutusuna {string} yazar")
    public void gmibank_username_kutusuna_yazar(String yanlisUserName) {
        gmiBankPage.gmibankUsernameKutusu.sendKeys(yanlisUserName);
    }

    @Then("gmibank password kutusuna {string} yazar")
    public void gmibank_password_kutusuna_yazar(String yanlisPassword) {
        gmiBankPage.gmiBankPasswordKutusu.sendKeys(yanlisPassword);
    }

    @Then("gmibank sign in butonuna basar")
    public void gmibank_sign_in_butonuna_basar() {
        gmiBankPage.gmiBankSigInOkButonu.click();
    }

    @Then("gmibank giris yapilamadigini test eder")
    public void gmibank_giris_yapilamadigini_test_eder() {
        Assert.assertTrue(gmiBankPage.hataliGirisWebElementi.isDisplayed());

    }

    @Then("kullanici gecerli username ve password girer")
    public void kullanici_gecerli_username_ve_password_girer() {
        gmiBankPage.gmibankUsernameKutusu.sendKeys(ConfigReader.getProperty("GMIBankValidUsername"));
        gmiBankPage.gmiBankPasswordKutusu.sendKeys(ConfigReader.getProperty("GMIBankValidPassword"));
    }

    @Then("kullanici usedrIcona tiklar")
    public void kullanici_usedr_icona_tiklar() {
        gmiBankPage.girisOnayWebElementi.click();


    }

    @Then("kullanici settings sayfasinda olmalidir")
    public void kullanici_settings_sayfasinda_olmalidir() {
        gmiBankPage.userinfoWebElement.click();
        String expectedUrl = "https://www.gmibank.com/account/settings";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        System.out.println(expectedUrl.equals(actualUrl) ? "PASS" : "FAILED");
    }

    @Then("kullanici language dropdown da secenekleri gorur")
    public void kullanici_language_dropdown_da_secenekleri_gorur() {
        Select select = new Select(gmiBankPage.languageDropDown);
        gmiBankPage.languageDropDown.click();
        List<WebElement> languageOptions = select.getOptions();
//        System.out.println("Optuons1 :"+languageOptions.get(0).getText());
//        System.out.println("Optuons2 :"+languageOptions.get(1).getText());

        Assert.assertTrue(languageOptions.get(0).getText().equals("English"));
        Assert.assertTrue(languageOptions.get(1).getText().equals("Türkçe"));


    }

    @Then("kullanici English ve Turkish den baska dil seceneginin olmadigini dogrular")
    public void kullanici_english_ve_turkish_den_baska_dil_seceneginin_olmadigini_dogrular() {
        Select select = new Select(gmiBankPage.languageDropDown);
        List<WebElement> languageOptions = select.getOptions();
        for (WebElement each : languageOptions) {
            boolean language = each.getText().equals("English") || each.getText().equals("Türkçe");
            Assert.assertTrue("baska diller var", language);

            //     if(each.getText()=="English"||each.getText()=="Türkçe"){
            // }

        }


    }

    @Then("kullanici My Operations a tiklar")
    public void kullaniciMyOperationsATiklar() {
        gmiBankPage.myOperationWebElementi.click();
    }

    @Then("kullanaici Manage Customers i secer")
    public void kullanaiciManageCustomersISecer() {
        gmiBankPage.manageCustomersWebElementi.click();
    }

    @And("kullanici Create anew Customer a tiklar")
    public void kullaniciCreateAnewCustomerATiklar() {
        gmiBankPage.createNewCustomer.click();
    }

    @And("kullanici {string} girer")
    public void kullaniciGirer(String ssn) {
        gmiBankPage.searchSSN.sendKeys(ConfigReader.getProperty("ssn"));
    }

    @And("kullanaici search button a tiklar")
    public void kullanaiciSearchButtonATiklar() {
        gmiBankPage.searchButton.click();
    }

    @Then("kullanici fail message i gorur")
    public void kullaniciFailMessageIGorur() {
        Assert.assertTrue(gmiBankPage.failedMessage.isDisplayed());
    }


}