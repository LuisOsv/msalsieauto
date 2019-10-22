package uitests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AutoHelper {

    public static List< String > getValues(By locator) {
        List<WebElement> elements = BrowerFactory.getWebDriver().findElements(locator);
        List< String > values = new ArrayList<>();

        for (WebElement element : elements)
            values.add(element.getText());

        return values;
    }

    public static boolean verifyIfCustomerIsPresent(List<String> customers, String searchCustomer) {
        for(String customer : customers)
            if(customer.contains(searchCustomer)) return true;
        return false;
    }

    public static String convertDateFormat(String birthDate) {
        return "2019-10-09";
    }

}
