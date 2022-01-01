package stepdefinitions;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.restassured.http.ContentType;

import io.restassured.response.Response;
import org.junit.Assert;
import pojos.Customer;
import utilities.ConfigReader;
import utilities.ReadTxt;
import utilities.WriteToTxt;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class CustomerApiSteps {
    Response response;
    String bearerToken= ConfigReader.getProperty("api_bearer_token");
    Customer [] customers;
    String fileName=ConfigReader.getProperty("fileNameOfCustomerSSN");

    @Given("Kullanici Api end pointe gidecek {string} datalari alacak")
    public void kullanici_api_end_pointe_gidecek_datalari_alacak(String url) {

        response = given().headers(
                        "Authorization",
                        "Bearer " + bearerToken,
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON)
                .when()
                .get(url)
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();
       // response.prettyPrint();
    }
    @Given("Kullanici musteri datalarini alir")
    public void kullanici_musteri_datalarini_alir() throws JsonProcessingException {
        ObjectMapper obj = new ObjectMapper();

        customers = obj.readValue(response.asString(), Customer[].class);

        System.out.println(customers[0]);
        System.out.println(customers[0].getMobilePhoneNumber());
        System.out.println(customers[0].getAccounts());

        for(int i = 0; i<customers.length; i++)
            //System.out.println(custumers[i].getFirstName());
            if(customers[i].getUser() !=null)
                System.out.println(customers[i].getUser().getFirstName());
    }
    @Given("Kullanici aldigi datalari kaydeder")
    public void kullanici_aldigi_datalari_kaydeder() {
        WriteToTxt.saveDataInFileWithSSN(fileName, customers);



    }
    @Given("Kullanici Customer datalarini onaylar")
    public void kullanici_customer_datalarini_onaylar() {
        List<String> expectedSSNIds = new ArrayList<>();
        expectedSSNIds.add("888-77-6666");
        expectedSSNIds.add("255-25-2525");

        List<String > actualSSNIDs = ReadTxt.returnCustomerSNNList(fileName);
        Assert.assertTrue("SSN'LER ESLESMiYOR", actualSSNIDs.containsAll(expectedSSNIds));


    }
}
