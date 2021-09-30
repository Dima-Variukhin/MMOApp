package com.example.mmoapp.core

interface Matcher<T> {
    fun matches(arg: T): Boolean
}