package com.aarafrao.salezmediaadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SetLinkActivity extends AppCompatActivity implements View.OnClickListener {

    private TextInputEditText edLoginLink, edUpdateLink, edInstagramLink, edInstagramUName, edYtChannel, edChannelLink, edWaNo, edWALink, edEmail;
    private MaterialButton btnUpdateDash, btnUpdateSocialMedia, btnUpdateContact;
    private DatabaseReference mDatabase;


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
        mDatabase = FirebaseDatabase.getInstance().getReference();
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
        mDatabase.child("Social").child("ChannelLink").setValue(edChannelLink.getText().toString());
        mDatabase.child("Social").child("ILink").setValue(edInstagramLink.getText().toString());
        mDatabase.child("Social").child("YtChannel").setValue(edYtChannel.getText().toString());
        mDatabase.child("Social").child("iUName").setValue(edInstagramUName.getText().toString());
        Toast.makeText(this, "Social Media Updated", Toast.LENGTH_SHORT).show();

        edYtChannel.setText("");
        edChannelLink.setText("");
        edInstagramLink.setText("");
        edInstagramUName.setText("");

    }

    private void updateDashBoard() {
        mDatabase.child("Dashboard").child("LoginLink").setValue(edLoginLink.getText().toString());
        mDatabase.child("Dashboard").child("UpdateLink").setValue(edUpdateLink.getText().toString());
        Toast.makeText(this, "Dashboard Updated", Toast.LENGTH_SHORT).show();

        edUpdateLink.setText("");
        edLoginLink.setText("");

    }

    private void updateContacts() {

        mDatabase.child("Contacts").child("WaLink").setValue(edWALink.getText().toString());
        mDatabase.child("Contacts").child("WaNo").setValue(edWaNo.getText().toString());
        mDatabase.child("Contacts").child("Email").setValue(edEmail.getText().toString());


        edWALink.setText("");
        edWaNo.setText("");
        edEmail.setText("");
        Toast.makeText(this, "Contacts Update", Toast.LENGTH_SHORT).show();
    }
}