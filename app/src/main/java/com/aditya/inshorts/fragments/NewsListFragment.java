package com.aditya.inshorts.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.aditya.inshorts.NewsAdapter;
import com.aditya.inshorts.R;
import com.aditya.inshorts.base.BaseFragment;
import com.aditya.inshorts.concurrency.ExecutorUtils;
import com.aditya.inshorts.db.NewsHelper;
import com.aditya.inshorts.models.News;
import com.aditya.inshorts.network.Factory;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class NewsListFragment extends BaseFragment {

    private OnFragmentInteractionListener mListener;
    private List<News> products;
    private NewsAdapter newsAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private FloatingActionMenu menuRed;
    private ImageView close;

    private NewsHelper newsHelper;

    public NewsListFragment() {
        // Required empty public constructor
    }

    public static NewsListFragment newInstance() {
        NewsListFragment fragment = new NewsListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_list, container, false);
        menuRed = (FloatingActionMenu) view.findViewById(R.id.menu_red);
        final FloatingActionButton programFab1 = new FloatingActionButton(getContext());
        programFab1.setButtonSize(FloatingActionButton.SIZE_MINI);
        programFab1.setLabelText("Title");
        programFab1.setImageResource(R.mipmap.ic_title);
        menuRed.addMenuButton(programFab1);
        programFab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Collections.sort(products,Product.TITLE_COMPARATOR);
//                productAdapter.notifyDataSetChanged();
                menuRed.close(true);
            }
        });
        final FloatingActionButton programFab2 = new FloatingActionButton(getContext());
        programFab2.setButtonSize(FloatingActionButton.SIZE_MINI);
        programFab2.setLabelText("Location");
        programFab2.setImageResource(R.mipmap.ic_launcher);
        menuRed.addMenuButton(programFab2);
        programFab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Collections.sort(products,Product.LOCATION_COMPARATOR);
//                productAdapter.notifyDataSetChanged();
                menuRed.close(true);
            }
        });
        final FloatingActionButton programFab3 = new FloatingActionButton(getContext());
        programFab3.setButtonSize(FloatingActionButton.SIZE_MINI);
        programFab3.setLabelText("Pledged");
        programFab3.setImageResource(R.mipmap.ic_money);
        menuRed.addMenuButton(programFab3);
        programFab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Collections.sort(products,Product.PLEDGED_COMPARATOR);
//                productAdapter.notifyDataSetChanged();
                menuRed.close(true);
            }
        });

        close = (ImageView) view.findViewById(R.id.close_search_box);
        close.setVisibility(View.INVISIBLE);
        recyclerView=(RecyclerView)view.findViewById(R.id.universities_list);
        linearLayoutManager=new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        linearLayoutManager.setSmoothScrollbarEnabled(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        products =new ArrayList<>();
        newsAdapter =new NewsAdapter(getContext(), products);
        //Read Data
        initialize(products);
        recyclerView.setAdapter(newsAdapter);
        return view;
    }

    private void initialize(final List<News> products){

        ListenableFuture<JSONArray> getContacts= Factory.getNewsService().getNews();
        Futures.addCallback(getContacts, new FutureCallback<JSONArray>() {
            @Override
            public void onSuccess(JSONArray result) {
                Log.d(getTAG(), "OnSuccess: " + result.toString());

                try {
                    for(int i=0;i<result.length();i++){
                        JSONObject jsonObject=result.getJSONObject(i);
                        News news=new News();
                        news.setId(jsonObject.getLong("ID"));
                        news.setTimestamp(new Date(jsonObject.getString("TIMESTAMP")));
                        news.setUrl(jsonObject.getString("URL"));
                        news.setHostname(jsonObject.getString("HOSTNAME"));
                        news.setPublisher(jsonObject.getString("PUBLISHER"));
                        news.setCategory(jsonObject.getString("CATEGORY"));
                        news.setTitle(jsonObject.getString("TITLE"));
                        newsHelper.addNews(news);
                    }
                }catch (JSONException exception){
                    Log.d(getTAG(),"JSON Exception");
                }finally {

                    newsHelper=new NewsHelper(getContext());
                    products.addAll(newsHelper.getAllNews());
                    newsAdapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onFailure(Throwable t) {
                Log.d(getTAG(),t.getMessage());
            }
        }, ExecutorUtils.getUIThread());
    }


    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
