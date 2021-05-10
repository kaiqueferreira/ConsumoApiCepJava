package com.xl.consumoapicepjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.xl.consumoapicepjava.ApiViaJson.MainActivityViaJSON;
import com.xl.consumoapicepjava.ApiViaXmL.MainActivityViaXML;

public class InitActivity extends AppCompatActivity {

    Button btn_simple,btn_xml,btn_json;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init);

        btn_simple = findViewById(R.id.btn_simple);
        btn_xml = findViewById(R.id.btn_xml);
        btn_json = findViewById(R.id.btn_json);



        btn_simple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InitActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        btn_xml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InitActivity.this, MainActivityViaXML.class);
                startActivity(intent);
            }
        });
        btn_json.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InitActivity.this, MainActivityViaJSON.class);
                startActivity(intent);
            }
        });
    }
}