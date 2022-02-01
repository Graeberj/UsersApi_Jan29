package com.example.usersapi_jan29.view.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.usersapi_jan29.databinding.ItemUserBinding
import com.example.usersapi_jan29.model.network.models.Address
import com.example.usersapi_jan29.model.network.models.Company
import com.example.usersapi_jan29.model.network.models.User

class UserAdapter(
    private val userList: List<User>

) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemUserBinding.inflate(inflater, parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(userList[position])
    }

    override fun getItemCount(): Int {
        return userList.size
    }
    class UserViewHolder(
        private val binding: ItemUserBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(user: User) {
            with(binding) {
                idTv.text = user.id.toString()
                nameTv.text = user.name
                usernameTv.text = user.username
                emailTv.text = user.email
                streetTv.text = user.address.street
                suiteTv.text = user.address.suite
                cityTv.text = user.address.city
                zipTv.text = user.address.zipcode
                latTv.text = user.address.geo.lat
                lonTv.text = user.address.geo.lng
                websiteTv.text = user.website
                phoneTv.text = user.phone
                companyTv.text = user.company.name
                catchPhraseTv.text = user.company.catchPhrase
                bsTv.text = user.company.bs
            }
        }
    }

}