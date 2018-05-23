package yazdaniscodelab.datepickerdialogforandroid;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private static final String TAG="Main";

    private DatePickerDialog.OnDateSetListener mDatepicker;

    private TextView mDisplayDate;
    private Button btnDatePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDisplayDate=findViewById(R.id.date_show);
        btnDatePicker=findViewById(R.id.btn_date_picker);

        btnDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calendar cal=Calendar.getInstance();

                int year=cal.get(Calendar.YEAR);
                int month=cal.get(Calendar.MONTH);
                int day=cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog=new DatePickerDialog(
                        MainActivity.this,
                        android.R.style.Theme_Holo_Wallpaper,
                        mDatepicker,year,month,day
                );

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDatepicker=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                Log.d(TAG,"onDateSet"+year+"/"+month+"/"+day);
                month=month+1;
                String date=year+"/"+month+"/"+day;

                mDisplayDate.setText(date);

            }
        };

    }




}
