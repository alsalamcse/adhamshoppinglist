package com.klaib.adham.adhamshoppinglist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.klaib.adham.adhamshoppinglist.R;

public class AddItem extends AppCompatActivity {
    private EditText ETNAME;
    private EditText ETAMOUNT;
    private EditText ETUNITS;
    private EditText ETPRICE;
    private Button BTNSAVE;
    private ImageButton IBTNIMAGE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
    }
}
