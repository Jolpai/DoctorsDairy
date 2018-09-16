package com.jolpai.doctorsdiary.View.Report;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.LinearLayout;

import com.andexert.library.RippleView;
import com.jolpai.doctorsdiary.View.helper.VerticalTextView;
import com.jolpai.doctorsdiary.R;
import com.jolpai.doctorsdiary.View.helper.MyStyle;
import com.jolpai.doctorsdiary.Model.Worker.Database.GetData;
import com.jolpai.doctorsdiary.Model.Worker.Others.MyDateFormat;
import com.jolpai.doctorsdiary.Model.Worker.Database.SaveData;
import com.jolpai.doctorsdiary.Model.Worker.Parse.StrParser;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import io.realm.RealmResults;


public class Activity_Report_Show extends AppCompatActivity {
    private static final String YEAR="YEAR";
    private static final String MONTH="MONTH";

    LinearLayout llReportHeader,llDate,llR;
    RippleView llFooterDate;

    TextView avrgTotalDay,
            avrgProfessionalWork,
            avrgAcademicStudy,
            avrgHadithStudy,
            avrgLiteratureStudy,
            avrgSalatWithJamaat,
            avrgParticipantIntentContact,
            avrgVolunteerIntentContact,
            avrgMemberIntentContact,
            avrgContact,
            avrgBookDistribution,
            avrgSocietyWork,
            avrgQuranStudy,
            avrgFamilyMeeting,
            avrgVisit,
            avrgReportKeeping,
            avrgSelfAssessment;
    VerticalTextView txtHeaderMonthYear;

    RecyclerView horizontalRecycler;
    LinearLayoutManager horizontalLayoutManager;
    int rowRecyclerView;
    int reportPortrait,reportLandscape;
    int year=0;
    int month=0;
    int daysOfMonth=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // Log.e(App.TAG,"Activity_Report_Show");

        hideStatusBar();
        checkOrientation();
        //initialize();

    }


    private void hideStatusBar() {
        if(Build.VERSION.SDK_INT >= 16){
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
    }


    private void initialize() {

        llR= findViewById(R.id.llR);

        horizontalRecycler = findViewById(R.id.horizontalRecycler);
        txtHeaderMonthYear= findViewById(R.id.txtHeaderMonthYear);
        avrgTotalDay = findViewById(R.id.avrgTotalDay);
        avrgProfessionalWork = findViewById(R.id.avrgProfessionalWork);
        avrgAcademicStudy = findViewById(R.id.avrgAcademicStudy);
        avrgHadithStudy = findViewById(R.id.avrgHadithStudy);
        avrgLiteratureStudy = findViewById(R.id.avrgLiteratureStudy);
        avrgSalatWithJamaat = findViewById(R.id.avrgSalatWithJamaat);
        avrgParticipantIntentContact = findViewById(R.id.avrgParticipantIntentContact);
        avrgVolunteerIntentContact = findViewById(R.id.avrgVolunteerIntentContact);
        avrgMemberIntentContact = findViewById(R.id.avrgMemberIntentContact);
        avrgContact = findViewById(R.id.avrgContact);
        avrgBookDistribution = findViewById(R.id.avrgBookDistribution);
        avrgSocietyWork = findViewById(R.id.avrgSocietyWork);
        avrgQuranStudy = findViewById(R.id.avrgQuranStudy);
        avrgFamilyMeeting = findViewById(R.id.avrgFamilyMeeting);
        avrgVisit = findViewById(R.id.avrgVisit);
        avrgReportKeeping = findViewById(R.id.avrgReportKeeping);
        avrgSelfAssessment = findViewById(R.id.avrgSelfAssessment);

    }

    private void showReportList(){

        Intent intent=this.getIntent();
        if(intent != null){
            year=intent.getIntExtra(YEAR,0);
            month=intent.getIntExtra(MONTH,0);
        }
        daysOfMonth= MyDateFormat.getNumOfDayOfMonth(year,month-1);
        txtHeaderMonthYear.setText(MyDateFormat.getMonthName(year,month-1));

        final ArrayList<com.jolpai.doctorsdiary.Model.Worker.Database.entity.DailyReport> horizontalList=new ArrayList<>();
        final RealmResults<com.jolpai.doctorsdiary.Model.Worker.Database.entity.DailyReport> reportList =
                GetData.getOneMonthReportFromRealm(this, (Class) com.jolpai.doctorsdiary.Model.Worker.Database.entity.DailyReport.class,year,month);

        final RealmResults<com.jolpai.doctorsdiary.Model.Worker.Database.entity.DailyReport> avgReportList =
                GetData.getTotalOneMonthReport(this, (Class) com.jolpai.doctorsdiary.Model.Worker.Database.entity.DailyReport.class,year,month);

        final String totalQuranStudiedDay =GetData.getTotalQuranStudyDay(Activity_Report_Show.this,
                (Class) com.jolpai.doctorsdiary.Model.Worker.Database.entity.DailyReport.class,year,month);

        final String totalFamilyMeetingDay=GetData.getTotalFamilyMeetingDay(Activity_Report_Show.this,
                (Class) com.jolpai.doctorsdiary.Model.Worker.Database.entity.DailyReport.class,year,month);

        final String totalVisitedDay= GetData.getTotalVisitDay(Activity_Report_Show.this,
                (Class) com.jolpai.doctorsdiary.Model.Worker.Database.entity.DailyReport.class,year,month);

        final String totalReportKeepingDay=GetData.getTotalReportKeepingDay(Activity_Report_Show.this,
                (Class) com.jolpai.doctorsdiary.Model.Worker.Database.entity.DailyReport.class,year,month);

        final String totalSelfAssessmentDay=GetData.getTotalSelfAssessmentDay(Activity_Report_Show.this,
                (Class) com.jolpai.doctorsdiary.Model.Worker.Database.entity.DailyReport.class,year,month);


        for (int i=0;i<reportList.size();i++){

            horizontalList.add(reportList.get(i));
        }

        if(reportList.size()==0){
            for(int i=0;i<daysOfMonth;i++){
                com.jolpai.doctorsdiary.Model.Worker.Database.entity.DailyReport report=
                        new com.jolpai.doctorsdiary.Model.Worker.Database.entity.DailyReport();
                report.setToDay(i+1);
                report.setYear(year);
                report.setMonth(month);
                report.setDate(MyDateFormat.getDateDDMMYY(year,month,i+1));
                SaveData.saveDataToRealm(this,report,(Class) com.jolpai.doctorsdiary.Model.Worker.Database.entity.DailyReport.class);
                horizontalList.add(report);
            }
        }

        Collections.sort(horizontalList);



        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                horizontalRecycler.setLayoutManager(horizontalLayoutManager);
                horizontalRecycler.setAdapter( new Recycler_View_Adapter(horizontalList,Activity_Report_Show.this));




                avrgTotalDay.setText(StrParser.parseIntToString(avgReportList.size()));

                avrgProfessionalWork.setText(StrParser.parseNumberToString(avgReportList.sum("professionalWork")));
                avrgAcademicStudy.setText(StrParser.parseNumberToString(avgReportList.sum("academicStudy")));
                avrgQuranStudy.setText(totalQuranStudiedDay);
                avrgHadithStudy.setText(StrParser.parseNumberToString(avgReportList.sum("hadithStudy")));
                avrgLiteratureStudy.setText(StrParser.parseNumberToString(avgReportList.sum("literatureStudy")));
                avrgSalatWithJamaat.setText(StrParser.parseNumberToString(avgReportList.sum("salatwithJamaat")));
                avrgParticipantIntentContact.setText(StrParser.parseNumberToString(avgReportList.sum("participantIntentContact")));
                avrgVolunteerIntentContact.setText(StrParser.parseNumberToString(avgReportList.sum("volunteerIntentContact")));
                avrgMemberIntentContact.setText(StrParser.parseNumberToString(avgReportList.sum("memberIntentContact")));
                avrgContact.setText(StrParser.parseNumberToString(avgReportList.sum("contact")));
                avrgBookDistribution.setText(StrParser.parseNumberToString(avgReportList.sum("bookDistribution")));
                avrgSocietyWork.setText(StrParser.parseNumberToString(avgReportList.sum("societyWork")));
                avrgFamilyMeeting.setText(totalFamilyMeetingDay);
                avrgVisit.setText(totalVisitedDay);
                avrgReportKeeping.setText(totalReportKeepingDay);
                avrgSelfAssessment.setText(totalSelfAssessmentDay);


                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            try {
                                                pdfGenerate(llR);
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    },500);


            }
        }, 300);
    }

    // check the device orientation and choose layout file.
    private void checkOrientation(){

        int orientation= Activity_Report_Show.this.getResources().getConfiguration().orientation;
        if(orientation == Configuration.ORIENTATION_PORTRAIT) {
            setContentView(R.layout.activity_report_portrait);
            rowRecyclerView=R.layout.row_report_portrait;
            horizontalLayoutManager = new LinearLayoutManager(Activity_Report_Show.this,LinearLayoutManager.VERTICAL,false);



        }/*else if(orientation == Configuration.ORIENTATION_LANDSCAPE){
            setContentView(R.layout.activity_report_landscape);
            rowRecyclerView=R.layout.row_report_landscape;
           horizontalLayoutManager = new LinearLayoutManager(Activity_Report_Show.this,LinearLayoutManager.HORIZONTAL,false);
        }*/
    }
    private void setWidthAndHeight(){
        llReportHeader = findViewById(R.id.llReportHeader);

        llDate = findViewById(R.id.llDate);
        llFooterDate = findViewById(R.id.llFooterDate);


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

    public  void pdfGenerate(View v) throws IOException {

        final  LinearLayout layout = findViewById(R.id.llR);
          ViewTreeObserver vto = layout.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                layout.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                int width  = layout.getMeasuredWidth();
                int height = layout.getMeasuredHeight();

            }
        });



        Bitmap b = Bitmap.createBitmap( 500, 2080, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(b);
        v.layout(v.getLeft(), v.getTop(), v.getRight(), v.getBottom());
        v.draw(c);


        saveBitmap(b);

    }

    public void saveBitmap(Bitmap bitmap) throws IOException {
        String path = Environment.getExternalStorageDirectory().toString();
        OutputStream fOut = null;
        Integer counter = 0;
        File file = new File(path, "FitnessGirl"+counter+".jpg"); // the File to save , append increasing numeric counter to prevent files from getting overwritten.
        fOut = new FileOutputStream(file);

        //Bitmap pictureBitmap = getImageBitmap(myurl); // obtaining the Bitmap
        bitmap.compress(Bitmap.CompressFormat.JPEG, 85, fOut); // saving the Bitmap to a file compressed as a JPEG with 85% compression rate
        fOut.flush(); // Not really required
        fOut.close(); // do not forget to close the stream

        MediaStore.Images.Media.insertImage(getContentResolver(),file.getAbsolutePath(),file.getName(),file.getName());

    }

    @Override
    public void onResume(){
        super.onResume();
        initialize();

        showReportList();

    }

// inner Adapter class for recyclerview
    public class Recycler_View_Adapter  extends RecyclerView.Adapter<Recycler_View_Adapter.View_Holder> {
        private List<com.jolpai.doctorsdiary.Model.Worker.Database.entity.DailyReport> list;
        private Context context;

        public Recycler_View_Adapter(List<com.jolpai.doctorsdiary.Model.Worker.Database.entity.DailyReport> list, Context context) {
            this.list = list;
            this.context = context;
        }


        public class View_Holder extends RecyclerView.ViewHolder{

            RippleView llFooterDate;
            TextView txtDate;
            TextView
                    txtProfessionalWorkd,
                    txtAcademicStudy,
                    txtHadithStudy,
                    txtLiteratureStudy,
                    txtSalatWithJamaat,
                    txtParticipantIntentContact,
                    txtVolunteerIntentContact,
                    txtMemberIntentContact,
                    txtContact,
                    txtBookDistribution,
                    txtSocietyWork;
            CheckBox
                    checkQuranStudy,
                    checkFamilyMeeting,
                    checkVisit,
                    checkReportKeeping,
                    checkSelfAssessment;

            public View_Holder (View itemView){
                super(itemView);
                txtDate = itemView.findViewById(R.id.txtDate);
                txtProfessionalWorkd= itemView.findViewById(R.id.txtProfessionalWork);
                txtAcademicStudy= itemView.findViewById(R.id.txtAcademicStudy);
                txtHadithStudy= itemView.findViewById(R.id.txtHadithStudy);
                txtLiteratureStudy= itemView.findViewById(R.id.txtLiteratureStudy);
                txtSalatWithJamaat= itemView.findViewById(R.id.txtSalatWithJamaat);
                txtParticipantIntentContact= itemView.findViewById(R.id.txtParticipantIntentContact);
                txtVolunteerIntentContact= itemView.findViewById(R.id.txtVolunteerIntentContact);

                txtMemberIntentContact= itemView.findViewById(R.id.txtMemberIntentContact);
                txtContact= itemView.findViewById(R.id.txtContact);
                txtBookDistribution= itemView.findViewById(R.id.txtBookDistribution);
                txtSocietyWork= itemView.findViewById(R.id.txtSocietyWork);

                checkQuranStudy= itemView.findViewById(R.id.checkQuranStudy);
                checkFamilyMeeting= itemView.findViewById(R.id.checkFamilyMeeting);
                checkVisit= itemView.findViewById(R.id.checkVisit);
                checkReportKeeping= itemView.findViewById(R.id.checkReportKeeping);
                checkSelfAssessment= itemView.findViewById(R.id.checkSelfAssessment);
                llFooterDate= this.itemView.findViewById(R.id.llFooterDate);

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
        public void onBindViewHolder(final View_Holder holder, int position) {

            //Use the provided View Holder on the onCreateViewHolder method to populate the current row on the RecyclerView
            final com.jolpai.doctorsdiary.Model.Worker.Database.entity.DailyReport dailyReport = list.get(position);
            holder.txtDate.setText(dailyReport.getToDay()+"");
            holder.txtDate.setBackground(new MyStyle().getShape());


            holder.txtProfessionalWorkd.setText(StrParser.parseIntToString(dailyReport.getProfessionalWork()));

            holder.txtAcademicStudy.setText(StrParser.parseIntToString(dailyReport.getAcademicStudy()));


            if(dailyReport.isQuranStudy()){
                holder.checkQuranStudy.setChecked(dailyReport.isQuranStudy());
                holder.checkQuranStudy.setVisibility(View.VISIBLE);
            }else{
                holder.checkQuranStudy.setChecked(false);
                holder.checkQuranStudy.setVisibility(View.GONE);
            }

            if(dailyReport.getHadithStudy()==0){
                holder.txtHadithStudy.setText("");
            }else{
                holder.txtHadithStudy.setText(dailyReport.getHadithStudy()+"");
            }


            if(dailyReport.getLiteratureStudy()==0){
                holder.txtLiteratureStudy.setText("");
            }else{
                holder.txtLiteratureStudy.setText(dailyReport.getLiteratureStudy()+"");
            }

            if(dailyReport.getSalatwithJamaat() == 0){
                holder.txtSalatWithJamaat.setText("");
            }else{
                holder.txtSalatWithJamaat.setText(dailyReport.getSalatwithJamaat()+"");
            }

            if(dailyReport.getParticipantIntentContact()==0){
                holder.txtParticipantIntentContact.setText("");
            }else{
                holder.txtParticipantIntentContact.setText(dailyReport.getParticipantIntentContact()+"");
            }

            if(dailyReport.getVolunteerIntentContact()==0){
                holder.txtVolunteerIntentContact.setText("");
            }else{
                holder.txtVolunteerIntentContact.setText(dailyReport.getVolunteerIntentContact()+"");
            }

            if(dailyReport.getMemberIntentContact()==0){
                holder.txtMemberIntentContact.setText("");
            }else{
                holder.txtMemberIntentContact.setText(dailyReport.getMemberIntentContact()+"");
            }

            if(dailyReport.getContact()==0){
                holder.txtContact.setText("");
            }else{
                holder.txtContact.setText(dailyReport.getContact()+"");
            }

            if(dailyReport.getBookDistribution()==0){
                holder.txtBookDistribution.setText("");
            }else{
                holder.txtBookDistribution.setText(dailyReport.getBookDistribution()+"");
            }

            if(dailyReport.isFamilyMeeting()){
                holder.checkFamilyMeeting.setChecked(dailyReport.isFamilyMeeting());
                holder.checkFamilyMeeting.setVisibility(View.VISIBLE);
            }else{
                holder.checkFamilyMeeting.setChecked(false);
                holder.checkFamilyMeeting.setVisibility(View.GONE);
            }

            if(dailyReport.getSocietyWork()==0.0){
                holder.txtSocietyWork.setText("");
            }else{
                holder.txtSocietyWork.setText(dailyReport.getSocietyWork()+"");
            }

            if(dailyReport.isVisit()) {
                holder.checkVisit.setChecked(dailyReport.isVisit());
            }else{
                holder.checkVisit.setChecked(false);
                holder.checkVisit.setVisibility(View.GONE);
            }

            if(dailyReport.isReportKeeping()) {
                holder.checkReportKeeping.setChecked(dailyReport.isReportKeeping());
                holder.checkReportKeeping.setVisibility(View.VISIBLE);
            }else{
                holder.checkReportKeeping.setChecked(dailyReport.isReportKeeping());
                holder.checkReportKeeping.setVisibility(View.GONE);
            }

            if(dailyReport.isSelfAssessment()) {
                holder.checkSelfAssessment.setChecked(dailyReport.isSelfAssessment());
                holder.checkSelfAssessment.setVisibility(View.VISIBLE);
            }else{
                holder.checkSelfAssessment.setChecked(false);
                holder.checkSelfAssessment.setVisibility(View.GONE);
            }


            // holder.description.setText(list.get(position).description);
            // holder.imageView.setImageResource(list.get(position).imageId);

            //animate(holder);
            holder.llFooterDate.setTag(dailyReport);
            holder.llFooterDate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(context,holder.txtDate.getText().toString(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context,Activity_Report_Comment_AddEdit.class);
                    com.jolpai.doctorsdiary.Model.Worker.Database.entity.DailyReport report=(com.jolpai.doctorsdiary.Model.Worker.Database.entity.DailyReport)holder.llFooterDate.getTag();

                    intent.putExtra("year",report.getYear()+"");
                    intent.putExtra("month",report.getMonth()+"");
                    intent.putExtra("day",report.getToDay()+"");
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
