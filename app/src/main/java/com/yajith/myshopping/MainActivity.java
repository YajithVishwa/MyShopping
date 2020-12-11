package com.yajith.myshopping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    private ImageButton shirt,pant;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        shirt=findViewById(R.id.tshirt);
        pant=findViewById(R.id.pant);
        shirt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ShirtActivity.class);
                intent.putExtra("type","shirt");
                startActivity(intent);
            }
        });
        pant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ShirtActivity.class);
                intent.putExtra("type","pant");
                startActivity(intent);
            }
        });
    }
}