package com.example.datepicker.Activity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.datepicker.Fragment.DatePickerFragment;
import com.example.datepicker.Fragment.TimePickerFragment;
import com.example.datepicker.R;

import java.text.DateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

     TextView dateView,timeView;
     Button datePicker,timePicker;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dateView = findViewById(R.id.tvDate);
        timeView = findViewById(R.id.tvTime);
        datePicker = findViewById(R.id.btDatePicker);
        timePicker = findViewById(R.id.btTimePicker);

       /* Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance().format(calendar.getTime());
        date.setText(currentDate);*/
    }


    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR,year);
        calendar.set(Calendar.MONTH,month);
        calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);


        String currentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        dateView.setText(currentDateString);

    }



    public void saveDate(View view) {
        DialogFragment datePicker = new DatePickerFragment();
        datePicker.show(getSupportFragmentManager(),"datePicker");
    }


    public void saveTime(View view) {

        DialogFragment timePicker = new TimePickerFragment();
        timePicker.show(getSupportFragmentManager(),"timePicker");

    }


    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

        timeView.setText("Hour : "+hourOfDay +"\n"+"Minute : "+minute);
    }
}
