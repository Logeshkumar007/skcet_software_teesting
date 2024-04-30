package com.iamneo.pageobject;



public class LoginPage {
    private WebDriver driver;

    @FindBy(name = "uid")
    private WebElement usernameInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(name = "btnLogin")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setUserName(String uname) {
        usernameInput.sendKeys(uname);
    }

    public void setPassword(String pwd) {
        passwordInput.sendKeys(pwd);
    }

    public void clickButton() {
        loginButton.click();
    }
}
