package com.example.learnrunyankole;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);


        // Create an ArrayList of word objects
        final ArrayList<Word> myWords = new ArrayList<Word>();
        myWords.add(new Word("Emwe", "One", R.drawable.number_one, R.raw.emwe));
        myWords.add(new Word("Ibiri", "Two", R.drawable.number_two, R.raw.numbers_biri));
        myWords.add(new Word("Ishatu", "Three", R.drawable.number_three, R.raw.numbers_shatu));
        myWords.add(new Word("Iina", "Four", R.drawable.number_four, R.raw.numbers_four));
        myWords.add(new Word("Itaano", "Five", R.drawable.number_five, R.raw.numbers_five));
        myWords.add(new Word("Mukaaga", "Six", R.drawable.number_six, R.raw.numbers_six));
        myWords.add(new Word("Mushanju", "Seven", R.drawable.number_seven, R.raw.numbers_seven));
        myWords.add(new Word("Munaana", "Eight", R.drawable.number_eight, R.raw.numbers_eight));
        myWords.add(new Word("Mwenda", "Nine", R.drawable.number_nine, R.raw.numbers_nine));
        myWords.add(new Word("Ikumi", "Ten", R.drawable.number_ten, R.raw.numbers_ten));

        //create the object of wordadapter
        WordAdapter wordAdapter = new WordAdapter(this, myWords, R.color.category_numbers);

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