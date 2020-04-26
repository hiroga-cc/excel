package cc.hiroga.excel

import com.github.ajalt.clikt.core.subcommands

fun main(args: Array<String>) {
    Excel().subcommands(ListSheetsCommand()).main(args)
}
