package tk.cronibet.proxy;

import net.md_5.bungee.api.plugin.Plugin;
import tk.cronibet.proxy.command.CommandCreative;
import tk.cronibet.proxy.command.CommandHub;

public final class Proxy extends Plugin {

    @Override
    public void onEnable() {
        this.getProxy().getPluginManager().registerCommand(this, new CommandHub());
        this.getProxy().getPluginManager().registerCommand(this, new CommandCreative());
    }

    @Override
    public void onDisable() {
        this.getProxy().getPluginManager().unregisterCommands(this);
    }
}
