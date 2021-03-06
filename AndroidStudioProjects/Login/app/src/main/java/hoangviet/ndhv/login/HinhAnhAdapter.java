package hoangviet.ndhv.login;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class HinhAnhAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<HinhAnh>hinhAnhList;


    public HinhAnhAdapter(Context context, int layout, List<HinhAnh> hinhAnhList) {
        this.context = context;
        this.layout = layout;
        this.hinhAnhList = hinhAnhList;
    }

    @Override
    public int getCount() {
        return hinhAnhList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    private class ViewHolder{
        ImageView imgHinh;
        TextView txtTen;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        ViewHolder holder ;
        if (view == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,null);
            holder.imgHinh = (ImageView)view.findViewById(R.id.imageHinhAnh);
            holder.txtTen = (TextView)view.findViewById(R.id.textTen);
            view.setTag(holder);
        }else {
            holder = (ViewHolder)view.getTag();

        }
        HinhAnh hinhAnh = hinhAnhList.get(i);
        holder.txtTen.setText(hinhAnh.getHinh());
        holder.imgHinh.setImageResource(hinhAnh.getHinh());



        return view;
    }
}
