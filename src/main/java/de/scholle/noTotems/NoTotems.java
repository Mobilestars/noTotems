package de.scholle.noTotems;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Item;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class NoTotems extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("NoTotems has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("NoTotems has been disabled!");
    }

    @EventHandler
    public void onEntityDamage(EntityDamageEvent e) {
        if (!getConfig().getBoolean("NoTotems", true)) return;
        if (!(e.getEntity() instanceof Player p)) return;

        if (p.getHealth() - e.getFinalDamage() <= 0) {
            if (p.getInventory().getItemInOffHand().getType() == Material.TOTEM_OF_UNDYING) {
                p.getInventory().setItemInOffHand(null);
                p.sendMessage("§cTotems are disabled!");
            } else if (p.getInventory().getItemInMainHand().getType() == Material.TOTEM_OF_UNDYING) {
                p.getInventory().setItemInMainHand(null);
                p.sendMessage("§cTotems are disabled!");
            }
        }
    }

    @EventHandler
    public void onPickup(EntityPickupItemEvent e) {
        if (!getConfig().getBoolean("NoTotems", true)) return;
        if (!(e.getEntity() instanceof Player)) return;

        Item item = e.getItem();
        if (item.getItemStack().getType() == Material.TOTEM_OF_UNDYING) {
            e.setCancelled(true);
        }
    }
}
