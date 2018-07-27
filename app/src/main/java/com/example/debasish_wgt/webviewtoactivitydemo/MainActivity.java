package com.example.debasish_wgt.webviewtoactivitydemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn_pay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_pay = findViewById(R.id.btn_pay);
        btn_pay.setOnClickListener(view->{
            startActivity(new Intent(MainActivity.this, PaymentActivity.class));
        });
    }
}
