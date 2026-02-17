package com.BidderBoyPages;

import com.Base.BasePage;
import com.BidderBoyPages.LoginPage.LoginPage;
import com.BidderBoyPages.SignUp.SignUpPage;
import org.openqa.selenium.By;

public class HomePage extends BasePage {
    By Register = By.className("ico-register");
    By Login = By.className("ico-login");

    public SignUpPage clickRegister(){
        click(Register);
        return new SignUpPage();
    }
    public LoginPage goToLoginPage(){
        click(Login);
        return new LoginPage();
    }


}
