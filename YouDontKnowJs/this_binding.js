//debugger;

/*
New binding
*/
// function foo(a) {
// 	this.a = a;
// }

// var bar = new foo(2);
// console.log(bar.a);

/*
explicit binding takes precedence over implict binding
*/
// function foo() {
// 	console.log(this.a);
// }

// var obj1 = {
// 	a: 2,
// 	foo: foo
// }

// var obj2 = {
// 	a: 3,
// 	foo: foo
// }

// obj1.foo();
// obj2.foo();

// obj1.foo.call(obj2);
// obj2.foo.call(obj1);

/*
"hard binding" is a form of explicit binding which
returns a function with the "this" context set as specified.
Provided with ES5+ built in on Function.prototype.bind
*/
// function foo(something) {
//     console.log( this.a, something );
//     return this.a + something;
// }

// var obj = {
//     a: 2
// };

// var bar = foo.bind( obj );

// var b = bar( 3 ); // 2 3
// console.log( b ); // 5


/*
new binding takes precedence over implicit binding
*/
// function foo(something) {
// 	this.a = something;
// }

// var obj1 = {
// 	foo: foo
// };

// var obj2 = {};

// obj1.foo(2);
// console.log(obj1.a);

// obj1.foo.call(obj2, 3);
// console.log(obj2.a);

// var bar = new obj1.foo(4);
// console.log(obj1.a);
// console.log(bar.a);

/*
new binding takes precendence over hard/explicit binding
*/
// function foo(something) {
// 	this.a = something;
// }

// var obj1 = {};

// var bar = foo.bind(obj1);
// bar(2);
// console.log(obj1.a);

// var baz = new bar(3);
// console.log(obj1.a);
// console.log(baz.a);

/*
Using bind function with additional arguments after the initial 'this'
binding argument will be defaulted as standard arguments to the 
underlying function.
*/
// function foo(p1,p2) {
// 	this.val = p1 + p2;
// }

// // using `null` here because we don't care about
// // the `this` hard-binding in this scenario, and
// // it will be overridden by the `new` call anyway!
// var bar = foo.bind( null, "p1" );
// var baz = new bar( "p2" );
// console.log(baz.val); // p1p2”


/*
Softening binding - a disadvantage of hard binding is that it reduces the flexibility of a
function because it does not allow overriding "this".  We can "soften" the binding which will
still allow us to provide a default for the default binding other than "global" or "undefined"
but still also allow the function to be manually "this"-bound via implicit or explicit binding.
*/
// if (!Function.prototype.softBind) {
//     Function.prototype.softBind = function(obj) {
//         var fn = this;
//         // capture any curried parameters
//         var curried = [].slice.call( arguments, 1 );
//         var bound = function() {
//             return fn.apply(
//                 (!this ||  this === (window || global)) ?
//                   obj : this.curried.concat.apply( curried, arguments )
//             );
//         };
//         bound.prototype = Object.create( fn.prototype );
//         return bound;
//     };
// }

// function foo() {
//    console.log("name: " + this.name);
// }

// var obj = { name: "obj" },
//     obj2 = { name: "obj2" },
//     obj3 = { name: "obj3" };

// var fooOBJ = foo.softBind( obj );

// fooOBJ(); // name: obj

// obj2.foo = foo.softBind(obj);
// obj2.foo(); // name: obj2   <---- look!!!

// fooOBJ.call( obj3 ); // name: obj3   <---- look!

// setTimeout( obj2.foo, 10 ); // name: obj   <---- falls back to soft-binding” 


/*
Lexical this - arrow functions
Arrow functions adopt the "this" binding from the enclosing (function or global) scope
The lexical binding of an arrow-function can't be overridden, even
with "new".
*/
function foo() {
	//return an arrow function
	return () => {
		//'this' here is lexically inherited from 'foo()'
		console.log(this.a);
	};
}

var obj1 = {
	a: 2
};

var obj2 = {
	a: 3
};

var bar = foo.call(obj1);
bar.call(obj2);		//2, not 3!

//This is effectively shorthand for the following ES5
//technique:
function foo2() {
	var self = this;	//lexical capture of 'this'
	setTimeout(function() {
		console.log(self.a);
	}, 100);
}

var obj = {
	a: 2
};

foo2.call(obj);	//2

/*
This binding rules and order of precendence:

1. New binding takes highest precendence.  'this' is
the newly constructed object:
	var bar = new foo();
2. Explicit binding using 'call' or 'apply' functions
(including 'bind' which uses 'apply' internally). 'this'
is set to the first argument of the 'call' or 'apply' function
call.
	var bar = foo.call(obj2);
3. Implicit binding - when function is called with a context e.g.
an owning or containing object.
	var bar = obj1.foo();
4. Default binding - if in 'strict' mode, 'this' = undefined, otherwise
it is the 'global' object.
	var bar = foo();
*/



