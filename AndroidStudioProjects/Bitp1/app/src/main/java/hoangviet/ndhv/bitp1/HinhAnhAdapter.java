package hoangviet.ndhv.bitp1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

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
    private class Holder{
        ImageView imageHinh;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        Holder holder = new Holder();
        if (view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,null);
            holder.imageHinh = (ImageView)view.findViewById(R.id.imageHinhAnh);
            view.setTag(holder);
        }
        else {
            holder = (Holder)view.getTag();
        }
        HinhAnh hinhAnh = hinhAnhList.get(i);
        holder.imageHinh.setImageResource(hinhAnh.getHinh());
        return view;
    }
}
