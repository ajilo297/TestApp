package ajil.com.testapp.spinner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import ajil.com.testapp.R;

/**
 * Created by ajilo on 23-10-2017.
 */

public class CustomSpinnerAdapter extends BaseAdapter{
    private Context context;
    private ArrayList<DataModel> models;
    private DBHelper dbHelper;
    private OnDataChangedListener dataChangedListener;

    public CustomSpinnerAdapter(Context context, ArrayList<DataModel> models) {
        this.context = context;
        this.models = models;
        this.dbHelper = new DBHelper(context);
        dataChangedListener = (OnDataChangedListener) context;
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getDropDownView(final int position, View convertView, ViewGroup parent) {
//        return super.getDropDownView(position, convertView, parent);
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.spinner_detail_item, parent, false);
        ImageView imageView = v.findViewById(R.id.image);
        TextView textView = v.findViewById(R.id.text);
        imageView.setVisibility(View.VISIBLE);
        textView.setText(models.get(position).getName());
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.deleteModel(models.get(position));
                dataChangedListener.onChanged();
            }
        });
        return v;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.spinner_detail_item, viewGroup, false);
        ImageView imageView = v.findViewById(R.id.image);
        TextView textView = v.findViewById(R.id.text);
        imageView.setVisibility(View.GONE);
        textView.setText(models.get(i).getName());
        return v;
    }
}
