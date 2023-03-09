package com.example.app3ratlla.clases;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.app3ratlla.R;

import java.util.List;

public class Adapter extends ArrayAdapter<User> {

    private Context mContext;
    private int mResource;

    public Adapter(Context context, int resource, List<User> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            view = inflater.inflate(mResource, parent, false);
        }

        User user = getItem(position);
        if (user != null) {
            ImageView profileImageView = view.findViewById(R.id.profile_image_view);
            TextView usernameTextView = view.findViewById(R.id.username_text_view);
            TextView scoreTextView = view.findViewById(R.id.score_text_view);

            profileImageView.setImageResource(user.getProfileImage());
            usernameTextView.setText(user.getUsername());
            scoreTextView.setText("Score: " + user.getScore());
        }

        return view;
    }
}
