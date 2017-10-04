package com.klaib.adham.adhamshoppinglist;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity implements View.OnClickListener {
    public static final String PREF_FILE_NAME = "AdhamPref";
    private EditText ETEMAIL;
    private EditText ETPASSWPRD;
    private Button BTNLOGIN;
    private Button BTNSIGNUP;
    private Button BTNFORGETPASS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in);
        ETEMAIL = (EditText) findViewById(R.id.ETEMAIL);
        ETPASSWPRD = (EditText) findViewById(R.id.ETPASSWORD);
        BTNLOGIN = (Button) findViewById(R.id.BTNLOGIN);
        BTNFORGETPASS = (Button) findViewById(R.id.BTNFORGETPASS);
        BTNSIGNUP = (Button) findViewById(R.id.BTNSIGNUP);
    }

    @Override
    public void onClick(View view) {
        if (BTNLOGIN == view) {
            SharedPreferences prefs = getSharedPreferences(login.PREF_FILE_NAME, MODE_PRIVATE);
            String user = prefs.getString("user", null);
            String passw = prefs.getString("passw", null);
            if (user != null || passw != null) {
                Toast.makeText(this, "Succsfully logged", Toast.LENGTH_SHORT).show();
                finish();1
            }
        }
    }
}
