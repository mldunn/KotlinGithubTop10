package model

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class Repo(
        @SerialName("full_name") var title: String,
        @SerialName("stargazers_count") var stars: Int,
        @SerialName("forks") var forks: Int
)