package com.example.tuitionterminal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.tuitionterminal.Guardian.GuardianModuleStartActivity;
import com.example.tuitionterminal.Tutor.TutorModuleStartActivity;

public class HomePageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
    }

    public void goToGaurdianModule(View view){
        Intent intent = new Intent(this, GuardianModuleStartActivity.class) ;
        startActivity(intent);
        finish();
    }

    public void goToTutorModule(View view){
        Intent intent = new Intent(this, TutorModuleStartActivity.class) ;
        startActivity(intent);
        finish();
    }
}
