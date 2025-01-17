package br.com.bernardino.githubsearch.database

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.bernardino.githubsearch.model.Owner
import br.com.bernardino.githubsearch.model.Repository
import br.com.bernardino.githubsearch.model.RepositoryBody
import kotlinx.android.parcel.Parcelize


@Entity(tableName = "repos")
@Parcelize
data class RepositoryDatabase constructor(
    @PrimaryKey
    val id: Int,
    val name: String?,
    val fullName: String??,
    val ownerAvatar : String?,
    val ownerUserFirstName : String?,
    val ownerUserLastName: String?,
    val description: String?,
    val stargazersCount: Int,
    val forksCount: Int
) : Parcelable

fun List<Repository>.asDomainModel(): List<RepositoryDatabase> {
    return map {
        RepositoryDatabase(
            id = it.id,
            name = it.name,
            fullName = it.fullName,
            ownerAvatar = it.owner.avatarUrl,
            ownerUserFirstName = it.owner.login,
            ownerUserLastName = it.owner.login,
            description = it.description,
            stargazersCount = it.stargazersCount,
            forksCount = it.forksCount
        )
    }
}

