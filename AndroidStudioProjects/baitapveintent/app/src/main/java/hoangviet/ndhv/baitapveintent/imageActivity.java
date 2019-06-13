package hoangviet.ndhv.baitapveintent;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import java.util.Collections;

public class imageActivity extends Activity {
TableLayout myTable ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        myTable = (TableLayout)findViewById(R.id.tableLayout);
        int soDong = 3;
        int soCot = 3;

        for (int i = 1 ; i<= soDong ; i++){
            TableRow tableRow = new TableRow(this);
            for ( int j = 1 ; j <= soCot; j++){
                ImageView imageView =  new ImageView(this);
                TableRow.LayoutParams layoutParams =  new TableRow.LayoutParams(180,180);
                // set lai LayoutParams để có đc kích thước đã xác đinh ở trên
                imageView.setLayoutParams(layoutParams);
                final int vitri = soCot * (i-1) + j-1;
                Log.d("AAA", "onCreate SECOND ** "+ vitri);
                int idHinh = getResources().getIdentifier(MainActivity.arrayName.get(vitri),"drawable",getPackageName());
                imageView.setImageResource(idHinh);
                // add hinh vao dong trong table row
                tableRow.addView(imageView);
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        Toast.makeText(imageActivity.this,MainActivity.arrayName.get(vitri), Toast.LENGTH_SHORT).show();
                        Intent intent =  new Intent();
                        intent.putExtra("tenHinhChon",MainActivity.arrayName.get(vitri));
                        setResult(RESULT_OK,intent);
                        finish();
                    }
                });
            }
            //thêm tablerow và table
            myTable.addView(tableRow);
        }

    }
}
