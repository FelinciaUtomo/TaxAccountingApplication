package id.ac.petra.taxaccountingapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

import id.ac.petra.taxaccountingapplication.databinding.ActivityDrawerBinding;

public class DrawerActivity extends AppCompatActivity {

    ActivityDrawerBinding binding;
    ListAdapter listAdapter;
    ArrayList<ListData> dataArrayList = new ArrayList<>();
    ListData listData;
    DrawerLayout drawerLayout;
    ImageView menu;
    LinearLayout home, quiz, download, logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDrawerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int[] BasicAccountingList = {R.string.Concepts, R.string.basicAccounting,
                R.string.Types1, R.string.Detailed1, R.string.Types2, R.string.Detailed2,
                R.string.COA, R.string.COA1, R.string.COA2, R.string.COA3, R.string.COA4,
                R.string.COA5, R.string.AccountingEquations, R.string.BAEquations};

        for (int i = 0; i < BasicAccountingList.length; i++) {
            listData = new ListData(BasicAccountingList[i]);
            dataArrayList.add(listData);
        }

        listAdapter = new ListAdapter(DrawerActivity.this, dataArrayList);
        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);

        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(DrawerActivity.this, DetailedActivity.class);
                intent.putExtra("name", BasicAccountingList[i]);
                startActivity(intent);
            }
        });

        drawerLayout = findViewById(R.id.drawerLayout);
        menu = findViewById(R.id.menu);
        home = findViewById(R.id.home);
        quiz = findViewById(R.id.Quiz);
        download = findViewById(R.id.Download);
        logout = findViewById(R.id.Logout);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDrawer(drawerLayout);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recreate();
            }
        });

        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectActivity(DrawerActivity.this, QuizActivity.class);
            }
        });

        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectActivity(DrawerActivity.this, DownloadActivity.class);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DrawerActivity.this, "Logout", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static void openDrawer(DrawerLayout drawerLayout){
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public static void closDrawer(DrawerLayout drawerLayout){
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public static void  redirectActivity(Activity activity, Class secondActivity){
        Intent intent = new Intent(activity, secondActivity);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
        activity.finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
        closDrawer(drawerLayout);
    }
}
