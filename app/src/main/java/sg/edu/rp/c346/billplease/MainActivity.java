package sg.edu.rp.c346.billplease;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    TextView TVBill;
    EditText ETbill;
    TextView TVPAX;
    EditText ETPAX;
    TextView TVGST;
    ToggleButton TBGST;
    TextView TVSC;
    ToggleButton TBSC;
    Button BTCAL;
    Button BTRESET;
    TextView TVTOTAL;
    TextView TVPAY;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TVBill = findViewById(R.id.TVBill);
        ETbill = findViewById(R.id.ETbill);
        TVPAX = findViewById(R.id.TVPAX);
        ETPAX = findViewById(R.id.ETPAX);
        TVGST = findViewById(R.id.TVGST);
        TBGST = findViewById(R.id.TBGST);
        TVSC = findViewById(R.id.TVSC);
        TBSC = findViewById(R.id.TBSC);
        BTCAL = findViewById(R.id.BTCAL);
        BTRESET = findViewById(R.id.BTRESET);
        TVTOTAL = findViewById(R.id.TVTOTAL);
        TVPAY = findViewById(R.id.TVPAY);

        BTRESET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TVTOTAL.setText(" ");
                TVPAY.setText(" ");
            }
        });


        BTCAL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double TOTAL = Double.parseDouble(ETbill.getText().toString());
                int pax = Integer.parseInt(ETPAX.getText().toString());



                if (TBGST.isChecked()){
                    TOTAL = TOTAL * 1.10;
                }
                if (TBSC.isChecked()){
                    TOTAL = TOTAL * 1.07;
                }
                double payable = TOTAL/pax;
                TVTOTAL.setText("Total bill is $" +TOTAL);
                TVPAY.setText("Each pax pay $" + payable);


                }
        });


    }
}
