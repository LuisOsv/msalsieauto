package uitests;

import org.openqa.selenium.By;

public class CustomerLocators {
    public static By CustomerNameInput = By.id("customerName");
    public static By CustomerEmailInput = By.id("email");
    public static By CustomerBirthDateInput = By.id("dateOfBirth");
    public static By CustomerAddButton = By.xpath("//button[contains(text(),'Add')]");
    public static By TableRows = By.cssSelector("tbody tr");
    public static String RemoveButton = "//*[contains(text(),'%s')]/..//a";
}
