package sg.edu.rp.c346.id18015906.reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;


import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.CheckBox;
import android.widget.Button;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    EditText name;
    EditText num;
    EditText size;
    DatePicker date;
    TimePicker time;
    CheckBox smoking;
    Button confirm;
    Button clear;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.editTextName);
        num = findViewById(R.id.editTextNumber);
        size = findViewById(R.id.editTextGroupSize);
        date = findViewById(R.id.datePicker);
        time = findViewById(R.id.timePicker);
        smoking = findViewById(R.id.checkBoxSmoking);
        confirm = findViewById(R.id.buttonConfirm);
        clear = findViewById(R.id.buttonClear);

        date.updateDate(2020,6,1);
        time.setCurrentHour(19);
        time.setCurrentMinute(30);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String smokingText = "";
                if (smoking.isChecked()){
                    smokingText = "Yes";
                }else{
                    smokingText = "No";
                }

                Context context = getApplicationContext();

               String output = "Name: " + name.getText().toString();
               output += "\nPhone Number: " + num.getText().toString();
               output+= "\nSize Of Group: " + size.getText().toString();
               output+= "\nDate: " + date.getDayOfMonth() + "/" +date.getMonth() + "/" + date.getYear();
               output+= "\nTime: " + time.getCurrentHour() + ":" + time.getCurrentMinute();
               output+= "\nSmoking: "+smokingText;


                Toast toast = Toast.makeText(context,output,Toast.LENGTH_LONG);
                toast.show();

            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText("");
                num.setText("");
                size.setText("");
                smoking.setChecked(false);
                time.setCurrentHour(19);
                time.setCurrentMinute(30);
                date.updateDate(2020,6,1);
            }
        });




    }
}
