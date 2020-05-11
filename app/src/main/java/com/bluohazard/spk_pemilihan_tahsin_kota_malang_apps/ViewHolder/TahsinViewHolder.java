package com.bluohazard.spk_pemilihan_tahsin_kota_malang_apps.ViewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bluohazard.spk_pemilihan_tahsin_kota_malang_apps.Class.Tahsin;
import com.bluohazard.spk_pemilihan_tahsin_kota_malang_apps.R;

public class TahsinViewHolder extends RecyclerView.ViewHolder {

    public TextView tvNama;
    public TextView tvSkor;

    public TahsinViewHolder(@NonNull View itemView) {
        super(itemView);
        tvNama = itemView.findViewById(R.id.tv_nama_tempat_tahsin);
        tvSkor = itemView.findViewById(R.id.tv_skor_tempat_tahsin);
    }

    public void bindToTahsin(Tahsin tahsin, View.OnClickListener onClickListener){
        tvNama.setText(tahsin.nama);
        tvSkor.setText(Double.toString(tahsin.skor));
    }
}
