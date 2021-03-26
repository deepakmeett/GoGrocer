package com.example.gogrocer;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.Toast;

import com.example.gogrocer.adaptor.Banner_Adaptor;
import com.example.gogrocer.api.Api;
import com.example.gogrocer.fragments.New_products;
import com.example.gogrocer.fragments.Deal_products;
import com.example.gogrocer.fragments.Recent_selling;
import com.example.gogrocer.fragments.Top_Selling;
import com.example.gogrocer.model.Banner_Model;
import com.google.android.material.tabs.TabLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ViewPager2 viewPager2;
    TabLayout tabLayout;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        recyclerView = findViewById( R.id.bannerRecycler );
        viewPager2 = findViewById( R.id.view_pager );
        tabLayout = findViewById( R.id.tab_Layout );
        recyclerView.setHasFixedSize( true );
        recyclerView.setLayoutManager( new LinearLayoutManager( this, RecyclerView.HORIZONTAL, false ) );
        
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl( Api.BASE_URL )
                .addConverterFactory( GsonConverterFactory.create() )
                .build();
        Api api = retrofit.create( Api.class );
        final Call<Banner_Model> call = api.getBanner();
        call.enqueue( new Callback<Banner_Model>() {
            @Override
            public void onResponse(Call<Banner_Model> call, Response<Banner_Model> response) {
                Banner_Model list = response.body();
                recyclerView.setAdapter( new Banner_Adaptor( MainActivity.this, list.getData() ) );
            }

            @Override
            public void onFailure(Call<Banner_Model> call, Throwable t) {
                Toast.makeText( MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT ).show();
            }
        } );
        
        viewPager2.setAdapter( new pagerAdaptor( this ) );
        viewPager2.registerOnPageChangeCallback( new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected( position );
                tabLayout.getTabAt( position ).select();
            }
        } );
        tabLayout.addOnTabSelectedListener( new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        viewPager2.setCurrentItem( 0, true );
                        break;
                    case 1:
                        viewPager2.setCurrentItem( 1, true );
                        break;
                    case 2:
                        viewPager2.setCurrentItem( 2, true );
                        break;
                    case 3:
                        viewPager2.setCurrentItem( 3, true );
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        } );
    }

    public static class pagerAdaptor extends FragmentStateAdapter {

        pagerAdaptor(@NonNull FragmentActivity fragmentActivity) {
            super( fragmentActivity );
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position) {
                case 0:
                    return new Top_Selling();
                case 1:
                    return new Recent_selling();
                case 2:
                    return new Deal_products();
                case 3:
                    return new New_products();
            }
            return null;
        }

        @Override
        public int getItemCount() {
            return 4;
        }
    }
}
