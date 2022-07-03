package com.example.pdf_filler;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import com.example.pdf_filler.DnD5eCharacter.Abilities.Abilityscores;
import com.example.pdf_filler.DnD5eCharacter.Abilities.Skills.Skill_names;
import com.example.pdf_filler.DnD5eCharacter.DnD5eCharacter;
import com.example.pdf_filler.parser.CAHParser;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

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
                String content = new String(buffer, StandardCharsets.UTF_8);
                JSONObject cah = new JSONObject(content);
                m_text.setText(cah.toString());
                //parse JSONObject to Character Model
                CAHParser parser = new CAHParser();
                DnD5eCharacter character = parser.parse(cah);
                StringBuilder sb = new StringBuilder();
                sb.append(character.toString());
                sb.append("\n");
                sb.append(character.getAbilities().getAbilityScores().getAbilityScore(Abilityscores.STRRENGTH.toString()).getScore());
                sb.append("(str-score)\n");
                sb.append(character.getAbilities().getSkills().getSkill(Skill_names.DECEPTION.toString()).getMod());
                sb.append("(deception mod)\n");
                m_text.setText(sb.toString());

            } catch (Exception e) {
                m_text.setText("Error: " + e.getMessage());
            }
        }
    }
}
