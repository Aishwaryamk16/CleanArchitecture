package com.project.cleanarchitecturesample.di.module

import com.project.cleanarchitecturesample.view.HeroViewModel
import com.project.cleanarchitecturesample.view.PostViewModel
import com.project.data.di.module.*
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


val PostModule = module {

    viewModel { PostViewModel(get()) }

    //Error- No be
    viewModel { HeroViewModel(get()) }


    //inside network  module its declared
    single { createGetPostsUseCase(get(), createApiErrorHandle()) }

    single { createGetHeroUseCase(get(), createApiErrorHandle()) }

    // single instance of PostsRepository
    single { createPostRepository(get()) }

    single { createHeroRepository(get()) }
}

