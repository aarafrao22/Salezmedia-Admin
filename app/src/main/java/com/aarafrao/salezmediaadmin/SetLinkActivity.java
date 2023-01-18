package com.aarafrao.salezmediaadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class SetLinkActivity extends AppCompatActivity implements View.OnClickListener {

    private TextInputEditText edLoginLink, edUpdateLink, edInstagramLink, edInstagramUName, edYtChannel, edChannelLink, edWaNo, edWALink, edEmail;
    private MaterialButton btnUpdateDash, btnUpdateSocialMedia, btnUpdateContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_link);

        initViews();
        clickListeners();

    }

    private void clickListeners() {
        btnUpdateContact.setOnClickListener(this);
        btnUpdateDash.setOnClickListener(this);
        btnUpdateSocialMedia.setOnClickListener(this);
    }

    private void initViews() {
        btnUpdateContact = findViewById(R.id.btnUpdateContact);
        btnUpdateDash = findViewById(R.id.btnUpdateDash);
        btnUpdateSocialMedia = findViewById(R.id.btnUpdateSocial);

        edLoginLink = findViewById(R.id.edLoginLink);
        edUpdateLink = findViewById(R.id.edUpdateLink);
        edInstagramLink = findViewById(R.id.edInstaLink);
        edInstagramUName = findViewById(R.id.edInstaUName);
        edYtChannel = findViewById(R.id.edYtChannel);
        edChannelLink = findViewById(R.id.edYtChannelLink);
        edWaNo = findViewById(R.id.edWANo);
        edWALink = findViewById(R.id.edWALink);
        edEmail = findViewById(R.id.edEmail);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnUpdateContact:
                updateContacts();
                break;
            case R.id.btnUpdateDash:
                updateDashBoard();
                break;
            case R.id.btnUpdateSocial:
                updateSocialMedia();
                break;

        }
    }

    private void updateSocialMedia() {
        Toast.makeText(this, "Social Media Updated", Toast.LENGTH_SHORT).show();
    }

    private void updateDashBoard() {
        Toast.makeText(this, "Dashboard Updated", Toast.LENGTH_SHORT).show();
    }

    private void updateContacts() {
        Toast.makeText(this, "Contacts Update", Toast.LENGTH_SHORT).show();
    }
}