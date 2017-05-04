package zafrani.com.pubgapp.models;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ItemContainer {

    @SerializedName("categories")
    public List<ItemCategory> categories;
    @SerializedName("steven")
    public boolean steven;

    public List<ItemCategory> getCategories() {
        return categories;
    }

    @Override
    public String toString() {
        return "ItemContainer{" +
                "categories=" + (categories == null ? "null":categories.toString()) +
                ", steven=" + steven +
                '}';
    }
}
