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
