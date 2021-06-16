package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity {
    listdatabase listdatabase;
    listdao listdao;
    Button button;
    TextView textView2;
    EditText gname,gnum;
    LiveData<List<listentity>> allwordLive;
    RecyclerView recyclerView;
    Adapter Adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        Adapter = new Adapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(Adapter);
        listdatabase = Room.databaseBuilder(this,listdatabase.class,"list_database")
                .allowMainThreadQueries()
                .build();
        listdao = listdatabase.getlistdao();
        allwordLive = listdao.getallwordLive();
        /*allwordLive.observe(this, new Observer<List<listentity>>() {
            @Override
            public void onChanged(List<listentity> lists) {
                Adapter.setAllWords(lists);
                Adapter.notifyDataSetChanged(); 這裡一直出錯 直接放生 但好像因此沒辦法跑..?

            }
        });*/
        button=findViewById(R.id.button);
        gname = (EditText)findViewById(R.id.gname);
        gnum =(EditText) findViewById(R.id.gnum);
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

            // COMPLETED (4) Override onMove and simply return false inside
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                //滑動
                int position = viewHolder.getAdapterPosition();
                switch (direction) {
                    case ItemTouchHelper.LEFT:
                    case ItemTouchHelper.RIGHT:


                        String ai = findViewById(R.id.textViewnum).toString();
                        break;
                }
            }

            //COMPLETED (11) attach the ItemTouchHelper to the waitlistRecyclerView
        }).attachToRecyclerView(recyclerView);
    }
    public void bionclick(View view) {
        String name = gname.getText().toString();
        String num = gnum.getText().toString();
        listentity word = new listentity(name,num);

        listdao.insertlist(word);



    }
}