package dbStepDefinition;

import io.cucumber.java.en.Given;
import utilities.DBUtilsForJDBC;

import java.util.List;

public class DatabaseStepdefinition {
    @Given("user connects database and print all data")
    public void userConnectsDatabaseAndPrintAllData() {
        DBUtilsForJDBC.createConnectionGMB();
        String query="SELECT *FROM public.tp_customer";
        List<Object> list=DBUtilsForJDBC.getColumnData(query,"email");
        for (Object w:list
             ) {
            System.out.println(w.toString());
        }
    }
}
