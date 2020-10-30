data class Comment(
    val ownerId: Int,
    val postId: Int,
    val fromGroup: Int = 0,
    val message: String,
    val replyToComment: Int,
    val attachments: Array<CommentAttachment>? = null,
    val stickerId: Int = 0,
    val guid: Int = 1

)

data class CommentAttachment(
    val type: String = "nope",
    val ownerId: Int = 0,
    val mediaId: Int = 0
)
