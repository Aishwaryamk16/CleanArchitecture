package com.project.cleanarchitecturesample.view

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.project.data.Post
import com.project.domain.model.model.ErrorModel
import com.project.domain.model.usecase.base.GetPostsUseCase
import com.project.domain.model.usecase.base.UseCaseResponse
import kotlinx.coroutines.ExperimentalCoroutinesApi

class PostViewModel constructor(private val getPostsUseCase: GetPostsUseCase) : BaseViewModel() {

    val postsData = MutableLiveData<List<Post>>()
    val showProgressbar = MutableLiveData<Boolean>()
    val messageData = MutableLiveData<String>()

    @ExperimentalCoroutinesApi
    fun getPosts() {
        showProgressbar.value = true
        getPostsUseCase.invoke(null, object : UseCaseResponse<List<Post>> {
            override fun onSuccess(result: List<Post>) {
                Log.i(TAG, "result: $result")
                postsData.value = result
                showProgressbar.value = false
            }

            override fun onError(errorModel: ErrorModel?) {
                messageData.value = errorModel?.message
                showProgressbar.value = false
            }
        })
    }

    companion object {
        private val TAG = PostViewModel::class.java.name
    }
}