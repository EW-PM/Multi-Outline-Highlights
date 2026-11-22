package com.multioutline;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.List;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.NPCComposition;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.outline.ModelOutlineRenderer;
import net.runelite.client.util.Text;

class MultiOutlineOverlay extends Overlay
{
	private static final int VARDORVIS_AXE_STATIC = 12225;
	private static final int VARDORVIS_AXE_MOVING = 12227;

	private final Client client;
	private final MultiOutlinePlugin plugin;
	private final MultiOutlineConfig config;
	private final ModelOutlineRenderer outlineRenderer;

	@Inject
	MultiOutlineOverlay(Client client, MultiOutlinePlugin plugin, MultiOutlineConfig config,
		ModelOutlineRenderer outlineRenderer)
	{
		this.client = client;
		this.plugin = plugin;
		this.config = config;
		this.outlineRenderer = outlineRenderer;
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		List<HighlightGroup> groups = plugin.getGroups();
		boolean axes = config.vardorvisAxes();
		if (groups.isEmpty() && !axes)
		{
			return null;
		}

		int width = config.outlineWidth();
		int feather = config.outlineFeather();

		for (NPC npc : client.getTopLevelWorldView().npcs())
		{
			if (npc == null)
			{
				continue;
			}

			int id = npc.getId();
			if (axes && (id == VARDORVIS_AXE_STATIC || id == VARDORVIS_AXE_MOVING))
			{
				outlineRenderer.drawOutline(npc, width, config.vardorvisAxesColor(), feather);
				continue;
			}

			// Transformed composition covers NPCs that change form mid-fight
			NPCComposition comp = npc.getTransformedComposition();
			String name = comp != null ? comp.getName() : npc.getName();
			if (name == null)
			{
				continue;
			}
			name = Text.removeTags(name);

			// First matching group wins, so group order sets priority
			for (HighlightGroup group : groups)
			{
				if (group.matches(name))
				{
					outlineRenderer.drawOutline(npc, width, group.color, feather);
					break;
				}
			}
		}
		return null;
	}
}
