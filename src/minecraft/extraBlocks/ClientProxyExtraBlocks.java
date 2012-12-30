package extraBlocks;

import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxyExtraBlocks extends CommonProxyExtraBlocks
{
@Override
public void registerRenderThings()
{
MinecraftForgeClient.preloadTexture("/textures/Blocks.png");
}
}