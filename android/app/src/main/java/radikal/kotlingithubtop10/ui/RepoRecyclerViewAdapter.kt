package radikal.kotlingithubtop10.ui

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import model.Repo
import radikal.kotlingithubtop10.R

/**
 * Created by radiKal on 26-Feb-18.
 */
class RepoRecyclerViewAdapter(val context: Context, val repos: List<Repo>) : RecyclerView.Adapter<RepoRecyclerViewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.repo_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = repos.size

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.titleTv?.text = repos[position].title
        holder?.starsTv?.text = repos[position].stars.toString()
        holder?.forksTv?.text = repos[position].forks.toString()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleTv = view.findViewById<TextView>(R.id.titleTv)
        val starsTv = view.findViewById<TextView>(R.id.starsTv)
        val forksTv = view.findViewById<TextView>(R.id.forksTv)
    }
}