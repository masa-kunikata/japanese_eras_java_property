package msd.sample;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class GengouSettingCheck{

  public static void main(String[] args){
    long millisec = Long.parseLong(args[0], 10);

    DateFormat gengouFormat = new SimpleDateFormat("GGGG", new Locale("ja", "JP", "JP"));
    DateFormat gengouYearFormat = new SimpleDateFormat("GGGG yyyy'年'M'月'd'日'", new Locale("ja", "JP", "JP"));
    DateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");


    System.out.println(isoFormat.format(millisec));
    System.out.println(gengouFormat.format(millisec));
    System.out.println(gengouYearFormat.format(millisec));


    System.out.println("-----------");

    long prevMillisec = millisec - 1;

    System.out.println(isoFormat.format(prevMillisec));
    System.out.println(gengouFormat.format(prevMillisec));
    System.out.println(gengouYearFormat.format(prevMillisec));

  }

}


