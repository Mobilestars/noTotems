# ☠️ NoTotems

A **Minecraft Spigot/Paper plugin** that completely **disables Totems of Undying**.  
Perfect for survival or PvP servers that want to remove the extra life advantage from Totems.

---

## ⚙️ Features

- 🚫 **Prevents players from being saved** by Totems of Undying  
- ❌ **Cancels picking up Totems**  
- 💬 Sends a message to the player when a Totem is blocked  
- ⚡ Lightweight and easy to configure  

---

## 📁 Installation

1. Download the plugin `.jar` file  
2. Place it in your server’s `plugins/` folder  
3. Start or reload your server  
4. A default `config.yml` will be created automatically  

---

## ⚙️ Configuration (`config.yml`)

```yaml
# Enable or disable Totem blocking
NoTotems: true
´´´

---

- NoTotems: true → Totems are disabled

- NoTotems: false → Totems work normally

## 💬 Example Message

When a player would have been saved by a Totem:

§cTotems are disabled!

You can modify this message in the code if needed.

## 🧩 Developer Information

Main class:
de.scholle.noTotems.NoTotems

Events handled:

EntityDamageEvent – prevents Totem from saving the player

EntityPickupItemEvent – prevents picking up Totems

Blocked item:
Material.TOTEM_OF_UNDYING

## 🧰 Compatibility

- ✅ Works on Spigot, Paper, and Purpur

- 🧱 Compatible with Minecraft 1.18+

- ⚙️ Requires Java 17+
