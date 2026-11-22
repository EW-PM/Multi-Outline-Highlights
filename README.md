# Multi Outline Highlights (RuneLite plugin)

Five color groups. Each group outlines matching NPCs using RuneLite's model
outline renderer (the same look as Better NPC Highlight's "Outline Highlight").

Each group has: Enabled, Color (with alpha), Names, IDs.
- Names and IDs both work, in the same group, comma-separated.
- `*` is a wildcard in names (e.g. `Sergeant*`).
- Trailing commas and curly apostrophes are handled.
- If an NPC matches more than one group, the lower-numbered group wins.

Outline width and feather are shared by all groups.

## Run it
1. Open this folder in IntelliJ IDEA (File > Open, pick the folder; it imports as Gradle).
2. Use JDK 11 or newer.
3. Run `MultiOutlinePluginTest.main()` under src/test/java.
   It launches RuneLite in developer mode with the plugin loaded.
   Add VM option `-ea` and program argument `--developer-mode` if prompted.

Note: sideloaded plugins only run in a dev-launched client. To use it in your
normal RuneLite, it would have to be submitted to the Plugin Hub.
