package me.wither.bloodBendingRanking;

import com.projectkorra.projectkorra.ProjectKorra;
import com.projectkorra.projectkorra.configuration.ConfigManager;
import com.sun.java.accessibility.util.AccessibilityEventMonitor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionDefault;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class BloodBendingRanking extends JavaPlugin {

    private Listener listener;

    public static BloodBendingRanking plugin;
    public static FileConfiguration config;
    private PluginManager pl = getServer().getPluginManager();




    @Override
    public void onEnable() {
        plugin = this;
        config = this.getConfig();

        listener = new BloodBendingListener();

        Ranking.Amon = new Permission("bending.bloodbendingrank.amon");
        Ranking.Tarlok = new Permission("bending.bloodbendingrank.tarlok");
        Ranking.Master = new Permission("bending.bloodbendingrank.master");
        Ranking.Expert = new Permission("bending.bloodbendingrank.expert");






        getServer().getPluginManager().registerEvents(listener, this);

        pl.addPermission(Ranking.Amon);
        pl.addPermission(Ranking.Tarlok);
        pl.addPermission(Ranking.Master);
        pl.addPermission(Ranking.Expert);





        plugin.getLogger().info("BloodBendingRanking by Sc1_original successfully enabled! <8");



        checkforcanBloodbendotherBloodbenders();



    }

    @Override
    public void onDisable() {

        //        HandlerList.unregisterAll(listener);
        //
        //        pl.removePermission(Ranking.Amon);
        //        pl.removePermission(Ranking.Tarlok);
        //        pl.removePermission(Ranking.Master);
        //        pl.removePermission(Ranking.Expert);




    }


    public void checkforcanBloodbendotherBloodbenders(){

        boolean canBloodbendotherBloodbenders = ConfigManager.getConfig().getBoolean("Abilities.Water.Bloodbending.CanBloodbendOtherBloodbenders");

        if (!canBloodbendotherBloodbenders) {

            ProjectKorra.plugin.getLogger().warning("BloodbendingRanking: CanBloodbendotherBloodbenders is disabled!");


        }
    }
}
