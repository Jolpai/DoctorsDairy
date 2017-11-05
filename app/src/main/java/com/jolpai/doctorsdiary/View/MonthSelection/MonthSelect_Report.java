package com.jolpai.doctorsdiary.View.MonthSelection;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;

import com.jolpai.doctorsdiary.App;
import com.jolpai.doctorsdiary.R;
import com.jolpai.doctorsdiary.View.Report.DailyReport;
import com.jolpai.doctorsdiary.Worker.Others.MyDateFormat;

import java.util.ArrayList;

/**
 * A fragment with a Google +1 button.
 * Activities that contain this fragment must implement the
 * {@link MonthSelect_Report.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MonthSelect_Report#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MonthSelect_Report extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String YEAR="YEAR";
    private static final String MONTH="MONTH";

    public View ripleJanuary,ripleFebruary,ripleMarch,ripleApril,ripleMay,ripleJune,
            ripleJuly,ripleAugust,ripleSeptember,ripleOctober,ripleNovember,ripleDecember,allMonth;

    // The request code must be 0 or greater.
    private static final int PLUS_ONE_REQUEST_CODE = 0;
    // The URL to +1.  Must be a valid URL.
    private final String PLUS_ONE_URL = "http://developer.android.com";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public MonthSelect_Report() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MonthSelect_Report.
     */
    // TODO: Rename and change types and number of parameters
    public static MonthSelect_Report newInstance(String param1, String param2) {
        MonthSelect_Report fragment = new MonthSelect_Report();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=null;
        int orientation= MonthSelect_Report.this.getResources().getConfiguration().orientation;
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
        int year=MyDateFormat.getCurrentYear();
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
        Intent intent = new Intent(getContext(),DailyReport.class);
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
        switch (month) {
            case 1:
                ripleJanuary.startAnimation(App.blinkAnim());
                break;
            case 2:
                ripleFebruary.startAnimation(App.blinkAnim());
                break;
            case 3:
                ripleMarch.startAnimation(App.blinkAnim());
                break;
            case 4:
                ripleApril.startAnimation(App.blinkAnim());
                break;
            case 5:
                ripleMay.startAnimation(App.blinkAnim());
                break;
            case 6:
                ripleJune.startAnimation(App.blinkAnim());
                break;
            case 7:
                ripleJuly.startAnimation(App.blinkAnim());
                break;
            case 8:
                ripleAugust.startAnimation(App.blinkAnim());
                break;
            case 9:
                ripleSeptember.startAnimation(App.blinkAnim());
                break;
            case 10:
                ripleOctober.startAnimation(App.blinkAnim());
                break;
            case 11:
                ripleNovember.startAnimation(App.blinkAnim());
                break;
            case 12:
                ripleDecember.startAnimation(App.blinkAnim());
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