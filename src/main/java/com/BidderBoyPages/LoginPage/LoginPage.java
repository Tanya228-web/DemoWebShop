package com.BidderBoyPages.LoginPage;

import com.BidderBoyPages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends HomePage {
    By LoginEmail = By.id("Email");
    By LoginPassword = By.id("Password");
    By LoginBtn = By.xpath("//input[@class = 'button-1 login-button']");
    By LogOut = By.className("ico-logout");
    By WrongEmail = By.xpath("//li[text() = 'No customer account found']");
    By WrongPassword = By.xpath("//li[text()='The credentials provided are incorrect']");
    By ForgotPassword = By.xpath("//a[text()='Forgot password?']");
    By rememberMeCheckBox = By.id("RememberMe");
    By noCredentialError = By.xpath("//li[text()='No customer account found']");

    public void userDetails(String email, String password){
        find(LoginEmail).sendKeys(email);
        find(LoginPassword).sendKeys(password);


    }
    public void clickLoginBtn(){
        click(LoginBtn);
    }
    public String verifyLogin(){
        return find(LogOut).getText();

    }
    public String getErrorMsgBySendingWrongEmail(){
        return find(WrongEmail).getText();


    }
    public String getErrorMsgBySendingWrongPassword(){
        return find(WrongPassword).getText();

    }
    public ForgotPasswordPage goToForgotPasswordPage(){
        click(ForgotPassword);
        return new ForgotPasswordPage();

    }
//    public void clickRememberMe(){
//        var checkBox = find(By.id("rememberMe"));
//        if (!checkBox.isSelected()){
//            click(checkBox);
//        }else{
//            click(checkBox);
//        }
//    }
    public String getErrorMsgWithoutSendingUserDetails(){
        return find(noCredentialError).getText();

    }
}
