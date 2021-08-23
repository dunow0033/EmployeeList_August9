package com.example.employeelist_august9

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.employeelist_august9.databinding.FragmentEmployeeListBinding
import com.example.employeelist_august9.databinding.FragmentEmployeeSignUpBinding

class EmployeeListFragment : Fragment() {

    private var _binding: FragmentEmployeeListBinding? = null
    private val binding: FragmentEmployeeListBinding get() = _binding!!

    private val viewModel: EmployeeViewModel by activityViewModels {
        EmployeeViewModel.Factory(EmployeeRepository)
    }

    private val adapter: EmployeeAdapter by lazy {
        EmployeeAdapter(::removeEmployee)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEmployeeListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            employeeRv.apply {
                adapter = this@EmployeeListFragment.adapter
                layoutManager = LinearLayoutManager(requireContext())
            }

            viewModel.employeeData.observe(viewLifecycleOwner) {
                adapter.setData(it)
            }
        }
    }

    private fun removeEmployee(employee: Employee) {
        viewModel.deleteEmployee(employee)
    }
}