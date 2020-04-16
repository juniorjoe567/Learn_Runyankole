package com.example.learnrunyankole;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word>{
//private int mColorResourceId;
    public WordAdapter(@NonNull Context context, ArrayList<Word> words, int colorResourceId) {
        super(context, 0,words);
    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //check if the existing view is being used, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.language_list, parent, false);
        }
        //get the word object located at this position in the list
        Word currentWord = getItem(position);

        TextView textView = listItemView.findViewById(R.id.runyankole_word);
        textView.setText(currentWord.getmRunyankoleTranslation());

        TextView textView1 = listItemView.findViewById(R.id.english_word);
        textView1.setText(currentWord.getmEnglishTranslation());

        ImageView imageView = listItemView.findViewById(R.id.imageToShow);

        if(currentWord.hasImage()){
            /**
             * If the current word has an image associated with it, then set the image and then show it otherwise hide the
             * view as shown below
             */
            imageView.setImageResource(currentWord.getmImageResourceId());
            imageView.setVisibility(View.VISIBLE);
        }
        else {
            /**
             * If there is no image associated, then hide the view
             */
            imageView.setVisibility(View.GONE);
        }

        return listItemView;
    }
}
