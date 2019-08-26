package com.don.bottomsheetonfragment.mdl

import com.google.gson.annotations.SerializedName

data class MdlStick(

    @field:SerializedName("data")
    val data: List<DataItem>? = null
)