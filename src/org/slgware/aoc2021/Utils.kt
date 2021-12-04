package org.slgware.aoc2021

import java.io.File
import java.math.BigInteger
import java.security.MessageDigest

/**
 * Reads lines from the given input text file.
 */
fun readInput( name: String ) = File( "src/org/slgware/aoc2021", "$name.text" ).readLines()

/**
 * Reads lines from the given input text file.
 */
fun readIntegers( name: String ) = readInput( name ).map( String::toInt )

/**
 * Converts string to md5 hash.
 */
fun String.md5(): String =
    BigInteger(1, MessageDigest.getInstance( "MD5" ).digest( toByteArray() ) )
        .toString( 16 )
