package com.geektech.newsapp.di

import com.geektech.newsapp.data.repositories.EverythingNewsRepository
import com.geektech.newsapp.ui.fragments.EverythingNewsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val dataModule = module {

    factory {
        EverythingNewsRepository(get())
    }

    viewModel {
        EverythingNewsViewModel(get())
    }
}
