package com.example.prmproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.prmproject.adaptor.CategoryAdaptor;
import com.example.prmproject.adaptor.PopularAdaptor;
import com.example.prmproject.domain.CategoryDomain;
import com.example.prmproject.domain.FoodDomain;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapter, adapter2;
    private RecyclerView recyclerViewCategoryList, recyclerViewPopularList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewCategory();
        recyclerViewPopular();
        bottomNavigation();

    }

    private void bottomNavigation(){
        FloatingActionButton floatingActionButton = findViewById(R.id.cartBtn);
        LinearLayout homeBtn = findViewById(R.id.homeBtn);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,CartListActivity.class));
            }
        });

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,MainActivity.class));
            }
        });

    }

    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategoryList = findViewById(R.id.recyclerView);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> catagory = new ArrayList<>();
        catagory.add(new CategoryDomain("Pizze", "cat_1"));
        catagory.add(new CategoryDomain("Burger", "cat_2"));
        catagory.add(new CategoryDomain("Hot Dog", "cat_3"));
        catagory.add(new CategoryDomain("Drink", "cat_4"));
        catagory.add(new CategoryDomain("Donut", "cat_5"));

        adapter = new CategoryAdaptor(catagory);
        recyclerViewCategoryList.setAdapter(adapter);

    }


    private void recyclerViewPopular() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPopularList = findViewById(R.id.recyclerView2);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);
        ArrayList<FoodDomain> foodList = new ArrayList<>();
        foodList.add(new FoodDomain("Pepperoni pizza", "pizza", "slices pepperoni, mozzerella cheese, fresh oregano, ground black pepper,pizza sauce", 9.76));
        foodList.add(new FoodDomain("Cheese Burger", "pizza", "slices pepperoni, mozzerella cheese, fresh oregano, ground black pepper,pizza sauce", 8.76));
        foodList.add(new FoodDomain("Vegetable pizza", "pizza", "slices pepperoni, mozzerella cheese, fresh oregano, ground black pepper,pizza sauce", 9.86));

        adapter2 = new PopularAdaptor(foodList);
        recyclerViewPopularList.setAdapter(adapter2);
    }

}