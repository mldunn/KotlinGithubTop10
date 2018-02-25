import kotlinx.serialization.Serializable

@Serializable
class Repo(val title: String, val starts: Int, val forks: Int) {
}