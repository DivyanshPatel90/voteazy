package com.example.voteazy;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerVotingpageAdadpter  extends RecyclerView.Adapter<RecyclerVotingpageAdadpter.ViewHolder> {


    Context context ;
    ArrayList<CandidateModel> arrCandidates;
    RecyclerVotingpageAdadpter(Context context, ArrayList<CandidateModel> arrCandidates){
        this.context = context;
        this.arrCandidates = arrCandidates;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.candidate_row,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.imgCandidate.setImageResource(arrCandidates.get(position).img);
        holder.txtName.setText(arrCandidates.get(position).name);
        holder.txtParty.setText(arrCandidates.get(position).party);

        holder.llRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 holder.imgCandidate.setImageResource(R.drawable.check);
            }

        });

        holder.llRow.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return false;
            }
        });
    }


    @Override
    public int getItemCount() {
        return arrCandidates.size();
    }

    public class  ViewHolder extends RecyclerView.ViewHolder{
        TextView txtName, txtParty;
        ImageView imgCandidate;
        LinearLayout llRow;
        public  ViewHolder(View itemView){
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtParty = itemView.findViewById(R.id.txtParty);
            imgCandidate = itemView.findViewById(R.id.imgCandidate);
            llRow = itemView.findViewById(R.id.llRow);
        }
    }
}
