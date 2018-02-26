package model

import kotlinx.serialization.Serializable

/**
 * Created by radiKal on 26-Feb-18.
 */
@Serializable
class ReposResponse(var items: List<Repo>)