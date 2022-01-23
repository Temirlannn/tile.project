package com.itacademy.myapplication.models

import java.io.Serializable

class Model(
    var short_descriotion: String,
    var detali_description : String,
    ///////////////////////
    var name: String,
    var startDate: String,
    var endDate: String,
    var userNotes: String,
    ////////////
    ) : Serializable
