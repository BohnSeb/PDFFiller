package com.example.pdf_filler;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FileSelectActivity extends Activity {

    private TextView m_text;

    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_fileselect);

        //find textview and initialize it
        m_text = (TextView) findViewById(R.id.textView);

        //get intent
        Intent intent = getIntent();
        String action = intent.getAction();
        String type = intent.getType();

        m_text.setText("Received File, Type: " + type);

        if (Intent.ACTION_SEND.equals(action) && type != null){
            if ("application/octet-stream".equals(type)){
                handleSendCah(intent);
            }
        }
    }

    private void handleSendCah(Intent intent) {
        Uri l_cahUri = intent.getParcelableExtra(Intent.EXTRA_STREAM);
        if (l_cahUri != null){
            m_text.setText(l_cahUri.getPath());
            try {
                InputStream l_inputStream = getContentResolver().openInputStream(l_cahUri);
                byte[] buffer = new byte[l_inputStream.available()];
                l_inputStream.read(buffer);
                JSONTokener l_tokener = new JSONTokener(buffer.toString());
                JSONObject l_cahJSON = new JSONObject(l_tokener);
                m_text.setText(l_cahJSON.toString());

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
