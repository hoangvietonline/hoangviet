package hoangviet.ndhv.radiobutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
RadioGroup rdGroup;
RadioButton sang,trua,chieu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rdGroup = (RadioGroup) findViewById(R.id.radioGroup);
        sang = (RadioButton) findViewById(R.id.radioButton1);
        trua = (RadioButton) findViewById(R.id.radioButton2);
        chieu =(RadioButton) findViewById(R.id.radioButton3);
        // code
        rdGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int b) {
                switch (b){
                    case R.id.radioButton1:
                        Toast.makeText(MainActivity.this, "bạn chọn sáng", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButton2:
                        Toast.makeText(MainActivity.this, "bạn chọn trưa", Toast.LENGTH_SHORT).show();
                        break;
                    case  R.id.radioButton3:
                        Toast.makeText(MainActivity.this, "bạn chọn chiều", Toast.LENGTH_SHORT).show();
                        break;
                }

            }
        });
    }

}
