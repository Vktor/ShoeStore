package com.example.myshoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myshoestore.model.Shoe

class ShoeActivityViewModel : ViewModel() {
    private val shoesRepository = ShoeRepository()
    private val _shoeRepository = MutableLiveData<MutableList<Shoe>>()

    val shoeRepository: LiveData<MutableList<Shoe>>
        get() = _shoeRepository

    fun addNewShoe(shoe: Shoe){
        shoesRepository.addNewShoe(shoe)
        _shoeRepository.value = shoesRepository.shoes
    }

    fun addNewId(): Int{
        return shoesRepository.addId()
    }
}

class ShoeRepository {

    val shoes = mutableListOf(
        Shoe(
            1,
            "Jazz",
            "Adidas",
            6.0,
            "A jazz shoe is a type of shoe worn by dancers."
        ),
        Shoe(
            2,
            "Moccasin",
            "Nike",
            8.5,
            "A moccasin is a shoe, made of deerskin or other soft leather"
        )
    )

    fun addNewShoe(shoe: Shoe) {
        shoes.add(shoe)
    }

    fun addId(): Int{
        var id = shoes.count()
        id++
        return id
    }
}