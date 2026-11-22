package com.multioutline;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

/** Run this main() from your IDE to launch RuneLite with the plugin loaded. */
public class MultiOutlinePluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(MultiOutlinePlugin.class);
		RuneLite.main(args);
	}
}
