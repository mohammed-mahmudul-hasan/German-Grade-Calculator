package com.example.gradeconversiontool;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class German_Grade_Activity extends Activity {
    EditText input1,input2,input3;
    TextView result;
    Button convert,reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_german__grade_);

        input1=(EditText) findViewById(R.id.input1);
        input2=(EditText) findViewById(R.id.input2);
        input3=(EditText) findViewById(R.id.input3);
        result=(TextView) findViewById(R.id.result_german);
        convert=(Button) findViewById(R.id.convert);
        reset=(Button) findViewById(R.id.reset);

        final DecimalFormat number=new DecimalFormat("###.##");
        number.setRoundingMode(RoundingMode.FLOOR);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Double max = new Double(input1.getText().toString());
                    Double min = new Double(input2.getText().toString());
                    Double cg = new Double(input3.getText().toString());
                    double res = converter_german.convert(max,min,cg);
                    if(res==-1){
                        Toast.makeText(German_Grade_Activity.this, "Fill up correctly", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        result.setText(new Double(number.format(res)).toString());
                    }
                }
                catch (Exception e){
                    Toast.makeText(German_Grade_Activity.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input1.setText("");
                input2.setText("");
                input3.setText("");
            }
        });
    }
}
