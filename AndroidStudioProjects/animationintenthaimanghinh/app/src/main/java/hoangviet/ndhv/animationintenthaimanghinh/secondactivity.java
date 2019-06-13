package hoangviet.ndhv.animationintenthaimanghinh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class secondactivity extends AppCompatActivity {
Button button ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondactivity);
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(secondactivity.this,MainActivity.class));
                overridePendingTransition(R.anim.anim_enter,R.anim.anim_exit);
            }
        });
    }
}
