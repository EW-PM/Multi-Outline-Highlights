package com.multioutline;

import java.awt.Color;
import net.runelite.client.config.Alpha;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;
import net.runelite.client.config.Range;

@ConfigGroup(MultiOutlineConfig.GROUP)
public interface MultiOutlineConfig extends Config
{
	String GROUP = "multioutline";

	// ---------------------------------------------------------------- Global

	@ConfigSection(name = "Outline style", description = "Applies to every group", position = 0)
	String styleSection = "style";

	@Range(min = 1, max = 10)
	@ConfigItem(keyName = "outlineWidth", name = "Outline width", description = "Thickness of the outline in pixels",
		section = styleSection, position = 0)
	default int outlineWidth()
	{
		return 2;
	}

	@Range(min = 0, max = 4)
	@ConfigItem(keyName = "outlineFeather", name = "Outline feather", description = "Softens the outline edge (0 = hard edge)",
		section = styleSection, position = 1)
	default int outlineFeather()
	{
		return 2;
	}

	// ---------------------------------------------------------------- Group 1

	@ConfigSection(name = "Group 1", description = "First color group", position = 1)
	String group1 = "group1";

	@ConfigItem(keyName = "enabled1", name = "Enabled", description = "Draw this group", section = group1, position = 0)
	default boolean enabled1()
	{
		return true;
	}

	@Alpha
	@ConfigItem(keyName = "color1", name = "Color", description = "Outline color for this group", section = group1, position = 1)
	default Color color1()
	{
		return new Color(255, 0, 0);
	}

	@ConfigItem(keyName = "names1", name = "Names", description = "Comma-separated NPC names. * works as a wildcard.",
		section = group1, position = 2)
	default String names1()
	{
		return "";
	}

	@ConfigItem(keyName = "ids1", name = "IDs", description = "Comma-separated NPC IDs", section = group1, position = 3)
	default String ids1()
	{
		return "";
	}

	// ---------------------------------------------------------------- Group 2

	@ConfigSection(name = "Group 2", description = "Second color group", position = 2)
	String group2 = "group2";

	@ConfigItem(keyName = "enabled2", name = "Enabled", description = "Draw this group", section = group2, position = 0)
	default boolean enabled2()
	{
		return true;
	}

	@Alpha
	@ConfigItem(keyName = "color2", name = "Color", description = "Outline color for this group", section = group2, position = 1)
	default Color color2()
	{
		return new Color(0, 255, 0);
	}

	@ConfigItem(keyName = "names2", name = "Names", description = "Comma-separated NPC names. * works as a wildcard.",
		section = group2, position = 2)
	default String names2()
	{
		return "";
	}

	@ConfigItem(keyName = "ids2", name = "IDs", description = "Comma-separated NPC IDs", section = group2, position = 3)
	default String ids2()
	{
		return "";
	}

	// ---------------------------------------------------------------- Group 3

	@ConfigSection(name = "Group 3", description = "Third color group", position = 3)
	String group3 = "group3";

	@ConfigItem(keyName = "enabled3", name = "Enabled", description = "Draw this group", section = group3, position = 0)
	default boolean enabled3()
	{
		return true;
	}

	@Alpha
	@ConfigItem(keyName = "color3", name = "Color", description = "Outline color for this group", section = group3, position = 1)
	default Color color3()
	{
		return new Color(0, 0, 255);
	}

	@ConfigItem(keyName = "names3", name = "Names", description = "Comma-separated NPC names. * works as a wildcard.",
		section = group3, position = 2)
	default String names3()
	{
		return "";
	}

	@ConfigItem(keyName = "ids3", name = "IDs", description = "Comma-separated NPC IDs", section = group3, position = 3)
	default String ids3()
	{
		return "";
	}

	// ---------------------------------------------------------------- Group 4

	@ConfigSection(name = "Group 4", description = "Fourth color group", position = 4)
	String group4 = "group4";

	@ConfigItem(keyName = "enabled4", name = "Enabled", description = "Draw this group", section = group4, position = 0)
	default boolean enabled4()
	{
		return true;
	}

	@Alpha
	@ConfigItem(keyName = "color4", name = "Color", description = "Outline color for this group", section = group4, position = 1)
	default Color color4()
	{
		return new Color(255, 255, 0);
	}

	@ConfigItem(keyName = "names4", name = "Names", description = "Comma-separated NPC names. * works as a wildcard.",
		section = group4, position = 2)
	default String names4()
	{
		return "";
	}

	@ConfigItem(keyName = "ids4", name = "IDs", description = "Comma-separated NPC IDs", section = group4, position = 3)
	default String ids4()
	{
		return "";
	}

	// ---------------------------------------------------------------- Group 5

	@ConfigSection(name = "Group 5", description = "Fifth color group", position = 5)
	String group5 = "group5";

	@ConfigItem(keyName = "enabled5", name = "Enabled", description = "Draw this group", section = group5, position = 0)
	default boolean enabled5()
	{
		return true;
	}

	@Alpha
	@ConfigItem(keyName = "color5", name = "Color", description = "Outline color for this group", section = group5, position = 1)
	default Color color5()
	{
		return new Color(0, 221, 255);
	}

	@ConfigItem(keyName = "names5", name = "Names", description = "Comma-separated NPC names. * works as a wildcard.",
		section = group5, position = 2)
	default String names5()
	{
		return "";
	}

	@ConfigItem(keyName = "ids5", name = "IDs", description = "Comma-separated NPC IDs", section = group5, position = 3)
	default String ids5()
	{
		return "";
	}
}
