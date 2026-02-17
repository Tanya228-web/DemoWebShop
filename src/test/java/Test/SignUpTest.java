package Test;

import Base.BaseTest;
import com.BidderBoyPages.HomePage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SignUpTest extends BaseTest {
    private String generateEmail(){
        return "anita" + System.currentTimeMillis() + "@gmail.com";
    }

    @Test
    public void verifyUserCanRegisterSuccessfully(){

        var userRegisterPage = homepage.clickRegister();
        String email = generateEmail();

        userRegisterPage.UserDetails("anita", "singh", email, "123456", "123456");
        userRegisterPage.clickRegisterBtn();

        var actualResult = userRegisterPage.checkRegistered();
        Assert.assertEquals(actualResult, email);
    }
    @DataProvider(name = "invalidSignupData")
    public Object[][] getInvalidSignupData(){

        return new Object[][]{

                {"", "singh", "email", "123456", "123456", "firstName"},
                {"tanya", "", "email", "123456", "123456", "lastName"},
                {"tanya", "singh", "", "123456", "123456", "emailField"},
                {"tanya", "singh", "email", "", "123456", "password"},
                {"tanya", "singh", "email", "123456", "", "confirmPassword"},
                {"tanya", "singh", "email", "123457", "123456", "mismatch"},
                {"tanya", "singh", "email", "12345", "12345", "minLength"}

        };
    }
    @Test(dataProvider = "invalidSignupData")
    public void verifySignupValidation(String firstName,
                                       String lastName,
                                       String emailInput,
                                       String password,
                                       String confirmPassword,
                                       String validationType){

        var userRegisterPage = homepage.clickRegister();
        String email = generateEmail();

        if(emailInput.equals("email")){
            emailInput = email;
        }
        userRegisterPage.ClickGender();
        userRegisterPage.UserDetails(firstName, lastName, emailInput, password, confirmPassword);
        userRegisterPage.clickRegisterBtn();

        String actualResult = "";

        switch (validationType){

            case "firstName":
                actualResult = userRegisterPage.checkFirstNameError();
                Assert.assertEquals(actualResult, "First name is required.");
                break;

            case "lastName":
                actualResult = userRegisterPage.checkLastNameError();
                Assert.assertEquals(actualResult, "Last name is required.");
                break;

            case "emailField":
                actualResult = userRegisterPage.checkEmailError();
                Assert.assertEquals(actualResult, "Email is required.");
                break;

            case "password":
                actualResult = userRegisterPage.checkPasswordError();
                Assert.assertEquals(actualResult, "Password is required.");
                break;

            case "confirmPassword":
                actualResult = userRegisterPage.checkConfirmPasswordError();
                Assert.assertEquals(actualResult, "Password is required.");
                break;

            case "mismatch":
                actualResult = userRegisterPage.checkErrorWhenPassAndConPassNotMatch();
                Assert.assertEquals(actualResult,
                        "The password and confirmation password do not match.");
                break;

            case "minLength":
                actualResult = userRegisterPage.checkPasswordContainsMinimumLetters();
                Assert.assertEquals(actualResult,
                        "The password should have at least 6 characters.");
                break;
        }
    }



}


