package com.example.mmoapp.presentation

import android.view.View
import android.view.ViewGroup
import com.example.mmoapp.R
import com.example.mmoapp.core.*


class GameListAdapter(
    private val retry: Retry,
) : BaseAdapter<GameUi, BaseViewHolder<GameUi>>() {

    abstract class GamesViewHolder(view: View) : BaseViewHolder<GameUi>(view) {
        class Base(view: View) : GamesViewHolder(view) {
            val title: CustomTextViewTitle = itemView.findViewById(R.id.title)
            val description: CustomTextViewDescription = itemView.findViewById(R.id.description)
            val genre: CustomTextViewGenre = itemView.findViewById(R.id.genre)
            val platform: CustomTextViewPlatform = itemView.findViewById(R.id.platform)
            val developer: CustomTextViewDeveloper = itemView.findViewById(R.id.developer)
            val releaseDate: CustomTextViewDate = itemView.findViewById(R.id.data)
            override fun bind(item: GameUi) {
                item.map(title)
                item.map(description)
                item.map(genre)
                item.map(platform)
                item.map(developer)
                item.map(releaseDate)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<GameUi> =
        when (viewType) {
            0 -> GamesViewHolder.Base(R.layout.game_layout.makeView(parent))
            1 -> BaseViewHolder.Fail(R.layout.fail_fullscreen.makeView(parent), retry)
            else -> BaseViewHolder.FullScreenProgress(R.layout.progress_fullscreen.makeView(parent))
        }

    override fun getItemViewType(position: Int) = when (list[position]) {
        is GameUi.Base -> 0
        is GameUi.Fail -> 1
        is GameUi.Progress -> 2
        else -> 1
    }
}