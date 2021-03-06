package runners;



import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions (
        plugin={"html:target\\Pcucumber-reports2.html",
                "json:target/json-reports/Pcucumber2.json",
                "junit:target/xml-report/Pcucumber2.xml"},
        features = "src/test/resources/features",
        glue = "stepdefinitions",
        tags = "@Paralel2",

        dryRun=false
        //dryrun=true dedigimizde testi calistirmadan bize eksik adimi verir
        //dryrun=false dersek testi calistirir, eksik bir adimla calisirsa test fail olur , bize eksik adimi raporlar
)

public class ParalelTestRunner2 {
}
