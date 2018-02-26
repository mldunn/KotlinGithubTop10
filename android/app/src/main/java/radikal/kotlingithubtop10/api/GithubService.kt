package radikal.kotlingithubtop10.api

import model.Repo
import io.reactivex.Observable
import model.ReposResponse
import retrofit2.http.GET

/**
 * Created by radiKal on 26-Feb-18.
 */
interface GithubService {
    @GET("search/repositories?q=language:kotlin&sort=stars&order=desc&page=1&per_page=10")
    fun getRepos(): Observable<ReposResponse>
}