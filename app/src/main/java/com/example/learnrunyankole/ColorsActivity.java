package com.example.learnrunyankole;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);


        // Create an ArrayList of word objects
        final ArrayList<Word> myWords = new ArrayList<Word>();
        myWords.add(new Word("Ekyirikutukura", "Red",R.drawable.color_red, R.raw.colors_red));
        myWords.add(new Word("Ekyamutale", "White", R.drawable.color_white, R.raw.colors_white));
        myWords.add(new Word("Ekyirikwiragura", "Black",R.drawable.color_black, R.raw.colors_black));
        myWords.add(new Word("Kyibabi", "Green",R.drawable.color_green, R.raw.colors_green));
        myWords.add(new Word("Kyeiju", "Dusty yellow",R.drawable.color_dusty_yellow, R.raw.colors_grey));
        myWords.add(new Word("Ekyirikwera", "Brown",R.drawable.color_brown, R.raw.colors_brown));
        myWords.add(new Word("Kyinekye", "Mustard yellow",R.drawable.color_mustard_yellow, R.raw.colors_kyinekye));

        //create the object of wordadapter
        WordAdapter wordAdapter = new WordAdapter(this,myWords, R.color.category_numbers);

        //attach the adapter to the list view
        ListView listView = findViewById(R.id.listViewNumbers);
        listView.setAdapter(wordAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                //we want to get the position of the word that wa passed
                Word word = myWords.get(position);

                releaseMediaPlayer();

                mediaPlayer = MediaPlayer.create(getApplicationContext(), word.getmAudioResourceID());
                mediaPlayer.start();

                //We need to be notified when the sound finishes so that we can release the media player resources
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        releaseMediaPlayer();
                    }
                });
            }
        });


    }
    private void releaseMediaPlayer() {
        //if the media player is not null, then it may be playing a sound. thats why we release the resources
        if (mediaPlayer != null) {
            mediaPlayer.release();

            mediaPlayer = null;
        }
    }

    //release resources when the user leaves the app so that it can stop playing the audio in the background

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
}
