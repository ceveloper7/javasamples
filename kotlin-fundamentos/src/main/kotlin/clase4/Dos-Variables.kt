package clase4

fun main(){
    val nombre = "Antonio"
    var recibidos = 12
    var enviados = 8

    var porcentajeEnviados = (recibidos.toDouble() / (recibidos + enviados)) * 100;

    println("$nombre -  Enviados: ${porcentajeEnviados}%")
}