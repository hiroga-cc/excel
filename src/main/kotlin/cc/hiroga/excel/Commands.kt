package cc.hiroga.excel

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.arguments.argument
import com.github.ajalt.clikt.parameters.types.file

class Excel : CliktCommand() {
    override fun run() = Unit
}

class SheetCommands : CliktCommand(name = "sheets") {

    private val file by argument(help = "Excel worksheet path").file()

    override fun run() {
        println("File: ${file.name}")
    }
}
