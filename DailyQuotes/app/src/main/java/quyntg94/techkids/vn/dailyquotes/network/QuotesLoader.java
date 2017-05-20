package quyntg94.techkids.vn.dailyquotes.network;

import android.content.Context;
import android.os.AsyncTask;
import android.text.Html;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by quyntg94 on 16/05/2017.
 */

public class QuotesLoader extends AsyncTask<Void, Void, String> {

    private static final String QUOTES_URL = "http://quotesondesign.com/wp-json/posts?filter[orderby]=rand";
    private static final String IMAGE_URL = "https://source.unsplash.com/random/600x800";

    private Context context;
    private ImageView imageView;
    private TextView textView;
    private String quotes;

    public QuotesLoader(TextView textView) {
        this.textView = textView;
    }

    @Override
    protected String doInBackground(Void... params) {
        try {
            URL url = new URL(QUOTES_URL);

            InputStream inputStream = url.openStream();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            StringBuilder stringBuilder = new StringBuilder();

            String line = "";

            while ((line = bufferedReader.readLine()) != null){
                stringBuilder.append(line);
            }

            String content = stringBuilder.toString();

            Log.d("ahihi", content);

            try {
                JSONArray jsonArray = new JSONArray(content);
                JSONObject jsonObject = jsonArray.getJSONObject(0);
                Log.d("bhihi", jsonObject.toString());
                quotes = jsonObject.getString("content");
                return jsonObject.getString("content");

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }  catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        textView.setText(Html.fromHtml(quotes));
    }
}
