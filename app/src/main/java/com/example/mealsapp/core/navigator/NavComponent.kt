package com.example.mealsapp.core.navigator

import dagger.Component

@Component
interface NavComponent {
    fun navigation(): Navigator
}