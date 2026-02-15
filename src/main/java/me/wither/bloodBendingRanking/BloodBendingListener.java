package me.wither.bloodBendingRanking;

import com.projectkorra.projectkorra.BendingPlayer;
import com.projectkorra.projectkorra.ProjectKorra;
import com.projectkorra.projectkorra.configuration.ConfigManager;
import com.projectkorra.projectkorra.event.AbilityStartEvent;
import com.projectkorra.projectkorra.waterbending.blood.Bloodbending;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;


public class BloodBendingListener implements Listener {



    @EventHandler
    public void OnBloodBendingUse(AbilityStartEvent event) {



        Player player = event.getAbility().getPlayer();
        BendingPlayer bPlayer = BendingPlayer.getBendingPlayer(player);



        if(event.getAbility().getName().equals("Bloodbending") ){

            Bloodbending ability = (Bloodbending) event.getAbility();
            Entity entitytarget = ability.getTarget();

            if(!(entitytarget instanceof Player)) {
                return;
            }

            Player target = (Player) ability.getTarget();



            if(getRank(player) < getRank(target)){

                ability.remove();
                event.setCancelled(true);





            }


        }





    }


    public int getRank(Player player) {

        if(player.hasPermission(Ranking.Amon)) return 3;
        if(player.hasPermission(Ranking.Tarlok)) return 2;
        if(player.hasPermission(Ranking.Master)) return 1;
        if(player.hasPermission(Ranking.Expert)) return 0;

        return -1;
    }






}
