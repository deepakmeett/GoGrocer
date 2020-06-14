package com.example.gogrocer.adaptor;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gogrocer.api.Api;
import com.example.gogrocer.model.Banner_Model;
import com.example.gogrocer.R;
import com.squareup.picasso.Picasso;

import java.util.List;
public class Banner_Adaptor extends RecyclerView.Adapter<Banner_Adaptor.ViewHolder> {

    Context context;
    List<Banner_Model.Datum> list;

    public Banner_Adaptor(Context context, List<Banner_Model.Datum> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Banner_Adaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from( context );
        View view = layoutInflater.inflate( R.layout.item_banner, parent, false );
        return new ViewHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull Banner_Adaptor.ViewHolder holder, int position) {
        Banner_Model.Datum model = list.get( position );
        
        if (list.get( position ).getBannerId()!=null){
            holder.bannerId.setText( list.get( position ).getBannerId() );
        }
        
        if (list.get( position ).getBannerName() != null){
            holder.bannerName.setText( list.get( position ).getBannerName() );
        }
        
        if (model.getBannerImage()!= null) {
            String imageUri = Api.IMAGE_URL;
            Picasso.get()
                    .load( imageUri + model.getBannerImage() )
                    .fit()
                    .into( holder.bannerImage );
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView bannerImage;
        TextView bannerId, bannerName;

        public ViewHolder(@NonNull View itemView) {
            super( itemView );
            bannerImage = itemView.findViewById( R.id.topImage );
            bannerId = itemView.findViewById( R.id.productName );
            bannerName = itemView.findViewById( R.id.bannerName );
        }
    }
}
