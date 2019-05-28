package hoangviet.ndhv.checkbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
CheckBox android,ios,cbcheck;
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String monhoc = "Tôi đã chọn môn học: \n";
                if (android.isChecked()){
                    monhoc += android.getText() + "\n";
                }
                if (ios.isChecked()){
                    monhoc += ios.getText() + "\n";
                }
                if (cbcheck.isChecked()){
                    monhoc += cbcheck.getText() + "\n";
                }
                Toast.makeText(MainActivity.this,  monhoc, Toast.LENGTH_LONG).show();
            }
        });
        android.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                if (b){
                    Toast.makeText(MainActivity.this, "Bạn đã chọn Andoid", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Bạn không chon Andoid", Toast.LENGTH_SHORT).show();
                }
            }
        });
        ios.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                if (b){
                    Toast.makeText(MainActivity.this, "Bạn đã chọn IOS", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Bạn không chon IOS", Toast.LENGTH_SHORT).show();
                }
            }
        });
        cbcheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                if (b){
                    Toast.makeText(MainActivity.this, "Bạn đã chọn CheckBox", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Bạn không chon CheckBox", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    private void anhxa(){
        android = (CheckBox)findViewById(R.id.checkBox1);
        ios = (CheckBox) findViewById(R.id.checkBox2);
        cbcheck = (CheckBox)findViewById(R.id.checkBox3);
        btn = (Button) findViewById(R.id.button);
    }
}
