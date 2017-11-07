package ajil.com.testapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

public class EditTextImeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text_ime);

        EditText editText = findViewById(R.id.textView);

        editText.setImeOptions(EditorInfo.IME_ACTION_SEND);
        editText.setRawInputType(InputType.TYPE_CLASS_TEXT);
    }
}
