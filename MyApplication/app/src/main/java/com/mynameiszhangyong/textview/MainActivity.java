package com.mynameiszhangyong.textview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {


    private Button btnGetMoney;
    private TextView tvGetMoney;
    private  int money=0;
    private Button btnGetMoney2;
    private EditText edGoalMoney;

    private RadioGroup rgCCAVsurvey;
    private CheckBox cbLOL,cbGF,cbCodingMoney;
    private Button btnSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnGetMoney=(Button)findViewById(R.id.btnGetMoney);
        btnGetMoney2=(Button)findViewById(R.id.btnGetMoney2);
        tvGetMoney=(TextView)findViewById(R.id.tvGetMoney);
        edGoalMoney=(EditText)findViewById(R.id.edGoalMoney);

        btnSwitch = (Button)findViewById(R.id.btnSwichAty);
        btnSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,SecondAty.class);
                startActivity(intent);
            }
        });

        rgCCAVsurvey =(RadioGroup)findViewById(R.id.rgCCAVsurvey);
        cbLOL=(CheckBox)findViewById(R.id.cbLOL);
        cbGF=(CheckBox)findViewById(R.id.cbGirlFriend);
        cbCodingMoney=(CheckBox)findViewById(R.id.cbCodingMoney);



        btnGetMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strInputMoney=edGoalMoney.getText().toString().trim();
                int iMoney=Integer.parseInt(strInputMoney);
                if (iMoney==money){
                    Toast.makeText(MainActivity.this,"小伙子努力加油",Toast.LENGTH_SHORT).show();
                }else {
                money++;
                tvGetMoney.setText("哈哈,我挣到了"+money+"元");}
            }
        });
        btnGetMoney2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                money++;
//                tvGetMoney.setText("哈哈,我挣到了"+money+"元");
                if (money == 0) {
//                    提示
                    Toast.makeText(MainActivity.this, "别按了,没钱了", Toast.LENGTH_SHORT).show();
                } else {
                    money--;
                    tvGetMoney.setText("哈哈,我挣到了" + money + "元");
                }
            }
        });

        rgCCAVsurvey.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rbSoHappy:
                        Toast.makeText(MainActivity.this, "你开心就好", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbNoHappy:
                        Toast.makeText(MainActivity.this, "你要开心", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbZeng:
                        Toast.makeText(MainActivity.this, "你姓张", Toast.LENGTH_SHORT).show();
                        break;
                }
            }


        });
        cbLOL.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(MainActivity.this, "别玩游戏了", Toast.LENGTH_SHORT).show();
                }
            }
        });
        cbGF.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(MainActivity.this, "不错", Toast.LENGTH_SHORT).show();
                }
            }

        });
        cbCodingMoney.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(MainActivity.this, "小伙子加油", Toast.LENGTH_SHORT).show();
                }
            }

        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
