package com.BidderBoyPages.SignUp;

import com.BidderBoyPages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SignUpPage extends HomePage {
    By MaleRadioBtn = By.id("gender-male");
    By FemaleRadioBtn = By.id("gender-female");
    By FirstName = By.id("FirstName");
    By LastName = By.id("LastName");
    By Email = By.id("Email");
    By Password = By.id("Password");
    By ConfirmPassword = By.id("ConfirmPassword");
    By RegisterBtn = By.id("register-button");
    By getMailAfterRegister = By.className("account");
    By FirstNameError = By.xpath("//span[text()=\"First name is required.\"]");
    By LastNameError = By.xpath("//span[text()='Last name is required.']");
    By EmailError = By.xpath("//span[text()='Email is required.']");
    By PasswordError = By.xpath("//span[text()='Password is required.']");
    By ConfirmPasswordError = By.xpath("//span[text()='Password is required.']");
    By PassAndConPassError = By.xpath("//span[text()='The password and confirmation password do not match.']");
    By MinimumPasswordError = By.xpath("//span[text()='The password should have at least 6 characters.']");
    public void ClickGender(){
        if(!find(MaleRadioBtn).isSelected()){
            click(MaleRadioBtn);
        }else
            click(FemaleRadioBtn);

    }
    public void UserDetails(String firstName, String lastName, String email, String password, String confirmPassword){
        find(FirstName).sendKeys(firstName);
        find(LastName).sendKeys(lastName);
        find(Email).sendKeys(email);
        find(Password).sendKeys(password);
        find(ConfirmPassword).sendKeys(confirmPassword);

    }
    public void clickRegisterBtn(){
        click(RegisterBtn);

    }
    public String checkRegistered(){
        String mailText = find(getMailAfterRegister).getText();
        return mailText;

    }
    public String checkFirstNameError(){
        String firstNameError = find(FirstNameError).getText();
        return firstNameError;
    }
    public String checkLastNameError(){
        String lastNameError = find(LastNameError).getText();
        return lastNameError;
    }
    public String checkEmailError(){
        String emailError = find(EmailError).getText();
        return emailError;
    }
    public String checkPasswordError(){
        String passwordError = find(PasswordError).getText();
        return passwordError;
    }
    public String checkConfirmPasswordError(){
        String confirmPasswordError = find(ConfirmPasswordError).getText();
        return confirmPasswordError;
    }
    public String checkErrorWhenPassAndConPassNotMatch(){
        String checkPassAndConPass = find(PassAndConPassError).getText();
        return checkPassAndConPass;
    }
    public String checkPasswordContainsMinimumLetters(){
        String checkMinPass = find(MinimumPasswordError).getText();
        return checkMinPass;
    }

}