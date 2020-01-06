package me.pan.zeroxrps.modules.nms.v1_14_R1;

import me.pan.zeroxrps.modules.nms.common.TitleUpdator;
import net.minecraft.server.v1_14_R1.PacketPlayInWindowClick;
import net.minecraft.server.v1_14_R1.ChatMessage;
import net.minecraft.server.v1_14_R1.EntityPlayer;
import net.minecraft.server.v1_14_R1.PacketPlayOutOpenWindow;
import org.bukkit.craftbukkit.v1_14_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class updateTitle implements TitleUpdator {
    @Override
    public void update(Player p, String title) {
        EntityPlayer ep = ((CraftPlayer) p).getHandle();
        PacketPlayOutOpenWindow packet = new PacketPlayOutOpenWindow(ep.activeContainer.windowId, ep.activeContainer.getType(), new ChatMessage(title));
        ep.playerConnection.sendPacket(packet);
        ep.updateInventory(ep.activeContainer);
    }
}
