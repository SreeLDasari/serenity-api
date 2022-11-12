@petapitest
Feature: Validate Pet API Post, Put and Delete

  @petapitest
  Scenario: Verify the pet api post,put and delete methods
  When user create a pet
  |id		|categoryId|categoryName|name		|photoUrls|tagsId |tagsName|status|
  |100101	|0|sree		|doggie	|pic	|10 |  name|available|
  Then user verifies the status code 200
  When user gets the pet
  Then verify json schema
  When user deleted the created pet
  Then user verify the status code is 200
  When user gets the pet
  Then verify the status code 404
  
   
	
