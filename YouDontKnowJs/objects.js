/*
The six primary types (language types):
	string - immutable.  Modification requires use of "String" object (JS will coerce automatically)
	number
	boolean
	null
	undefined
	object
The first five are NOT objects.
*/

/*
There are a few special object subtypes:
	function - subtype of object (a "callable object"), these are objects
		with callable behavior semantics bolted on.
	arrays - subtype of object with extra behavior, organization of
		content in arrays is slightly more structured than standard
		objects
*/

var constructedString = new String("mahString");
console.log(Object.prototype.toString.call(constructedString));	//[object String]

//Objects are collections of key value pairs.  The values are accessed as properties, via the .propName or 
//["propName"] syntax.  Whenever these are accessed, the JS engine will invoke an internal default [[Get]] or
//[[Put]] operation which will look for the property on the object as well as traverse its prototype chain.

//Object properties have attributes (called "descriptors") such as "writable" and "configurable".  Also, objects
//can have their write behavior/mutability behavior controlled by functions like Object.preventExtensions(), Object.seal,
//Object.freeze(), etc.

//Properties can be optionally enumerable.  If a property is enumerable, it can be accessed via an iterator that
//loops over the properties of an object.  Properties that are not enumerable will not be iterated over in
//a loop (such as a "for..in" loop).

//Do not use "for..in" to iterate over arrays as this will also iterate over any properties defined on the array
//along with the indices in the array, which is almost always not the intended behavior and likely to cause bugs.
//Use "for..in" with objects only.
