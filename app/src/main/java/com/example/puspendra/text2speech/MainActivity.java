package com.example.puspendra.text2speech;

import android.content.Intent;
import android.preference.PreferenceManager;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
TextView tv;
Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.b1);
        tv=findViewById(R.id.tv);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "hifeiogh", Toast.LENGTH_SHORT).show();
                Intent in=new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                in.putExtra(RecognizerIntent.EXTRA_PROMPT,"bol be");
                startActivityForResult(in,0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ArrayList<String> al=data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
        tv.setText(al.get(0));


    }
}
