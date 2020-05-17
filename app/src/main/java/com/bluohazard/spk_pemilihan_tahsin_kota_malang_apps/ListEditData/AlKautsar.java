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

import java.text.DecimalFormat;

public class AlKautsar extends AppCompatActivity {

    double nilaiKriteriaBiaya;
    double nilaiKriteriaFasilitas;
    double nilaiKriteriaJarak;
    double nilaiKriteriaLamaPendidikan;
    double nilaiKriteriaProgramPembelajaran;
    double nilaiKriteriaSistemKeamanan;

    double nilaiBiayaAlInsan;
    double nilaiFasilitasAlInsan;
    double nilaiJarakAlInsan;
    double nilaiLamaPendidikanAlInsan;
    double nilaiProgramPembelajaranAlInsan;
    double nilaiSistemKeamananAlInsan;

    double nilaiBiayaAlKautsar;
    double nilaiFasilitasAlKautsar;
    double nilaiJarakAlKautsar;
    double nilaiLamaPendidikanAlKautsar;
    double nilaiProgramPembelajaranAlKautsar;
    double nilaiSistemKeamananAlKautsar;

    double nilaiBiayaAlMuhajirin;
    double nilaiFasilitasAlMuhajirin;
    double nilaiJarakAlMuhajirin;
    double nilaiLamaPendidikanAlMuhajirin;
    double nilaiProgramPembelajaranAlMuhajirin;
    double nilaiSistemKeamananAlMuhajirin;

    double nilaiBiayaAlMujib;
    double nilaiFasilitasAlMujib;
    double nilaiJarakAlMujib;
    double nilaiLamaPendidikanAlMujib;
    double nilaiProgramPembelajaranAlMujib;
    double nilaiSistemKeamananAlMujib;

    double nilaiBiayaAlMunawaroh;
    double nilaiFasilitasAlMunawaroh;
    double nilaiJarakAlMunawaroh;
    double nilaiLamaPendidikanAlMunawaroh;
    double nilaiProgramPembelajaranAlMunawaroh;
    double nilaiSistemKeamananAlMunawaroh;

    // Get a reference to our posts
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference("rank").child("al-insan").child("alternatif");
    DatabaseReference ref2 = database.getReference("rank").child("al-kautsar").child("alternatif");
    DatabaseReference ref3 = database.getReference("rank").child("al-muhajirin").child("alternatif");
    DatabaseReference ref4 = database.getReference("rank").child("al-mujib").child("alternatif");
    DatabaseReference ref5 = database.getReference("rank").child("al-munawaroh").child("alternatif");

    private DatabaseReference mDatabase;

    EditText edtTextSistemKeamanan, edtTextLamaPendidikan, edtTextJarak, edtTextFasilitas, edtTextBiaya, edtTextProgramPembelajaran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_al_insan);

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

                nilaiBiayaAlInsan = tahsin.biaya;
                nilaiFasilitasAlInsan = tahsin.fasilitas;
                nilaiJarakAlInsan = tahsin.jarak;
                nilaiLamaPendidikanAlInsan = tahsin.lama_pendidikan;
                nilaiProgramPembelajaranAlInsan = tahsin.program_pembelajaran;
                nilaiSistemKeamananAlInsan = tahsin.sistem_keamanan;
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        mDatabase = FirebaseDatabase.getInstance().getReference();

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                nilaiKriteriaBiaya = dataSnapshot.child("kriteria").child("biaya-pembelajaran").getValue(Double.class);
                nilaiKriteriaFasilitas = dataSnapshot.child("kriteria").child("fasilitas").getValue(Double.class);
                nilaiKriteriaJarak = dataSnapshot.child("kriteria").child("jarak").getValue(Double.class);
                nilaiKriteriaLamaPendidikan = dataSnapshot.child("kriteria").child("lama-pendidikan").getValue(Double.class);
                nilaiKriteriaProgramPembelajaran = dataSnapshot.child("kriteria").child("program-pembelajaran").getValue(Double.class);
                nilaiKriteriaSistemKeamanan = dataSnapshot.child("kriteria").child("sistem-keamanan").getValue(Double.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        // Al-Kautsar
        ref2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Tahsin tahsin = dataSnapshot.getValue(Tahsin.class);

                nilaiBiayaAlKautsar = tahsin.biaya;
                nilaiFasilitasAlKautsar = tahsin.fasilitas;
                nilaiJarakAlKautsar = tahsin.jarak;
                nilaiLamaPendidikanAlKautsar = tahsin.lama_pendidikan;
                nilaiProgramPembelajaranAlKautsar = tahsin.program_pembelajaran;
                nilaiSistemKeamananAlKautsar = tahsin.sistem_keamanan;
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        // Al-Muhajirin
        ref3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Tahsin tahsin = dataSnapshot.getValue(Tahsin.class);

                nilaiBiayaAlMuhajirin = tahsin.biaya;
                nilaiFasilitasAlMuhajirin = tahsin.fasilitas;
                nilaiJarakAlMuhajirin = tahsin.jarak;
                nilaiLamaPendidikanAlMuhajirin = tahsin.lama_pendidikan;
                nilaiProgramPembelajaranAlMuhajirin = tahsin.program_pembelajaran;
                nilaiSistemKeamananAlMuhajirin = tahsin.sistem_keamanan;
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        // Al-Mujib
        ref4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Tahsin tahsin = dataSnapshot.getValue(Tahsin.class);

                nilaiBiayaAlMujib = tahsin.biaya;
                nilaiFasilitasAlMujib = tahsin.fasilitas;
                nilaiJarakAlMujib = tahsin.jarak;
                nilaiLamaPendidikanAlMujib = tahsin.lama_pendidikan;
                nilaiProgramPembelajaranAlMujib = tahsin.program_pembelajaran;
                nilaiSistemKeamananAlMujib = tahsin.sistem_keamanan;
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        // Al-Munawaroh
        ref5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Tahsin tahsin = dataSnapshot.getValue(Tahsin.class);

                nilaiBiayaAlMunawaroh = tahsin.biaya;
                nilaiFasilitasAlMunawaroh = tahsin.fasilitas;
                nilaiJarakAlMunawaroh = tahsin.jarak;
                nilaiLamaPendidikanAlMunawaroh = tahsin.lama_pendidikan;
                nilaiProgramPembelajaranAlMunawaroh = tahsin.program_pembelajaran;
                nilaiSistemKeamananAlMunawaroh = tahsin.sistem_keamanan;
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void onClickListData(View view) {
        Intent i = new Intent(AlKautsar.this, EditDataActivity.class);
        startActivity(i);
    }

    public void perhitungan() {

        double alMunawaroh[] = {nilaiSistemKeamananAlMunawaroh, nilaiLamaPendidikanAlMunawaroh, nilaiJarakAlMunawaroh, nilaiFasilitasAlMunawaroh, nilaiBiayaAlMunawaroh, nilaiProgramPembelajaranAlMunawaroh};
        double alInsan[] = {nilaiSistemKeamananAlInsan, nilaiLamaPendidikanAlInsan, nilaiJarakAlInsan, nilaiFasilitasAlInsan, nilaiBiayaAlInsan, nilaiProgramPembelajaranAlInsan};
        double alMujib[] = {nilaiSistemKeamananAlMujib, nilaiLamaPendidikanAlMujib, nilaiJarakAlMujib, nilaiFasilitasAlMujib, nilaiBiayaAlMujib, nilaiProgramPembelajaranAlMujib};
        double alMuhajirin[] = {nilaiSistemKeamananAlMuhajirin, nilaiLamaPendidikanAlMuhajirin, nilaiJarakAlMuhajirin, nilaiFasilitasAlMuhajirin, nilaiBiayaAlMuhajirin, nilaiProgramPembelajaranAlMuhajirin};
        double alKautsar[] = {nilaiSistemKeamananAlKautsar, nilaiLamaPendidikanAlKautsar, nilaiJarakAlKautsar, nilaiFasilitasAlKautsar, nilaiBiayaAlKautsar, nilaiProgramPembelajaranAlKautsar};

        // Biaya Pembelajaran, Sistem Keamanan, Lama Pendidikan, Jarak, Fasilitas, Program Pembelajaran
        double bobot[] = {nilaiKriteriaSistemKeamanan, nilaiKriteriaLamaPendidikan, nilaiKriteriaJarak, nilaiKriteriaFasilitas, nilaiKriteriaBiaya, nilaiKriteriaProgramPembelajaran};

        // Tahap 1 - Menentukan Skor Ternormalisasi

        double r_alMunawaroh[] = new double[6];
        double r_alInsan[] = new double[6];
        double r_alMujib[] = new double[6];
        double r_alMuhajirin[] = new double[6];
        double r_alKautsar[] = new double[6];

        DecimalFormat digit = new DecimalFormat("0.000");

        for (int x = 0; x < 6; x++) {
            r_alMunawaroh[x] =
                    alMunawaroh[x] / Math.sqrt(
                            (alMunawaroh[x] * alMunawaroh[x]) +
                                    (alInsan[x] * alInsan[x]) +
                                    (alMujib[x] * alMujib[x]) +
                                    (alMuhajirin[x] * alMuhajirin[x]) +
                                    (alKautsar[x] * alKautsar[x]));
        }

        for (int x = 0; x < 6; x++) {
            r_alInsan[x] =
                    alInsan[x] / Math.sqrt(
                            (alMunawaroh[x] * alMunawaroh[x]) +
                                    (alInsan[x] * alInsan[x]) +
                                    (alMujib[x] * alMujib[x]) +
                                    (alMuhajirin[x] * alMuhajirin[x]) +
                                    (alKautsar[x] * alKautsar[x]));
        }

        for (int x = 0; x < 6; x++) {
            r_alMujib[x] =
                    alMujib[x] / Math.sqrt(
                            (alMunawaroh[x] * alMunawaroh[x]) +
                                    (alInsan[x] * alInsan[x]) +
                                    (alMujib[x] * alMujib[x]) +
                                    (alMuhajirin[x] * alMuhajirin[x]) +
                                    (alKautsar[x] * alKautsar[x]));
        }

        for (int x = 0; x < 6; x++) {
            r_alMuhajirin[x] =
                    alMuhajirin[x] / Math.sqrt(
                            (alMunawaroh[x] * alMunawaroh[x]) +
                                    (alInsan[x] * alInsan[x]) +
                                    (alMujib[x] * alMujib[x]) +
                                    (alMuhajirin[x] * alMuhajirin[x]) +
                                    (alKautsar[x] * alKautsar[x]));
        }

        for (int x = 0; x < 6; x++) {
            r_alKautsar[x] =
                    alKautsar[x] / Math.sqrt(
                            (alMunawaroh[x] * alMunawaroh[x]) +
                                    (alInsan[x] * alInsan[x]) +
                                    (alMujib[x] * alMujib[x]) +
                                    (alMuhajirin[x] * alMuhajirin[x]) +
                                    (alKautsar[x] * alKautsar[x]));
        }

        // Tahap 2 - Menentukan Skor Ternormalisasi Terbobot

        double r_bobot_alMunawaroh[] = new double[6];
        double r_bobot_alInsan[] = new double[6];
        double r_bobot_alMujib[] = new double[6];
        double r_bobot_alMuhajirin[] = new double[6];
        double r_bobot_alKautsar[] = new double[6];

        for (int x = 0; x < 6; x++)
            r_bobot_alMunawaroh[x] = r_alMunawaroh[x] * bobot[x];

        for (int x = 0; x < 6; x++)
            r_bobot_alInsan[x] = r_alInsan[x] * bobot[x];

        for (int x = 0; x < 6; x++)
            r_bobot_alMujib[x] = r_alMujib[x] * bobot[x];

        for (int x = 0; x < 6; x++)
            r_bobot_alMuhajirin[x] = r_alMuhajirin[x] * bobot[x];

        for (int x = 0; x < 6; x++)
            r_bobot_alKautsar[x] = r_alKautsar[x] * bobot[x];

        double a_positif[] = new double[6];
        double a_negatif[] = {1, 1, 1, 1, 1, 1};

        for (int x = 0; x < 6; x++) {
            // Cari yang Positif / MAX

            if (x == 2 || x == 4) // Cost
            {
                a_positif[x] = r_bobot_alMunawaroh[x];

                if (a_positif[x] > r_bobot_alMunawaroh[x])
                    a_positif[x] = r_bobot_alMunawaroh[x];

                if (a_positif[x] > r_bobot_alInsan[x])
                    a_positif[x] = r_bobot_alInsan[x];

                if (a_positif[x] > r_bobot_alMujib[x])
                    a_positif[x] = r_bobot_alMujib[x];

                if (a_positif[x] > r_bobot_alMuhajirin[x])
                    a_positif[x] = r_bobot_alMuhajirin[x];

                if (a_positif[x] > r_bobot_alKautsar[x])
                    a_positif[x] = r_bobot_alKautsar[x];

                a_negatif[x] = r_bobot_alMunawaroh[x];

                if (a_negatif[x] < r_bobot_alMunawaroh[x])
                    a_negatif[x] = r_bobot_alMunawaroh[x];

                if (a_negatif[x] < r_bobot_alInsan[x])
                    a_negatif[x] = r_bobot_alInsan[x];

                if (a_negatif[x] < r_bobot_alMujib[x])
                    a_negatif[x] = r_bobot_alMujib[x];

                if (a_negatif[x] < r_bobot_alMuhajirin[x])
                    a_negatif[x] = r_bobot_alMuhajirin[x];

                if (a_negatif[x] < r_bobot_alKautsar[x])
                    a_negatif[x] = r_bobot_alKautsar[x];
            } else // Benefit
            {
                if (a_positif[x] < r_bobot_alMunawaroh[x])
                    a_positif[x] = r_bobot_alMunawaroh[x];

                if (a_positif[x] < r_bobot_alInsan[x])
                    a_positif[x] = r_bobot_alInsan[x];

                if (a_positif[x] < r_bobot_alMujib[x])
                    a_positif[x] = r_bobot_alMujib[x];

                if (a_positif[x] < r_bobot_alMuhajirin[x])
                    a_positif[x] = r_bobot_alMuhajirin[x];

                if (a_positif[x] < r_bobot_alKautsar[x])
                    a_positif[x] = r_bobot_alKautsar[x];

                // Cari yang negatif

                if (a_negatif[x] > r_bobot_alMunawaroh[x])
                    a_negatif[x] = r_bobot_alMunawaroh[x];

                if (a_negatif[x] > r_bobot_alInsan[x])
                    a_negatif[x] = r_bobot_alInsan[x];

                if (a_negatif[x] > r_bobot_alMujib[x])
                    a_negatif[x] = r_bobot_alMujib[x];

                if (a_negatif[x] > r_bobot_alMuhajirin[x])
                    a_negatif[x] = r_bobot_alMuhajirin[x];

                if (a_negatif[x] > r_bobot_alKautsar[x])
                    a_negatif[x] = r_bobot_alKautsar[x];
            }
        }

        // solusi ideal positif

        double d1_positif = Math.sqrt(
                ((a_positif[0] - r_bobot_alMunawaroh[0]) * (a_positif[0] - r_bobot_alMunawaroh[0]))
                        + ((a_positif[1] - r_bobot_alMunawaroh[1]) * (a_positif[1] - r_bobot_alMunawaroh[1]))
                        + ((a_positif[2] - r_bobot_alMunawaroh[2]) * (a_positif[2] - r_bobot_alMunawaroh[2]))
                        + ((a_positif[3] - r_bobot_alMunawaroh[3]) * (a_positif[3] - r_bobot_alMunawaroh[3]))
                        + ((a_positif[4] - r_bobot_alMunawaroh[4]) * (a_positif[4] - r_bobot_alMunawaroh[4]))
                        + ((a_positif[5] - r_bobot_alMunawaroh[5]) * (a_positif[5] - r_bobot_alMunawaroh[5])));

        double d2_positif = Math.sqrt(
                ((a_positif[0] - r_bobot_alInsan[0]) * (a_positif[0] - r_bobot_alInsan[0]))
                        + ((a_positif[1] - r_bobot_alInsan[1]) * (a_positif[1] - r_bobot_alInsan[1]))
                        + ((a_positif[2] - r_bobot_alInsan[2]) * (a_positif[2] - r_bobot_alInsan[2]))
                        + ((a_positif[3] - r_bobot_alInsan[3]) * (a_positif[3] - r_bobot_alInsan[3]))
                        + ((a_positif[4] - r_bobot_alInsan[4]) * (a_positif[4] - r_bobot_alInsan[4]))
                        + ((a_positif[5] - r_bobot_alInsan[5]) * (a_positif[5] - r_bobot_alInsan[5])));

        double d3_positif = Math.sqrt(
                ((a_positif[0] - r_bobot_alMujib[0]) * (a_positif[0] - r_bobot_alMujib[0]))
                        + ((a_positif[1] - r_bobot_alMujib[1]) * (a_positif[1] - r_bobot_alMujib[1]))
                        + ((a_positif[2] - r_bobot_alMujib[2]) * (a_positif[2] - r_bobot_alMujib[2]))
                        + ((a_positif[3] - r_bobot_alMujib[3]) * (a_positif[3] - r_bobot_alMujib[3]))
                        + ((a_positif[4] - r_bobot_alMujib[4]) * (a_positif[4] - r_bobot_alMujib[4]))
                        + ((a_positif[5] - r_bobot_alMujib[5]) * (a_positif[5] - r_bobot_alMujib[5])));

        double d4_positif = Math.sqrt(
                ((a_positif[0] - r_bobot_alMuhajirin[0]) * (a_positif[0] - r_bobot_alMuhajirin[0]))
                        + ((a_positif[1] - r_bobot_alMuhajirin[1]) * (a_positif[1] - r_bobot_alMuhajirin[1]))
                        + ((a_positif[2] - r_bobot_alMuhajirin[2]) * (a_positif[2] - r_bobot_alMuhajirin[2]))
                        + ((a_positif[3] - r_bobot_alMuhajirin[3]) * (a_positif[3] - r_bobot_alMuhajirin[3]))
                        + ((a_positif[4] - r_bobot_alMuhajirin[4]) * (a_positif[4] - r_bobot_alMuhajirin[4]))
                        + ((a_positif[5] - r_bobot_alMuhajirin[5]) * (a_positif[5] - r_bobot_alMuhajirin[5])));

        double d5_positif = Math.sqrt(
                ((a_positif[0] - r_bobot_alKautsar[0]) * (a_positif[0] - r_bobot_alKautsar[0]))
                        + ((a_positif[1] - r_bobot_alKautsar[1]) * (a_positif[1] - r_bobot_alKautsar[1]))
                        + ((a_positif[2] - r_bobot_alKautsar[2]) * (a_positif[2] - r_bobot_alKautsar[2]))
                        + ((a_positif[3] - r_bobot_alKautsar[3]) * (a_positif[3] - r_bobot_alKautsar[3]))
                        + ((a_positif[4] - r_bobot_alKautsar[4]) * (a_positif[4] - r_bobot_alKautsar[4]))
                        + ((a_positif[5] - r_bobot_alKautsar[5]) * (a_positif[5] - r_bobot_alKautsar[5])));

        // solusi ideal negatif

        double d1_negatif = Math.sqrt(
                ((r_bobot_alMunawaroh[0] - a_negatif[0]) * (r_bobot_alMunawaroh[0] - a_negatif[0]))
                        + ((r_bobot_alMunawaroh[1] - a_negatif[1]) * (r_bobot_alMunawaroh[1] - a_negatif[1]))
                        + ((r_bobot_alMunawaroh[2] - a_negatif[2]) * (r_bobot_alMunawaroh[2] - a_negatif[2]))
                        + ((r_bobot_alMunawaroh[3] - a_negatif[3]) * (r_bobot_alMunawaroh[3] - a_negatif[3]))
                        + ((r_bobot_alMunawaroh[4] - a_negatif[4]) * (r_bobot_alMunawaroh[4] - a_negatif[4]))
                        + ((r_bobot_alMunawaroh[5] - a_negatif[5]) * (r_bobot_alMunawaroh[5] - a_negatif[5])));

        double d2_negatif = Math.sqrt(
                ((r_bobot_alInsan[0] - a_negatif[0]) * (r_bobot_alInsan[0] - a_negatif[0]))
                        + ((r_bobot_alInsan[1] - a_negatif[1]) * (r_bobot_alInsan[1] - a_negatif[1]))
                        + ((r_bobot_alInsan[2] - a_negatif[2]) * (r_bobot_alInsan[2] - a_negatif[2]))
                        + ((r_bobot_alInsan[3] - a_negatif[3]) * (r_bobot_alInsan[3] - a_negatif[3]))
                        + ((r_bobot_alInsan[4] - a_negatif[4]) * (r_bobot_alInsan[4] - a_negatif[4]))
                        + ((r_bobot_alInsan[5] - a_negatif[5]) * (r_bobot_alInsan[5] - a_negatif[5])));

        double d3_negatif = Math.sqrt(
                ((r_bobot_alMujib[0] - a_negatif[0]) * (r_bobot_alMujib[0] - a_negatif[0]))
                        + ((r_bobot_alMujib[1] - a_negatif[1]) * (r_bobot_alMujib[1] - a_negatif[1]))
                        + ((r_bobot_alMujib[2] - a_negatif[2]) * (r_bobot_alMujib[2] - a_negatif[2]))
                        + ((r_bobot_alMujib[3] - a_negatif[3]) * (r_bobot_alMujib[3] - a_negatif[3]))
                        + ((r_bobot_alMujib[4] - a_negatif[4]) * (r_bobot_alMujib[4] - a_negatif[4]))
                        + ((r_bobot_alMujib[5] - a_negatif[5]) * (r_bobot_alMujib[5] - a_negatif[5])));

        double d4_negatif = Math.sqrt(
                ((r_bobot_alMuhajirin[0] - a_negatif[0]) * (r_bobot_alMuhajirin[0] - a_negatif[0]))
                        + ((r_bobot_alMuhajirin[1] - a_negatif[1]) * (r_bobot_alMuhajirin[1] - a_negatif[1]))
                        + ((r_bobot_alMuhajirin[2] - a_negatif[2]) * (r_bobot_alMuhajirin[2] - a_negatif[2]))
                        + ((r_bobot_alMuhajirin[3] - a_negatif[3]) * (r_bobot_alMuhajirin[3] - a_negatif[3]))
                        + ((r_bobot_alMuhajirin[4] - a_negatif[4]) * (r_bobot_alMuhajirin[4] - a_negatif[4]))
                        + ((r_bobot_alMuhajirin[5] - a_negatif[5]) * (r_bobot_alMuhajirin[5] - a_negatif[5])));

        double d5_negatif = Math.sqrt(
                ((r_bobot_alKautsar[0] - a_negatif[0]) * (r_bobot_alKautsar[0] - a_negatif[0]))
                        + ((r_bobot_alKautsar[1] - a_negatif[1]) * (r_bobot_alKautsar[1] - a_negatif[1]))
                        + ((r_bobot_alKautsar[2] - a_negatif[2]) * (r_bobot_alKautsar[2] - a_negatif[2]))
                        + ((r_bobot_alKautsar[3] - a_negatif[3]) * (r_bobot_alKautsar[3] - a_negatif[3]))
                        + ((r_bobot_alKautsar[4] - a_negatif[4]) * (r_bobot_alKautsar[4] - a_negatif[4]))
                        + ((r_bobot_alKautsar[5] - a_negatif[5]) * (r_bobot_alKautsar[5] - a_negatif[5])));

        double skorAkhirAlMunawaroh = d1_negatif / (d1_negatif + d1_positif);
        double skorAkhirAlInsan = d2_negatif / (d2_negatif + d2_positif);
        double skorAkhirAlMujib = d3_negatif / (d3_negatif + d3_positif);
        double skorAkhirAlMuhajirin = d4_negatif / (d4_negatif + d4_positif);
        double skorAkhirAlKautsar = d5_negatif / (d5_negatif + d5_positif);

        String skorAkhirAlMunawarohFix = digit.format(skorAkhirAlMunawaroh);
        String skorAkhirAlInsanFix = digit.format(skorAkhirAlInsan);
        String skorAkhirAlMujibFix = digit.format(skorAkhirAlMujib);
        String skorAkhirAlMuhajirinFix = digit.format(skorAkhirAlMuhajirin);
        String skorAkhirAlKautsarFix = digit.format(skorAkhirAlKautsar);

        mDatabase.child("rank").child("al-insan").child("skor").setValue(Double.parseDouble(skorAkhirAlInsanFix));
        mDatabase.child("rank").child("al-munawaroh").child("skor").setValue(Double.parseDouble(skorAkhirAlMunawarohFix));
        mDatabase.child("rank").child("al-mujib").child("skor").setValue(Double.parseDouble(skorAkhirAlMujibFix));
        mDatabase.child("rank").child("al-muhajirin").child("skor").setValue(Double.parseDouble(skorAkhirAlMuhajirinFix));
        mDatabase.child("rank").child("al-kautsar").child("skor").setValue(Double.parseDouble(skorAkhirAlKautsarFix));
    }

    public void onClickUpdateData(View view) {
        ref.child("sistem_keamanan").setValue(Integer.parseInt(edtTextSistemKeamanan.getText().toString()));
        ref.child("lama_pendidikan").setValue(Integer.parseInt(edtTextLamaPendidikan.getText().toString()));
        ref.child("jarak").setValue(Integer.parseInt(edtTextJarak.getText().toString()));
        ref.child("fasilitas").setValue(Integer.parseInt(edtTextFasilitas.getText().toString()));
        ref.child("biaya").setValue(Integer.parseInt(edtTextBiaya.getText().toString()));
        ref.child("program_pembelajaran").setValue(Integer.parseInt(edtTextProgramPembelajaran.getText().toString()));

        perhitungan();

        Toast.makeText(this, "Update data berhasil!", Toast.LENGTH_LONG).show();
    }
}
