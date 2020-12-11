package com.yajith.myshopping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PayActivity extends AppCompatActivity {
    private EditText card,date,cvv;
    private Button pay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
        card=findViewById(R.id.card);
        date=findViewById(R.id.date);
        cvv=findViewById(R.id.cvv);
        pay=findViewById(R.id.submit);
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(card.getText().toString().equals("")) {
                    Toast.makeText(PayActivity.this, "Enter Card No", Toast.LENGTH_SHORT).show();return;
                }
                else if(date.getText().toString().equals(""))
                {
                    Toast.makeText(PayActivity.this, "Enter Date", Toast.LENGTH_SHORT).show();return;
                }
                else if (cvv.getText().toString().equals(""))
                {
                    Toast.makeText(PayActivity.this, "Enter CVV", Toast.LENGTH_SHORT).show();return;
                }
                else
                {
                    Toast.makeText(PayActivity.this, "Confirming Payment", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(new Intent(PayActivity.this,MainActivity.class));
                }

            }
        });

    }
}