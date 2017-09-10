package com.aditya.inshorts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.aditya.inshorts.db.NewsHelper;
import com.aditya.inshorts.models.News;

public class MainActivity extends AppCompatActivity {

    private NewsHelper newsHelper;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=(TextView)findViewById(R.id.hell);
        newsHelper=new NewsHelper(getApplicationContext());

        newsHelper.addNews(new News("Adi","Adi sud jhadsajk"));
        newsHelper.addNews(new News("asdadd","dds sdsd fdfd fdfd"));

        textView.setText("Size is: "+newsHelper.getAllNews().size());
    }
}
