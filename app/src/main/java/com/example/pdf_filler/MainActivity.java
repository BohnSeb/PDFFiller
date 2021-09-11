package com.example.pdf_filler;

import androidx.appcompat.app.AppCompatActivity;

//import android.graphics.pdf.PdfDocument;
import android.app.Activity;
import android.app.DownloadManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.itextpdf.forms.PdfAcroForm;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {
    EditText et;
    private File m_workingFile;



    public MainActivity() throws IOException {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = (EditText) findViewById(R.id.editText);
        et.setText("Billy is Kacke");

        String l_assetName = "DD.pdf";

        DndPdf l_dndPdf = new DndPdf(getApplicationContext());
        l_dndPdf.setCharacterName("Testie, der Testende, der unfassbare, der unbeschreibliche Testinger");
        l_dndPdf.setStr(17);
        l_dndPdf.setDex(9);
        l_dndPdf.setCon(13);
        l_dndPdf.setInt(7);
        l_dndPdf.setWis(15);
        l_dndPdf.setCha(18);
        String[] classlevels = new String[2];
        classlevels[0] = "Bladesinger Wizard 6";
        classlevels[1] = "Monk 1";

        l_dndPdf.setClassLevel(classlevels);

        l_dndPdf.setSTStrength(9,true);
        m_workingFile = l_dndPdf.saveFile();


        if (m_workingFile.exists()){
            System.out.println("Copied File, containing: " + m_workingFile.length() + " bytes");

            System.out.println("Downloading File");
            Intent intent = new Intent(Intent.ACTION_CREATE_DOCUMENT);
            intent.addCategory(Intent.CATEGORY_OPENABLE);
            intent.setType("application/pdf");
            intent.putExtra(Intent.EXTRA_TITLE, "output.pdf");
            startActivityForResult(intent, DndPdf.NEW_FILE_REQUEST_CODE);
        }

        //set Button onClick listener
        final Button btn = findViewById(R.id.btnFill);
        btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                //md.getForm().getFields().getFormField("CharacterName").setValue(et.getText().toString());
                String dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString() + File.separator + et.getText().toString() + ".pdf";
                //md.draw(dir);
                Toast.makeText(getApplicationContext(), "Saved File in Downloads Folder", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void savePdf(String filename){
        Intent l_intent = new Intent(Intent.ACTION_CREATE_DOCUMENT);
        l_intent.addCategory(Intent.CATEGORY_OPENABLE);
        l_intent.setType("application/pdf");
        l_intent.putExtra(Intent.EXTRA_TITLE, filename+".pdf");
        l_intent.putExtra(DocumentsContract.EXTRA_INITIAL_URI , Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS));
        startActivityForResult(l_intent, DndPdf.NEW_FILE_REQUEST_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == DndPdf.NEW_FILE_REQUEST_CODE && resultCode == Activity.RESULT_OK) ;
        {
            Uri l_uri = data.getData();
            try {
                OutputStream output = getApplicationContext().getContentResolver().openOutputStream(l_uri);
                FileInputStream l_inputFile = new FileInputStream(m_workingFile);
                int size = l_inputFile.available();
                byte[] buffer = new byte[size];
                l_inputFile.read(buffer);
                l_inputFile.close();
                output.write(buffer);
            } catch (FileNotFoundException e) {
                System.err.println(e.getMessage());
                e.printStackTrace();
            } catch (IOException e) {
                System.err.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }
}