package com.example.codeoff;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HP on 27-10-2017.
 */

public class SignUp extends AppCompatActivity{

    protected EditText email;
    protected EditText password;
    protected EditText name;
    protected Button signUpButton;
    private Spinner userSpinner;
    private StorageReference mStorage;
    private FirebaseAuth mFirebaseAuth;
    private FirebaseUser mFirebaseUser;
    private DatabaseReference mDatabase;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        password = (EditText)findViewById(R.id.editTextPassword);
        email = (EditText)findViewById(R.id.editTextEmail);
        name = (EditText)findViewById(R.id.editTextName);

        signUpButton = (Button) findViewById(R.id.signUpButton);
        mStorage = FirebaseStorage.getInstance().getReference();

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.userRadio);
        int radioButtonID = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = (RadioButton) radioGroup.findViewById(radioButtonID);
        final String selectedtext = (String) radioButton.getText();

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String pass = password.getText().toString();
                String emailID = email.getText().toString();
                final String Name = name.getText().toString().trim();
                final String type = selectedtext;

                pass = pass.trim();
                emailID = emailID.trim();

                if (pass.isEmpty() || emailID.isEmpty()) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(SignUp.this);
                    builder.setMessage("Error")
                            .setTitle("Error")
                            .setPositiveButton(android.R.string.ok, null);
                    AlertDialog dialog = builder.create();
                    dialog.show();
                } else {

                    mFirebaseAuth.createUserWithEmailAndPassword(emailID, pass)
                            .addOnCompleteListener(SignUp.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        User user = new User();
                                        user.setName(Name);
                                        user.setEmailID(email.getText().toString().trim());
                                        user.setTypeOfUser(selectedtext);
                                        mDatabase.child("Private User Data").child(mFirebaseAuth.getCurrentUser().getUid()).push().setValue(user);
                                        Intent intent = new Intent(SignUp.this, SignIn.class);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                        startActivity(intent);
                                    } else {
                                        AlertDialog.Builder builder = new AlertDialog.Builder(SignUp.this);
                                        builder.setMessage(task.getException().getMessage())
                                                .setTitle("Error")
                                                .setPositiveButton(android.R.string.ok, null);
                                        AlertDialog dialog = builder.create();
                                        dialog.show();
                                    }
                                }

                            });

                }
            }
        });






    }





}
