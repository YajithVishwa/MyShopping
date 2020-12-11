package com.yajith.myshopping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class DetailActivity extends AppCompatActivity {
    private EditText count,size1,size2,size3;
    private TextInputLayout t1,t2,t3,t4;
    private Button pay;
    private String type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        count=findViewById(R.id.count);
        size1=findViewById(R.id.size1);
        size2=findViewById(R.id.size2);
        size3=findViewById(R.id.size3);
        t1=findViewById(R.id.outlinedTextField1);
        t2=findViewById(R.id.outlinedTextField2);
        t3=findViewById(R.id.outlinedTextField3);
        t4=findViewById(R.id.outlinedTextField4);
        pay=findViewById(R.id.submit);
            type=getIntent().getExtras().getString("type");
        switch (type)
        {
            case "tshirt":t1.setHint("Shirt Count");t2.setHint("Waist Size");t3.setHint("Shoulder Size");t4.setHint("Shirt Length");break;
            case "uniform":t1.setHint("Uniform Count");t2.setHint("Waist Size");t3.setHint("Shoulder Size");t4.setHint("Uniform Length");break;
            case "pant":t1.setHint("Pant Count");t2.setHint("Hip Size");t3.setHint("Leg Size");t4.setHint("Pant Length");break;
            case "trousers":t1.setHint("Trousers Count");t2.setHint("Hip Size");t3.setHint("Thigh Size");t4.setHint("Trouser Length");break;
        }
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DetailActivity.this,PayActivity.class);
                finish();
                startActivity(intent);
            }
        });


    }
}