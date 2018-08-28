package com.bql.customviewdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bql.customviewdemo.aty.CanvasDrawBaseActivity;
import com.bql.customviewdemo.aty.LinearGradientActivity;
import com.bql.customviewdemo.aty.PaintAndPathEffectActivity;
import com.bql.customviewdemo.aty.PathActivity;
import com.bql.customviewdemo.aty.PieChatViewAndHistogramViewActivity;
import com.bql.customviewdemo.aty.RadialGradientActivity;
import com.bql.customviewdemo.aty.ShaderActivity;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * https://hencoder.com 自定义view系列
 */
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
        mEntityList.add(new Entity("Day1 Canvas基础 & Path"));
        mEntityList.add(new Entity("CanvasDrawBaseView", CanvasDrawBaseActivity.class));
        mEntityList.add(new Entity("PathView", PathActivity.class));
        mEntityList.add(new Entity("饼图与直方图（Day1作业）", PieChatViewAndHistogramViewActivity.class));
        mEntityList.add(new Entity());

        mEntityList.add(new Entity("Day2 Paint"));
        mEntityList.add(new Entity("LinearGradient", LinearGradientActivity.class));
        mEntityList.add(new Entity("RadialGradient", RadialGradientActivity.class));
        mEntityList.add(new Entity("BitmapShader", ShaderActivity.class));
        mEntityList.add(new Entity("Paint PathEffect", PaintAndPathEffectActivity.class));

    }

    private void initAdapter() {
        mMyAdapter = new MyAdapter(mEntityList);
        mMyAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Entity item = (Entity) adapter.getItem(position);
                if (item.getTargetClass() != null) {
                    startActivity(new Intent(MainActivity.this, item.getTargetClass()));
                }
            }
        });

        rcv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rcv.setAdapter(mMyAdapter);
    }

    private void initView() {
        rcv = findViewById(R.id.rcv);
    }
}
