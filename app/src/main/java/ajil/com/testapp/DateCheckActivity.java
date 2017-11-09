package ajil.com.testapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

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

//            if (date.compareTo(date1) == 0) {
//                Toast.makeText(this, "Matches", Toast.LENGTH_SHORT).show();
//            } else {
//                Toast.makeText(this, "Not matches", Toast.LENGTH_SHORT).show();
//            }


            Calendar c = Calendar.getInstance();
            c.setTime(date1);
            c.add(Calendar.DATE, 1);
            date1 = c.getTime();

            String x = String.valueOf(getDateDiff(date1, date, TimeUnit.DAYS));
            Toast.makeText(this, "" + x, Toast.LENGTH_SHORT).show();

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
        long diffInMillies = date2.getTime() - date1.getTime();
        return timeUnit.convert(diffInMillies,TimeUnit.MILLISECONDS);
    }
}
