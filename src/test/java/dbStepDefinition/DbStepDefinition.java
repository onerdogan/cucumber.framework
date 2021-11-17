package dbStepDefinition;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbStepDefinition {
    String url="jdbc:sqlserver://184.168.194.58:1433;databaseName=qaconcorthotel; user=Ahmet_User;password=Ahmet123!";
    String username="Ahmet_User";
    String password="Ahmet123!";
    Connection connection;
    Statement statement;
    ResultSet resultSet;


        @Given("kullanici databaseye baglanir")
        public void kullanici_databaseye_baglanir() throws SQLException {

        connection=DriverManager.getConnection(url,username,password);
        statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    }
    @Given("kullanici {string} tablosundaki {string} verilerini alir")
    public void kullanici_tablosundaki_verilerini_alir(String table, String field) throws SQLException {
        // SELECT Price FROM tHOTELROOM
        String readQuery= "SELECT "+field+" FROM "+table;

        resultSet=statement.executeQuery(readQuery);
    }
    @Then("kullanici {string} sutunundaki verileri okur ve istedigi islemi yapar")
    public void kullanici_sutunundaki_verileri_okur_ve_istedigi_islemi_yapar(String field) throws SQLException {

        // resultset iterator gibi calisir
        resultSet.first();
        System.out.println(resultSet.getObject(field).toString());

        //resultset.next() bir sonraki objeye gecer, sonraki eleman varsa true, yoksa false doner***
        System.out.println(resultSet.next());
        System.out.println(resultSet.getObject(field).toString());

        resultSet.last();
        System.out.println(resultSet.next());
        //tum liste icin: while loop ile birlikte resultSet.next() kullanilabilir,
        // sonraki eleman varsa, true devam edecek, son elemandan sonra false olur loop biter
        //eger son elemandaysak, hicbirsey yazdirmaz,
        //while loop calismadan once ilk elemana gitmek gerek

       /*
        resultSet.first();
       while (resultSet.next()){//birinci objeye gidildi ama .next sonraki elemana gitti, liste 2. elemandan basladi
           System.out.println(resultSet.getObject(field).toString());
       }

        resultSet.absolute(0);
        while (resultSet.next()) {
            System.out.println(resultSet.getObject(field).toString());//sona gidince hata veriyuor
        }*/
        //varsa ilk 100 fiyati double liste olarak
        int count=1;
        resultSet.absolute(0);
        List<Double> ilkyuzSayi=new ArrayList<>();
        while (count<=100 && resultSet.next()){
            ilkyuzSayi.add(resultSet.getDouble(field));
            count++;
        }
        System.out.println(ilkyuzSayi);
        System.out.println(ilkyuzSayi.size());
        //7. fiyati double olarak, 620.0 oldugunu test edin

        resultSet.absolute(7);
        double yedinciSayi=resultSet.getDouble(field);
        Assert.assertTrue(yedinciSayi==620.0);
    }
}