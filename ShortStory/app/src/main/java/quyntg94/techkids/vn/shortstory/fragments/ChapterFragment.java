package quyntg94.techkids.vn.shortstory.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import quyntg94.techkids.vn.shortstory.R;
import quyntg94.techkids.vn.shortstory.StoryApplication;
import quyntg94.techkids.vn.shortstory.databases.StoryDatabases;
import quyntg94.techkids.vn.shortstory.models.Chapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChapterFragment extends Fragment {

    private TextView tvTitle;
    private WebView wvContet;
    private int chapterId;
    private Chapter chapter;

    public ChapterFragment() {
        // Required empty public constructor
    }


    public ChapterFragment setChapterId(int chapterIds) {
        this.chapterId = chapterIds;
        return this;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chapter, container, false);
        getChapter();
        findReferences(view);
        setupUI();
        return view;
    }

    private void getChapter() {
        StoryDatabases storyDatabases = StoryApplication.getInstance().getStoryDatabases();
        chapter = storyDatabases.getChapter(chapterId);
    }

    private void setupUI() {
        tvTitle.setText(chapter.getTitle());
        wvContet.loadData(chapter.getContent(), "text/html; charset=utf8", "utf-8");
    }

    private void findReferences(View view) {
        tvTitle = (TextView) view.findViewById(R.id.tv_title);
        wvContet = (WebView) view.findViewById(R.id.wv_content);
    }

}
