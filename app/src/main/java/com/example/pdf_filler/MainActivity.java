package com.example.pdf_filler;

import androidx.appcompat.app.AppCompatActivity;

//import android.graphics.pdf.PdfDocument;
import android.app.DownloadManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//import com.cete.dynamicpdf.merger.MergeDocument;
//import com.cete.dynamicpdf.merger.PdfDocument;

import com.itextpdf.forms.PdfAcroForm;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import static com.itextpdf.kernel.PdfException.PdfEncodings;

public class MainActivity extends AppCompatActivity {
    EditText et;
    //MergeDocument md;
    public static final String FONT = "./src/main/resources/font/FreeSans.ttf";
    //public final InputStream SRC = this.getAssets().open("DD.pdf");
    public final String DST = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString() + File.separator + "output.pdf";
    public final String SRC = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString() + File.separator + "UA_ModernMagic.pdf";


    public MainActivity() throws IOException {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = (EditText) findViewById(R.id.editText);
        et.setText("Billy is Kacke");
        //InputStream is = this.getAssets().open("DD.pdf");
        //long avail = is.available();
        //byte[] samplePDF = new byte[(int) avail];
        //is.read(samplePDF, 0, (int) avail);
        //is.close();
        //PdfDocument objPDF = new PdfDocument(samplePDF);
        //OutputStream output = null
        //md = new MergeDocument(objPDF);
        //CharacterNameField = document.getForm().getFields().getFormField("CharacterName");

        //open pdf file and prepare output
        try {
            PdfDocument pdfDoc = new PdfDocument(new PdfReader(SRC), new PdfWriter(DST));
            pdfDoc.close();

        } catch (Exception e){
            e.printStackTrace();
            System.err.println(e.getMessage());
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
}