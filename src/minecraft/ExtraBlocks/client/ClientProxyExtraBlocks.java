package ExtraBlocks.client;

import net.minecraftforge.client.MinecraftForgeClient;
import ExtraBlocks.common.CommonProxyExtraBlocks;

public class ClientProxyExtraBlocks extends CommonProxyExtraBlocks
{
@Override
public void registerRenderThings()
{
MinecraftForgeClient.preloadTexture("/textures/Blocks.png");
}
}