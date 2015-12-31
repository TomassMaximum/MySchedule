package com.example.tom.toolbarslidetabdemo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Tom on 2015/12/5.
 */
public class MainActivity extends AppCompatActivity {
    Toolbar mToolbar;
    TabLayout mTabLayout;
    ViewPager mViewPager;
    MyPagerAdapter myPagerAdapter;
    String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //创建适配器对象
        myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());

        //应用工具栏
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        //应用适配器到TabLayout
        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mViewPager.setAdapter(myPagerAdapter);
        mTabLayout.setTabsFromPagerAdapter(myPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);

        //设置动作监听
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if(itemId == R.id.menu_add){
            ChoosingOperationDialog dialog = new ChoosingOperationDialog();
            dialog.show(getFragmentManager(),TAG);
        }
        if(itemId == R.id.menu_setting){
            Intent intent = new Intent(getApplication(),Settings.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    //创建显示内容的碎片内部类
    public static class MyFragment extends Fragment{

        //空参构造函数
        public MyFragment(){

        }

        //提供创建本类实例的方法
        public static MyFragment newInstance(int pageNumber){
            MyFragment myFragment = new MyFragment();
            return myFragment;
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            //应用碎片布局
            //View rootView = inflater.inflate(R.layout.fragment,container,false);

            return inflater.inflate(R.layout.fragment,container,false);
        }
    }

    //用户点击添加菜单项时显示此对话框，进入课程表列表或添加新课表
    public static class ChoosingOperationDialog extends DialogFragment{
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle(R.string.pick_operation)
                    .setItems(R.array.operation_items, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // The 'which' argument contains the index position
                            // of the selected item
                            switch (which){
                                case 0:
                                    Intent addIntent = new Intent(getActivity(),AddClassForm.class);
                                    startActivity(addIntent);
                                    break;
                                case 1:
                                    Intent editIntent = new Intent(getActivity(),FormList.class);
                                    startActivity(editIntent);
                            }
                        }
                    });
            return builder.create();
        }
    }
}

class MyPagerAdapter extends FragmentStatePagerAdapter{

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        MainActivity.MyFragment myFragment = MainActivity.MyFragment.newInstance(position);
        return myFragment;
    }

    @Override
    public int getCount() {
        return 7;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String currentTab = "";
        switch(position){
            case 0:
                currentTab = "周一";
                break;
            case 1:
                currentTab = "周二";
                break;
            case 2:
                currentTab = "周三";
                break;
            case 3:
                currentTab = "周四";
                break;
            case 4:
                currentTab = "周五";
                break;
            case 5:
                currentTab = "周六";
                break;
            case 6:
                currentTab = "周日";
                break;
            default:
                break;
        }
        return currentTab;
    }
}


