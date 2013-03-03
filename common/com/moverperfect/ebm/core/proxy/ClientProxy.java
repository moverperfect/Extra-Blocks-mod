package com.moverperfect.ebm.core.proxy;

import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy
{
@Override
public void registerRenderThings()
{
MinecraftForgeClient.preloadTexture("/textures/Blocks.png");
}
}