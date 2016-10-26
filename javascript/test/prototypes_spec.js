import {expect} from 'chai';

describe('prototype tests', () => {

  it('Object.create()', () => {
    var propertyDescriptors = {a: {value:1},  b: {value:2}};
    var proto = {b: 3, c: 4};

    //First arg = prototype of new object.  Second arg: properties of new object.  Need to be "property descriptors", hence the map of maps.
    //See https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Object/create
    var o = Object.create(proto, propertyDescriptors);

    proto.d = 5;
    //o.prototype.d = "d";

    String.prototype.myNewMethod = function () { console.log("myNewMethod called!");}

    console.log(o.a);
    console.log(o.b);
    console.log(o.c);
    console.log(o.d);

    var myString = "test";
    myString.myNewMethod();
  });
});
