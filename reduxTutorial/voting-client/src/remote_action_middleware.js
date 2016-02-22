export default socket => store => next => action => {
  if (action.meta && action.meta.remote) {
    console.log('in middleware, emitting action to websocket: ', action);
    socket.emit('action', action);
  }
  return next(action);
}

/*
The above is a more concise way of writing this (which is an example of function currying):

export default function(socket) {
  return function(store) {
    return function(next) {
      return function(action) {
    
      }
    }
  }
}
*/