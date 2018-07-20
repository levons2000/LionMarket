package com.example.student.lionmarket.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.student.lionmarket.R;
import com.example.student.lionmarket.models.GameModel;
import com.example.student.lionmarket.providers.AllItemDatas;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 */
public class InfoFragment extends android.app.Fragment {


    public InfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_info, container, false);
        ImageView imageView = view.findViewById(R.id.info_image);
        TextView textName = view.findViewById(R.id.info_name);
        TextView textType = view.findViewById(R.id.info_type);
        TextView textPrice = view.findViewById(R.id.info_price);
        TextView textCreator = view.findViewById(R.id.info_creator);
        RatingBar ratingBar = view.findViewById(R.id.ratingBar);
        GameModel gameModel = AllItemDatas.list.get(AllItemDatas.position);
        Picasso.get().load(gameModel.getImgUrl()).into(imageView);
        textName.setText(gameModel.getName());
        textType.setText(gameModel.getType());
        textPrice.setText(gameModel.getPrice());
        textCreator.setText(gameModel.getCreator());
        ratingBar.setRating(gameModel.getRaiting());
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                AllItemDatas.list.get(AllItemDatas.position).setRaiting(v);
            }
        });

        return view;
    }

}
