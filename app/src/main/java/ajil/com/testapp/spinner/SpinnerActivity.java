package ajil.com.testapp.spinner;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

import java.util.ArrayList;

import ajil.com.testapp.R;

public class SpinnerActivity extends AppCompatActivity implements OnDataChangedListener {

    private DBHelper dbHelper;
    private CustomSpinnerAdapter adapter;
    private ArrayList<DataModel> models;
    private Context context;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        spinner = findViewById(R.id.spinner);
        context = SpinnerActivity.this;
        dbHelper = new DBHelper(context);

        models = dbHelper.getAllData();

        adapter = new CustomSpinnerAdapter(context, models);
        spinner.setAdapter(adapter);
    }

    private ArrayList<String> getDataArray() {
        ArrayList<String> arrayList = new ArrayList<>();
        CharSequence[] list = getResources().getStringArray(R.array.dataArray);
        for (CharSequence i : list) {
            arrayList.add(i.toString());
        }
        return arrayList;
    }

    public void addData(View view) {
        dbHelper.addData();
        onChanged();
    }

    @Override
    public void onChanged() {
        models = dbHelper.getAllData();
        if (models.size() == 0) {
            adapter = new CustomSpinnerAdapter(context, new ArrayList<DataModel>());
        }else {
            adapter = new CustomSpinnerAdapter(context, models);
        }
        spinner.setAdapter(adapter);
    }
}
