package comsci.khowoat.myfirstapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class AboutMe extends AppCompatActivity {

        MediaPlayer mediaPlayer;
        int soundId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);

        //Toast onClick แสดงข้อความเมื่อคลิ้ก(แสดงชั่วคราว)
        final ImageView clickImageView = (ImageView) findViewById(R.id.imvAbout);



        clickImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Hello My Name Is Khowoat",Toast.LENGTH_SHORT).show();
                //show sound1 when click image เมื่อคลิ้กที่ภาพ

                soundId = R.raw.sound1;
                playsound(soundId);
            }
        });//สิ้นสุด Toast

        //Toast On LongClick แสดงข้อความเมืื่อคลิ้ก(4-5วินาที)
        ImageView longClickImageView = (ImageView) findViewById(R.id.imvAbout);



        longClickImageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(getApplicationContext(),"Thank Guy",Toast.LENGTH_LONG).show();
                soundId = R.raw.sound2;
                playsound(soundId);

                return true;
            }
        });
        //phone Onclick
        TextView phoneTextView = (TextView) findViewById(R.id.txtTel);
        phoneTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent phoneIntent = new Intent(Intent.ACTION_DIAL);
                phoneIntent.setData(Uri.parse("tel:0823371350"));
                startActivity(phoneIntent);
            }
        });


    }//main method

    private void playsound(int soundId) {

        mediaPlayer = MediaPlayer.create(getApplicationContext(),soundId);
        mediaPlayer.start();

    }


    public void onClickFace(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.facebook.com/jaruwit.boonma"));
        startActivity(intent);
    }

    public void clickBack(View view) {

        finish();
    }
}


