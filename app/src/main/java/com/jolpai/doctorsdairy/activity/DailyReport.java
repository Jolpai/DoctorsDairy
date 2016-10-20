package com.jolpai.doctorsdairy.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.andexert.library.RippleView;
import com.jolpai.doctorsdairy.App;
import com.jolpai.doctorsdairy.R;
import com.jolpai.doctorsdairy.custom.MyStyle;

import java.util.ArrayList;
import java.util.List;

import static com.jolpai.doctorsdairy.App.TAG;
import static com.jolpai.doctorsdairy.App.currentTime;

public class DailyReport extends AppCompatActivity {
    LinearLayout llReportHeader,llDate;
    RippleView llFooterDate;

    RecyclerView horizontalRecycler;
    LinearLayoutManager horizontalLayoutManager;
    int rowRecyclerView;
    int reportPortrait,reportLandscape;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(App.TAG,"DailyReport");

        hideStatusBar();
        checkOrientation();
       initialize();

    }


    private void hideStatusBar() {
        if(Build.VERSION.SDK_INT >= 16){
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
    }


    private void initialize() {
        Log.e(App.TAG, App.currentTime());

        horizontalRecycler = (RecyclerView) findViewById(R.id.horizontalRecycler);

        final ArrayList horizontalList=new ArrayList<>();
        for (int i=0;i<31;i++){

            horizontalList.add("D:"+i);
        }

        horizontalRecycler.setLayoutManager(horizontalLayoutManager);
        horizontalRecycler.setAdapter( new Recycler_View_Adapter(horizontalList,this));


        Log.e(App.TAG, App.currentTime());

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //adapter = new HorizontalRecyclerAdapter(horizontalList,DailyReport.this);
               // horizontalRecycler.setAdapter( new HorizontalRecyclerAdapter(horizontalList,DailyReport.this));

                Log.e(App.TAG,"call adapter"+ App.currentTime());

            }
        }, 100);
 

    }

    // check the device orientation and choose layout file.
    private void checkOrientation(){

        int orientation= DailyReport.this.getResources().getConfiguration().orientation;
        if(orientation == Configuration.ORIENTATION_PORTRAIT) {
            setContentView(R.layout.activity_report_portrait);
            rowRecyclerView=R.layout.row_portrait;
            horizontalLayoutManager = new LinearLayoutManager(DailyReport.this,LinearLayoutManager.VERTICAL,false);

        }else if(orientation == Configuration.ORIENTATION_LANDSCAPE){
            setContentView(R.layout.activity_report_landscape);
            rowRecyclerView=R.layout.row_landscape;
           horizontalLayoutManager = new LinearLayoutManager(DailyReport.this,LinearLayoutManager.HORIZONTAL,false);
        }
    }
    private void setWidthAndHeight(){
        llReportHeader = (LinearLayout) findViewById(R.id.llReportHeader);

        llDate =(LinearLayout)findViewById(R.id.llDate);
        llFooterDate =(RippleView) findViewById(R.id.llFooterDate);


       final LinearLayout layout = llDate; //(LinearLayout)findViewById(R.id.YOUD VIEW ID);
        ViewTreeObserver vto = layout.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                layout.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                int width  = layout.getMeasuredWidth();
                int height = layout.getMeasuredHeight();

            }
        });

        ViewGroup.LayoutParams params = llFooterDate.getLayoutParams();
        // Changes the height and width to the specified *pixels*
        // params.height = 111;
        // params.width = 100;
        llFooterDate.setLayoutParams(params);

    }

    public  void pdfGenerate(View v){
        Bitmap b = Bitmap.createBitmap( v.getLayoutParams().width, v.getLayoutParams().height, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(b);
        v.layout(v.getLeft(), v.getTop(), v.getRight(), v.getBottom());
        v.draw(c);
    }







// inner Adapter class for recyclerview
    public class Recycler_View_Adapter  extends RecyclerView.Adapter<Recycler_View_Adapter.View_Holder> {
        private List<String> list;
        private Context context;

        public Recycler_View_Adapter(List<String> list, Context context) {
            this.list = list;
            this.context = context;
        }


        public class View_Holder extends RecyclerView.ViewHolder{

            TextView title;
            RippleView llFooterDate;
            public View_Holder (View itemView){
                super(itemView);
                title=(TextView)itemView.findViewById(R.id.txtDate);
                llFooterDate=(RippleView)itemView.findViewById(R.id.llFooterDate);

            }
        }

        @Override
        public View_Holder onCreateViewHolder(ViewGroup parent, int viewType) {
            //Inflate the layout, initialize the View Holder
            View v = LayoutInflater.from(parent.getContext()).inflate(rowRecyclerView, parent, false);
            View_Holder holder = new View_Holder(v);

            return holder;

        }

        @Override
        public void onBindViewHolder(View_Holder holder, int position) {

            //Use the provided View Holder on the onCreateViewHolder method to populate the current row on the RecyclerView
            holder.title.setText(list.get(position));
            holder.title.setBackground(new MyStyle().getShape());

            // Log.e(TAG,holder.toString());
            Log.e(TAG,"onBindViewHolder"+position);
            Log.e(TAG, currentTime());
            // holder.description.setText(list.get(position).description);
            // holder.imageView.setImageResource(list.get(position).imageId);

            //animate(holder);

            holder.llFooterDate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(context,holder.txtDate.getText().toString(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context,ReportAddEditComment.class);
                    context.startActivity(intent);
                }
            });

        }

        @Override
        public int getItemCount() {
            //returns the number of elements the RecyclerView will display
            return list.size();
        }

        @Override
        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
            super.onAttachedToRecyclerView(recyclerView);
        }


    }

}
