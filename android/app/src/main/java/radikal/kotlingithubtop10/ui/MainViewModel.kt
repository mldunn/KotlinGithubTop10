package radikal.kotlingithubtop10.ui

import BASE_URL
import android.arch.lifecycle.ViewModel
import com.jakewharton.retrofit2.converter.kotlinx.serialization.stringBased
import kotlinx.serialization.json.JSON
import okhttp3.MediaType
import radikal.kotlingithubtop10.api.GithubService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

/**
 * Created by radiKal on 26-Feb-18.
 */
class MainViewModel : ViewModel() {
    private val json = JSON.nonstrict
    private var githubService: GithubService = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(stringBased(MediaType.parse("application/json")!!, json::parse, json::stringify))
            .build()
            .create(GithubService::class.java)

    fun getRepos() = githubService.getRepos()
            .map {
                it.items
            }
}