package id.aiesper.mybook

data class Book(
    var title: String = "",
    var author: String = "",
    var type: String = "",
    var desc: String = "",
    val genre: String = "",
    var photo: Int = 0
)