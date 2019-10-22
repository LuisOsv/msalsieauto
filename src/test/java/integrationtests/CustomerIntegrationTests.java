package integrationtests;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import unittests.CustomerHelper;

public class CustomerIntegrationTests {

    @Before
    public void setup(){
        RestAssured.baseURI = "http://localhost:8080";
    }

    @Test
    public void testPostAddUser(){

        RestAssured
                .given()
                    .header("Accept", "*/*")
                    .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                    .param("customerId", String.valueOf(CustomerHelper.generateRandomId()))
                    .param("customerName", "liam")
                    .param("email", "liam@mail.com")
                    .param("dateOfBirth", "1955-02-24")
                .when()
                .post("/add")
                .then()
                .statusCode(302);
    }


    @Test
    public void testRemoveCustomerApi(){
        RestAssured
                .given()
                .header("Accept", "*/*")
                .when()
                .get("/delete/101")
                .then()
                .statusCode(200);
    }


}
