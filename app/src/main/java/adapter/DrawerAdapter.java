package adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import in.sap.viewer.R;


/**
 * Created by adityamathur on 19/06/15.
 */
public class DrawerAdapter extends BaseAdapter {
    private String[] arr;
    Context context;
    Holder holderobj;

    public DrawerAdapter(Context con, String[] arr) {
        this.arr = arr;
        this.context = con;

    }

    public int getCount() {
        return arr.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public class Holder {
        TextView volumeNames;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        holderobj = new Holder();

        LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final String record = arr[position];
        if (convertView == null) {
            convertView = (RelativeLayout) vi.inflate(R.layout.nav_drawer_row, parent, false);
            holderobj.volumeNames = (TextView) convertView.findViewById(R.id.title);
            Typeface typeFace = Typeface.createFromAsset(context.getAssets(), "Charlotte_Sans.ttf");
            holderobj.volumeNames.setTypeface(typeFace);
            convertView.setTag(holderobj);
        } else {
            holderobj = (Holder) convertView.getTag();
        }
        try {
            if (position == 0 || position == 4 || position == 8) {
                holderobj.volumeNames.setBackgroundColor(Color.parseColor("#bdbdbd"));
               holderobj.volumeNames.setTextColor(Color.parseColor("#777D77"));
                holderobj.volumeNames.setTypeface(null, Typeface.BOLD);
                holderobj.volumeNames.setGravity(Gravity.CENTER);
            }


            holderobj.volumeNames.setText(record);

        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }


        return convertView;
    }
}
