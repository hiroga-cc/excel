package cc.hiroga.excel

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.arguments.argument
import com.github.ajalt.clikt.parameters.types.file
import de.vandermeer.asciitable.AsciiTable
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment
import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.ss.usermodel.WorkbookFactory

class Excel : CliktCommand() {
    override fun run() = Unit
}

class ListSheetsCommand : CliktCommand(name = "list-sheets") {

    val file by argument(help = "Excel worksheet path").file(exists = true, readable = true, folderOkay = false)

    override fun run() {
        // Fatal error: com.oracle.svm.core.util.VMError$HostedError: com.oracle.svm.core.util.UserError$UserException: Static field or an object referenced from a static field changed during native image generation?
        val wb: Workbook = WorkbookFactory.create(file, null, true)
        val table = AsciiTable()
        table.addRule()
        table.addRow("Index", "SheetName", "IsSelected").setTextAlignment(TextAlignment.CENTER)

        var i = 0
        while (true) {
            try {
                val sheet = wb.getSheetAt(i)
                table.addRule()
                table.addRow(i, sheet.sheetName, sheet.isSelected).setTextAlignment(TextAlignment.CENTER)
                i++
            } catch (e: IllegalArgumentException) {
                break
            }
        }
        println(table.render())
    }
}
