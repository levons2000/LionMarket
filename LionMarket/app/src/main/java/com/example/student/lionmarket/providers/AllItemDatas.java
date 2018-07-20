package com.example.student.lionmarket.providers;

import com.example.student.lionmarket.models.GameModel;

import java.util.ArrayList;
import java.util.List;

public class AllItemDatas {
    public static List<GameModel> list = new ArrayList<>();
    public static int position;

    public static List<GameModel> getItemsByType(String type) {
        List<GameModel> newList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getType().equals(type)) {
                newList.add(list.get(i));
            }
        }
        return newList;
    }

    public static List<GameModel> getLikedItems() {
        List<GameModel> newList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isLiked) {
                newList.add(list.get(i));
            }
        }
        return newList;
    }

    public static List<GameModel> getBuyItems() {
        List<GameModel> newList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isInBin) {
                newList.add(list.get(i));
            }
        }
        return newList;
    }
}
