package app.sixthbca;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {
    EditText etEmail;
    EditText etPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button btnForgotPass = findViewById(R.id.btn_forgotpassword);
         etEmail = findViewById(R.id.et_email);
         etPassword = findViewById(R.id.et_password);


        btnForgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("Forgot Button","Forgot button ko kaam garxa");
                /*1. Create destination class/activity
                2. Make design of that class
                3. tyo activity ma switch hune code yo button click garda lekhnu paryo
                 */
                Intent intent = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
                startActivity(intent);

            }
        });
    }

    public void onLoginClick(View view) {
        String email = etEmail.getText().toString();
        String pw = etPassword.getText().toString();
        Log.e("Email tag", email);
        Log.e("Password tag", pw);

        if(etEmail.getText().toString().isEmpty()){
            etEmail.setError("This field is required");
        }
        if(pw.isEmpty()){
            etPassword.setError("This field is required");
        }
        // TODO: Write your login validation logic here
        Toast.makeText(LoginActivity.this,
                "Hello, I am a toast!",
                Toast.LENGTH_LONG).show();
        Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
        intent.putExtra("data","hello");
        startActivity(intent);
    }

}
