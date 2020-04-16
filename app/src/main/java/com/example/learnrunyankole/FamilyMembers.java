package com.example.learnrunyankole;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyMembers extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create an ArrayList of word objects
        final ArrayList<Word> myWords = new ArrayList<Word>();
        myWords.add(new Word("Taata", "Dad",R.drawable.family_father, R.raw.family_taata));
        myWords.add(new Word("Maama", "Mom", R.drawable.family_mother, R.raw.family_maama));
        myWords.add(new Word("Younger sister", "Murumuna", R.drawable.family_younger_sister, R.raw.family_murumuna));
        myWords.add(new Word("Older sister", "Munyanyazi", R.drawable.family_older_sister, R.raw.family_oldersister));
        myWords.add(new Word("Mutabani", "Son", R.drawable.family_son, R.raw.family_son));
        myWords.add(new Word("Muharawanje", "Daughter", R.drawable.family_daughter, R.raw.family_daughter));
        myWords.add(new Word("Shwenkuru", "Grandfather", R.drawable.family_grandfather, R.raw.family_grandpa));
        myWords.add(new Word("Kaaka", "Grandmother", R.drawable.family_grandmother, R.raw.family_grandma));
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
