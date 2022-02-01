package com.example.usersapi_jan29.viewModel

import androidx.lifecycle.*
import com.example.usersapi_jan29.model.network.models.User
import com.example.usersapi_jan29.model.repository.UserRepository
import kotlinx.coroutines.launch
import java.lang.RuntimeException

class UserViewModel (   private val usersRepository: UserRepository
): ViewModel() {

    private var _users: MutableLiveData<List<User>?> = MutableLiveData()
    val users: LiveData<List<User>?> = _users

    init {
        getUsers()
    }

    private fun getUsers() {
        viewModelScope.launch {
            val response = usersRepository.getUsers()
            _users.postValue(response)
        }
    }

    class Factory(
        private val usersRepository: UserRepository
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
                return UserViewModel(usersRepository) as T
            } else {
                throw RuntimeException("Could not create instance of UsersViewModel")
            }
        }

    }

}