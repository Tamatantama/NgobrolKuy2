package com.responsi.ngobrolkuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class HomeChatActivity extends AppCompatActivity {
    LinearLayout llChat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_chat);
        llChat = findViewById(R.id.chatnum1);

        llChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login = new Intent(HomeChatActivity.this, ChatPersonalActivity.class);
                startActivity(login);
            }
        });
    }
}