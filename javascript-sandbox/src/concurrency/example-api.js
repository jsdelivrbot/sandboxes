export default class Api {
    constructor() {
        this.user = { id: 1, name: 'test' };
        this.friends = [ this.user, this.user, this.user ];
        this.photo = 'fake photo';
    }

    getUser() {
        return new Promise((resolve, reject) => {
            setTimeout(() => resolve(this.user), 200);
        });
    }

    getFriends(userId) {
        return new Promise((resolve, reject) => {
            setTimeout(() => resolve(this.friends.slice()), 200);
        });
    }

    getPhoto(userIdD) {
        return new Promise((resolve, reject) => {
            setTimeout(() => resolve(this.photo), 200);
        });
    }

    throwError() {
        return new Promise((resolve, reject) => {
            setTimeout(() => reject(new Error('Intentional Error')), 200);
        });
    }
}