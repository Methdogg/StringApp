package com.emirhan.stringapp

class Main {
    companion object {

        private var string = "abbcccdeefffkkkkkmmmm"

        @JvmStatic
        fun main(args: Array<String>) {
            function(2)
            function(3)
            function(4)
            function(5)
        }

        private fun function(n: Int) {
            val stringBuilder = StringBuilder(string)

            var repeatingIndex = 0
            var repeatingCharCounter = 0
            var repeatingChar = 'a'

            string.forEachIndexed { index, char ->
                if (repeatingChar != char) {
                    calculate(
                        index = n,
                        repeatingCharCounter = repeatingCharCounter,
                        repeatingIndex = repeatingIndex,
                        stringBuilder = stringBuilder
                    )

                    repeatingIndex = index
                    repeatingCharCounter = 0
                }

                repeatingChar = char
                ++repeatingCharCounter

                if (index == string.length - 1)
                    calculate(
                        index = n,
                        repeatingCharCounter = repeatingCharCounter,
                        repeatingIndex = repeatingIndex,
                        stringBuilder = stringBuilder
                    )
            }

            println("Result: $stringBuilder")
        }

        private fun calculate(index: Int, repeatingCharCounter: Int, repeatingIndex: Int, stringBuilder: StringBuilder){
            if (repeatingCharCounter == index) {
                replaceWithStar(
                    startIndex = repeatingIndex,
                    endIndex = repeatingIndex + repeatingCharCounter,
                    stringBuilder = stringBuilder
                )
            }
        }

        private fun replaceWithStar(startIndex: Int, endIndex: Int, stringBuilder: StringBuilder) {
            for (index in startIndex until endIndex)
                stringBuilder.setCharAt(index, '*')
        }
    }
}