package com.periferia.metas_amway.persistence.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "event")
class Event {

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null

    var quantity: Int? = null

    var created: String? = null

    var finished: String? = null
}