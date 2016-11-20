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
import com.jolpai.doctorsdiary.Worker.GetData;
import com.jolpai.doctorsdiary.Worker.IntParser;
import com.jolpai.doctorsdiary.Worker.SaveData;
import com.jolpai.doctorsdiary.Realm_Model.DailyReport;


import java.util.Calendar;
import java.util.Date;

import io.realm.RealmResults;

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
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

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
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ReportAddEdit.
     */
    // TODO: Rename and change types and number of parameters
    public static ReportAddEdit newInstance(int param1, String param2) {
        ReportAddEdit fragment = new ReportAddEdit();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
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
                //getActivity().finish();
                Calendar now =Calendar.getInstance();
                Date date = now .getTime();


                DailyReport report = new DailyReport();
                report.setDate(date.toString());
                report.setToDay(date.getDay());
                report.setMonth(date.getMonth());
                report.setYear(date.getYear());
                report.setProfessionalWork(IntParser.StrToInt(editProfessionalWorkd.getText().toString()));
                report.setAcademicStudy(IntParser.StrToInt(editAcademicStudy.getText().toString()));
                report.setQuranStudy(checkQuranStudy.isChecked());
                report.setHadithStudy(IntParser.StrToInt(editHadithStudy.getText().toString()));
                report.setLiteratureStudy(IntParser.StrToInt(editLiteratureStudy.getText().toString()));
                report.setSalatwithJamaat(IntParser.StrToInt(editSalatWithJamaat.getText().toString()));
                report.setParticipantIntentContact(IntParser.StrToInt(editParticipantIntentContact.getText().toString()));
                report.setVolunteerIntentContact(IntParser.StrToInt(editVolunteerIntentContact.getText().toString()));
                report.setMemberIntentContact(IntParser.StrToInt(editMemberIntentContact.getText().toString()));
                report.setContact(IntParser.StrToInt(editContact.getText().toString()));
                report.setBookDistribution(IntParser.StrToInt(editBookDistribution.getText().toString()));
                report.setFamilyMeeting(checkFamilyMeeting.isChecked());
                report.setSocietyWork(DoubleParser.parseStrToDouble(editSocietyWork.getText().toString()));
                report.setVisit(checkVisit.isChecked());
                report.setReportKeeping(checkReportKeeping.isChecked());
                report.setSelfAssessment(checkSelfAssessment.isChecked());


                SaveData.saveDataToRealm(getContext(),report,(Class)DailyReport.class);

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
