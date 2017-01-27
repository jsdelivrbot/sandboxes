import React, { Component } from 'react';

class SearchBar extends Component {
  constructor(props) {
    super(props);

    this.state = { term: '' };
  }

  render() {
    console.log("RENDER");


    return (
      <div className="search-bar col-md-12">
        <input
          value={this.state.term}   //this setting of input's value turns the component into a "controlled component"
          onChange={event => this.onInputChange(event.target.value)} />
      </div>
    );
  }

  onInputChange(term) {
    this.setState({term});
    this.props.onSearchTermChange(term);
  }

  static componentWillReceiveProps(nextProps) {
    console.log("componentWillReceiveProps called with nextProps: ");
    console.log(nextProps);
  }

  static shouldComponentUpdate(nextProps, nextState) {
    console.log("shouldComponentUpdate called with nextProps: ");
    console.log(nextProps);
    console.log(" shouldComponentUpdate and nextState: ");
    console.log(nextState);
    return true;  //if false, component will not get re-rendered ever
  }

  static componentWillUpdate(nextProps, nextState) {
    console.log("componentWillUpdate called with nextProps: ");
    console.log(nextProps);
    console.log(" componentWillUpdate and nextState: ");
    console.log(nextState);
  }

  static componentDidUpdate(prevProps, prevState) {
    console.log("componentDidUpdate called with prevProps: ");
    console.log(prevProps);
    console.log(" componentDidUpdate and prevState: ");
    console.log(prevState);
  }
}

SearchBar.propTypes = {
  onSearchTermChange: React.PropTypes.func
};

export default SearchBar;