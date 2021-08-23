package com.example.employeelist_august9

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.employeelist_august9.databinding.ListItemEmployeeBinding

class EmployeeAdapter(private val listener: (employee: Employee) -> Unit) :
    RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder>() {

    private var employees = mutableListOf<Employee>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        return EmployeeViewHolder(
            ListItemEmployeeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        ).also { viewHolder ->
            viewHolder.itemView.setOnClickListener { listener.invoke(employees[viewHolder.adapterPosition]) }
        }
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        holder.bind(employees[position])
    }

    override fun getItemCount(): Int {
        return employees.size
    }

    fun setData(employees: List<Employee>) {
        this.employees.clear()
        this.employees.addAll(employees)
        notifyDataSetChanged()
    }

    class EmployeeViewHolder(private val binding: ListItemEmployeeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(employee: Employee) {
            with(binding) {
                name.text = employee.name
                age.text = employee.age.toString()
                occupation.text = employee.occupation
                number.text = employee.phoneNumber
            }
        }
    }
}