package APITesting;

import io.restassured.response.ValidatableResponse;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class TestingProductsApi {
    private int skuID;

    @Test
    public void Test00_Check_GetProductsAPI_Status() {
        given()
                .get("http://localhost:3030/products")
                .then()
                .statusCode(200);
    }

    @Test
    public void Test02_check_that_user_can_add_products_sucsessfully() {
        JSONObject request = new JSONObject();
        request.put("name", "TestSKU");
        request.put("type", "metal");
        request.put("price", 600);
        request.put("shipping", 100);
        request.put("upc", "SKU1");
        request.put("description", "sku test");
        request.put("manufacturer", "gold");
        request.put("model", "model2020");
        request.put("url", "testURL");
        request.put("image", "NA");
        // System.out.println(request.toJSONString());
        ValidatableResponse response;
        response = given().header("Content-Type", "application/json")
                .body(request.toJSONString())
                .when()
                .post("http://localhost:3030/products")
                .then().statusCode(201);
        // System.out.println(response.extract().asPrettyString());
        Assert.assertTrue(response.extract().asPrettyString().contains("TestSKU"));
        skuID = response.extract().path("id");
    }

    @Test(dependsOnMethods = "Test02_check_that_user_can_add_products_sucsessfully")
    public void Test03_check_that_user_can_filter_with_product_id() {
        ValidatableResponse response;
        response = given().queryParam("id", skuID)
                .when().get("http://localhost:3030/products")
                .then().statusCode(200);
        System.out.println(response.extract().asPrettyString());

    }

    @Test(dependsOnMethods = "Test02_check_that_user_can_add_products_sucsessfully")
    public void Test04_chek_that_user_can_delete_product_sucsessfully() {
        ValidatableResponse response;

        response = given().queryParam("id", skuID)
                .when().delete("http://localhost:3030/products")
                .then().statusCode(200);
        System.out.println(response.extract().asPrettyString());
    }

    @Test
    public void Test05_chek_that_user_can_update_product_sucsessfully() {
        ValidatableResponse response;
        JSONObject request = new JSONObject();
        request.put("name", "UpdatedTestSKU");
        response = given().header("Content-Type", "application/json")
                .body(request.toJSONString())
                .when()
                .patch("http://localhost:3030/products/" + 185267)
                .then().statusCode(200);
        Assert.assertEquals(response.extract().path("name"), "UpdatedTestSKU");
        System.out.println(response.extract().asPrettyString());
    }



}

