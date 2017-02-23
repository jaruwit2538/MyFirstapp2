package comsci.khowoat.myfirstapp;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Constructor;

/**
 * Created by Khowoatt on 23/2/2560.
 */
//Activity นี้สร้างเพื่อทำ layout เสมือนเพื่อนำไปแสดงผลบนหน้า mainActivity

public class MyAdapter extends BaseAdapter{
    //Explicit
    private Context context;
    private int[] ints;
    private String[] titleStrings,detailStrings;
    //กด Alt+Insert เพื่อใช้ implement Constuctor
    public MyAdapter(Context context, int[] ints, String[] titleStrings, String[] detailStrings) {
        this.context = context;
        this.ints = ints;
        this.titleStrings = titleStrings;
        this.detailStrings = detailStrings;
    }

    @Override
    public int getCount() {//Method นี้ใช้นับจำนวนข้อมูลแล้วส่งต่อไป Getview
        return ints.length;
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
    public View getView(int position, View View, ViewGroup parent) {//นับจำนวนข้อมูลแล้วแสดงผลบนหน้า App

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view =layoutInflater.inflate(R.layout.my_listview,parent,false);

        //Initiol view ผูกไอดีของ view กับตัวแปร
        ImageView imgview = (ImageView) view.findViewById(R.id.imvicon);
        TextView titleTextView = (TextView) view.findViewById(R.id.txtTitleLiv);
        TextView detailTextView = (TextView) view.findViewById(R.id.txtDetailLiv);

        //showview เอาข้อมูลไปแสดงผลบนหน้า App
        imgview.setImageResource(ints[position]);
        titleTextView.setText(titleStrings[position]);
        detailTextView.setText(detailStrings[position]);
        return view;

    }
}   //Main class
