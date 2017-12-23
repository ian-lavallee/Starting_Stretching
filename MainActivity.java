package com.mark.v.starting_stretchingv2;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    ArrayList<stretch> stretches = new ArrayList();
    int pos=0;
    long t = 10000,numleft;
    boolean btnskip = true, btnstart = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageView img = (ImageView) (findViewById(R.id.img));
        final TextView desc = (TextView) (findViewById(R.id.text_description));
        final TextView title = (TextView) (findViewById(R.id.text_title));
        final TextView time = (TextView) (findViewById(R.id.text_time));
        final Button btnright = (Button) (findViewById(R.id.btnright));
        final Button btnleft = (Button) (findViewById(R.id.btnleft));
        title.setText(getString(R.string.shoulder_extension));
        img.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.se, null));
        desc.setText(getString(R.string.SEdescription));

        final CountDownTimer count = new CountDownTimer(t,1) {
            @Override
            public void onTick(long l) {
                time.setText(""+
                        TimeUnit.MILLISECONDS.toSeconds(l));
                if(l==0){
                    time.setText("0:00");
                }
                numleft=l;
            }

            @Override
            public void onFinish() {
                btnright.setText("Next");
                btnright.setEnabled(true);
                btnleft.setEnabled(true);
                btnleft.setText("Redo");
                btnstart = false;
                btnskip = false;
            }
        };


        btnright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btnstart){
                    count.start();
                    btnleft.setEnabled(false);
                    btnright.setEnabled(false);
                }
                else{
                    pos++;
                    desc.setText(stretches.get(pos).getDescription());
                    img.setImageDrawable(stretches.get(pos).getImage());
                    title.setText(stretches.get(pos).getName());
                    time.setText(""+ t);
                    btnright.setText("Start");
                    btnleft.setText("Skip");
                    btnstart=true;
                }
            }
        });

        btnleft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btnskip){
                    pos++;
                    desc.setText(stretches.get(pos).getDescription());
                //    img.setImageDrawable(stretches.get(pos).getImage());
                    title.setText(stretches.get(pos).getName());
                }

                else{
                    desc.setText(stretches.get(pos).getDescription());
                    //    img.setImageDrawable(stretches.get(pos).getImage());
                    title.setText(stretches.get(pos).getName());
                    count.start();
                    btnright.setEnabled(false);
                    btnleft.setEnabled(false);
                }
            }
        });
        stretches.add(new stretch(this, ResourcesCompat.getDrawable(getResources(), R.drawable.se, null),
                true, getString(R.string.SEdescription), getString(R.string.shoulder_extension)));
        stretches.add(new stretch(this, ResourcesCompat.getDrawable(getResources(), R.drawable.uss, null),
                true, getString(R.string.USSdescription), getString(R.string.underarm_shoulder_stretch)));
        stretches.add(new stretch(this, ResourcesCompat.getDrawable(getResources(), R.drawable.rhc, null),
                true, getString(R.string.RHCdescription), getString(R.string.rear_hand_clasp)));
        stretches.add(new stretch(this, ResourcesCompat.getDrawable(getResources(), R.drawable.fs, null),
                true, getString(R.string.FSdescription), getString(R.string.full_squat)));
        stretches.add(new stretch(this, ResourcesCompat.getDrawable(getResources(), R.drawable.sp, null),
                true, getString(R.string.SPdescription), getString(R.string.standing_pike)));
        stretches.add(new stretch(this, ResourcesCompat.getDrawable(getResources(), R.drawable.kl, null),
                true, getString(R.string.KLdescription), getString(R.string.kneeling_lunge)));
        stretches.add(new stretch(this, ResourcesCompat.getDrawable(getResources(), R.drawable.bf, null),
                true, getString(R.string.BFdescription), getString(R.string.butterfly)));
        stretches.add(new stretch(this, ResourcesCompat.getDrawable(getResources(), R.drawable.bb, null),
                true, getString(R.string.BBdescription), getString(R.string.backbend_bridging)));
        stretches.add(new stretch(this, ResourcesCompat.getDrawable(getResources(), R.drawable.lt, null),
                true, getString(R.string.LTdescription), getString(R.string.lying_twist)));

    }

}
