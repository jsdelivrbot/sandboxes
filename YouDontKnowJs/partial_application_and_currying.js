
/*
Super simple partial function application example
*/
// function fun1(arg1, arg2, arg3) {
// 	return arg1 + arg2 + arg3;
// }

// function fun2(arg2, arg3) {
// 	return fun1(1, arg2, arg3);
// }
// var result = fun2(2, 3);
// console.log(result);

/*
More complex partial function application example
*/
function partial(fn /*, arguments*/) {
	// A reference to the Array#slice method.  Note that arguments is an array-like object, but not an array,
	//so it does not have the slice method on it.
	var slice = Array.prototype.slice;
	// Convert arguments object to an array, removing the first argument.
	var args = slice.call(arguments, 1);

	return function() {
		return fn.apply(this, args.concat(slice.call(arguments, 0)));
	};
}

function addAllTheThings() {
	var sum = 0;
	for (var i = 0; i < arguments.length; i++) {
		sum += arguments[i];
	}
	return sum;
}

console.log(addAllTheThings(1, 2));			//3
console.log(addAllTheThings(1, 2, 3, 4));	//10

var addOne = partial(addAllTheThings, 1);
console.log(addOne(2));						//3
console.log(addOne(3, 4));					//8

var addTen = partial(addAllTheThings, 10);
console.log(addTen(5));						//15

/*
Currying example
*/
function curry(fn, n) {
	//If 'n' argument was omitted, use the function.length property
	if (typeof n !== 'number') {
		n = fn.length;
	}

	function getCurriedFn(prev) {
		return function(arg) {
			//Concat the just-specified argument with the array of
			//previously-specified arguments.
			var args = prev.concat(arg);
			if (args.length < n) {
				//Not all arguments have been satisfied yet, so return
				//a curried version of the original function.
				return getCurriedFn(args);
			} else {
				//Otherwise, invoke the original function with the arguments
				//and return its value.
				return fn.apply(this, args);
			}
		};
	}

	//Return a curried function of the original function.
	return getCurriedFn([]);
}

function curryTest() {
	var i = 0;
	function a(arg1, arg2, arg3) {
		return ++i + ': ' + arg1 + ', ' + arg2 + ', ' + arg3;
	}

	//Normal function invocation

	console.log(a('x', 'y', 'z'));	//"1: x, y, z"
	console.log(a('x', 'y'));		//"2: x, y, undefined"
	console.log(a('x'));				//"3: x, undefined, undefined"
	console.log(a());				//"4: undefined, undefined, undefined"

	//Curried function invocation

	var b = curry(a);
	console.log(b());				//'a' not invoked, curried function returned
	console.log(b('x'));				//'a' not invoked, curried function returned
	console.log(b('x')('y'));		//'a' not invoked, curried function returned
	console.log(b('x')('y')('z'));	//"5: x, y, z"
	console.log(b('x')('y')());		//"6: x, y, undefined"
	console.log(b('x')()());			//"7: x, undefined, undefined"
	console.log(b()('y')());			//"8: undefined, y, undefined"
	console.log(b()()('z'));			//"9: undefined, undefined, z"
	console.log(b()()());			//"10: undefined, undefined, undefined"

	var c = b('x');
	console.log(c());				//'a' not invoked, curried function returned
	console.log(c('y'));			//'a' not invoked, curried function returned
	console.log(c('y')('z'));		//"11: x, y, z"
	console.log(c('y')());			//"12: x, y, undefined"
	console.log(c()('z'));			//"13: x, undefined, z"
	console.log(c()());				//"14: x, undefined, undefined"

	var d = c('y');
	console.log(d('z'));			//"15: x, y, z"
	console.log(d());				//"16: x, y, undefined"

	var e = d('z');
	console.log(e);					//"17: x, y, z"
}

curryTest();

