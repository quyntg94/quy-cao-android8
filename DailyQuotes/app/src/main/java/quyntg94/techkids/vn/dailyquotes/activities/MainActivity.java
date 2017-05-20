package quyntg94.techkids.vn.dailyquotes.activities;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import quyntg94.techkids.vn.dailyquotes.R;
import quyntg94.techkids.vn.dailyquotes.fragments.QuotesFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        changeFragment(new QuotesFragment(), false);
    }

    public void changeFragment(Fragment fragment, boolean addToBackStack){
        if ((addToBackStack)) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, fragment).addToBackStack(null).commit();

        } else {
            getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, fragment).commit();

        }
    }
}
