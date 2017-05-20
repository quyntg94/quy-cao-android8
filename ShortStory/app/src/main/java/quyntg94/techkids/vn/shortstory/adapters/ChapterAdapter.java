package quyntg94.techkids.vn.shortstory.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

import quyntg94.techkids.vn.shortstory.StoryApplication;
import quyntg94.techkids.vn.shortstory.databases.StoryDatabases;
import quyntg94.techkids.vn.shortstory.fragments.ChapterFragment;
import quyntg94.techkids.vn.shortstory.models.Story;

/**
 * Created by quyntg94 on 14/05/2017.
 */

public class ChapterAdapter extends FragmentStatePagerAdapter {

    private Story story;
    private List<Integer> chapterIds;
    private StoryDatabases storyDatabases;

    public ChapterAdapter(FragmentManager fm) {
        super(fm);
        storyDatabases = StoryApplication.getInstance().getStoryDatabases();
    }

    public ChapterAdapter setStory(Story story) {
        this.story = story;
        this.chapterIds =  storyDatabases.getChapterIds(story);
        return this;
    }

    @Override
    public Fragment getItem(int position) {
        int chapterId = this.chapterIds.get(position);
        ChapterFragment chapterFragment = new ChapterFragment();
        chapterFragment.setChapterId(chapterId);
        return chapterFragment;
    }

    @Override
    public int getCount() {
        return storyDatabases.getChapterCount(story);
    }
}
