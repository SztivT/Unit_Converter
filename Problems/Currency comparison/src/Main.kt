import java.util.*

enum class Countries(val currency: String) {
    GERMANY("Euro"),
    MALI("CFA franc"),
    DOMINICA("Eastern Caribbean dollar"),
    CANADA("Canadian dollar"),
    SPAIN("Euro"),
    AUSTRALIA("Australian dollar"),
    BRAZIL("Brazilian real"),
    SENEGAL("CFA franc"),
    FRANCE("Euro"),
    GRENADA("Eastern Caribbean dollar"),
    KIRIBATI("Australian dollar");

    companion object {
        fun getCurrency(country: String): String {
            for (enum in values()) {
                if (enum.name == country.toUpperCase()) {
                    return enum.currency
                }
            }
            return ""
        }
    }
}

fun main(args: Array<String>) {
    // put your code here
    val scanner = Scanner(System.`in`)
    val a = Countries.getCurrency(scanner.next())
    val b = Countries.getCurrency(scanner.next())
    print(a == b)
}

