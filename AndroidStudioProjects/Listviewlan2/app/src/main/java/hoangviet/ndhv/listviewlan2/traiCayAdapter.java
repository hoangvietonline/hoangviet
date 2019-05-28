package hoangviet.ndhv.listviewlan2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class traiCayAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<traiCay> traiCayList;

    public traiCayAdapter(Context context, int layout, List<traiCay> traiCayList) {
        this.context = context;
        this.layout = layout;
        this.traiCayList = traiCayList;
    }


    @Override
    public int getCount() {
        return traiCayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout,null);
        // ánh xạ
        TextView txtTen = (TextView) view.findViewById(R.id.textTen);
        TextView txtMoTa = (TextView)view.findViewById(R.id.textMoTa);
        ImageView imgHinh = (ImageView)view.findViewById(R.id.imageHinh);

        // gán giá trị
        traiCay traiCay = traiCayList.get(i);
        txtTen.setText(traiCay.getTen());
        txtMoTa.setText(traiCay.getMoTa());
        imgHinh.setImageResource(traiCay.getHinh());

        return view;
    }
}
