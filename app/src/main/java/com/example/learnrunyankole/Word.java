package com.example.learnrunyankole;

public class Word {
    private String mRunyankoleTranslation;
    private String mEnglishTranslation;
    private int mAudioResourceID;
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;

    public Word(String mRunyankoleTranslation, String mEnglishTranslation, int mAudioResourceID) {
        this.mRunyankoleTranslation = mRunyankoleTranslation;
        this.mEnglishTranslation = mEnglishTranslation;
        this.mAudioResourceID = mAudioResourceID;
    }

    public Word(String mRunyankoleTranslation, String mEnglishTranslation, int mImageResourceId, int mAudioResourceID) {
        this.mRunyankoleTranslation = mRunyankoleTranslation;
        this.mEnglishTranslation = mEnglishTranslation;
        this.mAudioResourceID = mAudioResourceID;
        this.mImageResourceId = mImageResourceId;
    }

    /**
     * @return the runyankole translation
     */
    public String getmRunyankoleTranslation() {
        return mRunyankoleTranslation;
    }

    /**
     * @return the english translation
     */
    public String getmEnglishTranslation() {
        return mEnglishTranslation;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Returns whether or not there is an image for this word
     */
    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    public int getmAudioResourceID() {
        return mAudioResourceID;
    }
}
