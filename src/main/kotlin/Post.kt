import attachment.Attachment

data class Post(
        val id: Int = 0,
        val ownerId: Int = 0,
        val fromId: Int = 0,
        val createdBy: Int? = null,
        val date: Long = 0,
        val text: String = "No text",
        val replyOwnerId: Int? = null,
        val replyPostId: Int? = null,
        val friendsOnly: Boolean = false,
        val comments: Comments? = null,
        val copyright: String = "ru.netology (c)",
        val likes: Likes = Likes(),
        val reposts: Reposts = Reposts(),
        val views: Views = Views(),
        val postType: String = "post",
        val postSource: PostSource? = null,
        val attachments: Array<Attachment>? = null,
        val geo: Geo? = null,
        val signerId: Int? = null,
        val copyHistory: ArrayList<Post>? = null,
        val canPin: Boolean = false,
        val canDelete: Boolean = true,
        val canEdit: Boolean = true,
        val isPinned: Boolean = false,
        val markedAsAds: Boolean = false,
        val isFavorite: Boolean = false,
        val postponedId: Int = 0
)

data class PostSource(
        val type: String = "",
        val platform: String = "",
        val data: String = "",
        val url: String = ""
)


data class Geo(
        val type: String = "",
        val coordinates: String = "",
        val place: Place = Place()
)

data class Place(
        val id: Int = 0,
        val title: String = "",
        val latitude: Int = 0,
        val longitude: Int = 0,
        val created: Int = 0,
        val icon: String = "",
        val checkins: Int = 0,
        val updated: Int = 0,
        val type: Int = 0,
        val country: Int = 0,
        val city: Int = 0,
        val address: String = ""
)

data class Views(
        val count: Int = 0
)

data class Likes(
        val count: Int = 0,
        val userLikes: Boolean = true,
        val canLike: Boolean = true,
        val canPublish: Boolean = true
)

data class Reposts(
        val count: Int = 0,
        val userReposted: Boolean = false
)

data class Comments(
        val count: Int = 0,
        val canPost: Boolean = true,
        val groupsCanPost: Boolean = true,
        val canClose: Boolean = false,
        val canOpen: Boolean = true
)
