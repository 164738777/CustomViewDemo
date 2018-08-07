package com.bql.customviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.bql.customviewdemo.aty.Demo1Activity;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rcv;
    private MyAdapter mMyAdapter;
    private List<Entity> mEntityList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initList();
        initAdapter();
    }

    private void initList() {
        mEntityList.add(new Entity("Demo1", Demo1Activity.class));
    }

    private void initAdapter() {
        mMyAdapter = new MyAdapter(mEntityList);
        mMyAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(MainActivity.this, "sdfsdf", Toast.LENGTH_SHORT).show();
            }
        });

        rcv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rcv.setAdapter(mMyAdapter);
    }

    private void initView() {
        rcv = findViewById(R.id.rcv);
    }
}
