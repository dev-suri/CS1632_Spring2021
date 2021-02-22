package edu.pitt.cs.cs1632;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class StepDefinitions {
	private RentACat r;
	private String listResult;
	private boolean worked; // rent/return is successful - > true, else -> false
	// essentially, when i rent, i store the result in this boolean, same with returning
	// that way, i can check if it was successful or not
	
	
	// TODO: Add more member variables and methods as necessary
	@Then("the return is successful")
	public void theReturnIsSuccessful() {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(worked, true);
	}
	
	@Then("the return is unsuccessful")
	public void theReturnIsUnsuccessful() {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(worked, false);
	}

	@When("I return cat number {int}")
	public void iReturnCatNumber(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	   worked = r.returnCat(int1);
	}

	@Given("a rent-a-cat facility")
	public void aRentACatFacility() {
		r = RentACat.createInstance();
	}
	
	@Given("no cats")
	public void noCats() {
		// nothing to do really
	}
	
	@Given("a cat with ID {int} and name {string}")
	public void aCatWithIDAndName(Integer id, String name) {
		r.addCat(new Cat(id, name));
		System.out.println("Created cat " + id + ". " + name);
	}
	
	@When("I list the cats")
	public void iListTheCats() {
		listResult = r.listCats();
	}
	
	@When("I rent cat number {int}")
	public void iRentCatNumber(Integer id) {
		worked = r.rentCat(id);
	}
	
	@Then("the listing is: {string}")
	public void theListingIs(String result) {
		assertEquals(result.replaceAll("\\\\n", "\n"), listResult);
	}
	
	@Then("the rent is successful")
	public void theRentIsSuccessful() {
		// TODO: Implement
		assertEquals(worked, true);
	}

	@Then("the rent is unsuccessful")
	public void theRentIsUnsuccessful() {
		// TODO: Implement
		assertEquals(worked, false);
	}
}
