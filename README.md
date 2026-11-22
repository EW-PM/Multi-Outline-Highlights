# Multi Outline Highlights

A RuneLite plugin that outlines NPCs in up to five color groups. Each group
matches NPCs by **name** and draws them with RuneLite's model
outline renderer.

![icon](icon.png)

## Settings

**Outline style** (shared by all groups)
- Outline width
- Outline feather

**Group 1 to 5** (each one)
- Enabled
- Color (alpha supported)
- Names: comma-separated, case-insensitive, `*` works as a wildcard (e.g. `Sergeant*`)

Trailing commas, extra spaces and curly apostrophes are ignored. If an NPC
matches more than one group, the lower-numbered group wins.

## Example: God Wars Dungeon by combat style

| Group | Color | Names |
|---|---|---|
| 1 | Red (melee) | `Sergeant Strongstack, Starlight, Flight Kilisa, Tstanon Karlak` |
| 2 | Green (ranged) | `Sergeant Grimspike, Bree, Flockleader Geerin, Zakl'n Gritch` |
| 3 | Blue (magic) | `Sergeant Steelwill, Growler, Wingman Skree, Balfrug Kreeyath` |
| 4 | Yellow (bosses) | `General Graardor, Commander Zilyana, Kree'arra, K'ril Tsutsaroth` |

Vardorvis: put `Vardorvis' Head` in a group.

## Development

Run `MultiOutlinePluginTest.main()` in `src/test/java` from IntelliJ to launch
RuneLite with the plugin loaded (VM option `-ea`, program argument
`--developer-mode`). Every push is also built by GitHub Actions.
