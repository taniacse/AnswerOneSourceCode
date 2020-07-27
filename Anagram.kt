package com.example.problemsolving

import org.jetbrains.annotations.TestOnly
import java.util.*
import kotlin.collections.HashMap


fun main() {

    println("Enter the two string for anagram testing ")
    val firstString = readLine()!!
    val secondString = readLine()!!
    print(anagram(firstString, secondString))

}
@TestOnly
fun anagram(firstString: String, secondString: String): String {
    var resultString = ""
    val firstMap = HashMap<Char, Int>()
    val secondMap = HashMap<Char, Int>()
    val firstCharArray = firstString.toLowerCase(Locale.ROOT).toCharArray()
    val secondCharArray = secondString.toLowerCase(Locale.ROOT).toCharArray()

    firstCharArray.forEach {
        firstMap[it] = 0

    }
    secondCharArray.forEach {
        secondMap[it] = 0
    }


    firstMap.forEach { entry ->

        val key = entry.key
        var counter = 0
        firstCharArray.forEach {
            if (key == it) {
                counter++
            }

        }

        firstMap[key] = counter

    }

    secondMap.forEach { entry ->

        val key = entry.key
        var counter = 0
        secondCharArray.forEach {
            if (key == it) {
                counter++
            }

        }

        secondMap[key] = counter

    }


    var counter = 0
    firstMap.forEach { entry ->

        val firstKey = entry.key
        val firstValue = entry.value

        secondMap.forEach {
            val secondKey = it.key
            val secondValue = it.value
            if (firstKey.equals(secondKey, true) && firstValue == secondValue) {

                counter++
            }


        }
    }



    resultString = if (counter == firstMap.size)
        "Anagram"
    else
        "Not Anagram"

    return resultString
}