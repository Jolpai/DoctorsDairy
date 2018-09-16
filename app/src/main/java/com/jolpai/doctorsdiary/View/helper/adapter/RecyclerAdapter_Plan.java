package com.jolpai.doctorsdiary.View.helper.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.andexert.library.RippleView;
import com.jolpai.doctorsdiary.Model.Worker.Database.entity.PlanForMonth;
import com.jolpai.doctorsdiary.Model.Worker.Others.MyDateFormat;
import com.jolpai.doctorsdiary.R;

import java.util.List;


/**
 * Created by User on 1/25/2017.
 */

public class RecyclerAdapter_Plan extends RecyclerView.Adapter<RecyclerAdapter_Plan.View_Holder> {
    private List<PlanForMonth> list;
    private Context context;

    public RecyclerAdapter_Plan(List<PlanForMonth> list, Context context) {
        this.list = list;
        this.context = context;
    }


    public class View_Holder extends RecyclerView.ViewHolder{

        RippleView llFooterDate;
        TextView
                textName,
                textContactDate,
                textIntentDate,
                textType,
                textPlanDate;

        View view;

        public View_Holder (View itemView){
            super(itemView);
            textName =(TextView) itemView.findViewById(R.id.textName);
            textContactDate=(TextView) itemView.findViewById(R.id.textContactDate);
            textIntentDate=(TextView) itemView.findViewById(R.id.textIntentDate);
            textType=(TextView)itemView.findViewById(R.id.textType);
            textPlanDate=(TextView)itemView.findViewById(R.id.textPlanDate);
            view=itemView;
        }
    }

    @Override
    public RecyclerAdapter_Plan.View_Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Inflate the layout, initialize the View Holder
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_plan, parent, false);
        RecyclerAdapter_Plan.View_Holder holder = new RecyclerAdapter_Plan.View_Holder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(final RecyclerAdapter_Plan.View_Holder holder, int position) {
        //Use the provided View Holder on the onCreateViewHolder method to populate the current row on the RecyclerView
        final PlanForMonth planForMonth = list.get(position);
        holder.textPlanDate.setText(MyDateFormat.getDDMMMYY(planForMonth.getPlanDate()));
        holder.textName.setText(planForMonth.getTargetName());
        holder.textContactDate.setText(planForMonth.getContactDate());
        holder.textIntentDate.setText(planForMonth.getIntentDate());
        holder.textType.setText(planForMonth.getType());
        holder.view.setTag(planForMonth);


    }

    @Override
    public int getItemCount() {
        //returns the number of elements the RecyclerView will display
        return list.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}
