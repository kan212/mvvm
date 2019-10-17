package com.ihandy.mvvm.inject

interface HelloRepository{
    fun hello() : String
}

class HelloRepositoryImpl : HelloRepository{
    override fun hello(): String {
        return "hello kotlin"
    }
}
