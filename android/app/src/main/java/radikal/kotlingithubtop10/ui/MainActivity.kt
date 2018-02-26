package radikal.kotlingithubtop10.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import radikal.kotlingithubtop10.R

class MainActivity : AppCompatActivity() {
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        setContentView(R.layout.activity_main)

        mainViewModel.getRepos()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError {
                    Log.e(TAG, it.message, it)
                }
                .subscribe {
                    reposRv.layoutManager = LinearLayoutManager(this)
                    reposRv.adapter = RepoRecyclerViewAdapter(this, it)
                }
    }

    companion object {
        val TAG = MainActivity::class.java.simpleName
    }
}
