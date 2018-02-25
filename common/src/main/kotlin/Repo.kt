import kotlinx.serialization.Serializable

@Serializable
data class Repo(var title: String, var stars: Int, var forks: Int)