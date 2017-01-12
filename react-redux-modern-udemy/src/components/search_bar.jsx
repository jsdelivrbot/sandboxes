import React, { Component } from 'react';

class SearchBar extends Component {
  constructor(props) {
    super(props);

    this.state = { term: 'Starting value' };
  }

  render() {
    console.log("RENDER");


    return (
      <div>
        <input
          value={this.state.term}   //this setting of input's value turns the component into a "controlled component"
          onChange={event => this.setState({ term: event.target.value })} />
      </div>
    );
  }

  componentWillReceiveProps(nextProps) {
    console.log("componentWillReceiveProps called with nextProps: ");
    console.log(nextProps);
  }

  shouldComponentUpdate(nextProps, nextState) {
    console.log("shouldComponentUpdate called with nextProps: ");
    console.log(nextProps);
    console.log(" shouldComponentUpdate and nextState: ");
    console.log(nextState);
    return true;  //if false, component will not get re-rendered ever
  }

  componentWillUpdate(nextProps, nextState) {
    console.log("componentWillUpdate called with nextProps: ");
    console.log(nextProps);
    console.log(" componentWillUpdate and nextState: ");
    console.log(nextState);
  }

  componentDidUpdate(prevProps, prevState) {
    console.log("componentDidUpdate called with prevProps: ");
    console.log(prevProps);
    console.log(" componentDidUpdate and prevState: ");
    console.log(prevState);
  }


  // //Event handler function
  // onInputChange(event) {
  //   console.log(event);
  // }
}

export default SearchBar;