package com.mpip.finki.mpip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.R.attr.button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initButtons();
    }

    private void initButtons() {
        Button btn = (Button) this.findViewById(R.id.btnNextActivity);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToNextActivity();
            }
        });
    }

    @Override
    public void onStart() {
        Toast.makeText(getApplication().getApplicationContext(), "Start Main Activity", Toast.LENGTH_SHORT).show();

        super.onStart();
    }

    @Override
    public void onRestart() {
        Toast.makeText(getApplication().getApplicationContext(), "Restart Main Activity", Toast.LENGTH_SHORT).show();

        super.onRestart();
    }

    @Override
    public void onStop() {
        Toast.makeText(getApplication().getApplicationContext(), "Stop Main Activity", Toast.LENGTH_SHORT).show();
        super.onStop();
    }

    @Override
    public void onResume() {
        Toast.makeText(getApplication().getApplicationContext(), "Resume Main Activity", Toast.LENGTH_SHORT).show();
        super.onResume();
    }

    @Override
    public void onPause() {
        Toast.makeText(getApplication().getApplicationContext(), "Pause Main Activity", Toast.LENGTH_SHORT).show();
        super.onPause();
    }

    @Override
    public void onDestroy() {
        Toast.makeText(getApplication().getApplicationContext(), "Destroy Main Activity", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }

    private void goToNextActivity() {
        Intent SecondActivityIntent = new Intent(this, SecondActivity.class);
        startActivity(SecondActivityIntent);
    }
}
