import React from 'react';
import PureRenderMixin from 'react-addons-pure-render-mixin';
import {connect} from 'react-redux';
import Winner from './Winner';
import Vote from './Vote';
import * as actionCreators from '../action_creators';

//Voting is the "dumb" or "pure" component, fully driven by the props it is given.
export const Voting = React.createClass({
  mixins: [PureRenderMixin],
  render: function () {
    return <div>
      {this.props.winner ? 
        <Winner ref="winner" winner={this.props.winner} /> :
        <Vote {...this.props} />
      }
    </div>;
  }
});

function mapStateToProps(state) {
  return {
    pair: state.getIn(['vote', 'pair']),
    hasVoted: state.get('hasVoted'),
    winner: state.get('winner')
  };
}

connect(mapStateToProps)(Voting);

//VotingContainer is the "smart" or "connected" component, wrapping the pure component with logic that will keep
//it in sync with the changing state of the Redux store
export const VotingContainer = connect(
  mapStateToProps,
  actionCreators
)(Voting);