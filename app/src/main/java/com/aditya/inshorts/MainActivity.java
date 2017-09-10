package com.aditya.inshorts;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.aditya.inshorts.base.BaseAppCompat;
import com.aditya.inshorts.db.NewsHelper;
import com.aditya.inshorts.fragments.NewsListFragment;
import com.aditya.inshorts.models.News;

public class MainActivity extends BaseAppCompat implements NewsListFragment.OnFragmentInteractionListener{

    private NewsHelper newsHelper;

    private FrameLayout frameLayout;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        frameLayout=(FrameLayout)findViewById(R.id.frame);


        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        Fragment fragment = NewsListFragment.newInstance();
        fragmentTransaction.add(R.id.frame,fragment)
                .addToBackStack(null)
                .commit();


        newsHelper=new NewsHelper(getApplicationContext());

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
