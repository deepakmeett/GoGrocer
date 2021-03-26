package com.example.gogrocer.adaptor;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.gogrocer.Controller;
import com.example.gogrocer.EntriesDataListener;
import com.example.gogrocer.R;
import com.example.gogrocer.model.Banner_Model;
public class MainActivity extends AppCompatActivity implements EntriesDataListener {

    RecyclerView recyclerView;
    Controller controller;
    EntriesDataListener dataListener;
    Banner_Adaptor adaptor;
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main2 );
        dataListener = new MainActivity();
        controller.getAllEntries( this, dataListener );

        recyclerView = findViewById( R.id.banner2Recycler );
        recyclerView.setHasFixedSize( true );
        recyclerView.setLayoutManager( new LinearLayoutManager( this, RecyclerView.HORIZONTAL, false ) );
    }

    @Override
    public void onDetailsFetchedSuccess(Banner_Model dto) {
        recyclerView.setAdapter( new Banner_Adaptor( this, dto.getData() ) );
    }

    @Override
    public void onDetailsFetchedFailure(String msg) {
        Toast.makeText( this, msg, Toast.LENGTH_SHORT ).show();
    }
}