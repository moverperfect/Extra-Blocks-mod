package com.moverperfect.ebm.configuration;

/**
 * Extra-Blocks-Mod
 * 
 * ConfigurationSettings
 * 
 * @author Moverperfect
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class ConfigurationSettings {

    /*
     * General configuration settings
     */
    public static boolean DISPLAY_VERSION_RESULT;
    public static final String DISPLAY_VERSION_RESULT_CONFIGNAME = "version_check.display_results";
    public static final boolean DISPLAY_VERSION_RESULT_DEFAULT = true;
    
    public static String LAST_DISCOVERED_VERSION;
    public static final String LAST_DISCOVERED_VERSION_CONFIGNAME = "version_check.last_discovered_version";
    public static final String LAST_DISCOVERED_VERSION_DEFAULT = "";
    
    /*
     * Recipe configuration settings
     */
    
    public static boolean SEEDS_BREAD;
    public static final String SEEDS_BREAD_CONFIGNAME = "seedstobread.enabled";
    public static final boolean SEEDS_BREAD_DEFAULT = true;
    

    /*
     * Block related config settings
     */
    public static boolean METALS;
    public static final String METALS_CONFIGNAME = "metals.enabled";
    public static final boolean METALS_DEFAULT = true;
    
    public static boolean METAL_TOOLS;
    public static final String METAL_TOOLS_CONFIGNAME = "metal.tools.enabled";
    public static final boolean METAL_TOOLS_DEFAULT = true;
    
    public static boolean BLOCK_TOOLS;
    public static final String BLOCK_TOOLS_CONFIGNAME = "block.tools.enabled";
    public static final boolean BLOCK_TOOLS_DEFAULT = true;
    
    /*
     * Item related config settings
     */
}
