package com.k1llm3sixy.colorcodehelper.main

import com.k1llm3sixy.colorcodehelper.enum.Colors.*
import net.minecraft.text.ClickEvent
import net.minecraft.text.HoverEvent
import net.minecraft.text.Text

object Main {
    fun showColors(): Text {
        return Text.empty()
            .append(Text.literal("§7» Available colors:§r"))
            .append(BLACK.color.copyable(BLACK.colorCode))
            .append(DARK_BLUE.color.copyable(DARK_BLUE.colorCode))
            .append(DARK_GREEN.color.copyable(DARK_GREEN.colorCode))
            .append(DARK_AQUA.color.copyable(DARK_AQUA.colorCode))
            .append(DARK_RED.color.copyable(DARK_RED.colorCode))
            .append(DARK_PURPLE.color.copyable(DARK_PURPLE.colorCode))
            .append(GOLD.color.copyable(GOLD.colorCode))
            .append(GRAY.color.copyable(GRAY.colorCode))
            .append(DARK_GRAY.color.copyable(DARK_GRAY.colorCode))
            .append(BLUE.color.copyable(BLUE.colorCode))
            .append(GREEN.color.copyable(GREEN.colorCode))
            .append(AQUA.color.copyable(AQUA.colorCode))
            .append(RED.color.copyable(RED.colorCode))
            .append(LIGHT_PURPLE.color.copyable(LIGHT_PURPLE.colorCode))
            .append(YELLOW.color.copyable(YELLOW.colorCode))
            .append(WHITE.color.copyable(WHITE.colorCode))
            .append(BOLD.color.copyable(BOLD.colorCode))
            .append(UNDERLINE.color.copyable(UNDERLINE.colorCode))
            .append(ITALIC.color.copyable(ITALIC.colorCode))
            .append(STRIKETHROUGH.color.copyable(STRIKETHROUGH.colorCode))
            .append(MAGIC.color.copyable(MAGIC.colorCode))
            .append(RESET.color.copyable(RESET.colorCode))
    }

    fun String.copyable(colorCode: String): Text {
        return Text.literal("\n$this")
            .styled {
                it.withClickEvent(ClickEvent(ClickEvent.Action.COPY_TO_CLIPBOARD, colorCode))
                    .withHoverEvent(HoverEvent(HoverEvent.Action.SHOW_TEXT, Text.literal("Copy $colorCode")))
            }
    }
}