package com.example.tp3

import java.io.Serializable

data class Livre(val image:Int, val titre:String, val description:String, val isbn:String, val auteur:String, val url:String, val annee:String, val latitute:Double, val longitude:Double):Serializable {

}