package hooks;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;

public class Hooks {
	  @Before
	    public void setReqSpec(Scenario scenario) {
	        if(scenario.getSourceTagNames().contains("@petapitest")) {
	            RequestSpecification requestSpecification = new RequestSpecBuilder()
	                    .setBaseUri("https://petstore.swagger.io/v2/pet/")
	                    .setContentType(ContentType.JSON)
	                 //   .addHeader("api_key", "special-key")
	                    .build();
	            SerenityRest.setDefaultRequestSpecification(requestSpecification);
	        }
	    }

}
