package com.jolpai.doctorsdiary.IO.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jolpai.doctorsdiary.R;
import com.jolpai.doctorsdiary.Worker.IntParser;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CommentOnReport.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CommentOnReport#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CommentOnReport extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String YEAR = "YEAR";
    private static final String MONTH = "MONTH";
    private static final String DAY="DAY";

    private int year;
    private int month;
    private int day;

    private OnFragmentInteractionListener mListener;

    public CommentOnReport() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param year Parameter 1. selected year by uers
     * @param month Parameter 2. selected month of @param year
     * @param day Parameter 3. selected day of @param month
     * @return A new instance of fragment CommentOnReport.
     */
    // TODO: Rename and change types and number of parameters
    public static CommentOnReport newInstance(String year, String month,String day) {
        CommentOnReport fragment = new CommentOnReport();
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
        }
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =null;
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            view=inflater.inflate(R.layout.v21_fragment_comment, container, false);
        }



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
        /*if (context instanceof OnFragmentInteractionListener) {
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
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */

    public View setParentLayout(){
        View view =null;

        return view;
    }
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
