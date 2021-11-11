package com.example.voteazy;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnvoter;
    Button btnadmin;
    TextView languagedialog;
    TextView votingmadeeasytext;
    boolean lang_selected = true;
    Context context;
    Resources resources;
    TextView welcome;
    static  int languageselected  ;
    static String[] languages = {"English", "हिंदी" ,"বাংলা","मराठी","తెలుగు" , "தமிழ்" ,"ગુજરાતી"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnvoter = findViewById(R.id.voterbtn);
        btnadmin = findViewById(R.id.adminbtn);
        languagedialog = findViewById(R.id.textviewdialog);
        welcome = findViewById(R.id.Welcome);
        votingmadeeasytext = findViewById(R.id.votingmadeeasytxt);


        //for changing Languages
        languagedialog.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                int checkeditem;
                if (lang_selected) {
                    checkeditem = 0;
                } else {
                    checkeditem = 1;
                }


                final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Select a language").setSingleChoiceItems(languages, checkeditem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        languageselected = i;

                        languagedialog.setText(languages[i]);


                        if (languages[i].equals("English")) {

                            context = LocaleHelper.setLocale(MainActivity.this, "en");
                            resources = context.getResources();
                            welcome.setText(resources.getString(R.string.welcome_to_voteasy));
                            btnvoter.setText(resources.getString(R.string.voter));
                            btnadmin.setText(resources.getString(R.string.admin));
                            votingmadeeasytext.setText(resources.getString(R.string.voting_made_easy));

                        }
                        if (languages[i].equals("हिंदी")) {
                            context = LocaleHelper.setLocale(MainActivity.this, "hi");
                            resources = context.getResources();
                            welcome.setText(resources.getString(R.string.welcome_to_voteasy));
                            btnvoter.setText(resources.getString(R.string.voter));
                            btnadmin.setText(resources.getString(R.string.admin));
                            votingmadeeasytext.setText(resources.getString(R.string.voting_made_easy));
                        }

                       if (languages[i].equals("বাংলা")) {
                            context = LocaleHelper.setLocale(MainActivity.this, "bn");
                            resources = context.getResources();
                            welcome.setText(resources.getString(R.string.welcome_to_voteasy));
                            btnvoter.setText(resources.getString(R.string.voter));
                            btnadmin.setText(resources.getString(R.string.admin));
                            votingmadeeasytext.setText(resources.getString(R.string.voting_made_easy));
                        }
                     if (languages[i].equals("मराठी")) {
                            context = LocaleHelper.setLocale(MainActivity.this, "mr");
                            resources = context.getResources();
                            welcome.setText(resources.getString(R.string.welcome_to_voteasy));
                            welcome.setTextSize(resources.getDimension(R.dimen.textsize1));
                            btnvoter.setText(resources.getString(R.string.voter));
                            btnadmin.setText(resources.getString(R.string.admin));
                            votingmadeeasytext.setText(resources.getString(R.string.voting_made_easy));
                        }

                     if (languages[i].equals("తెలుగు")) {
                            context = LocaleHelper.setLocale(MainActivity.this, "te");
                            resources = context.getResources();
                            welcome.setText(resources.getString(R.string.welcome_to_voteasy));
                            welcome.setTextSize(resources.getDimension(R.dimen.textsize1));
                            btnvoter.setText(resources.getString(R.string.voter));
                            btnadmin.setText(resources.getString(R.string.admin));
                            votingmadeeasytext.setText(resources.getString(R.string.voting_made_easy));
                        }

                       if (languages[i].equals("தமிழ்")) {
                            context = LocaleHelper.setLocale(MainActivity.this, "ta");
                            resources = context.getResources();
                            welcome.setText(resources.getString(R.string.welcome_to_voteasy));
                            welcome.setTextSize(resources.getDimension(R.dimen.textsize1));
                            btnvoter.setText(resources.getString(R.string.voter));
                            btnadmin.setText(resources.getString(R.string.admin));
                            votingmadeeasytext.setText(resources.getString(R.string.voting_made_easy));
                        }

                       if (languages[i].equals("ગુજરાતી")) {
                            context = LocaleHelper.setLocale(MainActivity.this, "gu");
                            resources = context.getResources();
                            welcome.setText(resources.getString(R.string.welcome_to_voteasy));
                            welcome.setTextSize(resources.getDimension(R.dimen.textsize1));
                            btnvoter.setText(resources.getString(R.string.voter));
                            btnadmin.setText(resources.getString(R.string.admin));
                            votingmadeeasytext.setText(resources.getString(R.string.voting_made_easy));
                        }

                    }
                    })
                            .setPositiveButton("Ok",new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick (DialogInterface dialogInterface,int i){
                            dialogInterface.dismiss();
                        }
                    });

                 builder.create().show();

                }
            });




        btnvoter.setOnClickListener(new View.OnClickListener()

            {
                @Override
                public void onClick (View view){
                Intent intent = new Intent(getApplicationContext(), voterlogin.class);

                startActivity(intent);
            }
            });

       btnadmin.setOnClickListener(new View.OnClickListener()

            {
                @Override
                public void onClick (View view){
                Intent intent = new Intent(getApplicationContext(), adminlogin.class);
                startActivity(intent);
            }
            });

        }
    }