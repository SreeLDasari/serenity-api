package steps;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.assertj.core.util.Arrays;

import helpers.PetHelper;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.Category;
import models.Pet;
import models.Tags;

public class PetSteps {
	PetHelper pethelper=new PetHelper();
	String petId;
	@When("user create a pet")
	public void user_create_a_pet(List<Map<String, String>> petDataList) {
		
		petDataList.forEach(petData -> {Pet pet=Pet.builder()
				.id(Integer.parseInt(petData.get("id")))
				.name(petData.get("name"))
				.status(petData.get("status"))
				.photoUrls(List.of(petData.get("photoUrls")))
				.tags(List.of(Tags.builder()
						.id(petData.get("tagsId"))
						.name(petData.get("tagsName"))
						.build()))
				.category(Category.builder()
						.id(petData.get("categoryId"))
						.name(petData.get("categoryName")).build())						
				.build();
		pethelper.createPet( pet);
		System.out.println(pet+"----------->pet data");
		petId=petData.get("id");
		});
	
		System.out.println(petId+"--> created pet id");

	}

	@Then("user verifies the status code {int}")
	public void user_verifies_the_status_code(Integer int1) {
		pethelper.verifyStatusCode(int1);
	}

	@When("user deleted the created pet")
	public void user_deleted_the_created_pet() {
		pethelper.deletePet(petId);
	}

	@Then("user verify the status code is {int}")
	public void user_verify_the_status_code_is(Integer int1) {
		pethelper.verifyStatusCode(int1);
	}
	@When("user gets the pet")
	public void user_gtes_the_pet() {
		pethelper.getPet(petId);
	}

	@Then("verify the status code {int}")
	public void verify_the_status_code(Integer int1) {
		pethelper.verifyStatusCode(int1);
	}
	@Then("verify json schema")
	public void verify_json_schema() {
	    File file=new File("src/test/resources/schemas/petSchema.json");
	    pethelper.verifySchema(file);
	    
	}
}
