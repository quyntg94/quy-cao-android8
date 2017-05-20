package quyntg94.techkids.vn.shortstory.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import quyntg94.techkids.vn.shortstory.R;
import quyntg94.techkids.vn.shortstory.StoryApplication;
import quyntg94.techkids.vn.shortstory.adapters.ChapterAdapter;
import quyntg94.techkids.vn.shortstory.models.Story;

/**
 * A simple {@link Fragment} subclass.
 */
public class StoryDetailFragment extends Fragment {

    private ViewPager vpChapter;
    private ChapterAdapter chapterAdapter;
    private Story story;

    public StoryDetailFragment() {
        // Required empty public constructor
    }

    public StoryDetailFragment setStory(Story story) {
        this.story = story;
        return this;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_story_detail, container, false);
        vpChapter = (ViewPager) view.findViewById(R.id.vp_chapter);

        setupUI();
        return view;
    }



    private void setupUI() {
        chapterAdapter = new ChapterAdapter(this.getFragmentManager());
        chapterAdapter.setStory(this.story);
        vpChapter.setAdapter(chapterAdapter);
        if(story.getLastChapterNo() != -1){
            vpChapter.setCurrentItem(story.getLastChapterNo());
        }
        vpChapter.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                StoryApplication.getInstance().getStoryDatabases().updateLastChapter(story, position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

}
