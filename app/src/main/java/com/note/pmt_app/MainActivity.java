package com.note.pmt_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {

    private CardView cardwelcome,cardmain,card_Result;
    private EditText txt_percen , txt_numOfyesar , txt_payment;
    private TextView txt_result;
    private Button btn_calucate;
    private PMT pmt;

    private AdView adView1,adView2,adView3,adView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardwelcome = findViewById(R.id.cardwelcome);
        cardmain = findViewById(R.id.card_main);
        card_Result = findViewById(R.id.card_Result);



        //adview
        adView1 = findViewById(R.id.adView1);
        adView2 =findViewById(R.id.adView2);
        adView3 =findViewById(R.id.adView3);
        adView4 =findViewById(R.id.adView4);


        cardwelcome.setBackgroundResource(R.drawable.cardwelcome1);
        cardmain.setBackgroundResource(R.drawable.carddesigncolor1);
        card_Result.setBackgroundResource(R.drawable.cardresult1);


        //Admob setting
        MobileAds.initialize(getApplicationContext(),"ca-app-pub-7633958771517626~1076276430");

        Location location = new Location("AdMobProvider");
        location.setLatitude(13.543296);
        location.setLatitude(100.924562);

        AdRequest.Builder adBuilder = new AdRequest.Builder();
        adBuilder.setLocation(location);

        AdRequest adRequest = adBuilder.build();

        adView1.loadAd(adRequest);
        adView2.loadAd(adRequest);
        adView3.loadAd(adRequest);
        adView4.loadAd(adRequest);


        //admob Event
        adView1.setAdListener(new AdListener()
        {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }

            @Override
            public void onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }

        });

        adView2.setAdListener(new AdListener()
        {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }

            @Override
            public void onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }
        });

        adView3.setAdListener(new AdListener()
        {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }

            @Override
            public void onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }
        });

        adView4.setAdListener(new AdListener()
        {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }

            @Override
            public void onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }
        });


        pmt = new PMT();
        // varible get input
        txt_percen = findViewById(R.id.txtpersen);
        txt_numOfyesar = findViewById(R.id.txt_num_of_yesar);
        txt_payment = findViewById(R.id.txt_payment);

        //varible output
        txt_result = findViewById(R.id.txt_Result);

        //Button Calucate
        btn_calucate = findViewById(R.id.btn_calucat);

        // set Event on Click
        btn_calucate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // save input

                try {

                    Calulat();
                }
                catch (Exception ex)
                {
                    Toast.makeText(getApplicationContext(),"โปรดกรอกข้อมูล",Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    private void Calulat()
    {
        int payment , num_of_yesar;
        double persen;


        persen = Double.parseDouble(txt_percen.getText().toString());
        num_of_yesar = Integer.parseInt(txt_numOfyesar.getText().toString());
        payment = Integer.parseInt(txt_payment.getText().toString());

        pmt.setAnnuallnterestRate(persen);
        pmt.setNumnerOfYesars(num_of_yesar);
        pmt.setLoanAmount(payment);

        // getmp =pmt.getMonthlyPayment();
        //  long mp = (new Double(getmp).longValue());
        String monthlyPayment = String.format("%.2f",pmt.getMonthlyPayment());

        // gettp =  pmt.getTotalPayment();
        // long tp = (new Double(gettp).longValue());
        String TotalPayment = String.format("%.2f",pmt.getTotalPayment());

        String data = "เงินแต่ละงวด :" + monthlyPayment+"\n\n" + "จำนวนจำเงินทั่งหมดที่จ่าย :" + TotalPayment+"\n"+"ระยะเวลา: "+ pmt.getNper()+" ครั่ง";

        txt_result.setText(data);
        Toast.makeText(getApplicationContext(),"คำนวณแล้ว โปรดเลื่อนลงด้านล่าง",Toast.LENGTH_LONG).show();

        persen = 0.0;
        num_of_yesar = 0;
        payment = 0;

    }


}

