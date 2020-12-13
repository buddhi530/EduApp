package com.example.eduapp.yasasri;

public class Upload {
    private String mName;
    private String mImageUrl;

    public Upload(){

    }
    public Upload(String name,String mImageUrl){
        if(name.trim().equals("")){
            name = "No Name";
        }

        mName = name;
        mImageUrl = mImageUrl;

    }

    public String getmName(){
        return mName;
    }

    public void setmName(String name){
        mName = name;
    }

    public String getmImageUrl(){
        return mImageUrl;
    }

    public void setmImageUrl(String imageUrl){
        mImageUrl = imageUrl;
    }
}
