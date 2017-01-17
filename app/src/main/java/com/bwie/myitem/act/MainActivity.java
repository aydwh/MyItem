package com.bwie.myitem.act;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.bwie.library.mvp.BaseActivity;
import com.bwie.myitem.R;
import com.bwie.myitem.fragment.AppBarMainFragment;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {


    private DrawerLayout mDrawerLayout;
    private Toolbar toolbar;

    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initVariables() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, new AppBarMainFragment()).commit();

    }

    @Override
    public void initViews(Bundle savedInstanceState) {

    }


    @Override
    protected void onResume() {
        super.onResume();
        //设置抽屉DrawerLayout
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar,
                R.string.drawer_open, R.string.drawer_close);
        mDrawerToggle.syncState();//初始化状态
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        //设置导航栏NavigationView的点击事件
        NavigationView mNavigationView = (NavigationView) findViewById(R.id.nav_view);
        mNavigationView.setNavigationItemSelectedListener(this);
//        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//                switch (item.getItemId()) {
//                    case R.id.day:
//                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
//                        recreate();
//                        break;
//                    case R.id.night:
//                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
//                        recreate();
//                        break;
//                }
//                return true;
//            }
//        });
    }


    @Override
    public void loadData() {

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.menu_publish:
                startActivity(FaBuActivity.class);
                break;
            case R.id.menu_tv:
                startActivity(TvMainActivity.class);
                break;
            case R.id.setting:
                startActivity(SettingActivity.class);
                break;
            case R.id.about:
                startActivity(AboutActivity.class);
                break;
        }

        item.setChecked(true);//点击了把它设为选中状态
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


}
