package com.k1llm3sixy.colorcodehelper.color

import net.minecraft.text.ClickEvent
import net.minecraft.text.HoverEvent
import net.minecraft.text.Text

object ColorBuilder {
    fun getColors(): Text {
        return Text.empty()
            .append(getTranslatable("color.black").withEvent("&0"))
            .append(getTranslatable("color.dark_blue").withEvent("&1"))
            .append(getTranslatable("color.dark_green").withEvent("&2"))
            .append(getTranslatable("color.dark_aqua").withEvent("&3"))
            .append(getTranslatable("color.dark_red").withEvent("&4"))
            .append(getTranslatable("color.dark_purple").withEvent("&5"))
            .append(getTranslatable("color.gold").withEvent("&6"))
            .append(getTranslatable("color.gray").withEvent("&7"))
            .append(getTranslatable("color.dark_gray").withEvent("&8"))
            .append(getTranslatable("color.blue").withEvent("&9"))
            .append(getTranslatable("color.green").withEvent("&a"))
            .append(getTranslatable("color.aqua").withEvent("&b"))
            .append(getTranslatable("color.red").withEvent("&c"))
            .append(getTranslatable("color.light_purple").withEvent("&d"))
            .append(getTranslatable("color.yellow").withEvent("&e"))
            .append(getTranslatable("color.white").withEvent("&f"))
            .append(getTranslatable("format.bold").withEvent("&l"))
            .append(getTranslatable("format.underline").withEvent("&n"))
            .append(getTranslatable("format.italic").withEvent("&o"))
            .append(getTranslatable("format.strikethrough").withEvent("&m"))
            .append(getTranslatable("format.magic").withEvent("&k"))
            .append(getTranslatable("format.reset").withEvent("&r"))
    }

    fun getTranslatable(key: String): String = Text.translatable(key).string

    fun String.withEvent(colorCode: String): Text {
        return Text.literal("\n$this")
            .styled {
                it.withClickEvent(ClickEvent(ClickEvent.Action.COPY_TO_CLIPBOARD, colorCode))
                    .withHoverEvent(HoverEvent(HoverEvent.Action.SHOW_TEXT, Text.literal(colorCode)))
            }
    }
}