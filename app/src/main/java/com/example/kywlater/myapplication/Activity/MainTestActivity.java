package com.example.kywlater.myapplication.Activity;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import com.example.kywlater.myapplication.Adapter.MainActivityViewPagerAdapter;
import com.example.kywlater.myapplication.Fragment.AdoptFragment;
import com.example.kywlater.myapplication.Fragment.infoFragment;
import com.example.kywlater.myapplication.Fragment.mypetsFragment;
import com.example.kywlater.myapplication.R;
import com.example.kywlater.myapplication.Adapter.AnimalAdapter;

import java.util.Arrays;
import java.util.List;


public class MainTestActivity extends AppCompatActivity {

    private List<Fragment> fragments = Arrays.asList(
            new mypetsFragment(),
            new AdoptFragment(),
            new infoFragment()
    );
    ViewPager mainActivityViewPager;
    BottomNavigationView bottomNavView;
    MainActivityViewPagerAdapter adapter;
    AnimalAdapter AnimalAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_test);
//        获取到两个控件的对象
        mainActivityViewPager = findViewById(R.id.main_viewpager);
        mainActivityViewPager.setOffscreenPageLimit(3);
        mainActivityViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
        bottomNavView = (BottomNavigationView) findViewById(R.id.main_bottom_nav_view);
//        为ViewPager设置Adapter

//        为 BottomNavigationView 的菜单项  设置监听事件
        bottomNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//               获取到菜单项的Id
                int itemId = item.getItemId();
//                当第一项被选择时BlankFragmentOne显示，以此类推
                switch (itemId) {
                    case R.id.btm_nav_item1:
                        mainActivityViewPager.setCurrentItem(0);
                        break;
                    case R.id.btm_nav_item2:
                        mainActivityViewPager.setCurrentItem(1);
                        break;
                    case R.id.btm_nav_item3:
                        mainActivityViewPager.setCurrentItem(2);
                        break;

                }
                // true 会显示这个Item被选中的效果 false 则不会
                return true;
            }
        });
//        为 ViewPager 设置监听事件
        mainActivityViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
//                当 ViewPager 滑动后设置BottomNavigationView 选中相应选项
                bottomNavView.getMenu().getItem(position).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

}
