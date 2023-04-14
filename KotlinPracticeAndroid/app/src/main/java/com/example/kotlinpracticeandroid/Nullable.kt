package com.example.kotlinpracticeandroid

fun main() {
   val name: String? = "Darshan"
   //name = null
   //println(name.length)
   var age: Int = 21
   //age = null
   var address: String? = null

   val result = if(name != null) name.length else -1

   if (name != null && name.length > 0){
      println("Name is: $name and its length is ${name.length}")
   } else {
      println("String is empty")
   }

   println(name?.length)
   println(address?.length)

}