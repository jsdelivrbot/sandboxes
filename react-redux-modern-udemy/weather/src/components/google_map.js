import React, { Component } from 'react';

class GoogleMap extends Component {

  componentDidMount() {
    //Google's Map API takes the following parameters:
    //1 - HTML element where map will be rendered (this.refs.map points to our div ref map below)
    //2 - Object containing a set of options to configure the map
    new google.maps.Map(this.refs.map, {
      zoom: 12,
      center: {
        lat: this.props.lat,
        lng: this.props.lon
      }
    });
  }

  render() {
    // this.refs.map can now be used to reference this component
    //WARNING: this is no longer the recommended approach.  See https://facebook.github.io/react/docs/refs-and-the-dom.html
    //for more details.  HINT: Use callback functions instead
    return <div ref="map" />
  }
}

export default GoogleMap;