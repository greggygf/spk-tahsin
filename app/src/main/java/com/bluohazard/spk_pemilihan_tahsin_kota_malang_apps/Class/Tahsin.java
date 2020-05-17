package com.bluohazard.spk_pemilihan_tahsin_kota_malang_apps.Class;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class Tahsin {
    public String nama;
    public int sistem_keamanan, lama_pendidikan, jarak, fasilitas, biaya, program_pembelajaran;

    public double skor;

    public Tahsin() {
    }

    public Tahsin(String nama, int sistem_keamanan, int lama_pendidikan, int jarak, int fasilitas, int biaya, int program_pembelajaran, double skor) {
        this.nama = nama;
        this.sistem_keamanan = sistem_keamanan;
        this.lama_pendidikan = lama_pendidikan;
        this.jarak = jarak;
        this.fasilitas = fasilitas;
        this.biaya = biaya;
        this.program_pembelajaran = program_pembelajaran;
        this.skor = skor;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("nama", nama);
        result.put("sistem_ keamanan", sistem_keamanan);
        result.put("lama-pendidikan", lama_pendidikan);
        result.put("jarak", jarak);
        result.put("fasilitas", fasilitas);
        result.put("biaya", biaya);
        result.put("program-pembelajaran", program_pembelajaran);
        result.put("skor", skor);
        return result;
    }
}
