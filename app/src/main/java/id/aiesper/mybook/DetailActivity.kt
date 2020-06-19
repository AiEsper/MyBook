package id.aiesper.mybook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout)

        val tvTitle: TextView = findViewById(R.id.book_title)
        val tvAuthor: TextView = findViewById(R.id.book_author)
        val tvDesc: TextView = findViewById(R.id.book_desc )
        val tvType: TextView = findViewById(R.id.book_type)
        val tvGenre: TextView = findViewById(R.id.book_genre)
        val imgSetPhoto: ImageView = findViewById(R.id.img_item_photo)
        //val toolbarDetail: Toolbar   = findViewById(R.id.detail_toolbar)
        //val toolbarDetTitle: TextView = findViewById(R.id.toolbar_title)
        //val detailScrollView: ScrollView = findViewById(R.id.detail_scrollView)\

        val tTitle  = intent.getStringExtra(EXTRA_TITLE)
        val tAuthor = intent.getStringExtra(EXTRA_AUTHOR)
        val tDesc = intent.getStringExtra(EXTRA_DESC)
        val tType = intent.getStringExtra(EXTRA_TYPE)
        val tGenre = intent.getStringExtra(EXTRA_GENRE)
        val tImg = intent.getIntExtra(EXTRA_PHOTO,0)

        tvTitle.text = tTitle
        Glide.with(this)
            .load(tImg)
            .apply(RequestOptions())
            .into(imgSetPhoto)
        tvAuthor.text = tAuthor
        tvDesc.text = tDesc
        tvType.text = tType
        tvGenre.text = tGenre

    }

    companion object {
        const val EXTRA_TITLE = "extra_title"
        const val EXTRA_AUTHOR = "extra_author"
        const val EXTRA_DESC = "extra_desc"
        const val EXTRA_TYPE = "extra_type"
        const val EXTRA_GENRE = "extra_genre"
        const val EXTRA_PHOTO = "extra_photo"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}