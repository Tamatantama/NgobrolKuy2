package com.responsi.ngobrolkuy;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfilePicActivity extends AppCompatActivity {
    ImageView ivButton, ivProfile;
    TextView tvNext;
    ActivityResultLauncher<String> arPicker;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_pic);


        ivButton = findViewById(R.id.buttonImage);
        ivProfile = findViewById(R.id.profilePic);
        tvNext = findViewById(R.id.buttonNext);

        arPicker = registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
            @Override
            public void onActivityResult(Uri result) {
                ivProfile.setImageURI(result);
            }
        });

        ivButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arPicker.launch("image/*");
            }
        });

        tvNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next = new Intent(ProfilePicActivity.this, LoginActivity.class);
                startActivity(next);
            }
        });



    }
}