package com.project.cleanarchitecturesample.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.project.data.Hero
import com.project.domain.model.model.ErrorModel
import com.project.domain.model.usecase.base.GetHeroUseCase
import com.project.domain.model.usecase.base.UseCaseResponse

class HeroViewModel constructor(private val getHeroUseCase: GetHeroUseCase) : BaseViewModel() {

    private val _heroData = MutableLiveData<List<Hero>>()
    val heroLiveData: LiveData<List<Hero>>
        get() = _heroData

    fun getHeroData(){
        getHeroUseCase.invoke(null, object : UseCaseResponse<List<Hero>> {

            override fun onError(errorModel: ErrorModel?) {
              println(errorModel)
            }

            override fun onSuccess(result: List<Hero>) {
                _heroData.value = result
            }
        })
    }

}