package hoangviet.ndhv.intentexplicit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class secondActivity extends AppCompatActivity {
TextView txtview ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        txtview = (TextView)findViewById(R.id.textViewsecond);
        Intent intent = getIntent();

        Bundle bundle = intent.getBundleExtra("dulieu");

        String[] ten = bundle.getStringArray("array");
        txtview.setText(ten[0]+"");
    }
}
