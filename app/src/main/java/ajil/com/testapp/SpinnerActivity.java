package ajil.com.testapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import java.util.ArrayList;

public class SpinnerActivity extends AppCompatActivity implements OnDataChangedListener, AdapterView.OnItemSelectedListener {

    private DBHelper dbHelper;
    private CustomSpinnerAdapter adapter;
    private ArrayList<DataModel> models;
    private Context context;
    private Spinner spinner;
    private Boolean animate = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        spinner = findViewById(R.id.spinner);
        context = SpinnerActivity.this;
        dbHelper = new DBHelper(context);

        models = dbHelper.getAllData();

        adapter = new CustomSpinnerAdapter(context, models, animate);
        spinner.setOnItemSelectedListener(this);
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
        animate = false;
        models = dbHelper.getAllData();
        if (models.size() == 0) {
            adapter = new CustomSpinnerAdapter(context, new ArrayList<DataModel>(), animate);
        }else {
            adapter = new CustomSpinnerAdapter(context, models, animate);
        }
        spinner.setAdapter(adapter);
    }

    @Override
    public void onRemovePressed() {
        animate = true;
        models = dbHelper.getAllData();
        if (models.size() == 0) {
            adapter = new CustomSpinnerAdapter(context, new ArrayList<DataModel>(), animate);
        }else {
            adapter = new CustomSpinnerAdapter(context, models, animate);
        }
        spinner.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        animate = false;

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        animate = false;

    }
}
