package com.example.learnrunyankole;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);


        // Create an ArrayList of word objects
        final ArrayList<Word> myWords = new ArrayList<Word>();
        myWords.add(new Word("Agaandi?", "How are you?", R.raw.phrases_agaandi));
        myWords.add(new Word("Ninyenda Kurya", "I want to eat", R.raw.phrases_iwanttoeat));
        myWords.add(new Word("Nokyiguza zingahi?", "How much money do you sell it?", R.raw.phrases_howmuchareyouselling));
        myWords.add(new Word("Iziina ryangye niinye Joseph", "My name is Joseph", R.raw.phrases_myname));
        myWords.add(new Word("Nooza nkahi?", "Where are you going?", R.raw.phrases_myname));

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
