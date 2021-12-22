package com.ilyascilingir.storingdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.ilyascilingir.storingdata.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    SharedPreferences sharedPreferences;

    //private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //binding = ActivityMainBinding.inflate(getLayoutInflater());
        //View view = binding.getRoot();
        //setContentView(view);

        editText = findViewById(R.id.editText2);
        textView = findViewById(R.id.Textview);

       sharedPreferences = this.getSharedPreferences("com.ilyascilingir.storingdata", Context.MODE_PRIVATE);

       int storedAge = sharedPreferences.getInt("storedAge",0);

       if(storedAge==0){
           textView.setText("Your Age: ");
       }else{
           textView.setText("Your age: " + storedAge);
       }

        //binding.editText2.getText();
        //binding.Textview.getText();

    }

    public void save(View view){

        if(!editText.getText().toString().matches("")){
            int userAge = Integer.parseInt(editText.getText().toString());
            textView.setText("Your Age: " + userAge);

            sharedPreferences.edit().putInt("storedAge",userAge).apply();
        }
    }

    public void delete(View view){

            int storedData = sharedPreferences.getInt("storedAge",0);

            if(storedData!=0){
                sharedPreferences.edit().remove("storedAge").apply();
                textView.setText("Your Age: ");
            }
        }
    }


