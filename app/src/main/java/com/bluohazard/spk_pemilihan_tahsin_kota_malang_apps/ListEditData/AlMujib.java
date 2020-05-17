package com.bluohazard.spk_pemilihan_tahsin_kota_malang_apps.ListEditData;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.bluohazard.spk_pemilihan_tahsin_kota_malang_apps.Class.Tahsin;
import com.bluohazard.spk_pemilihan_tahsin_kota_malang_apps.EditDataActivity;
import com.bluohazard.spk_pemilihan_tahsin_kota_malang_apps.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AlMujib extends AppCompatActivity {

    // Get a reference to our posts
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference("rank").child("al-mujib").child("alternatif");

    EditText edtTextSistemKeamanan, edtTextLamaPendidikan, edtTextJarak, edtTextFasilitas, edtTextBiaya, edtTextProgramPembelajaran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_al_mujib);

        edtTextSistemKeamanan = findViewById(R.id.inputSistemKeamanan);
        edtTextLamaPendidikan = findViewById(R.id.inputLamaPendidikan);
        edtTextJarak = findViewById(R.id.inputJarak);
        edtTextFasilitas = findViewById(R.id.inputFasilitas);
        edtTextBiaya = findViewById(R.id.inputBiaya);
        edtTextProgramPembelajaran = findViewById(R.id.inputPP);

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Tahsin tahsin = dataSnapshot.getValue(Tahsin.class);
                edtTextSistemKeamanan.setText(String.valueOf(tahsin.sistem_keamanan));
                edtTextLamaPendidikan.setText(String.valueOf(tahsin.lama_pendidikan));
                edtTextJarak.setText(String.valueOf(tahsin.jarak));
                edtTextFasilitas.setText(String.valueOf(tahsin.fasilitas));
                edtTextBiaya.setText(String.valueOf(tahsin.biaya));
                edtTextProgramPembelajaran.setText(String.valueOf(tahsin.program_pembelajaran));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void onClickListData(View view) {
        Intent i = new Intent(AlMujib.this, EditDataActivity.class);
        startActivity(i);
    }

    public void onClickUpdateData(View view) {
        ref.child("sistem_keamanan").setValue(Integer.parseInt(edtTextSistemKeamanan.getText().toString()));
        ref.child("lama_pendidikan").setValue(Integer.parseInt(edtTextLamaPendidikan.getText().toString()));
        ref.child("jarak").setValue(Integer.parseInt(edtTextJarak.getText().toString()));
        ref.child("fasilitas").setValue(Integer.parseInt(edtTextFasilitas.getText().toString()));
        ref.child("biaya").setValue(Integer.parseInt(edtTextBiaya.getText().toString()));
        ref.child("program_pembelajaran").setValue(Integer.parseInt(edtTextProgramPembelajaran.getText().toString()));

        Toast.makeText(this, "Data berhasil diupdate!", Toast.LENGTH_SHORT).show();
    }
}
