package com.class5.ncert.cbsc.book;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;

import java.io.File;

public class PdfViewer extends AppCompatActivity {
    PDFView pdfView;
    String filePath;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_viewer);

        pdfView = findViewById(R.id.pdfview);
        filePath = getIntent().getStringExtra("path");
//        filePath="/storage/emulated/0/Download/Ganit+Prabha+Class+VI(1).pdf";
        File file = new File(filePath);
        Uri path = Uri.fromFile(file);
        pdfView.fromUri(path)
                .defaultPage(0)
                .enableAnnotationRendering(true)
                .scrollHandle(new DefaultScrollHandle(getApplicationContext()))
                .load();
    }
}