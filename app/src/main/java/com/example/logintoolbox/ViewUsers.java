package com.example.logintoolbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ViewUsers extends AppCompatActivity {
    ListView listView;
    //Array of string used to print out
    String[] StudentNames ={"Yumna","Kira","Stephan","Ruphael ","Janneke"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_users);

        ArrayAdapter adapter = new ArrayAdapter<String>(
                this,R.layout.activity_listview,StudentNames);

        listView = (ListView) findViewById(R.id.lvOutput);
        listView.setAdapter(adapter);

        //Search array ... then send finding of the data collected to the new
        //Adapter
        //Send adapter to the listview

    }


    public void NewLayout(View view)
    {
        Login l = new Login();

        DetailsListAdapter adapter = new DetailsListAdapter(this, R.layout.activity_view_multi, l.returnArray());
        listView.setAdapter(adapter);
    }
}