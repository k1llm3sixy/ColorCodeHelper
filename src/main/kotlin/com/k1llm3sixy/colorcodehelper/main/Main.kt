package com.k1llm3sixy.colorcodehelper.main

import com.k1llm3sixy.colorcodehelper.enum.Translatable.*
import com.k1llm3sixy.colorcodehelper.enum.translate
import net.minecraft.text.ClickEvent
import net.minecraft.text.HoverEvent
import net.minecraft.text.Text

object Main {
    fun showColors(): Text {
        return Text.empty()
            .append(COLORS.translate())
            .append(BLACK.translate().copyable(BLACK.value))
            .append(DARK_BLUE.translate().copyable(DARK_BLUE.value))
            .append(DARK_GREEN.translate().copyable(DARK_GREEN.value))
            .append(DARK_AQUA.translate().copyable(DARK_AQUA.value))
            .append(DARK_RED.translate().copyable(DARK_RED.value))
            .append(DARK_PURPLE.translate().copyable(DARK_PURPLE.value))
            .append(GOLD.translate().copyable(GOLD.value))
            .append(GRAY.translate().copyable(GRAY.value))
            .append(DARK_GRAY.translate().copyable(DARK_GRAY.value))
            .append(BLUE.translate().copyable(BLUE.value))
            .append(GREEN.translate().copyable(GREEN.value))
            .append(AQUA.translate().copyable(AQUA.value))
            .append(RED.translate().copyable(RED.value))
            .append(LIGHT_PURPLE.translate().copyable(LIGHT_PURPLE.value))
            .append(YELLOW.translate().copyable(YELLOW.value))
            .append(WHITE.translate().copyable(WHITE.value))
            .append(BOLD.translate().copyable(BOLD.value))
            .append(UNDERLINE.translate().copyable(UNDERLINE.value))
            .append(ITALIC.translate().copyable(ITALIC.value))
            .append(STRIKETHROUGH.translate().copyable(STRIKETHROUGH.value))
            .append(MAGIC.translate().copyable(MAGIC.value))
            .append(RESET.translate().copyable(RESET.value))
    }

    fun String.copyable(colorCode: String): Text {
        return Text.literal("\n$this")
            .styled {
                it.withClickEvent(ClickEvent(ClickEvent.Action.COPY_TO_CLIPBOARD, colorCode))
                    .withHoverEvent(HoverEvent(HoverEvent.Action.SHOW_TEXT, Text.literal(COPY.translate(colorCode))))
            }
    }
}