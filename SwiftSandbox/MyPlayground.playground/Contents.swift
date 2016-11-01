// PrimeChecker.Swift
// Created by Stephen Coyle on 02/04/2016.
// Copyright Â© 2016 Stephen Coyle. All rights reserved.
//

import Foundation

func primeRun() {

    let time1 = CFAbsoluteTimeGetCurrent()
    var numberOfPrimes = 0
    let range = 100000

    for index in 2...range {
        if isPrime(index) == true {
            numberOfPrimes += 1
        }
    }

    let time2 = CFAbsoluteTimeGetCurrent()

    let timeDiff = time2-time1

    print("Calculation took",timeDiff,"seconds. There are",numberOfPrimes,"primes between 0 and",range)

}

func isPrime(number: Int) -> Bool {


    for factor in 2..<number {
        if number % factor == 0 {
            return false
        }
    }
    return true
}

//import Darwin

//func isPrime(number: Int) -> Bool {
//    var prime = true
//    for factor in 2..<Int(sqrt(Double(number)) + 1) { // end index must be ≤ than 2, my bad
//        if number % factor == 0 {
//            prime = false
//        }
//    }
//    return prime
//}

primeRun()
