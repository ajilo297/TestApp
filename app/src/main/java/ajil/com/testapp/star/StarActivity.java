package ajil.com.testapp.star;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

import ajil.com.testapp.R;

public class StarActivity extends AppCompatActivity {

    private ImageView image1, image2, image3, image4, image5;
    private Context context;
    private int i = 1;
    private long duration = 800;
    private Handler animHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star);

        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);
        image4 = findViewById(R.id.image4);
        image5 = findViewById(R.id.image5);

        context = StarActivity.this;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                setupView(); // This method will initialize all IVs
                // and add the vector drawable as bitmap
                animHandler = new Handler();
                startAnim();
            }
        }, 200);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                endAnimation();
            }
        }, 5000);
    }

    private void endAnimation() {
        animHandler.removeCallbacks(runnable);
    }


    private void setupView() {
        setVectorDrawable(image1, ContextCompat.getDrawable(context,R.drawable.star1));
        setVectorDrawable(image2, ContextCompat.getDrawable(context,R.drawable.star2));
        setVectorDrawable(image3, ContextCompat.getDrawable(context,R.drawable.star3));
        setVectorDrawable(image4, ContextCompat.getDrawable(context,R.drawable.star4));
        setVectorDrawable(image5, ContextCompat.getDrawable(context,R.drawable.star5));
    }

    private void setVectorDrawable(ImageView imageView, Drawable drawable) {
        Bitmap bitmap = Bitmap.createBitmap(imageView.getWidth(),
                imageView.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);

        imageView.setImageBitmap(bitmap);
    }

    private void startAnim() {
        runnable.run();
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            switch (i) {
                case 1:
                    animateStarIn(image1);
                    break;
                case 2:
                    animateStarIn(image2);
                    break;

                case 3:
                    animateStarIn(image3);
                    break;
                case 4:
                    animateStarIn(image4);
                    break;

                case 5:
                    animateStarIn(image5);
                    break;
                case 6:
                    animateStartOut(image1);
                    break;

                case 7:
                    animateStartOut(image2);
                    break;
                case 8:
                    animateStartOut(image3);
                    break;

                case 9:
                    animateStartOut(image4);
                    break;
                case 10:
                    animateStartOut(image5);
                    break;
            }
            i++;
            if (i == 11) i = 1;
            animHandler.postDelayed(runnable, duration);
        }
    };

    private void animateStarIn(ImageView imageView) {
        imageView.animate().alpha(1).setDuration(duration).setInterpolator(new AccelerateInterpolator());
    }
    private void animateStartOut (ImageView imageView) {
        imageView.animate().alpha(0).setDuration(duration).setInterpolator(new DecelerateInterpolator());
    }
}
