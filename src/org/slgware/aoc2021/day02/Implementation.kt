package org.slgware.aoc2021.day01

import org.slgware.aoc2021.readInput
import org.slgware.aoc2021.readIntegers

enum class Action { forward, down, up }
data class Motion( val action: Action, val magnitude: Int )

fun main()
{
    fun motions( input: List<String> ): Sequence<Motion>
    {
        return input.map { s -> s.toMotion() }.asSequence()
    }

    fun part1( input: Sequence<Motion> ): Int
    {
        var horizontal = 0
        var depth = 0
        input.forEach { motion ->
            when ( motion.action )
            {
                Action.forward -> horizontal += motion.magnitude
                Action.down -> depth += motion.magnitude
                Action.up -> depth -= motion.magnitude
            }
        }
        return horizontal * depth
    }

    fun part2( input: Sequence<Motion> ): Int
    {
        var horizontal = 0
        var depth = 0
        var aim = 0
        input.forEach { motion ->
            when ( motion.action )
            {
                Action.forward ->
                {
                    horizontal += motion.magnitude
                    depth += aim * motion.magnitude
                }
                Action.down -> aim += motion.magnitude
                Action.up -> aim -= motion.magnitude
            }
        }
        return horizontal * depth
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput( "day02/test_input" )
    check( part1( motions( testInput ) ) == 150 )
    check( part2( motions( testInput ) ) == 900 )

    val input = readInput( "day02/input" )
    println( part1( motions( input ) ) )
    println( part2( motions( input ) ) )
}

fun String.toMotion(): Motion
{
    val (action, magnitude) = split( " ", ignoreCase = false, limit = 2 )
    return Motion( Action.valueOf( action ), magnitude.toInt() )
}