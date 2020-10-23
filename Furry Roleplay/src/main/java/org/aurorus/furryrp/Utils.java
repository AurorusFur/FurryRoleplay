package org.aurorus.furryrp;

import org.aurorus.furryrp.objects.Sona;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Utils {
    public Sona searchPlayerSona(Player p){
        ArrayList<Sona> sonasList = Sona.SonasList;

        for (Sona s : sonasList){
            if (s.id.equals(p.getUniqueId())){
                return s;
            }
        }
        return null;
    }

    public String cutColor(String s){
        String cutted = "";

        for (int i = 2; i<s.length(); i++){
            cutted += s.charAt(i);
        }

        return cutted;
    }

    public int returnCuttedInt(String s){
        int cuttedInt = 0;
        String cuttedString = "";

        for (int i = 2; i<s.indexOf(" "); i++)
            cuttedString += s.charAt(i);

        cuttedInt = Integer.parseInt(cuttedString);

        return cuttedInt;
    }

    public String returnStringInt(String s){
        String cuttedString = "";

        for (int i = s.indexOf(" ")+1; i<s.length(); i++)
            cuttedString += s.charAt(i);

        return cuttedString;
    }
}
