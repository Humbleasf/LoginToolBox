package com.example.logintoolbox;

import android.graphics.Bitmap;

public class DetailsWithImage
{
    String strName ;
    String strPassword;
    String strWelcomeMessage;
    String bImage;


    public DetailsWithImage(String strName, String strPassword, String strWelcomeMessage, String image) {
        this.strName = strName;
        this.strPassword = strPassword;
        this.strWelcomeMessage = strWelcomeMessage;
        this.bImage = image;
    }
    public String getbImage() {
        return bImage;
    }

    public void setbImage(String bImage) {
        this.bImage = bImage;
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
}
