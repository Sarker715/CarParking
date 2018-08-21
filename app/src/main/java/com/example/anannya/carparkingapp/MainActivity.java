package com.example.anannya.carparkingapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    TextView name;
    TextView std_no;
    TextView hour;
    TextView slot;
    TextView total;
    TextView message;
    ImageView confirm;
    List<String> slots = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        std_no = findViewById(R.id.std_no);
        hour = findViewById(R.id.hour);
        slot = findViewById(R.id.slot);
        total = findViewById(R.id.total);
        message = findViewById(R.id.txt_msg);
        confirm = findViewById(R.id.confirm);


        confirm.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {

                        if (name.getText().toString().isEmpty() || std_no.getText().toString().isEmpty() || hour.getText().toString().isEmpty() || slot.getText().toString().isEmpty() || total.getText().toString().isEmpty() || name.getText().toString().isEmpty()
                                || name.getText().toString().isEmpty()) {

                            message.setTextColor(Color.WHITE);
                            message.setText("Fill in everything !!!");

                        } else {
                            if (slots.contains(slot.getText().toString())) {
                                message.setTextColor(Color.WHITE);
                                message.setText("Slot is already taken !!!");
                            } else {
                                slots.add(slot.getText().toString());
                                message.setTextColor(Color.GREEN);
                                message.setText("Parking is confirmed");

                            }

                            total.setText(Double.toString(calculateTotal()));
                        }
                    }

                }
        );

    }

    private double calculateTotal() {
        double i = Double.parseDouble(hour.getText().toString()) * 3.5;
        return i;
    }
}
