package com.example.tuitionterminal.Tutor;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import android.os.Bundle;

import com.example.tuitionterminal.R;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TutorSignUpActivityStep1 extends AppCompatActivity {

    private EditText firstNameBox, lastNameBox, emailBox, mobileNumberBox ;

    private Spinner areaAddressBox, currentPositionBox, edu_instituteNameBox, edu_tutorSubjectBox ;
    private RadioGroup genderBoxGroup ;
    private RadioButton genderBox ;

    private FirebaseDatabase database ;
    private DatabaseReference databaseReference , myRefAccountInfo ;
    private FirebaseUser firebaseUser;
    private ProgressBar progressBar ;

    private String firstName, lastName, email, mobileNumber, gender, areaAddress, currentPosition, edu_instituteName, edu_tutorSubject ;

    private TutorAccountInfo AccountInfo, checkAccountInfo ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor_sign_up_step1);
        getSupportActionBar().hide();
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser() ;
        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference = databaseReference.child("AccountInfo").child(firebaseUser.getUid()) ;
    }

    @Override
    protected void onStart() {
        super.onStart();

        genderBoxGroup = (RadioGroup)findViewById(R.id.gender) ;
        areaAddressBox = (Spinner) findViewById(R.id.areaAddress);
        currentPositionBox = (Spinner) findViewById(R.id.currentPosition);
        edu_instituteNameBox = (Spinner) findViewById(R.id.Edu_instituteName);
        edu_tutorSubjectBox = (Spinner) findViewById(R.id.department);

        firstNameBox = findViewById(R.id.fName);
        lastNameBox = findViewById(R.id.lName);
        emailBox = findViewById(R.id.email);
        mobileNumberBox = findViewById(R.id.mobileNumber);
        genderBox = (RadioButton) findViewById((int) genderBoxGroup.getCheckedRadioButtonId());
        progressBar = findViewById(R.id.progressBar);

        ArrayAdapter<CharSequence> adapter0 = ArrayAdapter.createFromResource(this,
                R.array.areaAddress_array, android.R.layout.simple_spinner_item);

        adapter0.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        areaAddressBox.setAdapter(adapter0);

        emailBox.setText(firebaseUser.getEmail());
        emailBox.setEnabled(false);

        System.out.println(firebaseUser.getDisplayName() + " " + firebaseUser.getEmail() +" " +firebaseUser.getPhotoUrl());
    }

    public void signUpCompletion(View view) {

        progressBar.setVisibility(View.VISIBLE);

        firstName = firstNameBox.getText().toString().trim();
        lastName = lastNameBox.getText().toString().trim();
        email = emailBox.getText().toString().trim();
        mobileNumber = mobileNumberBox.getText().toString().trim();
        gender = genderBox.getText().toString().trim();
        areaAddress = areaAddressBox.getSelectedItem().toString();
        currentPosition = currentPositionBox.getSelectedItem().toString();
        edu_instituteName = edu_instituteNameBox.getSelectedItem().toString();
        edu_tutorSubject = edu_tutorSubjectBox.getSelectedItem().toString();

        AccountInfo = new TutorAccountInfo(firstName, lastName, email, mobileNumber, gender, areaAddress, currentPosition, edu_instituteName, edu_tutorSubject);

        //key = databaseReference.push().getKey() ;

        databaseReference.setValue(AccountInfo) ;
        Toast.makeText(getApplicationContext(),"sign up successfully",Toast.LENGTH_SHORT).show();
        goToTutorSignUpActivityStep2();
    }

    public void goToTutorSignUpActivityStep2(){
        Intent intent = new Intent(this,TutorSignUpActivityStep2.class);
        startActivity(intent);
        finish();
    }

    public void goToTutorSignUpActivityStep3(){
        Intent intent = new Intent(this,TutorSignUpActivityStep3.class);
        startActivity(intent);
        finish();
    }

    public void backFromSignUpT_Activity(View view){
        Intent intent = new Intent(this, TutorModuleStartActivity.class);
        startActivity(intent);
        finish();
    }

}

/*ArrayAdapter<CharSequence> adapter0 = ArrayAdapter.createFromResource(this,
                R.array.areaAddress_array, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.currentPosition_array, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.Edu_InstituteName_array, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,
                R.array.Edu_tutorSubject_array, android.R.layout.simple_spinner_item);

        adapter0.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        areaAddressBox.setAdapter(adapter0);
        currentPositionBox.setAdapter(adapter1);
        edu_instituteNameBox.setAdapter(adapter2);
        edu_tutorSubjectBox.setAdapter(adapter3);*/