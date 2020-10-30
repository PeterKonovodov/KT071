package attachment

sealed class Attachment {
    abstract val type: String
}


data class AttachmentPhoto(
    override val type: String = "photo",
    val attachmentContent : Photo
): Attachment()

data class AttachmentVideo(
    override val type: String = "video",
    val attachmentContent: Video
): Attachment()

data class AttachmentAudio(
    override val type: String = "audio",
    val attachmentContent: Audio
): Attachment()

data class AttachmentDoc(
    override val type: String = "doc",
    val attachmentContent: Doc
): Attachment()

data class AttachmentLink(
    override val type: String = "link",
    val attachmentContent: Link
): Attachment()


