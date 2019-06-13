package hoangviet.ndhv.ungdungdemngay;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText edtDau, edtCuoi, edtgio;
    TextView txtView;
    Calendar calendarOne,calendarTwo;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        edtgio = (EditText)findViewById(R.id.editTextChonGio);
        edtgio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chonGio();
            }
        });
        // chọn ngày đầu
        edtDau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chonNgay1();
            }
        });
        // chọn ngày cuối
        edtCuoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chonNgay2();
            }
        });
        // tính ngày nk
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tinhNgay = (int)((calendarTwo.getTimeInMillis()-calendarOne.getTimeInMillis())/(1000*60*60*24));
                txtView.setText("số ngày cách xa em: "+tinhNgay+"");
            }
        });

    }

    private void chonNgay1(){
        calendarOne = Calendar.getInstance();
        int ngay = calendarOne.get(Calendar.DAY_OF_MONTH);
        int thang = calendarOne.get(Calendar.MONTH);
        int nam = calendarOne.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendarOne.set(year,month,dayOfMonth);

                edtDau.setText(dateFormat.format(calendarOne.getTime()));
            }
        },nam,thang,ngay);
        datePickerDialog.show();
    }
    private void chonNgay2(){
        calendarTwo = Calendar.getInstance();
        int ngay = calendarTwo.get(Calendar.DAY_OF_MONTH);
        int thang = calendarTwo.get(Calendar.MONTH);
        int nam = calendarTwo.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendarTwo.set(year,month,dayOfMonth);
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                edtCuoi.setText(dateFormat.format(calendarTwo.getTime()));
            }
        },nam,thang,ngay);
        datePickerDialog.show();
    }
    private void Anhxa() {
        btn = (Button) findViewById(R.id.button);
        edtDau = (EditText) findViewById(R.id.editText1);
        edtCuoi = (EditText) findViewById(R.id.editText2);
        txtView = (TextView) findViewById(R.id.textView);

    }
    private void chonGio(){
        final Calendar calendar = Calendar.getInstance();
        final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        int gio = calendar.get(Calendar.HOUR_OF_DAY);
        int phut = calendar.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                calendar.set(0,0,0,hourOfDay,minute);
                edtgio.setText(dateFormat.format(calendar.getTime()));



            }
        },gio,phut,true);
        timePickerDialog.show();
    }
}
