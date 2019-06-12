package com.don.bottomsheetonfragment

import com.google.gson.annotations.SerializedName

/**
 * Created by gideon on 12,June,2019
 * dunprek@gmail.com
 * Jakarta - Indonesia
 */

data class MdlExample(
    @SerializedName("image") val image: Int,
    @SerializedName("text") val name: String
)