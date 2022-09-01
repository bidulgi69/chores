package src

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.pow

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val cases = readLine().toInt()
    val bw = System.out.bufferedWriter()

    repeat(cases) {
        var cnt = 0
        val (x1, y1, x2, y2) = readLine()
            .split(" ")
            .map { value -> value.toDouble() }

        val numOfPlanets = readLine().toInt()
        repeat(numOfPlanets) {
            val planet = Circle(
                readLine()
                    .split(" ")
                    .map { value -> value.toDouble() }
            )
            //  시작점과의 거리를 계산
            var doesStartInsideOfPlanet = false
            val distanceFromStart = (x1 - planet.x).pow(2.0) + (y1 - planet.y).pow(2.0)
            if (distanceFromStart < planet.r.pow(2.0)) doesStartInsideOfPlanet = true

            //  도착점과의 거리를 계산
            var doesTargetInsideOfPlanet = false
            val distanceFromTarget = (x2 - planet.x).pow(2.0) + (y2 - planet.y).pow(2.0)
            if (distanceFromTarget < planet.r.pow(2.0)) doesTargetInsideOfPlanet = true

            if (doesStartInsideOfPlanet || doesTargetInsideOfPlanet) {
                if (doesStartInsideOfPlanet && doesTargetInsideOfPlanet) {
                    //  do nothing
                } else {
                    cnt++
                }
            }
        }
        bw.write("$cnt\n")
    }

    bw.flush()
    bw.close()
}

data class Circle(
    val x: Double,
    val y: Double,
    val r: Double,
) {
    constructor(values: List<Double>): this(values[0], values[1], values[2])
}