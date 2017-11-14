package zimmermann.larissa.annotationapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private EditText annotationText;
    private ImageView saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        annotationText = (EditText)findViewById(R.id.textID);
        saveButton = (ImageView)findViewById(R.id.saveButton);
    }
}
