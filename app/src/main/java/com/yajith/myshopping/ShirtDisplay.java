package com.yajith.myshopping;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ShirtDisplay extends AppCompatActivity {
    private ImageView shirt,c1,c2,c3,c4,c5;
    private Button upload,pay;
    private String type;
    private RadioButton radioButton1,radioButton2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shirt_display);
        shirt=findViewById(R.id.image);
        c1=findViewById(R.id.c1);
        c2=findViewById(R.id.c2);
        c3=findViewById(R.id.c3);
        c4=findViewById(R.id.c4);
        c5=findViewById(R.id.c5);
        pay=findViewById(R.id.submit);
            type=getIntent().getExtras().getString("type");
        switch (type)
        {
            case "tshirt":shirt.setImageResource(R.drawable.tshirt);break;
            case "uniform":shirt.setImageResource(R.drawable.uniform);break;
            case "trousers":shirt.setImageResource(R.drawable.trousers);break;
            case "pants":shirt.setImageResource(R.drawable.pants);break;
        }
        upload=findViewById(R.id.upload);
        radioButton1=findViewById(R.id.defaultradio);
        radioButton2=findViewById(R.id.custom);
        radioButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                upload.setEnabled(true);
            }
        });
        radioButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                upload.setEnabled(false);

            }
        });
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shirt.setColorFilter(Color.parseColor("#FFBB86FC"));
            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shirt.setColorFilter(Color.parseColor("#FF3700B3"));
            }
        });
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shirt.setColorFilter(Color.parseColor("#FF6200EE"));
            }
        });
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shirt.setColorFilter(Color.parseColor("#FF000000"));
            }
        });
        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shirt.setColorFilter(Color.parseColor("#EEB59494"));
            }
        });
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, 100);
            }
        });
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ShirtDisplay.this,DetailActivity.class);
                intent.putExtra("type",type);
                finish();
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode)
        {
            case 100:
                if(resultCode==RESULT_OK)
                {
                    Uri uri=data.getData();
                    if(uri!=null)
                    {
                        shirt.setImageURI(uri);
                    }
                }
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);

    }
}