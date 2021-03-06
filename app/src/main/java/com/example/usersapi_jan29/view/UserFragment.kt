package com.example.usersapi_jan29.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.usersapi_jan29.databinding.FragmentUserBinding
import com.example.usersapi_jan29.model.network.ApiManager
import com.example.usersapi_jan29.model.network.models.User
import com.example.usersapi_jan29.model.repository.UserRepository
import com.example.usersapi_jan29.view.adapter.UserAdapter
import com.example.usersapi_jan29.viewModel.UserViewModel

class UserFragment: Fragment() {

    private var _binding: FragmentUserBinding? = null
    private val binding: FragmentUserBinding get() = _binding!!

    private val viewModel: UserViewModel by activityViewModels {
        UserViewModel.Factory(UserRepository(ApiManager()))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            viewModel.users.observe(viewLifecycleOwner){user ->
                userRv.apply {
                    adapter = user?.let { UserAdapter(it) }
                    layoutManager =
                        LinearLayoutManager(requireContext())
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}