package Test.Login;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void verifyLogin(){
        var LoginPage = homepage.goToLoginPage();
        LoginPage.userDetails("tannu1@gmail.com","123456");
        LoginPage.clickLoginBtn();
        var actualResult = LoginPage.verifyLogin();
        var expectedResult = "Log out";
        Assert.assertEquals(actualResult, expectedResult, "actual result and expected result did not match");
    }


    @DataProvider(name = "verifyLoginData")
    public Object [][] verifyLoginData(){

        return new Object[][]{
                {"Radhe1234567@gmail.com","123456","checkErrorMsgBySendingWrongEmail"},
                {"tannu1@gmail.com","1237890","checkErrorMsgBySendingWrongPassword"},
                {"","","EmptyUserDetails"}
        };
    }

    @Test (dataProvider = "verifyLoginData")
    public void verifyUserDetails(String email, String password, String validation){
        var LoginPage = homepage.goToLoginPage();
        LoginPage.userDetails(email, password);
        LoginPage.clickLoginBtn();
        String actualResult = "";
        switch (validation){
            case "checkErrorMsgBySendingWrongEmail":
                actualResult = LoginPage.getErrorMsgBySendingWrongEmail();
                Assert.assertEquals(actualResult, "No customer account found");
                break;

            case "checkErrorMsgBySendingWrongPassword":
                actualResult = LoginPage.getErrorMsgBySendingWrongPassword();
                Assert.assertEquals(actualResult,"The credentials provided are incorrect");
                break;

            case "EmptyUserDetails":
                actualResult = LoginPage.getErrorMsgWithoutSendingUserDetails();
                Assert.assertEquals(actualResult,"No customer account found");
                break;


        }


    }






}
