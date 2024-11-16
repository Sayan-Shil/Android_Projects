package com.gfx.tictactoe;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    ImageButton btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;

    int count=0;
    boolean flag=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });

        init();
    }
    private void init(){

        btn1= findViewById(R.id.btn1);
        btn2= findViewById(R.id.btn2);
        btn3= findViewById(R.id.btn3);
        btn4= findViewById(R.id.btn4);
        btn5= findViewById(R.id.btn5);
        btn6= findViewById(R.id.btn6);
        btn7= findViewById(R.id.btn7);
        btn8= findViewById(R.id.btn8);
        btn9= findViewById(R.id.btn9);



    }

    public void input(View v) {
        ImageButton btn = (ImageButton) v;

        if (flag) {
            if (btn.getTag() == null) { // Check if the button has not been clicked yet
                btn.setImageResource(R.drawable.cross);
                btn.setTag("X"); // Set tag to "X"
                flag = false;
                count++;
            }
        } else {
            if (btn.getTag() == null) { // Check if the button has not been clicked yet
                btn.setImageResource(R.drawable.circle);
                btn.setTag("O"); // Set tag to "O"
                flag = true;
                count++;
            }
        }

        if(count==9){
            Toast.makeText(this, "Draw !!!!", Toast.LENGTH_SHORT).show();
            restart();
        }

        if (count > 4) {
            checkWinner();
        }
    }


    public void checkWinner() {
        // Check horizontal rows
        if (btn1.getTag() != null && btn1.getTag().equals(btn2.getTag()) && btn2.getTag().equals(btn3.getTag())) {
            btn1.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));
            btn2.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));
            btn3.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));
            Toast.makeText(this, "Player " + btn1.getTag() + " wins!", Toast.LENGTH_SHORT).show();
            restart();
        } else if (btn4.getTag() != null && btn4.getTag().equals(btn5.getTag()) && btn5.getTag().equals(btn6.getTag())) {
            btn4.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));
            btn5.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));
            btn6.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));
            Toast.makeText(this, "Player " + btn4.getTag() + " wins!", Toast.LENGTH_SHORT).show();
            restart();
        } else if (btn7.getTag() != null && btn7.getTag().equals(btn8.getTag()) && btn8.getTag().equals(btn9.getTag())) {
            btn7.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));
            btn8.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));
            btn9.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));
            Toast.makeText(this, "Player " + btn7.getTag() + " wins!", Toast.LENGTH_SHORT).show();
            restart();
        }

        // Check vertical columns
        else if (btn1.getTag() != null && btn1.getTag().equals(btn4.getTag()) && btn4.getTag().equals(btn7.getTag())) {
            btn1.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));
            btn4.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));
            btn7.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));
            Toast.makeText(this, "Player " + btn1.getTag() + " wins!", Toast.LENGTH_SHORT).show();
            restart();
        } else if (btn2.getTag() != null && btn2.getTag().equals(btn5.getTag()) && btn5.getTag().equals(btn8.getTag())) {
            btn2.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));
            btn5.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));
            btn8.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));
            Toast.makeText(this, "Player " + btn2.getTag() + " wins!", Toast.LENGTH_SHORT).show();
            restart();
        } else if (btn3.getTag() != null && btn3.getTag().equals(btn6.getTag()) && btn6.getTag().equals(btn9.getTag())) {
            btn3.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));
            btn6.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));
            btn9.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));
            Toast.makeText(this, "Player " + btn3.getTag() + " wins!", Toast.LENGTH_SHORT).show();
            restart();
        }

        // Check diagonals
        else if (btn1.getTag() != null && btn1.getTag().equals(btn5.getTag()) && btn5.getTag().equals(btn9.getTag())) {
            btn1.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));
            btn5.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));
            btn9.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));
            Toast.makeText(this, "Player " + btn1.getTag() + " wins!", Toast.LENGTH_SHORT).show();
            restart();
        } else if (btn3.getTag() != null && btn3.getTag().equals(btn5.getTag()) && btn5.getTag().equals(btn7.getTag())) {
            btn3.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));
            btn5.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));
            btn7.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));
            Toast.makeText(this, "Player " + btn3.getTag() + " wins!", Toast.LENGTH_SHORT).show();
            restart();
        }
    }

    public void restart(){

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                count =0;
                flag=true;

                // Reset the tags as well
                btn1.setTag(null);
                btn2.setTag(null);
                btn3.setTag(null);
                btn4.setTag(null);
                btn5.setTag(null);
                btn6.setTag(null);
                btn7.setTag(null);
                btn8.setTag(null);
                btn9.setTag(null);

                btn1.setImageDrawable(null);
                btn2.setImageDrawable(null);
                btn3.setImageDrawable(null);
                btn4.setImageDrawable(null);
                btn5.setImageDrawable(null);
                btn6.setImageDrawable(null);
                btn7.setImageDrawable(null);
                btn8.setImageDrawable(null);
                btn9.setImageDrawable(null);

                btn1.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.black)));
                btn2.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.black)));
                btn3.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.black)));
                btn4.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.black)));
                btn5.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.black)));
                btn6.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.black)));
                btn7.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.black)));
                btn8.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.black)));
                btn9.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.black)));





            }
        },1000);


    }




}