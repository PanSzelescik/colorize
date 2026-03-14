# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Build Commands

```bash
# Build all active modules
./gradlew build

# Build specific module
./gradlew :common:build
./gradlew :fabric:build

# Run Minecraft client with mod
./gradlew :fabric:runClient

# Clean build
./gradlew clean build
```

No tests exist in this project.

## Architecture

**Colorize** is a Minecraft mod that lets players right-click blocks with dyes to recolor them. It targets Minecraft 26.1 (first unobfuscated MC version) with Java 25 and Gradle 9.4.

### Module Structure

- **`common/`** — Platform-agnostic mod logic. Compiles against vanilla MC + Fabric Loader (for mixin support only). Must never import loader-specific APIs.
- **`fabric/`** — Fabric entrypoint. Registers `UseBlockCallback` and wires up the handler.
- **`forge/`** and **`neoforged/`** — Commented-out placeholders; Forge/NeoForge not yet released for 26.1.

### Key Abstractions

**`ColorizeEventHandler`** (`common/api/`) — Abstract base class instantiated per loader. Holds all `BaseBlockHandler` instances and dispatches right-click events. Each loader subclasses this (e.g., `ColorizeFabricHandler`).

**`BaseBlockHandler`** (`common/api/`) — Handles one category of colorable blocks (e.g., wool, concrete, beds). Contains a `RightClicker → Block` map (color → target block). On right-click, finds the old block in the map, finds the new block by item, and calls `level.setBlockAndUpdate()`.

**`RightClicker`** (`common/api/`) — Abstraction over "what item triggers the color change" — currently dye items (via `DataComponents.DYE`) and mossy conversion items.

**`ColorizeConfig`** (`common/api/`) — JSON config loaded from the platform config dir. Controls per-handler enable/disable, sneaking requirement, and item consumption.

### Important Notes

- **MC 26.1 is unobfuscated** — no Yarn mappings, all class/method names are official Mojang names. `DyeItem.getDyeColor()` (Yarn) → `stack.get(DataComponents.DYE)` (Mojang).
- Build uses `net.fabricmc.fabric-loom` 1.15.5. Common module classes are bundled into the fabric jar via `jar { from project(":common").sourceSets.main.output }` — no shadow plugin needed.
- **JEI integration is disabled** — no JEI release for 26.1 yet. Source files excluded via `sourceSets.main.java.exclude "**/jei/**"` in `common/build.gradle`. Re-enable when JEI publishes for 26.1.
- `loom.platform` properties (Forge/NeoForge submodule gradle.properties) are gone — that was an architectury-loom concept, not used with native per-loader plugins.
