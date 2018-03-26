package com.example.smita.imageslider;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.ViewHolder> {

    private Context mcontext;
    private List<Categories> categoriesList;

    public CategoriesAdapter(Context context, List<Categories> categoriesList) {
        this.mcontext = context;
        this.categoriesList = categoriesList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView foodvariety,foodvarietydetails;
        public ImageView foodImg;
        public CardView cardView,iconCardView;


        public ViewHolder(View itemView) {
            super(itemView);
            foodvariety = (TextView) itemView.findViewById(R.id.foodCategoryTextView);
            foodvarietydetails = (TextView) itemView.findViewById(R.id.foodDescriptionTextView);
            foodImg = (ImageView) itemView.findViewById(R.id.icon);
            cardView = (CardView) itemView.findViewById(R.id.listCardView);
           // iconCardView = (CardView) itemView.findViewById(R.id.iconCardView);


            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // intent to open
                }
            });
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Categories categories=categoriesList.get(position);
        holder.foodvariety.setText(categories.getFoodvariety());
        holder.foodvarietydetails.setText(categories.getFooddetails());
        holder.foodImg.setImageResource(categories.getFoodvarietyimg());
       // holder.foodImg.setImageResource(categories.getFoodvarietyimg());

    }

    @Override
    public int getItemCount() {

        return categoriesList.size();
    }
}