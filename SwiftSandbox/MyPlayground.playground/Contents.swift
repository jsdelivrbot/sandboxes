//: Playground - noun: a place where people can play

import UIKit

var str = "Hello, playground";
var test = 3;

func test (param1 : Int) -> Bool
{
    if (param1 > 0) {
        return true;
    }
    return false;
}

test(-5);


class dustin {
    var name: String = "";
    var age: Int;

    init(age: Int) {
        self.age = age;
    }
}

var instance = dustin(age: 5);
instance.age;

var myDictionary:[Int:String] = [1:"One", 2:"Two", 3:"Three"];
myDictionary;
myDictionary.count;
let sortedDictionary = myDictionary.sort { $0.0 < $1.0 }
sortedDictionary;
print("\(sortedDictionary)")