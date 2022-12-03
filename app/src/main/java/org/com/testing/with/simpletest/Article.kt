package org.com.testing.with.simpletest

import androidx.databinding.BaseObservable

data class Article(
    var imageURL: String,
    var title: String? = null,
    var content: String? = null)