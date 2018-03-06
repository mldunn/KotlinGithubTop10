package main.kotlin
import kotlinx.cinterop.*
import platform.Foundation.*
import libs.*

const val ENDPOINT: String = "https://api.github.com/search/repositories?q=language:kotlin&sort=stars&order=desc&page=1&per_page=10"

class GithubService {

    fun getRepos(onComplete: (List<Repo>) -> Unit) {
        val repos: MutableList<Repo> = ArrayList()
        val request: NSMutableURLRequest = OMGHTTPURLRQ.GET(ENDPOINT, null, error = null)!!
        request.addValue("application/json", forHTTPHeaderField = "Accept")
        NSLog("GithubService.1")
        val session = NSURLSession.sessionWithConfiguration(NSURLSessionConfiguration.defaultSessionConfiguration,
                delegate = null, delegateQueue = NSOperationQueue.mainQueue)

        NSLog("GithubService.2")
        session.dataTaskWithRequest(request) { data, _, error ->
            NSLog("GithubService.3")
            val deserializedData = NSJSONSerialization.JSONObjectWithData(data!!, options = 0, error = null)
            val dict = deserializedData.uncheckedCast<NSDictionary>()
            NSLog("GithubService.4")
            val items = dict.valueForKey("items").uncheckedCast<NSArray>()
            NSLog("GithubService.5")
            NSLog(items.objectAtIndex(0).uncheckedCast<NSDictionary>().valueForKey("full_name").toString())
            for (i in 0 until items.count()) {
                val item = items.objectAtIndex(i).uncheckedCast<NSDictionary>()
                var repo = Repo(item.valueForKey("full_name").uncheckedCast(), item.valueForKey("stargazers_count").uncheckedCast(), item.valueForKey("forks").uncheckedCast())
                repos.add(repo)
            }
            onComplete(repos)
        }.resume()
    }
}