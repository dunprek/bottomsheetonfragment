package com.don.bottomsheetonfragment.mdl

import com.google.gson.annotations.SerializedName

data class DataItem(

	@field:SerializedName("type")
	val type: Int? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("content")
	val content: List<ContentItem>? = null
)