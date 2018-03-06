package com.juange.todoprojects.view.adapter

import android.R
import android.graphics.drawable.Drawable
import android.support.v7.widget.RecyclerView
import android.view.View
import com.juange.todoprojects.domain.project.model.Project
import com.juange.todoprojects.domain.project.model.datePeriodFormatted
import kotlinx.android.synthetic.main.project_row.view.*

class ProjectViewHolder(v: View, private val onClick: (project: Project) -> Unit) : RecyclerView.ViewHolder(v) {

    fun bind(project: Project) {
        itemView.project_name.text = project.name
        itemView.company.text = project.company.name
        itemView.period.text = project.datePeriodFormatted()
        itemView.description.text = project.description

        val drawableStarred: Drawable = if (project.starred) {
            itemView.context.resources.getDrawable(R.drawable.star_big_on, null)
        } else {
            itemView.context.resources.getDrawable(R.drawable.star_big_off, null)
        }
        itemView.starred.setImageDrawable(drawableStarred)

        itemView.setOnClickListener { onClick(project) }
    }
}