package com.juange.todoprojects.view.adapter.task

import android.support.v7.widget.RecyclerView
import android.view.View
import com.juange.todoprojects.domain.task.model.Task
import com.juange.todoprojects.domain.task.model.dueDateFormatted
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.task_row.view.*

class TaskViewHolder(v: View) : RecyclerView.ViewHolder(v) {

    fun bind(task: Task) {
        itemView.task_name.text = task.content
        itemView.creator.text = "${task.creatorFirstName} ${task.creatorLastName}"

        Picasso.with(itemView.context)
                .load(task.creatorAvatarUrl)
                .into(itemView.avatar)

        val dueDateFormatted = task.dueDateFormatted()
        if (!dueDateFormatted.isEmpty()) {
            itemView.due_date.visibility = View.VISIBLE
            itemView.due_date.text = dueDateFormatted
        } else {
            itemView.due_date.visibility = View.GONE
        }



//        val context = itemView.context
//        Glide.with(context)
//                .load(task.creatorAvatarUrl)
//                .into(itemView.avatar)
//        itemView.project_name.text = project.name
//        itemView.company.text = project.company.name
//        itemView.period.text = project.datePeriodFormatted()
//        itemView.description.text = project.description
//
//        val drawableStarred: Drawable = if (project.starred) {
//            itemView.context.resources.getDrawable(R.drawable.star_big_on, null)
//        } else {
//            itemView.context.resources.getDrawable(R.drawable.star_big_off, null)
//        }
//        itemView.starred.setImageDrawable(drawableStarred)
    }
}