package com.jolpai.doctorsdairy.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.LinearLayout;

import com.andexert.library.RippleView;
import com.jolpai.doctorsdairy.App;
import com.jolpai.doctorsdairy.R;
import com.jolpai.doctorsdairy.activity.DailyReport;
import com.jolpai.doctorsdairy.activity.MonthlyPlan;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MonthForPlan.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MonthForPlan#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MonthForPlan extends Fragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    public View ripleJanuary,ripleFebruary,ripleMarch,ripleApril,ripleMay,ripleJune,
            ripleJuly,ripleAugust,ripleSeptember,ripleOctober,ripleNovember,ripleDecember,allMonth;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public MonthForPlan() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MonthForPlan.
     */
    // TODO: Rename and change types and number of parameters
    public static MonthForPlan newInstance(String param1, String param2) {
        MonthForPlan fragment = new MonthForPlan();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v =null;

        int orientation= MonthForPlan.this.getResources().getConfiguration().orientation;
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
        switch (id){
            case R.id.ripleJanuary:
                //ToDo
                break;
            case R.id.ripleFebruary:

                break;
            case R.id.ripleMarch:

                break;
            case R.id.ripleApril:

                break;
            case R.id.ripleMay:

                break;
            case R.id.ripleJune:

                break;
            case R.id.ripleJuly:

                break;
            case R.id.ripleAugust:

                break;
            case R.id.ripleSeptember:

                break;
            case R.id.ripleOctober:
                openActivity();
                break;
            case R.id.ripleNovember:

                break;
            case R.id.ripleDecember:

                break;
            default:
                break;

        }
    }

    private void openActivity(){
        Intent inent = new Intent(getContext(),MonthlyPlan.class);
        getContext().startActivity(inent);
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


        setAnimation();
    }

    private void setAnimation() {

        int month=10;
        switch (month){
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
}
