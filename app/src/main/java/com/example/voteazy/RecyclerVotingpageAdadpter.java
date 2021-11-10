package com.example.voteazy;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.media.Image;
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

public class RecyclerVotingpageAdadpter extends RecyclerView.Adapter<RecyclerVotingpageAdadpter.ViewHolder> {


    Context context;
    ArrayList<CandidateModel> arrCandidates;
    int tempPosition = -1;
    LinearLayout templlrow;
    ImageView tempcandidateimg;
    TextView nametxt;
    TextView partytxt;

    RecyclerVotingpageAdadpter(Context context, ArrayList<CandidateModel> arrCandidates) {
        this.context = context;
        this.arrCandidates = arrCandidates;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.candidate_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, @SuppressLint("RecyclerView") final int position) {

        holder.imgCandidate.setImageURI(arrCandidates.get(position).img);
        holder.txtName.setText(arrCandidates.get(position).name);
        holder.txtParty.setText(arrCandidates.get(position).party);

        holder.llRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (tempPosition != -1) {

                    templlrow.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    tempcandidateimg.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    nametxt.setTextColor(Color.parseColor("#000000"));
                    partytxt.setTextColor(Color.parseColor("#000000"));
                }

                holder.llRow.setBackgroundColor(Color.parseColor("#4CAF50"));
                holder.imgCandidate.setBackgroundColor(Color.parseColor("#4CAF50"));
                holder.txtName.setTextColor(Color.parseColor("#FFFFFF"));
                holder.txtParty.setTextColor(Color.parseColor("#FFFFFF"));

                templlrow = holder.llRow;
                nametxt = holder.txtName;
                partytxt = holder.txtParty;
                tempcandidateimg = holder.imgCandidate;
                tempPosition = 0;

            }

        });

        holder.llRow.setOnLongClickListener(
                new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.aboutcandidate);

                final TextView title = dialog.findViewById(R.id.candidate_form_title);
                final  TextView aboutcandidate = dialog.findViewById(R.id.about);
                final ImageView profile = dialog.findViewById(R.id.candidate_profile_img);

                Button btnclose =dialog.findViewById(R.id.closebtn);

                title.setText(arrCandidates.get(position).name);
                aboutcandidate.setText(arrCandidates.get(position).about);
                profile.setImageURI(arrCandidates.get(position).img);

                btnclose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
                return true;
            }
        });

    }


    @Override
    public int getItemCount() {
        return arrCandidates.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtName, txtParty;
        ImageView imgCandidate;
        LinearLayout llRow;

        public ViewHolder(View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtParty = itemView.findViewById(R.id.txtParty);
            imgCandidate = itemView.findViewById(R.id.imgCandidate);
            llRow = itemView.findViewById(R.id.llRow);
        }
    }
}
