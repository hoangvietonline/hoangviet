package hoangviet.ndhv.seekbar;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    SeekBar seekBar1, seekBar2 , seekBar3;
    ImageButton btn;
    CheckBox checkBox1,checkBox2,checkBox3;
    TextView txtDiem;
    int diemSo = 100;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        anhxa();

            seekBar1.setEnabled(false);
            seekBar2.setEnabled(false);
            seekBar3.setEnabled(false);
        txtDiem.setText(String.valueOf(diemSo));
            final CountDownTimer countDownTimer = new CountDownTimer(60000,200) {
                @Override
                public void onTick(long millisUntilFinished) {
                    int number = 5;
                    Random random = new Random();
                    int one = random.nextInt(number);
                    int two = random.nextInt(number);
                    int three = random.nextInt(number);
                    // xét win
                    if (seekBar1.getProgress()>=seekBar1.getMax()){
                        this.cancel();
                        Toast.makeText(MainActivity.this, "Pikachu chiến thắng", Toast.LENGTH_SHORT).show();
                        btn.setVisibility(View.VISIBLE);
                        if (checkBox1.isChecked()){
                            diemSo += 10;
                        }
                        else {
                            diemSo -= 10;
                        }
                        txtDiem.setText(String.valueOf(diemSo));
                        EnabledCheckBox();
                    }
                    if (seekBar2.getProgress()>=seekBar2.getMax()){
                        this.cancel();
                        Toast.makeText(MainActivity.this, "Sâu chiến thắng", Toast.LENGTH_SHORT).show();
                        btn.setVisibility(View.VISIBLE);
                        if (checkBox2.isChecked()){
                            diemSo += 10;
                        }
                        else {
                            diemSo -= 10;
                        }
                        txtDiem.setText(diemSo+"");
                        EnabledCheckBox();
                    }
                    if (seekBar3.getProgress()>=seekBar3.getMax()){
                        this.cancel();
                        Toast.makeText(MainActivity.this, "Basac chiến thắng", Toast.LENGTH_SHORT).show();
                        btn.setVisibility(View.VISIBLE);
                        if (checkBox3.isChecked()){
                            diemSo += 10;
                        }
                        else {
                            diemSo -= 10;
                        }
                        txtDiem.setText(diemSo+"");
                        EnabledCheckBox();
                    }

                    seekBar1.setProgress( seekBar1.getProgress()+ one);
                    seekBar2.setProgress( seekBar2.getProgress()+ two);
                    seekBar3.setProgress( seekBar3.getProgress()+ three);
                }
                @Override
                public void onFinish() {

                }
            };
        // sự kiện khi bấm nút
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox1.isChecked()||checkBox2.isChecked()||checkBox3.isChecked()){
                    btn.setVisibility(View.INVISIBLE);
                    seekBar1.setProgress(0);
                    seekBar2.setProgress(0);
                    seekBar3.setProgress(0);
                    countDownTimer.start();
                    DisabledCheckBox();
                 }
                else{
                    Toast.makeText(MainActivity.this, "Bạn vui lòng đặt cược trước khi cuộc đua bắt đầu", Toast.LENGTH_SHORT).show();
                }
            }
        });
        // checkbox
        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                if(b){
                    checkBox2.setChecked(false);
                    checkBox3.setChecked(false);
                }
            }
        });
        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                if(b){
                    checkBox1.setChecked(false);
                    checkBox3.setChecked(false);
                }
            }
        });
        checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                if(b){
                    checkBox1.setChecked(false);
                    checkBox2.setChecked(false);
                }
            }
        });

    }
    public void EnabledCheckBox(){
            checkBox1.setEnabled(true);
            checkBox2.setEnabled(true);
            checkBox3.setEnabled(true);
    }

    public void DisabledCheckBox(){
            checkBox1.setEnabled(false);
            checkBox2.setEnabled(false);
            checkBox3.setEnabled(false);
    }
    public void anhxa(){
        seekBar1     = (SeekBar)findViewById(R.id.seekBar1);
        seekBar2     = (SeekBar)findViewById(R.id.seekBar2);
        seekBar3     = (SeekBar)findViewById(R.id.seekBar3);
        checkBox1    = (CheckBox)findViewById(R.id.checkbox1);
        checkBox2    = (CheckBox)findViewById(R.id.checkbox2);
        checkBox3    = (CheckBox)findViewById(R.id.checkbox3);
        btn          = (ImageButton)findViewById(R.id.button);
        txtDiem      = (TextView)findViewById(R.id.textView);
    }
}
