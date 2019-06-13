package hoangviet.ndhv.intentdataresult;

import android.content.Intent;
import android.media.AudioFocusRequest;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView txtname;
Button btn;
int REQUET_CODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtname = (TextView)findViewById(R.id.textViewName);
        btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(MainActivity.this, seconActiity.class);
                startActivityForResult(intent,REQUET_CODE);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQUET_CODE && resultCode == RESULT_OK && data != null){
            String ten =  data.getStringExtra("dulieu");
            txtname.setText(ten);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
