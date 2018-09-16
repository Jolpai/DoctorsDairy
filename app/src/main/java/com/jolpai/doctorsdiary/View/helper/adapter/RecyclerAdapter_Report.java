package com.jolpai.doctorsdiary.View.helper.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.andexert.library.RippleView;
import com.jolpai.doctorsdiary.Model.Worker.Database.entity.DailyReport;
import com.jolpai.doctorsdiary.View.Report.Activity_Report_Comment_AddEdit;
import com.jolpai.doctorsdiary.View.helper.MyStyle;
import com.jolpai.doctorsdiary.R;
import com.jolpai.doctorsdiary.Model.Worker.Parse.StrParser;

import java.util.List;


/**
 * Created by User on 1/25/2017.
 */

public class RecyclerAdapter_Report   extends RecyclerView.Adapter<RecyclerAdapter_Report.View_Holder> {
        private List<DailyReport> list;
        private Context context;
        private int rowRecyclerView;

        public RecyclerAdapter_Report(List<DailyReport> list, Context context,int rowRecyclerView) {
            this.list = list;
            this.context = context;
            this.rowRecyclerView=rowRecyclerView;
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
                txtDate =(TextView) itemView.findViewById(R.id.txtDate);
                txtProfessionalWorkd=(TextView) itemView.findViewById(R.id.txtProfessionalWork);
                txtAcademicStudy=(TextView) itemView.findViewById(R.id.txtAcademicStudy);
                txtHadithStudy=(TextView) itemView.findViewById(R.id.txtHadithStudy);
                txtLiteratureStudy=(TextView) itemView.findViewById(R.id.txtLiteratureStudy);
                txtSalatWithJamaat=(TextView) itemView.findViewById(R.id.txtSalatWithJamaat);
                txtParticipantIntentContact=(TextView) itemView.findViewById(R.id.txtParticipantIntentContact);
                txtVolunteerIntentContact=(TextView) itemView.findViewById(R.id.txtVolunteerIntentContact);

                txtMemberIntentContact=(TextView) itemView.findViewById(R.id.txtMemberIntentContact);
                txtContact=(TextView) itemView.findViewById(R.id.txtContact);
                txtBookDistribution=(TextView) itemView.findViewById(R.id.txtBookDistribution);
                txtSocietyWork=(TextView) itemView.findViewById(R.id.txtSocietyWork);

                checkQuranStudy=(CheckBox) itemView.findViewById(R.id.checkQuranStudy);
                checkFamilyMeeting=(CheckBox) itemView.findViewById(R.id.checkFamilyMeeting);
                checkVisit=(CheckBox) itemView.findViewById(R.id.checkVisit);
                checkReportKeeping=(CheckBox) itemView.findViewById(R.id.checkReportKeeping);
                checkSelfAssessment=(CheckBox) itemView.findViewById(R.id.checkSelfAssessment);
                llFooterDate=(RippleView) this.itemView.findViewById(R.id.llFooterDate);

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

            final DailyReport dailyReport = list.get(position);
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
                    DailyReport report=(DailyReport)holder.llFooterDate.getTag();

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
