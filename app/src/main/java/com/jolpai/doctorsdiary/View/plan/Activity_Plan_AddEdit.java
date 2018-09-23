package com.jolpai.doctorsdiary.View.plan;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.jolpai.doctorsdiary.R;
import com.jolpai.doctorsdiary.Model.Worker.Database.entity.PlanForMonth;
import com.jolpai.doctorsdiary.View.helper.adapter.RecyclerAdapter_Plan;
import com.jolpai.doctorsdiary.Model.Worker.Database.GetData;
import com.jolpai.doctorsdiary.Model.Worker.Database.SaveData;
import com.jolpai.doctorsdiary.Model.Worker.Listener.ItemTouchListener_Plan;
import com.jolpai.doctorsdiary.Model.Worker.Others.MyCalendar;
import com.jolpai.doctorsdiary.Model.Worker.Others.MyDateFormat;
import com.jolpai.doctorsdiary.Model.Worker.Others.MyToast;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

import io.realm.RealmResults;

public class Activity_Plan_AddEdit extends AppCompatActivity implements View.OnClickListener,
        DatePickerDialog.OnDateSetListener{

    private static final String YEAR="YEAR";
    private static final String MONTH="MONTH";
    private static String commentDate = MyDateFormat.getDateTimeNow();

    TextView txtDateIntent,txtDateContact;
    EditText editTextPersonName;
    Spinner spinnerType;
    static FragmentManager fragmentManager;
    TextView dateView;
    Button btnSave;
    int year=0;
    int month=0;
    int daysOfMonth=0;

    private ArrayList<PlanForMonth> planForMonthsList;
    private RecyclerView recyclerView_PlanList;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monthly_plan);
        initialization();

    }

    private void initialization(){
        Intent intent=this.getIntent();
        if(intent != null){
            year=intent.getIntExtra(YEAR,0);
            month=intent.getIntExtra(MONTH,0);
        }
        daysOfMonth= MyDateFormat.getNumOfDayOfMonth(year,month-1);

        txtDateIntent =(TextView) findViewById(R.id.txtDateIntent);
        txtDateContact=(TextView) findViewById(R.id.txtDateContact);
        editTextPersonName =(EditText)findViewById(R.id.editTextPersonName);
        spinnerType=(Spinner)findViewById(R.id.spinnerType);
        btnSave =(Button)findViewById(R.id.btnSave);
        recyclerView_PlanList=(RecyclerView)findViewById(R.id.recyclerPlanList) ;
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Doctor's Diary");
        fragmentManager =getFragmentManager();

        String[] items = new String[3];

        items[0] = "Participant";
        items[1] = "Volunteer";
        items[2] = "Member";


        ArrayAdapter<String> adapter = new ArrayAdapter<>(Activity_Plan_AddEdit.this, R.layout.x_row_span, items);
        adapter.setDropDownViewResource(R.layout.row_spinner_plan_green);
        spinnerType.setAdapter(adapter);
        spinnerType.setSelection(0,true);

        txtDateIntent.setOnClickListener(this);

        txtDateContact.setOnClickListener(this);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlanForMonth planForMonth=new PlanForMonth();
                String currentDateTime = MyDateFormat.getDateTimeNow();
                if(checkValidation()) {

                    planForMonth.setDate(currentDateTime);
                    if (btnSave.getText().toString().equalsIgnoreCase("update")) {
                        planForMonth.setDate(commentDate);
                    }
                    planForMonth.setYear(year);
                    planForMonth.setMonth(month);
                    planForMonth.setPlanDate(currentDateTime);
                    planForMonth.setIntentDate(txtDateIntent.getText().toString());
                    planForMonth.setContactDate(txtDateContact.getText().toString());
                    planForMonth.setType(spinnerType.getSelectedItem().toString());
                    planForMonth.setTargetName(editTextPersonName.getText().toString());
                    SaveData.saveDataToRealm(Activity_Plan_AddEdit.this, planForMonth, (Class) PlanForMonth.class);

                    showPlanList();
                    clear();
                }
            }
        });

        recyclerView_PlanList.addOnItemTouchListener(
            new ItemTouchListener_Plan(Activity_Plan_AddEdit.this,recyclerView_PlanList,
            new ItemTouchListener_Plan.OnItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {
                    PlanForMonth planForMonth =(PlanForMonth)view.getTag();
                    editTextPersonName.setText(planForMonth.getTargetName());
                    txtDateContact.setText(planForMonth.getContactDate());
                    txtDateIntent.setText(planForMonth.getIntentDate());
                    String spinnerValue=planForMonth.getType().toString();

                    String s =spinnerType.getSelectedItem().toString();
                    if(spinnerValue.equalsIgnoreCase("Participant")){
                        /*spinnerType.setAdapter(null);
                        String[] items = {"Participant","Volunteer","Member"};
                        ArrayAdapter<String> adapter = new ArrayAdapter<>(Activity_Plan_AddEdit.this, R.layout.x_row_span, items);
                        adapter.setDropDownViewResource(R.layout.row_spinner_plan_green);
                        spinnerType.setAdapter(adapter);*/
                        spinnerType.setSelection(0,true);

                    }else if(spinnerValue.equalsIgnoreCase("Volunteer")){
                        /*spinnerType.setAdapter(null);
                        String[] items = {"Participant","Volunteer","Member"};
                        ArrayAdapter<String> adapter = new ArrayAdapter<>(Activity_Plan_AddEdit.this, R.layout.x_row_span, items);
                        adapter.setDropDownViewResource(R.layout.row_spinner_plan_green);
                        spinnerType.setAdapter(adapter);*/
                        spinnerType.setSelection(1,true);

                    }else if(spinnerValue.equalsIgnoreCase("Member")){
                        /*spinnerType.setAdapter(null);
                        String[] items = {"Participant","Volunteer","Member"};
                        ArrayAdapter<String> adapter = new ArrayAdapter<>(Activity_Plan_AddEdit.this, R.layout.x_row_span, items);
                        adapter.setDropDownViewResource(R.layout.row_spinner_plan_green);
                        spinnerType.setAdapter(adapter);*/
                        spinnerType.setSelection(2,true);
                    }

                    btnSave.setText("UPDATE");
                    commentDate=planForMonth.getDate();
                }

                @Override
                public void onLongItemClick(View view, int position) {

                }
            })
        );
    }

    private void clear(){

        txtDateContact.setText("Date");
        txtDateIntent.setText("Date");
        editTextPersonName.setText("");
        spinnerType.setSelection(0);
        btnSave.setText("SAVE");
       // clearFocous();

    }

    private boolean checkValidation(){
        String personName =editTextPersonName.getText().toString();
        String dateIntent=txtDateIntent.getText().toString();
        String dateContact =txtDateContact.getText().toString();
        View focuasableView;
        if(personName.equalsIgnoreCase("")){
            MyToast.toast_short("Please Enter Your Name.");
            return false;

        }else if(dateIntent.equalsIgnoreCase("Date")){
            MyToast.toast_short("Please Select Intent Date");
            return false;
        }else if(dateContact.equalsIgnoreCase("Date")){
            MyToast.toast_short("Please Select Contact Date");
            return false;
        }
        return true;
    }

    private void showPlanList(){
        Handler handler= new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                RealmResults<PlanForMonth> realmCommentList= GetData.getOneMonthPlanListFromRealm(Activity_Plan_AddEdit.this,(Class)PlanForMonth.class,year,month);
                planForMonthsList  = new ArrayList<>();
                for (PlanForMonth planForMonth : realmCommentList){
                    planForMonthsList.add(planForMonth);
                }
                Collections.sort(planForMonthsList);
                LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(Activity_Plan_AddEdit.this,LinearLayoutManager.VERTICAL,false);
                recyclerView_PlanList.setLayoutManager(horizontalLayoutManager);
                recyclerView_PlanList.setAdapter(new RecyclerAdapter_Plan(planForMonthsList,Activity_Plan_AddEdit.this));

            }
        },300);
    }

    @Override
    public void onResume() {
        super.onResume();

        showPlanList();

    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (v.getId()){
            case R.id.txtDateContact:
                dateView=txtDateContact;
                MyCalendar.showCalendar(Activity_Plan_AddEdit.this,
                        getFragmentManager());
                break;
            case R.id.txtDateIntent:
                dateView=txtDateIntent;
                MyCalendar.showCalendar(Activity_Plan_AddEdit.this,
                        getFragmentManager());
                break ;

        }
    }


    /**
     * @param view        The view associated with this listener.
     * @param year        The year that was set.
     * @param monthOfYear The month that was set (0-11) for compatibility
     *                    with {@link Calendar}.
     * @param dayOfMonth  The day of the month that was set.
     */
    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        monthOfYear=monthOfYear+1;
        String date=""+monthOfYear+"/"+dayOfMonth+"/"+year ;
        String nDate=""+dayOfMonth+" "+MyDateFormat.getMonthName(monthOfYear-1)+" "+year;
        dateView.setText(nDate);
    }
}
