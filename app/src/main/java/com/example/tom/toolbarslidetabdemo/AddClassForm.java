package com.example.tom.toolbarslidetabdemo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Selection;
import android.text.Spannable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Tom on 2015/12/5.
 */
public class AddClassForm extends AppCompatActivity {
    private Toolbar mToolbar;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private AddPagerAdapter myPagerAdapter;
    public static final String TAG = "AddClassForm";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_class_form);

        //获取适配器对象
        myPagerAdapter = new AddPagerAdapter(getSupportFragmentManager());

        //应用工具栏
        mToolbar = (Toolbar) findViewById(R.id.add_form_toolbar);
        setSupportActionBar(mToolbar);

        //应用适配器到TabLayout
        mTabLayout = (TabLayout) findViewById(R.id.add_form_tabLayout);
        mViewPager = (ViewPager) findViewById(R.id.add_form_viewpager);
        mViewPager.setAdapter(myPagerAdapter);
        mTabLayout.setTabsFromPagerAdapter(myPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);

        //设置动作监听
        //设置动作监听
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));

        FormNameDialog dialog = new FormNameDialog();
        dialog.show(getFragmentManager(),TAG);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_form_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if(itemId == R.id.menu_save_form){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    //添加新课表的内部碎片类
    public static class AddFragment extends Fragment{
        View rootView;
        static int pageNumber;

        //空参构造函数
        public AddFragment(){

        }

        //提供创建本类实例的方法
        public static AddClassForm.AddFragment newInstance(int page){
            pageNumber = page;
            AddClassForm.AddFragment myFragment = new AddClassForm.AddFragment();
            return myFragment;
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            //应用碎片布局
            rootView = inflater.inflate(R.layout.add_form_fragment,container,false);

            return rootView;
        }

        @Override
        public void onPause() {
            super.onPause();
            //获取到所有的编辑框
            EditText classOne = (EditText) rootView.findViewById(R.id.class_one);
            EditText classTwo = (EditText) rootView.findViewById(R.id.class_two);
            EditText classThree = (EditText) rootView.findViewById(R.id.class_three);
            EditText classFour = (EditText) rootView.findViewById(R.id.class_four);
            EditText classFive = (EditText) rootView.findViewById(R.id.class_five);
            EditText classSix = (EditText) rootView.findViewById(R.id.class_six);

            EditText locationOne = (EditText) rootView.findViewById(R.id.location_one);
            EditText locationTwo = (EditText) rootView.findViewById(R.id.location_two);
            EditText locationThree = (EditText) rootView.findViewById(R.id.location_three);
            EditText locationFour = (EditText) rootView.findViewById(R.id.location_four);
            EditText locationFive = (EditText) rootView.findViewById(R.id.location_five);
            EditText locationSix = (EditText) rootView.findViewById(R.id.location_six);

            //获取编辑框中的文本
            String classOneText = classOne.getText().toString();
            String classTwoText = classTwo.getText().toString();
            String classThreeText = classThree.getText().toString();
            String classFourText = classFour.getText().toString();
            String classFiveText = classFive.getText().toString();
            String classSixText = classSix.getText().toString();

            String locationOneText = locationOne.getText().toString();
            String locationTwoText = locationTwo.getText().toString();
            String locationThreeText = locationThree.getText().toString();
            String locationFourText = locationFour.getText().toString();
            String locationFiveText = locationFive.getText().toString();
            String locationSixText = locationSix.getText().toString();

            //获取到数据库操作对象
            ClassFormOpenHelper myHelper = new ClassFormOpenHelper(getContext(),"class_form",null,1);
            SQLiteDatabase db = myHelper.getWritableDatabase();

            //创建ContentValues临时存储数据
            ContentValues contentValues = new ContentValues();

            //将获取到的用户输入数据添加到ContentValues
            contentValues.put(ClassFormContract.MONDAY_ONE,classOneText);
            contentValues.put(ClassFormContract.MONDAY_TWO,classTwoText);
            contentValues.put(ClassFormContract.MONDAY_THREE,classThreeText);
            contentValues.put(ClassFormContract.MONDAY_FOUR,classFourText);
            contentValues.put(ClassFormContract.MONDAY_FIVE,classFiveText);
            contentValues.put(ClassFormContract.MONDAY_SIX,classSixText);

            contentValues.put(ClassFormContract.MONDAY_ONE_LOCATION,locationOneText);
            contentValues.put(ClassFormContract.MONDAY_TWO_LOCATION,locationTwoText);
            contentValues.put(ClassFormContract.MONDAY_THREE_LOCATION,locationThreeText);
            contentValues.put(ClassFormContract.MONDAY_FOUR_LOCATION,locationFourText);
            contentValues.put(ClassFormContract.MONDAY_FIVE_LOCATION,locationFiveText);
            contentValues.put(ClassFormContract.MONDAY_SIX_LOCATION,locationSixText);
        }
    }

    //提示用户输入课程表名的对话框
    public static class FormNameDialog extends DialogFragment{
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            LayoutInflater inflater = getActivity().getLayoutInflater();
            View rootView = inflater.inflate(R.layout.form_name_dialog, null);
            EditText editText = (EditText) rootView.findViewById(R.id.input_form_name);
            editText.setText(R.string.new_form_name);
            editText.setSelection(editText.length());
            builder.setView(rootView)
                    .setPositiveButton(R.string.sure, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    })
                    .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
            return builder.create();
        }
    }
}

class AddPagerAdapter extends FragmentStatePagerAdapter{

    public AddPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        AddClassForm.AddFragment myFragment = AddClassForm.AddFragment.newInstance(position);
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
