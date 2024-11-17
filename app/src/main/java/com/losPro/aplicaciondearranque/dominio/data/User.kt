package com.losPro.aplicaciondearranque.dominio.data

data class User(
   val id: Long,
   val nickName: String,
   val password: String,
   val name: String,
   val surname: String,
   var money: Double,
   val createdDate: String

)
