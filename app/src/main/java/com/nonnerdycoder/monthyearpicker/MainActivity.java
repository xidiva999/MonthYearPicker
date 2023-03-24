package com.nonnerdycoder.monthyearpicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.nonnerdycoder.monthyearpick.YearMonthPickerDialog;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
TextView yearMonth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        yearMonth = (TextView) findViewById(R.id.yearMonth);

        Calendar calendar = Calendar.getInstance();
       // calendar.set(2010,01,01);

        YearMonthPickerDialog yearMonthPickerDialog = new YearMonthPickerDialog(this,
                calendar,
                new YearMonthPickerDialog.OnDateSetListener() {
                    @Override
                    public void onYearMonthSet(int year, int month) {
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(Calendar.YEAR, year);
                        calendar.set(Calendar.MONTH, month);

                        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM yyyy");

                        yearMonth.setText(dateFormat.format(calendar.getTime()));
                    }
                });
        yearMonthPickerDialog.setMinYear(2000);
        yearMonthPickerDialog.setMaxYear(2020);
        yearMonthPickerDialog.show();
    }
}