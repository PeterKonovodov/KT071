open class WallServiceCore {
    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()
    private var reportsForComments = emptyArray<Report>()


    fun add(post: Post): Post {
        posts += if (posts.isEmpty()) post.copy(id = 1)
        else post.copy(id = posts.last().id + 1)
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, currentPost) in posts.withIndex()) {
            if (currentPost.id == post.id) {
                posts[index] = post.copy(ownerId = currentPost.ownerId, date = currentPost.date)
                return true
            }
        }
        return false
    }

    fun getLastPostId(): Int = if (posts.isEmpty()) 0 else posts.last().id

    fun findPostById(id: Int): Post? {
        for ((index, currentPost) in posts.withIndex()) {
            if (currentPost.id == id) {
                return posts[index]
            }
        }
        return null
    }

    fun createComment(comment: Comment) {
        for (currentPost in posts) {
            if (currentPost.id == comment.replyToComment) {
                comments += comment
                return
            }
            throw PostNotFoundException("Post to comment does not exist!")
        }
    }

    fun getPostComments(post: Post): String {
        var commentsString = ""
        for (comment in comments) {
            if (comment.replyToComment == post.id) {
                var reportString = ""
                for (report in reportsForComments) {
                    if (report.commentId == comment.postId) {
                        reportString = " (marked as ${report.reason.toString()})"
                        break
                    }
                }
                commentsString += "- " + comment.message + reportString + "\n"

            }
        }
        return commentsString
    }


    fun reportComment(commentId: Int, reason: ReportReason) {
        for (comment in comments) {
            if (comment.postId == commentId) {
                reportsForComments += Report(comment.postId, reason)
                if (comment.message.isEmpty()) throw WrongReportReasonException("Probably wrong reason to report!")
                return
            }
        }
        throw CommentNotFoundException("Comment id=$commentId does not exist!")
    }
}

class CommentNotFoundException(message: String) : RuntimeException(message)
class PostNotFoundException(message: String) : RuntimeException(message)
class WrongReportReasonException(message: String) : RuntimeException(message)


data class Report(
    val commentId: Int,
    val reason: ReportReason
)

enum class ReportReason {
    SPAM,
    PORN,
    EXTREMISM,
    VIOLENCE,
    NARCOTICS
}

