package com.example.mmoapp.presentation

import com.example.mmoapp.core.Abstract
import com.example.mmoapp.core.ComparableTextMapper
import com.example.mmoapp.core.Matcher

sealed class GameUi : ComparableTextMapper<GameUi>, Matcher<Int> {
    override fun matches(arg: Int) = false
    override fun map(mapper: TextMapper) = Unit
    override fun map(mapper: TextMapper.TitleTextView) = Unit
    override fun map(mapper: TextMapper.DescriptionTextView) = Unit
    override fun map(mapper: TextMapper.GenreTextView) = Unit
    override fun map(mapper: TextMapper.PlatformTextView) = Unit
    override fun map(mapper: TextMapper.DeveloperTextView) = Unit
    override fun map(mapper: TextMapper.DateTextView) = Unit

    //todo for diffuitil
    object Empty : GameUi()
    object Progress : GameUi()

    data class Base(
        val id: Int,
        val title: String,
        val description: String,
        val genre: String,
        val platform: String,
        val developer: String,
        val releaseDate: String
    ) : GameUi() {
        override fun map(mapper: TextMapper.TitleTextView) = mapper.map(title)
        override fun map(mapper: TextMapper.DescriptionTextView) = mapper.map(description)
        override fun map(mapper: TextMapper.GenreTextView) = mapper.map(genre)
        override fun map(mapper: TextMapper.PlatformTextView) = mapper.map(platform)
        override fun map(mapper: TextMapper.DeveloperTextView) = mapper.map(developer)
        override fun map(mapper: TextMapper.DateTextView) = mapper.map(releaseDate)

        override fun matches(arg: Int) = arg == id
        override fun same(item: GameUi) = item is Base && id == item.id
        override fun sameContent(item: GameUi) = if (item is Base) {
            title == item.title
        } else false
    }

    data class Fail(private val message: String) : GameUi() {
        override fun map(mapper: TextMapper) = mapper.map(message)


        override fun sameContent(item: GameUi) = if (item is Fail) {
            message == item.message
        } else false

        override fun same(item: GameUi) = sameContent(item)
    }
}

interface TextMapper : Abstract.Mapper.Data<String, Unit> {
    interface TitleTextView : Abstract.Mapper.Data<String, Unit>
    interface DescriptionTextView : Abstract.Mapper.Data<String, Unit>
    interface GenreTextView : Abstract.Mapper.Data<String, Unit>
    interface PlatformTextView : Abstract.Mapper.Data<String, Unit>
    interface DeveloperTextView : Abstract.Mapper.Data<String, Unit>
    interface DateTextView : Abstract.Mapper.Data<String, Unit>
}

