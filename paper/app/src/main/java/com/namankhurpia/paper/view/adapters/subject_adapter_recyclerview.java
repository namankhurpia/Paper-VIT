package com.namankhurpia.paper.view.adapters;


import android.content.Context;
import android.content.Intent;


import android.support.annotation.NonNull;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.TextView;


import com.facebook.ads.AbstractAdListener;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.InterstitialAd;
import com.namankhurpia.paper.R;

import com.namankhurpia.paper.view.Models.Schema;
import com.namankhurpia.paper.view.view.Web_view;



import java.util.ArrayList;
import java.util.List;


import static android.content.ContentValues.TAG;
import static java.lang.Thread.sleep;


public class subject_adapter_recyclerview extends RecyclerView.Adapter<subject_adapter_recyclerview.adapterviewholder> implements Filterable {


    private List<Schema> paperlist;
    private List<Schema> paperfilter;

    public Context context;
    String url;

    //download button
    String datadir, relpath;

    //implementing ads
    private InterstitialAd interstitialAd;


    //empty constructor
    public subject_adapter_recyclerview(Context context,List<Schema> paperlist) {

        this.context=context;
        this.paperfilter = paperfilter;
        this.paperlist = paperlist;

    }


    @NonNull
    @Override
    public adapterviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_paper_recyclerview, parent, false);

        return new adapterviewholder(view);

    }

    @NonNull
    @Override
    public void onBindViewHolder(@NonNull final adapterviewholder holder, final int position) {




        holder.coursename.setText(paperlist.get(position).getCourseName());
        holder.cousecode.setText(paperlist.get(position).getCourseCode());
        holder.slot.setText(paperlist.get(position).getSlot());
        holder.year.setText(paperlist.get(position).getYear());
        datadir = paperlist.get(position).getDataDir();
        relpath = paperlist.get(position).getRelativePath();







    }


    @Override
    public int getItemCount() {
        return paperlist.size();
    }


    //child class
    class adapterviewholder extends RecyclerView.ViewHolder {
        TextView coursename;
        TextView cousecode;
        TextView slot;
        TextView year;
        ImageButton downloadbutton;


        public adapterviewholder(final View itemview) {

            super(itemview);
            coursename = itemview.findViewById(R.id.coursename);
            cousecode = itemview.findViewById(R.id.coursecode);
            slot = itemview.findViewById(R.id.slot);
            year = itemview.findViewById(R.id.year);
            downloadbutton = itemview.findViewById(R.id.download_btn);


            downloadbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    int position=getAdapterPosition();
                    if(position!=RecyclerView.NO_POSITION)
                    {
                        Schema viewselected=paperlist.get(position);
                        url=viewselected.getDataDir();

                           loadads();


                        Intent i=new Intent(context, Web_view.class);
                        String finalurl="http://namankhurpia.pythonanywhere.com"+url;
                        Log.i(TAG,"$$$"+ finalurl);
                        //Toast.makeText(context, finalurl, Toast.LENGTH_SHORT).show();
                        i.putExtra("url", finalurl);
                        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(i);

                    }

                }


            });




        }



    }

    @Override
    public Filter getFilter() {

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();

                if(charString.isEmpty())
                {
                    //paperlist=paperfilter;
                    paperfilter=paperlist;
                }
                else
                {
                    List<Schema> filteredlist=new ArrayList<>();
                    for(Schema s:paperlist)
                    {
                        if(s.getCourseName().toLowerCase().contains(charString.toLowerCase()) || s.getCourseCode().toLowerCase().contains(charSequence) || s.getCourseCode().contains(charSequence) || s.getCourseName().contains(charSequence))
                        {
                            filteredlist.add(s);
                        }
                    }

                    //paperlist=filteredlist;
                    paperfilter=filteredlist;
                }

                FilterResults filterResults=new FilterResults();
                //filterResults.values = paperlist;
                filterResults.values=paperfilter;


                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {

                //paperfilter=(ArrayList<Schema>) filterResults.values;
                paperlist=(ArrayList<Schema>)filterResults.values;
                notifyDataSetChanged();

            }
        };
    }






    //showing facebook ads
    private void showads() {

        if(interstitialAd.isAdLoaded())
        {

            Log.i(TAG,"$$$############"+ "adloaded ready to show" );
            interstitialAd.show();
        }

    }


    //load ads
    private void loadads() {

        interstitialAd = new InterstitialAd(context, "api-key-removed");
        interstitialAd.setAdListener(new AbstractAdListener() {
            @Override
            public void onError(Ad ad, AdError adError) {
                super.onError(ad, adError);
            }

            @Override
            public void onAdLoaded(Ad ad) {
                super.onAdLoaded(ad);
                showads();
            }

            @Override
            public void onAdClicked(Ad ad) {
                super.onAdClicked(ad);
            }

            @Override
            public void onInterstitialDisplayed(Ad ad) {
                super.onInterstitialDisplayed(ad);
            }

            @Override
            public void onInterstitialDismissed(Ad ad) {
                super.onInterstitialDismissed(ad);
            }

            @Override
            public void onLoggingImpression(Ad ad) {
                super.onLoggingImpression(ad);
            }
        });


        Log.i(TAG, "$$$############" + "aasked ad to load");
        interstitialAd.loadAd();

        /*if(interstitialAd.isAdLoaded())
        {
            showads();
            return true;
        }
        else
        {
            return false;
        }*/
    }



}

