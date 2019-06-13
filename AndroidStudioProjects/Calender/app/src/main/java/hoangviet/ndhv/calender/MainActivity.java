package hoangviet.ndhv.calender;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    TextView txtTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtTime = (TextView)findViewById(R.id.textTime);
        Calendar calendar = Calendar.getInstance();
        txtTime.append(toString().valueOf(calendar.getTime())+"\n");
        txtTime.append(toString().valueOf(calendar.get(Calendar.YEAR) + " \n"));
        SimpleDateFormat dateFormat =  new SimpleDateFormat("dd/MM/yyyy");
        txtTime.append(dateFormat.format(calendar.getTime()));

    }
}
