package hoangviet.ndhv.edittext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnClick;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Ánh sạ
        btnClick = (Button) findViewById(R.id.buttonLayNoiDung);
        editText = (EditText) findViewById(R.id.editText);
        //code
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String noi_dung = editText.getText().toString();
                Toast.makeText(MainActivity.this,noi_dung,Toast.LENGTH_LONG).show();


            }
        });
    }
}
