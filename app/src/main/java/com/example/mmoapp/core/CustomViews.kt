package com.example.mmoapp.core

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.example.mmoapp.presentation.TextMapper

class CustomTextView : AppCompatTextView, TextMapper {
    //region constructors
    constructor(context: Context) : super(
        context
    )

    constructor(context: Context, attrs: AttributeSet) : super(
        context, attrs
    )

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context, attrs, defStyleAttr
    )

    override fun map(data: String) = setText(data)
    //endregion
}

class CustomTextViewDescription : AppCompatTextView, TextMapper.DescriptionTextView {
    //region constructors
    constructor(context: Context) : super(
        context
    )

    constructor(context: Context, attrs: AttributeSet) : super(
        context, attrs
    )

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context, attrs, defStyleAttr
    )

    override fun map(data: String) = setText(data)
    //endregion
}

class CustomTextViewDate : AppCompatTextView, TextMapper.DateTextView {
    //region constructors
    constructor(context: Context) : super(
        context
    )

    constructor(context: Context, attrs: AttributeSet) : super(
        context, attrs
    )

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context, attrs, defStyleAttr
    )

    override fun map(data: String) = setText(data)
    //endregion
}

class CustomTextViewDeveloper : AppCompatTextView, TextMapper.DeveloperTextView {
    //region constructors
    constructor(context: Context) : super(
        context
    )

    constructor(context: Context, attrs: AttributeSet) : super(
        context, attrs
    )

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context, attrs, defStyleAttr
    )

    override fun map(data: String) = setText(data)
    //endregion
}

class CustomTextViewGenre : AppCompatTextView, TextMapper.GenreTextView {
    //region constructors
    constructor(context: Context) : super(
        context
    )

    constructor(context: Context, attrs: AttributeSet) : super(
        context, attrs
    )

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context, attrs, defStyleAttr
    )

    override fun map(data: String) = setText(data)
    //endregion
}

class CustomTextViewPlatform : AppCompatTextView, TextMapper.PlatformTextView {
    //region constructors
    constructor(context: Context) : super(
        context
    )

    constructor(context: Context, attrs: AttributeSet) : super(
        context, attrs
    )

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context, attrs, defStyleAttr
    )

    override fun map(data: String) = setText(data)
    //endregion
}

class CustomTextViewTitle : AppCompatTextView, TextMapper.TitleTextView {
    //region constructors
    constructor(context: Context) : super(
        context
    )

    constructor(context: Context, attrs: AttributeSet) : super(
        context, attrs
    )

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context, attrs, defStyleAttr
    )

    override fun map(data: String) = setText(data)
    //endregion
}

