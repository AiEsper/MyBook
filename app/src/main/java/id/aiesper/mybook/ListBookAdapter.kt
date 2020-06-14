package id.aiesper.mybook

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListBookAdapter(val listBook: ArrayList<Book>) : RecyclerView.Adapter<ListBookAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_cardview, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val book = listBook[position]
        Glide.with(holder.itemView.context)
            .load(book.photo)
            .apply(RequestOptions().override(55, 55))
            .into(holder.imgPhoto)
        holder.tvTitle.text = book.title
        holder.tvDesc.text = book.desc

        val mContext = holder.itemView.context

        holder.itemView.setOnClickListener {
            val moveDetail = Intent(mContext, detail_book::class.java)
            moveDetail.putExtra(detail_book.EXTRA_TITLE, book.title)
            moveDetail.putExtra(detail_book.EXTRA_AUTHOR, book.author)
            moveDetail.putExtra(detail_book.EXTRA_DESC, book.desc)
            moveDetail.putExtra(detail_book.EXTRA_PHOTO, book.photo)
            moveDetail.putExtra(detail_book.EXTRA_TYPE, book.type)
            moveDetail.putExtra(detail_book.EXTRA_GENRE, book.genre)
            mContext.startActivity(moveDetail)
        }

    }

    override fun getItemCount(): Int {
        return listBook.size
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvTitle: TextView = itemView.findViewById(R.id.book_title)
        var tvDesc: TextView = itemView.findViewById(R.id.book_desc)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }
}