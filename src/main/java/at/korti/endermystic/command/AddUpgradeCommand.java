package at.korti.endermystic.command;

import at.korti.endermystic.api.tools.ToolLevelHandler;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Korti on 15.05.2015.
 */
public class AddUpgradeCommand implements ICommand {

    private List aliases;
    public AddUpgradeCommand() {
        aliases = new ArrayList();
        aliases.add("addupgrade");
    }

    @Override
    public String getCommandName() {
        return "Add Upgrade";
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "/addupgrade <upgrade id> <level>";
    }

    @Override
    public List getCommandAliases() {
        return aliases;
    }

    @Override
    public void processCommand(ICommandSender iCommandSender, String[] args) {
        if (args.length != 2) {
            iCommandSender.addChatMessage(new ChatComponentText("Invalid arguments"));
            return;
        }

        EntityPlayer player = iCommandSender.getEntityWorld().getPlayerEntityByName(iCommandSender.getCommandSenderName());
        boolean check = ToolLevelHandler.getInstance().addUpgrad(player.inventory.getCurrentItem(), args[0], args[1], true);

        if(check) {
            iCommandSender.addChatMessage(new ChatComponentText("Upgrade with id " + args[0] + " added on item " + player.inventory.getCurrentItem().getDisplayName()));
        }
        else {
            iCommandSender.addChatMessage(new ChatComponentText("Can't execute command"));
        }
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
