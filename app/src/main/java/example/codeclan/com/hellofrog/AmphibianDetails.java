package example.codeclan.com.hellofrog;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class AmphibianDetails extends AppCompatActivity {
    TextView mNameText;
    TextView mSpeciesText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        mNameText = (TextView) findViewById(R.id.text_name);
        mSpeciesText = (TextView)findViewById(R.id.text_species);

        ImageView gif = (ImageView) findViewById(R.id.hypno_toad_gif);
        Glide.with(this).load("http://i.imgur.com/wyYOP.gif").into(gif);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String name = extras.getString("name");
        String species = extras.getString("species");

        mNameText.setText(name + " the " + species + " is now a F-R-E-E frog.");
//        mSpeciesText.setText("the " + species);
    }

}
