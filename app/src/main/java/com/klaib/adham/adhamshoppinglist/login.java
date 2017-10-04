package com.klaib.adham.adhamshoppinglist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class login extends AppCompatActivity
{
    private EditText ETEMAIL;
    private EditText ETPASSWPRD;
    private Button BTNLOGIN;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in);

    }
}
