package com.dicoding.submission_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.submission_1.DetailUser.Companion.EXTRA_USER

class MainActivity : AppCompatActivity() {
    private lateinit var rv_User: RecyclerView
    private val list = ArrayList<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_User = findViewById(R.id.rv_heroes)
        rv_User.setHasFixedSize(true)

        list.addAll(listUsers)
        showRecyclerList()
    }

    private val listUsers: ArrayList<User>
        get() {
            val dataName = resources.getStringArray(R.array.name)
            val dataCompany = resources.getStringArray(R.array.company)
            val dataLocation = resources.getStringArray(R.array.location)
            val dataPhoto = resources.obtainTypedArray(R.array.avatar)
            val dataUsername = resources.getStringArray(R.array.username)
            val dataRepository = resources.getStringArray(R.array.repository)
            val dataFollowers = resources.getStringArray(R.array.followers)
            val dataFollowing = resources.getStringArray(R.array.following)
            val listUser = ArrayList<User>()
            for (i in dataUsername.indices) {
                val user = User(
                    dataName[i], dataCompany[i], dataLocation[i], dataPhoto.getResourceId(i, -1), dataUsername[i], dataRepository[i], dataFollowers[i], dataFollowing[i],
                )
                listUser.add(user)
            }
            return listUser
        }

    private fun showRecyclerList() {
        rv_User.layoutManager = LinearLayoutManager(this)
        val listUserAdapter = ListUserAdapter(list)
        rv_User.adapter = listUserAdapter
        listUserAdapter.setOnItemClickCallback(object : ListUserAdapter.OnItemClickCallback {
            override fun onItemClicked(user: User) {
                startActivity(Intent(this@MainActivity, DetailUser::class.java).putExtra(EXTRA_USER, user))
            }
        })
    }
}