package hoangviet.ndhv.intentdataresult;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class seconActiity extends AppCompatActivity {
    EditText editText;
    Button btn ;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secon_actiity);
        editText = (EditText)findViewById(R.id.editTextName);
        btn = (Button)findViewById(R.id.buttonXacNhan);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent();
                String ten =  editText.getText().toString();
                intent.putExtra("dulieu",ten);
                setResult(RESULT_OK,intent);
                finish();
            }
        });

    }
}
