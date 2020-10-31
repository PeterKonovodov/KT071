import attachment.*
import java.time.LocalDateTime
import java.time.ZoneOffset

object WallService : WallServiceCore() {
}

fun main() {

    val attachment: Attachment = AttachmentLink(
        attachmentContent = Link(
            url = "www.netology.ru", title = "-=Курсы выживания без интернета=-", "", "",
            product = LinkProduct(
                LinkProduct.Price(100500, LinkProduct.Currency(1, "RUP (российских песо)"), text = "цена"),
            )
        )
    )
    WallService.add(
        Post(
            date = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC),
            text = "Скоро Армагеддец!\nУспей апнуть скиллы на кейс тотального блэкаута!",
            attachments = arrayOf(attachment)
        )
    )

    WallService.createComment(
        Comment(
            replyToComment = WallService.getLastPostId(),
            message = "На дешевку не согласен, плачу 100502!", ownerId = 1, postId = 1
        )
    )
    WallService.createComment(
        Comment(
            replyToComment = WallService.getLastPostId(),
            message = "Кто здесь?", ownerId = 2, postId = 2
        )
    )
    WallService.createComment(
        Comment(
            replyToComment = WallService.getLastPostId(),
            message = "Казино Вулкан - подними бабло!", ownerId = 3, postId = 3
        )
    )
    WallService.createComment(
        Comment(
            replyToComment = WallService.getLastPostId(),
            message = "Достали со своим казином, зарэжу!", ownerId = 2, postId = 4
        )
    )

    WallService.reportComment(3, ReportReason.SPAM)
    WallService.reportComment(4, ReportReason.EXTREMISM)

    WallService.findPostById(WallService.getLastPostId())?.let { postPrint(it) }

}


fun postPrint(post: Post) {
    println(post.text)
    for ((_, att) in post.attachments?.withIndex()!!) {
        when (att) {
            is AttachmentLink -> {
                println(att.attachmentContent.title)
                println("Идите сюда ${att.attachmentContent.url}")
                println(
                    "Невероятные скидки! цена всего ${att.attachmentContent.product?.price?.amount} " +
                            "${att.attachmentContent.product?.price?.currency?.name} !"
                )
            }
            is AttachmentVideo -> println("Смотрите сюда")
            is AttachmentDoc -> println("Читайте сюда")
            is AttachmentPhoto -> println("Смотрите сюда")
            is AttachmentAudio -> println("Слушайте сюда")
        }
    }
    println("copyright ${post.copyright}")

    val commentString = WallService.getPostComments(post)
    if (commentString.isNotEmpty()) {
        println("\nКомментарии:")
        println(commentString)
    }


}