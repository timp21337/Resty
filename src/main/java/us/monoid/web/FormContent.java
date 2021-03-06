package us.monoid.web;

import java.io.UnsupportedEncodingException;

/** Encapsulates form-data sent to web services.
 * Currently only application/x-www-form-urlencoded is supported.
 * 
 * @author beders
 *
 */
public class FormContent extends Content {
	protected String rawQuery;

	public FormContent(String query) {
		super("application/x-www-form-urlencoded", getBytes(query)); // strictly speaking US ASCII should be used
    rawQuery = query;
  }
	
	private static byte[] getBytes(String query) {
		try {
			return query.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public String toString() {
		return rawQuery;
	}
}
