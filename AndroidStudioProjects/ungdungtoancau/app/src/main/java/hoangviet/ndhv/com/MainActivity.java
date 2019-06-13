package hoangviet.ndhv.com;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
Button btn;
TextView txtInfo;
EditText etxtTen,etxtEmail,etxtSDT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        //code

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ten = etxtTen.getText().toString();
                String email = etxtEmail.getText().toString();
                String sDT = etxtSDT.getText().toString();
                String textHello = getResources().getString(R.string.text_chaoBan);
                String textEmail = getResources().getString(R.string.text_Email);
                String textSDT = getResources().getString(R.string.text_Sdt);

                txtInfo.setText(textHello+" :"+ten+"\n"+textEmail+": "+email+"\n"
                        +textSDT+": "+sDT);
            }
        });

    }

    private void Anhxa() {
        btn = (Button)findViewById(R.id.button);
        txtInfo = (TextView)findViewById(R.id.textViewThongTin);
        etxtTen = (EditText)findViewById(R.id.editTextName);
        etxtEmail = (EditText)findViewById(R.id.editTextEmail);
        etxtSDT = (EditText)findViewById(R.id.editTextSDT);
    }
}
