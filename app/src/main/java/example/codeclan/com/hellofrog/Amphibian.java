package example.codeclan.com.hellofrog;

import android.os.Bundle;
import android.widget.ImageView;
import android.support.v7.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import static example.codeclan.com.hellofrog.R.layout.activity_main;

public class Amphibian extends AppCompatActivity {
    private String mName;

    public Amphibian(String name)
    {
        mName = name;
    }

    public String getName() {
        return mName;
    }

    public void setName(String nName) {
        mName = nName;
    }
}

