import axios from 'axios';
import { API_KEY }  from '../config';

export const FETCH_WEATHER = 'FETCH_WEATHER';
const ROOT_URL = `http://api.openweathermap.org/data/2.5/forecast?appid=${API_KEY}`;

export function fetchWeather(cityName) {
  const url = `${ROOT_URL}&q=${cityName},us`;
  const request = axios.get(url);

  return {
    type: FETCH_WEATHER,
    // return the axios promise as the payload.  Before this is sent to the reducer, the redux-promise
    // middleware will wait until the promise is resolved, then will dispatch a new action with the same type
    // containing the data as the payload, which is then sent to the reducer.  The reducer should see just the one
    // action with the response data, not the promise itself.
    payload: request
  };
}