package attachment

data class Video(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val description: String,
    val duration: Int,
    val image: Array<Image>,
    val firstFrame: Array<FirstFrame>,
    val date: Long,
    val addingDate: Long,
    val views: Int,
    val localViews: Int,
    val comments: Int,
    val player: String,
    val platform: String,
    val canEdit: Boolean,
    val canAdd: Boolean,
    val isPrivate: Boolean,
    val accessKey: String,
    val processing: Boolean,
    val isFavorite: Boolean,
    val canComment: Boolean,
    val canLike: Boolean,
    val canRepost: Boolean,
    val canSubscribe: Boolean,
    val canAddToFaves: Boolean,
    val canAttachLink: Boolean,
    val width: Int,
    val height: Int,
    val userId: Int,
    val converting: Boolean,
    val added: Boolean,
    val isSubscribed: Boolean,
    val repeat: Boolean,
    val type: String,
    val balance: Int,
    val liveStatus: String,
    val live: Boolean,
    val upcoming: Boolean,
    val spectators: Int,
    val likes: LikesForVideo,
    val reposts: RepostsForVideo
)

data class LikesForVideo(
    val count: Int,
    val userLikes: Boolean
)

data class RepostsForVideo(
    val count: Int,
    val wallCount: Int,
    val mailCount: Int,
    val userReposted: Boolean
)

data class Image(
    val height: Int = 0,
    val width: Int = 0,
    val url: String = "",
    val withPadding: Boolean
)

data class FirstFrame(
    val height: Int = 0,
    val width: Int = 0,
    val url: String = "",
)