package com.aditya.inshorts;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.aditya.inshorts.models.News;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHelper>{

    private Context context;
    private List<News> newses;

    public NewsAdapter(Context context,List<News> newses){
        this.context=context;
        this.newses=newses;
    }

    @Override
    public NewsViewHelper onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(NewsViewHelper holder, int position) {
        final News news=newses.get(position);
        if(news!=null){

        }
    }

    @Override
    public int getItemCount() {
        return newses.size();
    }


    public static class NewsViewHelper extends RecyclerView.ViewHolder{

        private TextView title;
        private TextView url;
        private TextView publisher;
        private TextView category;
        private TextView hostname;
        private TextView timestamp;

        public NewsViewHelper(View itemView) {
            super(itemView);
        }
    }

}
