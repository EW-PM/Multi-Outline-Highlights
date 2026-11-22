package com.multioutline;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import net.runelite.client.util.WildcardMatcher;

/**
 * One color group, parsed once from its config strings.
 * Blank entries (from trailing or doubled commas) are ignored, and curly
 * apostrophes are treated the same as straight ones.
 */
final class HighlightGroup
{
	final Color color;
	private final List<String> namePatterns;
	private final Set<Integer> ids;

	HighlightGroup(Color color, String names, String ids)
	{
		this.color = color;
		this.namePatterns = parseNames(names);
		this.ids = parseIds(ids);
	}

	boolean isEmpty()
	{
		return namePatterns.isEmpty() && ids.isEmpty();
	}

	boolean matches(int id, String name)
	{
		if (ids.contains(id))
		{
			return true;
		}
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

	private static Set<Integer> parseIds(String raw)
	{
		if (raw == null || raw.isEmpty())
		{
			return Collections.emptySet();
		}
		Set<Integer> out = new HashSet<>();
		for (String part : raw.split("[,\\n]"))
		{
			String p = part.trim();
			if (p.isEmpty())
			{
				continue;
			}
			try
			{
				out.add(Integer.parseInt(p));
			}
			catch (NumberFormatException ignored)
			{
				// skip anything that isn't a number
			}
		}
		return out;
	}
}
