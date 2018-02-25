import kotlinx.html.a
import kotlin.browser.document
import kotlinx.html.div
import kotlinx.html.dom.append
import kotlinx.html.dom.create
import kotlinx.html.p
import org.w3c.fetch.RequestInit
import kotlin.browser.window
import kotlin.js.json

fun main(args: Array<String>) {
    console.log("Started web client")

    window.fetch(ENDPOINT, object : RequestInit {
        override var method: String? = "GET"
        override var headers: dynamic = json("Accept" to "application/json")
    }).then {
        console.log("Status: ${it.status}")
        return@then it.json()
    }.then {
        val repos: MutableList<Repo> = ArrayList()
        for (repoJson in it.asDynamic().items) {
            val title = repoJson.full_name.unsafeCast<String>()
            val stars: Int = repoJson.stargazers_count.unsafeCast<Int>()
            val forks: Int = repoJson.forks_count.unsafeCast<Int>()
            console.log(title, stars, forks)
            val repo = Repo(title, stars, forks)
            repos.add(repo)
        }

        val reposDiv = document.create.div("repos")
        for (repo in repos) {
            reposDiv.append.div {
                p {
                    console.log("Render: $repo")
                    render(repo)
                }
            }
        }
    document.getElementById("root")!!.appendChild(reposDiv)
    }
}