package radikal.kotlingithubtop10

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import Repo

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val r = Repo("", 2, 3)
    }
}
