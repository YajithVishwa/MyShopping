package com.yajith.myshopping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ShirtActivity extends AppCompatActivity {
    private ImageView shirt,uniform;
    private String type="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shirt);
        shirt=findViewById(R.id.tshirt);
        uniform=findViewById(R.id.uniform);
            type=getIntent().getExtras().getString("type");
        if(type.equals("shirt"))
        {
            shirt.setImageResource(R.drawable.tshirt);
            uniform.setImageResource(R.drawable.uniform);
        }
        else
        {
            shirt.setImageResource(R.drawable.trousers);
            uniform.setImageResource(R.drawable.pants);
        }
        shirt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ShirtActivity.this,ShirtDisplay.class);
                if(shirt.getDrawable().getConstantState()==getResources().getDrawable(R.drawable.tshirt).getConstantState())
                {
                    intent.putExtra("type","tshirt");
                }
                else
                {
                    intent.putExtra("type","trousers");
                }
                startActivity(intent);
            }
        });
        uniform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ShirtActivity.this,ShirtDisplay.class);
                if(shirt.getDrawable().getConstantState()==getResources().getDrawable(R.drawable.tshirt).getConstantState())
                {
                    intent.putExtra("type","uniform");
                }
                else
                {
                    intent.putExtra("type","pants");
                }
                startActivity(intent);
            }
        });

    }
}