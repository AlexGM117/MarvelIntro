package com.example.fintonictest.characters.interfaces

import com.example.fintonictest.domain.client.model.Superhero

interface ItemClickListener {
    fun onItemSelected(get: Superhero)
}