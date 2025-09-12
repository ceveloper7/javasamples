package clase4

fun main(){
    // creacion de variables: 1era forma. val hace que la variable sea inmutable
    val nombreUsuario = "Pedro"

    // creacion de variables: 2da forma. var permite que a la variable se le reasigne un nuevo valor.
    var nomUser = "Alberto"

    var emailNoLeidos = 5

    println("Usuario: $nombreUsuario, Emails: $emailNoLeidos")

    // de forma explicita indicamos el tipo de dato
    var totalEmail: Int
    // asignamos un valor
    totalEmail = 34

    // variables de punto flotante
    var totalOrder: Float = 119.85f
    // usando inferencia de tipos
    var porcentaje = 32.80
    var asunto: String = "Reunion"

    // boolean
    val isUrgent: Boolean = true

    // operaciones artimeticas
    val a = 20
    val b = 7

    val sum = a + b
    val difference = a - b
    val product = a * b
    val quotient = a.toDouble() / b // usamos el metoso toDouble() para obtener la parte fraccionaria
    val remainder = a % b

    println("La division entre $a y $b es $quotient")
    println("El residuo entre $a y $b es $remainder")

    // conversion de tipos
    val numero = 55
    val numStr: String = numero.toString()

    val numInt: Int = numStr.toInt();

    println("numero str: $numStr")
    println("numero int: $numInt")


}