package com.example.voteazy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.transition.Hold;

import java.util.ArrayList;

public class RecyclerResultpageAdapter extends  RecyclerView.Adapter<RecyclerResultpageAdapter.ViewHolder>{


    Context context;
    ArrayList<CandidateModel> arrCandidates;

     RecyclerResultpageAdapter(Context context, ArrayList<CandidateModel> arrCandidates) {
         this.context = context;
         this.arrCandidates = arrCandidates;
     }



    @NonNull
    @Override
    public RecyclerResultpageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.candidate_votes, parent, false);
         RecyclerResultpageAdapter.ViewHolder viewHolder = new RecyclerResultpageAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerResultpageAdapter.ViewHolder holder, int position) {
        holder.txtName.setText(arrCandidates.get(position).name);
        holder.imgCandidate.setImageURI( arrCandidates.get(position).img);
    }

    @Override
    public int getItemCount() {
       return  arrCandidates.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtName ;
        ImageView imgCandidate;
        LinearLayout llRow;
        TextView votecount;

        public ViewHolder(View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.candidate_name);
            imgCandidate = itemView.findViewById(R.id.candidate_profile_img);
            llRow = itemView.findViewById(R.id.llRow);
            votecount = itemView.findViewById(R.id.votecount);
        }
    }
}
