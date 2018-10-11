package com.zytech.app.feed

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.zytech.app.R
import com.zytech.app.model.Feed



class FeedAdapter(var context: Context, var feeds: List<Feed>?): RecyclerView.Adapter<FeedAdapter.FeedHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedHolder {
        return FeedHolder(LayoutInflater.from(context).inflate(R.layout.feed_item, parent, false))
    }

    override fun getItemCount(): Int {
        return feeds!!.size
    }

    override fun onBindViewHolder(holder: FeedHolder, position: Int) {
        holder.let {
            holder.tvGroup.text = feeds!![position].group_name
            holder.tvUserName.text = feeds!![position].user_name
            holder.tvTimestamp.text = feeds!![position].timestamp
            holder.tvDescription.text = feeds!![position].description
            holder.tvLike.text = "Like " + feeds!![position].like_count.toString()
            holder.tvComment.text = "Reply " + feeds!![position].comment_count.toString()

            Glide.with(context).load(feeds!![position].user_pic).into(holder.ivUserPic)
            Glide.with(context).load(feeds!![position].image_url).into(holder.ivContentImage)

            if (feeds!![position].liked)
                holder.tvLike.setTextColor(context.resources.getColor(R.color.liked))
            else
                holder.tvLike.setTextColor(context.resources.getColor(android.R.color.black))

            holder.tvLike.setOnClickListener {
                if (feeds!![position].liked)
                    feeds!![position].like_count--
                else
                    feeds!![position].like_count++
                feeds!![position].liked = !feeds!![position].liked
                notifyDataSetChanged()
            }

            if (feeds!![position].comment_count>0){
                holder.rvComments.layoutManager = LinearLayoutManager(context)

                holder.rvComments.post {
                    holder.rvComments.adapter = CommentAdapter(context, feeds!![position].comments)
                }
            }
        }
    }


    inner class FeedHolder(view: View): RecyclerView.ViewHolder(view) {
        val tvGroup: TextView = view.findViewById(R.id.groupName)
        val ivUserPic: ImageView = view.findViewById(R.id.profileImage)
        val tvUserName: TextView = view.findViewById(R.id.userName)
        val tvTimestamp: TextView = view.findViewById(R.id.timestamp)
        val tvDescription: TextView = view.findViewById(R.id.description)
        val ivContentImage: ImageView = view.findViewById(R.id.contentImage)
        val tvLike: TextView = view.findViewById(R.id.tvLike)
        val tvComment: TextView = view.findViewById(R.id.tvComment)
        val rvComments: RecyclerView = view.findViewById(R.id.rvComments)
    }

}