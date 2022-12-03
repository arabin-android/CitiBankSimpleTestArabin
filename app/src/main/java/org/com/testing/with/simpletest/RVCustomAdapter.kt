package org.com.testing.with.simpletest

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import org.com.testing.with.simpletest.databinding.CardViewItemBinding

/**
 * TODO: Implement the Adapter that will populate a RecyclerView using the information generated in ViewModel
 * */

class RVCustomAdapter(private val items : List<Article>) : RecyclerView.Adapter<RVCustomAdapter.RViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RViewHolder {
        return RViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.card_view_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RViewHolder, position: Int) {
        return holder.setDetails(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class RViewHolder(private val binding: CardViewItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun setDetails(item: Article){
            binding.model = item
            Picasso.get().load(item.imageURL).into(binding.mImageViewCardViewItem)
            binding.executePendingBindings()
        }

    }




}