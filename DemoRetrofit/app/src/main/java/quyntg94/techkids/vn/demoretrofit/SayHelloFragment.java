package quyntg94.techkids.vn.demoretrofit;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SayHelloFragment extends Fragment {

    private TextView tvSayHello;

    public SayHelloFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_say_hello, container, false);
        tvSayHello = (TextView) view.findViewById(R.id.tv_sayhello);
        tvSayHello.setText("Hello " + SharedPreferences.getInstance().getUsername());
        return view;
    }

}
