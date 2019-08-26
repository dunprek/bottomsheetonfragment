package com.don.bottomsheetonfragment.mdl

import com.google.gson.annotations.SerializedName

data class ItemsItem(

	@field:SerializedName("thumbnail")
	val thumbnail: String? = null,

	@field:SerializedName("content_category")
	val contentCategory: String? = null,

	@field:SerializedName("author")
	val author: String? = null,

	@field:SerializedName("status_name")
	val statusName: String? = null,

	@field:SerializedName("link")
	val link: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("status_show")
	val statusShow: Int? = null,

	@field:SerializedName("enclosure_type")
	val enclosureType: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("pubDate")
	val pubDate: String? = null,

	@field:SerializedName("content")
	val content: String? = null,

	@field:SerializedName("enclosure_link")
	val enclosureLink: String? = null,

	@field:SerializedName("enclosure_length")
	val enclosureLength: String? = null,

	@field:SerializedName("guid")
	val guid: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
)