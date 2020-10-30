import attachment.*
import java.time.LocalDateTime
import java.time.ZoneOffset

object WallService {
    val service = WallServiceCore()
}

fun main() {

    val attachment: Attachment = AttachmentLink(
        attachmentContent = Link(
            url = "www.netology.ru", title = "-=Курсы выживания без интернета=-", "", "",
            product = LinkProduct(
                LinkProduct.Price(100500, LinkProduct.Currency(1, "RUP (российский песо)"), text = "цена"),
            )
        )
    )
    WallService.service.add(
        Post(
            date = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC),
            text = "Скоро Армагеддец! Успей апнуть скиллы на кейс тотального блэкаута!",
            attachments = arrayOf(attachment)
        )
    )





    WallService.service.findPostById(WallService.service.getLastPostId())?.let { postPrint(it) }

}


fun postPrint(post: Post) {
    println(post.text)
    for ((index, att) in post.attachments?.withIndex()!!) {
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
}