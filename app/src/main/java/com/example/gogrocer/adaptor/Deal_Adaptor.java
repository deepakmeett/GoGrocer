package com.example.gogrocer.adaptor;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gogrocer.R;
import com.example.gogrocer.api.Api;
import com.example.gogrocer.model.Deal_Model;
import com.example.gogrocer.model.Top_Selling_Model;
import com.squareup.picasso.Picasso;

import java.util.List;
public class Deal_Adaptor extends RecyclerView.Adapter<Deal_Adaptor.ViewHolder> {
    
    Context context;
    List<Deal_Model.Datum> list;

    int num = 1;

    public Deal_Adaptor(Context context, List<Deal_Model.Datum> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Deal_Adaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from( context );
        View view = layoutInflater.inflate( R.layout.items_top_selling, parent, false );
        return new ViewHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull final Deal_Adaptor.ViewHolder holder, int position) {
        Deal_Model.Datum model = list.get( position );
        if (model.getProductName()!=null){
            holder.productName.setText( model.getProductName() );
        }

        if (model.getPrice() != null){
            holder.price.setText( "Rs. " + model.getPrice() );
        }

        if (model.getPrice() != null){
            holder.rs.setText( "Rs. " + model.getMrp() );
        }

        if (model.getQuantity()!= null){
            holder.days.setText( model.getQuantity() );
        }

        if (model.getUnit() != null){
            holder.unit.setText( model.getUnit() );
        }

        if (model.getProductId() != null){
            holder.types.setText( model.getProductId());
        }


        if (model.getProductImage() != null) {
            String imageUri = Api.IMAGE_URL;
            Picasso.get()
                    .load( imageUri + model.getProductImage() )
                    .fit()
                    .into( holder.imageView );
        }
        
        holder.addBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num++;
                holder.removeBtn.setVisibility( View.VISIBLE );
                if (num == 1){
                    holder.result.setText( "x2" );
                }else {
                    holder.result.setText( "x" + num );
                }
            }
        } );
        
        
        holder.removeBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num--;
                holder.result.setText( "x" + num );
                if (num == 1){
                    holder.result.setText( "ADD" );
                    holder.removeBtn.setVisibility( View.INVISIBLE );
                }
            }
        } );
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView, removeBtn, addBtn;
        TextView productName, types, days, unit, rs, price, result;
        Spinner spinner;

        public ViewHolder(@NonNull View itemView) {
            super( itemView );
            imageView = itemView.findViewById( R.id.topImage );
            removeBtn = itemView.findViewById( R.id.removeBtn );
            addBtn = itemView.findViewById( R.id.addBtn );
            productName = itemView.findViewById( R.id.productName );
            types = itemView.findViewById( R.id.types );
            unit = itemView.findViewById( R.id.units );
            days = itemView.findViewById( R.id.days );
            rs = itemView.findViewById( R.id.rs );
            price = itemView.findViewById( R.id.price );
            result = itemView.findViewById( R.id.result );
//            spinner = itemView.findViewById( R.id.units_spinner );
        }
    }
}
