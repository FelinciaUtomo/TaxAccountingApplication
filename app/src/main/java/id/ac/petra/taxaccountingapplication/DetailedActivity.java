package id.ac.petra.taxaccountingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import id.ac.petra.taxaccountingapplication.databinding.ActivityDetailedBinding;

public class DetailedActivity extends AppCompatActivity {

    ActivityDetailedBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailedBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = this.getIntent();
        if (intent != null){
            String name = intent.getStringExtra("name");
            binding.BAEquiations.setText(name);
            binding.BasicAccountingEquations.setText(name);
            binding.COA1.setText(name);
            binding.COA2.setText(name);
            binding.COA3.setText(name);
            binding.COA4.setText(name);
            binding.COA5.setText(name);
            binding.Type1.setText(name);
            binding.Type2.setText(name);
            binding.detailType1.setText(name);
            binding.detailType2.setText(name);
            binding.detailAccounting.setText(name);
            binding.detailName.setText(name);
            binding.concepts.setText(name);
            binding.typesAcc.setText(name);
            binding.COA.setText(name);
        }
    }
}