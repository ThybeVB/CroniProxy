package tk.cronibet.proxy.command;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class CommandHub extends Command {

    public CommandHub() {
        super("hub", "croniproxy.warp.hub");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (!(sender instanceof ProxiedPlayer)) {
            sender.sendMessage(new ComponentBuilder("Player only command!").color(ChatColor.RED).create());
            return;
        }
        ProxiedPlayer player = (ProxiedPlayer)sender;

        if (player.getServer().getInfo().getName().equalsIgnoreCase("survival")) {
            return;
        }

        ServerInfo targetServer = ProxyServer.getInstance().getServerInfo("survival");
        player.connect(targetServer);
    }
}
