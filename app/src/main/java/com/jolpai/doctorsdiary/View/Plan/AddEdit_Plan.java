package com.jolpai.doctorsdiary.View.Plan;

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
import com.jolpai.doctorsdiary.Worker.Database.POJO.PlanForMonth;
import com.jolpai.doctorsdiary.Worker.Adapter.RecyclerAdapter_Plan;
import com.jolpai.doctorsdiary.Worker.Database.GetData;
import com.jolpai.doctorsdiary.Worker.Database.SaveData;
import com.jolpai.doctorsdiary.Worker.Listener.ItemTouchListener_Plan;
import com.jolpai.doctorsdiary.Worker.Others.MyCalendar;
import com.jolpai.doctorsdiary.Worker.Others.MyDateFormat;
import com.jolpai.doctorsdiary.Worker.Others.MyToast;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

import io.realm.RealmResults;

public class AddEdit_Plan extends AppCompatActivity implements View.OnClickListener,
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
        fragmentManager =getFragmentManager();

        String[] items = new String[3];

        items[0] = "Participant";
        items[1] = "Volunteer";
        items[2] = "Member";


        ArrayAdapter<String> adapter = new ArrayAdapter<>(AddEdit_Plan.this, R.layout.x_row_span, items);
        adapter.setDropDownViewResource(R.layout.x_row_spn_dropdown);
        spinnerType.setAdapter(adapter);

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
                    SaveData.saveDataToRealm(AddEdit_Plan.this, planForMonth, (Class) PlanForMonth.class);

                    showPlanList();
                    clear();
                }
            }
        });

        recyclerView_PlanList.addOnItemTouchListener(
            new ItemTouchListener_Plan(AddEdit_Plan.this,recyclerView_PlanList,
            new ItemTouchListener_Plan.OnItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {
                    PlanForMonth planForMonth =(PlanForMonth)view.getTag();
                    editTextPersonName.setText(planForMonth.getTargetName());
                    txtDateContact.setText(planForMonth.getContactDate());
                    txtDateIntent.setText(planForMonth.getIntentDate());

                    String s =spinnerType.getSelectedItem().toString();
                    if(s.equalsIgnoreCase("Participant")){
                        spinnerType.setSelection(0,false);
                    }else if(s.equalsIgnoreCase("Volunteer")){
                        spinnerType.post(new Runnable() {
                            public void run() {
                                spinnerType.setSelection(1);
                            }
                        });
                    }else if(s.equalsIgnoreCase("Member")){
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
                RealmResults<PlanForMonth> realmCommentList= GetData.getOneMonthPlanListFromRealm(AddEdit_Plan.this,(Class)PlanForMonth.class,year,month);
                planForMonthsList  = new ArrayList<>();
                for (PlanForMonth planForMonth : realmCommentList){
                    planForMonthsList.add(planForMonth);
                }
                Collections.sort(planForMonthsList);
                LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(AddEdit_Plan.this,LinearLayoutManager.VERTICAL,false);
                recyclerView_PlanList.setLayoutManager(horizontalLayoutManager);
                recyclerView_PlanList.setAdapter(new RecyclerAdapter_Plan(planForMonthsList,AddEdit_Plan.this));

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
                MyCalendar.showCalendar(AddEdit_Plan.this,getFragmentManager());
                break;
            case R.id.txtDateIntent:
                dateView=txtDateIntent;
                MyCalendar.showCalendar(AddEdit_Plan.this,getFragmentManager());
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
        String date=""+monthOfYear+1+"/"+dayOfMonth+"/"+year ;
        dateView.setText(date);
    }
}
