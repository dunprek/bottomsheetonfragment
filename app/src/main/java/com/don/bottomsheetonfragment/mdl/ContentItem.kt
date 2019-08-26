package com.don.bottomsheetonfragment.mdl

import com.google.gson.annotations.SerializedName

data class ContentItem(

	@field:SerializedName("category_name")
	val categoryName: String? = null,

	@field:SerializedName("category_id")
	val categoryId: Int? = null,

	@field:SerializedName("items")
	val items: List<ItemsItem>? = null
)