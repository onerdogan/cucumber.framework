package stepdefinitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.CHQAPage;

public class CHQAStepDefinitions {

    CHQAPage chqaPage=new CHQAPage();
    @Then("CH Login linkine tiklar")
    public void ch_login_linkine_tiklar() {
        chqaPage.loginLinki.click();

    }
    @Then("CH username kutusuna {string} yazar")
    public void ch_username_kutusuna_yazar(String kullaniciadi) {
    chqaPage.usernameKutusu.sendKeys(kullaniciadi);
    }
    @Then("CH password kutusuna {string} yazar")
    public void ch_password_kutusuna_yazar(String sifre) {
        chqaPage.passwordKutusu.sendKeys(sifre);
    }
    @Then("CH Login butonuna basar")
    public void ch_login_butonuna_basar() {
    chqaPage.logiButonu.click();
    }
    @Then("giris yapilamadigini test eder")
    public void giris_yapilamadigini_test_eder() {
        Assert.assertTrue(chqaPage.girisYapilamadiYazisi.isDisplayed());

    }

    @Then("CH basarili giris yapildigini test eder")
    public void chBasariliGirisYapildiginiTestEder() {
        Assert.assertTrue(chqaPage.basariliGirisYazisi.isDisplayed());
    }
}
