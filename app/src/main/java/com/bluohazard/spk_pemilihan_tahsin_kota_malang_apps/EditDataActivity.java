package com.bluohazard.spk_pemilihan_tahsin_kota_malang_apps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.bluohazard.spk_pemilihan_tahsin_kota_malang_apps.ListEditData.AlInsan;
import com.bluohazard.spk_pemilihan_tahsin_kota_malang_apps.ListEditData.AlKautsar;
import com.bluohazard.spk_pemilihan_tahsin_kota_malang_apps.ListEditData.AlMuhajirin;
import com.bluohazard.spk_pemilihan_tahsin_kota_malang_apps.ListEditData.AlMujib;
import com.bluohazard.spk_pemilihan_tahsin_kota_malang_apps.ListEditData.AlMunawaroh;

public class EditDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_data);
    }

    public void onClickMain(View view) {
        Intent i = new Intent(EditDataActivity.this, MainActivity.class);
        startActivity(i);
    }

    public void onClickAlInsan(View view) {
        Intent i = new Intent(EditDataActivity.this, AlInsan.class);
        startActivity(i);
    }

    public void onClickAlKautsar(View view) {
        Intent i = new Intent(EditDataActivity.this, AlKautsar.class);
        startActivity(i);
    }

    public void onClickAlMuhajirin(View view) {
        Intent i = new Intent(EditDataActivity.this, AlMuhajirin.class);
        startActivity(i);
    }

    public void onClickAlMujib(View view) {
        Intent i = new Intent(EditDataActivity.this, AlMujib.class);
        startActivity(i);
    }

    public void onClickAlMunawaroh(View view) {
        Intent i = new Intent(EditDataActivity.this, AlMunawaroh.class);
        startActivity(i);
    }
}
