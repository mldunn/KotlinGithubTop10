import kotlinx.cinterop.*
import main.kotlin.GithubService
import platform.UIKit.*
import platform.Foundation.*
import platform.CoreData.*

@ExportObjCClass
class TableViewController(aDecoder: NSCoder) : UITableViewController(aDecoder), UITableViewDataSourceProtocol, UITableViewDelegateProtocol, NSFetchedResultsControllerDelegateProtocol {
    private var data: Array<String> = arrayOf("repo1", "repo2", "repo3", "repo4")
    private var githubService: GithubService =  GithubService()

    init {
        NSLog("TableViewController.init")
        githubService.getRepos()
    }

    override fun initWithCoder(aDecoder: NSCoder) = initBy(TableViewController(aDecoder))

    override fun tableView(tableView: UITableView, cellForRowAtIndexPath: NSIndexPath): UITableViewCell {
        val cell = tableView.dequeueReusableCellWithIdentifier("repo", cellForRowAtIndexPath)

        cell.textLabel?.text = data[cellForRowAtIndexPath.row.toInt()]

        return cell
    }

    override fun tableView(tableView: UITableView, numberOfRowsInSection: Long): Long {
        return data.size.toLong()
    }

    override fun numberOfSectionsInTableView(tableView: UITableView): Long {
        return 1
    }
}