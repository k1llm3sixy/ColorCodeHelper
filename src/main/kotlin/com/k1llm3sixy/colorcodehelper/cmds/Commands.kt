package com.k1llm3sixy.colorcodehelper.cmds

import com.k1llm3sixy.colorcodehelper.main.Main
import com.mojang.brigadier.CommandDispatcher
import com.mojang.brigadier.arguments.StringArgumentType
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource
import net.minecraft.text.Text

const val MESSAGE_HELP = """
                        §7» §eAvailable commands:
                        §6/colorhelper test <message> §7- Allow you to test your message with colors. §bExample: &1&lhi!
                        §6/colorhelper colors §7- Shows available color codes
                        §7» P.S: §aColors on most servers use the ampersand (§f&) §ainstead of the section sign, which is §cinvisible in Minecraft chat and cannot be used
                        §7» P.S2: §a/colorhelper test automatically §creplaces §athe ampersand (§f&§a) §cwith the section sign
                    """

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
                    it.source.sendFeedback(Text.literal(MESSAGE_HELP.trimIndent()))
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