package com.utilities;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringJoiner;

public class Utilities {

    public String getDateTime(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
