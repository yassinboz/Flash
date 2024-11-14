package com.example.flashresto;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flashresto.AppDataBase.AppDataBase;
import com.example.flashresto.entity.Menu;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {

    private List<Menu> menuList;
    private Context context;
    private AppDataBase appDataBase;

    public MenuAdapter(List<Menu> menuList, Context context) {
        this.menuList = menuList;
        this.context = context;
        this.appDataBase = AppDataBase.getInstance(context);
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item, parent, false);
        return new MenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        Menu menu = menuList.get(position);

        holder.platTextView.setText(menu.getPlat());
        holder.descriptionTextView.setText(menu.getDescription());
        holder.prixTextView.setText(menu.getPrix() + " D");
        holder.itemRatingBar.setRating(menu.getRating());

        // Mettre à jour la note dans la base de données quand l'utilisateur change la note
        holder.itemRatingBar.setOnRatingBarChangeListener((ratingBar, rating, fromUser) -> {
            if (fromUser) {
                menu.setRating(rating);
                appDataBase.menuDao().update(menu);  // Mettez à jour la note dans la base de données
            }
        });
    }

    @Override
    public int getItemCount() {
        return menuList.size();
    }

    public static class MenuViewHolder extends RecyclerView.ViewHolder {
        TextView platTextView, descriptionTextView, prixTextView;
        RatingBar itemRatingBar;

        public MenuViewHolder(View itemView) {
            super(itemView);
            platTextView = itemView.findViewById(R.id.platTextView);
            descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
            prixTextView = itemView.findViewById(R.id.prixTextView);
            itemRatingBar = itemView.findViewById(R.id.itemRatingBar);
        }
    }
}
