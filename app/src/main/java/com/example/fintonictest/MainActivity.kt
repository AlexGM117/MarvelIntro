package com.example.fintonictest

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(), MainContract.View {

    @Inject
    lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.layoutManager = LinearLayoutManager(this)
        presenter.bind(this)
        presenter.getCharacters()
    }

    override fun injectDependencies(application: MarvelApplication, component: ApplicationComponent) {
        component.inject(this)
    }

    override fun setData2Adapter(response: List<Superhero>) {
        recyclerView.adapter = RecyclerAdapter(response)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unBind()
    }
}