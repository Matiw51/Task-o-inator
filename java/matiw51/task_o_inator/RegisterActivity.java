package matiw51.task_o_inator;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.*;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

class RegisterActivity extends AppCompatActivity {
    private EditText emailField;
    private EditText passwordField;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button registerbutton;
        mAuth = FirebaseAuth.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        emailField = (EditText) findViewById(R.id.editLogin);
        passwordField = (EditText) findViewById(R.id.editPassword);
        registerbutton = (Button) findViewById(R.id.buttonRegister);

        FirebaseAuth.AuthStateListener mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() != null) {
                    startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                }
            }

        };

        registerbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                startRegister();
            }
        });
    }
    private void startRegister() {
        String email=emailField.getText().toString();
        String password=passwordField.getText().toString();
        if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)){
            Toast.makeText(RegisterActivity.this, "Fields are empty", Toast.LENGTH_LONG).show();
        }
        else {
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull com.google.android.gms.tasks.Task<AuthResult> task) {
                    if (!task.isSuccessful()) {
                        Toast.makeText(RegisterActivity.this, "Registration Problem", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }

}
