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
		long[] mss = new long[]{
				1546268400000L, //日本の切り替え時間
				1546300800000L, //UTCの真夜中（propertyファイルに書いた数値）
		};
		Arrays.stream(mss).forEach(s -> {
			System.out.println();
			System.out.println("-----------");
			System.out.println();
			DateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
			DateFormat jpFormat = new SimpleDateFormat("GGGGyyyy'年'M'月'd'日'", new Locale("ja", "JP", "JP"));


			System.out.println(isoFormat.format(s));
			System.out.println(jpFormat.format(s));


			System.out.println("　　　-----1ms前------");

			long prev = s - 1;

			System.out.println(isoFormat.format(prev));
			System.out.println(jpFormat.format(prev));

	    });

	}
}
