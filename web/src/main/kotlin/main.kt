import kotlinx.html.a
import kotlin.browser.document
import kotlinx.html.div
import kotlinx.html.dom.create
import kotlinx.html.p

fun main(args: Array<String>) {
    console.log("Started web client")
    val myDiv = document.create.div("panel") {
        p {
            +"Here is "
            a("http://kotlinlang.org") { +"official Kotlin site" }
        }
    }
    document.getElementById("root")!!.appendChild(myDiv)
}