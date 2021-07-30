package com.unity3d.player;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        getActionBar().hide();

        Animation topAnim, botAnim;
        TextView judul, subJudul;
        Button btnMulai;

        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_anim);
        botAnim = AnimationUtils.loadAnimation(this, R.anim.bot_anim);

        judul = findViewById(R.id.tv_judul);
        subJudul = findViewById(R.id.tv_subjudul);
        btnMulai = findViewById(R.id.btnMulai);

        judul.setAnimation(topAnim);
        subJudul.setAnimation(topAnim);
        btnMulai.setAnimation(botAnim);


        btnMulai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainMenu.class);
                startActivity(intent);

            }
        });

    }
}