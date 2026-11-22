package com.multioutline;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import net.runelite.client.util.WildcardMatcher;

/**
 * One color group, parsed once from its comma-separated name list.
 * Blank entries (from trailing or doubled commas) are ignored, and curly
 * apostrophes are treated the same as straight ones.
 */
final class HighlightGroup
{
	final Color color;
	private final List<String> namePatterns;

	HighlightGroup(Color color, String names)
	{
		this.color = color;
		this.namePatterns = parseNames(names);
	}

	boolean isEmpty()
	{
		return namePatterns.isEmpty();
	}

	boolean matches(String name)
	{
		if (name == null || namePatterns.isEmpty())
		{
			return false;
		}
		String n = normalize(name);
		for (String pattern : namePatterns)
		{
			if (WildcardMatcher.matches(pattern, n))
			{
				return true;
			}
		}
		return false;
	}

	static String normalize(String s)
	{
		return s.replace('’', '\'')
			.replace('‘', '\'')
			.replace(' ', ' ')
			.trim()
			.toLowerCase(Locale.ROOT);
	}

	private static List<String> parseNames(String raw)
	{
		if (raw == null || raw.isEmpty())
		{
			return Collections.emptyList();
		}
		List<String> out = new ArrayList<>();
		for (String part : raw.split("[,\\n]"))
		{
			String p = normalize(part);
			if (!p.isEmpty())
			{
				out.add(p);
			}
		}
		return out;
	}

}
