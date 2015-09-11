package com.mynameiszhangyong.textview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DataAtyFromLifeCircleAty extends ActionBarActivity {


    private Button btnClickBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_aty_from_life_circle_aty);
         Intent intent=this.getIntent();

        String msg=intent.getStringExtra("msg");
        Toast.makeText(this,"消息"+msg,Toast.LENGTH_SHORT).show();

        btnClickBtn=(Button)findViewById(R.id.btnClickBack);

        btnClickBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strMsg=getIntent().getStringExtra("joke");
                if (strMsg.equals("joke")){

                    Intent intent1=new Intent();
                    intent1.putExtra("ma","我就是我,不一样的烟火");
                    setResult(RESULT_OK, intent1);
                    finish();

                }else {


                    Intent intent1=new Intent();
                    intent1.putExtra("ma1","失败火");
                    setResult(RESULT_CANCELED,intent1);
                    finish();

                }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        getMenuInflater().inflate(R.menu.menu_data_aty_from_life_circle_aty, menu);
        return true;
//    jj
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
