package com.k1llm3sixy.colorcodehelper.enum

import net.minecraft.text.Text

enum class Translatable(val key: String, val value: String = "") {
    COLORS("color.list"),
    BLACK("color.black", "&0"),
    DARK_BLUE("color.dark_blue", "&1"),
    DARK_GREEN("color.dark_green", "&2"),
    DARK_AQUA("color.dark_aqua", "&3"),
    DARK_RED("color.dark_red", "&4"),
    DARK_PURPLE("color.dark_purple", "&5"),
    GOLD("color.gold", "&6"),
    GRAY("color.gray", "&7"),
    DARK_GRAY("color.dark_gray", "&8"),
    BLUE("color.blue", "&9"),
    GREEN("color.green", "&a"),
    AQUA("color.aqua", "&b"),
    RED("color.red", "&c"),
    LIGHT_PURPLE("color.light_purple", "&d"),
    YELLOW("color.yellow", "&e"),
    WHITE("color.white", "&f"),
    BOLD("format.bold", "&l"),
    UNDERLINE("format.underline", "&n"),
    ITALIC("format.italic", "&o"),
    STRIKETHROUGH("format.strikethrough", "&m"),
    MAGIC("format.magic", "&k"),
    RESET("format.reset", "&r"),
    COPY("color.copy"),
    MESSAGE_HELP_1("message.help.1"),
    MESSAGE_HELP_2("message.help.2"),
    MESSAGE_HELP_3("message.help.3"),
    MESSAGE_HELP_4("message.help.4"),
    MESSAGE_HELP_5("message.help.5"),
}

fun Translatable.translate(args: String = ""): String = Text.translatable(this.key, args).string