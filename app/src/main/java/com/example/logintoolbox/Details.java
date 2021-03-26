package com.example.logintoolbox;

public class Details
{
    public Details(String strName, String strPassword, String strWelcomeMessage) {
        this.strName = strName;
        this.strPassword = strPassword;
        this.strWelcomeMessage = strWelcomeMessage;
    }

    public String getStrName() {
        return strName;
    }

    public void setStrName(String strName) {
        this.strName = strName;
    }

    public String getStrPassword() {
        return strPassword;
    }

    public void setStrPassword(String strPassword) {
        this.strPassword = strPassword;
    }

    public String getStrWelcomeMessage() {
        return strWelcomeMessage;
    }

    public void setStrWelcomeMessage(String strWelcomeMessage) {
        this.strWelcomeMessage = strWelcomeMessage;
    }

    String strName ;
    String strPassword;
    String strWelcomeMessage;
}
