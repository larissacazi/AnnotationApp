package zimmermann.larissa.annotationapp;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private static final String ANNOTATION_FILE = "annotation.txt";
    private EditText annotationText;
    private ImageView saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        annotationText = (EditText)findViewById(R.id.textID);
        saveButton = (ImageView)findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String annotation = annotationText.getText().toString();

                saveOnFile(annotation);

                Toast.makeText(MainActivity.this, "Anotação salva com sucesso.", Toast.LENGTH_LONG).show();
            }
        });

        String annotationRecover = "";
        if((annotationRecover = readFile()) != null) {
            annotationText.setText(annotationRecover);
        }
    }

    private void saveOnFile(String annotation) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput(ANNOTATION_FILE, Context.MODE_PRIVATE));
            outputStreamWriter.write(annotation);
            outputStreamWriter.close();
        }
        catch (IOException e) {
            Log.v(TAG, e.toString());
        }
    }

    private String readFile() {
        String annotation = "";

        try {
            InputStream inputStream = openFileInput(ANNOTATION_FILE);
            if(inputStream != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                String line = "";
                while ( (line = bufferedReader.readLine()) != null ) {
                    annotation += line + "\n";
                }
            }
        }
        catch (IOException e) {
            Log.v(TAG, e.toString());
        }

        return annotation;
    }
}
