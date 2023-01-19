package com.aarafrao.salezmediaadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    LinearLayout item_cu, item_login, item_sm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initViews();

    }

    private void initViews() {
        item_cu = findViewById(R.id.item_onesignal);
        item_sm = findViewById(R.id.item_firebase);
        item_login = findViewById(R.id.item_login);

        item_sm.setOnClickListener(this);
        item_login.setOnClickListener(this);
        item_cu.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.item_firebase:
                startActivity(new Intent(this, WebActivity.class).putExtra("url", "https://console.firebase.google.com/u/0/"));

                break;

            case R.id.item_onesignal:
                startActivity(new Intent(this, WebActivity.class).putExtra("url", "https://dashboard.onesignal.com/apps"));
                break;

            case R.id.item_login:
                startActivity(new Intent(this, SetLinkActivity.class));
                break;
        }
    }
}