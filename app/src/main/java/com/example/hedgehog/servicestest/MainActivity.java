package com.example.hedgehog.servicestest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button mbStart;
    ProgressBar mProgress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mbStart = (Button) findViewById(R.id.mbStart);
      //  if (MyService.isRunningNow == true){
     //       mbStart.setText(R.string.stop);
     //   }
        mbStart.setOnClickListener(this);
        mProgress = (ProgressBar) findViewById(R.id.mProgress);

    }

    @Override
    public void onClick(View v) {
      // if (!MyService.isRunningNow){
          // mbStart.setText(R.string.stop);
           MyService.isRunningNow = true;
           startService(new Intent(this, NewService.class));
     //  }else {
      //     mbStart.setText(R.string.start);
      //     MyService.isRunningNow = false;
      //     stopService(new Intent(this, MyService.class));
     //  }

    }
}
