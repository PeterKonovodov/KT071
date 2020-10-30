package attachment

data class Photo(
    val id: Int,
    val albumId: Int,
    val ownerId: Int,
    val userId: Int,
    val text: String,
    val date: Long,
    val sizes: Array<PhotoCopy>,
    val width: Int,
    val height: Int
)

data class PhotoCopy(
    val type : String,
    val url: String,
    val width: Int,
    val height: Int
)