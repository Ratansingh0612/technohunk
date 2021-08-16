package com.techquiz.trainer.web.controller.vo;

import java.beans.PropertyEditorSupport;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class TimeEditor extends PropertyEditorSupport {

    // Converts a String to a Category (when submitting form)
    @Override
    public void setAsText(String text) {
        String myTime = text.split("[ ]+")[0];
        //String str = "08:03:10 pm";
      //  DateFormat formatter = new SimpleDateFormat("hh:mm:ss");
        Time startingTime = Time.valueOf(myTime+":00");
        this.setValue(startingTime);
    }

    // Converts a Category to a String (when displaying form)
    @Override
    public String getAsText() {
    	Time c = (Time) this.getValue();
        return c.toString();
    }

}
