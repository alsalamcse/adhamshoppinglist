package com.klaib.adham.adhamshoppinglist;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
public class signup extends AppCompatActivity
{
    private EditText ETNAME;
    private EditText ETEMAIL1;
    private EditText ETPASSWORD1;
    private EditText ETREPASS;
    private Button BTNSAVE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ETNAME= (EditText) findViewById(R.id.ETNAME);
        ETEMAIL1=(EditText) findViewById(R.id.ETEMAIL1);
        ETPASSWORD1=(EditText) findViewById(R.id.ETPASSWORD1);
        ETREPASS=(EditText) findViewById(R.id.ETREPASS);
        BTNSAVE=(Button) findViewById(R.id.BTNSAVE);
    }
}
