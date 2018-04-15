package com.example.toshiba.parkme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class BookActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
   Integer timeArray[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        TextView FromTime;
        FromTime = (TextView) findViewById(R.id.fromtime);

        //get time

        Calendar cal = Calendar.getInstance();

        //int millisecond = cal.get(Calendar.MILLISECOND);
        //int second = cal.get(Calendar.SECOND);
        final int minute = cal.get(Calendar.MINUTE);
        //12 hour format
        //int hour = cal.get(Calendar.HOUR);
        //24 hour format



        final int hourofday = cal.get(Calendar.HOUR_OF_DAY);
        FromTime.setText(Integer.toString(hourofday + 1)+ "Hrs ");
        //start
        //Getting the instance of Spinner and applying OnItemSelectedListener on it
       // Spinner fromTime = (Spinner) findViewById(R.id.editFrom);
        //fromTime.setOnItemSelectedListener(this);
        //Creating the ArrayAdapter instance having the bank name list
       // ArrayAdapter  aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,timeArray);
       // aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
       // fromTime.setAdapter(aa);

        final Spinner toTime= (Spinner)findViewById(R.id.editTo);
        toTime.setOnItemSelectedListener(this);
        ArrayAdapter  aa2 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,timeArray);
        aa2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        toTime.setAdapter(aa2);
        toTime.post(new Runnable() {
            @Override
            public void run() {
                toTime.setSelection(hourofday +1);
            }
        });

       // toTime.setSelection(spinner_adapter.getPosition(hourofday)+1);

        Button check_button = (Button) findViewById(R.id.check);

        check_button.setOnClickListener((new OnClickListener() {
            @Override
            public void onClick(View view) {


                if(minute >=0 && minute <=10)
                {
                    Toast.makeText(getApplicationContext(),"SLOT BOOKING AVAILABLE ONLY IN LAST HALF OF HOUR",Toast.LENGTH_LONG).show();

                }
                else {
                    Intent checkIntent = new Intent(BookActivity.this, ListActivity.class);
                    startActivity(checkIntent);
                }
            }
        }));

        Button back_button =(Button) findViewById(R.id.backbook);

        back_button.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backIntent = new Intent(BookActivity.this, ProfileActivity.class);
                startActivity(backIntent);
            }
        }));


    }
    //Performing action onItemSelected and onNothing selected
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position,long id) {
//        Toast.makeText(getApplicationContext(), timeArray[position], Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
    // TODO Auto-generated method stub

    }




}