package com.k1llm3sixy.colorcodehelper

import com.k1llm3sixy.colorcodehelper.cmds.Commands
import net.fabricmc.api.ClientModInitializer

class ColorCodeHelperClient: ClientModInitializer {

    override fun onInitializeClient() {
        Commands.register()
    }
}