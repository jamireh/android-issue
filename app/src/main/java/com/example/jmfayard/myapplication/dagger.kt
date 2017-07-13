package com.example.jmfayard.myapplication

import dagger.Component
import dagger.Module
import dagger.Provides

@Component(modules = arrayOf(DaggerModule::class))
interface Component {
    fun hello() : String
    fun hellos() : List<String>
}

@Module class DaggerModule {
    @Provides fun providesString() : String = "Hello"

    @Provides fun providesStrings() : List<String> = listOf("Hello", "World")
}



fun dagger() {
    val component = DaggerComponent.create()
    component.hello()
}