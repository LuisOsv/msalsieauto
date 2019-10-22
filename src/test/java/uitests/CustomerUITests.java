package uitests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import org.springframework.test.context.junit4.SpringRunner;
import unittests.CustomerHelper;

import java.util.List;

@RunWith(SpringRunner.class)
public class CustomerUITests {

    public WebDriver webDriver;

    @Before
    public void setupDriver(){
        BrowerFactory.initWebDriver();
        webDriver = BrowerFactory.getWebDriver();
        webDriver.get("http://localhost:8080/");
    }

    @Test
    public void testAddCustomerUI(){

        String name = String.format("Charly %s", CustomerHelper.generateRandomId());
        String email = "charly@alsi.com";
        String birthDate = "09/10/2019";
        CustomerPage customerPage = new CustomerPage();
        customerPage.createNewCustomer(name, email, birthDate);
        List<String> customers = AutoHelper.getValues(CustomerLocators.TableRows);
        String expectedCustomer = String.format("%s %s %s", name, email, AutoHelper.convertDateFormat(birthDate));
        Assert.assertTrue(
                String.format("Table should has the customer \"%s\" but it doesn't:\n %s",
                        expectedCustomer, String.join("\n ", customers)),
                AutoHelper.verifyIfCustomerIsPresent(customers, expectedCustomer));
    }

    @Test
    public void testRemoveCustomerUI(){
        String name = String.format("Charly %s", CustomerHelper.generateRandomId());
        String email = "charly@alsi.com";
        String birthDate = "09/10/2019";
        CustomerPage customerPage = new CustomerPage();
        customerPage.createNewCustomer(name, email, birthDate);
        customerPage.removeCustomer(name);
        List<String> customers = AutoHelper.getValues(CustomerLocators.TableRows);
        String customerRemoved = String.format("%s %s %s", name, email, AutoHelper.convertDateFormat(birthDate));
        Assert.assertFalse(
                String.format("Table should NOT has the customer \"%s\" but it does:\n %s",
                        customerRemoved, String.join("\n ", customers)),
                AutoHelper.verifyIfCustomerIsPresent(customers, customerRemoved)
        );
    }

    @After
    public void finishTest(){
        BrowerFactory.closeWebdriver();
    }
}
