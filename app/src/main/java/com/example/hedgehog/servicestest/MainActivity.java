package com.example.hedgehog.servicestest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
       if (!MyService.isRunningNow){
           mbStart.setText(R.string.stop);
           MyService.isRunningNow = true;
           startService(new Intent(this, MyService.class));
       }else {
           mbStart.setText(R.string.start);
           MyService.isRunningNow = false;
           stopService(new Intent(this, MyService.class));
       }

        /*startService(new Intent(this, NewService.class).putExtra("time", 7));
        startService(new Intent(this, NewService.class).putExtra("time", 2));
        startService(new Intent(this, NewService.class).putExtra("time", 4));*/
        //Будет создано и передано экзекьютору три MyRun-объекта. Он их по очереди начнет выполнять.
        // Это займет у него соответственно 7,2 и 4 секунд (время паузы мы передаем в intent-е).
        // В конце обработки каждого MyRun будет выполняться stopSelf(startId).

    }

    @Override
    public void onBackPressed() {
        //stopService(new Intent (this, NewService.class));
        super.onBackPressed();
    }
}
