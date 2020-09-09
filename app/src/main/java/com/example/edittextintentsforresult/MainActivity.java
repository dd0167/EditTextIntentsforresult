package com.example.edittextintentsforresult;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText numa;
    EditText numb;
    EditText numc;
    TextView resu1;
    TextView resu2;
    float re1=0;
    float re2=0;
    Random rnd=new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numa=(EditText) findViewById(R.id.numa);
        numb=(EditText) findViewById(R.id.numb);
        numc=(EditText) findViewById(R.id.numc);
        resu1=(TextView) findViewById(R.id.resu1);
        resu2=(TextView) findViewById(R.id.resu2);
    }

    public void randoms(View view) {
        float na= (float) ((Math.random()*(100+100+1))-100);
        float nb=(float) ((Math.random()*(100+100+1))-100);
        float nc=(float) ((Math.random()*(100+100+1))-100);
        numa.setText(String.valueOf(na));
        numb.setText(String.valueOf(nb));
        numc.setText(String.valueOf(nc));
    }

    public void solve(View view) {
        String nua=numa.getText().toString();
        String nub=numb.getText().toString();
        String nuc=numc.getText().toString();
        if(nua.equals("") || nub.equals("") || nuc.equals(""))
        {
            Toast.makeText(this, "Enter Number!", Toast.LENGTH_SHORT).show();
        }
        else
        {
            float a=Float.parseFloat(nua);
            float b=Float.parseFloat(nub);
            float c=Float.parseFloat(nuc);
            Intent re=new Intent(this,ResultActivity.class);
            re.putExtra("a",a);
            re.putExtra("b",b);
            re.putExtra("c",c);
            startActivityForResult(re,1);
        }
    }


    protected void onActivityResult(int source, int good, @Nullable Intent data_back) {
        super.onActivityResult(source, good, data_back);
        if (data_back != null) {
            re1=data_back.getFloatExtra("result1",0);
            re2=data_back.getFloatExtra("result2",0);
            if (re1==9999999999.0 && re2==9999999999.0)
            {
                resu1.setText("error");
                resu2.setText("error");
            }
            else
            {
                resu1.setText(""+re1);
                resu2.setText(""+re2);
            }
        }
        else
        {
            resu1.setText("null");
            resu2.setText("null");
        }
    }
}