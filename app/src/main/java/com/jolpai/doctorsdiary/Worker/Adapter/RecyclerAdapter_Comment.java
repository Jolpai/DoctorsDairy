package com.jolpai.doctorsdiary.Worker.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.andexert.library.RippleView;
import com.jolpai.doctorsdiary.R;
import com.jolpai.doctorsdiary.Realm_Model.Comments;

import java.util.List;

import static com.jolpai.doctorsdiary.Brain.App.TAG;
import static com.jolpai.doctorsdiary.Brain.App.currentTime;

/**
 * Created by User on 1/22/2017.
 */

public class RecyclerAdapter_Comment extends RecyclerView.Adapter<RecyclerAdapter_Comment.View_Holder> {

        private List<com.jolpai.doctorsdiary.Realm_Model.Comments> list;
        private Context context;

        public RecyclerAdapter_Comment(List<com.jolpai.doctorsdiary.Realm_Model.Comments> list, Context context) {
            this.list = list;
            this.context = context;
        }


        public class View_Holder extends RecyclerView.ViewHolder{

            RippleView llFooterDate;
            TextView
                    textCommentDate,
                    textComment,
                    textCommentersName;
            View view;

            public View_Holder (View itemView){
                super(itemView);
                textCommentDate =(TextView) itemView.findViewById(R.id.textCommentDate);
                textComment=(TextView) itemView.findViewById(R.id.textComment);
                textCommentersName=(TextView) itemView.findViewById(R.id.textCommentersName);
                view=itemView;
            }
        }

        @Override
        public View_Holder onCreateViewHolder(ViewGroup parent, int viewType) {
            //Inflate the layout, initialize the View Holder
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_commenters, parent, false);
            View_Holder holder = new View_Holder(v);
            return holder;
        }

        @Override
        public void onBindViewHolder(final View_Holder holder, int position) {
            //Use the provided View Holder on the onCreateViewHolder method to populate the current row on the RecyclerView
            final Comments comments = list.get(position);
            holder.textCommentDate.setText(comments.getDate());
            holder.textComment.setText(comments.getComment());
            holder.textCommentersName.setText(comments.getPersonsName());
            holder.view.setTag(comments);

            // Log.e(TAG,holder.toString());
            Log.e(TAG,"onBindViewHolder"+position);
            Log.e(TAG, currentTime());

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
