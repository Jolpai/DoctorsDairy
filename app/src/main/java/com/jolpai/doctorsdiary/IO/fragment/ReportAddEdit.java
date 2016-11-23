package com.jolpai.doctorsdiary.IO.fragment;

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
import com.jolpai.doctorsdiary.Worker.DoubleParser;
import com.jolpai.doctorsdiary.Worker.IntParser;
import com.jolpai.doctorsdiary.Realm_Model.DailyReport;
import com.jolpai.doctorsdiary.Worker.SaveData;


import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ReportAddEdit.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ReportAddEdit#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ReportAddEdit extends Fragment  {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String YEAR = "";
    private static final String MONTH = "";
    private static final String DAY="";

    // TODO: Rename and change types of parameters
    private int year;
    private int month;
    private int day;

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

    public ReportAddEdit() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param year year.
     * @param month selected month of this year.
     * @param day selected day of this month.
     * @return A new instance of fragment ReportAddEdit.
     */
    // TODO: Rename and change types and number of parameters
    public static ReportAddEdit newInstance(int year, int month,int day) {
        ReportAddEdit fragment = new ReportAddEdit();
        Bundle bundle = new Bundle();
        bundle.putInt(YEAR, year);
        bundle.putInt(MONTH, month);
        bundle.putInt(DAY,day);

        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            year = getArguments().getInt(YEAR);
            month = getArguments().getInt(MONTH);
            day = getArguments().getInt(DAY);
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
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"clicked",Toast.LENGTH_SHORT).show();
                //
                Calendar c = Calendar.getInstance();
                System.out.println("Current time => " + c.getTime());

                SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
                String fDate = df.format(c.getTime());


               // int yy = c.get(Calendar.YEAR);
               // int mm = c.get(Calendar.MONTH)+1;
               // int dd = c.get(Calendar.DAY_OF_MONTH);


                DailyReport report = new DailyReport();
                report.setDate(fDate);
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


                SaveData.saveDataToRealm(getContext(),report,(Class)DailyReport.class);

                getActivity().finish();

               // RealmResults<DailyReport> results = GetData.getDataFromRealm(getContext(),(Class)DailyReport.class);


            }
        });

        return view;
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
