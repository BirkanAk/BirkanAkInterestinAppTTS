package com.example.birkanakinterestinapptts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Button TTSButton;
    EditText TTSText;

    TextToSpeech TTSAgent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TTSText=(EditText)findViewById(R.id.TTSText);
        TTSButton=(Button)findViewById(R.id.TTSButton);

        TTSAgent=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    TTSAgent.setLanguage(Locale.US);
                }
            }
        });

    }

    public void onTTSClick(View view) {
        String text = TTSText.getText().toString();
        Toast.makeText(getApplicationContext(), text,Toast.LENGTH_SHORT).show();
        TTSAgent.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }
}