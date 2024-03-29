package com.example.fintonictest.characters

import com.example.fintonictest.base.BasePresenter
import com.example.fintonictest.domain.manager.ApiRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainPresenter(val repository: ApiRepository) : BasePresenter<MainContract.View>(),
    MainContract.Presenter {

//    @Inject
//    lateinit var repository: ApiRepository

    override fun getCharacters() {
        GlobalScope.launch(Dispatchers.Main) {
            val data = repository.makeRequest()
            if (data != null){
                if (!data.superheroes.isNullOrEmpty()){
                    view?.setData2Adapter(data.superheroes)
                }
            } else {
                view?.showErrorDialog("Ocurrio un error al obtener los datos")
            }
        }
    }

    override fun bind(view: MainContract.View) {
        super.bind(view)
    }
}