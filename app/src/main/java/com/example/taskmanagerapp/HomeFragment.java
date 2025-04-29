sssspackage com.example.taskmanagerapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import org.json.JSONArray;
import org.json.JSONObject;

public class HomeFragment extends Fragment {

    private TextView quoteTextView;
    private ImageView backgroundImageView;
    private static final String QUOTE_API = "https://zenquotes.io/api/random";
    //private static final String IMAGE_URL = "https://source.unsplash.com/1600x900/?nature,motivation";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        quoteTextView = view.findViewById(R.id.textViewQuote);
        //backgroundImageView = view.findViewById(R.id.imageViewBackground);


        //Glide.with(this).load(IMAGE_URL).into(backgroundImageView);

        loadQuote();

        return view;
    }

    private void loadQuote() {
        RequestQueue queue = Volley.newRequestQueue(requireContext());

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, QUOTE_API, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            JSONObject jsonObject = response.getJSONObject(0);
                            String quote = jsonObject.getString("q") + " - " + jsonObject.getString("a");
                            quoteTextView.setText(quote);
                        } catch (Exception e) {
                            quoteTextView.setText("Stay positive and keep going!");
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                quoteTextView.setText("Stay positive and keep going!");
            }
        });

        queue.add(jsonArrayRequest);
    }
}
