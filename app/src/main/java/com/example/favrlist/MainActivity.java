package com.example.favrlist;

import android.content.DialogInterface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.InputType;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView categorieRecyclerView;
    //TextView btnMain;
    FloatingActionButton fab;
    CategoryManager mCategoryManager = new CategoryManager(this);
   FloatingActionButton fabCancel;
   Switch aSwitch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
      //  btnMain = findViewById(R.id.btnMain);
        setSupportActionBar(toolbar);
        fab = findViewById(R.id.fab);
        fabCancel = findViewById(R.id.fabCancel);
        aSwitch = findViewById(R.id.aSwitch);


        categorieRecyclerView = findViewById(R.id.category_recyclerview);
        categorieRecyclerView.setAdapter(new CreatRecyclerAdaptor(mCategoryManager.retrieveCategory()));
        categorieRecyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this,2));
        //categorieRecyclerView.setVisibility(View.GONE);

//        btnMain.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this,"By Rohit sangwan - This App is Just For Practicing RecyclerView",Toast.LENGTH_LONG).show();
//
//                categorieRecyclerView.setVisibility(View.VISIBLE);
//                btnMain.setVisibility(View.GONE);
//
//            }
//        });
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog();
            }
        });
        fabCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Categories> catrg = new ArrayList<>();
               // Toast.makeText(MainActivity.this,"This Button Clear The Screen",Toast.LENGTH_LONG).show();
                 categorieRecyclerView.setAdapter(new CreatRecyclerAdaptor(catrg));
                mCategoryManager.removeCategory();
            }
        });
        aSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(aSwitch.getText().toString().equals("ListView")){
                   categorieRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                   aSwitch.setText("GridView");
               }else if(aSwitch.getText().toString().equals("GridView")){
                   categorieRecyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this,2));
                   aSwitch.setText("ListView");
               }
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void alertDialog(){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);

        alert.setTitle("Write A Note");
        final EditText alertText = new EditText(this);
        alertText.setInputType(InputType.TYPE_CLASS_TEXT);
        alert.setView(alertText);
        alert.setPositiveButton("Create", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Categories categories = new Categories(alertText.getText().toString(),new ArrayList<String>());
                mCategoryManager.saveCategory(categories);
                CreatRecyclerAdaptor recyclerViewAdapter = (CreatRecyclerAdaptor) categorieRecyclerView.getAdapter();
                recyclerViewAdapter.addAdapter(categories);

                dialog.dismiss();
            }
        });
        alert.create().show();
    }
}