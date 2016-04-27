package example.codeclan.com.hellofrog;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONObject;

/**
 * Created by sandy on 25/04/2016.
 */
public class HelloFrog extends AppCompatActivity {
    private static final String API_URL = "http://cc-amphibian-api.herokuapp.com/";

    EditText mNameEditText;
    EditText mSpeciesEditText;
    Button mSubmitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("HelloFrog:", "onCreate called");
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mNameEditText = (EditText) findViewById(R.id.name_input);
        mSpeciesEditText = (EditText) findViewById(R.id.species_input);
        mSubmitButton = (Button) findViewById(R.id.submit_button);

        ImageView gif = (ImageView) findViewById(R.id.fairy_tail_gif);
        Glide.with(this).load("http://33.media.tumblr.com/8cbda6d05134e0ff591e47e789881bf5/tumblr_inline_nubz5dDa1d1sebu2v_500.gif").into(gif);

        fetchAmphibians();

        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("HelloFrog:", "submit button clicked!");
                Intent intent = new Intent(HelloFrog.this, AmphibianDetails.class);
                intent.putExtra("name", mNameEditText.getText().toString());
                intent.putExtra("species", mSpeciesEditText.getText().toString());
                startActivity(intent);
            }
        });
    }

    private void fetchAmphibians() {
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(API_URL, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(JSONObject jsonObject) {
                Log.d("HelloFrog: ", jsonObject.toString());
            }
            @Override
            public void onFailure(int statusCode, Throwable throwable, JSONObject error) {
                Log.e("HelloFrog: ", "Failure: " + statusCode + " " + throwable.getMessage());
            }
        });
    }
}
