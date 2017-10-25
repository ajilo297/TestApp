package ajil.com.testapp.spinner;

import android.content.Context;
import android.support.v4.content.ContextCompat;
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
    private ArrayList<DataModel> models;
    private DBHelper dbHelper;
    private OnDataChangedListener dataChangedListener;
    private Context context;
    private Boolean animate;

    CustomSpinnerAdapter(Context context, ArrayList<DataModel> models, Boolean animate) {
        this.models = models;
        this.dbHelper = new DBHelper(context);
        dataChangedListener = (OnDataChangedListener) context;
        this.context = context;
        this.animate = animate;
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
        if (position == 0) {
            imageView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_remove_black_24dp));
            textView.setText(R.string.select_item);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dataChangedListener.onRemovePressed();
                }
            });
        } else {
            imageView.setAlpha(0f);
            if (animate) {
                imageView.animate().alpha(1f).setDuration(400);
                imageView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_delete_black_24dp));
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dbHelper.deleteModel(models.get(position - 1));
                        dataChangedListener.onChanged();
                    }
                });
            }
            textView.setText(models.get(position - 1).getName());

        }
        return v;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.spinner_detail_item, viewGroup, false);
        ImageView imageView = v.findViewById(R.id.image);
        TextView textView = v.findViewById(R.id.text);
        imageView.setVisibility(View.GONE);
        if (i == 0) {
            textView.setText(R.string.select_item);
        } else {
            textView.setText(models.get(i - 1).getName());
        }
        return v;
    }
}
