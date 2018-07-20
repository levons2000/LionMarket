package com.example.student.lionmarket.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.student.lionmarket.R;
import com.example.student.lionmarket.adapters.GamesAdapter;
import com.example.student.lionmarket.models.GameModel;
import com.example.student.lionmarket.providers.AllItemDatas;

import java.util.Collections;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends android.app.Fragment {

    public static RecyclerView recyclerView;
    boolean b = true;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        if (b) {
            itemsAdd();
        }
        Collections.shuffle(AllItemDatas.list);
        GamesAdapter gamesAdapter = new GamesAdapter(getActivity(), AllItemDatas.list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView = v.findViewById(R.id.items_recyc);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(gamesAdapter);
        return v;

    }

    private void itemsAdd() {
        AllItemDatas.list.add(new GameModel("https://orig00.deviantart.net/4edb/f/2013/328/0/5/the_forest_by_pooterman-d6vk4b0.png", "The Forest", "10.49", "PC Game", "Endnight Games Ltd", 0));
        AllItemDatas.list.add(new GameModel("https://orig00.deviantart.net/91d5/f/2012/128/d/2/terraria_by_tchiba69-d4yzkij.png", "Terraria", "6.99", "PC Game", "Re-Logic", 0));
        AllItemDatas.list.add(new GameModel("https://pbs.twimg.com/profile_images/1017713253676302337/RwcqV6eI_400x400.jpg", "Earthfall", "29.99", "PS4 Game", "Holospark", 0));
        AllItemDatas.list.add(new GameModel("https://orig00.deviantart.net/32e1/f/2016/053/9/5/far_cry_3___icon_by_blagoicons-d9sqfyj.png", "Far Cry 3", "10.49", "PS4 Game", "Ubisoft Entertainment", 0));
        AllItemDatas.list.add(new GameModel("https://orig00.deviantart.net/a935/f/2014/240/d/2/resident_evil_2___icon_circle_by_wesleysouji-d7x38a5.png", "Resident Evil 2", "59.99", "XBox One Game", "CapCom Ltd", 0));
        AllItemDatas.list.add(new GameModel("https://orig00.deviantart.net/1d82/f/2018/160/3/4/battlefield_5_icon_by_troublem4ker-dcdxlii.png", "Battlefield 5", "59.99", "XBox One Game", "Electronic Arts", 0));
        b = false;
    }

}
