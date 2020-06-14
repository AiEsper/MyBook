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

class ListBookAdapter(private val listBook: ArrayList<Book>) : RecyclerView.Adapter<ListBookAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_cardview, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listBook.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val book = listBook[position]
        Glide.with(holder.itemView.context)
            .load(book.photo)
            .apply(RequestOptions().override(55, 55))
            .into(holder.imgPhoto)

        holder.tvTitle.text = book.title
        holder.tvAuthor.text = book.author
        holder.tvType.text = book.type

        val mContext = holder.itemView.context

        holder.itemView.setOnClickListener {
            val goToDetail = Intent(holder.itemView.context, DetailActivity::class.java)
            goToDetail.putExtra("position", position)
            holder.itemView.context.startActivity(goToDetail)
        }

    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvTitle: TextView = itemView.findViewById(R.id.book_title)
        val tvAuthor: TextView = itemView.findViewById(R.id.book_author)
        val tvType: TextView = itemView.findViewById(R.id.book_type)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }
}