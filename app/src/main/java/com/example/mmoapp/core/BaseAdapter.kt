package com.example.mmoapp.core

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mmoapp.R
import com.example.mmoapp.presentation.*

abstract class BaseAdapter<E : ComparableTextMapper<E>, T : BaseViewHolder<E>> :
    RecyclerView.Adapter<T>() {
    protected val list = ArrayList<E>()

    fun update(new: List<E>) {
        val diffCallback = DiffUtilCallback(list, new)
        val result = DiffUtil.calculateDiff(diffCallback)
        list.clear()
        list.addAll(new)
        result.dispatchUpdatesTo(this)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: T, position: Int) = holder.bind(list[position])

    protected fun Int.makeView(parent: ViewGroup) =
        LayoutInflater.from(parent.context).inflate(this, parent, false)
}

abstract class BaseViewHolder<E : ComparableTextMapper<E>>(view: View) :
    RecyclerView.ViewHolder(view) {
    open fun bind(item: E) {}


    class FullScreenProgress<E : ComparableTextMapper<E>>(view: View) : BaseViewHolder<E>(view)

    class Fail<E : ComparableTextMapper<E>>(
        view: View,
        private val retry: Retry
    ) : BaseViewHolder<E>(view) {
        private val message = itemView.findViewById<CustomTextView>(R.id.messageTextView)
        private val button = itemView.findViewById<Button>(R.id.tryAgainButton)
        override fun bind(item: E) {
            item.map(message)
            button.setOnClickListener {
                retry.tryAgain()
            }
        }
    }
}

interface ComparableTextMapper<T : ComparableTextMapper<T>> : Abstract.Object<Unit, TextMapper>,
    Comparing<T> {
    fun map(mapper: TextMapper.DescriptionTextView)
    fun map(mapper: TextMapper.TitleTextView)
    fun map(mapper: TextMapper.GenreTextView)
    fun map(mapper: TextMapper.PlatformTextView)
    fun map(mapper: TextMapper.DeveloperTextView)
    fun map(mapper: TextMapper.DateTextView)
}