package com.multioutline;

import com.google.inject.Provides;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "Multi Outline Highlights",
	description = "Outline NPCs in up to five color groups by name",
	tags = {"npc", "highlight", "outline", "color", "group", "boss"}
)
public class MultiOutlinePlugin extends Plugin
{
	@Inject
	private OverlayManager overlayManager;

	@Inject
	private MultiOutlineOverlay overlay;

	@Inject
	private MultiOutlineConfig config;

	private volatile List<HighlightGroup> groups = Collections.emptyList();

	List<HighlightGroup> getGroups()
	{
		return groups;
	}

	@Provides
	MultiOutlineConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(MultiOutlineConfig.class);
	}

	@Override
	protected void startUp()
	{
		rebuildGroups();
		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown()
	{
		overlayManager.remove(overlay);
		groups = Collections.emptyList();
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (MultiOutlineConfig.GROUP.equals(event.getGroup()))
		{
			rebuildGroups();
		}
	}

	private void rebuildGroups()
	{
		List<HighlightGroup> list = new ArrayList<>(5);
		add(list, config.enabled1(), config.color1(), config.names1());
		add(list, config.enabled2(), config.color2(), config.names2());
		add(list, config.enabled3(), config.color3(), config.names3());
		add(list, config.enabled4(), config.color4(), config.names4());
		add(list, config.enabled5(), config.color5(), config.names5());
		groups = Collections.unmodifiableList(list);
	}

	private static void add(List<HighlightGroup> list, boolean enabled, java.awt.Color color, String names)
	{
		if (!enabled)
		{
			return;
		}
		HighlightGroup g = new HighlightGroup(color, names);
		if (!g.isEmpty())
		{
			list.add(g);
		}
	}
}
