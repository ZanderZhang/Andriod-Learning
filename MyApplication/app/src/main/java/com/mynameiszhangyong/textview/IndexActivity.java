package com.mynameiszhangyong.textview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class IndexActivity extends ActionBarActivity {

    private Button btnMainAty,btnSecondAty,btnLifeCircleAty;

    private ButtonListener listener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        FindViewButton();

        listener = new ButtonListener();

        SetClickListener();

    }

    private void SetClickListener() {
        btnMainAty.setOnClickListener(listener);
        btnSecondAty.setOnClickListener(listener);
        btnLifeCircleAty.setOnClickListener(listener);

        }

    private void FindViewButton() {
        btnMainAty = (Button)findViewById(R.id.btyMainAty);
        btnSecondAty=(Button)findViewById(R.id.btySecondAty);
        btnLifeCircleAty=(Button)findViewById(R.id.btyLifeCircleAty);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_index, menu);
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
    private class ButtonListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btyMainAty:
                    Intent i1=new Intent(IndexActivity.this,MainActivity.class);
                    startActivity(i1);
                    break;
                case R.id.btySecondAty:
                    Intent i2=new Intent(IndexActivity.this,SecondAty.class);
                    startActivity(i2);
                    break;
                case R.id.btyLifeCircleAty:
                    Intent i3=new Intent(IndexActivity.this,LifeCircleAty.class);
                    startActivity(i3);
                    break;


            }
        }
    }


}
