package ajil.com.testapp;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.TransformationMethod;
import android.util.Log;
import android.view.ViewOverlay;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class LayoutScaleTestActivity extends AppCompatActivity {

    RelativeLayout testRel;
    TextView textView;
    float initialWidth, finalWidth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_scale_test);

        testRel = findViewById(R.id.testRel);
        textView = findViewById(R.id.test1);

        testRel.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                testRel.getViewTreeObserver().removeOnGlobalLayoutListener(this);

//                Log.e("TEst", "scale: " + testRel.getScaleX() + " x: " + testRel.getX()
//                        + "\nscale: " + textView.getScaleX() + " x: " + textView.getX()
//                        + "\nscale: " + ((RelativeLayout) textView.getParent()).getScaleX() + " x: " + ((RelativeLayout) textView.getParent()).getX());

                initialWidth = textView.getMeasuredWidth();

                Log.e("Test", "iWidth: " + initialWidth);

            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                testRel.setScaleX(1.8f);
                testRel.setScaleY(1.8f);

//                Log.e("TEst", "scale: " + testRel.getScaleX() + " x: " + testRel.getX()
//                        + "\nscale: " + textView.getScaleX() + " x: " + textView.getX()
//                        + "\nscale: " + ((RelativeLayout) textView.getParent()).getScaleX() + " x: " + ((RelativeLayout) textView.getParent()).getX());


                finalWidth = ((RelativeLayout) textView.getParent()).getScaleX();

                Log.e("Test", "fWidth: " + finalWidth);

            }
        }, 3000);
    }
}
