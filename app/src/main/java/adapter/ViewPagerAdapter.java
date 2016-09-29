package adapter;

import android.app.Activity;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import in.sap.viewer.R;

public class ViewPagerAdapter extends PagerAdapter {

    Activity activity;
    int imageArray[];
    ArrayList<String> array;
    ArrayList<String> colourarray;

    LayoutInflater mLayoutInflater;

    public ViewPagerAdapter(Activity act, ArrayList<String> array) {
        activity = act;
        this.array = array;
        this.colourarray = array;
        mLayoutInflater = (LayoutInflater) activity.getSystemService(activity.LAYOUT_INFLATER_SERVICE);
    }

    public int getCount() {
        return array.size();
    }

    public Object instantiateItem(ViewGroup collection, int position) {

        View itemView = mLayoutInflater.inflate(R.layout.howit_work_row, collection, false);

        final RelativeLayout backrelative = (RelativeLayout) itemView.findViewById(R.id.backrelative);
        final TextView txtheading = (TextView) itemView.findViewById(R.id.txtheader);
        final TextView txtdesc = (TextView) itemView.findViewById(R.id.txtdesc);


        try {

           // backrelative.setBackgroundColor(Color.parseColor("#ffffff"));
            // txtclorName.setText("" + StrcolrName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (position == 0) {
            txtheading.setText("Select Language");
            txtdesc.setText("With the SAP 3D Visual Enterprise Viewer mobile app for Android, you can increase uptime of mission critical products and assets, improve productivity and utilization of your resources anywhere and anytime");
        }
        if (position == 1) {
txtheading.setText("Search Product");
            txtdesc.setText("This app allows assembly and maintenance personnel to view, zoom, pan, and rotate interactive 3D data, play step-by-step animations, and view content created with the SAP 3D Visual Enterprise suite of products right from their Android device.");
        }
        if (position == 2) {
            txtheading.setText("Description of product");
            txtdesc.setText("This app allows assembly and maintenance personnel to view, zoom, pan, and rotate interactive 3D data, play step-by-step animations, and view content created with the SAP 3D Visual Enterprise suite of products right from their Android device.");

        }
        if(position==3){
            txtheading.setText("3D view of product");
            txtdesc.setText("This app allows assembly and maintenance personnel to view, zoom, pan, and rotate interactive 3D data, play step-by-step animations, and view content created with the SAP 3D Visual Enterprise suite of products right from their Android device.");
        }

        //view.setBackgroundResource(array.[position]);

        collection.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(View arg0, int arg1, Object arg2) {
        ((ViewPager) arg0).removeView((View) arg2);
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == ((View) arg1);
    }

    @Override
    public Parcelable saveState() {
        return null;
    }
}
