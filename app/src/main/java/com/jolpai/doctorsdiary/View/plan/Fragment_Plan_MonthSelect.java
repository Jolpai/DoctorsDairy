package com.jolpai.doctorsdiary.View.plan;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import com.jolpai.doctorsdiary.Model.Worker.Parse.IntParser;
import com.jolpai.doctorsdiary.Model.Worker.Animation.BlinkAnimator;
import com.jolpai.doctorsdiary.R;
import com.jolpai.doctorsdiary.Model.Worker.Others.MyDateFormat;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Fragment_Plan_MonthSelect.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Fragment_Plan_MonthSelect#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_Plan_MonthSelect extends Fragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String SELECTED_YEAR = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String YEAR="YEAR";
    private static final String MONTH="MONTH";

    public View ripleJanuary,ripleFebruary,ripleMarch,ripleApril,ripleMay,ripleJune,
            ripleJuly,ripleAugust,ripleSeptember,ripleOctober,ripleNovember,ripleDecember,allMonth;

    Spinner spnrYear;
    // TODO: Rename and change types of parameters
    private String selectedYear;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Fragment_Plan_MonthSelect() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param year  Selected Year, it comes from spinner by user.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_Plan_MonthSelect.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_Plan_MonthSelect newInstance(String year, String param2) {
        Fragment_Plan_MonthSelect fragment = new Fragment_Plan_MonthSelect();
        Bundle args = new Bundle();
        args.putString(SELECTED_YEAR, year);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            selectedYear = getArguments().getString(SELECTED_YEAR);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v =null;

        int orientation= Fragment_Plan_MonthSelect.this.getResources().getConfiguration().orientation;
        if(orientation == Configuration.ORIENTATION_PORTRAIT) {
            v= inflater.inflate(R.layout.fragment_month_for_plan_portrait, container, false);

        }else if(orientation == Configuration.ORIENTATION_LANDSCAPE){
            v= inflater.inflate(R.layout.fragment_month_for_plan_landscape, container, false);
        }

        init(v);

        return v;
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
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        int id=v.getId();
        //int year=MyDateFormat.getCurrentYear();
        int year= IntParser.parseStrToInt(spnrYear.getSelectedItem().toString());
        switch (id){
            case R.id.ripleJanuary:
                openActivity(year,1);
                break;
            case R.id.ripleFebruary:
                openActivity(year,2);
                break;
            case R.id.ripleMarch:
                openActivity(year,3);
                break;
            case R.id.ripleApril:
                openActivity(year,4);
                break;
            case R.id.ripleMay:
                openActivity(year,5);
                break;
            case R.id.ripleJune:
                openActivity(year,6);
                break;
            case R.id.ripleJuly:
                openActivity(year,7);
                break;
            case R.id.ripleAugust:
                openActivity(year,8);
                break;
            case R.id.ripleSeptember:
                openActivity(year,9);
                break;
            case R.id.ripleOctober:
                openActivity(year,10);
                break;
            case R.id.ripleNovember:
                openActivity(year,11);
                break;
            case R.id.ripleDecember:
                openActivity(year,12);
                break;
            default:
                break;

        }
    }

    private void openActivity(int year,int month){
        Intent intent = new Intent(getContext(),Activity_Plan_AddEdit.class);
        intent.putExtra(YEAR,year);
        intent.putExtra(MONTH,month);
        getContext().startActivity(intent);
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



    private void init(View view){
        ripleJanuary=view.findViewById(R.id.ripleJanuary);
        ripleFebruary=view.findViewById(R.id.ripleFebruary);
        ripleMarch=view.findViewById(R.id.ripleMarch);
        ripleApril=view.findViewById(R.id.ripleApril);
        ripleMay=view.findViewById(R.id.ripleMay);
        ripleJune=view.findViewById(R.id.ripleJune);
        ripleJuly=view.findViewById(R.id.ripleJuly);
        ripleAugust=view.findViewById(R.id.ripleAugust);
        ripleSeptember=view.findViewById(R.id.ripleSeptember);
        ripleOctober=view.findViewById(R.id.ripleOctober);
        ripleNovember=view.findViewById(R.id.ripleNovember);
        ripleDecember=view.findViewById(R.id.ripleDecember);

        ripleJanuary.setOnClickListener(this);
        ripleFebruary.setOnClickListener(this);
        ripleMarch.setOnClickListener(this);
        ripleApril.setOnClickListener(this);
        ripleMay.setOnClickListener(this);
        ripleJune.setOnClickListener(this);
        ripleJuly.setOnClickListener(this);
        ripleAugust.setOnClickListener(this);
        ripleSeptember.setOnClickListener(this);
        ripleOctober.setOnClickListener(this);
        ripleNovember.setOnClickListener(this);
        ripleDecember.setOnClickListener(this);

        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        spnrYear =(Spinner) toolbar.findViewById(R.id.spnrYear);
        setAnimation();
    }

    private void setAnimation() {

        int month= MyDateFormat.getCurrentMonth();
        switch (month){
            case 1:
                ripleJanuary.startAnimation(BlinkAnimator.blink());
                break;
            case 2:
                ripleFebruary.startAnimation(BlinkAnimator.blink());
                break;
            case 3:
                ripleMarch.startAnimation(BlinkAnimator.blink());
                break;
            case 4:
                ripleApril.startAnimation(BlinkAnimator.blink());
                break;
            case 5:
                ripleMay.startAnimation(BlinkAnimator.blink());
                break;
            case 6:
                ripleJune.startAnimation(BlinkAnimator.blink());
                break;
            case 7:
                ripleJuly.startAnimation(BlinkAnimator.blink());
                break;
            case 8:
                ripleAugust.startAnimation(BlinkAnimator.blink());
                break;
            case 9:
                ripleSeptember.startAnimation(BlinkAnimator.blink());
                break;
            case 10:
                ripleOctober.startAnimation(BlinkAnimator.blink());
                break;
            case 11:
                ripleNovember.startAnimation(BlinkAnimator.blink());
                break;
            case 12:
                ripleDecember.startAnimation(BlinkAnimator.blink());
                break;
            case 0:
                break;
        }

    }
}
