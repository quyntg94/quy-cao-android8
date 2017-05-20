package quyntg94.techkids.vn.dailyquotes.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import quyntg94.techkids.vn.dailyquotes.R;
import quyntg94.techkids.vn.dailyquotes.activities.MainActivity;
import quyntg94.techkids.vn.dailyquotes.network.QuotesLoader;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuotesFragment extends Fragment {

    private static final String IMAGE_URL = "https://source.unsplash.com/random/600x800";

    private TextView tvQuotes;
    private ImageView ivBackground;

    public QuotesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quotes, container, false);
        getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        tvQuotes = (TextView) view.findViewById(R.id.tv_quotes);
        ivBackground = (ImageView) view.findViewById(R.id.iv_background);
        new QuotesLoader(tvQuotes).execute();
        Picasso.with(getContext()).load(IMAGE_URL).fit().into(ivBackground);

        return view;
    }



}
