package com.example.tuitionterminal.Guardian;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.tuitionterminal.R;
import com.example.tuitionterminal.HomePageActivity;
import com.example.tuitionterminal.Tutor.TutorViewPostActivity;
import com.google.firebase.auth.FirebaseAuth;

public class GuardianHomePageActivity extends AppCompatActivity {

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guardian_home_page);
        mAuth = FirebaseAuth.getInstance();
    }

    public void goToGuardianPostForTuitionActivity(View view) {
        Intent intent = new Intent(this, GuardianPostForTuitionActivity.class);
        startActivity(intent);
        finish();

    }

    public void goToGuardianTutorProfileViewActivity(View view){
        Intent intent = new Intent(this, GuardianTutorProfileViewActivity.class) ;
        startActivity(intent);
        finish();
    }

    public void signOut(View view) {
        mAuth.signOut();

        Intent intent = new Intent(this, HomePageActivity.class);
        startActivity(intent);
        finish();

    }
}
