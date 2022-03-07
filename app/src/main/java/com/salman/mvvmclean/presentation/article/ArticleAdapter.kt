package com.salman.mvvmclean.presentation.article

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.salman.mvvmclean.databinding.ArticleListItemBinding
import com.salman.mvvmclean.domain.model.Article

class ArticleAdapter (private val list: List<Article>, private val context: Context) : RecyclerView.Adapter<ArticleAdapter.ArticleHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleHolder {

        val articleItemBinding = ArticleListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArticleHolder(articleItemBinding, context)
    }

    override fun onBindViewHolder(holder: ArticleHolder, position: Int) {
        holder.setData(list.get(position))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ArticleHolder(private val view: ArticleListItemBinding, private val context: Context) : RecyclerView.ViewHolder(view.root) {

        private var article: Article? = null

        fun setData(article: Article) {
            this.article = article
            view.articleListItemTitleTv.text = article.title
            Glide
                .with(context)
                .load(article.imageUrl)
                .centerCrop()
                .into(view.articleListItemImageIv)

        }
    }
}