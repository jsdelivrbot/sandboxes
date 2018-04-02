let drawPoint = (point) => {
    point.x;
};
class Point {
    constructor(x, y) {
        this.x = x;
        this.y = y;
    }
    get X() {
        return this.x;
    }
    set X(value) {
        if (value < 0) {
            throw new Error('value cannot be less than 0');
        }
        this.x = value;
    }
    draw() {
        console.log('x:' + this.x);
        console.log('y:' + this.y);
    }
    getDistance(another) {
    }
}
let point = new Point(1, 2);
point.X = 5;
point.draw();
