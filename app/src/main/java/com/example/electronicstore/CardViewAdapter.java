package com.example.electronicstore;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.ViewHolder> {

    private Listener listener;
   List<String> Icategory, Iname, Iprice, Idescription, IresourceId, Istar;

    interface Listener {
        void onClick(int position);
        void onUpdateClick(int position);

    }

    public void setListener(Listener listener){

        this.listener = listener;
    }

    public CardViewAdapter(List<String> icategory, List<String> iname, List<String> iprice, List<String> idescription, List<String> iresourceId, List<String> istar) {

        Icategory = icategory;
        Iname = iname;
        Iprice = iprice;
        Idescription = idescription;
        IresourceId = iresourceId;
        this.Istar=istar;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new ViewHolder(inflater,parent);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.textname.setText(Iname.get(position));
        holder.textprice.setText(Iprice.get(position));

        Drawable drawable = ContextCompat.getDrawable(holder.cardView.getContext(), Integer.parseInt(IresourceId.get(position)));

        holder.imageview.setImageDrawable(drawable);
        holder.imageview.setContentDescription((CharSequence) Iname.get(position));
        holder.star.setRating(Float.parseFloat(Istar.get(position)));

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onClick(holder.getAdapterPosition());
                }
            }
        });

        holder.star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onUpdateClick(holder.getAdapterPosition());
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return Iname.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;
        private TextView textname;
        private ImageView imageview;
        private TextView textprice;
        private RatingBar star;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public ViewHolder(LayoutInflater inflater, ViewGroup container){
            super(inflater.inflate(R.layout.card_view,container,false));
            imageview = itemView.findViewById(R.id.image);
            cardView=itemView.findViewById(R.id.card_view);
            textprice=itemView.findViewById(R.id.itemPrice);
            textname=itemView.findViewById(R.id.itemName);
            star=itemView.findViewById(R.id.ratingstar);


        }

    }
}
