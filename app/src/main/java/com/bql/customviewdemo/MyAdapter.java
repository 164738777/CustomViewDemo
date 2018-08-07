package com.bql.customviewdemo;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * 作者:  lbqiang on 2018/8/7 23:31
 * 邮箱:  anworkmail_q@126.com
 * 作用:
 */
public class MyAdapter extends BaseQuickAdapter<Entity, BaseViewHolder> {


    public MyAdapter(@Nullable List<Entity> data) {
        super(R.layout.item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Entity item) {
        helper.setText(R.id.item_tv, item.getName());
    }
}
