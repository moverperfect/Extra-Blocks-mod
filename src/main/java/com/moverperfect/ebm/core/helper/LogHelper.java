package com.moverperfect.ebm.core.helper;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.moverperfect.ebm.lib.Reference;

import cpw.mods.fml.common.FMLLog;

/**
 * Extra-Blocks-Mod
 * 
 * LogHelper
 * 
 * @author Moverperfect
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class LogHelper {

    private static Logger ebmLogger = Logger.getLogger(Reference.MOD_ID);

    public static void init() {

        ebmLogger.setParent(FMLLog.getLogger());
    }

    public static void log(Level logLevel, String message) {

        ebmLogger.log(logLevel, message);
    }

}
