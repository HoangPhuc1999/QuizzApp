package com.example.prmproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.prmproject.domain.CategoryDomain;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewCategoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewCategory();
    }

    private void recyclerViewCategory(){
        LinearLayoutManager linearLayoutManager =  new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewCategoryList = findViewById(R.id.recyclerView);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> catagory = new ArrayList<>();
        catagory.add(new CategoryDomain("Pizze","cat_1"));
        catagory.add(new CategoryDomain("Burger","cat_2"));
        catagory.add(new CategoryDomain("Hot Dog","cat_3"));
        catagory.add(new CategoryDomain("Drink","cat_4"));
        catagory.add(new CategoryDomain("Donut","cat_5"));

    }


}