package com.jolpai.doctorsdiary.View.Report;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
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
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.widget.Spinner;

import com.jolpai.doctorsdiary.Model.Worker.Parse.IntParser;
import com.jolpai.doctorsdiary.R;
import com.jolpai.doctorsdiary.Model.Worker.Animation.BlinkAnimator;
import com.jolpai.doctorsdiary.Model.Worker.Others.MyDateFormat;

import java.util.ArrayList;


/**
 * A fragment with a Google +1 button.
 * Activities that contain this fragment must implement the
 * {@link Fragment_Report_MonthSelect.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Fragment_Report_MonthSelect#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_Report_MonthSelect extends Fragment implements View.OnClickListener {

    private static final String YEAR="YEAR";
    private static final String MONTH="MONTH";

    public View ripleJanuary,
            ripleFebruary,
            ripleMarch,
            ripleApril,
            ripleMay,
            ripleJune,
            ripleJuly,
            ripleAugust,
            ripleSeptember,
            ripleOctober,
            ripleNovember,
            ripleDecember,
            allMonth;
    Spinner spnrYear;

    // The request code must be 0 or greater.
    private static final int PLUS_ONE_REQUEST_CODE = 0;
    // The URL to +1.  Must be a valid URL.
    private final String PLUS_ONE_URL = "http://developer.android.com";
    // TODO: Rename and change types of parameters
    private String currentYear;
    private String currentMonth;

    private OnFragmentInteractionListener mListener;

    public Fragment_Report_MonthSelect() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param year Parameter 1.
     * @param month Parameter 2.
     * @return A new instance of fragment Fragment_Report_MonthSelect.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_Report_MonthSelect newInstance(String year, String month) {
        Fragment_Report_MonthSelect fragment = new Fragment_Report_MonthSelect();
        Bundle bundle = new Bundle();
        bundle.putString(YEAR, year);
        bundle.putString(MONTH, month);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            currentYear = getArguments().getString(YEAR);
            currentMonth = getArguments().getString(MONTH);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=null;
        int orientation= Fragment_Report_MonthSelect.this.getResources().getConfiguration().orientation;
        if(orientation == Configuration.ORIENTATION_PORTRAIT) {
            v =inflater.inflate(R.layout.fragment_month_for_report_portrait, container, false);

        }else if(orientation == Configuration.ORIENTATION_LANDSCAPE){
            v= inflater.inflate(R.layout.fragment_month_for_report_landscape, container, false);
        }

        init(v);

        /*final RippleBackground rippleBackground=(RippleBackground)v.findViewById(R.id.ripleOctober);
        ripleOctober=v.findViewById(R.id.ripleNovember);
        final Handler handler=new Handler();

        ripleOctober.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rippleBackground.startRippleAnimation();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        foundDevice();
                    }
                },3000);
            }
        });*/

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();

        // Refresh the state of the +1 button each time the activity receives focus.

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
        Intent intent = new Intent(getContext(),Activity_Report_Show.class);
        intent.putExtra(YEAR,year);
        intent.putExtra(MONTH,month);
        getContext().startActivity(intent);
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

        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        spnrYear =(Spinner) toolbar.findViewById(R.id.spnrYear);

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

        setAnimation();
    }

    private void setAnimation() {

        int month = MyDateFormat.getCurrentMonth();
        Animation blinkAnimation=BlinkAnimator.blink();
        switch (month) {
            case 1:
                ripleJanuary.startAnimation(blinkAnimation);
                break;
            case 2:
                ripleFebruary.startAnimation(blinkAnimation);
                break;
            case 3:
                ripleMarch.startAnimation(blinkAnimation);
                break;
            case 4:
                ripleApril.startAnimation(blinkAnimation);
                break;
            case 5:
                ripleMay.startAnimation(blinkAnimation);
                break;
            case 6:
                ripleJune.startAnimation(blinkAnimation);
                break;
            case 7:
                ripleJuly.startAnimation(blinkAnimation);
                break;
            case 8:
                ripleAugust.startAnimation(blinkAnimation);
                break;
            case 9:
                ripleSeptember.startAnimation(blinkAnimation);
                break;
            case 10:
                ripleOctober.startAnimation(blinkAnimation);
                break;
            case 11:
                ripleNovember.startAnimation(blinkAnimation);
                break;
            case 12:
                ripleDecember.startAnimation(blinkAnimation);
                break;
            case 0:
                break;
        }
    }

    private void foundDevice(){
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(400);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        ArrayList<ObjectAnimator> animatorList=new ArrayList<>();
        ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat(ripleOctober, "ScaleX", 0f, 1.2f, 1f);
        animatorList.add(scaleXAnimator);
        ObjectAnimator scaleYAnimator = ObjectAnimator.ofFloat(ripleOctober, "ScaleY", 0f, 1.2f, 1f);
        animatorList.add(scaleYAnimator);
        //animatorSet.playTogether(animatorList);
        ripleOctober.setVisibility(View.VISIBLE);
        animatorSet.start();
    }


}
