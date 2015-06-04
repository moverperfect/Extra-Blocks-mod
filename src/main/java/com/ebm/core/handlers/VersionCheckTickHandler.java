package com.moverperfect.ebm.core.handlers;

import java.util.EnumSet;

import com.moverperfect.ebm.configuration.ConfigurationSettings;
import com.moverperfect.ebm.core.helper.VersionHelper;
import com.moverperfect.ebm.lib.Reference;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

/**
 * Extra-Blocks-Mod
 * 
 * VersionCheckTickHandler
 * 
 * @author Moverperfect
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class VersionCheckTickHandler implements ITickHandler {

    private static boolean initialized = false;

    @Override
    public void tickStart(EnumSet<TickType> type, Object... tickData) {

    }

    @Override
    public void tickEnd(EnumSet<TickType> type, Object... tickData) {
        if (ConfigurationSettings.NEW_VERSION_SHOWN) {
            if (ConfigurationSettings.DISPLAY_VERSION_RESULT) {
                if (!initialized) {
                    for (TickType tickType : type) {
                        if (tickType == TickType.CLIENT) {
                            if (FMLClientHandler.instance().getClient().currentScreen == null) {
                                if (VersionHelper.getResult() != VersionHelper.UNINITIALIZED || VersionHelper.getResult() != VersionHelper.FINAL_ERROR) {
                                    initialized = true;
                                    if (VersionHelper.getResult() == VersionHelper.OUTDATED) {
                                        FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage(VersionHelper.getResultMessageForClient());
                                        ConfigurationSettings.NEW_VERSION_SHOWN = false;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public EnumSet<TickType> ticks() {

        return EnumSet.of(TickType.CLIENT);
    }

    @Override
    public String getLabel() {

        return Reference.MOD_NAME + ": " + this.getClass().getSimpleName();
    }

}
