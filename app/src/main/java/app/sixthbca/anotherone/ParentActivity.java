package app.sixthbca.anotherone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import app.sixthbca.R;

public class ParentActivity extends AppCompatActivity {

    private ActivityResultLauncher<Intent> resultAucha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_parent);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnAddUser =findViewById(R.id.btnAddUser);

        //Register the launcher to get result
        //alt enter to find the type like ActivityResultLauncher
        ActivityResultLauncher<Intent> resultAucha = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {

                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                            String name = result.getData().getStringExtra("user_name");
                            Toast.makeText(ParentActivity.this, "User added:" + name, Toast.LENGTH_SHORT).show();
                        }
                        if (result.getResultCode() == RESULT_CANCELED) {
                            Toast.makeText(ParentActivity.this, "Action cancelled", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        //Start child activity when button clicked
//        btnAddUser.setOnClickListener(View v -> {
//            Intent intent = new Intent(ParentActivity.this, AddUserActivity.class);
//            resultAucha.launch(intent);
//        });
    }

   public void onAddClick(View view) {
       Intent intent = new Intent(ParentActivity.this, AddUserActivity.class);
      resultAucha.launch(intent);
   }
}