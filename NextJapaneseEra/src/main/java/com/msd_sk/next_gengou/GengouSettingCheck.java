/**
 *
 */
package com.msd_sk.next_gengou;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Locale;

/**
 * @author msd-sk
 *
 */
public class GengouSettingCheck {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
    
    final long newGengoStartMs = 1556668800000L;

    System.out.println();
    System.out.println("-----------");
    System.out.println();
    
    final DateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
    final DateFormat jpFormat = new SimpleDateFormat("GGGGyyyy'年'M'月'd'日'", new Locale("ja", "JP", "JP"));

    System.out.println(isoFormat.format(newGengoStartMs));
    System.out.println(jpFormat.format(newGengoStartMs));

    System.out.println("-----before 1ms------");

    final long prev = newGengoStartMs - 1;

    System.out.println(isoFormat.format(prev));
    System.out.println(jpFormat.format(prev));

	}
}
