package com.sutema.apps.alumnitracker;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MyLokerActivity extends AppCompatActivity {

    private TextView notifTxt;
    private ImageView emptyIcon;

    private Loker[] myLokerList;
    private ListView lokerListView;
    LokerAdapter lokerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_loker);

        emptyIcon = findViewById(R.id.imageView2);
        notifTxt = findViewById(R.id.textView3);

        lokerListView = findViewById(R.id.listview_loker);

        FetchLoker fetchLoker = new FetchLoker();
        fetchLoker.execute();

        FloatingActionButton createLokerBtn = findViewById(R.id.floatingActionButton);
        createLokerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLokerForm();
            }
        });
    }

    public void openLokerForm(){
        Intent intent = new Intent(this, LokerFormActivity.class);
        startActivity(intent);
    }
    @SuppressLint("StaticFieldLeak")
    public class FetchLoker extends AsyncTask<Void, Integer, String>{
        @SuppressLint("SetTextI18n")
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            notifTxt.setText("Pre Execute State");
        }

        @SuppressLint("SetTextI18n")
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.i("onPostExecute","Executed!");
            try{
                if (myLokerList == null){

                    notifTxt.setText("No Loker Submitted yet...");
                }else{
                    emptyIcon.setVisibility(View.INVISIBLE);
                    notifTxt.setVisibility(View.INVISIBLE);
                    lokerListView.setVisibility(View.VISIBLE);
                    renderLokerListView();
                }
            }catch (Exception e){
                Log.e("MyLokerAct",e.getMessage());
            }
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected String doInBackground(Void... voids) {
            try{

            }catch (Exception e){
                Log.e("MyLokerActivity",e.getMessage());
            }
            return null;
        }
    }

    public void renderLokerListView(){
        lokerAdapter = new LokerAdapter(this,R.layout.loker_row,myLokerList);

        if (lokerListView != null){
            lokerListView.setAdapter(lokerAdapter);
        }

        lokerListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                try{
                    Log.i("LokerView","Item "+i);
                    Log.i("ID",String.valueOf(myLokerList[i].getId()));
                } catch (Throwable e){
                    Log.e("Loker Item Click", e.getMessage());
                }
            }
        });
    }
}




