package com.five.fight;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.five.fight.base.BaseActivity;
import com.five.fight.moudle.car.CarFragment;
import com.five.fight.moudle.home.HomeFragment;
import com.five.fight.moudle.mine.MineFragment;
import com.five.fight.moudle.shop.ShopFragment;

public class MainActivity extends BaseActivity {
    private Fragment currentf;
    private RadioGroup radiogroup;
    private HomeFragment homeFragment;
    private ShopFragment shopFragment;
    private CarFragment carFragment;
    private MineFragment mineFragment;
    private RadioButton btn_main_home;
    private RadioButton btn_main_shop;
    private RadioButton btn_main_car;
    private RadioButton btn_main_mine;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected int getFragmentContentId() {
        return 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initview();
        lisenter();
        addFragments(new HomeFragment());


    }

    private void initview() {
        radiogroup = (RadioGroup) findViewById(R.id.radiogroup);

    }

    private void lisenter() {

        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.btn_main_home:


                        if (homeFragment == null) {
                            homeFragment = new HomeFragment();
                        }
                        addFragments(homeFragment);
                        break;
                    case R.id.btn_main_shop:

                        if (shopFragment == null) {
                            shopFragment = new ShopFragment();
                        }
                        addFragments(shopFragment);
                        break;
                    case R.id.btn_main_car:

                        if (carFragment == null) {
                            carFragment = new CarFragment();
                        }
                        addFragments(carFragment);
                        break;
                    case R.id.btn_main_mine:

                        if (mineFragment == null) {
                            mineFragment = new MineFragment();
                        }
                        addFragments(shopFragment);
                        break;


                }
            }

        });
    }

    private void addFragments(Fragment f) {
        // 第一步：得到fragment管理类
        FragmentManager manager = getSupportFragmentManager();
        // 第二步：开启一个事务
        FragmentTransaction transaction = manager.beginTransaction();

        if (currentf != null) {
            //每次把前一个fragment给隐藏了
            transaction.hide(currentf);
        }

        //isAdded:判断当前的fragment对象是否被加载过
        if (!f.isAdded()) {
            // 第三步：调用添加fragment的方法 第一个参数：容器的id 第二个参数：要放置的fragment的一个实例对象
            transaction.add(R.id.fcontent, f);
        }
        //显示当前的fragment
        transaction.show(f);

        // 第四步：提交
        transaction.commit();

        currentf = f;
    }


    private void initView() {
        btn_main_home = (RadioButton) findViewById(R.id.btn_main_home);
        btn_main_shop = (RadioButton) findViewById(R.id.btn_main_shop);
        btn_main_car = (RadioButton) findViewById(R.id.btn_main_car);
        btn_main_mine = (RadioButton) findViewById(R.id.btn_main_mine);
    }
}
