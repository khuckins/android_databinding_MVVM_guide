package com.example.mvvmsampleproject.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;
import android.databinding.DataBindingUtil;

import com.example.mvvmsampleproject.R;
import com.example.mvvmsampleproject.databinding.ActivityMainBinding;
import com.example.mvvmsampleproject.viewmodel.MainViewModel;

public class MainActivity extends BaseActivity {

    private MainViewModel mainViewModel;
    private ActivityMainBinding mainBinding;

    public static Intent getStartIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainViewModel = new MainViewModel(this);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        Toolbar toolbar = (Toolbar) mainBinding.toolbar;
        setSupportActionBar(toolbar);

        mainBinding.tabs.addTab(mainBinding.tabs.newTab().setText("Tab 1"));
        mainBinding.tabs.addTab(mainBinding.tabs.newTab().setText("Tab 2"));
        mainBinding.tabs.addTab(mainBinding.tabs.newTab().setText("Tab 3"));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainViewModel.destroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
