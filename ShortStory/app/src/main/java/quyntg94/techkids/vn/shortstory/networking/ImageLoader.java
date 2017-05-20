package quyntg94.techkids.vn.shortstory.networking;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import quyntg94.techkids.vn.shortstory.R;

/**
 * Created by quyntg94 on 14/05/2017.
 */

public class ImageLoader extends AsyncTask<String, Void, Bitmap> {
    private Bitmap image;

    private ImageView imageView;
    private String urlString;
    private String imageTag;

    public ImageLoader() {
    }

    public ImageLoader setImageView(ImageView imageView) {
        this.imageView = imageView;
        this.imageTag = (imageView.getTag() == null) ? "" : imageView.getTag().toString();
        return this;
    }

    public void loadImage(String urlString){
        if(!urlString.equals(imageTag)){
            this.imageView.setImageResource(R.drawable.progress_image);
            execute(urlString);
        }
    }

    @Override
    protected Bitmap doInBackground(String... params) {
        urlString = params[0];
        if (urlString.equals(imageTag)) {
            return null;
        }

        try {
            URL url = new URL(urlString);

            InputStream inputStream = url.openStream();

            image =  BitmapFactory.decodeStream(inputStream);
        } catch (IOException e) {
            image = null;
        }


        return image;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
            imageView.setTag(urlString);
        }
    }
}
