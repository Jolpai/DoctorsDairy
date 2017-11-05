package com.jolpai.doctorsdiary.View.Report;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.jolpai.doctorsdiary.R;
import com.jolpai.doctorsdiary.Worker.Others.MyDateFormat;
import com.jolpai.doctorsdiary.Worker.Parse.DoubleParser;
import com.jolpai.doctorsdiary.Worker.Database.GetData;
import com.jolpai.doctorsdiary.Worker.Parse.IntParser;
import com.jolpai.doctorsdiary.Worker.Database.POJO.DailyReport;
import com.jolpai.doctorsdiary.Worker.Database.SaveData;
import com.jolpai.doctorsdiary.Worker.Parse.StrParser;


import io.realm.RealmResults;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AddEdit_Report.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AddEdit_Report#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddEdit_Report extends Fragment  {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String YEAR = "YEAR";
    private static final String MONTH = "MONTH";
    private static final String DAY="DAY";

    // TODO: Rename and change types of parameters
    private int year;
    private int month;
    private int day;
    private String reportingDate;

    private TextView txtDate;
    private EditText
            editProfessionalWorkd,
            editAcademicStudy,
            editHadithStudy,
            editLiteratureStudy,
            editSalatWithJamaat,
            editParticipantIntentContact,
            editVolunteerIntentContact,
            editMemberIntentContact,
            editContact,
            editBookDistribution,
            editSocietyWork;
    private CheckBox
            checkQuranStudy,
            checkFamilyMeeting,
            checkVisit,
            checkReportKeeping,
            checkSelfAssessment;



    private OnFragmentInteractionListener mListener;

    public AddEdit_Report() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param year year.
     * @param month selected month of this year.
     * @param day selected day of this month.
     * @return A new instance of fragment AddEdit_Report.
     */
    // TODO: Rename and change types and number of parameters
    public static AddEdit_Report newInstance(String year, String month, String day) {
        AddEdit_Report fragment = new AddEdit_Report();
        Bundle bundle = new Bundle();
        bundle.putString(YEAR, year);
        bundle.putString(MONTH, month);
        bundle.putString(DAY,day);

        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            year = IntParser.parseStrToInt(getArguments().getString(YEAR));
            month = IntParser.parseStrToInt(getArguments().getString(MONTH));
            day = IntParser.parseStrToInt(getArguments().getString(DAY));
            reportingDate = MyDateFormat.getDateDDMMYY(year,month,day);
        }
        setHasOptionsMenu(true);

    }

    private void initialization(View v) {
        txtDate =(TextView) v.findViewById(R.id.txtDate);
        editProfessionalWorkd=(EditText) v.findViewById(R.id.editProfessionalWork);
        editAcademicStudy=(EditText) v.findViewById(R.id.editAcademicStudy);
        editHadithStudy=(EditText) v.findViewById(R.id.editHadithStudy);
        editLiteratureStudy=(EditText) v.findViewById(R.id.editLiteratureStudy);
        editSalatWithJamaat=(EditText) v.findViewById(R.id.editSalatWithJamaat);
        editParticipantIntentContact=(EditText) v.findViewById(R.id.editParticipantIntentContact);
        editVolunteerIntentContact=(EditText) v.findViewById(R.id.editVolunteerIntentContact);

        editMemberIntentContact=(EditText) v.findViewById(R.id.editMemberIntentContact);
        editContact=(EditText) v.findViewById(R.id.editContact);
        editBookDistribution=(EditText) v.findViewById(R.id.editBookDistribution);
        editSocietyWork=(EditText) v.findViewById(R.id.editSocietyWork);

        checkQuranStudy=(CheckBox) v.findViewById(R.id.checkQuranStudy);
        checkFamilyMeeting=(CheckBox) v.findViewById(R.id.checkFamilyMeeting);
        checkVisit=(CheckBox) v.findViewById(R.id.checkVisit);
        checkReportKeeping=(CheckBox) v.findViewById(R.id.checkReportKeeping);
        checkSelfAssessment=(CheckBox) v.findViewById(R.id.checkSelfAssessment);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_add_edit, container, false);
        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        Button btnSave =(Button) toolbar.findViewById(R.id.btnSave);
        initialization(view);
        final RealmResults<DailyReport> reportList = GetData.getOneDayReportFromRealm(getContext(), (Class)DailyReport.class,reportingDate);

        if(reportList.size()>0){
            DailyReport report =reportList.get(0);
            setDataToReportInterface(report);
            if(report.isHasReport()) {
                btnSave.setText("Update");
            }else{
                btnSave.setText("Save");
            }

        }else{
            txtDate.setText(reportingDate);
        }

        /*btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });*/

        return view;
    }

    public void save(){
        DailyReport report = new DailyReport();
        report.setDate(reportingDate);
        report.setToDay(day);
        report.setMonth(month);
        report.setYear(year);

        report.setProfessionalWork(IntParser.parseStrToInt(editProfessionalWorkd.getText().toString()));
        report.setAcademicStudy(IntParser.parseStrToInt(editAcademicStudy.getText().toString()));
        report.setQuranStudy(checkQuranStudy.isChecked());
        report.setHadithStudy(IntParser.parseStrToInt(editHadithStudy.getText().toString()));
        report.setLiteratureStudy(IntParser.parseStrToInt(editLiteratureStudy.getText().toString()));
        report.setSalatwithJamaat(IntParser.parseStrToInt(editSalatWithJamaat.getText().toString()));
        report.setParticipantIntentContact(IntParser.parseStrToInt(editParticipantIntentContact.getText().toString()));
        report.setVolunteerIntentContact(IntParser.parseStrToInt(editVolunteerIntentContact.getText().toString()));
        report.setMemberIntentContact(IntParser.parseStrToInt(editMemberIntentContact.getText().toString()));
        report.setContact(IntParser.parseStrToInt(editContact.getText().toString()));
        report.setBookDistribution(IntParser.parseStrToInt(editBookDistribution.getText().toString()));
        report.setFamilyMeeting(checkFamilyMeeting.isChecked());
        report.setSocietyWork(DoubleParser.parseStrToDouble(editSocietyWork.getText().toString()));
        report.setVisit(checkVisit.isChecked());
        report.setReportKeeping(checkReportKeeping.isChecked());
        report.setSelfAssessment(checkSelfAssessment.isChecked());

        report.setHasReport(checkReportStatus(report));

        SaveData.saveDataToRealm(getContext(),report,(Class)DailyReport.class);

        getActivity().finish();

        Toast.makeText(getActivity(),"Action Successfully Done",Toast.LENGTH_SHORT).show();
    }

    private void setDataToReportInterface(DailyReport report) {

        txtDate.setText(report.getDate());
        editProfessionalWorkd.setText(StrParser.parseIntToString(report.getProfessionalWork()));
        editAcademicStudy.setText(StrParser.parseIntToString(report.getAcademicStudy()));
        editHadithStudy.setText(StrParser.parseIntToString(report.getHadithStudy()));
        editLiteratureStudy.setText(StrParser.parseIntToString(report.getLiteratureStudy()));
        editSalatWithJamaat.setText(StrParser.parseIntToString(report.getSalatwithJamaat()));
        editParticipantIntentContact.setText(StrParser.parseIntToString(report.getParticipantIntentContact()));
        editVolunteerIntentContact.setText(StrParser.parseIntToString(report.getVolunteerIntentContact()));

        editMemberIntentContact.setText(StrParser.parseIntToString(report.getMemberIntentContact()));
        editContact.setText(StrParser.parseIntToString(report.getContact()));
        editBookDistribution.setText(StrParser.parseIntToString(report.getBookDistribution()));
        editSocietyWork.setText(StrParser.parseDoubleToString(report.getSocietyWork()));

        checkQuranStudy.setChecked(report.isQuranStudy());
        checkFamilyMeeting.setChecked(report.isFamilyMeeting());
        checkVisit.setChecked(report.isVisit());
        checkReportKeeping.setChecked(report.isReportKeeping());
        checkSelfAssessment.setChecked(report.isSelfAssessment());
    }

    private boolean checkReportStatus(DailyReport report) {
        if(report.getProfessionalWork()!= 0){
            return true;
        }
        if(report.getAcademicStudy()!= 0){
            return true;
        }
        if(report.isQuranStudy()){
            return true;
        }
        if(report.getHadithStudy()!=0){
            return true;
        }
        if(report.getLiteratureStudy()!=0){
            return true;
        }
        if(report.getSalatwithJamaat()!=0){
            return true;
        }
        if(report.getParticipantIntentContact()!=0){
            return true;
        }
        if(report.getVolunteerIntentContact()!=0) {
           return true;
        }
        if(report.getMemberIntentContact()!=0){
            return true;
        }
        if(report.getContact()!=0){
            return true;
        }
        if(report.getBookDistribution()!=0){
            return true;
        }
        if(report.isFamilyMeeting()){
            return true;
        }
        if(report.getSocietyWork()!= 0.0){
            return true;
        }
        if(report.isVisit()){
            return true;
        }
        if(report.isReportKeeping()){
            return true;
        }
        if(report.isSelfAssessment()){
            return true;
        }

        return false;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
       /* if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }*/
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }



    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
