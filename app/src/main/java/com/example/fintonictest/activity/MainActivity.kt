package com.example.fintonictest.activity

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fintonictest.*
import com.example.fintonictest.base.BaseActivity
import com.example.fintonictest.characters.CharacterInfoFragment
import com.example.fintonictest.characters.MainContract
import com.example.fintonictest.characters.adapters.RecyclerAdapter
import com.example.fintonictest.characters.interfaces.ItemClickListener
import com.example.fintonictest.domain.client.model.Superhero
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(),
    MainContract.View, ItemClickListener {

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
        recyclerView.adapter =
            RecyclerAdapter(response, this)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unBind()
    }

    override fun onItemSelected(get: Superhero) {
//        Toast.makeText(this, "${get.name} clicked", Toast.LENGTH_SHORT).show()
        val fragment = CharacterInfoFragment(get)
        supportFragmentManager.beginTransaction().replace(main_container.id, fragment)
            .addToBackStack(null).commit()
    }
}