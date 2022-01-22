package com.dicoding.submission_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailUser : AppCompatActivity() {

    lateinit var mShare : Button
    companion object {
        const val EXTRA_USER = "extra_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_user)

        val actionBar = supportActionBar
        actionBar?.title = "User Detail"

        val tvImageDetail: ImageView = findViewById(R.id.detail_avatar)
        val tvUser: TextView = findViewById(R.id.detail_name)
        val tvUsername: TextView = findViewById(R.id.detail_username)
        val tvLocation: TextView = findViewById(R.id.detail_location)
        val tvFollowers: TextView = findViewById(R.id.detail_followers)
        val tvFollowing: TextView = findViewById(R.id.detail_following)
        val tvCompany: TextView = findViewById(R.id.detail_company)
        val tvRepository: TextView = findViewById(R.id.detail_repository)

        val user = intent.getParcelableExtra<User>(EXTRA_USER)
        Glide.with(this)
            .load(user?.avatar)
            .apply(RequestOptions())
            .into(tvImageDetail)
        tvUser.text = user?.name
        tvLocation.text = user?.location
        tvUsername.text = user?.username
        tvFollowers.text = user?.followers
        tvFollowing.text = user?.following
        tvCompany.text = user?.company
        tvRepository.text = user?.repository

        mShare = findViewById(R.id.btnShare)
        mShare.setOnClickListener{
            val intent = Intent(Intent.ACTION_SEND)
            val shareBody = "Content"
            intent.type = "type/plain"
            intent.putExtra(Intent.EXTRA_SUBJECT, shareBody)
            startActivity(Intent.createChooser(intent, "Mengirim menggunakan ..."))
        }
    }
}