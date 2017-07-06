package com.five.fight.moudle.shop;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.five.fight.R;
import com.five.fight.base.BaseFragment;


public class ShopFragment extends BaseFragment implements View.OnClickListener {

    private View mEdt_search;
    private Context mContext;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.shopfragment;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {


        }
    }
}
