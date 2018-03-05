package main.kotlin
import kotlinx.cinterop.*
import platform.Foundation.*
import libs.*

const val ENDPOINT: String = "https://api.github.com/search/repositories?q=language:kotlin&sort=stars&order=desc&page=1&per_page=10"

class GithubService {

    fun getRepos() {
        /*val request = NSURLRequest(NSURL(ENDPOINT))
        request.addValue("application/json", forHTTPHeaderField = "Accept")
        request.setHTTPMethod("GET")
        val con = NSURLConnection().initWithRequest(request, this)*/

        val request: NSMutableURLRequest = OMGHTTPURLRQ.GET(ENDPOINT, null, error = null)!!
        request.addValue("application/json", forHTTPHeaderField = "Accept")
        val session = NSURLSession.sessionWithConfiguration(NSURLSessionConfiguration.defaultSessionConfiguration,
                delegate = null, delegateQueue = NSOperationQueue.mainQueue)

        session.dataTaskWithRequest(request) { data, _, error ->
            val deserializedData = NSJSONSerialization.JSONObjectWithData(data!!, options = 0, error = null)
            NSLog(deserializedData.toString())
        }

    }
}