package app.sixthbca.dialogs;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import app.sixthbca.R;

public class MyDialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_my_dialog);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button customButton = findViewById(R.id.btn_custom);
        customButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog mineDialog = new Dialog(MyDialogActivity.this);
                mineDialog.setContentView(R.layout.custom_dialog_box);
                //start referencing views
                Button btnAgree = mineDialog.findViewById(R.id.btnAgree);
                Button btnDisAgree = mineDialog.findViewById(R.id.btnDisagree);

                btnAgree.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MyDialogActivity.this, "Let's visit", Toast.LENGTH_SHORT).show();
                        mineDialog.dismiss();
                    }
                });

                btnDisAgree.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MyDialogActivity.this, "Let's not go now", Toast.LENGTH_SHORT).show();
                        mineDialog.dismiss();
                    }
                });

                mineDialog.show();
            }
        });
        Button btnShowDialog = findViewById(R.id.btn_show_dialog);
        btnShowDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //todo: write dialog box code here
                AlertDialog.Builder dialog = new AlertDialog.Builder(MyDialogActivity.this);
                dialog.setTitle("This is my dialog title");
                dialog.setCancelable(false);
                dialog.setMessage("It's gloomy today" + "It's kinda cold");
                dialog.setPositiveButton("Yess", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MyDialogActivity.this,
                                "We are feeling cold now", Toast.LENGTH_SHORT).show();
                        dialogInterface.cancel();
                    }
                });
                dialog.setNegativeButton("Noo", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MyDialogActivity.this,
                                "We are feeling warm", Toast.LENGTH_SHORT).show();
                        dialogInterface.cancel();

                    }
                });
                dialog.setNeutralButton("I don't knoww", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MyDialogActivity.this,
                                "We are neither warm nor cold", Toast.LENGTH_SHORT).show();
                        dialogInterface.cancel();
                    }
                });

                dialog.show();
            }
        });
    }
}

