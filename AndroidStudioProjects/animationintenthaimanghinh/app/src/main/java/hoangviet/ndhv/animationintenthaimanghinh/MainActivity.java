package hoangviet.ndhv.animationintenthaimanghinh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button buttonmain ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonmain = (Button)findViewById(R.id.buttonmain);
        buttonmain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,secondactivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.anim_enter,R.anim.anim_exit);
            }
        });
    }
}
