export class Point {
        constructor(private x?: number, private y?: number) {
    
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
    
        getDistance(another: Point) {
    
        }
}