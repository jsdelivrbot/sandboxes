import React, { Component } from 'react';

export default class CommentList extends Component {

  constructor(props) {
    super(props);

    this.state = { comment: ''};
  }

  render() {
    return <ul className="comment-list"></ul>;
  }
}