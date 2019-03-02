package org.pursuit.dailyhoroscope;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayHoroscope extends AppCompatActivity {
    private TextView displaysign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_horoscope);
        displaysign = findViewById(R.id.sign_name);
        Intent intent = getIntent();
        String text = intent.getStringExtra(MainActivity.INTENT_KEY);
        displaysign.setText(text);

    }
}
