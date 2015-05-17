package at.korti.endermystic.command;

import at.korti.endermystic.api.tools.ToolLevelHandler;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Korti on 17.05.2015.
 */
public class AddXpCommand implements ICommand{

    private List aliases;
    public AddXpCommand() {
        aliases = new ArrayList();
        aliases.add("addxp");
    }

    @Override
    public String getCommandName() {
        return "Add Xp";
    }

    @Override
    public String getCommandUsage(ICommandSender p_71518_1_) {
        return "/addxp <amount>";
    }

    @Override
    public List getCommandAliases() {
        return aliases;
    }

    @Override
    public void processCommand(ICommandSender iCommandSender, String[] args) {
        if (args.length != 1) {
            iCommandSender.addChatMessage(new ChatComponentText("Invalid arguments"));
            return;
        }

        EntityPlayer player = iCommandSender.getEntityWorld().getPlayerEntityByName(iCommandSender.getCommandSenderName());
        ToolLevelHandler.getInstance().addXP(player.inventory.getCurrentItem(), Integer.parseInt(args[0]));
        iCommandSender.addChatMessage(new ChatComponentText("Added " + args[0] + " XP to " + player.inventory.getCurrentItem().getDisplayName()));
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender iCommandSender) {
        EntityPlayer player = iCommandSender.getEntityWorld().getPlayerEntityByName(iCommandSender.getCommandSenderName());
        return player.getDisplayName().equals("korti11");
    }

    @Override
    public List addTabCompletionOptions(ICommandSender p_71516_1_, String[] p_71516_2_) {
        return null;
    }

    @Override
    public boolean isUsernameIndex(String[] p_82358_1_, int p_82358_2_) {
        return false;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
