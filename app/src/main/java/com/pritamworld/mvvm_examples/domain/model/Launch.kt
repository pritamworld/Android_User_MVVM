package com.pritamworld.mvvm_examples.domain.model

data class Launch(

    val missionName: String,

    val launchDate: String,

    val siteName: String,

    val patchImage: String?,

    val articleLink: String?,

    val videoLink: String?,

    val rocketName: String
)