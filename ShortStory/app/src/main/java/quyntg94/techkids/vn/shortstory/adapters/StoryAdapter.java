package quyntg94.techkids.vn.shortstory.adapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import quyntg94.techkids.vn.shortstory.R;
import quyntg94.techkids.vn.shortstory.StoryApplication;
import quyntg94.techkids.vn.shortstory.Utils.Utils;
import quyntg94.techkids.vn.shortstory.models.Story;
import quyntg94.techkids.vn.shortstory.networking.ImageLoader;

/**
 * Created by quyntg94 on 07/05/2017.
 */

public class StoryAdapter extends BaseAdapter {
    private List<Story> storyList;


    public StoryAdapter(List<Story> storyList){
        this.storyList = storyList;
    }

    @Override
    public Object getItem(int position) {
        return storyList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getCount() {
        return storyList.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Story story = storyList.get(position);

        if(convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            convertView = layoutInflater.inflate(R.layout.item_story, parent, false);
        }

        TextView tvTitle = (TextView) convertView.findViewById(R.id.tv_story_name);
        TextView tvDescription = (TextView) convertView.findViewById(R.id.tv_story_description);
        ImageView ivStory = (ImageView) convertView.findViewById(R.id.iv_story_image);
        final ImageView ivFavorite = (ImageView) convertView.findViewById(R.id.iv_favorite);

        tvTitle.setText(story.getTitle());
        Utils.makeFit(tvDescription);
        tvDescription.setText(story.getDescription());
        if(story.isFavorite()){
            ivFavorite.setImageResource(R.drawable.ic_favorite_black_24px);
        } else {
            ivFavorite.setImageResource(R.drawable.ic_favorite_border_black_24px);
        }

        ivFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(story.isFavorite()){
                    story.setFavorite(false);
                    ivFavorite.setImageResource(R.drawable.ic_favorite_border_black_24px);
                } else {
                    story.setFavorite(true);
                    ivFavorite.setImageResource(R.drawable.ic_favorite_black_24px);
                }
            }
        });

        new ImageLoader().setImageView(ivStory).loadImage(story.getImage());


        return convertView;
    }
}


