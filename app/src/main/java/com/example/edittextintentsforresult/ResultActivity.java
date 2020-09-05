package com.example.edittextintentsforresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView res1;
    TextView res2;
    Double result1;
    Double result2;
    Intent gi;
    WebView graph;
    String url="https://www.google.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        res1=(TextView) findViewById(R.id.res1);
        res2=(TextView) findViewById(R.id.res2);
        graph=(WebView) findViewById(R.id.graph);

        graph.getSettings().setJavaScriptEnabled(true);
        graph.setWebViewClient(new MyWebViewClient());

        gi=getIntent();
        Double a=gi.getDoubleExtra("a",1);
        Double b=gi.getDoubleExtra("b",1);
        Double c=gi.getDoubleExtra("c",1);

        double determinant=b*b-4*a*c;
        if(determinant>0) {
            result1=(-b+Math.sqrt(determinant))/(2*a);
            result2=(-b-Math.sqrt(determinant))/(2*a);
            res1.setText(""+result1);
            res2.setText(""+result2);
            url="https://www.google.com/search?sxsrf=ALeKk02--xxQfe0fnVrePerQ_78viRKUkQ%3A1599293469365&ei=HUhTX7v1Fca4aaTcveAC&q="+a+"x%5E2%2B"+b+"*x%2B"+c+"&oq";
        }
        else if(determinant==0) {
            result1=-b/(2*a);
            result2=-b/(2*a);
            res1.setText(""+result1);
            res2.setText(""+result2);
            url="https://www.google.com/search?sxsrf=ALeKk02--xxQfe0fnVrePerQ_78viRKUkQ%3A1599293469365&ei=HUhTX7v1Fca4aaTcveAC&q="+a+"x%5E2%2B"+b+"*x%2B"+c+"&oq";
        }
        else {
            result1=9999999999.0;
            result2=9999999999.0;
            res1.setText("error");
            res2.setText("error");
            url="https://www.computerhope.com/jargon/e/error.gif";
        }
        graph.loadUrl(url);
    }

    public void back(View view) {
        gi.putExtra("result1", result1);
        gi.putExtra("result2", result2);
        setResult(RESULT_OK, gi);
        finish();
    }

    private class MyWebViewClient extends WebViewClient {
        public boolean shouldOverideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}