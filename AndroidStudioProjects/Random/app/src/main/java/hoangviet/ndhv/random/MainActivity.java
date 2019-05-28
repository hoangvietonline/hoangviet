package hoangviet.ndhv.random;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button btnClick;
    TextView txtView;
    EditText editMin;
    EditText editMax;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Random random = new Random();
                String so1 = editMin.getText().toString();
                String so2 = editMax.getText().toString();

                if (so1.length() == 0 || so2.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Bạn chưa nhập số vào màng hình", Toast.LENGTH_SHORT).show();
                }
                else {
                    // chuyển kiểu String sáng kiểu số Int
                    int Min = Integer.parseInt(so1);
                    int Max = Integer.parseInt(so2);
                    int number = random.nextInt(Max - Min + 1) + Min;

                    txtView.setText(String.valueOf(number));
                }
            }
        });

        }

    private void Anhxa() {
        // ánh sạ
        btnClick = (Button) findViewById(R.id.buttonRandom);
        txtView = (TextView) findViewById(R.id.textViewNumber);
        editMin = (EditText) findViewById(R.id.Min);
        editMax = (EditText) findViewById(R.id.Max);
        // code
    }
}


