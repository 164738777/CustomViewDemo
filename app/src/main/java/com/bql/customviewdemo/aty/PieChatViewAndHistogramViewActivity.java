package com.bql.customviewdemo.aty;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bql.customviewdemo.R;
import com.bql.customviewdemo.views.HistogramView;
import com.bql.customviewdemo.views.PieChatView;

import java.util.HashMap;
import java.util.Map;

public class PieChatViewAndHistogramViewActivity extends AppCompatActivity {

    private PieChatView viewPieChat;
    private HistogramView viewHistogram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_histogram);

        initView();

        initPieData();


    }

    private void initPieData() {
        Map<String, Double> map = new HashMap<>();
        map.put("10", 10.0);
        map.put("20", 30.0);
        map.put("30", 60.0);

        viewPieChat.setData(map);
    }

    private void initView() {
        viewPieChat = findViewById(R.id.view_pieChat);
        viewHistogram = findViewById(R.id.view_histogram);
    }
}
