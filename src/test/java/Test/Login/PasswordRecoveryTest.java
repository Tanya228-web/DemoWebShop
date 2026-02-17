package Test.Login;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PasswordRecoveryTest extends BaseTest {
//
    @DataProvider(name = "PasswordRecoveryData")
    public Object [][] passwordRecoveryData(){
        return new Object[][]{
                {"tannu1@gmail.com","RegisteredUserEmail"},
                {"radhika123456@gmail.com","NonRegisteredUserEmail"},
                {"","Empty"}
        };

    }
    @Test (dataProvider = "PasswordRecoveryData")
    public void verifyPasswordRecovery(String email, String validation){
        var PasswordRecoveryPage = homepage.goToLoginPage().goToForgotPasswordPage();
        PasswordRecoveryPage.passwordRecoveryEmail(email);
        PasswordRecoveryPage.clickRecoverBtn();
        String actualResult = "";
        switch (validation){
            case "RegisteredUserEmail":
                actualResult = PasswordRecoveryPage.getRegisteredUserPasswordRecoveryMsg();
                Assert.assertEquals(actualResult, "Email with instructions has been sent to you.");
                break;

            case "NonRegisteredUserEmail":
                actualResult = PasswordRecoveryPage.getNonRegisteredUserPasswordRecoveryMsg();
                Assert.assertEquals(actualResult,"Email not found.");
                break;

            case "":
                actualResult = PasswordRecoveryPage.getEmptyEmailErrorMessage();
                Assert.assertEquals(actualResult,"Enter your email");
                break;


        }


    }


}
