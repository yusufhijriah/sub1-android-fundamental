package com.dicoding.submission_1

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    var name : String,
    var company : String,
    var location: String,
    var avatar : Int,
    var username: String,
    var repository : String,
    var followers : String,
    var following : String,
): Parcelable
