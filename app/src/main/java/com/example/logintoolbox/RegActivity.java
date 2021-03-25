package com.example.logintoolbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegActivity extends AppCompatActivity {
    Button btnLogin;
    EditText txtName, txtPassword;
    public Login l = new Login();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);btnLogin = findViewById(R.id.btnLogin);
        txtName = findViewById(R.id.txtNameSearch);
        txtPassword = findViewById(R.id.txtPassword);

        l.setArray(50);


        btnLogin.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String strName = txtName.getText().toString();

                String iPassword = txtPassword.getText().toString();

                if ((strName.length() > 0) && (iPassword.length() >0))
                {
                    l.add(strName,iPassword);
                    Toast.makeText(RegActivity.this, "New User Added Successfully!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "You did not fill in all the fields",
                            Toast.LENGTH_LONG).show();
                    txtName.setError("Enter the value here");
                    txtPassword.setError("Enter the value here");
                }


            }
        });
    }
    //for users who log in correctly
    public void LoginPage(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}