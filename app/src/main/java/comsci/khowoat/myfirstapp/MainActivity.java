package comsci.khowoat.myfirstapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    //Explicit
    ListView listView;
    private int[] ints = new int[]{R.drawable.traffic_01, R.drawable.traffic_02, R.drawable.traffic_03,
            R.drawable.traffic_04, R.drawable.traffic_05, R.drawable.traffic_06, R.drawable.traffic_07,
            R.drawable.traffic_08, R.drawable.traffic_09, R.drawable.traffic_10, R.drawable.traffic_11,
            R.drawable.traffic_12, R.drawable.traffic_13, R.drawable.traffic_14, R.drawable.traffic_15,
            R.drawable.traffic_16, R.drawable.traffic_17, R.drawable.traffic_18, R.drawable.traffic_19,
            R.drawable.traffic_20,};
    private String[] titleStrings, detailStrings,shortStrings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initiol view ผูกตัวแปรกับ id ของ view
        listView = (ListView) findViewById(R.id.livTraffic);

        //Get value
        titleStrings = getResources().getStringArray(R.array.title);
        detailStrings = getResources().getStringArray(R.array.detail);

        //subStrings detailStrings ตัดคำในส่วนของ detail เพื่อให้ข้อความไม่เกิน 30 ตัวอักษร
        shortStrings = new String[detailStrings.length];//จองพื้นที่ในหน่วยความจำในตัวแปร shortStrings
        for (int i=0;i<detailStrings.length;i++){//เริ่มนับตั้งแต่ตัวแรกถึงตัวที่30แล้วตัดคำ
            shortStrings[i]=detailStrings[i].substring(0,29)+"...";//นับถึง30ตัวแล้วโยนจาก detailStrings ไป shortStrings หลังข้อความจะแสดงว่า ...

        }//end for

        //create listview
        MyAdapter myAdapter = new MyAdapter(MainActivity.this, ints, titleStrings, shortStrings);//ตัวแปรที่ใช้ในหน้านี้
        listView.setAdapter(myAdapter);

        //active when click listview ลิ้งไปหน้า detail เมื่อคลิ้กเลือก item
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {//เมื่อมีการคลิ้ก้อมูลตำแหน่งใด จะเก็บตำแหน่งข้อมูลจากการคลิ้ก
                Intent intent = new Intent(MainActivity.this,Detail.class);//ประกาศเรียกใช้ object .this คืออ้างถึง activity ที่ใช้ปัจจุบัน ส่งข้อมูลจากหน้า main ไปหน้า detail
                intent.putExtra("Title", titleStrings[position]);
                intent.putExtra("Detail",detailStrings[position]);
                intent.putExtra("Image",ints[position]);
                startActivity(intent);
            }
        });

    }   //Main Method onCreate

    public void onClickMoreinfo(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.dlt.go.th/th/dlt-knowledge/view.php?_did=111"));
        startActivity(intent);
    }//Main Method onClickMoreinfo

    public void onClickAboutMe(View view) {
        Intent intent = new Intent(MainActivity.this, AboutMe.class);
        startActivity(intent);
    }//Main Method onClickAboutMe



}//Main class


