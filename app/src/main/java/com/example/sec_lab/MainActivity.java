package com.example.sec_lab;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity<imageAdapter> extends AppCompatActivity {
    RecyclerView my_list;
    //String[] list_titles={"One","Two","Three"};
    List<To_Do> list_titles = new ArrayList<>();
    ;
    To_Do_Adapter adpt;
    //ArrayList<Integer> DelItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        my_list = findViewById(R.id.RV1);

        my_list.setHasFixedSize(true);

        my_list.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));

        my_list.setLayoutManager(new LinearLayoutManager(this));

        list_titles.add(new To_Do("One", "Ay 7aga1", R.mipmap.ic_launcher_round));
        list_titles.add(new To_Do("Two", "Ay 7aga2", R.mipmap.ic_launcher_round));
        list_titles.add(new To_Do("Three", "Ay 7aga3", R.mipmap.ic_launcher_round));
        list_titles.add(new To_Do("Four", "Ay 7aga4", R.mipmap.ic_launcher_round));
        list_titles.add(new To_Do("Five", "Ay 7aga5", R.mipmap.ic_launcher_round));
        list_titles.add(new To_Do("Six", "Ay 7aga6", R.mipmap.ic_launcher_round));
        list_titles.add(new To_Do("Seven", "Ay 7aga7", R.mipmap.ic_launcher_round));
        list_titles.add(new To_Do("Eight", "Ay 7aga8", R.mipmap.ic_launcher_round));
        list_titles.add(new To_Do("Nine", "Ay 7aga9", R.mipmap.ic_launcher_round));


        adpt = new To_Do_Adapter(MainActivity.this, R.layout.row, list_titles);
        my_list.setAdapter(adpt);


    }

//    @Override
//    protected void onResume() {
//
//        super.onResume();
//        DelItems = getIntent().getIntegerArrayListExtra("Del");
//
//        if(DelItems !=null ) {
//
//            Collections.sort(DelItems, Collections.reverseOrder());
//            for (int i : DelItems) {
//                list_titles.remove(i);
//                adpt.notifyItemRemoved(i);
//                adpt.notifyItemRangeChanged(i,list_titles.size());
//
//
//            }}else{
//            list_titles.remove(0);
//        }
//
//
//    }


}