package com.di.playstore.data.dummy;

import com.di.playstore.R;
import com.di.playstore.data.model.CategoryModel;

import java.util.ArrayList;
import java.util.List;

public class DummyCategoryProvider {
    public static List<CategoryModel> getCategories() {
        List<CategoryModel> list = new ArrayList<>();
        list.add(new CategoryModel("Games", R.drawable.sports_esports_20px));
        list.add(new CategoryModel("Education", R.drawable.book_20px));
        list.add(new CategoryModel("Music", R.drawable.music_note_2_20px));
        list.add(new CategoryModel("Productivity", R.drawable.productivity_20px));
        list.add(new CategoryModel("Photography", R.drawable.photo_prints_20px));
        list.add(new CategoryModel("Social", R.drawable.add_reaction_20px));
        return list;
    }
}