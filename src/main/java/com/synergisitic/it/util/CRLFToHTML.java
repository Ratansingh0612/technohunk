package com.synergisitic.it.util;

import java.util.StringTokenizer;

/**
 * 
 * @author nagendra.yadav
 *
 */
public final class CRLFToHTML {

	public static String process(final String text) {
		if (text == null) {
			return null;
		}

		StringBuilder html = new StringBuilder();
		StringTokenizer st = new StringTokenizer(text, "\r\n", true);
		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			if (token.equals("\n")) {
				html.append("<br/>");
			} else if (token.equals("\r")) {
				// Do nothing
			} else {
				html.append(token);
			}
		}
		return html.toString();
	}
}
