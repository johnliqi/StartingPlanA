package com.liqi.wawwa;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.liqi.wawwa.Presenter.MainPresenter;
import com.liqi.wawwa.Presenter.MainPresenterImpl;
import com.liqi.wawwa.View.MainView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements MainView {
    ViewPager mViewPager;
    DrawerLayout mDrawerLayout;
    TabLayout mTabLayout;
    MainPresenter mainPresenter;
    int x = 0;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // CrashManager.getInstance().shareCrashFile(MainActivity.this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();
        assert ab != null;
        ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView =
                (NavigationView) findViewById(R.id.nv_main_navigation);
        mainPresenter = new MainPresenterImpl(this);
        if (navigationView != null) {
            navigationView.setNavigationItemSelectedListener(
                    new NavigationView.OnNavigationItemSelectedListener() {
                        @Override
                        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                            // 改变item选中状态
                            menuItem.setChecked(true);
                            mainPresenter.switchNavigation(menuItem.getItemId());
                            String title = menuItem.getTitle().toString();
                            x = x + 1;
                            //   Toast.makeText(getApplicationContext(), title, Toast.LENGTH_SHORT).show();
                            //关闭导航菜单
                            mDrawerLayout.closeDrawers();
                            return true;
                        }
                    });
        }

        switchHome();
        initViewPager();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_overaction, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private void initViewPager() {
        mTabLayout = (TabLayout) findViewById(R.id.tabs);
        List<String> titles = new ArrayList<>();
        titles.add("精选");
        titles.add("体育");
        titles.add("巴萨");
        titles.add("购物");
        titles.add("明星");

        titles.add("精选");

        for (int i = 0; i < titles.size(); i++) {
            mTabLayout.addTab(mTabLayout.newTab().setText(titles.get(i)));
        }
        List<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i < titles.size(); i++) {
            fragments.add(new ListFragment());
        }
        FragmentAdapter mFragmentAdapteradapter =
                new FragmentAdapter(getSupportFragmentManager(), fragments, titles);
        //给ViewPager设置适配器
        mViewPager.setAdapter(mFragmentAdapteradapter);
        //将TabLayout和ViewPager关联起来。
        mTabLayout.setupWithViewPager(mViewPager);
        //给TabLayout设置适配器
        mTabLayout.setTabsFromPagerAdapter(mFragmentAdapteradapter);
    }


    @Override
    public void switchHome() {
        Toast.makeText(getApplicationContext(), "首页88", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void switchFriend() {
        Toast.makeText(getApplicationContext(), "朋友88", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void switchDiscussion() {

    }

    @Override
    public void switchMessage() {

    }

    @Override
    public void switchAbout() {

    }

}
