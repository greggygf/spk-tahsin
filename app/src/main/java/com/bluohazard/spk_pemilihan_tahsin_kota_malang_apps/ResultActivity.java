package com.bluohazard.spk_pemilihan_tahsin_kota_malang_apps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bluohazard.spk_pemilihan_tahsin_kota_malang_apps.Class.Tahsin;
import com.bluohazard.spk_pemilihan_tahsin_kota_malang_apps.ViewHolder.TahsinViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class ResultActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;

    private FirebaseRecyclerAdapter<Tahsin, TahsinViewHolder> mAdapter;
    private RecyclerView mRecycler;
    private LinearLayoutManager mManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        mRecycler = findViewById(R.id.list_rank);
        mRecycler.setHasFixedSize(true);

        mManager = new LinearLayoutManager(this);
        mManager.setReverseLayout(true);
        mManager.setStackFromEnd(true);
        mRecycler.setLayoutManager(mManager);

        // Set up FirebaseRecyclerAdapter with the Query
        Query query = getQuery(mDatabase);

        FirebaseRecyclerOptions options = new FirebaseRecyclerOptions.Builder<Tahsin>()
                .setQuery(query, Tahsin.class)
                .build();

        mAdapter = new FirebaseRecyclerAdapter<Tahsin, TahsinViewHolder>(options) {
            @Override
            public TahsinViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                LayoutInflater inflater = LayoutInflater.from(parent.getContext());
                return new TahsinViewHolder(inflater.inflate(R.layout.item_rank, parent, false));
            }

            @Override
            protected void onBindViewHolder(@NonNull TahsinViewHolder holder, int position, @NonNull final Tahsin model) {
                holder.bindToTahsin(model, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
            }
        };

        mAdapter.notifyDataSetChanged();
        mRecycler.setAdapter(mAdapter);
    }

    @Override
    public void onStart() {
        super.onStart();
        if (mAdapter != null) {
            mAdapter.startListening();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAdapter != null) {
            mAdapter.stopListening();
        }
    }

    private Query getQuery(DatabaseReference mDatabase) {
        Query query = mDatabase.child("rank").orderByChild("skor");
        return query;
    }

    public void onClickMain(View view) {
        Intent i = new Intent(ResultActivity.this, MainActivity.class);
        startActivity(i);
    }
}
