package com.zytech.app.model

data class Feed(
        var group_id: String,
        var group_name: String,
        var user_id: String,
        var user_pic: String,
        var user_name: String,
        var timestamp: String,
        var description: String,
        var post_type: String,
        var image_url: String,
        var like_count: Int,
        var liked: Boolean,
        var comment_count: Int,
        var comments: List<Comment>
)