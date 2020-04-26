package cc.hiroga.excel

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.arguments.argument
import com.github.ajalt.clikt.parameters.types.file
import de.vandermeer.asciitable.AsciiTable
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment
import org.apache.poi.ss.usermodel.Sheet
import org.apache.poi.ss.usermodel.WorkbookFactory

class Excel : CliktCommand() {
    override fun run() = Unit
}

class SheetCommands : CliktCommand(name = "sheets") {

    private val file by argument(help = "Excel worksheet path").file(exists = true, readable = true, folderOkay = false)

    override fun run() {
        val wb = WorkbookFactory.create(file)
        val sheets = mutableMapOf<Int,Sheet>()
        var i = 0
        while(true){
            try{
                sheets[i] = wb.getSheetAt(i)
                i++
            }catch (e: IllegalArgumentException){
                break
            }
        }
        val table = AsciiTable()
        table.addRule()
        table.addRow("Index", "SheetName", "IsSelected").setTextAlignment(TextAlignment.CENTER)
        sheets.map{
            table.addRule()
            table.addRow(it.key, it.value.sheetName, it.value.isSelected).setTextAlignment(TextAlignment.CENTER)
        }
        println(table.render())
    }
}
