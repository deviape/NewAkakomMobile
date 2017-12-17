package id.antarmukamobile.akakommobile.modelAPI;

import java.util.ArrayList;

import id.antarmukamobile.akakommobile.R;

/**
 * Created by asus on 17/12/2017.
 */

public class ListFeed {
    public static ArrayList<FeedModel> getlist(){
        ArrayList<FeedModel> feedlist = new ArrayList<>();
        feedlist.add(new FeedModel(R.drawable.devi,"Devi Ariyana","Lumayan lah"));
        feedlist.add(new FeedModel(R.drawable.atika,"Atika Nurul","Hahaha... Hahaha... Hahaha... Hahaha... Hahaha... Hahaha... Hahaha... Hahaha..."));
        feedlist.add(new FeedModel(R.drawable.mila,"Mila Yunia","Apa ini?"));
        feedlist.add(new FeedModel(R.drawable.yudis,"Yudistiro Dwi","Semangat"));
        feedlist.add(new FeedModel(R.drawable.yudha,"Yudha Pratama","No caption"));

        return feedlist;
    }
}
