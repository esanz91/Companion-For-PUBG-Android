package tech.zafrani.companionforpubg.models;


import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;


public class Items implements Serializable {
    @NonNull
    @SerializedName("categories")
    private final List<Category> categories;


    public Items(@NonNull final List<Category> categories) {
        this.categories = categories;
    }



    @Override
    public String toString() {
        return "Items{" +
                "categories=" + Arrays.toString(categories.toArray()) +
                '}';
    }

    @NonNull
    public List<Category> getCategories() {
        return categories;
    }

    public Category getCategory(@NonNull final String name) {

        for (final Category category: categories) {
            if (category.getName().equals(name)) {
                return category;
            }
        }
        return null;
    }
}
