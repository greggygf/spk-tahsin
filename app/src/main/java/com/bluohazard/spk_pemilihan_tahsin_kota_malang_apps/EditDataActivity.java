package com.bluohazard.spk_pemilihan_tahsin_kota_malang_apps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.bluohazard.spk_pemilihan_tahsin_kota_malang_apps.Class.Tahsin;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EditDataActivity extends AppCompatActivity {

    // Get a reference to our posts
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference("rank");

    EditText edtTextNamaTahsin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_data);

        edtTextNamaTahsin = findViewById(R.id.inputTitleNamaTempatTahsin1);

        ref.keepSynced(true);

        ref.child("al-insan").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Tahsin tahsin = dataSnapshot.getValue(Tahsin.class);
                edtTextNamaTahsin.setText("" + tahsin.skor);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void onClickMain(View view) {
        Intent i = new Intent(EditDataActivity.this, MainActivity.class);
        startActivity(i);
    }
}
