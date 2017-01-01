package paladinium;

import paladiniumWorldgen.Worldgen;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.NetLoginHandler;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet1Login;
import net.minecraft.server.MinecraftServer;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.IConnectionHandler;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkMod.SidedPacketHandler;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.common.registry.GameRegistry;


@Mod(modid = "Paladinium", name = "Paladinium", version = "0.0a")
@NetworkMod(clientSideRequired = true,
	serverSideRequired = false,
	/*clientPacketHandlerSpec = @SidedPacketHandler(channels = { "Paladinium" },
	packetHandler = ClientPacketHandler.class),
	serverPacketHandlerSpec = @SidedPacketHandler(channels = { "Paladinium" },
	packetHandler = ServerPacketHandler.class),*/
	connectionHandler = Paladinium.class)

public class Paladinium implements IConnectionHandler{
	@Instance
	public static Paladinium instance;
	
	@SidedProxy(clientSide = "paladinium.ClientProxy", serverSide = "paladinium.CommonProxy")
	public static CommonProxy proxy;
	
	public static final String NAME = "Paladinium";
	
	@PreInit
	public void preLoad(FMLPreInitializationEvent event){
		proxy.registerPreLoad();
	}
	
	@Init
	public void load(FMLInitializationEvent event){
		instance = this;
		proxy.registerOnLoad();
		GameRegistry.registerWorldGenerator(new Worldgen());
	}

	@Override
	public void playerLoggedIn(Player player, NetHandler netHandler,
			INetworkManager manager) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String connectionReceived(NetLoginHandler netHandler,
			INetworkManager manager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void connectionOpened(NetHandler netClientHandler, String server,
			int port, INetworkManager manager) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void connectionOpened(NetHandler netClientHandler,
			MinecraftServer server, INetworkManager manager) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void connectionClosed(INetworkManager manager) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clientLoggedIn(NetHandler clientHandler,
			INetworkManager manager, Packet1Login login) {
		// TODO Auto-generated method stub
		
	}
	
}
