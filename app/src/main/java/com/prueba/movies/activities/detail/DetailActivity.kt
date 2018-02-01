package com.prueba.movies.activities.detail

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.prueba.movies.activities.detail.dagger.DaggerDetailActivityComponent
import com.prueba.movies.activities.detail.dagger.DetailActivityModule
import com.prueba.movies.activities.detail.mvp.DetailPresenter
import com.prueba.movies.activities.detail.mvp.DetailView
import com.prueba.movies.app.MoviesApplication
import kotlinx.android.synthetic.main.activity_detail.*
import javax.inject.Inject

class DetailActivity : AppCompatActivity() {

    @Inject
    lateinit var detailView: DetailView
    @Inject
    lateinit var detailPresenter: DetailPresenter
    var id: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerDetailActivityComponent
                .builder()
                .appComponent(MoviesApplication[this].component())
                .detailActivityModule(DetailActivityModule(this))
                .build().inject(this)
        setContentView(detailView)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener {
            finish()
        }

        detailPresenter.onCreate()

    }

    fun getIds(): Int {
        if (intent.extras != null) {
            id = intent.getIntExtra("ID", 0)

        }
        return id
    }


    override fun onDestroy() {
        detailPresenter.onDestroy()
        super.onDestroy()
    }
}
