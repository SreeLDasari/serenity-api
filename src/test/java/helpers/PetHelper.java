package helpers;

import java.io.File;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import models.Pet;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class PetHelper {
	 @Step
	    public void createPet( Pet pet) {
	        SerenityRest
	                .given()
	                .body(pet)
	                .when()
	                .post();
	    }

	   
	    @Step
	    public void deletePet(String petId) {
	        SerenityRest
	                .when()
	                .delete("/"+petId);
	    }

	    
	    @Step
	    public void verifyStatusCode(int expectedStatusCode) {
	        SerenityRest
	                .then()
	                .statusCode(expectedStatusCode);
	    }
	    @Step
	    public void getPet(String petId) {
	        SerenityRest
	                .when()
	                .get("/"+petId);
	    }
	   

	    @Step
	    public void verifySchema(File file) {
	           SerenityRest
	                .then()
	                .body(JsonSchemaValidator.matchesJsonSchema(file));
	    }


}
