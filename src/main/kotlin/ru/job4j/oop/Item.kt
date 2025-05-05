package ru.job4j.oop


class Item {
    private var id : Int = 0
    private var name : String = ""

    constructor(name: String) {
        this.name = name
    }

    fun setId(id: Int) {
        this.id = id
    }

    fun getId() : Int  = id

    fun getName() :String = name

}
