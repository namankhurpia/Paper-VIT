package com.namankhurpia.paper.view.view;

import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.namankhurpia.paper.R;
import com.namankhurpia.paper.view.Handlers.checkForInternet;
import com.namankhurpia.paper.view.Models.Schema;
import com.namankhurpia.paper.view.Retrofit_service.RetrofitInstance;
import com.namankhurpia.paper.view.Retrofit_service.paperDataService;
import com.namankhurpia.paper.view.adapters.subject_adapter_recyclerview;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class fat extends AppCompatActivity {

    List<Schema> data, dara;
    subject_adapter_recyclerview paperadapter;
    RecyclerView recyclerView;
    ImageButton backbtn;
    private SearchView searchView;

    private Schema schema;


    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fat);

        backbtn = (ImageButton) findViewById(R.id.back_btn);
        searchView = (SearchView) findViewById(R.id.searchview);


        relativeLayout = (RelativeLayout) findViewById(R.id.relativelayout);


        if (checkForInternet.getInstance(getApplicationContext()).isOnline()) {
            getpapers();

            SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
            searchView = (SearchView) findViewById(R.id.searchview);
            searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

            searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
            searchView.setMaxWidth(Integer.MAX_VALUE);

            //listening to query change
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    paperadapter.getFilter().filter(query);
                    Log.i("on response", "****************** code ran false");

                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {


                    paperadapter.getFilter().filter(newText);
                    Log.i("on response", "****************** code ran true");
                    return false;
                }

            });

        } else {
            RelativeLayout relativeLayout = new RelativeLayout(this);
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(R.mipmap.noaccess);

            imageView.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT));

            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
            params.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
            relativeLayout.addView(imageView);


            setContentView(relativeLayout);
            Toast.makeText(getApplicationContext(), "No internet access", Toast.LENGTH_SHORT).show();
        }

        //recyclerView.setAdapter(paperadapter);


        //click
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onBackPressed();

            }
        });

    }


    private Object getpapers() {

        final ProgressDialog progressDoalog;
        progressDoalog = new ProgressDialog(fat.this);
        progressDoalog.setMax(100);
        progressDoalog.setMessage("loading....");
        progressDoalog.setTitle("Fetching papers");
        progressDoalog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        // show it
        progressDoalog.show();

        final paperDataService paperDataService = RetrofitInstance.getService();
        Call<List<Schema>> call = paperDataService.GetFat();

        call.enqueue(new Callback<List<Schema>>() {
            @Override
            public void onResponse(Call<List<Schema>> call, Response<List<Schema>> response) {

                try {

                    data = response.body();
                    for (Schema m : data) {
                        Log.i("on response", "***************" + m.getCourseName() + m.getDataDir());
                    }

                    viewData();
                    progressDoalog.dismiss();

                } catch (Exception e) {

                    Log.d("onResponse", "There is an error");
                    e.printStackTrace();
                    progressDoalog.dismiss();
                }

            }

            @Override
            public void onFailure(Call<List<Schema>> call, Throwable t) {

            }
        });

        return data;

    }


    private void viewData() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview_fat);

        //changed
        paperadapter = new subject_adapter_recyclerview(getApplicationContext(), data);
        //ended with get app context

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(fat.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(paperadapter);


    }

}
