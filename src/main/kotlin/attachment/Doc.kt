package attachment

data class Doc(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val size: Int,
    val ext: String,
    val url: String,
    val date: Int,
    val type: Int,
    val preview: Preview
)

data class Preview(
    val docPhotoBySize: Array<DocPhoto>,
    val graffiti: Graffiti,
    val audioMessage: AudioMessage
)

data class AudioMessage(
    val duration: Int,
    val waveform: Array<Int>,
    val linkOgg: String,
    val linkMp3: String
)

data class Graffiti(
    val src: String,
    val width: Int,
    val height: Int
)

data class DocPhoto(
    val src: String,
    val width: Int,
    val height: Int,
    val type: String
)
