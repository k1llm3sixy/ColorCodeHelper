package com.k1llm3sixy.colorcodehelper.cmds

import com.k1llm3sixy.colorcodehelper.main.Main
import com.mojang.brigadier.CommandDispatcher
import com.mojang.brigadier.arguments.StringArgumentType
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource
import net.minecraft.text.Text
import com.k1llm3sixy.colorcodehelper.enum.Translatable.*
import com.k1llm3sixy.colorcodehelper.enum.translate

object Commands {
    fun register() {
        ClientCommandRegistrationCallback.EVENT.register { dispatcher, _ ->
            commands(dispatcher)
        }
    }

    fun commands(dispatcher: CommandDispatcher<FabricClientCommandSource>) {
        dispatcher.register(
            ClientCommandManager.literal("colorhelper")
                .executes {
                    val messageHelp = Text.empty()
                        .append(MESSAGE_HELP_1.translate())
                        .append(MESSAGE_HELP_2.translate())
                        .append(MESSAGE_HELP_3.translate())
                        .append(MESSAGE_HELP_4.translate())
                        .append(MESSAGE_HELP_5.translate())

                    it.source.sendFeedback(messageHelp)
                    1
                }
                .then(
                    ClientCommandManager.literal("colors")
                        .executes {
                            it.source.sendFeedback(Main.showColors())
                            1
                        }
                )
                .then(
                    ClientCommandManager.literal("test")
                        .then(
                            ClientCommandManager.argument("message", StringArgumentType.greedyString())
                                .executes { context ->
                                    val message = StringArgumentType.getString(context, "message").replace('&', '§')
                                    context.source.sendFeedback(Text.literal("» $message"))
                                    1
                                }
                        )
                )
        )
    }
}