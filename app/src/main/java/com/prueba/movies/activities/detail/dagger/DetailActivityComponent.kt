package com.prueba.movies.activities.detail.dagger


import com.prueba.movies.activities.detail.DetailActivity
import com.prueba.movies.app.dagger.AppComponent
import dagger.Component

@DetailActivityScope
@Component(modules = arrayOf(DetailActivityModule::class), dependencies = [(AppComponent::class)])
interface DetailActivityComponent {
    fun inject(detailActivity: DetailActivity)

}
