package com.example.fintonictest.domain.client.model.response

import com.example.fintonictest.domain.client.model.Superhero

data class ListResponse(
    val superheroes: List<Superhero>)