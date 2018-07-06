package ru.startandroid.week2homework2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.facebook.share.Share;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    static int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final Post[] posts = {new Post(R.drawable.gal_gadot, "Gal"),
                new Post(R.drawable.eva, "Eva"),
                new Post(R.drawable.jenifer, "Jenifer"),
                new Post(R.drawable.megan, "Megan"),
        };
        final RecyclerView rc = findViewById(R.id.rc);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rc.setLayoutManager(llm);

        final List<Post> list = new ArrayList<>();
        list.add(new Post(R.drawable.elizabeth, "Elizabeth"));
        list.add(new Post(R.drawable.scarlett, "Scarlett"));
        list.add(new Post(R.drawable.margo, "Margo"));
        list.add(new Post(R.drawable.kiran, "Kira"));
        list.add(new Post(R.drawable.angelina, "Angelina"));
        final MyAdapter myAdapter = new MyAdapter(list);
        rc.setAdapter(myAdapter);
        FloatingActionButton floatingActionButton = findViewById(R.id.fab);
        rc.setHasFixedSize(true);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == posts.length - 1){
                    i = 0;
                }
                list.add(posts[i]);
                myAdapter.notifyDataSetChanged();
                ++i;
                rc.scrollToPosition(list.size() - 1);
            }
        });
    }

}
