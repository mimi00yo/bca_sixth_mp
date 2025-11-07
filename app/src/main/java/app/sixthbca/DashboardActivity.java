package app.sixthbca;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DashboardActivity extends AppCompatActivity {
//type double shift to search any file
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dashboard);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
Button btnDialog = findViewById(R.id.btn_show_dialog);
btnDialog.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        //todo:show default dialog box here
    }
});
        //Context Menu Start
        Button btnContextMenu = findViewById(R.id.btn_context_menu);
        registerForContextMenu(btnContextMenu);

        //Popup menu
        Button btnPopUp = findViewById(R.id.btn_pop_menu);
        btnPopUp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                PopupMenu popup = new PopupMenu(DashboardActivity.this,view);
                popup.getMenuInflater().inflate(R.menu.pop_menu, popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        int id = menuItem.getItemId();
                        if(id == R.id.pop_one){
                            Toast.makeText(DashboardActivity.this,"Pop One", Toast.LENGTH_SHORT).show();
                        }
                        if(id == R.id.pop_two){
                            Toast.makeText(DashboardActivity.this,"Pop Two", Toast.LENGTH_SHORT).show();
                        }

                        return false;
                    }
                });
            }
        });
        }
        @Override
       public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.my_menu,menu);
        return true;
        }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu,menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int menuId = item.getItemId();
        if(menuId ==R.id.menu_one){

        }else if(menuId==R.id.menu_two){

        }
        return super.onOptionsItemSelected(item);
    }
}

//testinggg yesaii