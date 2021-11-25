package com.example.navigationcomposercondatos

sealed class Screen(val route: String) {
    object Home : Screen(route = "home_screen")
    object Second : Screen("second_screen/{nombre}/{autor}/{año}/{descripcion}/{localizacion}/{imagen}"){

        fun passMonu(
            nombre:String,
            autor: String,
            año: Int,
            descripcion: String,
            localizacion: String,
            imagen: String
            ): String {
            return "second_screen/$nombre/$autor/$año/$descripcion/$localizacion/$imagen"
        }
    }
}