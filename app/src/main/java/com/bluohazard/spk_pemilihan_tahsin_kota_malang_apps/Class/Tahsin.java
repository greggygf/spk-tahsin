package com.bluohazard.spk_pemilihan_tahsin_kota_malang_apps.Class;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class Tahsin {
    public String nama;
    public double skor;

    public Tahsin() {
    }

    public Tahsin(String nama, double skor) {
        this.nama = nama;
        this.skor = skor;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("nama", nama);
        result.put("skor", skor);
        return result;
    }
}
