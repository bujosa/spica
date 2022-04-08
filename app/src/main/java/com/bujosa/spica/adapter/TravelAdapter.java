package com.bujosa.spica.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bujosa.spica.R;

import com.bujosa.spica.entity.Travel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TravelAdapter extends RecyclerView.Adapter<TravelAdapter.ViewHolder>{

    private List<Travel> travelList;

    public TravelAdapter(List<Travel> travelList){
        this.travelList = travelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context= parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View travelView = layoutInflater.inflate(R.layout.list_element, parent, false);
        return new ViewHolder(travelView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Travel travel = travelList.get(position);
        holder.textView.setText(travel.getTitle());
        if(travel.getFavorite()) {
            holder.button.setBackground(Drawable.createFromPath("@drawable/ic_favorite_red_24"));
        } else {
            holder.button.setBackground(Drawable.createFromPath("@drawable/ic_favorite_shadow_24"));
        }
        Picasso.get()
                .load(travel.getImage())
                .placeholder(android.R.drawable.ic_dialog_map)
                .error(android.R.drawable.ic_dialog_alert)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return travelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textView;
        public ImageView imageView;
        public Button button;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            button=itemView.findViewById(R.id.itemFavoriteButton);
            textView=itemView.findViewById(R.id.itemTextView);
            imageView=itemView.findViewById(R.id.itemImageView);
        }
    }
}
