package com.example.logintoolbox;

import java.util.ArrayList;

public class Login
{
    private static String aName[];
    private static String aPassword[];
    private static int arrSize=0;

    public void setArray(int size)
    {
        if ( arrSize == 0)
        {
            aName = new String[size];
            aPassword = new String[size];
            setOlderUsers();
        }

    }
    public ArrayList<Details> returnArray()
    {
        ArrayList<Details> tempArray = new ArrayList<>();
        for (int i = 0; i <arrSize ; i++)
        {
            Details temp = new Details(aName[i],aPassword[i],null);
            tempArray.add(temp);
        }
        return tempArray;
    }

    public ArrayList<DetailsWithImage> returnArrayImages()
    {
        ArrayList<DetailsWithImage> tempArray = new ArrayList<>();
        for (int i = 0; i <arrSize ; i++)
        {
            DetailsWithImage temp = new DetailsWithImage(aName[i],aPassword[i],"","https://picsum.photos/500/300");
            tempArray.add(temp);
        }
        return tempArray;
    }



    public void setOlderUsers()
    {
        aName[0]="Granny";
        aName[1]="Granpa";
        aName[2]="GranSon";
        aName[3]="GranDaughter";

        aPassword[0]="1234";
        aPassword[1]="4321";
        aPassword[2]="1245";
        aPassword[3]="0000";

        arrSize=4;
    }

    public void add(String Username,String Password)
    {
        aName[arrSize]=Username;
        aPassword[arrSize]=Password;
        arrSize++;
    }

    public boolean Valid(String Username,String Password)
    {
        boolean bLoop = false;
        for (int i = 0; i <arrSize ; i++)
        {
            if ((aPassword[i].equals(Password))&&(aName[i].equals(Username)))
            {
                bLoop=true;
            }
        }
        return bLoop;
    }
}
