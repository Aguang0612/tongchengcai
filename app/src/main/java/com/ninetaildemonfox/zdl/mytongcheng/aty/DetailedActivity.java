package com.ninetaildemonfox.zdl.mytongcheng.aty;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.ninetaildemonfox.zdl.mytongcheng.R;
import com.ninetaildemonfox.zdl.mytongcheng.adp.MainFragmentPageAdapter;
import com.ninetaildemonfox.zdl.mytongcheng.base.BaseActivity;
import com.ninetaildemonfox.zdl.mytongcheng.fgt.my.AccountDetailsFragment;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author NineTailDemonFox
 * @date 2019/9/5 10:35
 * 功能描述： 1账户明细 2 提现明细
 * 联系方式：1037438704@qq.com
 */

public class DetailedActivity extends BaseActivity {
    @BindView(R.id.image_left_finish)
    ImageView imageleftFinish;
    @BindView(R.id.text_center)
    TextView textCenter;
    @BindView(R.id.text_right)
    TextView textRight;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;

    private String[] string;
    private List<Fragment> mFragmentList;
    private MainFragmentPageAdapter adapter;
    private String count;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_detailed;
    }

    @Override
    protected void onInitialization(Bundle bundle) {
        count = getIntent().getExtras().getString("count");
        initView();
        initData();
    }

    private void initData() {


        imageleftFinish.setVisibility(View.VISIBLE);
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(mFragmentList.size());
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void initView() {
        if (count.equals("1")) {
            textCenter.setText("账本明细");
            string = new String[]{"全部", "收入", "支出"};
        } else {
            textCenter.setText("账户明细");
            string = new String[]{"全部", "已发放", "待处理"};
        }
        mFragmentList = new ArrayList<>();
//       count 1  账本明细  2 体现明细
        mFragmentList.add(AccountDetailsFragment.newInstance(count, "1"));
        mFragmentList.add(AccountDetailsFragment.newInstance(count, "2"));
        mFragmentList.add(AccountDetailsFragment.newInstance(count, "3"));
        //实例化适配器
        adapter = new MainFragmentPageAdapter(getSupportFragmentManager(), mFragmentList, string);
    }

    @OnClick({R.id.image_left_finish})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.image_left_finish:
                finish();
                break;
            default:
        }
    }

}
