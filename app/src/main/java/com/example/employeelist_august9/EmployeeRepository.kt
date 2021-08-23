package com.example.employeelist_august9

import androidx.lifecycle.MutableLiveData

object EmployeeRepository {

    val employeeList = mutableListOf<Employee>()

    var _employeeData = MutableLiveData<List<Employee>>()

    fun addNewEmployee(employee: Employee) {
        employeeList.add(employee)

        _employeeData.value = employeeList
    }

    fun deleteEmployee(employee: Employee) {
        employeeList.remove(employee)

        _employeeData.value = employeeList
    }
}