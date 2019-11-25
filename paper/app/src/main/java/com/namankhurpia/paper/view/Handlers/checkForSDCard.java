package com.namankhurpia.paper.view.Handlers;

import android.os.Environment;

public class checkForSDCard {

    //Method to Check If SD Card is mounted or not

    public boolean isSDCardPresent() {
        if (Environment.getExternalStorageState().equals(

                Environment.MEDIA_MOUNTED)) {
            return true;
        }
        return false;
    }



}