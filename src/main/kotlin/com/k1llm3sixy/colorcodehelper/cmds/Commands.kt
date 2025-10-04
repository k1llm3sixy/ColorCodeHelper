package com.k1llm3sixy.colorcodehelper.cmds

import com.k1llm3sixy.colorcodehelper.color.ColorBuilder
import com.mojang.brigadier.CommandDispatcher
import com.mojang.brigadier.arguments.StringArgumentType
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource
import net.minecraft.text.Text

const val CMD_MAIN = "colorhelper"
const val CMD_COLORS = "colors"
const val CMD_TEST = "test"
object Commands {
    fun register() = ClientCommandRegistrationCallback.EVENT.register { dispatcher, _ -> setupCommands(dispatcher) }

    fun setupCommands(dispatcher: CommandDispatcher<FabricClientCommandSource>) {
        dispatcher.register(
            ClientCommandManager.literal(CMD_MAIN)
                .executes {
                    it.source.sendFeedback(
                        Text.empty()
                            .append(Text.translatable("message.help_1"))
                            .append(Text.translatable("message.help_2"))
                            .append(Text.translatable("message.help_3"))
                            .append(Text.translatable("message.help_4"))
                            .append(Text.translatable("message.help_5"))
                    )
                    1
                }
                .then(
                    ClientCommandManager.literal(CMD_COLORS)
                        .executes {
                            it.source.sendFeedback(ColorBuilder.getColors())
                            1
                        }
                )
                .then(
                    ClientCommandManager.literal(CMD_TEST)
                        .then(
                            ClientCommandManager.argument("message", StringArgumentType.greedyString())
                                .executes { ctx ->
                                    val message = StringArgumentType.getString(ctx, "message").replace('&', '§')
                                    ctx.source.sendFeedback(Text.literal("» $message"))
                                    1
                                }
                        )
                )
        )
    }
}