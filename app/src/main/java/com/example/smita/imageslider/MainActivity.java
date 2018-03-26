package com.example.smita.imageslider;

import android.content.DialogInterface;
import android.os.Build;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toolbar;
import android.app.AlertDialog.Builder;
import android.app.AlertDialog;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {


    int[] foodvarietyImg={R.drawable.cusinies,R.drawable.veg,R.drawable.night,R.drawable.pizzaa,R.drawable.bake,
    R.drawable.cusinies,R.drawable.cusinies,R.drawable.cusinies};
    String[] foodvariety={"Trending","Pure Veg","Night Life","Pizzas","Cafes","Bakries","Desserts","Cuisines"};
    //String[] fooddetails=getResources().getStringArray(R.array.arr);
    String[] fooddetails = {"Explore the most popular restaurants","Vegetarian delights",
            "The very best picks in your city","Happiness is a slice of pizza",
            "Spill the beans","Find your next tasty treat","Satiate your sweet cravings","Find your choice of cuisine"} ;

    List<Categories> CategoriesList = new ArrayList<>();

    ViewPager viewPager;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private  RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbarid);
        setSupportActionBar(toolbar);

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsingToolBar);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            collapsingToolbarLayout.setExpandedTitleColor(getColor(R.color.transparent));
        }


        TextView textView = findViewById(R.id.categoriesTextView);

        recyclerView = findViewById(R.id.categoriesRecyclerView);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new CategoriesAdapter(MainActivity.this,CategoriesList);
        recyclerView.setAdapter(adapter);


//
        viewPager = (ViewPager)findViewById(R.id.viewPager);

        ViewPageAdapter viewPageAdapter = new ViewPageAdapter(this);

        viewPager.setAdapter(viewPageAdapter);
        /*Timer timer=new Timer();
        timer.schedule(new MyTimerTask(),10000,50000);
*/
        preparedata();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }


    private void preparedata() {
        for (int i = 0; i < foodvariety.length; i++) {
            Categories categories = new Categories(foodvariety[i],fooddetails[i], foodvarietyImg[i]);

            CategoriesList.add(categories);
        }
        adapter.notifyDataSetChanged();
    }

    /*public class MyTimerTask extends TimerTask{

        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    if (viewPager.getCurrentItem() == 0){
                        viewPager.setCurrentItem(1);
                    }else if (viewPager.getCurrentItem() == 1){
                        viewPager.setCurrentItem(2);
                    }else {
                        viewPager.setCurrentItem(0);
                    }
                }
            });
        }
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_layout,menu);
        MenuItem item = menu.findItem(R.id.menuSearch);
        SearchView searchView =(SearchView) item.getActionView();
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(R.drawable.exxit)
                .setTitle("Close Application")
                .setMessage("Are you sure?")
                .setPositiveButton("Yes",new DialogInterface.OnClickListener()
                {
                    public void onClick(DialogInterface dialog,int which){
                        finish();
                    }
                })
                .setNegativeButton("No",null)
                .show();
    }
}
