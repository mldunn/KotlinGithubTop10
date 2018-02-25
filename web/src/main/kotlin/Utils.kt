import kotlinx.html.*

fun HtmlBlockTag.render(repo: Repo) {
    div {
        +"Title: "
        b {
            +repo.title
        }
        p {
            img {
                width = "16"
                height = "16"
                src = "https://raw.githubusercontent.com/okmr-d/okmr-d.github.io/master/img/DOFavoriteButton/flatIconImage.png"
            }
            +" Stars: "
            b {
                +repo.stars.toString()
            }
        }
        p {
            img {
                width = "16"
                height = "16"
                src = "http://www.allcodingworld.com/media/github/fork-icon.png"
            }
            +" Forks: "
            b {
                +repo.forks.toString()
            }
        }
        +"-----------------------------------------------------------------"
    }
}