package com.moverperfect.ebm.lib;

/**
 * Extra-Blocks-Mod
 * 
 * Reference
 * 
 * @author Moverperfect
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class Reference {

    /* Debug Mode On-Off */
    public static final boolean DEBUG_MODE = false;

    /* General Mod related constants */
    public static final String MOD_ID = "EBM";
    public static final String MOD_NAME = "ExtraBlocksmod";
    public static final String VERSION_NUMBER = "@VERSION";
    public static final String CHANNEL_NAME = MOD_ID;
    public static final String DEPENDENCIES = "required-after:Forge@[7.7.1.650,)";
    public static final int SECOND_IN_TICKS = 20;
    public static final int SHIFTED_ID_RANGE_CORRECTION = 256;
    public static final String SERVER_PROXY_CLASS = "com.moverperfect.ebm.core.proxy.CommonProxy";
    public static final String CLIENT_PROXY_CLASS = "com.moverperfect.ebm.core.proxy.ClientProxy";
    public static final int VERSION_CHECK_ATTEMPTS = 3;
    public static final String BUILD_NUMBER = "@BUILD_NUMBER@";

}
