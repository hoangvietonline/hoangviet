package hoangviet.ndhv.onlaiphanintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class secondactivity extends AppCompatActivity {
TextView textView ;
EditText edt;
Button btnXacNhan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondactivity);
//        textView = (TextView) findViewById(R.id.textView1);
//        Intent intent = getIntent();
//        hocSinh hocSinh = (hocSinh) intent.getSerializableExtra("dulieu");
//        textView.setText(hocSinh.getName()+"-"+hocSinh.getTuoi());
//        String[] ten = intent.getStringArrayExtra("dulieu");
//        for (int i = 0 ; i < ten.length;i++){
//            textView.append(ten[i]+"\n");
//        }
        btnXacNhan = (Button)findViewById(R.id.buttonoke);
        edt = (EditText)findViewById(R.id.editText);
        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent();
                String ten = edt.getText().toString();
                intent.putExtra("dulieu",ten);
                setResult(RESULT_OK,intent);
                finish();
            }
        });

    }
}
