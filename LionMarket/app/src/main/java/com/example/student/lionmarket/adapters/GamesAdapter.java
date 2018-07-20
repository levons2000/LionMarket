package com.example.student.lionmarket.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.student.lionmarket.R;
import com.example.student.lionmarket.activitys.MainActivity;
import com.example.student.lionmarket.models.GameModel;
import com.example.student.lionmarket.providers.AllItemDatas;
import com.squareup.picasso.Picasso;

import java.util.List;

public class GamesAdapter extends RecyclerView.Adapter<GamesAdapter.ItemsViewHolder> {

    private List<GameModel> list;
    private Context context;

    public GamesAdapter(Context context, List<GameModel> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ItemsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.game_model_style, parent, false);
        return new ItemsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ItemsViewHolder holder, int position) {
        holder.textName.setText(list.get(position).getName());
        holder.textConsole.setText(list.get(position).getType());
        holder.textPrise.setText(list.get(position).getPrice());
        if (list.get(position).isLiked) {
            holder.buttonLike.setImageResource(R.drawable.ic_thumb_up_active_24dp);
        }
        if (list.get(position).isInBin) {
            holder.buttonBuy.setImageResource(R.drawable.ic_shopping_cart_active_24dp);
        }
        Picasso.get().load(list.get(position).getImgUrl()).into(holder.imageGame);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ItemsViewHolder extends RecyclerView.ViewHolder {
        TextView textName;
        TextView textConsole;
        TextView textPrise;
        ImageView imageGame;
        ImageButton buttonBuy;
        ImageButton buttonLike;

        public ItemsViewHolder(View itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.game_name);
            textConsole = itemView.findViewById(R.id.game_console);
            textPrise = itemView.findViewById(R.id.game_price);
            buttonBuy = itemView.findViewById(R.id.buy);
            buttonLike = itemView.findViewById(R.id.like);
            imageGame = itemView.findViewById(R.id.game_image);
            buttonLike.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!list.get(getAdapterPosition()).isLiked) {
                        buttonLike.setImageResource(R.drawable.ic_thumb_up_active_24dp);
                        for (int i = 0; i < AllItemDatas.list.size(); i++) {
                            if (AllItemDatas.list.get(i).getName().equals(list.get(getAdapterPosition()).getName())) {
                                AllItemDatas.list.get(i).isLiked = true;
                            }
                        }
                    } else {
                        buttonLike.setImageResource(R.drawable.ic_thumb_up_black_24dp);
                        for (int i = 0; i < AllItemDatas.list.size(); i++) {
                            if (AllItemDatas.list.get(i).getName().equals(list.get(getAdapterPosition()).getName())) {
                                AllItemDatas.list.get(i).isLiked = false;
                            }
                        }
                    }
                }
            });
            buttonBuy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!list.get(getAdapterPosition()).isInBin) {
                        buttonBuy.setImageResource(R.drawable.ic_shopping_cart_active_24dp);
                        for (int i = 0; i < AllItemDatas.list.size(); i++) {
                            if (AllItemDatas.list.get(i).getName().equals(list.get(getAdapterPosition()).getName())) {
                                AllItemDatas.list.get(i).isInBin = true;
                            }
                        }
                    } else {
                        buttonBuy.setImageResource(R.drawable.ic_shopping_cart_black_24dp);
                        for (int i = 0; i < AllItemDatas.list.size(); i++) {
                            if (AllItemDatas.list.get(i).getName().equals(list.get(getAdapterPosition()).getName())) {
                                AllItemDatas.list.get(i).isInBin = false;
                            }
                        }
                    }
                }

            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    for (int i = 0; i < AllItemDatas.list.size(); i++) {
                        if (AllItemDatas.list.get(i).getName().equals(list.get(getAdapterPosition()).getName())) {
                            AllItemDatas.position = i;
                        }
                    }
                    MainActivity.setFragment();
                }
            });
        }
    }
}
