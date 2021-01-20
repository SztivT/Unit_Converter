package converter

import java.util.*
import kotlin.system.exitProcess

enum class Distances(val shortForm: String, val plural: String, val ratio: Double) {
    METER("m", "meters", 1.0),
    KILOMETER("km", "kilometers", 1000.0),
    CENTIMETER("cm", "centimeters", 0.01),
    MILLIMETER("mm", "millimeters", 0.001),
    MILE("mi", "miles", 1609.344),
    YARD("yd", "yards", 0.9144),
    FOOT("ft", "feet", 0.3048),
    INCH("in", "inches", 0.0254);

    companion object {
        fun isMember(unit: String): Boolean {
            for (enum in values()) {
                if (unit.equals(
                        enum.name,
                        ignoreCase = true
                    ) || unit.toLowerCase() == enum.shortForm || unit.toLowerCase() == enum.plural
                ) {
                    return true
                }
            }
            return false
        }

        private fun getRatio(unit: String): Double {
            for (enum in values()) {
                if (enum.name.toLowerCase() == unit) {
                    return enum.ratio
                }
            }
            return 0.0
        }

        fun convert(from: String, to: String, value: Double) {
            val fromUnit = getUnit(from, value)
            val fromRatio = getRatio(getUnit(from, 1.0))
            val toRatio = getRatio(getUnit(to, 1.0))
            val calculated = value * fromRatio / toRatio
            println(" $value $fromUnit is $calculated ${getUnit(to, calculated)}")
        }
    }
}

enum class Weight(val shortForm: String, val plural: String, val ratio: Double) {
    GRAM("g", "grams", 1.0),
    KILOGRAM("kg", "kilograms", 1000.0),
    MILLIGRAM("mg", "milligrams", 0.001),
    POUND("lb", "pounds", 453.592),
    OUNCE("oz", "ounces", 28.3495);

    companion object {
        fun isMember(unit: String): Boolean {
            for (enum in values()) {
                if (unit.equals(
                        enum.name,
                        ignoreCase = true
                    ) || unit.toLowerCase() == enum.shortForm || unit.toLowerCase() == enum.plural
                ) {
                    return true
                }
            }
            return false
        }

        private fun getRatio(unit: String): Double {
            for (enum in values()) {
                if (enum.name.toLowerCase() == unit) {
                    return enum.ratio
                }
            }
            return 0.0
        }

        fun convert(from: String, to: String, value: Double) {
            val fromUnit = getUnit(from, value)
            val fromRatio = getRatio(getUnit(from, 1.0))
            val toRatio = getRatio(getUnit(to, 1.0))
            val calculated = value * fromRatio / toRatio
            println(" $value $fromUnit is $calculated ${getUnit(to, calculated)}")
        }
    }


}

enum class Temperature(
    val shortForm: String,
    val plural: String,
    val degreeShort: String,
    val degreeName: String,
    val degreePlural: String,
    val ratio: Double,
    val constants: Double
) {
    CELSIUS("c", "celsius", "dc", "degree Celsius", "degrees Celsius", 1.0, 0.0),
    FAHRENHEIT("f", "fahrenheit", "df", "degree Fahrenheit", "degrees Fahrenheit", (5.0 / 9.0), 32.0),
    KELVIN("k", "kelvins", "k", "kelvin", "kelvins", 1.0, 273.15);

    companion object {
        fun isMember(unit: String): Boolean {
            for (enum in values()) {
                if (unit.equals(enum.name, ignoreCase = true) || unit.toLowerCase() == enum.shortForm
                    || unit.toLowerCase() == enum.plural || unit.toLowerCase() == enum.degreeShort
                    || unit.equals(enum.degreeName, ignoreCase = true) || unit.equals(
                        enum.degreePlural,
                        ignoreCase = true
                    )
                ) {
                    return true
                }
            }
            return false
        }

        private fun getRatio(unit: String): Double {
            for (enum in values()) {
                if (unit.equals(enum.name, ignoreCase = true) || unit.toLowerCase() == enum.shortForm
                    || unit.toLowerCase() == enum.plural || unit.toLowerCase() == enum.degreeShort
                    || unit.equals(enum.degreeName, ignoreCase = true) || unit.equals(
                        enum.degreePlural,
                        ignoreCase = true
                    )
                ) {
                    return enum.ratio
                }

            }
            return 0.0
        }

        private fun getConst(unit: String): Double {
            for (enum in values()) {
                if (unit.equals(enum.name, ignoreCase = true) || unit.toLowerCase() == enum.shortForm
                    || unit.toLowerCase() == enum.plural || unit.toLowerCase() == enum.degreeShort
                    || unit.equals(enum.degreeName, ignoreCase = true) || unit.equals(
                        enum.degreePlural,
                        ignoreCase = true
                    )
                ) {
                    return enum.constants
                }
            }
            return 0.0
        }

        fun convert(from: String, to: String, value: Double) {
            val fromUnit = getUnit(from, value)
            val fromRatio = getRatio(fromUnit)
            val fromConst = getConst(fromUnit)
            val toRatio = getRatio(getUnit(to, 1.0))
            val toConst = getConst(to)
            val calculated = ((value - fromConst) * fromRatio) / toRatio + toConst
            println(" $value $fromUnit is $calculated ${getUnit(to, calculated)}")
        }
    }

}

val scanner = Scanner(System.`in`)

fun main() {
    print("Enter what you want to convert (or exit):")
    val input = scanner.nextLine()
    if (input == "exit") {
        exitProcess(0)
    } else {
        converter(input)
    }
    main()
}
fun parseError(input: Array<String>): Boolean {
    if (input.size !in 4..6){
        return true
    }
    if (input[0].toDoubleOrNull() == null) {
        return true
    }
    return false
}

fun getUnit(input: String, value: Double): String {
    for (enum in Distances.values()) {
        if (input.toUpperCase() == enum.name || input.toLowerCase() == enum.shortForm || input
                .toLowerCase() == enum.plural
        ) {
            return if (value == 1.0) {
                enum.name.toLowerCase()
            } else {
                enum.plural
            }
        }
    }
    for (enum in Weight.values()) {
        if (input.toUpperCase() == enum.name || input.toLowerCase() == enum.shortForm || input
                .toLowerCase() == enum.plural
        ) {
            return if (value == 1.0) {
                enum.name.toLowerCase()
            } else {
                enum.plural
            }
        }
    }
    for (enum in Temperature.values()) {
        if (input.toUpperCase() == enum.name || input.toLowerCase() == enum.shortForm || input
                .toLowerCase() == enum.plural || input.toLowerCase() == enum.degreeShort ||
            input.toLowerCase() == enum.degreeName || input.toLowerCase() == enum.degreePlural
        ) {
            return if (value == 1.0) {
                enum.degreeName
            } else {
                enum.degreePlural
            }
        }
    }
    return "???"

}

fun converter(input: String) {
    val inputArgs = input.split(" ").toTypedArray()
    var fromUnitInput = inputArgs[1].toLowerCase()
    var offset = 0
    if (fromUnitInput == "degree" || fromUnitInput == "degrees") {
        fromUnitInput = inputArgs[2].toLowerCase()
        offset++
    }
    var toUnitInput = inputArgs[3 + offset].toLowerCase()
    if (toUnitInput == "degree" || toUnitInput == "degrees") {
        toUnitInput = inputArgs[4 + offset].toLowerCase()
    }
    val fromUnit = getUnit(fromUnitInput, 1.0)
    val fromIsDistance = Distances.isMember(getUnit(fromUnitInput, 1.0))
    val fromIsWeight = Weight.isMember(getUnit(fromUnitInput, 1.0))
    val fromIsTemperature = Temperature.isMember(fromUnit)
    val toIsDistance = Distances.isMember(getUnit(toUnitInput, 1.0))
    val toIsWeight = Weight.isMember(getUnit(toUnitInput, 1.0))
    val toIsTemperature = Temperature.isMember(getUnit(toUnitInput, 1.0))
    when {
        parseError(inputArgs) -> println("Parse error")
        inputArgs[0].toDouble() < 0.0 && Distances.isMember(getUnit(fromUnitInput, 1.0))
        -> println(" Length shouldn't be negative")
        inputArgs[0].toDouble() < 0.0 && Weight.isMember(getUnit(fromUnitInput, 1.0)) ->
            println(" Weight shouldn't be negative")
        fromIsDistance && toIsDistance -> Distances.convert(fromUnitInput, toUnitInput, inputArgs[0].toDouble())
        fromIsWeight && toIsWeight -> Weight.convert(fromUnitInput, toUnitInput, inputArgs[0].toDouble())
        fromIsTemperature && toIsTemperature -> Temperature.convert(fromUnitInput, toUnitInput, inputArgs[0].toDouble())
        else ->
            println(" Conversion from ${getUnit(fromUnitInput, 0.0)} to ${getUnit(toUnitInput, 0.0)} is impossible")
    }
}