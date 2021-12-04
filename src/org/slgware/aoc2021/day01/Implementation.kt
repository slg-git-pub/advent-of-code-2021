package org.slgware.aoc2021.day01

import org.slgware.aoc2021.readIntegers

fun main()
{
    fun part1( input: Sequence<Int> ): Int
    {
        var accumulator = 0
        var previous = Int.MAX_VALUE
        input.forEach { n ->
            if ( previous == Int.MAX_VALUE ) { /* no-op */ }
            else if ( n > previous ) { ++accumulator }
            previous = n
        }
        return accumulator
    }

    fun triplets( raw: List<Int> ): List<Int>
    {
        val result = mutableListOf<Int>()
        var index = 0
        while ( index + 2 <= raw.lastIndex )
        {
            result.add (raw[index] + raw[index+1] + raw[index+2] )
            ++index
        }
        return result
    }

    fun part2( input: List<Int> ): Int
    {
        return part1( triplets( input ).asSequence() )
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readIntegers( "day01/test_input" )
    check( part1( testInput.asSequence() ) == 7 )
    check( part2( testInput ) == 5 )

    val input = readIntegers( "day01/input" )
    println( part1( input.asSequence() ) )
    println( part2( input ) )
}
