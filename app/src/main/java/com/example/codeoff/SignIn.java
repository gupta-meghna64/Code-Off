package com.example.codeoff;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by jains on 27-10-2017.
 */

public class SignIn extends AppCompatActivity {

    public FirebaseAuth mFirebaseAuth;
    public EditText useremail;
    public EditText userpassword;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        mFirebaseAuth = FirebaseAuth.getInstance();
        useremail = (EditText) findViewById(R.id.editTextEmail);
        userpassword = (EditText) findViewById(R.id.editTextPassword);


        TextView tv = (TextView) findViewById(R.id.goToSignUp);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SignIn.this, SignUp.class);
                startActivity(i);
            }
        });


        Button signInButton = (Button) findViewById(R.id.loginButton);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = useremail.getText().toString();
                String password = userpassword.getText().toString();

                email = email.trim();
                password = password.trim();
                if (email.isEmpty() || password.isEmpty()) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(SignIn.this);
                    builder.setMessage("Hello")
                            .setTitle("Hello")
                            .setPositiveButton(android.R.string.ok, null);
                    AlertDialog dialog = builder.create();
                    dialog.show();
                } else {
                    mFirebaseAuth.signInWithEmailAndPassword(email, password)
                            .addOnCompleteListener(SignIn.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        Intent intent = new Intent(SignIn.this, MainActivity.class);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                        startActivity(intent);
                                    } else {
                                        AlertDialog.Builder builder = new AlertDialog.Builder(SignIn.this);
                                        builder.setMessage(task.getException().getMessage())
                                                .setTitle("Hello")
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
