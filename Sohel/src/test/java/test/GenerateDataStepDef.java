package test;

import framework.ParentScenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;


public class GenerateDataStepDef extends ParentScenario {

    @Given("Open a new page in the browser")
    public void open_a_new_page_in_the_browser() {
        basePage.verifyBrowserIsOpen();
    }

    @When("User navigate to the page")
    public void user_navigate_to_the_page(int howManyPage) throws InterruptedException, IOException, ParseException {

    }

    @When("User navigate to the page and grab {string} page information")
    public void user_navigate_to_the_page_and_grab_page_information(String howManyPage) throws InterruptedException, IOException, ParseException {
        basePage.navigateToPage();
        generateData.clickOnDetailsButton();
        int intPageNumber = Integer.valueOf(howManyPage);
        generateData.prepareArrayListOfCompanyDataFull(intPageNumber);
        generateData.generate();
    }


}
