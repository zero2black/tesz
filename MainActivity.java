package com.example.signalscanner;

import android.os.Bundle;
import android.telephony.CellInfo;
import android.telephony.TelephonyManager;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView signalStrengthView = findViewById(R.id.signalStrength);
        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);

        if (telephonyManager != null) {
            List<CellInfo> cellInfos = telephonyManager.getAllCellInfo(); // Requires API level 17 or higher
            if (cellInfos != null && !cellInfos.isEmpty()) {
                signalStrengthView.setText("Signal Info: " + cellInfos.get(0).toString());
            } else {
                signalStrengthView.setText("No Signal Info Available");
            }
        }
    }
}
