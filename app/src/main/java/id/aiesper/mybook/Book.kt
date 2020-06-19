package id.aiesper.mybook

data class Book(
    var title: String = "",
    var author: String = "",
    var desc: String = "",
    var type: String = "",
    val genre: String = "",
    var photo: Int = 0
)