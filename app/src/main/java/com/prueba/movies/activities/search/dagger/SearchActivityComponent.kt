package com.prueba.movies.activities.search.dagger

import com.prueba.movies.activities.search.SearchActivity
import com.prueba.movies.app.dagger.AppComponent
import dagger.Component

@SearchActivityScope
@Component(modules = arrayOf(SearchActivityModule::class), dependencies = [(AppComponent::class)])
interface SearchActivityComponent {
    fun inject(searchActivity: SearchActivity)
}