package com.example.employeelist_august9

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class EmployeeViewModel(private val repo: EmployeeRepository) : ViewModel() {


    val employeeData: LiveData<List<Employee>> = repo._employeeData

    fun addEmployee(employee: Employee) {
        repo.addNewEmployee(employee)
    }

    fun deleteEmployee(employee: Employee) {
        repo.deleteEmployee(employee)
    }

    class Factory(
        private val repo: EmployeeRepository
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(EmployeeViewModel::class.java)) {
                return EmployeeViewModel(repo) as T
            } else {
                throw IllegalArgumentException("Cannot create instance of view model.")
            }
        }
    }
}