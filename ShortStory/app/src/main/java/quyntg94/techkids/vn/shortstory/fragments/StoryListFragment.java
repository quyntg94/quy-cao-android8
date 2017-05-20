package quyntg94.techkids.vn.shortstory.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import quyntg94.techkids.vn.shortstory.R;
import quyntg94.techkids.vn.shortstory.StoryApplication;
import quyntg94.techkids.vn.shortstory.activites.MainActivity;
import quyntg94.techkids.vn.shortstory.adapters.StoryAdapter;
import quyntg94.techkids.vn.shortstory.databases.StoryDatabases;
import quyntg94.techkids.vn.shortstory.models.Story;

/**
 * A simple {@link Fragment} subclass.
 */
public class StoryListFragment extends Fragment {

    private ListView lvStoryList;
    private TextView tvStoryName;
    private TextView tvStoryDescription;
    private ImageView ivStoryImage;
    private List<Story> stories;
    private StoryAdapter storyAdapter;
    private ImageView ivFavorite;

    public StoryListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onStart() {
        super.onStart();
        loadData();
        setupUI();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_story_list, container, false);
        lvStoryList = (ListView) view.findViewById(R.id.lv_story_list);
        ivFavorite = (ImageView) view.findViewById(R.id.iv_favorite);
        return view;
    }

    private void setupUI() {
        storyAdapter = new StoryAdapter(stories);
        lvStoryList.setAdapter(storyAdapter);
//        ivStoryImage = (ImageView) findViewById(R.id.iv_story_image);
//        tvStoryDescription = (TextView) findViewById(R.id.tv_story_description);
//        tvStoryName = (TextView) findViewById(R.id.tv_story_name);
        lvStoryList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Story story = stories.get(position);

                ((MainActivity)getActivity()).changeFragment(new StoryDetailFragment().setStory(story), true);

            }
        });


    }

    private void loadData() {
        StoryDatabases storyDatabases = StoryApplication.getInstance().getStoryDatabases();
        stories = storyDatabases.loadAllStories();

    }


}
