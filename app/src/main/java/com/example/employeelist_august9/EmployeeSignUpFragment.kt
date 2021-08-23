package com.example.employeelist_august9

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.employeelist_august9.databinding.FragmentEmployeeSignUpBinding

class EmployeeSignUpFragment : Fragment() {

    private var _binding: FragmentEmployeeSignUpBinding? = null
    private val binding: FragmentEmployeeSignUpBinding get() = _binding!!

    private val viewModel: EmployeeViewModel by activityViewModels {
        EmployeeViewModel.Factory(EmployeeRepository())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEmployeeSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            nextBtn.setOnClickListener {
                val employee = Employee(
                    name.text.toString(),
                    age.text.toString().toInt(),
                    occupation.text.toString(),
                    number.text.toString()
                )

                viewModel.addEmployee(employee)
            }
        }
    }
}