package quyntg94.techkids.vn.shortstory.activites;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import quyntg94.techkids.vn.shortstory.R;
import quyntg94.techkids.vn.shortstory.fragments.StoryListFragment;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayStartScreen();

    }

    public void displayStartScreen() {
        StoryListFragment storyListFragment = new StoryListFragment();
        changeFragment(storyListFragment, false);
    }

    public void changeFragment(Fragment fragment, boolean addToBackStack) {
        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.fl_container, fragment);
        if (addToBackStack){
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
    }


}
