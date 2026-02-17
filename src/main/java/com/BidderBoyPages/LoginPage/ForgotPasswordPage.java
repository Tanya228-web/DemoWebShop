package com.BidderBoyPages.LoginPage;

import org.openqa.selenium.By;

public class ForgotPasswordPage extends LoginPage{
    By email = By.id("Email");
    By recoverBtn = By.xpath("//input[@class = 'button-1 password-recovery-button']");
    By recoveryMsgOfRegisterUser = By.className("result");
    By recoveryMsgOfNonRegisteredUser = By.xpath("//div[@class = 'result']");
    By emptyEmailError = By.xpath("//span[text() = 'Enter your email']");
    public void passwordRecoveryEmail(String Email){
        find(email).sendKeys(Email);

    }
    public void clickRecoverBtn(){
        click(recoverBtn);

    }
    public String getRegisteredUserPasswordRecoveryMsg(){
        return find(recoveryMsgOfRegisterUser).getText();

    }
    public String getNonRegisteredUserPasswordRecoveryMsg(){
        return find(recoveryMsgOfNonRegisteredUser).getText();
    }
    public String getEmptyEmailErrorMessage(){
        return find(emptyEmailError).getText();
    }
}
