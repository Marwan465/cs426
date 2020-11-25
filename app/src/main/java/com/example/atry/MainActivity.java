package com.example.atry;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    public static final String Key ="MyY";
    public static final String Key1 ="MyM";
    TextView M,Y,result;
    int year,month =0;
    Button calc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Y = findViewById(R.id.edityear);
        M = findViewById(R.id.editmonth);
        result=findViewById(R.id.textView2);
        calc = findViewById(R.id.button);
        String lang = Locale.getDefault().getLanguage();
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!M.getText().toString().equals("") && !Y.getText().toString().equals("")) {
                    month = Integer.parseInt(M.getText().toString());
                    year = Integer.parseInt(Y.getText().toString());
                    Calendar c = Calendar.getInstance();

                    if (month <= 12 && year >= 0 && month > 0 && year <= c.get(Calendar.YEAR)) {

                         year = c.get(Calendar.YEAR) - year;
                         month = c.get(Calendar.MONTH) - month;
                        if(month<0 && year >0){
                                year = year - 1;
                                month=month+12;
                           if(lang.equals("en")) {
                               result.setText("You are " + String.valueOf(year) + " year/s and "
                                       + String.valueOf(month) + " month!");
                           }
                            if(lang.equals("ar")) {
                                result.setText("انت تبلغ " + String.valueOf(year) + " سنه و "
                                        + String.valueOf(month) + " شهر!");
                            }
                        }
                        else if (month<0 && year ==0) {
                            result.setText("You are not born YET! ");
                        }
                        else {
                            if(lang.equals("en")) {
                                result.setText("You are " + String.valueOf(year) + " year/s and "
                                        + String.valueOf(month) + " month!");
                            }
                            if(lang.equals("ar")) {
                                result.setText("انت تبلغ " + String.valueOf(year) + " سنه و "
                                        + String.valueOf(month) + " شهر!");
                            }
                        }
                        Toast.makeText(MainActivity.this, "Calculated! ", Toast.LENGTH_LONG).show();
                    } else
                        Toast.makeText(MainActivity.this, "Please Enter Valid Month and Year! ", Toast.LENGTH_LONG).show();
                } else{
                    Toast.makeText(MainActivity.this, "Please Enter a Value! ", Toast.LENGTH_LONG).show();
                }
            }


        });
        if(savedInstanceState !=null) {
            year = savedInstanceState.getInt(Key);
            month = savedInstanceState.getInt(Key1);
            if(month >=0) {
                if(lang.equals("en")) {
                    result.setText("You are " + String.valueOf(year) + " year/s and "
                            + String.valueOf(month) + " month!");
                }
                if(lang.equals("ar")) {
                    result.setText("انت تبلغ " + String.valueOf(year) + " سنه و "
                            + String.valueOf(month) + " شهر!");
                }
            }
            else if (month<0 && year ==0) {
                result.setText("You are not born YET! ");
            }

        }
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(Key, year);
        outState.putInt(Key1, month);
    }
}