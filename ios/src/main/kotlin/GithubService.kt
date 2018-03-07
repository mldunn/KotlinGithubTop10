package main.kotlin
import kotlinx.cinterop.*
import platform.Foundation.*
import libs.*

const val ENDPOINT: String = "https://api.github.com/search/repositories?q=language:kotlin&sort=stars&order=desc&page=1&per_page=10"

/**
 * Class used to fetch items from GitHub API
 */
class GithubService {

    /**
     * Get the repo data
     */
    fun getRepos(onComplete: (List<Repo>) -> Unit) {
        val repos: MutableList<Repo> = ArrayList()

        // prepare the request
        val request: NSMutableURLRequest = OMGHTTPURLRQ.GET(ENDPOINT, null, error = null)!!
        request.addValue("application/json", forHTTPHeaderField = "Accept")

        val session = NSURLSession.sessionWithConfiguration(NSURLSessionConfiguration.defaultSessionConfiguration,
                delegate = null, delegateQueue = NSOperationQueue.mainQueue)

        // execute the HTTP request
        session.dataTaskWithRequest(request) { data, _, error ->
            // deserialize the json data
            val deserializedData = NSJSONSerialization.JSONObjectWithData(data!!, options = 0, error = null)
            val dict = deserializedData.uncheckedCast<NSDictionary>()

            // get the items json element
            val items = dict.valueForKey("items").uncheckedCast<NSArray>()

            // create model objects from the json
            for (i in 0 until items.count()) {
                val item = items.objectAtIndex(i).uncheckedCast<NSDictionary>()

                val title = item.valueForKey("full_name").toString()
                val stars = item.valueForKey("stargazers_count").uncheckedCast<Int>()
                val forks = item.valueForKey("forks").uncheckedCast<Int>()

                repos.add(Repo(title, stars, forks))
            }

            // call the onComplete handler
            onComplete(repos)
        }.resume()
    }
}