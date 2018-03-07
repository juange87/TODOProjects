package com.juange.todoprojects.view.adapter

import android.support.v7.util.DiffUtil
import android.support.v7.util.ListUpdateCallback
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.juange.todoprojects.R
import com.juange.todoprojects.domain.project.model.Project

class ProjectAdapter(
        private val dataSet: MutableList<Project>,
        private val onClick: (project: Project) -> Unit
) : RecyclerView.Adapter<ProjectViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ProjectViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.project_row, parent, false)
        return ProjectViewHolder(v, onClick)
    }

    override fun onBindViewHolder(holder: ProjectViewHolder?, position: Int) {
        val project = dataSet[position]
        holder?.bind(project)
    }

    override fun getItemCount(): Int = dataSet.size

    fun notifyChanges(newList: List<Project>) {
        if (dataSet.isEmpty()) {
            dataSet.addAll(newList)
            notifyDataSetChanged()
        } else {
            val diffCallback = ProjectDiffUtilCallback(dataSet, newList)
            val diffResult = DiffUtil.calculateDiff(diffCallback)

            dataSet.clear()
            dataSet.addAll(newList)

            diffResult.dispatchUpdatesTo(object : ListUpdateCallback {
                override fun onInserted(position: Int, count: Int) {
                    notifyItemRangeInserted(position, count)
                }

                override fun onRemoved(position: Int, count: Int) {
                    notifyItemRangeRemoved(position, count)
                }

                override fun onMoved(fromPosition: Int, toPosition: Int) {
                    notifyItemMoved(fromPosition, toPosition)
                }

                override fun onChanged(position: Int, count: Int, payload: Any?) {
                    notifyItemRangeChanged(position, count, payload)
                }
            })
        }
    }
}