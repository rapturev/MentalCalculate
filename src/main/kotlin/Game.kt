import kotlin.random.Random

// Entry point to the game
fun main() {
    println("hello, user. this is your mental calculating trainer")
    val itemBuilder = ItemBuilder()
    itemBuilder.chooseDifficulty()
    itemBuilder.build()
}

// This enum represents three difficulty levels of mental calculate trainings
enum class DifficultyMode {
    EASY, MEDIUM, HARD
}

// ItemBuilder is a part of the program that generates "items" - single math exercises
class ItemBuilder {
    private lateinit var difficultyMode: DifficultyMode
    private var firstValue: Int = 0
    private var secondValue: Int = 0
    private lateinit var operation: String
    private var resultValue: Int = 0

    // This function generates math operator that single exercise ("item") will include
    fun generateOperation(): Unit {
        val opCode = Random.nextInt(0, 4)
        when (opCode) {
            0 -> {
                operation = "+"
                resultValue = firstValue + secondValue
            }
            1 -> {
                    if (firstValue > secondValue) {
                        operation = "-"
                        resultValue = firstValue - secondValue
                    } else {
                        generateOperation()
                    }
            }
            2 -> {
                operation = "*"
                resultValue = firstValue * secondValue
            }
            3 -> {
                if (firstValue % secondValue == 0) {
                    operation = "/"
                    resultValue = firstValue / secondValue
                } else {
                    generateOperation()
                }
            }
        }
    }

    // This function generate numbers of the math exercise by randomizer
    fun build(): Unit {
        when (difficultyMode) {
            DifficultyMode.EASY -> {
                firstValue = Random.nextInt(1, 10)
                secondValue = Random.nextInt(1, 10)
            }
            DifficultyMode.MEDIUM -> {
                firstValue = Random.nextInt(1, 100)
                secondValue = Random.nextInt(1, 100)
            }
            DifficultyMode.HARD -> {
                firstValue = Random.nextInt(1, 1000)
                secondValue = Random.nextInt(1, 1000)
            }
        }
        generateOperation()
        val item: Item = Item(firstValue, secondValue, operation, resultValue)
        val answer = readLine()
        if (answer == item.resultValue.toString()) {
            println("right")
            build()
        } else {
            println("wrong")
            build()
        }
    }
    // This function handles a user input and choose a difficulty mode of the game
    fun chooseDifficulty(): Unit {
        println("please choose a difficulty level by enter a number: 1, 2 or 3")
        val difficultyLevel = readLine()
        when (difficultyLevel) {
            "1" -> difficultyMode = DifficultyMode.EASY
            "2" -> difficultyMode = DifficultyMode.MEDIUM
            "3" -> difficultyMode = DifficultyMode.HARD
            else -> chooseDifficulty()
        }
    }
}

// "Item" is a single math exercise in this mental calculate trainer
class Item (val firstValue: Int, val secondValue: Int, val operation: String, val resultValue: Int) {
    init {
        println("$firstValue $operation $secondValue")
    }
}


