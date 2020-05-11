package com.bluohazard.spk_pemilihan_tahsin_kota_malang_apps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
    }

    public void onClickMain(View view) {
        Intent i = new Intent(ResultActivity.this, MainActivity.class);
        startActivity(i);
    }
}
