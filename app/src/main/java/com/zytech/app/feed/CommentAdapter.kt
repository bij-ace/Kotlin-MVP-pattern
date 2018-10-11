package com.zytech.app.feed

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.zytech.app.R
import com.zytech.app.model.Comment

class CommentAdapter(var context: Context, var comments: List<Comment>?): RecyclerView.Adapter<CommentAdapter.CommentHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentHolder {
        return CommentHolder(LayoutInflater.from(context).inflate(R.layout.comment_item, parent, false))
    }

    override fun getItemCount() = comments!!.size

    override fun onBindViewHolder(holder: CommentHolder, position: Int) {
        holder.let {
            holder.tvName.text = comments!![position].user_name + ": "
            holder.tvComment.text = comments!![position].comment
        }
    }


    inner class CommentHolder(view: View): RecyclerView.ViewHolder(view) {
        val tvName: TextView = view.findViewById(R.id.tvName)
        val tvComment: TextView = view.findViewById(R.id.tvComment)
    }

}