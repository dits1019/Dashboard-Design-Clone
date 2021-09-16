package com.example.dashboarddesignclone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupContentsViewPager();

    }

    private void setupContentsViewPager() {
        ViewPager2 contentsViewPager = findViewById(R.id.viewPager);
        contentsViewPager.setClipToPadding(false);
        contentsViewPager.setClipChildren(false);
        contentsViewPager.setOffscreenPageLimit(3);
        contentsViewPager.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(10));
        compositePageTransformer.addTransformer((page, position) -> {
            float r = 1 - Math.abs(position);
            page.setScaleY(0.85f + r * 0.15f);
        });
        contentsViewPager.setPageTransformer(compositePageTransformer);
        contentsViewPager.setAdapter(new ContentsAdapter(getContents()));
    }

    private List<Contents> getContents() {
        List<Contents> contents = new ArrayList<>();

        Contents num1 = new Contents();
        num1.poster= R.drawable.img1;
        num1.name = "Modern House";
        num1.category = "NEW YORK";
        num1.explanation = "with a swimming pool for a big family in the village";
        num1.rating = 4.6f;
        contents.add(num1);

        Contents num2 = new Contents();
        num2.poster= R.drawable.img2;
        num2.name = "Modern House";
        num2.category = "NEW YORK";
        num2.explanation = "with a swimming pool for a big family in the village";
        num2.rating = 4.6f;
        contents.add(num2);

        Contents num3 = new Contents();
        num3.poster= R.drawable.img3;
        num3.name = "Modern House";
        num3.category = "NEW YORK";
        num3.explanation = "with a swimming pool for a big family in the village";
        num3.rating = 4.6f;
        contents.add(num3);

        Contents num4 = new Contents();
        num4.poster= R.drawable.img4;
        num4.name = "Modern House";
        num4.category = "NEW YORK";
        num4.explanation = "with a swimming pool for a big family in the village";
        num4.rating = 4.6f;
        contents.add(num4);
        
        return contents;
    }

}