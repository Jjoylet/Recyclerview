package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val usersList: List<Person>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = usersList[position]
        holder.txtPhone.text = user.phone
        holder.txtName.text = user.name

        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, user.name, Toast.LENGTH_SHORT).show()
        }

        /*holder.txtName.setOnClickListener {
            val popupMenu = PopupMenu(holder.txtName.context, holder.txtName)
            popupMenu.menuInflater.inflate(R.menu.pop_up_menu, popupMenu.menu)
            popupMenu.setOnMenuItemClickListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.item_delete-> {
                        Toast.makeText(holder.itemView.context, "Deleting", Toast.LENGTH_SHORT).show()
                    }
                }
                true
            }
        }*/
    }

    override fun getItemCount(): Int {
        return usersList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtName: TextView = itemView.findViewById(R.id.txtName)
        val txtPhone: TextView = itemView.findViewById(R.id.txtPhone)
    }

}
