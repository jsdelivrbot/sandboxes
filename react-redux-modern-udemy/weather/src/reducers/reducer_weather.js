import { FETCH_WEATHER } from '../actions';

export default function(state = [], action) {
  switch (action.type) {
    case FETCH_WEATHER:
      //concat() merges two (or more) arrays and returns a new array
      //return state.concat([action.payload.data]);

      // The spread operator in this example is effectively the same as the concat operation above, we
      // expect action.payload.data to contain a single city's weather data that is appended to the front
      // of the existing array of cities, and this is returned as a new array.
      return [ action.payload.data, ...state ];
    default:
      return state;
  }
}