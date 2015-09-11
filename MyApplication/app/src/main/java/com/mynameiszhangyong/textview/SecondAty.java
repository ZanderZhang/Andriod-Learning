package com.mynameiszhangyong.textview;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class SecondAty extends ActionBarActivity {


    private RatingBar rtbScore;
    private SeekBar skbScore;
    private TextView tvScore;
    private ImageButton ibTimeGoing;
    private ProgressBar pbTimeWaiting;

    private DatePicker dpPicker;
    private TimePicker tpPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_aty);
        rtbScore = (RatingBar)findViewById(R.id.rtbScore);
        skbScore = (SeekBar)findViewById(R.id.skbScore);
        tvScore=(TextView)findViewById(R.id.tvScore);

        ibTimeGoing=(ImageButton)findViewById(R.id.ibTimeGoing);
        pbTimeWaiting=(ProgressBar)findViewById(R.id.pbTimeWaiting);


        dpPicker=(DatePicker)findViewById(R.id.dpPicker);
        tpPicker=(TimePicker)findViewById(R.id.tpPicker);

        dpPicker.setCalendarViewShown(false);
        tpPicker.setIs24HourView(true);
        tpPicker.setCurrentHour(20);
        tpPicker.setCurrentMinute(20);
        dpPicker.init(2014, 2, 15, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Toast.makeText(SecondAty.this,"你所选择的日期"+year+(monthOfYear+1)+dayOfMonth,Toast.LENGTH_SHORT).show();
            }
        });
        tpPicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                Toast.makeText(SecondAty.this,"你所选择的时间"+" "+hourOfDay+" "+minute,Toast.LENGTH_SHORT).show();

            }
        });




        ibTimeGoing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pbTimeWaiting.setVisibility(View.VISIBLE);
                Thread thread=new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });

        rtbScore.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                System.out.println(fromUser+"s dfdfffff");

                Toast.makeText(SecondAty.this,"自己的评分" + rating, Toast.LENGTH_SHORT).show();
            }
        });
        skbScore.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvScore.setText("复兴进度"+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_second_aty, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
