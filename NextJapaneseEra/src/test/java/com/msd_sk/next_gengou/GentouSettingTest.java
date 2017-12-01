package com.msd_sk.next_gengou;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.junit.Test;

public class GentouSettingTest {

	@Test
	public void testNextJpGengouSetting() {
		try {
			DateFormat isoFmt = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
			DateFormat jpFormat = new SimpleDateFormat("GGGGyyyy'年'M'月'd'日'", new Locale("ja", "JP", "JP"));


			Date currentGengouDate = isoFmt.parse("2019-04-30T23:59:59.999+0900");
			final String currentGengouJpString = jpFormat.format(currentGengouDate);
			assertEquals(currentGengouJpString, "平成31年4月30日");


			Date nextGengouDate = isoFmt.parse("2019-05-01T00:00:00.000+0900");
			final String nextGengouJpString = jpFormat.format(nextGengouDate);
			assertTrue(nextGengouJpString.endsWith("元年5月1日"));


		} catch (ParseException e) {
			fail(e.toString());
		}

	}

}
