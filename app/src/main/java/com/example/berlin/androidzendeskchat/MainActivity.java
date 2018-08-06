package com.example.berlin.androidzendeskchat;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import zendesk.core.AnonymousIdentity;
import zendesk.core.Identity;
import zendesk.core.Zendesk;
import zendesk.support.Support;
import zendesk.support.guide.HelpCenterActivity;

public class MainActivity extends Activity {

    Button btn_help;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_help = findViewById(R.id.help_button);

        Zendesk.INSTANCE.init(this, "https://dsclonger.zendesk.com",
                "43f91088a66c4a5317346c7995c72decb270ed7489b3320d",
                "mobile_sdk_client_d6f0213c32b87327f3c0");
        Support.INSTANCE.init(Zendesk.INSTANCE);

        Identity identity = new AnonymousIdentity();
        Zendesk.INSTANCE.setIdentity(identity);

        Support.INSTANCE.init(Zendesk.INSTANCE);

        btn_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HelpCenterActivity.builder().show(MainActivity.this);

            }
        });


    }
}
