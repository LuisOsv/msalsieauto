package uitests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomerPage {
    private WebDriver webDriver;

    public CustomerPage() {
        this.webDriver = BrowerFactory.getWebDriver();
    }

    public void createNewCustomer(String name, String email, String birthDate){
        webDriver.findElement(CustomerLocators.CustomerNameInput).sendKeys(name);
        webDriver.findElement(CustomerLocators.CustomerEmailInput).sendKeys(email);
        webDriver.findElement(CustomerLocators.CustomerBirthDateInput).sendKeys(birthDate);
        webDriver.findElement(CustomerLocators.CustomerAddButton).click();
    }

    public void removeCustomer(String name) {
        webDriver.findElement(By.xpath(String.format(CustomerLocators.RemoveButton, name))).click();
    }
}
