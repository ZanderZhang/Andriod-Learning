package com.mynameiszhangyong.textview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LifeCircleAty extends ActionBarActivity {

    private EditText etMsg;
    private Button btnSendMsg;

    private static final int RC_DATA_ATY=100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_circle_aty);

        etMsg=(EditText)findViewById(R.id.etMsg);
        btnSendMsg=(Button)findViewById(R.id.btnSendMsg);

        btnSendMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg=etMsg.getText().toString();
                Intent intent=new Intent(LifeCircleAty.this,DataAtyFromLifeCircleAty.class);
                intent.putExtra("msg",msg);
//                intent.setClass(LifeCircleAty.this,DataAtyFromLifeCircleAty.class);

                intent.putExtra("joke",msg);


//                startActivity(intent);

                startActivityForResult(intent,RC_DATA_ATY);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode ) {
            case RC_DATA_ATY:

                if (resultCode==RESULT_OK){
                    String strResult=data.getStringExtra("ma");
                    Toast.makeText(this,strResult,Toast.LENGTH_LONG).show();
                }else {
                    String strResult=data.getStringExtra("ma1");
                    Toast.makeText(this,strResult,Toast.LENGTH_LONG).show();
                }
            break;
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_life_circle_aty, menu);
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
