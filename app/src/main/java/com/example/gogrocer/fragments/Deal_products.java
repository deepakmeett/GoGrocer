package com.example.gogrocer.fragments;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.gogrocer.R;
import com.example.gogrocer.adaptor.Deal_Adaptor;
import com.example.gogrocer.adaptor.Top_Selling_Adaptor;
import com.example.gogrocer.api.Api;
import com.example.gogrocer.model.Deal_Model;
import com.example.gogrocer.model.Top_Selling_Model;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
/**
 * A simple {@link Fragment} subclass.
 */
public class Deal_products extends Fragment {
    
    RecyclerView recyclerView;

    public Deal_products() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate( R.layout.fragment_deal_products, container, false );
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated( view, savedInstanceState );
        recyclerView = view.findViewById( R.id.deal_recycler );
        recyclerView.setHasFixedSize( true );
        recyclerView.setLayoutManager( new LinearLayoutManager( getContext() ) );


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl( Api.BASE_URL )
                .addConverterFactory( GsonConverterFactory.create() )
                .build();


        Api api = retrofit.create( Api.class );
        final Call<Deal_Model> call = api.getdeal();
        
        call.enqueue( new Callback<Deal_Model>() {
            @Override
            public void onResponse(Call<Deal_Model> call, Response<Deal_Model> response) {
                Deal_Model list = response.body();
                recyclerView.setAdapter( new Deal_Adaptor( getActivity(), list.getData() ) );
            }

            @Override
            public void onFailure(Call<Deal_Model> call, Throwable t) {
                Toast.makeText( getActivity(), t.getMessage(), Toast.LENGTH_SHORT ).show();
            }
        } );

        
    }
}
