package com.example.learnrunyankole;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //call views
     TextView numbers = findViewById(R.id.numbers);
     TextView phrases = findViewById(R.id.phrases);
     TextView family = findViewById(R.id.family);
     TextView colors = findViewById(R.id.colors);

     //set click listeners for the views that will be clicked
     numbers.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent intent = new Intent(getApplicationContext(), NumbersActivity.class);
             startActivity(intent);
         }
     });

     phrases.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent intent = new Intent(getApplicationContext(),PhrasesActivity.class);
             startActivity(intent);
         }
     });

     colors.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent intent = new Intent(getApplicationContext(),ColorsActivity.class);
             startActivity(intent);
         }
     });

     family.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent intent = new Intent(getApplicationContext(),FamilyMembers.class);
             startActivity(intent);
         }
     });
    }

}
