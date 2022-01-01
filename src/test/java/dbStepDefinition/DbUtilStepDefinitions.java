package dbStepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.DBUtilsForJDBC;

import java.sql.SQLException;

public class DbUtilStepDefinitions {

    @Given("kullanici DBUtil ile CHQA database'ine baglanir")
    public void kullanici_db_utill_ile_chqa_database_ine_baglanir() {
        DBUtilsForJDBC.getConnection();

    }
    @Given("kullanici DBUtil ile {string} tablosundaki {string} verilerini alir")
    public void kullanici_db_utill_ile_tablosundaki_verilerini_alir(String table, String field) {
        String readQuery= "SELECT "+field+" FROM "+table;
        DBUtilsForJDBC.executeQuery(readQuery);

    }
    @Given("kullanici DBUtil ile {string} sutunundaki {int}. fiyatin {int} oldugunu test eder")
    public void kullanici_db_utill_ile_sutunundaki_fiyatin_oldugunu_test_eder(String field, Integer satirNo, Integer expectedPrice) throws Exception {

        int satirSayisi= DBUtilsForJDBC.getRowCount();
        int aktifSatirNumarasi=1;
        System.out.println(satirSayisi);

        DBUtilsForJDBC.getResultset().first();

        while (aktifSatirNumarasi<100){

            Object satirdakiObje= DBUtilsForJDBC.getResultset().getObject(field);
            System.out.println(aktifSatirNumarasi + ".satirdaki fiyat :" + satirdakiObje.toString());
            DBUtilsForJDBC.getResultset().next();
            aktifSatirNumarasi++;
        }

        DBUtilsForJDBC.getResultset().absolute(satirNo);
        int actualDeger= (int) DBUtilsForJDBC.getResultset().getDouble(field);
        Assert.assertTrue(actualDeger==expectedPrice);
    }

    @Then("DBU IDHotel degeri {int} olan kaydin Email degerini {string} yapar")
    public void dbuIDHotelDegeriOlanKaydinEmailDegeriniYapar(int IDHotelNo, String yeniEmail) throws SQLException {

        String updateQuery="UPDATE tHOTEL SET Email='"+yeniEmail+"' WHERE IDHotel="+IDHotelNo;
        DBUtilsForJDBC.executeQuery(updateQuery);





        String readQuery= "SELECT Email FROM tHOTEL";

        DBUtilsForJDBC.executeQuery(readQuery);

        int aktifSatirNumarasi=1;
        DBUtilsForJDBC.getResultset().first();

        while (aktifSatirNumarasi<100){

            Object satirdakiObje= DBUtilsForJDBC.getResultset().getObject("Email");
            System.out.println(aktifSatirNumarasi + ".satirdaki Email :" + satirdakiObje.toString());
            DBUtilsForJDBC.getResultset().next();
            aktifSatirNumarasi++;
        }



    }


}
