package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    CheckBox CB1,CB2,CB3;
    SeekBar SB1,SB2,SB3;
    Random random = new Random ();
    Integer integer=0;
    ImageButton IM1;
    int ramone;
    int ramtwo;
    int ramthree;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        index ();
        enventStrat();
        ckeckbox();
//        random();
        setSeekBar();
    }


    private void setSeekBar() {
    }

    private void ckeckbox() {
        CB1.setOnCheckedChangeListener ( new CompoundButton.OnCheckedChangeListener () {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CB2.setChecked ( false );
                CB3.setChecked ( false );
            }
        } );
        CB2.setOnCheckedChangeListener ( new CompoundButton.OnCheckedChangeListener () {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CB3.setChecked ( false );
                CB1.setChecked ( false );
            }
        } );
        CB3.setOnCheckedChangeListener ( new CompoundButton.OnCheckedChangeListener () {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CB2.setChecked ( false );
                CB1.setChecked ( false );
            }
        } );
    }

    private void enventStrat() {
        IM1.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                if (CB1.isChecked() || CB2.isChecked() || CB3.isChecked()){
                    random();
                    Hien();
                    IM1.setVisibility (View.INVISIBLE);
                    reset ();
                }else{
                    Toast.makeText ( MainActivity.this, "Put Bet", Toast.LENGTH_SHORT ).show ();
                }
            }
        } );
    }

    private void ckeckbox1() {
        CB1.setChecked ( false );
        CB2.setChecked ( false );
        CB3.setChecked ( false );
    }

    private void Hien() {
        SB1.setVisibility ( View.VISIBLE );
        SB3.setVisibility ( View.VISIBLE );
        SB2.setVisibility ( View.VISIBLE );
    }

    private void random() {
        CountDownTimer countDownTimer = new CountDownTimer (100000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                if (SB1.getProgress ()>=100){
                    this.cancel ();
                    Toast.makeText ( MainActivity.this, "1", Toast.LENGTH_SHORT ).show ();
                    ckeckbox1 ();
                    reset ();
                    IM1.setVisibility ( View.VISIBLE );
                }
                if (SB2.getProgress ()>=100){
                    this.cancel ();
                    Toast.makeText ( MainActivity.this, "2", Toast.LENGTH_SHORT ).show ();
                    ckeckbox1 ();
                    reset ();
                    IM1.setVisibility ( View.VISIBLE );
                }
                if (SB3.getProgress ()>=100){
                    this.cancel ();
                    Toast.makeText ( MainActivity.this, "3", Toast.LENGTH_SHORT ).show ();
                    ckeckbox1 ();
                    reset ();
                    IM1.setVisibility ( View.VISIBLE );
                }
                else {
                    int ramone = random.nextInt (15) ;
                    int ramtwo = random.nextInt (15);
                    int ramthree = random.nextInt (15);
                    SB1.setProgress ( SB1.getProgress ()+ramone );
                    SB2.setProgress ( SB2.getProgress ()+ramtwo );
                    SB3.setProgress ( SB3.getProgress ()+ramthree );
                }
            }
            @Overrid
            public void onFinish() {
            }
        }.start ();

    }
    private void reset(){
        int resert =0;
        SB1.setProgress ( resert );
        SB2.setProgress ( resert );
        SB3.setProgress ( resert );
    }
    private void index(){
        CB1 = findViewById ( R.id.CB1 );
        CB2 = findViewById ( R.id.CB2 );
        CB3 = findViewById ( R.id.CB3 );
        SB1 = findViewById ( R.id.SB1 );
        SB2 = findViewById ( R.id.SB2 );
        SB3 = findViewById ( R.id.SB3 );
        IM1 = (ImageButton) findViewById ( R.id.IM1 );
    }
}
