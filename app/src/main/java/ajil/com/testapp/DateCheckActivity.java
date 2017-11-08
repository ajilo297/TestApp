package ajil.com.testapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateCheckActivity extends AppCompatActivity {

    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_check);

        editText = findViewById(R.id.editText);
    }



    public void onClick(View view) {
        String dString = editText.getText().toString();
        String validDate = "2017-11-08";
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = format.parse(dString);
            Date date1 = format.parse(validDate);

            if (date.compareTo(date1) == 0) {
                Toast.makeText(this, "Matches", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Not matches", Toast.LENGTH_SHORT).show();
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
