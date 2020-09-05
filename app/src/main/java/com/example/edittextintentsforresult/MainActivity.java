package com.example.edittextintentsforresult;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText numa;
    EditText numb;
    EditText numc;
    TextView resu1;
    TextView resu2;
    double re1=0;
    double re2=0;

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
        int na = (int) ((Math.random()*(100+100+1))-100);
        int nb = (int) ((Math.random()*(100+100+1))-100);
        int nc = (int) ((Math.random()*(100+100+1))-100);
        numa.setText(""+na);
        numb.setText(""+nb);
        numc.setText(""+nc);
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
            Double a=Double.parseDouble(nua);
            Double b=Double.parseDouble(nub);
            Double c=Double.parseDouble(nuc);
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
            re1=data_back.getDoubleExtra("result1",0);
            re2=data_back.getDoubleExtra("result2",0);
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