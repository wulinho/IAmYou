package com.five.fight.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;

import com.zhy.autolayout.AutoLayoutActivity;


public abstract class BaseActivity extends AutoLayoutActivity{
    //布局文件ID
    protected abstract int getContentViewId();

    //布局中Fragment的ID
    protected abstract int getFragmentContentId();
    //去掉状态栏

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//该方法用来隐藏APP的title，其实AppCompatActivity原本就省略了title，我们看到的title其实是actionbar
//        所以调用下面方法隐藏掉。
//        getSupportActionBar().hide();
//        requestWindowFeature(Window.FEATURE_NO_TITLE);这个方法是去掉avitvity的标题栏，注意区别。

//  这个方法是设置全屏（遮挡状态栏），根据设计稿，并非全屏，而是沉浸式
//      getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(getContentViewId());
    }

    //添加fragment
    protected void addFragment(BaseFragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(getFragmentContentId(), fragment, fragment.getClass().getSimpleName())
                    .addToBackStack(fragment.getClass().getSimpleName())
                    .commitAllowingStateLoss();
        }
    }

    //移除fragment
    protected void removeFragment() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            getSupportFragmentManager().popBackStack();
        } else {
            finish();
        }
    }

    //返回键返回事件
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (KeyEvent.KEYCODE_BACK == keyCode) {
            if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
                finish();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
