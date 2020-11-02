package com.project.cleanarchitecturesample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.GONE
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.project.cleanarchitecturesample.databinding.ActivityMainBinding
import com.project.cleanarchitecturesample.view.HeroViewModel
import com.project.cleanarchitecturesample.view.PostViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private lateinit var activityPostsBinding: ActivityMainBinding
    private var mAdapter: PostsAdapter? = null
    private val viewModel by viewModel<PostViewModel>()
    private val heroViewModal by viewModel<HeroViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
        getPost()
        getHeroLiveData()
    }

    private fun getHeroLiveData() {
        heroViewModal.heroLiveData.observeForever {
            if (!it.isNullOrEmpty()) {
                println(it)
            }
        }
    }

    private fun initViews() {
        activityPostsBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mAdapter = PostsAdapter()
        activityPostsBinding.postsRecyclerView.adapter = mAdapter
    }

    private fun getPost() {
        // viewModel.getPosts()
        viewModel.postsData.observeForever {
            if (it != null) {
                mAdapter?.mPostList = it
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
